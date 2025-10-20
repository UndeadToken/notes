use std::io;

fn main() {
    let mut guess = String::new();

    io::stdin().read_line(&mut guess).expect("something...");

    println!("Your guess {guess}");
}

// Handling invalid inputio::stdin()
//io.read_line(&mut guess)
//    .expect("Failed to read line");
//let guess: u32 = match guess.trim().parse() {
//Ok(num) => num,
//Err(_) => continue,
//};
