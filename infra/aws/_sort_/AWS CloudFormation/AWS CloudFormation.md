AWS CloudFormation  
  
- CloudFormation is a declarative way of outlining your AWS Infrastructure, for any resources (most of them are supported)  
- For example, within a CloudFormation template, you say:  
    - I want a security group  
    - I want two EC2 instances using this security group  
    - I want two Elastic IPs for these EC2 instances  
    - I want an S3 Bucket  
    - I want a load balancer (ELB) in front of these EC2 instances  
- Then CloudFormation creates those for you, in the right order, with the exact configuration that you specify  
  
Benefits of AWS CloudFormation  
  
- Infrastructure as code  
    - No resources are manually created, which is excellent for control  
    - The code can be version controlled for example using Git  
    - Changes to the infrastructure are reviewed through code  
- Cost  
    - Each resource within the stack is tagged with an identifier so you can easily see how much a stack costs you  
    - You can estimate the costs of your resources using the CloudFormation template  
    - Savings strategy: In Dev, you could automate deletion of templates at 5PM and recreated at 8 AM safely  
- Productivity  
    - Ability to destroy and re-create an infrastructure on the cloud on the fly  
    - Automated generation of Diagram for you templates  
    - Declarative programming (No need to figure out ordering or orchestration)  
- Separation of Concerns: create many stacks for many apps, and many layers, ex.  
    - VPC stacks  
    - Network Stacks  
    - App Stacks  
- Don’t re-invent the wheel  
    - Leverage existing templates on the web  
    - Leverage the documentation  
  
How CloudFormation Works:  
  
    - Templates must be uploaded in S3 and then referenced in CloudFormation  
    - To update a template, we can’t edit previous ones. We have to re-upload a new version of the template to AWS  
    - Stacks are identified by a name  
    - Deleting a stack deletes every single artefact that was created by CloudFormation  
  
Deploying CloudFormation Templates  
  
Manual Way:  
- Editing templates in Application Composer or code editor  
- Using the console ti input parameters, etc…  
  
Automated way:  
- Editing templates in a YAML file  
- Using the AWS CLI to deploy the templates, or using a CD tool  
- Recommended way when fully want to automate your flow  
  
CloudFormation — Building Blocks  
  
Template Components:  
- AWSTemplateFormatVersion —identifies the capabilities of the template “2010-09-09”  
- Description — comments about the template  
- Resources (Mandatory) — your aws resources declared in the template  
- Parameters — the dynamic inputs for your template  
- Mappings — the static variables for your template  
- Outputs — references to what has been created  
- Conditionals — list of conditions to perform resource creation  
  
Templates helpers  
- References  
- Functions  
  
CloudFormation — Resources  
  
- Resources are the core of your CloudFormation template (Mandatory)  
- They reference the different AWS components that will be created and configured  
- Resources are declared and can reference each other  
- AWS figures out creation, updates and deletes of resources for us  
- There are over 700 types of resources   
- Resource type identifiers are of the form  
    - Service-provider::service-name::data-type-name  
  
You can create a dynamic number of resources using CloudFormation Macros and Transform.  
  
CloudFormation — Parameters  
  
- Parameters are a way to provide inputs to your AWS CloudFormation template  
- They’re important to know about if:  
    - You want to reuse your templates across the company  
    - Some inputs can not be determined ahead of time  
- Parameters are extremely powerful, controlled and can prevent errors from happening in your templates, thanks to types  
  
Parameters:  
	SecurityGroupDescription:  
		Description: Security Group Description  
		Type: String  
  
Parameter settings:  
- Type:  
    - String  
    - Number  
    - CommadDelimitedList  
    - List<Number>  
    - AWs-Specific Parameter (to help catch invalid values — match against existing values in the AWS account)  
    - List<AWS-Specific Parameter>  
    - SSM Parameter (get parameter value from SSM Parameter Store)  
- Description  
- ConsraintDescription(String)  
- Min/MaxLength  
- Min/MaxValue  
- Default  
- AllowedValues (array)  
- AllowedPattern (regex)  
- NoEcho (Boolean)  
  
AllowedValues:  
  
Parameters:  
	InstanceType:  
		Description: Choose an EC2 instance type  
		Type: String  
		AllowedValues:  
			- t2.micro  
			- t2.small  
			- t2.medium  
		Default: t2.micro  
  
Resources:  
	MyEC2Instance:  
		Type: AWS::EC2::Instance  
		Properties:  
			InstanceType: !Ref InstanceType  
			ImageId: ami-0c02f…  
  
