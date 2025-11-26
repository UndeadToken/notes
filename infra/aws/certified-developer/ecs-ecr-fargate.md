# ECS, ECR & Fargate – Docker on AWS

## Docker Overview
- Docker packages applications into containers that run consistently anywhere.
- Benefits:
  - Predictable behaviour
  - Platform-independent
  - Easier to maintain & deploy
  - Works with any language or OS
- Use Cases:
  - Microservices
  - Lift-and-shift apps from on-premises to AWS

## Docker Image Storage
- **Docker Hub:** public images (Ubuntu, MySQL, etc.)
- **Amazon ECR:** private & public repositories (ECR Public Gallery)
- Integrated with ECS for seamless deployment

## Docker vs Virtual Machines
| Concept | VM | Docker |
|---------|----|--------|
| OS Layer | Guest OS | Shared Host OS |
| Resources | Dedicated | Shared |
| Isolation | Strong | Lightweight |
| Deployment | Slower | Faster |

---

## AWS Container Management
- **Amazon ECS:** AWS-managed container service
- **Amazon EKS:** Managed Kubernetes service
- **AWS Fargate:** Serverless container execution (works with ECS & EKS)
- **Amazon ECR:** Container image repository

---

## ECS Launch Types
### EC2 Launch Type
- You provision EC2 instances
- ECS Agent manages container lifecycle
- Must maintain infrastructure

### Fargate Launch Type
- Serverless; no EC2 instances to manage
- Simply define task definitions (CPU, RAM)
- Auto-scalable by tasks

---

## ECS IAM Roles
- **EC2 Instance Role:** ECS agent actions (EC2 launch type)
- **Task Role:** IAM permissions per task (access APIs, secrets, logs)

---

## ECS Load Balancing
- **ALB:** Most use cases, Layer 7, HTTP/HTTPS routing
- **NLB:** High throughput, TCP/UDP
- **CLB:** Legacy, not recommended
- **Fargate:** Each task gets unique private IP; only container port needed

---

## ECS Data Volumes
- **EFS:** Multi-AZ persistent storage
- **Bind Mounts:** Share data between containers in the same task
  - EC2: tied to instance lifecycle
  - Fargate: ephemeral, task-lifecycle bound (20–200 GiB)

---

## ECS Auto Scaling
- Task-level scaling with Application Auto Scaling:
  - Target Tracking (CPU/Memory/RequestCountPerTarget)
  - Step Scaling (CloudWatch alarms)
  - Scheduled Scaling
- EC2 Launch Type requires underlying EC2 scaling via ASG and capacity providers

---

## ECS Task Definitions
- Metadata in JSON defining how containers run:
  - Image, ports, CPU, memory
  - Environment variables, IAM roles, logging
  - Can define multiple containers per task

---

## ECS Task Placement (EC2 only)
- Strategies:
  - **Binpack:** minimize instance usage
  - **Random:** random placement
  - **Spread:** distribute evenly across AZs/instances
- Constraints:
  - **memberOf:** select instances based on attribute expression
  - **distanceInstance:** ensure tasks run on separate instances

---

## Amazon ECR
- Fully-managed Docker image registry
- Private & Public repositories
- Integrated with ECS
- IAM-controlled access
- Supports image scanning, versioning, and lifecycle policies
- **CLI Example:**
  ```
  aws ecr get-login-password --region <region> | docker login --username AWS --password-stdin <account_id>.dkr.ecr.<region>.amazonaws.com
  docker push <account_id>.dkr.ecr.<region>.amazonaws.com/demo:latest
  docker pull <account_id>.dkr.ecr.<region>.amazonaws.com/demo:latest
  ```

---

## AWS Copilot CLI
- Tool for building, releasing, and operating production-ready containerized apps
- Supports AppRunner, ECS, Fargate
- Automates infrastructure (VPC, ALB, ECR, ECS)
- Simplifies multi-environment deployments

---

## Amazon EKS
- Managed Kubernetes service
- Alternative to ECS for Kubernetes workloads
- Supports EC2 or Fargate nodes
- Useful for companies already using Kubernetes on-premises or multi-cloud

### Node Types
- **Managed Node Groups:** AWS-managed EC2 instances in ASG
- **Self-Managed Nodes:** You provision and manage EC2 nodes
- **Fargate:** Serverless, no nodes to manage

### Storage
- Requires a StorageClass manifest
- Supports:
  - Amazon EBS
  - Amazon EFS (works with Fargate)
  - Amazon FSx (Lustre, NetApp ONTAP)
