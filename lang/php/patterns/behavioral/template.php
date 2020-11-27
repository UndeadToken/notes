<?php

abstract class Template
{
  public function apply()
  {
    $foo = $this->foo();
    $bar = $this->bar();
  }

  public abstract function foo();
  public abstract function bar();
}

class Fizz extends Template
{
  public function foo()
  {
    return 'foo';
  }

  public function foo()
  {
    return 'bar';
  }
}
