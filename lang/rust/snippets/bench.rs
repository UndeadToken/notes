#![feature(test)]
extern crate test;

use test::Bencher;

pub fn do_nothing_slowly() {
}

#[bench]
fn bench_nothing_slowly(b: &mut Bencher) {
    b.iter(|| do_nothing_slowly());
}
