use std::fs;

fn main() {
    let data = match fs::read_to_string("foo.txt") {
        Ok(v) => v,
        Err(e) => {
            println!("Failed to read from file...");
            std::process::exit(1);
        }
    };

    match fs::write("bar.txt", "foo.bar") {
        Ok(_) => {},
        Err(e) => {
            eprintln!("Failed to write to file.");
        }
    }
}
