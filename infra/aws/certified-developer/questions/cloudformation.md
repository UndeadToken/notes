### 1. Which section of a CloudFormation template is mandatory?
A. Parameters
B. Resources
C. Outputs
D. Mappings

**Answer:** B
**Explanation:** Resources is the only mandatory section in a CloudFormation template.

---

### 2. A CloudFormation stack creation fails. What happens by default?
A. Stack remains in CREATE_FAILED state
B. Stack automatically rolls back and deletes created resources
C. Stack pauses for manual intervention
D. Stack retries creation automatically

**Answer:** B
**Explanation:** By default, CloudFormation rolls back on failure, deleting all created resources.

---

### 3. Which intrinsic function retrieves the value of a resource attribute?
A. !Ref
B. !GetAtt
C. !FindInMap
D. !Sub

**Answer:** B
**Explanation:** !GetAtt (Fn::GetAtt) retrieves attributes of resources (e.g., ARN, DNS name).

---

### 4. What does !Ref return when used with a parameter?
A. Parameter type
B. Parameter value
C. Parameter name
D. Parameter ARN

**Answer:** B
**Explanation:** !Ref returns the value of a parameter or the physical ID of a resource.

---

### 5. Which DeletionPolicy preserves a resource when the stack is deleted?
A. Delete
B. Retain
C. Snapshot
D. Preserve

**Answer:** B
**Explanation:** DeletionPolicy: Retain keeps the resource when the stack is deleted.

---

### 6. A CloudFormation template needs to create IAM roles. Which capability must be acknowledged?
A. CAPABILITY_AUTO_EXPAND
B. CAPABILITY_IAM
C. CAPABILITY_RESOURCES
D. CAPABILITY_CUSTOM

**Answer:** B
**Explanation:** CAPABILITY_IAM (or CAPABILITY_NAMED_IAM) is required when creating IAM resources.

---

### 7. Which CloudFormation feature allows deploying stacks across multiple accounts and regions?
A. Nested Stacks
B. Stack Policies
C. StackSets
D. Change Sets

**Answer:** C
**Explanation:** StackSets deploy, update, or delete stacks across multiple accounts and regions.

---

### 8. What is the purpose of a Change Set?
A. Preview changes before executing stack updates
B. Automatically apply changes
C. Roll back failed updates
D. Export stack outputs

**Answer:** A
**Explanation:** Change Sets preview proposed changes before updating a stack.

---

### 9. Which pseudo parameter returns the AWS region where the stack is created?
A. AWS::Region
B. AWS::AccountId
C. AWS::StackName
D. AWS::StackId

**Answer:** A
**Explanation:** AWS::Region returns the region where the stack is being created.

---

### 10. A CloudFormation template uses !FindInMap. What section must exist?
A. Parameters
B. Mappings
C. Conditions
D. Outputs

**Answer:** B
**Explanation:** !FindInMap retrieves values from the Mappings section.

---

### 11. Which DeletionPolicy creates a backup before deleting RDS databases?
A. Delete
B. Retain
C. Snapshot
D. Backup

**Answer:** C
**Explanation:** DeletionPolicy: Snapshot creates a snapshot before deleting (RDS, EBS, ElastiCache, DocumentDB).

---

### 12. How can you prevent accidental updates to a critical resource in a stack?
A. Use DeletionPolicy
B. Use Stack Policy
C. Use Change Sets
D. Use Conditions

**Answer:** B
**Explanation:** Stack Policies protect specific resources from unintentional updates.

---

### 13. Which Transform is used for SAM templates?
A. AWS::Serverless
B. AWS::Serverless-2016-10-31
C. AWS::SAM
D. AWS::Lambda

**Answer:** B
**Explanation:** Transform: AWS::Serverless-2016-10-31 indicates a SAM template.

---

### 14. A custom resource is needed to empty an S3 bucket before deletion. What typically backs this?
A. EC2 instance
B. Lambda function
C. Step Functions
D. CloudWatch Events

**Answer:** B
**Explanation:** Custom resources are typically backed by Lambda functions for custom provisioning logic.

---

### 15. Which CloudFormation helper script installs packages on EC2 instances?
A. cfn-init
B. cfn-signal
C. cfn-hup
D. cfn-get-metadata

**Answer:** A
**Explanation:** cfn-init reads metadata and installs packages, creates files, and starts services.

---

### 16. What is the purpose of cfn-signal?
A. Install packages
B. Signal CloudFormation that resource creation is complete
C. Update stack metadata
D. Monitor stack changes

**Answer:** B
**Explanation:** cfn-signal signals CloudFormation when resource configuration is complete (used with WaitConditions).

---

### 17. Which section allows conditional resource creation based on parameter values?
A. Mappings
B. Conditions
C. Parameters
D. Metadata

**Answer:** B
**Explanation:** Conditions section defines conditions for conditional resource creation.

---

### 18. A stack update requires replacing a resource. What happens to the old resource?
A. Deleted immediately
B. Retained based on DeletionPolicy
C. Deleted after new resource is created
D. Renamed with timestamp

**Answer:** C
**Explanation:** CloudFormation creates the new resource first, then deletes the old one (unless DeletionPolicy: Retain).

---

### 19. Which CloudFormation feature prevents stack deletion?
A. Stack Policy
B. Termination Protection
C. DeletionPolicy
D. Change Sets

**Answer:** B
**Explanation:** Termination Protection prevents accidental stack deletion.

---

### 20. What does the Outputs section export?
A. Stack parameters
B. Resource values for cross-stack references
C. Stack metadata
D. Stack events

**Answer:** B
**Explanation:** Outputs export values (e.g., resource IDs, ARNs) for use in other stacks via !ImportValue.
