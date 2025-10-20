Step Functions

- Model your workflows as state machines (one per workflow)
    - Order fulfilment, Data processing
    - Web applications, Any workflow
- Written in JSON
- Visualisation of the workflow and the execution of the workflow, as well as history
- Start workflow with SDK call, API Gateway, Event Bridge (CloudWatch Event)

Task States

- Do some work in your state machine
- Invoke one AWS service
    - Can invoke a Lambda function
    - Run an AWS Batch job
    - Run an ECS task and wait for it to complete
    - Insert an item from DynamoDB
    - Publish message to SNS,SQS
    - Launch another Step Function workflow…
- Run an Activity
    - EC2, Amazon ECS, on-premises
    - Activities poll the Step functions for work
    - Activities send results back to Step Functions

"Invoke Lambda function": {
	"Type": "Task",
	"Resource": "arn:aws:states:::lambda:invoke",
	"Parameters": {
		"FunctionName": "arn:aws:lambda:REGION:ACCOUNT_ID:function:FUNCTION_NAME",
		"Payload": { 			"Input.$": "$" 		}
	}
	"Next": "NEXT_STATE",
	"TimeoutSeconds": 300
}

- Choice State: test for a condition to send to a branch (or default branch)
- Fail or Succeed State: Stop execution with failure or success
- Pass State: Simply pass its input to its output or inject some fixed data, without performing work
- Wait State: Provide a delay for a certain amount of time or until a specified time/data
- Map State: Dynamically iterate steps
- Parallel State: begin parallel branches of execution

Error Handling in Step Functions

- Any state can encounter runtime errors for various reasons:
    - State machine definition issues (for example, no matching rule in a choice state)
    - Task failures (for example, an exception in a Lambda function)
    - Transient issues (for example, network partition events)
- Use Retry (to retry failed state) and Catch (transition to failure path) in the State machine to handle the errors instead of inside of the Application Code
- Predefined error codes:
    - States.ALL: matches any error name
    - States.Timeout: Task ran longer than TimeoutSeconds or no heartbeat received
    - States.TaskFailed: execution failure
    - States.Permissions: insufficient privileges to execute code
- The state may report its own errors

Retry (Task or Parallel State)

- Evaluated from top to bottom
- ErrorEquals: match a specific kind of error
- IntervalsSeconds: initial delay before retrying
- BackoffRate: multiple the delay after each retry
- MaxAttempts: default to 3, set to 0 for never retried
- When max attempts are reached, the Catch kicks in

Catch (Task or Parallel State)

- Evaluated from top to bottom
- ErrorEquals: match a specific kind of error
- Next: State to send to
- ResultPath: A path that determines what input is sent to the state specified in the Next field

ResultPath

The result path is how you pass errors from the inputs into the output, into the next task.

- Include the error in the input

Wait for Task Token

- Allows you to pause Step Functions during a Task until a Task Token is returned
- Task might wait for other AWS services, human approval, 3rd party integration, call legacy systems
- Append .waitForTaskToken to the Resource field to tell Step Functions to wait for the Task Token to be returned

"Resource": "arn:aws:states:::sqs:sendMessage.waitForTaskToken"

- Task will pause until it receives that Task Token back with a SendTaskSuccess or SendTaskFailure API call

Activity Tasks

- Enables you to have the Task work performed by an Activity Worker
- Activity Worker apps can be running on EC2 Lambda, mobile device
- Activity Worker poll for a Task using GetActivityTask API
- After Activity Worker completes its work, it sends a response of its success/failure using SendTaskSuccess or SendTaskFailure
- To keep the Task active
    - Configure how long a task can wait by setting TimeoutSeconds
    - Periodically send a heartbeat from your Activity Worker using SendTaskHearBeat within the time you set in HearBeatSeconds
- By configuring a long TimeoutSeconds and actively sending a heartbeat, Activity Task can wait up to 1 year

Standard vs Express

Step Function Workflows -> Standard

Step Function Workflows -> Express -> Synchronous At-most once, Asynchronous At-least once
(Async doesn't wait for Workflow to complete gets results from CW logs, use cases: You don't need immediate response e.g. messaging service. Must manage idempotence.)

Standard

Max duration: up to 1 year
Execution model: exactly-once execution
Execution rate: over 2000 / second
Execution history: up to 90 days or using CloudWatch
Pricing: # of State Transitions
Use cases: Non-idempotent actions (e.g. processing payments)

Express

Max duration: up to 5 minutes
Execution rate: 100,000 / second
Execution history: CloudWatch Logs
Pricing: # of executions, duration and memory consumption
Use cases: IoT data ingestion, streaming data, mobile app backends. 

AppSync

- AppSync is a managed service that uses GraphQL
- GraphQL makes it easy for applications to get exactly the data they need
- This includes combining data from one or more sources
    - NoSQL data stores, Relational Databases, HTTP APIs
    - Integrates with DynamoDB, Aurora, OpenSearch & others
    - Custom sources with AWS Lambda
- Retrieve data in real-time with WebSocket or MQTT on WebSocket
- For mobile apps: local data access & data synchronisation
- It all starts with uploading one GraphQL schema

Security

- There are four ways you can authorise applications to interact with your AWS AppSync GraphQL API
- API_KEY
- AWS_IAM: IAM users/ roles/ cross-account access
- OPENID_CONNECT: OpenID Connect Provider / JSON Web Token
- AMAZON_COGNITO_USER_POOLS

- For custom domain & HTTPS, use CloudFront in front of AppSync

Amplify

- Create mobile and web applications

Amplify Studio: visually build a full-stack app, both front-end UI and a backend
Amplify CLI: configure an Amplify backend with a guided CLI workflow
Amplify Libraries: Connect your app to existing AWS services (Cognito, S3 and more)
Amplify Hosting: Host secure, reliable, fast web apps or websites via the AWS content delivery network

- Set of tools to get started with creating mobile and web applications
- Elastic beanstalk for mobile and web applications
- Must have features such as data storage, authentication, storage and machine learning, all powered by AWS services
- Front-end libraries with ready-to-use components for React.js, Vue, Javascript, IOS, Android, Flutter, etc...
- Build and deploy with the Amplify CLI or Amplify Studio

Authentication

- Leverages Amazon Cognito
- User registration, authentication, account recovery & other operations
- Support MFA, social sign-in etc...
- Pre-built UI components
- Fine-grained authorization

Datastore

- Leverages Amazon AppSync and Amazon DynamoDB
- Works with local data and have automatic synchronisation to the cloud with complex code
- Powered by GraphQL
- Offline and real-time capabilities
- Visual data modeling w/ Amplify Studio

Hosting

- Build and Host Modern Web Apps
- CICD (build, test, deploy)
- Pull Request Previews
- Custom Domains
- Monitoring
- Redirect and Custom headers
- Password protection

End-to-End (E2E) Testing

- Run end-trend tests in the test phase in Amplify
- Catch regressions before pushing code to production
- Use the test step to run any test commands at build time (amplify.yml)
- Integrated with Cypress testing framework
    - Allows you to generate UI report for your tests

Build: Run tests while the app is being built
Test E2E: Run tests while the app is deployed (staging)
Build -> Test -> Deploy

M
