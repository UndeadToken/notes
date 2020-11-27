<?php

interface Chain
{
  public function setNext(Chain $next);
  public function foo(int $value);
}

class FizzChain implements Chain
{
  public function setNext(Chain $next)
  {
    $this->next = $next;
    return true;
  }

  public function foo(int $value)
  {
    if ($value < 100) {
      return isset($this->next)
        ? ($this->next->foo($value))
        : false;
    }

    return 'fizz';
  }
}
