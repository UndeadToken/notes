ELB & ASG - Elastic Load Balancing & Auto Scaling  
  
- Scalability means that an application / system can handle greater loads by adapting  
- There are two kinds of scalability:  
    - Vertical Scalability  
    - Horizontal Scalability (= elasticity)  
- Scalability is linked but different to High Availability  
  
Vertical Scalability  
  
- Vertical Scalability means increasing the size of the instance  
- For example, your application runs on a t2.micro  
- Scaling that application vertically means running it on a t2.large  
- Vertical scalability is very common for non distributed systems, such as a database  
- There’s a limit to how much you can vertically scale (hardware limit)  
  
Horizontal Scalability  
  
- Horizontal Scalability means increasing the number of instances / systems for your application  
- Horizontal scaling implies distributed systems  
- This is very common for web applications / modern applications  
- It’s east to horizontally scale thanks to the cloud offerings such as Amazon EC2  
  
High Availability  
  
- High Availability usually goes hand in hand with horizontal scaling  
- High Availability means running your application / system in at least 2 Availability Zones  
- The goal of a high availability is to survive a data centre loss (disaster)  
  
High Availability & Scalability for EC2  
  
Vertical Scaling: Increase instance size (= scale up / down)  
  
- From: t2.nano - 0.5G of RAM, 1 vCPU  
- To: u-12tb1.metal - 12.3TB of RAM, 448 vCPUs  
  
Horizontal Scaling: Increase number of instances (= scale out / in)  
  
- Auto Scaling Group  
- Load Balancer  
  
High Availability: Run instances for the same application across multi AZ  
  
- Auto Scaling Group multi AZ  
- Load Balancer multi AZ  
  
Scalability vs Elasticity (vs Agility)  
  
Scalability  
  
Ability to accommodate a larger load by making the hardware stronger (scale up), or by adding nodes (scale out)  
  
Elasticity  
  
Once a system is scalable, elasticity means that there will be some “auto-scaling” so that the system can scale based on the load. This is cloud-friendly: pay-per-use, match demand, optimize costs.  
  
Agility  
  
(Not related to scalability - distractor) new IT resources are only a click away, which means that you reduce the time to make those resources available to your developers from weeks to just minutes.  
  
Load Balancing  
  
Load balancers are servers that forward internet traffic to multiple servers (EC2 instances) downstream.  
  
- Spread load across multiple downstream instances  
- Expose single single point of access (DNS) to your application  
- Seamlessly handle failures of downstream instances  
- Do regular health checks to your instances  
- Provide SSL termination (HTTPS) for your websites  
- High availability across zones  
  
An ELB (Elastic Load Balancer) is a managed load balancer.  
  
- AWS guarantees that it will be working  
- AWS takes care of upgrades, maintenance, high availability  
- AWS provides only a few configuration knobs  
  
It costs less to setup your own load balancer but it will be a lot more effort on your end (maintenance, integrations)  
  
There are 4 kinds of load balancers offered by AWS:  
  
- Application Load Balancer (HTTP / HTTPS only) — Layer 7  
- Network Load Balancer (Ultra-high performance, allows for TCP) — Layer 4  
- Gateway Load Balancer — Layer 3  
- Classic Load Balancer (retired in 2023) — Layer 4 & 7  
  
Health Checks  
  
- Health Checks are crucial for Load Balancers  
- They enable the load balancer to know if instances it forwards traffic to are available to reply to requests  
- The health check is done on a port and a route (/health is common)  
- If the response is not 200 (OK), then the instance is unhealthy  
  
Classic Load Balancer  
(V1 — old generation) — 2009 — CLB, HTTP, HTTPS, TCP, SSL (secure TPC)  
  
Application Load Balancer (ALB)  
(V2 — new generation) — 2016 — ALB, HTTP, HTTPS, Websocket  
  
Fixed hostname (XXX.region.elb.amazonaws.com). The application servers don’t see the IP of the client directly. The true IP of the client is inserted in the header X-Forwarded-For. We can also get Port (X-Forwarded-Port) and Port (X-Forwarded-Proto).  
  
EC2 Instances (can be managed by an Auto Scaling Group) — HTTP. EC2 tasks (managed by ECS itself) — HTTP. Lambda functions — HTTP request is translated into a JSON event. IP Addresses — must be private IP’s. ALB can route to multiple target groups. Health checks are at the target group level.  
  
- Load balancing ti multiple HTTP applications across machines (target groups)  
- Load balancing to multiple applications on the same machine (containers)  
- Support HTTP/2 and WebSocket  
- Support redirects (from HTTP to HTTPS for example)  
- HTTP / HTTPS / gRPC protocols (Layer 7)  
- HTTP Routing features  
- Static DNS (URL)  
  
