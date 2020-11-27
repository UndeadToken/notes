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

class Bar extends Foo
{
  public function setValue(string $value)
  {
    $this->value = strtoupper($value);
  }
}
