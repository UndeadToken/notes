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

---

### 21. What is CloudFormation Drift Detection used for?
A. Monitoring stack performance
B. Detecting manual changes to stack resources
C. Predicting stack costs
D. Validating template syntax

**Answer:** B
**Explanation:** Drift Detection identifies resources that have been modified outside of CloudFormation (manual changes via console/CLI).

---

### 22. Which feature allows reusing CloudFormation templates across multiple stacks?
A. StackSets
B. Nested Stacks
C. Change Sets
D. Stack Policies

**Answer:** B
**Explanation:** Nested Stacks allow reusing common template patterns (VPC, load balancer, etc.) across multiple parent stacks.

---

### 23. What is the purpose of CloudFormation Macros?
A. Encrypt stack resources
B. Perform custom processing and transformations on templates
C. Monitor stack events
D. Automatically roll back failed updates

**Answer:** B
**Explanation:** Macros enable custom template processing using Lambda functions to transform templates before deployment.

---

### 24. Which attribute controls what happens to a resource during stack updates (not deletion)?
A. DeletionPolicy
B. UpdatePolicy
C. UpdateReplacePolicy
D. CreationPolicy

**Answer:** C
**Explanation:** UpdateReplacePolicy determines whether to retain, snapshot, or delete a resource when it's replaced during stack updates.

---

### 25. How can one stack reference an output value from another stack?
A. !Ref
B. !GetAtt
C. !ImportValue
D. !FindInMap

**Answer:** C
**Explanation:** !ImportValue references exported output values from other stacks using the export name.

---

### 26. What is the maximum number of parameters in a CloudFormation template?
A. 60
B. 100
C. 200
D. Unlimited

**Answer:** C
**Explanation:** CloudFormation templates support up to 200 parameters.

---

### 27. Which CloudFormation feature deploys stacks across multiple accounts and regions?
A. Nested Stacks
B. Stack Sets
C. Cross-Stack References
D. Change Sets

**Answer:** B
**Explanation:** Stack Sets deploy stacks across multiple AWS accounts and regions from a single template.

---

### 28. What is the purpose of CloudFormation Change Sets?
A. Change templates
B. Preview changes before executing stack updates
C. Change parameters
D. Change regions

**Answer:** B
**Explanation:** Change Sets show what changes will be made to a stack before executing the update.

---

### 29. Which CloudFormation helper script installs packages and files?
A. cfn-init
B. cfn-signal
C. cfn-hup
D. cfn-get-metadata

**Answer:** A
**Explanation:** cfn-init retrieves and interprets metadata to install packages, create files, and start services.

---

### 30. What is the maximum template size for direct upload?
A. 51,200 bytes
B. 460,800 bytes (450 KB)
C. 1 MB
D. 10 MB

**Answer:** B
**Explanation:** Direct upload limit is 51,200 bytes. Use S3 for templates up to 460,800 bytes (450 KB).

---

### 31. Which CloudFormation intrinsic function joins values with a delimiter?
A. !Join
B. !Sub
C. !Concat
D. !Merge

**Answer:** A
**Explanation:** !Join concatenates values with a specified delimiter.

---

### 32. What is the purpose of CloudFormation DependsOn attribute?
A. Depend on other services
B. Control resource creation order
C. Depend on parameters
D. Depend on outputs

**Answer:** B
**Explanation:** DependsOn explicitly defines resource creation order when automatic dependency detection isn't sufficient.

---

### 33. Which CloudFormation feature allows custom provisioning logic?
A. Macros
B. Custom Resources
C. Transforms
D. All of the above

**Answer:** D
**Explanation:** Macros, Custom Resources, and Transforms all enable custom provisioning logic.

---

### 34. What is the maximum number of outputs per stack?
A. 60
B. 100
C. 200
D. Unlimited

**Answer:** A
**Explanation:** CloudFormation stacks support up to 60 outputs.

---

### 35. Which CloudFormation helper script signals resource creation completion?
A. cfn-init
B. cfn-signal
C. cfn-hup
D. cfn-get-metadata

**Answer:** B
**Explanation:** cfn-signal sends a signal to CloudFormation indicating resource creation success or failure.

---

