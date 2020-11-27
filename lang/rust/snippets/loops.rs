fn main() {
	let mut status = 200;
	
	// Regular loop.
	loop {
		status += 1;
		println!("{}", status);

		if status > 220 {
			break;
		}
	}

	// Nest loops with labels.	
	'primary: loop {
		loop {
			status -= 1;
			println!("{}", status);

			if status < 10 {
				break 'primary;
			}
		}
	}

	// While loops.
	let mut theta = 1000;
	while theta > 200 {
		theta -= 1;
		println!("{}", theta)
	}

	// For loops.
	for i in 0..10 {
		println!("Well here it is son! {}", i);
	}

	// Inclusive range.
	for i in 0..=10 {
		println!("Well here it is son! {}", i);
	}
}