References:  
  
Resources:  
    DBSubnet1:  
	 Type: AWS::EC2::Subnet  
	 Properties:  
              VpcId: !Ref MyVPC  
  
CloudFormation — Pseudo Parameters  
  
- Can be used at any time and are enabled by default  
  
AWS::AccountId  
AWS::Region  
AWS::StackId  
AWS::StackName  
AWS::NotificationARNs  
AWS::NoValue  
  
CloudFormation — Mappings  
  
- Mappings are fixed variables within your CloudFormation template  
- They’re very handy to differentiate between deferent environments  
- All the values are hard coded in the template  
  
Mappings:  
	Mapping01:  
		Key01:  
			Name: Value01  
  
RegionMap:  
	us-east-1:  
		HVM64: ami-off8a915…  
  
Resources:  
	MyEC2Instance:  
		Type: AWS::EC2::Instance  
		Properties:  
			ImageId: !FindMap [RegionMap, !Ref ”AWS::Region”, HVM64]  
  
CloudFormation — Outputs  
  
- The Outputs section declares optional output values that we can import into other stacks (if you export them first)  
- You can also view the outputs in the AWS Console or in using the AWS CLI  
- They’re very useful for example if you define a network CloudFormation, and output the variables such as VPC ID and your Subnet IDSs  
- It’s the bets way to perform some collaboration cross stack, as you let export handle their own part of the stack  
  
Outputs:  
	StackSSHSecurityGroup:  
		Description: The SSH Security Group  
		Value: !Ref MyCompanyWideSSHSecruityGroup  
		Export:  
			Name: SSHSecurityGroup  
  
Resources:  
	MySecureInstance:  
		Type: AWS::EC2::Instance  
		Properties:  
			ImageId: ami-…  
			InstanceType: t2.micro  
			AvailabilityZone: us-east-1a  
			SecurityGroups:  
				- !ImportValue SSHSecurityGroup  
  
CloudFormation — Conditions  
  
- Conditions are used to control the creation of resource for output based on a condition  
- Conditions can be whatever you want them to be, but common ones are:  
    - Environment (dev / test / prod)  
    - AWS Region  
    - Any parameter value  
- Each condition can reference another condition, parameter value or mapping  
  
Conditions:  
	CreateProdResources: !Equals [!Ref EnvType, prod]  
  
Fn::And  
Fn::Equals  
Fn::If  
Fn::Not  
Fn::Or  
  
Resources:  
	MountPoint:  
		Type: AWS::EC2::VolumeAttachment  
		Condition: CreateProdResources  
  
CloudFormation — Intrinsic Functions  
  
- Ref  
- Fn::GetAtt  
- Fn::FindInMap  
- Fn::ImportValue  
- Fn::Join  
- Fn::Sub  
- Fn::ForEach  
- Fn::ToJsonString  
- Condition Functions:  
    - Fn::If, Fn::Not, Fn::Equals. Etc...  
- Fn::Base64  
- Fn::Cidr  
- Fn::GetAZs  
- Fn::Select  
- Fn::Split  
- Fn::Transform  
- Fn::Length  
  
!Base64 “ValueToEncode”  
  
Resources:  
	WebServer:  
		Type: AWS::EC2::Instance  
		Properties:  
			UserData:  
				Fn::Base64: |  
					#!/bin/bash  
 					dns update -y  
 					dns install -y httpd  
  
CloudFormation — Rollbacks  
  
- Stack Creation Fails:  
    - Default: everything rolls back (gets deleted) we can look at the log  
    - Option to disable rollback and troubleshoot what happened  
- Stack Update Fails:  
    - The stack automatically rolls back to the previous known working state  
    - Ability to see in the log what happened and error messages  
- Rollback Failure? Fix resources manually then issue ContinueUpdateRollback API from Console  
  
CloudFormation — Service Role  
  
- IAM role that allows CloudFormation to create/update/delete stack resources on your behalf  
- Give ability to users to create/update/delete the stack resources even if they don’t have permissions to work with the resources in the stack  
- Use cases:  
    - You want to achieve the least privilege principle   
    - But you don’t want to give the user all the required permissions to create the stack resources  
  
CloudFormation — Capabilities  
  
- CAPABILITY_NAMED_IAM and CAPABILITY_IAM  
    - Necessary to enable when your CloudFormation template is creating or updating IAM resources (IAM User, Role, Group, Policy, Access Keys, Instance Profile)  
    - Specify CAPABILITY_NAMED_IAM if the resources are named  
