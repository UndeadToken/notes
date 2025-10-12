# AI

NavMesh: NavMesh in Unity simplifies pathfinding by defining walkable areas and calculating
efficient paths for characters. It’s essential for NPCs to navigate complex terrains, avoid obstacles,
and optimize routes in real time. Integrated with Unity’s physics engine, NavMesh ensures both
intelligent and realistic character movements.

Animator: Unity’s Animator is vital for lifelike game experiences, using state machines to manage
character animations based on gameplay dynamics. For example, characters transition between
walking and running or standing and jumping in response to the game’s logic. This tool enables
developers to create detailed animation flows, enhancing characters’ reactivity and dynamism.

ML-Agents: Unity’s ML-Agents Toolkit is a groundbreaking feature that enables machine
learning to boost game AI. It offers a framework to train intelligent agents within a game
environment, using deep reinforcement learning or other methods. These agents learn and
adapt over time, perfect for developing complex behaviors that improve with experience. This
capability is invaluable for games that need NPCs to handle tasks too complex for traditional
AI coding, such as adapting strategies based on player behavior.

using UnityEngine;
using UnityEngine.AI;

public class SimpleNavAgent : MonoBehaviour
{
    public Transform target; // Drag your target in the Inspector
    private NavMeshAgent agent;

    void Start()
    {
        agent = GetComponent<NavMeshAgent>();
    }

    void Update()
    {
        if (target != null)
        {
            agent.SetDestination(target.position);
        }
    }
}

 finite state
machines (FSMs), Behavior Trees, and utility-based systems can be leveraged within Unity to empower
NPCs with intelligent decision-making abilities, based on game states.

using UnityEngine;

public class EnemyController : MonoBehaviour
{
    private Animator animator;
    private Transform player;
    private float detectionRange = 10.0f;

    void Start()
    {
        animator = GetComponent<Animator>();
        player = GameObject.FindWithTag("Player").transform;
    }

    void Update()
    {
        float distanceToPlayer = Vector3.Distance(transform.position, player.position);

        if (distanceToPlayer < detectionRange)
        {
            animator.SetTrigger("Chase");
        }
        else
        {
            animator.SetTrigger("Patrol");
        }
    }
}

// Pseudocode for a behavior tree node
public class AttackOrRetreatNode : Node
{
    public override NodeState Evaluate()
    {
        if (CanSeePlayer() && EnoughHealth())
        {
            return NodeState.SUCCESS; // Proceed to attack
        }
        else
        {
            return NodeState.FAILURE; // Retreat or take cover
        }
    }

    private bool CanSeePlayer()
    {
        // Placeholder for line of sight logic
        return true;
    }

    private bool EnoughHealth()
    {
        // Placeholder for health check logic
        return true;
    }
}

using UnityEngine;

public class UtilityDecider : MonoBehaviour
{
    public float attackUtility;
    public float defendUtility;
    public float specialAbilityUtility;

    void DecideAction()
    {
        float maxUtility = Mathf.Max(attackUtility, defendUtility, specialAbilityUtility);

        if (maxUtility == attackUtility)
        {
            PerformAttack();
        }
        else if (maxUtility == defendUtility)
        {
            PerformDefend();
        }
        else
        {
            PerformSpecialAbility();
        }
    }

    void PerformAttack()
    {
        // Implementation here
    }

    void PerformDefend()
    {
        // Implementation here
    }

    void PerformSpecialAbility()
    {
        // Implementation here
    }
}

using UnityEngine;

public interface IEnemyState
{
    void EnterState(EnemyController controller);
    void UpdateState();
}

public class PatrolState : IEnemyState
{
    public void EnterState(EnemyController controller)
    {
        controller.SetPatrolBehavior();
    }

    public void UpdateState()
    {
        // Patrol logic here
    }
}

public class AttackState : IEnemyState
{
    public void EnterState(EnemyController controller)
    {
        controller.SetAttackBehavior();
    }

    public void UpdateState()
    {
        // Attack logic here
    }
}

public class EnemyController : MonoBehaviour
{
    private IEnemyState currentState;

    public void SetState(IEnemyState newState)
    {
        currentState = newState;
        currentState.EnterState(this);
    }

    void Update()
    {
        currentState?.UpdateState();
    }

    public void SetPatrolBehavior()
    {
        // Specific patrol settings
    }

    public void SetAttackBehavior()
    {
        // Specific attack settings
    }
}

public void UpdatePathfinding() {
  if (Time.time - lastPathUpdate > pathUpdateInterval) {
    navMeshAgent.CalculatePath(target.position, path);
    navMeshAgent.SetPath(path);
    lastPathUpdate = Time.time;
  }
}

private float decisionCooldown = 1.0f;
private float lastDecisionTime = 0.0f;

void Update() {
  if (Time.time > lastDecisionTime + decisionCooldown) {
    MakeDecision();
    lastDecisionTime = Time.time;
  }
}

void MakeDecision() {
  // Complex decision-making logic here
}

using UnityEngine;
using System.Collections.Generic;

public class PatrolGuardAI : MonoBehaviour
{
    private BehaviorTree tree;

    void Start()
    {
        tree = new BehaviorTree();

        Node root = new SelectorNode();

        Node patrolNode = new SequenceNode(new List<Node>
        {
            new CheckPatrolAreaNode(),
            new MoveToNode(patrolPath),
        });

        Node chaseNode = new SequenceNode(new List<Node>
        {
            new CanSeePlayerNode(),
            new ChasePlayerNode(),
        });

        Node investigateNode = new SequenceNode(new List<Node>
        {
            new HeardNoiseNode(),
            new InvestigateNoiseNode(),
        });

        root.AddChild(patrolNode);
        root.AddChild(chaseNode);
        root.AddChild(investigateNode);

        tree.SetRoot(root);
    }

    void Update()
    {
        tree.Tick(); // Process the behavior tree
    }
}

using Unity.MLAgents;
using Unity.MLAgents.Sensors;
using Unity.MLAgents.Actuators;
using System;

public class NPCAgent : Agent
{
    public override void OnEpisodeBegin()
    {
        // Reset the NPC state for new episode
    }

    public override void CollectObservations(VectorSensor sensor)
    {
        // Add NPC's observations of the environment for decision making
    }

    public override void OnActionReceived(ActionBuffers actionBuffers)
    {
        // Actions received from the model
        int action = actionBuffers.DiscreteActions[0];
        if (action == 1)
        {
            // Perform the action, e.g., move towards a target
        }
    }

    public override void Heuristic(in ActionBuffers actionsOut)
    {
        // Provide manual control as fallback
        actionsOut.DiscreteActions.Array[0] = Convert.ToInt32(Input.GetKey(KeyCode.Space));
    }
}

using UnityEngine;

public class DecisionThrottlingAI : MonoBehaviour
{
    public Transform player;
    private float decisionCooldown = 1.0f; // Time between decisions
    private float lastDecisionTime = 0f;

    void Update()
    {
        if (Time.time > lastDecisionTime + decisionCooldown)
        {
            MakeDecision();
            lastDecisionTime = Time.time;
        }
    }

    void MakeDecision()
    {
        if (Vector3.Distance(transform.position, player.position) < 10f)
        {
            // Logic to hide because the player is too close
            Debug.Log("Hiding");
        }
        else
        {
            // Logic to seek the player
            Debug.Log("Seeking");
        }
    }
}

