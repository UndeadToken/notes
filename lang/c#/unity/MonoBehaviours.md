# Mono Behaviours

### Update()

using UnityEngine;
public class Mover: MonoBehaviour
{
public float speed = 5.0f;
void Update()
{
// Move the game object forward continuously at the
// speed specified
transform.Translate(Vector3.forward * speed *
Time.deltaTime);
}
}

using UnityEngine;
public class Rotator: MonoBehaviour
{
public float rotationSpeed = 90.0f;
// Degrees per second
void Update()
{
// Rotate the game object around its up axis at the
// speed specified
transform.Rotate(Vector3.up, rotationSpeed *
Time.deltaTime);
}
}

### OnDisable()

OnDisable(): This method is invoked when the object becomes disabled or inactive. It is
commonly used for cleanup tasks or to unregister the object from events or services it was
previously listening to, ensuring that deactivated objects do not continue to consume resources
or process events.
In the following code, the OnDisable() method logs a message to the console when the
object is disabled. In the following example, the GameObject attached to this script is destroyed.
That is, it is completely removed from the gameplay:
void OnDisable() {
Destroy(this);
}

### LateUpdate

LateUpdate(): This is called once per frame, after all Update() functions have been called.
This is useful for actions that need to happen after all other regular updates, such as character
animation adjustments, where the animation needs to synchronize with the final positions
and states of characters after they have completed their movements for the frame. This code
defines the OnDisable method, which Unity automatically calls when a GameObject or its
component becomes inactive. Inside this method, a message, "OnDisable called.",
is logged to the console, serving as a simple notification or debugging tool to indicate when
the method is triggered. The following example updates the attached game component,
CharacterAnimator. It supplies a new value for Speed, which, for this example, we
assume is being supplied by another method.
void LateUpdate() {
characterAnimator.SetFloat("Speed",

### FixedUpdate()

FixedUpdate(): Unlike Update(), which is called once per frame and can have varying
intervals between calls, FixedUpdate() runs at consistent intervals. This makes it ideal
for physics-related updates where a consistent time step is crucial for stable and predictable
simulations. This code snippet defines the FixedUpdate method in Unity, which is called at
a consistent rate, independent of the game’s frame rate. It logs the message "FixedUpdate
called." to the console every time it executes, and is typically used for physics calculations
and consistent updates. In the following example, Gravity and the Rigidbody’s (rb) mass is
applied to the GameObject:
void FixedUpdate() {
rb.AddForce(Physics.gravity * rb.mass);
}

### OnBecameVisible

•
OnBecameVisible() and OnBecameInvisible(): These methods are called when the
GameObject becomes either visible or invisible to any camera. They are handy for optimizing
performance by enabling or disabling processing or rendering tasks based on the visibility of
the object.
The following code snippets are Unity event methods that detect the visibility of a GameObject.
OnBecameVisible() is called when the GameObject becomes visible to any camera, logging
"Object is now visible.". Similarly, OnBecameInvisible() is triggered when the
GameObject is no longer visible to any camera, logging "Object is now invisible.".
These methods are useful for managing behavior based on visibility, such as optimizing
performance by disabling off-screen processes. In the following example, a particle system,
such as a magic effect, is toggled on and off when the game object is made visible or invisible:
void OnBecameVisible() {
particleSystem.Play();
}
void OnBecameInvisible() {
particleSystem.Stop();
}

### OnDestroy()

OnDestroy(): This method is called when a MonoBehaviour instance is destroyed, either
because its GameObject is being destroyed or because the MonoBehaviour is being removed
from the GameObject. It’s an appropriate place to perform any final cleanup, such as saving
state or gracefully disconnecting from services or networks.
The following code snippet contains the OnDestroy() method, which Unity calls just before
it destroys a GameObject or component. The method logs "OnDestroy called." to the
console, providing a way to execute cleanup logic or notify when the object is being removed
from the scene:
void OnDestroy() {
Debug.Log("OnDestroy called.");
}

### Mathf

Mathf: While not a MonoBehaviour method, Mathf is a class provided by Unity that contains
static methods and constants useful for mathematical operations, especially those related to
floating-point numbers. It includes functions for trigonometric operations, logarithms, and
other common mathematical calculations.
Exploring Unity’s script life cycle and event order 109
This code snippet calculates the sine of a 45-degree angle, expressed in radians. The first line
converts 45 degrees to radians by dividing Mathf.PI (π) by 4, since π radians equal 180
degrees. The second line uses Mathf.Sin to compute the sine of the resulting radian value,
which for 45 degrees is sqrt{2}/2, approximately 0.707:
float angleRadians = Mathf.PI / 4;
// 45 degrees in radians
float sinValue = Mathf.Sin(angleRadians);
// Calculate sine of 45 degrees

### Lifecycle

At the start of a GameObject’s life, before any gameplay begins, Unity calls a series of initialization
methods to set up the scene and its objects:

Awake(): This method is called when a script instance is loaded, even before the game starts.
It’s used to initialize variables or game state before the game begins. All Awake() calls are
completed before any Start() calls begin.

OnEnable(): If a GameObject is active, OnEnable() is called after Awake(). This method
is invoked every time the object is enabled, making it suitable for resetting or initializing the
state when objects become active again after being disabled.

Start(): Called before the first frame update but after all Awake() methods have been
executed, Start() is ideal for initialization that depends on other objects having been set
up by their Awake() methods.

During each frame of gameplay, Unity processes input, runs game logic, and renders the frame in a
specific order:
1. 2. 3. 4. 5. Input events: At the beginning of a frame, Unity first processes input events such as keyboard,
mouse, or touch inputs.
Update(): The most frequently used method, Update(), is called once per frame and is where
most of your game’s logic will reside, from movement to reaction to input.
LateUpdate(): Called after all Update() methods have been executed, LateUpdate()
is useful for actions that need to happen after other updates have occurred, such as character
animations, AI behaviors, and physics-based calculations.
Physics update (FixedUpdate()): Independent of frame rate, FixedUpdate() is called at
fixed intervals and is where physics calculations and updates should occur.
Rendering: Finally, the frame is rendered, and any visual updates appear on the screen.
At the end of an object’s life cycle or when the gameplay scenario changes, cleanup methods are invoked:
•
•
OnDisable(): When a GameObject is disabled, OnDisable() is called, providing an
opportunity to stop animations or sounds.
OnDestroy(): Right before the object is destroyed, OnDestroy() allows for final cleanup,
such as disabling UI elements.

#### Initialization:
Awake()
OnEnable()
Start()

#### Per frame
Input Events (an internal Unity process)
Update()
LateUpdate()
FixedUpdate()*[Physics Update]
Rendering

#### Cleanup
OnDisable()
OnDestroy()

Note: Physics updates occur on a separate set schedule, approximately 1/60th of a second. This may or
may not match the frame rate of the game. This means that FixedUpdate() and Update()
rarely occur at the same time

### Use cases

Now, let us explore some of the use cases associated with each of these methods:
•
Use cases for Awake():
 Setting up component references within the same GameObject.
 Initializing non-dependent data structures or variables, such as setting initial health values
or configuring base speeds.
•
Use cases for OnEnable():
 Subscribing to game events or notifications, ensuring the object only listens or reacts when
it’s active in the scene.
 Resetting object states or counters, which is useful in scenarios where GameObjects are
frequently reused, such as in object pooling systems for projectiles or enemies.
•
Use cases for Start():
 Establishing links with other GameObjects that need to be present and initialized beforehand,
such as setting up a player character to follow a target that is guaranteed to be initialized.
 Delayed initialization tasks that benefit from ensuring the entire scene’s Awake() methods
have been completed, providing a clean setup for interconnected systems.

•
Use cases for Update():
 Player input handling: Checking for keypresses or mouse input to move a character, jump,
or perform actions.
 Animation transitions: Triggering changes in animation states based on game conditions,
such as switching from a run to a jump animation.
 Custom timers: Implementing countdowns or action delays, utilizing Time.deltaTime
to decrement the timer value.
•
Use cases for FixedUpdate():
 Physics movements: Applying forces, torques, or direct velocity changes to Rigidbody
components, ensuring consistent physics simulation.
 Physics-based animations: Animating objects that rely on physics calculations, such as a
swinging pendulum, to maintain realistic behavior.
 Repeating actions with precision: Executing actions that require precise timing, unaffected
by frame rate variability, such as firing projectiles at regular intervals.
•
Use cases for LateUpdate():
 Camera follow systems: Adjusting the camera’s position or rotation to follow a target object
smoothly, after the target has moved in Update().
114
Exploring Unity’s Scripting Anatomy
 Postprocessing updates: Applying final adjustments or corrections to objects based on other
objects’ updates, such as aligning a spotlight with a moving character.
 Delayed reactions: Implementing reactions to events or inputs processed in Update(),
ensuring that the response occurs after all other updates.

•
Use cases for OnDisable():
 Event unsubscription: If a GameObject was subscribed to certain events (e.g., player health
changes and game state updates), OnDisable() should be used to unsubscribe from these
events to avoid null reference errors or unwanted behavior when the object is not active.
 Stopping coroutines: For objects that initiate coroutines, OnDisable() is a suitable place
to stop them, especially if they’re not relevant when the object is inactive.
 Network cleanup: In multiplayer games, OnDisable() can signal the need to inform
other players or the server that a particular object is no longer active, ensuring a consistent
game state across the network.
•
Use cases for OnDestroy():
 Resource deallocation: Explicitly freeing up resources, such as textures or data loaded from
disk, to ensure they’re properly garbage collected.
 Saving state: For objects that hold critical game data, OnDestroy() can trigger saving
this data to disk or player preferences, ensuring no progress is lost.
 Cleanup notifications: Informing other parts of the game that an object is about to be
destroyed, which might be necessary for updating UI elements, leaderboards, or player stats.

### Input Management

•
•
•
•
•
•
Debouncing input: One common challenge in game development is handling rapid, repeated
inputs, such as a player pressing a button multiple times in quick succession. Debouncing is
a technique used to ensure that only one input is registered within a specified time frame,
preventing unintended multiple actions from being triggered. This is especially useful in
scenarios such as firing a weapon or jumping, where precise control is paramount.
Input abstraction: Rather than hardcoding specific keys or buttons within your game’s logic,
abstracting input allows for a more flexible and adaptable control scheme. By mapping actions to
abstract inputs, you can easily reassign keys or buttons without altering the underlying gameplay
logic. This approach not only makes your game more accessible across different devices but also
simplifies the process of customizing controls to suit individual player preferences.
Using Unity’s Input Manager: Unity’s built-in Input Manager offers a robust framework for
managing input from various sources, including keyboards, gamepads, and touch devices.
Leveraging this system enables developers to define and manage complex input configurations
with ease, ensuring compatibility across a wide range of devices.
Handling touch and mouse inputs: In today’s gaming landscape, accommodating both touch
and mouse inputs is essential for reaching a broader audience. Implementing multi-touch
gestures and mouse controls in a cohesive manner can significantly enhance the gameplay
experience, particularly in genres that require precision and finesse.
Utilizing Event Systems: Unity’s Event System can be a powerful tool for managing input in
more complex UI-driven games. By using event listeners and event triggers, you can create a
responsive and interactive interface that reacts intuitively to player actions.
Optimizing for performance: Efficient input handling also involves minimizing the impact
on performance. Polling for inputs in the most performance-conscious manner, such as within
the appropriate update loops (Update, FixedUpdate, or LateUpdate), ensur

