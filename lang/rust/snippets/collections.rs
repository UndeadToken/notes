use std::collections::HashMap;

// Arrays.
fn do_arrays() {
	let numbers: [u8; 10] = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
	let floats = [0.1f64, 0.2, 0.3];
	
	println!("---- Arrays ----");
	println!("Number: {}", numbers[5]);
	println!("Float: {}", floats[2]);
}

// Tuples.
fn do_tuples() {
	let theta: (u8, &str) = (40, "Have a good day!");
	let (num, string) = theta;	
	
	println!("---- Tupless ----");
	println!("{:?}", theta);
	println!("From tuple: Number: {}, String: {}", num, string);
}

// Vectors.
fn do_vectors() {
	let mut numbers_vec: Vec<u8> = Vec::new();
	numbers_vec.push(1);
	
	let mut vec_with_macro = vec![1];
	vec_with_macro.push(2);
	let _ = vec_with_macro.pop(); // Value ignore with _.

	println!("---- Vectors ----");
	println!("{:?} {:?}", numbers_vec, vec_with_macro);
}

// Hashmaps.
fn do_hashmaps() {
	let mut fruits = HashMap::new(); // Robin Hood hashing algorithm.
	fruits.insert("apple", 3);
	fruits.insert("orange", 1);
	fruits.insert("grape", 4);

	fruits.remove("orange");

	println!("---- Hashmaps ----");

	for (k, v) in &fruits {
		println!("{:?} {:?}", k, v);
	}	

	println!("{:?}", fruits["grape"]);
}

// Slices.
fn do_slices() {
	println!("---- Slices ----");

	let mut numbers: [u8; 4] = [1, 2, 3, 4];
	{
		let all: &[u8] = &numbers[..]; // All values.
		println!("{:?}", all);
	}
	{
		let first_two: &mut [u8] = &mut numbers[0..2];
		first_two[0] = 8;
		first_two[1] = 9;
	}
	println!("{:?}", numbers);
}

fn main() {
	do_arrays();
	do_tuples();
	do_vectors();
	do_hashmaps();
	do_slices();
}
