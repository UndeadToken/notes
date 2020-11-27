<?php

interface Foo
{
  public function show();
}

class Fizz implements Foo
{


  public function show()
  {
    return 'fizz';
  }
}

class Buzz implements Foo
{
  public function show()
  {
    return 'buzz';
  }
}

class FooProxy implements Foo
{
  protected $instance;

  public __construct(string $type)
  {
    $this->instance = new $type;
  }

  public function show()
  {
    return $this->instance->show();
  }
}
