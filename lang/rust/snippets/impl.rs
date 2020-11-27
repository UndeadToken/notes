
// Struct implementations.
struct Foo {
	thing: String
}

impl Foo {
	fn with_thing(thing: &str) -> Foo {
		Foo {
			thing: thing.to_string()
		}
	}

	fn bar(&self) {
		println!("{}", self.thing);
	}
}

// Enum implementations.
enum PaymentMode {
	Debit,
	Credit,
	Paypal
}

impl PaymentMode {
	fn pay(&self, amount: u64) {
		match self {
			PaymentMode::Debit => pay_by_debit(amount),
			PaymentMode::Credit => pay_by_credit(amount),
			PaymentMode::Paypal => pay_by_paypal(amount)
		}
	}
}

fn pay_by_debit(amt: u64) {
	println!("Processing debit card payment of {}", amt);
}

fn pay_by_credit(amt: u64) {
	println!("Processing credit card payment of {}", amt);
}

fn pay_by_paypal(amt: u64) {
	println!("Processing paypal payment of {}", amt);
}

fn get_saved_payment_mode() -> PaymentMode {
	PaymentMode::Debit
}

fn main() {
	let foo = Foo::with_thing("bazz");
	foo.bar();

	let mode = get_saved_payment_mode();
	mode.pay(512);
}

/// Bounds.
impl Foo {
	fn load<T: Entity>(&self, entity: T)
}

struct Foo<T: Bar> {
	bar: T
}

struct Foo<T> where T: Bar {
	bar: T
}
