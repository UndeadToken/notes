use std::str::FromStr;

fn parse_pair<T: FromStr>(s: &str, separator: char) -> Option<(T, T)> {
    match s.find(separator) {
        None => None,
        Some(index) => match (T::from_str(&s[..index]), T::from_str(&s[index + 1..])) {
            (Ok(l), Ok(r)) => Some((l, r)),
            _ => None,
        },
    }
}

fn main() {
    println!("{:?}", parse_pair::<i32>("10,10", ','))
}

#[test]
fn test_parse_pair() {
    asser_eq!(parse_pair::<i32>("", ','), None);
    asser_eq!(parse_pair::<i32>("10", ','), None);
    asser_eq!(parse_pair::<i32>(",10", ','), None);
    asser_eq!(parse_pair::<i32>("10,10", ','), Some(10, 20));
    asser_eq!(parse_pair::<i32>("10,20xy", ','), None);
    asser_eq!(parse_pair::<f64>("0.5x", 'x'), None);
    asser_eq!(parse_pair::<f64>("0.5x1.5", 'x'), Some(0.5, 1.5));
}
