# Networking

low-level APIs such as the Transport
Layer, which facilitates custom network protocols, and high-level APIs such as Unity Netgame for GameObjects (NGO), Mirror, or Photon, which simplify the creation of complex networked games.

using Unity.Netcode;
using UnityEngine;
using Unity.Collections;
using System.Text;

public class NetworkManagerExample : MonoBehaviour
{
    void Start()
    {
        // Start as server or client
        if (NetworkManager.Singleton.IsServer)
        {
            NetworkManager.Singleton.StartServer();
        }
        else
        {
            NetworkManager.Singleton.StartClient();
        }
    }

    // Send a message to the server
    public void SendMessageToServer()
    {
        if (NetworkManager.Singleton.IsClient)
        {
            var buffer = Encoding.UTF8.GetBytes("Hello Server!");
            using (var writer = new FastBufferWriter(buffer.Length, Allocator.Temp))
            {
                writer.WriteBytes(buffer);
                NetworkManager.Singleton.CustomMessagingManager.SendNamedMessage(
                    "ReceiveMessage",
                    NetworkManager.Singleton.ServerClientId,
                    writer
                );
            }
        }
    }

    // Receive a message from a client
    public void OnEnable()
    {
        NetworkManager.Singleton.CustomMessagingManager.RegisterNamedMessageHandler(
            "ReceiveMessage",
            (senderClientId, reader) =>
            {
                var buffer = new byte[reader.Length];
                reader.ReadBytes(buffer, reader.Length);
                string message = Encoding.UTF8.GetString(buffer);
                Debug.Log("Received message: " + message);
            }
        );
    }
}

### Remote Procedure Calls (RPCs)

// Command function called by the client but executed on the server
[Command]
void CmdFire()
{
    // Instantiate projectile
    GameObject projectile = Instantiate(projectilePrefab, position, rotation);

    // Spawn the projectile on the network
    NetworkServer.Spawn(projectile);

    // Trigger some behavior on all clients
    RpcShowFireEffects();
}

// RPC function to update clients
[ClientRpc]
void RpcShowFireEffects()
{
    // Show effects here
    Instantiate(fireEffect, transform.position, Quaternion.identity);
}

 peer-to-peer architectures can
struggle with issues such as Network Address Translation (NAT) traversal (the process of
establishing and maintaining connections through routers that use NAT), and synchronizing
game state across all clients can be more challenging without a central authority.

### Lobbies

Room creation.

// Using Mirror for room creation
public void CreateRoom(string roomName) {
  NetworkManager.singleton.StartHost(); // Start a host instance
  NetworkRoomManager.roomName = roomName; // Set the room name
}

Room listing and joining.

// Pseudocode for listing and joining rooms using Photon
void ListRooms() {
  var rooms = PhotonNetwork.GetRoomList(); // Get list of rooms
  
  foreach(var room in rooms) {
    UI.AddRoomToList(room.name, room.playerCount); // Update UI with room details
  }
}

public void JoinRoom(string roomName) {
  PhotonNetwork.JoinRoom(roomName); // Join a specific room
}

Managing player readiness.

// Using Mirror to handle player readiness
[Command]
public void CmdSetReady(bool isReady) {
  this.isReady = isReady; // Set player readiness
  RpcUpdateReadyStatus(this.isReady); // Notify all clients
}

[ClientRpc]
void RpcUpdateReadyStatus(bool isReady) {
  UI.UpdatePlayerReadiness(playerId, isReady); // Update UI on all clients
}

### Networked Variables

using Unity.Netcode;

public class PlayerHealth : NetworkBehaviour
{
    public NetworkVariable<int> health = new NetworkVariable<int>(
        100,
        NetworkVariableReadPermission.Everyone,
        NetworkVariableWritePermission.Server
    );

    [ServerRpc]
    public void TakeDamageServerRpc(int damage)
    {
        health.Value -= damage;
    }
}

### RPCs

using Unity.Netcode;

public class GameActions : NetworkBehaviour
{
    [ServerRpc]
    public void FireProjectileServerRpc()
    {
        PerformFire();              // server-side logic (e.g., spawn, state)
        FireProjectileClientRpc();  // tell clients to run their visuals
    }

    [ClientRpc]
    private void FireProjectileClientRpc()
    {
        // This runs on all clients (including host's client)
        // Avoid double execution on the host since the server already ran PerformFire()
        if (!IsServer)
        {
            PerformFire();
        }
    }

    private void PerformFire()
    {
        // Code to instantiate and fire a projectile
        // e.g., create projectile, set velocity, play effects, etc.
    }
}

using Unity.Netcode;
using UnityEngine;

public class PlayerScore : NetworkBehaviour
{
    public NetworkVariable<int> score = new NetworkVariable<int>(
        0,
        NetworkVariableReadPermission.Everyone,
        NetworkVariableWritePermission.Server
    );

    [ServerRpc]
    public void AddScoreServerRpc(int points)
    {
        score.Value += points;
    }
}

### latency

// Example of choosing a server based on lowest ping
void SelectBestServer(List<Server> servers)
{
    Server bestServer = null;
    float lowestPing = float.MaxValue;

    foreach (Server server in servers)
    {
        float ping = PingServer(server);
        if (ping < lowestPing)
        {
            bestServer = server;
            lowestPing = ping;
        }
    }

    ConnectToServer(bestServer);
}

// Example of client-side prediction for player movement
void UpdatePlayerPosition(PlayerInput input)
{
    if (isLocalPlayer)
    {
        // Predict local player's position
        PredictPosition(input);
    }
    else
    {
        // Interpolate position for remote players
        InterpolatePosition();
    }
}

void PredictPosition(PlayerInput input)
{
    // Apply input to predict the next position
    transform.position += input.direction * speed * Time.deltaTime;
}

void InterpolatePosition()
{
    // Smoothly interpolate to the server-reported position
    transform.position = Vector3.Lerp(
        transform.position,
        serverReportedPosition,
        Time.deltaTime * smoothingFactor
    );
}