- CAPABILITY_AUTO_EXPAND  
    - Necessary when your CloudFormation template includes Macros or Nested Stacks (stack within stacks) to perform dynamic transformations  
    - You’re acknowledging that your template may change before deploying  
- InsufficientCapabilitiesException  
    - Exception that will be thrown by CLoudFormation if the capabilities haven’t been acknowledged when deploying a template (security measure)  
  
CloudFormation — DeletionPolicy Delete  
  
- DeletionPolicy:  
    - Control what happens when the CloudFormation template is deleted or when a resource is removed from a CloudFormation template  
    - Extra safety measure to preserve and backup resources  
    - Default DeletionPolicy=Delete  
        - Delete won’t work on an S3 bucket if the bucket is not empty  
  
Resources:  
	MyS3Bucket:  
		Type: AWS::S3::Bucket  
		DeletionPolicy: Delete  
  
CloudFormation — DeletionPolicy Snapshot  
  
- DeletionPolicy=Snapshot  
- Create on final snapshot before deleting the resource  
- Examples of supported resources:  
    - EBS Volume, ElastiCache Cluster, ElastiCache ReplicationGroup  
    - RDS DBInstance, RDS DBCluster, DocumentDB DBCluster  
  
Resources:  
	MYDBInstance:  
		Type: AWS::RDS::DBInstance  
		Properties:  
			DBInstanceClass: db.t2.micro  
			AllocatedStorage: 20  
			Engine: mysql  
			MasterUsername: admin  
			MasterUserPassword: “ExamplePassword”  
		DeletionPolicy: Snapshot  
  
CloudFormation — Stack Policies  
  
- During a CloudFormation Stack update, all update actions are allowed on all resources (default)  
- A Stack Policy is a JSON document that defines the update actions that are allowed on specific resources during Stack updates  
- Protect resources from unintentional updates  
- When you set a Stack Policy, all resources in the Stack are protected by default  
- Specify an explicit ALLOW for the resources you want to be allowed to be updated  
  
{  
  “Statement”: [  
    {         “Effect”: “Allow”,  
       “Action”: “Update:*”,  
       “Principle”: “*”,  
       “Resource”: “*”     },   {         “Effect”: “Deny”,  
       “Action”: “Update:*”,  
       “Principle”: “*”,  
       “Resource”: “LogicalResourceId/ProductionDatabase”     }  
  ]  
}  
  
Allow updates on all resources except the ProductionDatabase.  
  
CloudFormation — Termination Protection  
  
- To prevent accidental deletes of CloudFormation Stacks, use TerminationProtection  
  
CloudFormation — Custom Resources  
  
- Used to:  
    - Define resources not yet supported by CloudFormation  
    - Define custom provisioning logic for resources that can be outside of CloudFormation (on-premises resources, 3rd party resources…)  
    - Have custom scripts run during create / update / delete through Lambda functions (running a Lambda function to empty an S3 Bucket before being deleted)  
- Defined in the template using  
    - AWS::CloudFormation::CustomResource or  
        - Custom::MyCustomResourceTypeName (recommended)  
- Backed by a Lambda function (most common) or an SNS topic  
  
Resources:  
	MyCustomResourceUsingLambda:  
		Type: Custom::MyLambdaResource  
		Properties:  
			ServiceToken: arn:aws:lambda:REGION:ACCOUNT_ID:function:FUNCTION_NAME  
			ExampleProperty: “ExampleValue”  
Use case:  
- You can’t delete a non-empty S3 bucket  
- To delete a non-empty S3 bucket, you must first delete all the objects inside it  
- We can use a custom resource to empty an S3 bucket before it gets deleted by CloudFormation  
  
CloudFormation — StackSets  
  
- Create, update, or delete stacks across multiple accounts and regions with a single operation / template  
- Target accounts to create, update, delete stack instances from StackSets  
- When you update a stack set, all associated stack instances are updated throughout all accounts and regions  
- Can be applied into all accounts of an AWS Organisation  
- Only Administrator account (or Delegated Administrator) can create StackSets  
  
https://docs.amazon.com/AWSCloudFormation/latest/UserGuide/aws-template-reosurce-type-ref.html  
https://docs.amazon.com/AWSCloudFormation/latest/UserGuide/aws-template-reosurce-ec2-instance.html  
