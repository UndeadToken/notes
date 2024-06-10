
// Nested module.
mod food {
	pub struct Cake;
	struct Smoothie;
	struct Pizza;
}

use food::Cake;

fn main() {
	let eatable = Cake;
}

// File module.

pub struct Bar; // demo.rs


mod foo; // main.rs

use crate::foo::Bar;

fn main() {
	let _bar = Bar::init();
}


// Directory as module.
pub struct Bar; // foo/bar.rs

mod bar; // foo.rs
pub use self::bar::Bar; // (re-export module)

mod foo; // main.rs

use foo::Bar;

pub fn do_foo() {
	foo::do_foo();
	Bar::hello();
}
