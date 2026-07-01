S3 - Infinity Scaling Storage  
  
Amazon S3 is one of the main building blocks of AWS.  
  
- Backup and Storage  
- Disaster Recovery  
- Archive  
- Hybrid Cloud Storage  
- Application hosting  
- Media hosting  
- Data lakes &. Big data analytics  
- Software delivery  
- Static website  
  
Nasdaq stores 7 years of data into S3 Glacier.  
Sysco runs analytics on its data and gain business insights.  
  
S3: Buckets  
  
- Amazon S3 allows people to store objects (files) in “buckets” (directories)  
- Buckets must have a globally unique name (across all regions all accounts)  
- Buckets are defined at the region level  
- S3 looks like a global service but buckets are created in a region  
  
S3 Buckets Naming Convention  
  
- No uppercase, No underscore  
- 3-63 characters long  
- Not an IP  
- Must start with lowercase letter or number  
- Must NOT start with the prefix xn—  
- Must NOT end with the suffix -s3alias  
  
S3: Objects  
  
- Objects (files) have a Key  
- The Key is the FULL path:  
    - s3://my-bucket/my_file.txt  
    - s3://my-bucket/my_folder/another_folder/my_file.txt  
- The Key is composed of prefix + object_name  
- There’s no concept of “directories” within buckets (although the UI will trick you to think otherwise)  
- Just keys with very long names that contain slashes (“/”)  
- Object values are the content of the body:  
    - Max. Object Size is 5TB (5000 GB)  
    - If uploading more than 5GB, must use “multi-part upload”  
- Metadata (list of text key / value pairs — system or user metadata)  
- Tags (unicode key / value pair — up to 10) — useful for security / lifecycle  
- Version ID (if versioning is enabled)  
  
S3: Bucket Security  
  
- User-Based  
    - IAM Policies — which API calls should be allowed for a specific user from IAM  
- Resource-Based  
    - Bucket Policies — bucket wide rules from the S3 console - allows cross account  
    - Object Access Control List (ACL) — finer grain (can be disabled)  
    - Bucket Access Control List (ACL) — less common (can be disabled)  
- Note: an IAM principle can access an S3 object if:  
    - The user IAM permissions ALLOW it OR the resource policy ALLOWS it  
    - AND there’s no explicit DENY  
- Encryption: encrypt objects in Amazon S3 using encryption keys  
  
S3: Bucket Policies  
  
- JSON based policies  
    - Resources: buckets and objects  
    - Effect: Allow/ Deny  
    - Actions: Set of API to Allow or Deny  
    - Principle: The account or user to apply the policy to  
  
Use S3 bucket for policy to:  
- Grant public access to the bucket  
- Force objects to be encrypted at upload  
- Grant access to another account (Cross Account)  
  
Permissions:  
- Assign IAM permissions to an IAM policy  
- EC2 Instance Roles / IAM Roles  
- Cross-Account Access using Bucket Policy  
  