Routing tables to different target groups:  
	- Routing based on path in URL (/users & example.com/posts)  
 	- Routing based on hostname in URL (one.example.com & other.example.com)  
	- Routing based on Query string, Headers (example.com/users?id=123&order=false)  
  
ALB are a great fit for micro services & container-based application (Docker & Amazon ECS). Has a Port mapping feature to redirect to a dynamic port in ECS. In comparison, we’d need multiple Classic Load Balancer per application.  
  
Network Load Balancer (NLB)  
(V2 — new generation) — 2017 — NLB, TCP, TLS (Secure TCP), UDP  
  
Forward TCP & UDP traffic to your instances. Handle millions of requests per second. Less latency ~100ms (vs 400 ms for ALB). NLB has one static IP per AZ, and supports assigning Elastic IP. (Helpful for whitelisting specific IP). NLB are used for extreme performance, TCP or UDP traffic. Not included in the AWS free tier.  
  
- TCP / UDP protocols (Layer 4)  
- High Performance: millions of requests per second  
- Static IP through Elastic IP  
  
Target Groups:  
  
- EC2 Instances  
- IP Addresses — must be private IP’s  
- Application Load Balancer  
- Health Checks support the TCP,HTTP and HTTPS Protocols  
  
Gateway Load Balancer (GWLB)  
(V2 — new generation) — 2020 — GWLB, IP  
  
Deploy, scale and manage a fleet of 3rd party network virtual appliances in AWS. Firewalls, Intrusion Detection Prevention Systems, Deep Packet Inspection. Combines the following functions: Transparent Network Gateway — single entry/exit for all traffic. Load Balancer — distributes traffic to your virtual appliances.  
  
- GENEVE Protocol on IP Packets (Layer 3)  
- Route Traffic to Firewalls that you manage on EC2 Instances  
- Intrusion detection  
  
Target Groups:  
  
- EC2 Instances  
- IP Addresses — must be private IP’s  
  
Cross-Zone Load Balancing  
  
With Cross Zone Load Balancing each load balancer instance distributes evenly across all registered instances in all AZ. Requests are distributed in the instances of the node of the Elastic Load Balancer.  
  
- Application Load Balancer:  
    - Enabled by default (can be disabled at the Target Group level)  
    - No charges for inter AZ data  
  
- Network Load Balancer & Gateway Load Balancer:  
    - Disabled by default  
    - You pay charges ($) for inter AZ data if enabled  
  
- Classic Load Balancer:  
    - Disabled by default  
    - No charges for inter AZ data if enabled  
  
Auto Scaling  
  
CloudWatch Alarms & Scaling  
  
- It is possible to scale an ASG based on CloudWatch alarms  
- An alarm monitors a m metric (such as Average CPU, or a custom metric)  
- Metrics such as Average CPU are computed for the overall ASG instances  
- Based on the alarm:  
    - We can create scale-out policies (increase the number of instances)  
    - We can create scale-in policies (decrease the number of instances)  
  
Auto Scaling Group Attributes  
  
- A Launch Template (older “Launch Configurations” are deprecated)  
    - AMI + Instance Type  
    - EC2 User Data  
    - EBS Volume  
    - Security Groups  
    - SSH Key Pair  
    - IAM Roles for your EC2 Instances  
    - Network + Subnets Information  
    - Load Balancer Information  
- Min Size / Max Size / Initial Capacity  
- Scaling Policies  
  
Auto Scaling Groups  
  
What is an Auto Scaling Group?  
  
- In real-life, the load on your websites and application can change  
- In the cloud, you can create and get rid of servers very quickly  
- The goal of an Auto Scaling Group (ASG) is to:  
    - Scale out (add EC2 instances) to match an increased load  
    - Scale in (remove EC2 instances) to match a decreased load  
    - Ensure we have a minimum and a maximum number of machines running  
    - Automatically register new instances to a load balancer  
    - Replace unhealthy instances  
- Cost Savings: only run at an optimal capacity (principle of the cloud)  
- ASG’s are free (you only pay for the underlying EC2 instances)  
  
Auto Scaling Group:   
Minimum Size, Actual Size / Desired Capacity, Maximum Size  
  
Auto Scaling Groups — Scaling Strategies  
  
- Manual Scaling: Update the size of an ASG manually  
- Dynamic Scaling: Respond to changing demand  
    - Simple / Step Scaling  
        - When a CloudWatch alarm is triggered (example CPU > 70%), then add 2 units  
        - When CloudWatch alarm is triggered (example CPU < 30%), then remove 1  
    - Target Tracking Scaling  
        - Example: I want the average ASG CPU to stay at around 40%  
    - Scheduled Scaling  
        - Anticipate a scaling based on known usage patterns  
        - Example: increase the min. Capacity to 10 at 5pm on Fridays  
    - Predictive Scaling  
        - Uses Machine Learning to predict future traffic ahead of time  
    - Automatically provisions the right number of EC2 instances in advance  
  
