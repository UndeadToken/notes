<?php

class Foo
{
  public function __invoke();
}

class Bar
{
  public function __invoke();
}

class Fizz
{
  protected $foo;

  protected $bar;

  public function __construct(Foo $foo, Bar $bar)
  {
    $this->foo = $foo;
    $this->bar = $bar;
  }

  public function __invoke()
  {
    ($this->foo)();
    ($this->bar)();
  }
}
