struct SomeRef<'a, T> {
    part: &'a T;
}

fn main() {
    let _a = SomeRef { part: &43 };
}

// Lifetimes in user defined types.
// If a struct definition has fields that are reference to any type, we need to explicitly specify
// how long those references will live.

#[derive(Debug)]
struct Number<'a, T> {
    num: &'a u8;
}

impl<'a> Number<'a> {
    fn get_num(&self) -> &'a u8 {
        self.num
    }
    fn set_num(&mut self, new_number: &'a u8) {
        self.num = new_number
    }
}

fn main() {
    let a = 10;
    let mut num = Number { num: &a };
    num.set_num(&23);
    println!("{:?}", num.get_num());
}


// Lifetime subtyping.
// b should never live longer than a.
struct Decoder<'a, 'b, S, R> {
        schema: &'a S,
        reader: &'b R
}

impl<'a, 'b, S, R> Decoder<'a, 'b, S, R>
where 'a: 'b {
}

fn main() {
    let a: Vec<u8> = vec![];
    let b: Vec<u8> = vec![];
    let decoder = Decoder {schema: &a, reader: &b};
}