### 36. What is the purpose of CloudFormation Conditions?
A. Conditional logic
B. Control resource creation based on parameter values or mappings
C. Error handling
D. Validation

**Answer:** B
**Explanation:** Conditions control whether resources are created based on parameter values, mappings, or other conditions.

---

### 37. Which CloudFormation transform enables SAM syntax?
A. AWS::Serverless
B. AWS::Serverless-2016-10-31
C. AWS::SAM
D. AWS::Lambda

**Answer:** B
**Explanation:** AWS::Serverless-2016-10-31 transform enables AWS SAM syntax in CloudFormation templates.

---

### 38. What happens when a stack update fails?
A. Stack is deleted
B. Stack automatically rolls back to previous state
C. Stack remains in failed state
D. Stack is archived

**Answer:** B
**Explanation:** Failed stack updates automatically roll back to the previous working state by default.

---

### 39. Which CloudFormation feature prevents accidental stack deletion?
A. DeletionPolicy
B. Termination Protection
C. Stack Lock
D. Deletion Lock

**Answer:** B
**Explanation:** Termination Protection prevents accidental stack deletion until explicitly disabled.

---

### 40. What is the maximum number of resources per stack?
A. 100
B. 200
C. 500
D. 1,000

**Answer:** C
**Explanation:** CloudFormation stacks support up to 500 resources (use nested stacks for larger deployments).

---

### 41. Which CloudFormation helper script detects metadata changes?
A. cfn-init
B. cfn-signal
C. cfn-hup
D. cfn-get-metadata

**Answer:** C
**Explanation:** cfn-hup daemon detects changes to resource metadata and runs specified actions.

---

### 42. What is the purpose of CloudFormation Mappings?
A. Map parameters
B. Define static lookup tables (key-value pairs)
C. Map resources
D. Map outputs

**Answer:** B
**Explanation:** Mappings define static key-value lookup tables for values like AMI IDs per region.

---

### 43. Which CloudFormation DeletionPolicy retains resources after stack deletion?
A. Delete
B. Retain
C. Snapshot
D. Both B and C

**Answer:** D
**Explanation:** Both Retain (keeps resource) and Snapshot (creates snapshot then deletes) preserve data after stack deletion.

---

### 44. What is the maximum nesting depth for nested stacks?
A. 3 levels
B. 5 levels
C. 10 levels
D. Unlimited

**Answer:** B
**Explanation:** Nested stacks support up to 5 levels of nesting.

---

### 45. Which CloudFormation feature allows template reuse with modifications?
A. Macros
B. Nested Stacks
C. Stack Sets
D. Modules

**Answer:** A
**Explanation:** Macros process templates and can add, modify, or remove resources programmatically.

---

### 46. What is the purpose of CloudFormation CreationPolicy?
A. Control who can create stacks
B. Wait for resource signals before marking creation complete
C. Define creation order
D. Validate creation

**Answer:** B
**Explanation:** CreationPolicy waits for a specified number of success signals before marking resource creation complete.

---

### 47. Which CloudFormation status indicates a failed update with successful rollback?
A. UPDATE_FAILED
B. UPDATE_ROLLBACK_COMPLETE
C. ROLLBACK_COMPLETE
D. UPDATE_COMPLETE

**Answer:** B
**Explanation:** UPDATE_ROLLBACK_COMPLETE indicates the update failed and successfully rolled back.

---

### 48. What is the maximum number of Stack Sets per administrator account?
A. 10
B. 100
C. 1,000
D. 2,000

**Answer:** B
**Explanation:** Maximum of 100 Stack Sets per administrator account (soft limit).

---

### 49. Which CloudFormation intrinsic function retrieves attribute values?
A. !Ref
B. !GetAtt
C. !FindInMap
D. !Select

**Answer:** B
**Explanation:** !GetAtt retrieves attribute values from resources (e.g., ARN, DNS name).

---

### 50. What is the purpose of CloudFormation Stack Policies?
A. IAM policies for stacks
B. Prevent unintended updates to stack resources
C. Network policies
D. Security policies

**Answer:** B
**Explanation:** Stack Policies define which resources can be updated during stack updates, preventing accidental modifications.

