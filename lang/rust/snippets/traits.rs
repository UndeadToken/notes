/// Simple Traits.

// A trait is an item that defines a set of contracts or shared behavior that types can opt to implement.

// src/media.rs

pub trait Playable {
	fn play(&self);
	fn pause() {
		println!("Paused");
	}
}

// src/main.rs
mod media;

struct Audio(String);
struct Video(String);

impl Playable for Audio {
	fn play(&self) {
		println!("Now playing: {}", self.0);
	}
}

impl Playable for Video {
	fn play(&self) {
		println!("Now playing: {}", self.0);
	}
}

fn main() {
	println!("Super player!");
	let audio = Audio("ambient_music.mp3".to_string());
	let video = Video("big_buk_bunny.mkv".to_string());
	audio.play();
	video.play();
}

/// Trait Inheritance.

trait Vehicle {
	fn get_price(&self) -> u64;
}

trait Car: Vehicle {
	fn model(&self) -> String;
}

struct TeslaRoadster {
	model: String,
	release_date: u16
}

impl TeslaRoadster {
	fn new(model: &str, release_date: u16) -> Self {
		Self { model: model.to_string(), release_date }
	}
}

impl Vehicle for TeslaRoadster {
	fn get_price(&self) -> u64 {
		200_000
	}
}

impl Car for TeslaRoadster {
	fn model(&self) -> String {
		"Tesla Roadtser I".to_string()
	}
}

fn main() {
	let my_roadster = TeslaRoadster::new("Tesla Roadster II", 2020);

	println!(
		"{} is priced at ${}",
		my_roadster.model,
		my_roadster.get_price()
	);
}

/// Marker traits, from std::marker are defined without any methods.
/// They are used to simply mark a type as belonging to a particular
/// family to gain some compile time garauntees.

/// Generic Traits. e.g. From<T> and Into<T> for conversions.
pub trait From<T> {
	fn from(T) -> Self;
}


/// Associated type traits.
trait Foo {
	type Out;
	fn get_value(self) -> Self::Out;
}

/// Multiple traits.
trait Programmer : Eat + Code + Sleep {

}

/// Trait bounds with impl tait syntax
use std::fmt::Display;

fn foo(val: impl Display) {
	println("{}", val);
}

fn bar(val: impl Display) -> impl Display {
	format!("{{{}}}", val); // surround with braces...
}

/// Trait closures
fn foo(a: u32, b: u32) -> Fn() -> u32 {
	move || a + b
}

let bar = foo(1, 2);
let x = bar();

/// Default traits
#[derive(Default)]
struct Foo<T>;

let foo: Foo<u32> = Foo::default();

/// Add
use std::ops::Add;

#[derive(Default, Debug, PartialEq, Copy, Clone)]
struct Complex<T> {
	re: T,
	im: T
}

impl<T> Complex<T> {
	fn new(re: T, im: T) -> Self {
		Complex { re, im }
	}
}

impl<T: Add<T, Output=T>> Add for Complex<T> {
	type Output = Complex<T>;
	fn add(self, rhs: Complex<T>) -> Self::Output {
		Complex {
			re: self.re + rhs.re,
			im: self.im + rhs.im
		}
	}
}

#[cfg(test)]
mod tests {
	use Complex;
	#[test]
	fn complex_basics() {
		let first = Complex::new(3, 5);
		let second: Complex<u32> = Complex::default();
		let third = Complex::u32::new(1, 2);
	}
	#[test]
	fn complex_addition() {
		let a = Complex::new(1, 2);
		let b = Complex::default();
		let res = a + b;
		assert_eq!(res, a);
	}
}

// From
use std::convert::From;

impl<T: From<T, T>> for Complex<T> {
	fn from(value: (T, T)) -> Complex<T> {
		Complex {
			re: value.0,
			im: value.1
		}
	}
}

#[cfg(test)]
mod tests {
	use Complex;
	#[test]
	fn complex_from() {
		let a = (1, 2);
		let complex = Complex::from(a);
		assert_eq!(a.re, 1);
		assert_eq!(a.im, 2);
	}
}

// Display
use std::fmt::{Formatter, Display, Result};

impl<T: Display> Display for Complex<T> {
	fn write(&self, f: &mut Formatter) -> Result {
		write!(f, "{} + {}i", self.re, self.im);
	}
}

#[cfg(test)]
mod tests {
	use Complex;
	#[test]
	fn complex_display() {
		let im = Complex::new(12, 34);
		println!("{}", im);
	}
}

///

use std::fmt::Display;

fn foo(item: &dyn Display) {
	println!("{}", item);
}

fn main() {
	foo(&"Hello, World!");
}
