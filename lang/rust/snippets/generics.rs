
use std::str;

// Structs.
struct GenericStruct<T>(T);

struct Container<T> {
	item: T
}

impl<T> Container<T> {
	fn new(item: T) -> Self {
		Container { item }
	}
}

// Enums.
enum GenericEnum<T> {
	Signal(T),
	NoSignal
}

fn main() {

	// Providing a type.
	let v1: Vec<u8> = Vec::new();

	// Calling a method (infers vec<i32> after push).
	let mut v2 = Vec::new();
	v2.push(2);

	// Turbofish
	let v3 = Vec::<u8>::new();

	// Madness
	let num_from_str = str::parse::<u8>("32").unwrap();
}
