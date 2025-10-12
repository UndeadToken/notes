# Physics

### Mass & Angular Drag

Mass determines the heaviness of an object, affecting how it responds to forces and collisions. A higher
mass means that the object will require a greater force to move or stop. Drag acts as air resistance,
slowing down the object’s movement and eventually bringing it to a halt if no other forces act upon it.

Typically, you will only need to select the isKinematic option for objects that are static and do not
move. Adding a RigidBody to static objects and setting them as kinematic ensures that collisions with
other objects are properly detected by Unity’s physics system, even if the static object itself doesn’t
use gravity. The Use Gravity option is usually enabled, except in special scenarios such as outer
space-themed games.

Note the isTrigger option; if this is selected, the collider will report when another GameObject with a collider
intersects its space.

using UnityEngine;

public class ForceAndTorqueDemo : MonoBehaviour
{
    public float forceMagnitude = 10f;
    public float torqueMagnitude = 5f;

    private Rigidbody rb;

    void Start()
    {
        // Get the Rigidbody component attached to this GameObject
        rb = GetComponent<Rigidbody>();
    }

    void Update()
    {
        // Check for user input to apply force
        if (Input.GetKeyDown(KeyCode.Space))
        {
            // Apply an upward force to the Rigidbody
            rb.AddForce(Vector3.up * forceMagnitude, ForceMode.Impulse);
        }

        // Check for user input to apply torque
        if (Input.GetKeyDown(KeyCode.T))
        {
            // Apply a rotational force (torque) around the Z-axis
            rb.AddTorque(Vector3.forward * torqueMagnitude, ForceMode.Impulse);
        }
    }
}

using UnityEngine;
using UnityEngine.UI;

public class GravityAndImpulseDemo : MonoBehaviour
{
    public float jumpForce = 5f;
    public Slider gravitySlider;

    private Rigidbody rb;

    void Start()
    {
        // Get the Rigidbody component attached to the GameObject
        rb = GetComponent<Rigidbody>();

        // Set the initial value of the gravity slider
        if (gravitySlider != null)
        {
            gravitySlider.value = Physics.gravity.y;
            gravitySlider.onValueChanged.AddListener(OnGravityChanged);
        }
    }

    void Update()
    {
        // Check for user input to apply an impulse force
        if (Input.GetKeyDown(KeyCode.Space))
        {
            // Apply an impulse force upwards to simulate a jump
            rb.AddForce(Vector3.up * jumpForce, ForceMode.Impulse);
        }
    }

    // Method to handle gravity changes via the slider
    void OnGravityChanged(float newGravity)
    {
        Physics.gravity = new Vector3(0, newGravity, 0);
    }
}

Physic Materials, a powerful feature in Unity that
allows developers to define how objects interact at their surfaces

### Events

OnCollisionEnter: This event is triggered when a collider makes contact with another
collider for the first time. It’s the starting point for many interaction scripts, signaling the initial
moment of impact.

OnCollisionStay: This event continuously fires as long as colliders remain in contact,
allowing for the scripting of sustained interactions such as objects pushing against each other.

OnCollisionExit: Triggered when colliders that were in contact separate, this event can be
used to script effects or behaviors that occur once an object is no longer in contact with another.

void OnCollisionEnter(Collision collision)
{
    // Play sound
    AudioSource audio = GetComponent<AudioSource>();
    audio.Play();

    // Change color to indicate damage
    Renderer renderer = GetComponent<Renderer>();
    renderer.material.color = Color.red;
}

The Unity Animator component is key for animating characters, managing states such as idle and
running through the Animator Controller for fluid transitions. Acting as a bridge between characters
and their animations, it ensures dynamic, responsive movements by interpreting the Controller’s
instructions for seamless animation playback.

using UnityEngine;

public class PlayerController : MonoBehaviour
{
    Animator animator;

    void Start()
    {
        animator = GetComponent<Animator>();
    }

    void Update()
    {
        if (Input.GetKeyDown(KeyCode.Space))
        {
            // Set the 'isJumping' parameter to true when the space bar is pressed
            animator.SetBool("isJumping", true);
        }
    }
}

