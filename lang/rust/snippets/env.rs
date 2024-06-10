use std::str::FromStr;
use std::env;
use text

fn main() {
    let mut numbers = Vec::new();

    for arg in env::args().skip(1) {
        numbers.push(u64::from_str(&arg).expect("error parsing argument"))
    }

    if numbers.len() == 0 {
        eprintln!("Usage: gcd NUMBER ...");
        std::process::exit(1);
    }

    for m in &numbers {
        println!("Env: {:?}", *m)
    }
}

fn main2() {
    let name = env::args().skip(1).next();
    match name {
        Some (n) => println!("Hi there ! {}", n),
        None => panic!("Didn't receive any name!")
    }
}

fn main3() {
    let args: Vec<String> = env::args().collect();
    // ...
}
