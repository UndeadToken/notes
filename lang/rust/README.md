# Rust

- cargo is Rust's compilation manager, package manager and general purpose tool.
- rustc is the compiler
- rustdoc is the rust documentation tool
- 4 space indentation is a rust rule

### Dispatch
The process by which a an API has to figure out the method implementation to invoke
on an instance of a type that's passed to the API. This process of method resolution
in a polymorphic context is called dispatch, and invoking the method is called dispatching.

### Monomorphization
The process of generating specialized functions with concrete types at compile time.
Also known as Static Dispatch, when the method to invoke is decided at compile time.

### Polymorphism
The process by which an abstraction superseeds its parents implementation during runtime.
Dynamic Dispatch, when the method call isn't decided until runtime.
(Looks through interface implementations in vtable, which is a list of function pointers which point to each types implemented method.)

#### Types

i32 Signed 32-bit integer
u8 Unsigned 8-bit integer
isize, usize types hold pointer-sized signed and unsigned integers, 32 bits long on 32-bit platforms and 64-bits long on 64-bit platforms.
f32, f64 IEEE single- and double-precision floating-point types, like float and double in C and C++.

### Ownership

Ownership is a set of rules that govern how a Rust program manages memory.

Each value in Rust has an owner.
There can only be one owner at a time.
When the owner goes out of scope, the value will be dropped.
