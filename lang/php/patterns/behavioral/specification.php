<?php

interface FooSpecification
{
  public function isSatisfiedBy(Foo $foo): bool;
}

class FooIsAwesome implements FooSpecification
{
  public function isSatisfiedBy(Foo $foo): bool
  {
    return $foo->department === 'social-engineering';
  }
}

class Foo
{
    protected $department;

    public function __construct(string $department)
    {
      $this->department = $department;
    }
}

$foo = new Foo('networking');
$isAwesome = (new FooIsAwesome)->isSatisfiedBy($foo);
