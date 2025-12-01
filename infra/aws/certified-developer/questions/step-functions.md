### 1. What language is used to define Step Functions state machines?
A. YAML
B. JSON
C. Python
D. JavaScript

**Answer:** B
**Explanation:** Step Functions state machines are defined using Amazon States Language (JSON).

---

### 2. Which Step Functions state type invokes a Lambda function?
A. Task
B. Lambda
C. Invoke
D. Function

**Answer:** A
**Explanation:** Task state performs work, including invoking Lambda functions.

---

### 3. What is the maximum execution duration for Standard Step Functions?
A. 5 minutes
B. 15 minutes
C. 1 hour
D. 1 year

**Answer:** D
**Explanation:** Standard workflows can run for up to 1 year.

---

### 4. What is the maximum execution duration for Express Step Functions?
A. 1 minute
B. 5 minutes
C. 15 minutes
D. 1 hour

**Answer:** B
**Explanation:** Express workflows have a maximum duration of 5 minutes.

---

### 5. Which Step Functions state type implements conditional branching?
A. Switch
B. Choice
C. If
D. Branch

**Answer:** B
**Explanation:** Choice state provides conditional branching based on input.

---

### 6. What is the purpose of the Wait state?
A. Wait for user input
B. Delay execution for a specified time
C. Wait for external event
D. Pause indefinitely

**Answer:** B
**Explanation:** Wait state delays execution for a duration or until a specific timestamp.

---

### 7. Which Step Functions execution type guarantees exactly-once execution?
A. Express Synchronous
B. Express Asynchronous
C. Standard
D. All of the above

**Answer:** C
**Explanation:** Standard workflows guarantee exactly-once execution. Express workflows are at-most-once (sync) or at-least-once (async).

---

### 8. What is the purpose of ResultPath in error handling?
A. Define error message
B. Specify where to store error information in output
C. Set retry count
D. Define catch conditions

**Answer:** B
**Explanation:** ResultPath determines how input, output, and errors are combined and passed to the next state.

---

### 9. Which Step Functions feature allows pausing until an external task completes?
A. Wait state
B. Task Token (.waitForTaskToken)
C. Parallel state
D. Pass state

**Answer:** B
**Explanation:** .waitForTaskToken pauses execution until SendTaskSuccess or SendTaskFailure is called.

---

### 10. What is the maximum number of retries for a Step Functions Retry?
A. 3
B. 5
C. 10
D. Unlimited

**Answer:** D
**Explanation:** MaxAttempts can be set to any value (default 3, set to 0 for no retry).

---

### 11. Which Step Functions state executes multiple branches in parallel?
A. Map
B. Parallel
C. Concurrent
D. Multi

**Answer:** B
**Explanation:** Parallel state executes multiple branches concurrently.

---

### 12. What is the purpose of the Map state?
A. Transform data
B. Iterate over array items dynamically
C. Map errors to handlers
D. Create key-value pairs

**Answer:** B
**Explanation:** Map state processes each item in an array with the same set of steps.

---

### 13. Which error code matches all errors in Step Functions?
A. States.ALL
B. States.Any
C. States.Error
D. *

**Answer:** A
**Explanation:** States.ALL matches any error type in Retry and Catch blocks.

---

### 14. What is the default BackoffRate for Step Functions Retry?
A. 1.0
B. 2.0
C. 1.5
D. 3.0

**Answer:** B
**Explanation:** Default BackoffRate is 2.0 (doubles the interval between retries).

---

### 15. Which Step Functions workflow type has the highest execution rate?
A. Standard
B. Express Synchronous
C. Express Asynchronous
D. All the same

**Answer:** C
**Explanation:** Express workflows support 100,000+ executions/sec vs 2,000/sec for Standard.

---

### 16. Where is execution history stored for Express workflows?
A. Step Functions console
B. CloudWatch Logs
C. S3
D. DynamoDB

**Answer:** B
**Explanation:** Express workflow history is sent to CloudWatch Logs (Standard stores in Step Functions for 90 days).

---

### 17. Which Step Functions state type stops execution with success?
A. End
B. Succeed
C. Success
D. Complete

**Answer:** B
**Explanation:** Succeed state terminates execution successfully.

