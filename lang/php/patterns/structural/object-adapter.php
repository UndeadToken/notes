<?php

class Foo
{
  private $value;

  public __construct(string $value)
  {
    $this->setValue($value);
  }

  public function getValue() : string
  {
    return $this->value;
  }

  public function setValue(string $value)
  {
    $this->value = $value;
  }
}

class Bar
{
  private $foo;

  public __construct(string $value)
  {
    $this->foo = new Foo(strtoupper($value));
  }

  public function setValue(string $value)
  {
    $this->foo->setValue(strtoupper($value));
  }
}

class Fizz
{
  private $foo;

  public __construct(Foo $foo)
  {
    $this->foo = $foo;
  }

  public function setValue(string $value)
  {
    $this->foo->setValue(strtoupper($value))
  }
}

$foo = new Foo('foo');

$bar = new Bar('bar');

$fizz = new Bar($foo);
