<?php

function foo(int $value): Generator
{
  for ($i = 0; $i < $value; $i++) {
    yield $i * $i;
  }
}

foreach (foo(10) as $foo) {
  var_dump($foo);
}

// Yield a key => value
function bar(int $value): Generator
{
  for ($i = 0; $i < $value; $i++) {
    yield $i => $i * $i;
  }
}

foreach (bar(10) as $bar) {
  var_dump($bar);
}

// Yield from an array
function fizz()
{
  yield from [1, 2, 3, 4];
}

foreach (fizz() as $bar) {
  var_dump($bar);
}
