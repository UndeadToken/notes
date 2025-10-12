# NPC

using UnityEngine;
using UnityEngine.Netcode;
public class PlayerMovement : NetworkBehaviour
{
public float speed = 10f;
void Update()
{
if (!isLocalPlayer) return;
float x = Input.GetAxis("Horizontal") * speed *
Time.deltaTime;
float z = Input.GetAxis("Vertical") * speed *
Time.deltaTime;
transform.Translate(x, 0, z);
}
}

using UnityEngine;
using UnityEngine.AI;
public class EnemyAI : MonoBehaviour
{
public NavMeshAgent agent;
public Transform player;
void Update()
{
agent.SetDestination(player.position);
}
}

using System.Collections.Generic;
using UnityEngine;
public class Inventory : MonoBehaviour
{
public List<Item> items = new List<Item>();
public void AddItem(Item item)
{
items.Add(item);
}
}

using UnityEngine;
using UnityEngine.Netcode;
public class MyNetworkManager : NetworkManager
{
public override void
OnServerAddPlayer(NetworkConnection conn,
short playerControllerId)
{
GameObject player = Instantiate(playerPrefab,
Vector3.zero,
Quaternion.identity);
NetworkServer.AddPlayerForConnection(conn, player,
playerControllerId);
}
}

using UnityEngine;
using UnityEngine.AI;
public class EnemyPatrolController : MonoBehaviour
{
public NavMeshAgent agent;
public Transform[] patrolPoints;
private int currentPatrolIndex;
void Start()
{
// Start patrolling from the first point
if (patrolPoints.Length > 0)
{
agent.SetDestination(patrolPoints[0].position);
currentPatrolIndex = 0;
}
}
void Update()
{
// If the agent reaches the current patrol point,
// move to the next one
if (!agent.pathPending && agent.remainingDistance
< 0.5f)
{
currentPatrolIndex = (currentPatrolIndex + 1)
% patrolPoints.Length;
agent.SetDestination(patrolPoints
[currentPatrolIndex].position);
}
}
}

using UnityEngine;
public class ApplyForce : MonoBehaviour
{
public Rigidbody rb;
public Vector3 forceDirection;
public float forceMagnitude;
void Start()
{
rb.AddForce(forceDirection.normalized *
forceMagnitude);
}
}


