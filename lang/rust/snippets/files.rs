use std::fs;
use std::fs::File;

fn main() {
    let output = match File::create("foo.txt") {
        Ok(f) => f,
        Err(e) => {
            eprintln!("Failed to create file: {}", e);
            return;
        }
    };

    // Write to file
    if let Err(e) = fs::write("bar.txt", "cake") {
        eprintln!("Failed to write file: {}", e);
        std::process::exit(1);
    }

    // Read from file
    let data = match fs::read_to_string("bar.txt") {
        Ok(v) => v,
        Err(e) => {
            eprintln!("Failed to read from file: {}", e);
            std::process::exit(1);
        }
    };

    println!("File created!");
}
