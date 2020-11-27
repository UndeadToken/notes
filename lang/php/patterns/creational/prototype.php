<?php

class Foo
{
  protected $bar;

  public function setBar(int $bar)
  {
    $this->bar = $bar;

    return $this;
  }

  public function getbar() : int
  {
    return $this->bar;
  }
}

$a = Foo();
$a->setBar(1);

$b = clone $a;
$b->setBar(2);

$b->fizz = function (string $x) {
    return 'hello, ' . $x;
};

$b->fizz->__invoke('MR. X');
