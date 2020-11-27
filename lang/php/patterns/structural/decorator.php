<?php

interface Foo
{
  public function get() : string;
}

class Fizz implements Foo
{
  protected $item;

  public __construct(string $item)
  {
    $this->item = $item;
  }

  public function get()
  {
    return $this->item;
  }
}

class Buzz implements Foo
{
  protected $fizz;

  public __construct(string $item)
  {
    $this->fizz = new Fizz($item);
  }

  public function get()
  {
    return $this->fizz->get();
  }

  public function show()
  {
    print($this->get());
  }
}
