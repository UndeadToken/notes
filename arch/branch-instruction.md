# Branch Instructions

Inserting a branch instruction into an instruction stream allows the processor to jump to a program line that is out of sequence via a forward branch or backward branch.

Branch instructions add an additional step in the fetch execute loop:

c. If the instruction is a branch instruction, then execute it using the control unit and the program counter. (For a taken branch, write the branch target address into the program counter.)

### Unconditional Branch

When the computer decodes the branch in the instruction register it has the control unit replace the address currently in the program counter with branch's target address.

```
jump #target
```

### Conditional Branch

Conditional branch instructions jump to a specified program instruction if a condition is met.


Jump to the source address if result of the previous instruction is zero. Depending on the computer architecture this may be stored in a register or flag.

```
jumpz #1
```

Jump if the result of the previous arithmetic operation is negative.

```
jumpn #1
```

Jump to the target address if the previous operation was too large and overflowed the register.

```
jumpo #1
```

Relative Addressing. Jump to the instruction located 30 bytes away from the start of the code segment. (Each instruction is 2-bytes in length, so this puts us at the 15 instruction.)

```
jump #(C + 30)
```

Jump to a label.

```
      jump LBL1
LBL1: add A, B, B
```
