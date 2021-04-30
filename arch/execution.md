# The Mechanics of Program Execution

All of the instructions in a program are represented insude the computer as strings
of numbers. A program is one long string of numbers stored in a series of memory
locations.

Each opcode designates a different operation that the processor can perform.

### The Instruction Reigster and Program Counter

Each instruction in a program lives in its own memory address. The computer begins
at the programs starting address and then steps through each sucessive memory
location, fetching each successive instruction from memory, placing it in a
special register, and executing it.

An instruction-fetch is a special type of load that happens automatically for
every instruction. It always takes the address that's currently in the programs
counter register as its source and the instruction register as its destination.
The control unit uses a fetch to load  each instruction of a program from memory
into the instruction register, where the instruction is decoded before being
executed and while the instruction is being decoded, the processor places the
address of the next instruction into the program counter by incrementing the
address that's currently in the program counter, so that the newly incremented
address points to the next instruction in the sequence.

#### The fetch-execute loop / cycle

The fetch-execute loop is repeated as long as the computer is powered on.

- Fetch the next instruction from the address stored in the program counter,
  and load that instruction into the instruction register. Increment the program
  counter.

- Decode the instruction in the instruction register.

- Execute the instruction in the instruction register, using the following rules:
  a. If the instruction is an arithmetic instruction, execute it using the ALU
     register file.
  b. If the instruction is a memory acccess instruction, execute it using the
     memory-access hardware.

### Hypothetical micrprocessor DLW-1 opcodes
The binary values representing both the opcodes and the register codes are arranged
in one of a number of 16-bit (or 2-byte) formats to get a complete
machine-language instruction, which is a binary number that can be stored in RAM
and used by the processor.

3-bit opcodes
|Mnemonic|Opcode|
|add     |000   |
|sub     |001   |
|load    |010   |
|store   |011   |

2-bit binary codes
|Register|Binary Code|
|A       |00         |
|B       |01         |
|C       |10         |
|D       |11         |

A 3-bit opcode allows the processor's instruction set to contain up to 2^3 mnemonics
which means it can have up to 8 instructions in teh instruction set. Increasing
the opcode size to 8 bits would allow the processor to store up to 2^8, or 256
instructions. Similarly increasing the number of bits in the register increases
the number of possible registers a machine can have.

### Binary Encoding of Arithmetic Instructions

Arithmetic instructions have the simplest machine language instruction formats.
The format for a register-type arithmetic instruciton.

The first bit of the instruction is the mode bit. If the mode bit is set to 0
then the instruction is a register-type. If the mode bit is set to 1 then the
instruction is of the immediate type.

The opcode bits define which operation to perform with the source inputs. Bits
8-9 is the detination and the last 6 bits are unused  which is padded with zeros.

|0       |1      |2      |3      |4      |5      |6      |7      |
|mode    |opcode                 |source1        |source2        |

Byte 1

|8            |9      |10     |11     |12     |13     |14     |15     |
|destination          |000000                                         |

Byte 2

|Assembly Language Instruction |Machine Language Instruction |
|add A, B, C                   |00000001 10000000            |

Arithmetic instructions containing an immediate value use an immediate-type
instruction format.

|0       |1      |2      |3      |4      |5      |6      |7      |
|mode    |opcode                 |source1        |destination    |

|8       |9      |10     |11     |12     |13     |14     |15     |
|8-bit immediate value                                           |

An immediate-type load uses the immediate-type instruction format, but because
the load's source is an immediate value (a memory address) and not a register,
the source field is not needed and must be zeroed out. (The source field is not
ignored.)

|0       |1      |2      |3      |4      |5      |6      |7      |
|mode    |opcode                 |00             |destination    |

Byte 1

|8       |9      |10     |11     |12     |13     |14     |15     |
|8-bit immediate source address  

Byte 2

|Assembly Language Instruction |Machine Language Instruction |
|load #12, A                   |10100000 00001100            |

A register-type load uses the register-type instruction format.

|0       |1      |2      |3      |4      |5      |6      |7      |
|mode    |opcode                 |source1        |00             |

Byte 1

|8       |9      |10     |11     |12     |13     |14     |15     |
|destination     |000000                                         |

Byte 2

For a register-relatvie addressed load we use a version of the immediate-type
instruction format.

|0       |1      |2      |3      |4      |5      |6      |7      |
|mode    |opcode                 |base           |destination    |

Byte 1

|8       |9      |10     |11     |12     |13     |14     |15     |
|8-bit immediate offset                                          |

Byte 2

### Binary Encoding of Store Instructions

The register-type binary format for a store instruction is similar to a load and
the immediate-type machine language format for a store is also similar to the
immediate-type instruction format for a load.

The register-relative store, on ther otehr hand uses the same immediate-type
instruction format used for the register-relative load.

immediate-type store

|0       |1      |2      |3      |4      |5      |6      |7      |
|mode    |opcode                 |source         |00             |

Byte 1

|8       |9      |10     |11     |12     |13     |14     |15     |
|8-bit immediate destination address                             |

Byte 2

|Assembly Language Instruction |Machine Language Instruction |
|store C, #14                  |101110000 00001110           |
