<?php

interface FooFactory
{
  public function makeFizz();
  public function makeBuzz();
}

class Foo implements FooFactory
{
  public function makeFizz()
  {
    return 'fizz';
  }

  public function makeBuzz()
  {
    return 'buzz';
  }
}

class Foo implements FooFactory ...
