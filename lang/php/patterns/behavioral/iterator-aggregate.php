<?php

class FooIterator implements IteratorAggregate
{
  public function getIterator()
  {
    return new ArrayIterator([
      'foo',
      'bar',
      'fizz',
      'buzz',
    ]);

    // return new ArrayIterator($this);
  }
}

$iterator = new FooIterator();

foreach ($iterator as $key => $value) {
  var_dump($key, $value);
  echo '\n';
}