// Mixamo animations site

using UnityEngine;

public class CharacterPhysicsReactions : MonoBehaviour
{
    public Animator animator;
    public float stumbleForce = 5f;

    private void OnCollisionEnter(Collision collision)
    {
        // Check if the collision was with an obstacle
        if (collision.gameObject.tag == "Obstacle")
        {
            // Play the "stumble" animation
            animator.SetTrigger("Stumble");

            // Apply a force to the character to make them stumble
            GetComponent<Rigidbody>().AddForce(
                -collision.contacts[0].normal * stumbleForce,
                ForceMode.Impulse
            );
        }
    }
}

using UnityEngine;

public class InteractiveDoor : MonoBehaviour
{
    public Animator doorAnimator;
    public float interactionRange = 2f;

    private void Update()
    {
        // Check if the player is within the interaction range
        float distance = Vector3.Distance(
            transform.position,
            PlayerController.instance.transform.position
        );

        if (distance <= interactionRange)
        {
            // Play the "Open" animation
            doorAnimator.SetTrigger("Open");
        }
        else
        {
            // Play the "Close" animation
            doorAnimator.SetTrigger("Close");
        }
    }
}

using UnityEngine;

public class BridgeCollapse : MonoBehaviour
{
    public float maxWeight = 500f;
    public float collapseSpeed = 2f;
    public Animator bridgeAnimator;

    private bool isCollapsing = false;

    private void OnTriggerEnter(Collider other)
    {
        // Check if the colliding object is the player
        if (other.CompareTag("Player"))
        {
            // Get the total weight of the player and any carried objects
            float totalWeight =
                other.GetComponent<Rigidbody>().mass +
                other.GetComponent<PlayerInventory>().totalWeight;

            // If the total weight exceeds the bridge's capacity, start the collapse
            if (totalWeight > maxWeight)
            {
                isCollapsing = true;
                bridgeAnimator.SetTrigger("Collapse");
            }
        }
    }

    private void Update()
    {
        // Gradually lower the bridge as it collapses
        if (isCollapsing)
        {
            transform.Translate(Vector3.down * collapseSpeed * Time.deltaTime);
        }
    }
}

using UnityEngine;

public class AnimatorManager : MonoBehaviour
{
    private Animator animator;
    private RuntimeAnimatorController controller;

    // Animation clips to assign
    public AnimationClip idleClip;
    public AnimationClip runClip;

    void Awake()
    {
        // Add Animator component if not present
        animator = GetComponent<Animator>();
        if (animator == null)
        {
            animator = gameObject.AddComponent<Animator>();
        }

        // Create a simple controller with two states (idle & run)
        controller = CreateSimpleController(idleClip, runClip);
        animator.runtimeAnimatorController = controller;
    }

    // Example to switch animation by name
    public void PlayAnimation(string stateName)
    {
        animator.Play(stateName);
    }

    // Creates a simple RuntimeAnimatorController with two states
    private RuntimeAnimatorController CreateSimpleController(AnimationClip idle, AnimationClip run)
    {
        var controller = new UnityEditor.Animations.AnimatorController();
        controller.AddParameter("State", UnityEngine.AnimatorControllerParameterType.Int);

        var rootStateMachine = controller.layers[0].stateMachine;

        var idleState = rootStateMachine.AddState("Idle");
        idleState.motion = idle;

        var runState = rootStateMachine.AddState("Run");
        runState.motion = run;

        // Transitions by parameter "State" (0 = Idle, 1 = Run)
        var transIdleToRun = idleState.AddTransition(runState);
        transIdleToRun.AddCondition(UnityEngine.AnimatorConditionMode.Equals, 1, "State");
        transIdleToRun.hasExitTime = false;

        var transRunToIdle = runState.AddTransition(idleState);
        transRunToIdle.AddCondition(UnityEngine.AnimatorConditionMode.Equals, 0, "State");
        transRunToIdle.hasExitTime = false;

        return controller;
    }

    // Switch animation by int param
    public void SetState(int state)
    {
        animator.SetInteger("State", state);
    }
}