Auto Scaling Groups — Scaling Policies  
  
- Predicate Scaling: continuously forecast load and schedule scaling ahead (Analyse load, Generate forecast, Schedule scaling actions)  
  
- Dynamic Scaling:   
    - Target Tracking Scaling:   
        - Simple to set-up  
        - Example: I want the average ASG CPU to stay at around 40%  
    - Simple / Step Scaling:  
        - When a CloudWatch alarm is triggered (example CPI > 70%), then add 2 units  
        - When a CloudWatch alarm is triggered (example CPI < 30%), then remove 1  
  
- Scheduled Scaling:  
    - Anticipate a scaling based on known usage patterns  
    - Example: increase the min capacity to 10 at 5 pm on Fridays  
  
Autoscaling — Instance Refresh  
  
- Goal: update launch template and then re-creating all EC2 instances  
- For this we can use the native feature of Instance Refresh  
- Setting the minimum healthy percentage  
- Specify warm-up time (how long until the instance is ready to use)  
  
Auto Scaling Groups — Scaling Cooldowns  
  
- After a scaling activity happens, you are in the cooldown period (300 seconds)  
- During the cooldown period, the ASG will not launch or terminate additional instances (to allow for metrics to stabalise)  
- Advice: Use a ready-to-use AMI to reduce configuration time in order to be serving requests faster and reduce the cooldown  
  
Good metrics to scale on:  
  
- CPUUtilization: Average CPU utilisation across your instances  
- RequestCountPerTarget: to make sure the number of requests per EC2 instances is stable  
- Average Network In/Out (if you’re application is network bound)  
- Any custom metric (that you push using CloudWatch)  
  
Connection Draining  
  
- Feature naming:  
    - Connection Draining — for CLB  
    - Deregistration Delay — for ALB & NLB  
- Time to compute “in-flight requests” while the instance is de-registering or unhealthy  
- Stops sending new requests to the EC2 instance which is re-registering  
- Between 1 to 3600 seconds (default: 300 seconds)  
- Can be disabled (set value to 0)  
- Set to low value if your requests are short  
  
Elastic Load Balancers — SSL Certificates  
  
The load balancer uses an X.509 certificate (SSL/TLS server certificate). You can manage certificates using ACM (AWS Certificate Manager). You can create or upload your own certificates alternatively.  
  
An SSL Certificate allows traffic between your clients and your load balancer to be encrypted in transit (in-flight encryption). SSL refers to Secure Sockets Layer, used to encrypt connections. TLS refers to Transport Layer Security, which is a newer version. Nowadays, TLS certificates are mainly used, nut people still refer as SSL. Public SSL certificates are issued by Certificate Authorities (CA). SSL Certificates have an expiration date (you set) and must be renewed.  
  
HTTPS listener:  
  
- You must specify a default certificate  
- You can add an optional list of certs to support multiple domains  
- Clients can use SNI (Server Name Indication) to specify the hostname they reach  
- Ability to specify a security policy to support older versions of SSL / TLS (legacy clients)  
  
Classic Load Balancer (v1)  
  
- Support only one SSL certificate  
- Must use multiple CLB for multiple hostname with multiple SSL certificates  
  
Application Load Balancer (v2)  
  
- Supports multiple listeners with multiple SSL certificates  
- Uses Server Name Indication (SNI) to make it work  
  
Network Load Balancer (v2)  
  
- Supports multiple listeners with multiple SSL certificates  
- Uses Server Name Indication (SNI) to make it work  
  
SSL — Server Name Indication (SNI)  
  
- SNI solves the problem of loading multiple SSL certificates onto one web server (to serve multiple websites)  
- It’s a newer protocol and requires the client to indicate the hostname of the target server in the initial SSL handshake  
- The server will then find the correct certificate, or return the default one  
  
Note: Only works for ALB & NLB (newer generation), CloudFront and does not work for CLB (older gen)  
  
Sticky Sessions (Session Affinity)  
  
- It is possible to implement stickiness so that the same client is always redirected to the same instance behind a load balancer.  
- This works for Classic Load Balancer, Application Load Balancer, and Network Load Balancer  
- The “Cookie” used for stickiness has an expiration date you control  
- Use case: make sure the user doesn’t lose session data  
- Enabling stickiness may bring imbalance to the load over the backend EC2 instances  
  
Cookie Names  
  
- Application-based Cookies  
    - Custom Cookie  
        - Generated by target  
        - Can include any custom attributes required by the application  
        - Cookie name must be specified individually for each target group  
        - Don’t use AWSALB, AWSALBAPP, or AWSALBTG (reserved for use by the ELB)  
    - Application Cookie  
        - Generated by the load balancer  
        - Cookie name is AWSALBAPP  
- Duration-based Cookies  
    - Cookie generated by the load balancer  
    - Cookie name is AWSALB for ALB, AWSELB for CLS  
  
