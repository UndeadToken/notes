# [dependencies]
# rand = "0.9.0"

fn main() {
    let mut rng = rand::thread_rng();
    let n: u32 = rng.gen_range(1..=100);
    println!("Your random number is: {n}");
}


