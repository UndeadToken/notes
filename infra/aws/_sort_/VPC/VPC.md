VPC  
  
- VPC is something you should know in depth for the AWS Certified solutions Architect Associate & AWS Certified SysOps Administrator  
  
- At the AWS Certified Developer Level, you should know about:  
    - VPC, Subnets, Internet Gateways & NAT Gateway  
    - Security Groups, Network ACL (NACL), VPC Flow Logs  
    - VPC Peering, VPC Endpoints  
    - Site to Site VPN & Direct Connect  
  
- I will just give you an overview, less than 1 or 2 questions at your exam  
- Later in the course, I will be highlighting when VPC concepts are helpful  
  
VPC & Subnets  
  
- VPC: private network to deploy your resources (regional resource)  
- Subnets allow you to partition your network inside your VPC (Availability Zone Resource)  
- A public subnet is a subnet that is accessible from the internet  
- A private subnet is a subnet that is not accessible from the internet  
- To define access to the internet and between subnets, we use Route Tables  
  
When you use your VPC that is created for you on AWS you only have public subnets you don’t have private subnets. You have one public subnet per AZ. You have one VPC in every region that’s created for you called the default VPC.  
  
Internet Gateway & NAT Gateways  
  
- Internet Gateways help our VPC instances connect with the internet  
- Public Subnets have a route to the internet gateway  
- NAT Gateways (AWS-managed) & NAT instances (self-managed) allow your instances in your Private Subnets to access the internet while remaining private  
  
Network ACL & Security Groups  
  
ENI: Elastic Network Interface  
  
When you have a default VPC the default NACL allows everything in and everything out. Before internet traffic reaches your instance it has to go though this NACL.  
  
- NACL (Network ACL)  
    - A firewall which controls traffic from and to subnet  
    - Can have ALLOW and DEBY rules  
    - Are attached at the Subnet level  
    - Rules only include IP addresses  
- Security Groups  
    - A firewall that controls traffic to and from an ENI / an EC2 instance  
    - Can have only ALLOW rules  
    - Rules include IP addresses and other security groups  
  
Security Group	Network ACL  
Operates at the instance level	Operates at the subnet level  
Supports allow rules only	Supports allow rules and deny rules  
Is Stateful: Return traffic is automatically allowed, regardless of any rules	Is Stateless: Return traffic must be explicitly allowed by rules  
We evaluate all rules before deciding whether to allow traffic	We process rules in number order when deciding whether to allow traffic  
Applies to an instance only if someone specifies the security group the. Launching the instance, or associates the security group with the instance later on	Automatically applies to all instances in the subnets it’s associated with (therefore, you don’t have to rely on users to specify the security group)  
https://docs.aws.amazon.com/vpc/latest/userguide/VPC_Security.html#VPC_Security_Comparison  
  
VPC Flow Logs  
  
- Capture information about IP traffic going into your interfaces  
    - VPC Flow Logs  
    - Subnet Flow Logs  
    - Elastic Network Interface Flow Logs  
- Helps to monitor & troubleshoot connectivity issues: Example:  
    - Subnets to internet  
    - Subnets to subnets  
    - Internet to subnets  
- Captures network information from AWS managed interfaces too: Elastic Load Balancers, ElastiCache, RDS, Aurora, etc…  
- VPC Flow Logs data can go to S3, CloudWatch Logs, and Kinesis Data Firehose  
  
VPC Peering  
  
- Connect two VPC, privately using AWS’ network  
- Make them behave as if they were in the same network  
- Must not have overlapping CIDR (IP address range)  
- VPC Peering connection is not transitive (must be established for each VPC that need to communicate with one another)  
  
VPC Endpoints  
  
All AWS services are public. Anytime AWS instances use the AWS services they talk publicly to AWS. Sometimes your instances are not connected to the public subnet and sometimes you want them to access privately your aws services.  
  
- Endpoints allow you to connect to AWS Services using a private network instead of the public www network  
- This gives you enhanced security and lower latency to access AWS services  
- VPC Endpoint Gateway: S3 & DynamoDB  
- VPC Endpoint Interface: the rest  
- Only used within your VPC  
  
Site to Site VPN & Direct Connect  
  
- Site to Site VPN  
    - Connect an on-premises VPN to AWS  
    - The connection is automatically encrypted  
    - Goes over the public internet  
- Direct Connect (DX)  
    - Establish a physical connection between on-premises and AWS  
    - The connection is private, secure and fast  
    - Goes over a private network  
    - Takes at lest a month to establish  
  
- VPC: Virtual Private Cloud  
- Subnets: Tied to an AZ, network partition of the VPC  
- Internet Gateway: at the VPC level, provide Internet Access  
- NAT Gateway / Instances: give internet access to private subnets  
- NACL: Stateless, subnet rules for inbound and outbound  
- Security Groups: Stateful, operate at the EC2 instance level or ENI  
- VPC Peering: Connect two VPC with non overlapping IP ranges, non transitive  
- VPC Endpoints: Provide private access to AWS Services within VPC  
- VPC Flow Logs: network traffic logs  
- Site to Site VPN: VPN over public internet between on-premises DC and AWS  
- Direct Connect: direct private connection to AWS  
  
Three-tier Architecture:  
  
Public Subnets > Private Subnets > Data Subnet  
  
User > ELB (Deployed in Public subnets) using Route53, sitting in an ELB deployed in a private subnet -> public subnet to private subnet > Data Subnet (Amazon RDS Read / write data, ElasticCache - store / retrieve data)  
  
LAMP stack on EC2  
  
- Linux: OS for EC2 instances  
- Apache: Web Server that run on Linux (EC2)  
- MySQL: database on RDS  
- PHP: Application logic (running on EC2)  
  
- Can add Redis / Memcached (ElastiCache) to includea caching tech  
- To store local application data & software: EBS drive (root)  
  
  
