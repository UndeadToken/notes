# Messages

### SendMessage

This allows developers to invoke a method by name on the target GameObject
or its components. This method takes the name of the method to be called as a string parameter,
along with optional parameters to pass to the method.

// Enemy.cs
using UnityEngine;

public class Enemy : MonoBehaviour
{
  void OnCollisionEnter(Collision collision)
  {
    if (collision.gameObject.CompareTag("Player"))
    {
      // Send message to the collided player
      // object to take damage
      collision.gameObject.SendMessage( "TakeDamage", 10);
    }
}

### BroadcastMessage 

On the other hand, while BroadcastMessage functions similarly
to SendMessage, it sends the message to all components on the target GameObject and
its children. This can be useful for triggering actions across multiple components within a
GameObject hierarchy.

// GameController.cs
using UnityEngine;

public class GameController : MonoBehaviour
{
  void Start()
  {
    // Broadcast message to all components in the GameController
    // object and its children
    gameObject.BroadcastMessage("Initialize",
    SendMessageOptions.RequireReceiver);
  }
}

### delegate

// Player.cs
using UnityEngine;
public class Player : MonoBehaviour
{
// Define a delegate type for the PowerUpCollected event
public delegate void PowerUpCollectedEventHandler();
// Define the event using the delegate type
public event PowerUpCollectedEventHandler PowerUpCollected;
void OnTriggerEnter(Collider other)
{
if (other.CompareTag("PowerUp"))
{
// Trigger the PowerUpCollected event
OnPowerUpCollected();
Destroy(other.gameObject); // Destroy the power-up object
}
}
// Method to trigger the PowerUpCollected event
protected virtual void OnPowerUpCollected()
{
PowerUpCollected?.Invoke();
}
}

// GameManager.cs
using UnityEngine;
public class GameManager : MonoBehaviour
{
void Start()
{
Player player = FindObjectOfType<Player>();
if (player != null)
{
// Subscribe to the PowerUpCollected event
player.PowerUpCollected += HandlePowerUpCollected;
}
}
// Method to handle the PowerUpCollected event
void HandlePowerUpCollected()
{
Debug.Log("Player collected a power-up!");
// Perform relevant actions
}
}

### Singleton

// AudioManager.cs
using UnityEngine;
public class AudioManager : MonoBehaviour
{
// Singleton instance
private static AudioManager _instance;
// Public accessor for the singleton instance
public static AudioManager Instance
{
get{
if(_instance ==null)
Debug.Log("Instance is null");
return instance;
}
void Awake() {
if(_instance != null) {
destroy(gameObject);
}
else
{
_instance=this;}
}
// Private constructor to prevent external
// instantiation
private AudioManager() { }
// Example method
public void PlaySound(AudioClip clip)
{
// Play sound logic
}
}

// ExampleScript.cs
using UnityEngine;
public class ExampleScript : MonoBehaviour
{
void Start()
{
// Accessing the AudioManager Singleton instance
AudioManager audioManager = AudioManager.Instance;
// Example usage: play a sound
AudioClip soundClip =
Resources.Load<AudioClip>("ExampleSound");
if (soundClip != null)
{
audioManager.PlaySound(soundClip);
}
else
{
Debug.LogWarning("Sound clip not found!");
}
}
}
