# Components

Transform: The Transform component controls an object’s position, rotation, and scale in
the game world, serving as the cornerstone for any spatial manipulation.

gameObject.transform.position += new Vector3(0, 0, 1);
gameObject.transform.Rotate(0, 90, 0);
gameObject.transform.localScale *= 2;

Rigidbody: Rigidbody adds physics properties to objects, allowing them to respond to
gravity and forces, making your game feel more dynamic and real.

Collider: Collider, on the other hand, defines the shape of an object for collision detection,
enabling objects to interact with each other through physical contact or proximity.


Renderer renderer = gameObject.GetComponent<Renderer>();
renderer.material.color = Color.red;

Texture newTexture = ...;
// Assume this is obtained or loaded elsewhere
Renderer renderer = gameObject.GetComponent<Renderer>();
renderer.material.mainTexture = newTexture;

model-view-controller (MVC) or entity component system (ECS)

Rigidbody: The Rigidbody component is essential for dynamics in game objects, allowing
them to respond to forces such as gravity and move realistically. It enables dynamic actions,
from characters jumping across platforms to vehicles speeding on tracks.

Collider: The Collider component defines an object’s shape for collision detection. It acts as
an invisible boundary that triggers responses upon contact with other colliders, from preventing
players from walking through walls to simulating projectile impacts. Colliders vary in shape
and size to match their objects, enhancing collision accuracy.

Physics Material: Physics Material further refines the interaction between colliding objects
by defining surface properties such as friction and bounciness. By adjusting these properties,
developers can control how objects slide, roll, or bounce off each other, adding another layer
of realism to the game environment. A slippery ice surface, for example, can be simulated by
reducing friction on a Physics Material, while a bouncy ball’s behavior can be replicated by
increasing its bounciness parameter.

using UnityEngine;
public class PlayerJump : MonoBehaviour
{
public float jumpForce = 5f;
private Rigidbody2D rb;
private bool isGrounded;

void Start()
{
rb = GetComponent<Rigidbody2D>();
}

void Update()
{
if (Input.GetKeyDown(KeyCode.Space) && isGrounded)
{
rb.AddForce(new Vector2(0, jumpForce),
ForceMode2D.Impulse);
}
}
// Check if the player is touching the ground
void OnCollisionEnter2D(Collision2D collision)
{
if (collision.gameObject.tag == "Ground")
{
isGrounded = true;
}
}
void OnCollisionExit2D(Collision2D collision)
{
if (collision.gameObject.tag == "Ground")
{
isGrounded = false;
}
}
}

using UnityEngine;

public class LaunchProjectile : MonoBehaviour
{
public Rigidbody2D projectile;
public float launchAngle = 45f;
public float launchForce = 10f;
void Start()
{
Vector2 launchDirection = Quaternion.Euler(0, 0, launchAngle)
* Vector2.right;
projectile.AddForce(launchDirection * launchForce,
ForceMode2D.Impulse);
}
}

 OnTriggerEnter, OnTriggerStay,
OnTriggerExit, OnCollisionEnter, OnCollisionStay, and OnCollisionExit

void OnTriggerEnter2D(Collider2D other)
{
if (other.gameObject.CompareTag("Collectible"))
{
Destroy(other.gameObject);
// Remove the collectible from the scene
// Increment the player's score or perform
// other actions
}
}

# Raycasting

Raycasting is a crucial technique in Unity for advanced collision detection, projecting invisible rays to identify intersections with various colliders such as BoxCollider, SphereCollider,
CapsuleCollider, and MeshCollider.

Note
Besides raycasting, Unity offers linecasting. Linecasting in Unity detects objects along a line
between two points, useful for checking lines of sight or obstacles. Physics.Linecast(startPoint,
endPoint, out RaycastHit hit) identifies whether any colliders intersect the line, aiding in
artificial intelligence (AI) visibility, bullet paths, and collision detection.

void Update() {
if (Input.GetButtonDown("Fire1")) {
// Assuming "Fire1" is your input for firing
RaycastHit hit;
Ray ray =
Camera.main.ScreenPointToRay(Input.mousePosition);
if (Physics.Raycast(ray, out hit, 100.0f)) {
// 100.0f is the max distance of the ray
Debug.Log("Hit: " + hit.collider.name);
// Optionally, apply damage to the hit object
// if it has a health component
Health health =
hit.collider.GetComponent<Health>();
if (health != null) {
health.TakeDamage(10);
// Assuming TakeDamage is a method in
// your Health script
}
}
}
}

•
•
Efficiently using Physics Layers: Unity allows developers to assign game objects to different
physics layers, which can then interact selectively with each other. By organizing objects into
these layers wisely, you can significantly reduce unnecessary physics calculations. For example,
decorative elements that don’t need to interact with the player or other game objects can be
placed on a separate layer that doesn’t calculate collisions, thus saving on processing power.
Adjusting the physics timestep: The physics timestep in Unity determines how often the
physics engine updates. While a smaller timestep can increase the accuracy of simulations, it
also requires more processing power. It’s crucial to find a balance that maintains stable and
realistic physics interactions without overburdening the CPU. Adjusting the timestep in Unity’s
time settings can help achieve smoother simulations, especially in physics-intensive games.
150
Mastering Unity’s API – Physics, Collisions, and Environment Interaction Techniques
•
•
Employing non-physics-based methods for certain interactions: Not all interactions in a
game need to rely on the physics engine. In some cases, using non-physics-based methods for
interactions, such as simple distance checks for collision detection in certain scenarios, can
be more performance-friendly while still providing a satisfactory outcome. This approach is
particularly useful in games where the number of objects and interactions can lead to significant
performance overheads if managed solely through physics.
Balancing physical accuracy with gameplay: While striving for realistic physics simulations
can enhance the immersion and feel of a game, it’s important to remember that gameplay
should always come first. In some cases, overly accurate physics can detract from the fun and
playability of the game. Developers must balance physical realism with gameplay mechanics
to ensure that the game remains engaging and accessible to players.

