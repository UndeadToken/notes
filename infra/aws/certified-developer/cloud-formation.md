# AWS CloudFormation

CloudFormation is a **declarative infrastructure-as-code (IaC)** service that lets you define and provision AWS resources automatically in the right order.

---

## **Benefits**

- **Infrastructure as Code**
  - Resources are fully managed by code (versionable via Git)
  - No manual creation → reduces human errors
  - Easy collaboration and review of infrastructure changes

- **Cost Management**
  - Resources can be tagged by stack
  - Easy to estimate and track costs
  - Automate deletion/recreation in dev/test environments

- **Productivity**
  - Automates creation, update, deletion of resources
  - Generates dependency graph automatically
  - Declarative programming removes orchestration concerns

- **Separation of Concerns**
  - Multiple stacks for apps/layers: VPC stacks, network stacks, app stacks

- **Reuse**
  - Use existing templates from AWS and the community
  - Standardized documentation and patterns

---

## **How CloudFormation Works**

- Templates describe resources in YAML/JSON
- Templates must be uploaded to S3 or referenced directly
- Stacks are created from templates
- Deleting a stack deletes all associated resources
- Updates require re-uploading the modified template

---

## **Template Structure**

### **1. Mandatory Components**
- `Resources` — core AWS components to create
- Over 700 resource types: `Service::Type::ResourceName`

### **2. Optional Components**
- `Parameters` — dynamic inputs for template
- `Mappings` — static variables
- `Outputs` — references to created resources (can export for other stacks)
- `Conditions` — control conditional resource creation
- `Transform` — enable macros and dynamic transformations
- `Description`, `AWSTemplateFormatVersion`

---

## **Parameters**

- Input values to templates for reuse
- Types: `String`, `Number`, `CommaDelimitedList`, `List<Number>`, AWS-specific, SSM parameter
- Constraints: `AllowedValues`, `AllowedPattern`, `Min/MaxLength`, `Min/MaxValue`, `NoEcho`
- Example:

```yaml
Parameters:
  InstanceType:
    Description: EC2 instance type
    Type: String
    AllowedValues:
      - t2.micro
      - t2.small
      - t2.medium
    Default: t2.micro
```

---

## **Mappings**

- Hardcoded values for environments, regions, etc.
- Example:

```yaml
Mappings:
  RegionMap:
    us-east-1:
      HVM64: ami-0ff8a91507f77f867
Resources:
  MyEC2Instance:
    Type: AWS::EC2::Instance
    Properties:
      ImageId: !FindInMap [RegionMap, !Ref "AWS::Region", HVM64]
```

---

## **Outputs**

- Optional values that can be exported to other stacks
- Example:

```yaml
Outputs:
  SSHSecurityGroup:
    Description: The SSH Security Group
    Value: !Ref MyCompanyWideSSHSecurityGroup
    Export:
      Name: SSHSecurityGroup
```

---

## **Conditions**

- Control whether resources are created
- Example:

```yaml
Conditions:
  CreateProdResources: !Equals [!Ref EnvType, prod]

Resources:
  ProdVolume:
    Type: AWS::EC2::Volume
    Condition: CreateProdResources
```

- Common functions: `Fn::If`, `Fn::And`, `Fn::Equals`, `Fn::Not`, `Fn::Or`

---

## **Intrinsic Functions**

- `!Ref`, `Fn::GetAtt`, `Fn::FindInMap`, `Fn::ImportValue`, `Fn::Join`, `Fn::Sub`
- `Fn::Base64`, `Fn::Cidr`, `Fn::GetAZs`, `Fn::Select`, `Fn::Split`, `Fn::Transform`
- Example:

```yaml
UserData:
  Fn::Base64: |
    #!/bin/bash
    yum install -y httpd
    systemctl start httpd
```

---

## **Stack Operations**

- **Rollback**
  - Stack creation/update fails → rollback to previous state
  - Can disable rollback for troubleshooting
- **Service Role**
  - IAM role to allow CloudFormation to manage resources
  - Supports least-privilege model
- **Capabilities**
  - `CAPABILITY_IAM`, `CAPABILITY_NAMED_IAM` → for IAM resources
  - `CAPABILITY_AUTO_EXPAND` → for macros/nested stacks

---

## **Deletion Policies**

- `Delete` (default) — deletes resource
- `Snapshot` — creates a snapshot before deletion (EBS, RDS, ElastiCache, DocumentDB)
- Example:

```yaml
Resources:
  MyDB:
    Type: AWS::RDS::DBInstance
    DeletionPolicy: Snapshot
```

---

## **Stack Policies**

- Protect resources from accidental updates
- Deny updates on specific resources:

```json
{
  "Statement": [
    {
      "Effect": "Allow",
      "Action": "Update:*",
      "Principal": "*",
      "Resource": "*"
    },
    {
      "Effect": "Deny",
      "Action": "Update:*",
      "Principal": "*",
      "Resource": "LogicalResourceId/ProductionDatabase"
    }
  ]
}
```

---

## **Termination Protection**

- Prevents accidental stack deletion

---

## **Custom Resources**

- For unsupported AWS resources or custom provisioning logic
- Usually backed by a Lambda function
- Example:

```yaml
Resources:
  EmptyS3Bucket:
    Type: Custom::EmptyBucket
    Properties:
      ServiceToken: arn:aws:lambda:REGION:ACCOUNT_ID:function:EmptyBucketLambda
```

---

## **StackSets**

- Deploy, update, or delete stacks across multiple accounts and regions
- Managed via admin/delegated accounts

---

### **References**

- AWS Resource Types: [AWS Docs](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-template-resource-type-ref.html)  
- EC2 Instance: [AWS Docs](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-resource-ec2-instance.html)
