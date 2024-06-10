<?php

interface Foo
{
  public function show();
}

class Bar implements Foo
{
  protected $value;

  public __construct(int $value)
  {
    $this->value = $value;
  }

  public function show()
  {
    return $this->value;
  }
}

class FooFactory
{
  protected $cache = [];

  public function get(int $value)
  {
    if (!array_key_exists($value, $this->cache))
    {
      $this->cache[$value] = new Bar($value);
    }

    return $this->cache[$value];
  }
}
