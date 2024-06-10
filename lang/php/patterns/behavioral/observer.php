<?php

class Subject implements SplSubject
{
  protected $value;

  protected $observers = [];

  public function __construct(int $value)
  {
      $this->value = $value;
  }

  public function attach(SplObserver $observer)
  {
    $hash = spl_object_hash($observer);
    $this->observers[$hash] = $observer;
  }

  public function detach(SplObserver $observer)
  {
    $hash = spl_object_hash($observer);
    $this->observers[$hash] = $observer;
  }

  public function setValue(int $value)
  {
    $this->value = $value;
    $this->notify();
  }

  public function getValue()
  {
    return $this->value;
  }

  public function notify()
  {
    foreach ($this->observers as $observer) {
      $observer->update($this);
    }
  }
}

class Observer implements SplObserver
{
  public function update(SplSubject $subject)
  {
    echo $subject->getValue();
  }
}
