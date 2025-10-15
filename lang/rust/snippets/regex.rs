//[dependencies]
//regex = "1"

use regex::Regex;

use regex::Regex;

fn replace(target: &str, replacement: &str, text: &str) -> Result<String, regex::Error> {
    let regex = Regex::new(target)?;
    Ok(regex.replace_all(text, replacement).to_string())
}

fn main() {
    let result = replace("foo", "bar", "foo").expect("oops");

    println!("{}", result);
}

//let re = Regex::new(r"\d+").unwrap(); // matches one or more digits
//let text = "I have 42 apples";

//for cap in re.find_iter(text) {
//println!("Found: {}", cap.as_str());
//}
//
