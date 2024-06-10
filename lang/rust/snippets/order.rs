use std::io;
use std::cmp::Ordering;

fn main() {
	println!("Hello, World!");

	let mut input = String::new();

	io::stdin().read_line(&mut input)
		.expect("Error reading line.");

	let input: u32 = input.trim().parse()
		.expect("Please type a number!");

	// OR
	/*
        .parse() {
		Ok(num) => num,
		Err(_) => continue,
	};
	*/

	println!("You guessed: {}", input);
	
	let value = 2;

	match input.cmp(&value) {
		Ordering::Less => println!("Too small!"),
		Ordering::Greater => println!("Too big!"),
		Ordering::Equal => {
			println!("You win!");
			break;
		}
	}
}
