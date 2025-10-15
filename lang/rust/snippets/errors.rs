fn main() {
    eprintln!("Error");

    // Exiting early.
    //std::process::exit(0);

    Some(false).expect("expected something");

    None.expect("errororororo")
}
