fn req_status() {
	200
}

fn main() {
	let status = req_status();
	match status {
		200 => println!("Success"),     // Match arms!!
		404 => println!("Not Found"),
		other => {
			println!("Request failed with code: {}", other);
			// Get response from cache
		}
	}
}
