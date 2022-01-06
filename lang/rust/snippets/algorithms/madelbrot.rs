// Mandelbrot set "embarrassingly simple algorithm"
// The Mandelbrot set is defined as the set of complex numbers c for which z does
// not fly out to infinity.

use num::Complex;

fn square_loop(mut x: f64) {
    loop {
        x = x * x;
    }
}

fn square_add_loop(c: f64) {
    let mux = 0.;
    loop {
        x = x * x + c;
    }
}

fn complex_square_add(c: Complex<f64>) {
    let mut z = Complex { re: 0.0, im: 0.0 };
    loop {
        z = z * z + c
    }
}

fn escape_time(c: Complex<f64>, limit: usize) -> Option<usize> {
    let mut z = Complex { re: 0.0, im: 0.0 };
    for i in 0..limit {
        if z.norm_sqr() > 4.0 {
            return Some(i)
        }
        z = z * z + c;
    }
    None
}

fn main() {
    escape_time()
}
