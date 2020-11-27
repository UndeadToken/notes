fn main() {
	let a = |x| x * 2;
	println!("You entered: {}", a(3));
	
	let b = |x, y| {
		x + y
	};

	println!("You entered: {:?}",  b(4, 9));
}

