# aarm64 Assembly

64-bit ARM Architecture.

GNU Assembler (Gas) program.

Under macos Gas is known as clang or Macho-O assembler.

aoaa.inc is a header file making it portable between linux and macos which eliminates the difference between Gas and the GNU assembler.

gcc = GNU Compiler Collection

gcc emits gas source code as its output which gas then converts to object code.

Apple macos uses a compiler based on the LLVM compiler suite rather than gcc.

The GNU assembler and the clang assemblers executable name is actually (assembler). References to this may be referred to as gas.

The standard suffix for assembly source files is .s since gcc emits this suffix when it converts a c/c++ file into assembly.

The .text directive tells gas that the statements following this directive go in the section of memory reserved for machine instructions (code).

macos must have the _main prefix. .global _main statement makes the _main procedures name visible outside this source file.

  .global _main, main

The .align 2 statement tells the assembler to align the following code on a 4-byte boundry
(required by the ARM CPU) The 2 operand specifies 2 raised to this power (2), which is 4.

  .align 2

Example;

_main:
main: ret 

ret returns control to the operating system.

Assembly programs are broken into sections, some sections contain data, come contain constants, some contain machine instruction (executable statements).

The .text statement tells the assembler the following statements are associated with the code seciton.

In assembly language source files, symbols are usually local or private to a source file. When creating an executable source file, you must pass one or more symbols to the system linker- at least the name of the main program. You can do this by using the .global statement, specifing the global name as an operand: _main in the macos case, main in the linux case.

The ARM instruction set requires all machine instructions to begin on a 32-bit (4-byte) boundry in memory. Therefore call align before .text.

Identifiers in Gas may begin with a dollar sign($), an underscore (_) or an alphabetic character, dollar sign or underscore characters. symbols are case sensitive.

Example:

// main.s
	.text                   // or: .section __TEXT,__text
	.globl _main
	.p2align 2
_main:
	mov     w0, #0          // return 0
	ret

assembler (as), linker (ld) supplying appropriate library files needed by the os.

as -arch arm64 foo.s -o foo.o
ld -o foo foo.o -lSystem -syslibroot `xcrun -sdk macosx --show-sdk-path` -e _main -arch arm64

or with gcc compiler g++

g++ -o foo foo.s
(macos has an alias for clang named g++)
see modifications with g++ -E foo.s

extern "C" namespace prevents name manginling by the C++ compiler.

--

app.s
  .text
  .global _asmMain, asmMain
  .align 2

  _asmMain:
  asmMain:
    ret

app.cpp


#include <stdio.h>

extern "C"
{
  void asmMain(void);
}

int main(void)
{
  printf("Calling asmMain: \n");
  asmMain();
  printf("Returned from asmMain\n");
}

g++ -o app app.cpp app.s

ARM64 CPU Architecture
generally classified as the Von Neumann architecture machine 
of which contain three building blocks: CPU, Memory and I/O devices. These three components are connect through the system bus (consisting of the address, data and control buses).

The CPU communicates with memory and I/O devices by placing a numeric value on the address bus to select one of the memory or I/O device port locations, each of which has a unique binary numeric address.

Then the CPU, memory, and I/O devices pass data among themselves by placing the data on the data bus.

The control bus contains signals that determine the direction of the data transfer (to/from memory and to/from an I/O device).
# Arm64 asm

The ARM CPU family is generally classified as a Von Neumann architecture machine. Von Neumann computer systems contain three main building blocks: the central processing unit (CPU), memory, and input/output (I/0) devices. These three components are interconnected via the system bus (consisting of the address, data, and control buses). Figure 1-1 shows this relationship.