---

### 18. What is the purpose of the Pass state?
A. Skip execution
B. Pass input to output or inject fixed data
C. Validate input
D. Filter data

**Answer:** B
**Explanation:** Pass state passes input to output unchanged or injects static JSON data.

---

### 19. Which Step Functions pricing model charges per state transition?
A. Express
B. Standard
C. Both
D. Neither

**Answer:** B
**Explanation:** Standard workflows charge per state transition. Express charges per execution, duration, and memory.

---

### 20. What AWS service can trigger Step Functions execution?
A. EventBridge
B. API Gateway
C. Lambda
D. All of the above

**Answer:** D
**Explanation:** Step Functions can be triggered by EventBridge, API Gateway, Lambda, SDK, and other services.

---

### 21. Which Step Functions state type terminates execution with failure?
A. Error
B. Fail
C. Failure
D. Abort

**Answer:** B
**Explanation:** Fail state terminates execution with a failure status and optional error/cause.

---

### 22. What is the purpose of Distributed Map in Step Functions?
A. Process small arrays
B. Process large-scale parallel workloads (millions of items)
C. Map errors to handlers
D. Create distributed systems

**Answer:** B
**Explanation:** Distributed Map processes large datasets (millions of items) in parallel with high concurrency from S3, DynamoDB, etc.

---

### 23. Which Step Functions integration pattern waits for a callback?
A. Request Response
B. Run a Job (.sync)
C. Wait for Callback (.waitForTaskToken)
D. Async

**Answer:** C
**Explanation:** .waitForTaskToken pauses execution until SendTaskSuccess/SendTaskFailure is called with the task token.

---

### 24. Which Step Functions intrinsic function generates a UUID?
A. States.UUID()
B. States.Random()
C. States.GenerateUUID()
D. States.NewId()

**Answer:** A
**Explanation:** States.UUID() generates a random UUID v4.

---

### 25. Which AWS service can Step Functions directly integrate with using optimized integrations?
A. Lambda, DynamoDB, ECS
B. S3, SNS, SQS
C. Batch, Glue, SageMaker
D. All of the above

**Answer:** D
**Explanation:** Step Functions provides optimized integrations with 200+ AWS services including Lambda, DynamoDB, ECS, S3, SNS, SQS, Batch, Glue, and SageMaker.

---

### 26. What is the maximum execution time for Standard Workflows?
A. 5 minutes
B. 15 minutes
C. 1 hour
D. 1 year

**Answer:** D
**Explanation:** Standard Workflows can run for up to 1 year.

---

### 27. Which Step Functions state type makes decisions?
A. Task
B. Choice
C. Wait
D. Parallel

**Answer:** B
**Explanation:** Choice state adds conditional logic to select different branches based on input.

---

### 28. What is the maximum execution time for Express Workflows?
A. 5 minutes
B. 15 minutes
C. 1 hour
D. 1 day

**Answer:** A
**Explanation:** Express Workflows have a maximum execution time of 5 minutes.

---

### 29. Which Step Functions feature retries failed tasks?
A. Retry policy
B. Error handling
C. Catch blocks
D. All of the above

**Answer:** D
**Explanation:** Retry policies, error handling, and Catch blocks all handle task failures.

---

### 30. What is the maximum number of state transitions per execution?
A. 1,000
B. 10,000
C. 25,000
D. Unlimited

**Answer:** C
**Explanation:** Standard Workflows support up to 25,000 state transitions per execution.

---

### 31. Which Step Functions state type waits for a duration?
A. Delay
B. Wait
C. Pause
D. Sleep

**Answer:** B
**Explanation:** Wait state delays execution for a specified time or until a timestamp.

---

### 32. What is the purpose of Step Functions Map state?
A. Map data
B. Iterate over array items and process them in parallel
C. Transform data
D. Filter data

**Answer:** B
**Explanation:** Map state iterates over array items, processing each in parallel (up to concurrency limit).

---

### 33. Which Step Functions workflow type is cheaper for high-volume workloads?
A. Standard
B. Express
C. Both same cost
D. Depends on duration

**Answer:** B
**Explanation:** Express Workflows are cheaper for high-volume, short-duration workloads (priced by executions and duration).

