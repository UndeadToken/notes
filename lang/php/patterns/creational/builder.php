<?php

class Director
{
  protected $foo;

  protected $bar;

  public function foo(string $foo) : Director
  {
    $this->foo = $foo;

    return $this;
  }

  public function bar(bool $bar) : Director
  {
    $this->bar = $bar;

    return $this;
  }
}

$dump = (new Director)
  ->foo('This is a foo')
  ->bar(false);
