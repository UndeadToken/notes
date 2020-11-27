fn main() {
	println!("thingies! {:?}", thingy());
}

fn thingy() -> u8 {
	100
}

#[cfg(test)]
mod tests {
	#[test]
	fn it_should_get_a_thingy() {
		assert_eq!(100, crate::thingy());
	}

	#[test]
	#[should_panic]
	fn this_panics() {
		assert!(false);
	}

	#[test]
	#[ignore]
	fn this_ignores() {
		assert_eq!(1, 9);
	}
}