---

### 34. What is the maximum payload size for Step Functions?
A. 32 KB
B. 256 KB
C. 1 MB
D. 10 MB

**Answer:** B
**Explanation:** Maximum payload size is 256 KB for state input/output.

---

### 35. Which Step Functions state type runs multiple branches in parallel?
A. Concurrent
B. Parallel
C. Fork
D. Branch

**Answer:** B
**Explanation:** Parallel state executes multiple branches concurrently.

---

### 36. What is the purpose of Step Functions Succeed state?
A. Mark success
B. Terminate execution successfully
C. Return success
D. All of the above

**Answer:** B
**Explanation:** Succeed state terminates the execution successfully.

---

### 37. Which Step Functions feature allows human approval?
A. Task state with callback pattern
B. Wait state
C. Choice state
D. Approval state

**Answer:** A
**Explanation:** Task state with callback pattern (.waitForTaskToken) pauses for external approval/input.

---

### 38. What is the maximum number of parallel branches in Parallel state?
A. 10
B. 40
C. 100
D. Unlimited

**Answer:** B
**Explanation:** Parallel state supports up to 40 parallel branches.

---

### 39. Which Step Functions state type passes input to output unchanged?
A. Pass
B. NoOp
C. Identity
D. Through

**Answer:** A
**Explanation:** Pass state passes input to output, optionally transforming data with Result/ResultPath.

---

### 40. What is the purpose of Step Functions ResultPath?
A. Define result path
B. Control where task result is placed in state output
C. Return results
D. Path to results

**Answer:** B
**Explanation:** ResultPath controls where task result is placed in the state output (merge, replace, or discard).

---

### 41. Which Step Functions integration pattern waits for completion?
A. Request Response (default)
B. Run a Job (.sync)
C. Wait for Callback (.waitForTaskToken)
D. All of the above

**Answer:** D
**Explanation:** All three patterns wait: Request Response (immediate), .sync (job completion), .waitForTaskToken (callback).

---

### 42. What is the maximum concurrency for Map state?
A. 10
B. 40
C. 100
D. 10,000

**Answer:** D
**Explanation:** Map state supports concurrency up to 10,000 parallel iterations.

---

### 43. Which Step Functions state type terminates execution with failure?
A. Error
B. Fail
C. Terminate
D. Abort

**Answer:** B
**Explanation:** Fail state terminates execution with a failure.

---

### 44. What is the purpose of Step Functions InputPath?
A. Define input path
B. Select portion of state input to pass to task
C. Input filtering
D. Path to input

**Answer:** B
**Explanation:** InputPath selects a portion of the state input using JSONPath.

---

### 45. Which Step Functions feature provides execution history?
A. CloudWatch Logs
B. Execution History (built-in)
C. CloudTrail
D. X-Ray

**Answer:** B
**Explanation:** Step Functions automatically maintains detailed execution history for debugging.

---

### 46. What is the maximum number of executions per second for Express Workflows?
A. 100
B. 1,000
C. 10,000
D. 100,000+

**Answer:** D
**Explanation:** Express Workflows support 100,000+ executions per second.

---

### 47. Which Step Functions state type catches errors?
A. Try
B. Catch (in Retry/Catch blocks)
C. Error
D. Exception

**Answer:** B
**Explanation:** Catch blocks in Task, Parallel, and Map states handle errors.

---

### 48. What is the purpose of Step Functions OutputPath?
A. Define output path
B. Select portion of state output to pass to next state
C. Output filtering
D. Path to output

**Answer:** B
**Explanation:** OutputPath selects a portion of the state output using JSONPath.

---

### 49. Which Step Functions workflow type provides exactly-once execution?
A. Standard
B. Express (Synchronous)
C. Express (Asynchronous)
D. Both B and C

**Answer:** A
**Explanation:** Standard Workflows provide exactly-once execution semantics.

---

### 50. What is the maximum number of Step Functions state machines per account?
A. 100
B. 1,000
C. 10,000
D. Unlimited (soft limit of 10,000)

**Answer:** D
**Explanation:** Default limit is 10,000 state machines per account per region (soft limit, can be increased).

