<?php

interface Strategy
{
  public function foo();
}

class Fizz implements Strategy
{
  public function foo()
  {
    return 'fizz';
  }
}

class Buzz implements Strategy
{
  public function foo()
  {
    return 'buzz';
  }
}

class Bar
{
  public function __construct(Strategy $strategy)
  {
    $this->strategy = $strategy;
  }

  public function foo()
  {
    return $this->strategy->foo();
  }
}

$strategy = new Fizz();

$bar = new Bar($strategy);

var_dump($bar->foo());
