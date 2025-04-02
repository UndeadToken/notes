use std::env;

fn main() {
	let name = env::args().skip(1).next();
	match name {
		Some (n) => println!("Hi there ! {}", n),
		None => panic!("Didn't receive any name!")	
	}
}

n main2() {
    let args: Vec<String> = env::args().collect();
    if args.contains(&"--help".to_string()) {
        println!("Usage: feud [--compile, -c] [--run, -r] [--interpret, -i]");
        return;
    }
    let mut debug = false;
    let mut mode: Option<String> = None;
    let mut iter = args.iter().peekable();
    while let Some(arg) = iter.next() {
        match arg.as_str() {
            "--verbose" | "-v" => {
                debug = true;
            }
            "-c" | "-r" | "-i" => {
                mode = Some(arg.clone());
            }
            _ => {
                mode = Some("-i".to_string());
            }
        }
    }
    match mode.as_deref() {
        Some("-c") => println!("Compiling..."),
        Some("-r") => println!("Running..."),
        Some("-i") => println!("Interpreting..."),
        _ => println!("Unknown option.")
    }
}