{  
  “Version”: “2012-10-17”,  
  “Statement”: [  
    {  
      “Sid”: “PublicRead”,  
      “Effect”: “Allow”,  
      “Principle”: “*”,  
      “Action”: [  
        “s3:GetObject”  
      ],  
     “Resource”: [  
        “arn:aws:s3:::example bucket/*”  
     ]  
    }  
  ]  
}  
  
S3: Static Website Hosting  
  
S3 can host static websites and have them accessible on the internet. If you get a 403 Forbidden error, make sure the bucket policy allows public reads.  
  
The website URL will be (depending on the region):  
- http://bucket-name.s3-website-aws-region.amazonaws.com  
- http://bucket-name.s3-website.aws-region.amazonaws.com  
  
S3: Versioning  
  
Any file that is not versioned prior to enabling versioning will have version “null”. Suspending versioning does not delete the previous versions.  
  
- You can version your files in Amazon S3  
- It is enabled at the bucket level  
- Same key overwrite will change the “version”: 1, 2, 3…  
- It is best practice to version your buckets  
    - Protect against unintended deletes (ability to restore a version)  
    - Easy to roll back to previous version  
  
S3: Replication (CRR & SRR)  
- Must enable versioning in source and destination buckets  
- Cross-Region Replication (CRR)  
- Same-Region Replication (SRR)  
- Buckets can be in different AWS accounts  
- Copying is asynchronous  
- Must give proper IAM permissions to S3  
  
Use Cases:  
  
- CRR - compliance, lower latency access, replication across accounts  
- SRR - log aggregation, live replication between production and test accounts  
  
Notes  
  
- After you enable Replication, only new objects are replicated  
- Optionally, you can replicate existing objects using S3 Batch Replication  
    - Replicates existing objects that failed replication  
- For DELETE operations  
    - Can replicate delete markers from source to target (optional setting)  
    - Deletions with version ID are not replicated (to avoid malicious deletes)  
- There is no “chaining” of replication  
    - If bucket 1 has replication into bucket 2, which has replication into bucket 3  
    - Then objects created in bucker 1 are not replicated to bucket 3  
  
S3: Storage Classes  
  
Can move between classes manually or using S3 Lifecycle configurations.  
  
- Amazon S3 Standard - General Purpose  
- Amazon S3 Standard-Infrequent Access (IA)  
- Amazon S3 One Zone-Infrequent Access  
- Amazon S3 Glacier Instant Retrieval  
- Amazon S3 Glacier Deep Archive  
- Amazon S3 Intelligent Tiering  
  
Durability  
  
- High durability (99.99% | | 9’s) of objects across multiple AZ  
- If you store 10,000,000 objects with Amazon S3, you can on average expect to incur a loss of a single object once every 10,000 years  
- Same for all storage classes  
  
Availability  
  
- Measures how readily available a service is  
- Varies depending on storage class  
- Example: S3 standard has 99.99% availability = not available 53 minutes a year  
  
S3: Storage Class: General Purpose  
  
- 99.99% Availability  
- Used for frequently accessed data  
- Low latency and high throughput  
- Sustain 2 concurrent facility failures  
- Use Cases: Big Data analytics, mobile & gaming applications, content distribution…  
  
S3: Storage Class: Infrequent Access  
  
For data that is less frequently accessed, but requires rapid access when needed. Lower cost than S3 Standard.  
  
Amazon S3 Standard-Infrequent Access (S3 Standard-IA):  
  
- 99.9% Availability  
- Use cases: Disaster Recovery, backups  
  
Amazon S3 One Zone-Infrequent Access (S3 One Zone-IA):  
  
- High durability (99.99%) in a single AZ; data lost when AZ is destroyed  
- 99.5% Availability  
- Use Cases: Storing secondary backup copies of on-premise data, or data you can recreate  
  
S3: Storage Class: Glacier  
  
Low-cost object storage meant for archiving / backup. Pricing: price for storage + object retrieval cost.  
  
Amazon S3 Glacier Instant Retrieval:  
- Millisecond retrieval, great for data accessed once a quarter  
- Minimum storage duration of 90 days  
  
Amazon S3 Glacier Flexible Retrieval (formerly Amazon S3 Glacier):  
- Expedited (1 to 5 minutes), Standard (3 to 5 hours), Bulk (5 to 12 hours) — free  
- Minimum storage duration of 90 days  
  
Amazon S3 Glacier Deep Archive — for long term storage:  
- Standard (12 hours), Bulk (48 hours)  
- Minimum storage duration of 180 days  
  
S3 Intelligent-Tiering  
  
- Small monthly monitoring and auto-tiering fee  
- Moves objects automatically between Access Tiers based on usage  
- There are no retrieval charges in S3 Intelligent-Tiering  
- Frequent Access tier (automatic): default tier  
- Infrequent Access tier (automatic): object not accessed for days  
- Archive Instant Access tier (automatic): objects not accessed for 90 days  
- Archive Access tier (optional): configurable from 90 days to 700+ days  
  
S3: Encryption  
  
- Server side encryption is always on  
- Server side encryption the object is encrypted on the server  
- Client side encryption the object is encrypted on the client  
  
You can encrypt objects in S3 buckets using one of 4 methods.  
  
- Server-Side Encryption (SSE)  
    - Server-Side Encryption with Amazon S3-Managed Keys (SSE-S3) - Enabled by default  
        - Encrypts S3 objects using keys handled, managed, and owned by AWS  
    - Server-Side Encryption with KMS Keys stored in AWS KMS (SSE-KMS)  
        - Leverage AWS Key Management Service (AWS KMS) to manage encryption keys  
    - Server-Side Encryption with Customer-Provided Keys (SSE-C)  
        - When you want to manage your own encryption keys  
    - Client-Side Encryption  
  
Encryption — SSE-S3  
  
- Encryption using keys handled, managed and owned by AWS  
- Object is encrypted server-side  
- Encryption type is AES-256  
- Must set header “x-amz-server-side-encryption”: “AES256”  
- Enabled by default for new buckets & new objects  
  
Encryption — SSE-KMS  
  
If you use SSE-KMS, you may be impacted by the KMS limits. When you upload it calls the GenerateDataKey KMS API. When you download it calls the Decrypt KMS API. Count towards the KMS quota per second (5500, 10000, 30000 req/s based on region). You can request a quota increase using the Service Quotas Console.  
  
- Encryption using keys handled and managed by AWS KMS (Key Management Service)  
- KMS advantages: user control + audit key usage using CloudTrail  
- Object is encrypted server side  
- Must set header “x-amz-server-side-encryption”: “aws:kms”  
  
Encryption — SSE-C  
  
- Server-Side Encryption using keys fully managed by the customer outside of AWS  
- Amazon S3 does not store the encryption key you provide  
- HTTPS must be used  
- Encryption key must be provided in HTTP headers, for every HTTP request made  
  
Encryption — Client-Side Encryption  
  
- Use client libraries such as Amazon S3 Client-Side Encryption Library  
- Clients must encrypt data themselves before sending to Amazon S3  
- Clients must encrypt data themselves when retrieving from Amazon S3  
- Customer fully manages the keys and encryption cycle  
  
Encryption in transit (SSL/TLS)  
  
- Encryption in flight is also called SSL/TLS  
- Amazon S3 exposes two endpoints  
    - HTTP Endpoint — non encrypted  
    - HTTPS Endpoint — encryption in flight  
- HTTPS is recommended  
- HTTPS is mandatory for SSE-C  
- Most clients would use the HTTPS endpoint by default  
  
S3: IAM Access Analyser for S3  
  
- Ensures that only intended people have access to your S3 buckets  
- Example: publicly accessible bucket, bucket shared with other AWS accounts  
- Evaluate S3 Bucket Policies, S3 ACL’s, S3 Access Point Policies  
- Powered by IAM Access Analyzer  
  
Force Encryption in Transit aws:SecureTransport  
DSSE-KMS is just "double encryption based on KMS".  
  
Shared Responsibility Model for S3  
  
AWS  
  
- Infrastructure (global security, durability, availability, sustain concurrent loss of data in two facilities)  
- Configuration and vulnerability analysis  
- Compliance validation  
  
User  
  
- S3 versioning  
- S3 Bucket Policies  
- S3 Replication Setup  
- Logging and Monitoring  
- S3 Storage Classes  
- Data encryption at rest and in transit  
  
AWS Snow Family  
  
- Highly-secure, portable devices to collect and process data at the edge and migrate data into and out of AWS  
- Data migration: Snowcone, Snowball Edge, Snowmobile  
- Edge computing: Snowcone, Snowball Edge  
  
Time to transfer:  
	100 Mbps	1 Gbps	10 Gbps  
10 TB	12 days	30 hours	3 hours  
100 TB	124 days	12 days	30 hours  
1 PB	3 years	124 days	12 days  
Challenges:  
  
- Limited connectivity  
- Limited bandwidth  
- High network cost  
- Shared bandwidth (can’t maximise the line)  
- Connection stability  
  
AWS Snow Family: offline devices to perform data migrations. If it takes more than a week to transfer over the network, use Snowball devices.  
  
Direct upload to S3:  
Client -> 10Gbit/s -> Amazon S3 Bucket  
  
With Snow Family:  
Client -> request AWS snowball device -> ship device -> AWS import / export ->Amazon S3 Bucket  
  
Snowball Edge (for data transfers)  
  
- Physical data transport solution: move TBs or PBs of data in or out of AWS  
- Alternative to moving data over the network (and paying network fees)  
- Pay per data transfer job  
- Provide block storage and Amazon S3-compatible object storage  
- Snowball Edge Storage Optimised  
    - 80 TB of HDD or 210 TB NVMe capacity for block and S3 compatible object storage  
- Snowball Edge Compute Optimised  
    - 42 TB of HDD or 28 TB NVMe capacity for block volume and S3 compatible object storage  
- Use cases: large data cloud migrations, DC decommission, disaster recovery  
  
AWS Snowcode & Snowcone SSD  
  
- Small, portable computing, anywhere, rugged & secure, withstands harsh environments  
- Light (4.5 pounds, 2.1kg)  
- Device used for edge computing, storage, and data transfer  
- Snowcone — 8 TB of HDD Storage  
- Snowcode SSD — 14 TB of SSD Storage  
- Use Snowcone where Snowball does not fit (space-constrained environment)  
- Must provide your own batteries and cables  
- Can be sent back to AWS offline, or connect it to internet and use AWS DataSync to send data  
  
AWS Snowmobile  
  
- Transfer exabytes of data (1 EB = 1,000 PBs = 1,000,000 TBs)  
- Each Snowmobile has 100 PB of capacity (use multiple in parallel)  
- High security: temperature controlled, GPS, 24/7 video surveillance  
- Better than Snowball if you transfer more than 10 PB  
  
Snow Family Usage Process  
  
- Request Snowball device from the AWS console for delivery  
- Install the Snowball client / AWS OpsHub on your servers  
- Connect the Snowball to your servers and copy files using the client  
- Ship back the device when you’re cone (goes to the right AWS facility)  
- Data will be loaded into an S3 bucket  
- Snowball is completely wiped  
  
Edge Computing  
  
- Process at a while it’s being created on an edge location  
    - A truck on the road, a ship on the sea, a mining station underground…  
- These locations may have:  
    - Limited / no internet access  
    - Limited / no easy access to computing power  
- We setup a Snowball Edge / Snowcone device to do edge computing  
- Use cases of Edge Computing  
    - Preprocess data  
    - Machine learning at the edge  
    - Transcoding media streams  
- Eventually (if need be) we can ship back the device to AWS (for transferring data for example)  
  
Snowball Family — Edge Computing  
  
- Snowcone & Snowcone SSD (smaller)  
    - 2 CPU’s, 4 GB of memory, wired or wireless access  
    - USB-C power using a cord or the optional battery  
- Snowball Edge — Compute Optimised  
    - 104 vCPUs, 416 GiB of RAM  
    - Optional GPU (useful for video processing or machine learning  
    - 28 TBB NVMe or 42 TB HDD usable storage)  
    - Storage Clustering available (up to 16 nodes)  
- Snowball Edge — Storage Optimised  
    - Up to 40 vCPUs, 80 Gib of RAM, 80 TB storage  
    - Up to 104 vCPUs, 416 GiB of RAM, 210 TB NVMe storage  
  
All can run EC2 Instances & AWS Lambda functions (using AWS IoT Greengrass)  
  
Long-term deployment options; 1 and 3 years discounted pricing  
  
AWS OpsHub  
  
Historically, to use Snow family devices, you needed a CLI (Command Line Interface tool). Today, you can use AWS OpsHub (a software you need to install on your computer / laptop) to manage your Snow Family device  
  
- Unlocking and configuring single or clustered devices  
- Transferring files  
- Launching and managing instances running on Snow Family Devices  
- Monitor device metrics (storage capacity, active instances on your device)  
- Launch compatible AWS services on your device (ex: Amazon EC2 instances, AWS DataSync, Network File System (NFS))  
  
https://aws.amazon.com/blogs/aws/aws-snowball-edge-update/  
  
Snowball Edge Pricing  
  
You pay for device usage and data transfer out of AWS. Data transfer in to Amazon S3 is $0.00 per GB.  
  
On-Demand:  
  
- Includes a one-time service fee per job, which includes:  
    - 10 days of usage for Snowball Edge Storage optimised 80TB  
    - 15 days of usage for Snowball Edge Storage optimised 210 TB  
- Shipping days are NOT counted towards the included 10 or 15 days  
- Pay per day for any additional days  
  
Committed Upfront:  
  
- Pay in advanced for monthly, 1-year, and 3-years of usage (Edge Computing)  
- Up to 62% discounted pricing  
  
Storage gateway Overview - Hybrid Cloud for Storage  
  
- AWS is pushing for “hybrid cloud”  
    - Part of your infrastructure is on-premises  
    - Part of your infrastructure is on the cloud  
- This can be due to  
    - Long cloud migrations  
    - Security requirements  
    - Compliance requirements  
    - IT Strategy  
- S3 is a proprietary storage technology (unlike EFS / NFS), so how do you expose the S3 data on-premise = AWS Storage Gateway  
  
AWS Storage Cloud Storage Native Options  
  
- Block (Amazon EBS, EC2 Instance Store)  
- FILE (Amazon EFS)  
- Object (Amazon S3, Glacier)  
  
AWS Storage Gateway  
  
- Bridge between on-premise data and cloud data in S3  
- Hybrid storage service to allow on-premises to seamlessly use the AWS Cloud  
- Use cases: disaster recovery, backup & restore, tiered storage  
  
Types of Storage Gateway:  
  
- File Gateway  
- Volume Gateway  
- Tape Gateway  
  
Amazon S3 — Moving Between Storage Classes  
  
- You can transition objects between storage classes  
- For infrequently accessed objects that you don’t need fast access to, move them to Glacier or Glacier Deep Archive  
- Moving objects can be automated using Lifecycle Rules  
  
Amazon S3 — Lifecycle Rules  
  
- Transition Actions — configure objects to transition to another storage class  
    - Move objects to Standard IA class 60 days after creation  
    - Move to Glacier for archiving after 60 months  
- Expiration actions — configure objects to expire (delete) after some time  
    - Access log files can be set to delete after a 365 days  
    - Can be used to delete old versions of files (if versioning is enabled)  
    - Can be used to delete incomplete Multi-Part uploads  
- Rules can be created for a certain prefix (example: s3://mybucket/mp3/*)  
- Rules can be created for certain Tags (example: Department: Finance)  
  
Amazon S3 Analytics — Storage Class Analytics  
  
- Help you decide when to transition objects to the right storage class  
- Recommendations for Standard and Standard IA  
    - Does NOT work for One-Zone IA or Glacier  
- Report is updated daily  
- 24 to 48 hours to start seeing data analysis  
- Good first step to put together Lifecycle Rules (or improve them)  
  
S3 Event Notifications  
  
- S3:ObjecrCreated, S3:ObjectRemoved, S3:ObjectRestore, S3:Replication  
- Object name filtering possible (*.jpg)  
- Use case: generate thumbnails of images uploaded to S3  
- Can create as many “S3 events” as desired  
- S3 event notifications typically deliver events in seconds but can sometimes take a minute or longer  
  
S3 — Baseline Performance  
  
- Amazon S3 automatically scales to high request rates, latency 100-200 ms  
- Your application can achieve at least 3500 PUT/COPY/POST/DELETE or 5,500 GET/HEAD requests per second per prefix in a bucket  
- There are no limits to the number of prefixes in a bucket  
- If you spread reads across all, let’s assume 4, prefixes evenly, you can achieve 22,000 requests per second for GET and HEAD  
  
S3 — Performance  
  
- Multi-part upload:  
    - Recommended for files > 100MB  
    - Can help parallelise uploads (speed up transfers)  
    - File > Divide in parts > Parallel uploads > S3 Bucket  
- S3 Transfer Acceleration  
    - Increase transfer speed by transferring file to an AWS edge location which will forward the data to the S3 bucket in the target region  
    - Compatible with multi-part upload  
    - File > Edge Location > S3 Bucket  
  
S3 Byte-Range Fetches  
  
    - Parallelise GETs by requesting specific byte ranges  
    - Better resilience in case of failures  
    - Can be used to speed up downloads  
    - Can be used to retrieve only partial data (for example the head of a file)  
  
S3 Select & Glacier Select  
  
    - Retrieve less data using SQL by performing server-side filtering  
    - Can filter by rows & columns (simple SQL statements)  
    - Less network transfer, less CPU cost client-side  
  
https://aws.amazon.com/blogs/aws/s3-glacier-select  
  
  
S3 User-Defined Object Metadata & S3 Object Tags  
  
- S3 User-Defined Object Metadata  
    - When uploading an object, you can also assign metadata  
    - Name-value (key-value) pairs  
    - User-defined metadata names must begin with “x-amz-meta-”  
    - Amazon S3 stores user-defined metadata keys in lowercase  
    - Metadata can be retrieved while retrieving the object  
- S3 Object Tags  
    - Key-value pairs for objects in Amazon S3  
    - Useful for fine-grained permissions (only access specific objects with specific tags)  
    - Useful for analytics purposes (using S3 Analytics o group by tags)  
- You cannot search the object metadata or object tags  
- Instead, you must use an external DB as a search index such as DynamoDB  
  
CORS  
  
- Cross-Origin Resource Sharing (CORS)  
- Origin = scheme (protocol) + host (domain) + port  
    - example: https://www.example.com (implied port is 443 for HTTPS, 80 for HTTP)  
- Web Browser based mechanism to allow requests to other origins while visiting the main origin]  
- Same origin: https://example.com/app1 & http://example.com/app2  
- Different origins: http://www.example.com & http://other.example.com  
- The requests won’t be fulfilled unless the other origin allows for the requests, using CORS Headers (example: Access-Control-Allow-Origin)  
  
Amazon S3 - CORS  
  
- If a client makes a cross-origin request on our S3 bucket, we need to enable the correct CORS headers   
- It’s a popular exam question  
- You can allow for a specific origin or for * (all origins)  
  
Amazon S3 - MFA Delete  
  
- MFA (Multi-Factor Authentication) — force users to generate a code on a device (usually a mobile phone or hardware) before doing important operations on S3  
- MFA will be required to:  
    - Permanently delete an object version  
    - Suspend versioning on the bucket  
- MFA won’t be required to:  
    - Enable Versinoing  
    - List deleted versions  
- To use MFA Delete, versioning must be enabled on the bucket  
- Only the bucket owner (root account) can enable/disable MFA Delete  
  
S3 Access Logs  
  
Do not set your logging bucket to be the monitored bucket. It will create a logging loop, and your bucket will grow exponentially.  
  
- For audit purposes, you may want to log all access to S3 buckets  
- Any request made to S3, from any account, authorised or denied, will be logged into another S3 bucket  
- The data can be analysed using data analysis tools…  
- The target logging bucket must be in the same AWS region  
  
The log format is at:  
https://docs.aws.amazon.com/AmazonS3/latest/dev/LogFormat.html  
  
Amazon S3 — Pre-Signed URLs  
  
- Generate pre-signed URL using the S3 Console, AWS CLI or SDK  
- URL Expiration  
    - S3 Console — 1 min up to 720 mins (12 hours)  
    - AWS CLI — configure expiration with —expires-in parameter in seconds (default 3600 secs, max 604800 secs ~ 168 hours)  
- Users given a pre-signed URL inherit the permissions of the user that generated the URL for GET / PUT  
- Examples:  
    - Allow only logged-in users to download a premium video from your S3 bucket  
    - Allow an ever-changing list of users to download files bye generating URLs dynamically  
    - Allow temporarily a user to upload a file to a precise location in your S3 bucket  
  
S3 — Access Points  
  
Assign access policies to buckets.  
  
    - Access Points simplify security management for S3 buckets  
    - Each Access Point has:  
        - It’s own DNS name (Internet Origin or VPC Origin)  
        - An access point policy (similar to bucket policy) — manage security at scale  
  
	VPC Origin:  
	- We can define the access point to be accessible only from within the VPC  
	- You must create a VPC Endpoint to access the Access Point (Gateway or Interface Endpoint)  
	- The VPC Endpoint Policy must allow access to the target bucket and Access Point  
  
  
S3 Object Lambda  
  
- Use AWS Lambda Functions to change the object before it is retrieved by the caller application  
- Only one S3 bucket is needed, on top of which we create S3 Access Point and S3 Object Lambda Access Points  
  
Use cases:  
- Redacting personally identifiable information for analytics or non-production environments  
- Converting across data formats, such as converting XML to JSON  
- Resizing and watermarking images on the fly using caller-specific details, such as the user who requested the object  
  
