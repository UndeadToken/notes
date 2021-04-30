# Pipeline Execution

Pipelined execution is a technique that enabled microprocessor designers to incease the speed at which the processor oeprates, thereby decreasing the amount of time a processor takes to execute a program.

A pipeline can be defined as a series of stages that an instruction in a code stream must pass through when the code is being executed.

In a classic RISC pipeline the four stages are:

- Fetch
- Decode
- Execute
- Write (or "write-back")

Single-cycle processors take exactly one clock cycle to execute a single instruction (pass through all four stages of the lifecycle).

The number of the pipeline stages is called the pipeline depth.

The amount of time it takes for the slowest stage in the pipeline to complete will determine the length of the CPU's clock cycle and thus the length of every pipeline stage.

### Pipeline Stall

A pipeline stall is when an instruction gets hung up in a single pipeline stage for multiple cycles. The spaces between the progressing instructions are called bubbles. Pipeline stalls reduce the pipeline's average instruction througput because they prevent the pipeline from attaining the maximum throughput of of one finished instruction per cycle.

### Instruction Latency

An instruction's latency is the number of coock cycle's it takes for the instruction to pass through the pipeline. For a single-cycle processor all instructions have a latency of one clock-cycle. For a simple four stage pipelined processor each instruction would have a latency of four clock-cycles. Though not always fixed due to pipeline stalls where instructions are hung up in the same pahse for multiple cycles.
