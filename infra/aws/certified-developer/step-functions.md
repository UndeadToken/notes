Step Functions

- Model workflows as state machines (one per workflow)
  - Order fulfilment, Data processing
  - Web applications, any workflow
- Written in JSON
- Visualisation of workflow execution and history
- Start workflow with SDK call, API Gateway, EventBridge (CloudWatch Event)

Task States

- Perform work in a state machine
- Invoke an AWS service:
  - Lambda function
  - AWS Batch job
  - ECS task
  - Insert DynamoDB item
  - Publish SNS/SQS
  - Launch another Step Function
- Run an Activity:
  - EC2, ECS, on-premises
  - Activities poll Step Functions and return results

"Invoke Lambda function": {
  "Type": "Task",
  "Resource": "arn:aws:states:::lambda:invoke",
  "Parameters": {
    "FunctionName": "arn:aws:lambda:REGION:ACCOUNT_ID:function:FUNCTION_NAME",
    "Payload": { "Input.$": "$" }
  },
  "Next": "NEXT_STATE",
  "TimeoutSeconds": 300
}

- Choice State: conditional branch
- Fail/Succeed State: stop execution
- Pass State: pass input to output or inject data
- Wait State: delay or until a specific time
- Map State: iterate dynamically
- Parallel State: parallel branches

Error Handling

- Any state may encounter errors:
  - State machine definition issues
  - Task failures (Lambda exceptions)
  - Transient issues (network, etc.)
- Use Retry and Catch instead of application code
- Predefined errors:
  - States.ALL, States.Timeout, States.TaskFailed, States.Permissions
- State may report its own errors

Retry

- Top-to-bottom evaluation
- ErrorEquals: match specific errors
- IntervalSeconds: initial delay
- BackoffRate: multiplier for delay
- MaxAttempts: default 3, 0 for never
- Catch triggers after max attempts

Catch

- Top-to-bottom evaluation
- ErrorEquals: match specific errors
- Next: state to send to
- ResultPath: input passed to next state

ResultPath

- Determines how input/output/errors are passed to next task

Wait for Task Token

- Pause Step Functions until Task Token is returned
- Task may wait for AWS services, human approval, legacy systems
- Append .waitForTaskToken to Resource
- Task resumes with SendTaskSuccess or SendTaskFailure

Activity Tasks

- Task performed by Activity Worker (EC2, Lambda, mobile)
- Worker polls GetActivityTask, sends success/failure
- TimeoutSeconds sets max wait
- Heartbeats via SendTaskHeartBeat
- Tasks can wait up to 1 year with heartbeat

Standard vs Express

- Standard:
  - Max duration: 1 year
  - Exactly-once execution
  - 2000+ exec/sec
  - History: 90 days or CloudWatch
  - Pricing: # of state transitions
  - Use: non-idempotent actions (payments)
- Express:
  - Max duration: 5 min
  - At-most-once sync, At-least-once async
  - 100,000 exec/sec
  - History: CloudWatch Logs
  - Pricing: executions, duration, memory
  - Use: IoT ingestion, streaming, mobile backends

AppSync

- Managed GraphQL service
- Fetch exactly needed data from multiple sources
  - NoSQL, RDS, HTTP APIs, Lambda
- Real-time: WebSocket/MQTT
- Mobile apps: local data + sync
- Start with GraphQL schema

Security

- Authorisation:
  - API_KEY
  - AWS_IAM
  - OPENID_CONNECT
  - AMAZON_COGNITO_USER_POOLS
- Custom domain + HTTPS via CloudFront

Amplify

- Mobile and web app development
- Amplify Studio: visual full-stack builder
- Amplify CLI: guided backend setup
- Amplify Libraries: connect app to AWS services
- Amplify Hosting: host web apps with CDN

- Features: data storage, authentication, ML
- Front-end libraries: React, Vue, JS, iOS, Android, Flutter
- Build/deploy via CLI or Studio

Authentication

- Uses Amazon Cognito
- User registration, authentication, account recovery
- MFA, social sign-in
- Pre-built UI components
- Fine-grained authorization

Datastore

- Uses AppSync + DynamoDB
- Local data with cloud sync
- Powered by GraphQL
- Offline and real-time
- Visual modeling via Amplify Studio

Hosting

- Modern web apps
- CI/CD: build, test, deploy
- Pull Request Previews
- Custom domains
- Monitoring, redirects, headers, password protection

End-to-End Testing

- E2E tests in Amplify
- Catch regressions before production
- Test step in amplify.yml
- Integrates with Cypress
- Run tests: build phase or deployed (staging)
- Build -> Test -> Deploy
