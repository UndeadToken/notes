use std::cmp::Ordering;

fn main() {
    let foo = 1;
    let bar = 2;

    match foo.cmp(bar) {
        Ordering::Less => println!("Less"),
        Ordering::Greater => println!("Greater"),
        Ordering::Equal => println!("Equal"),
    }
}
