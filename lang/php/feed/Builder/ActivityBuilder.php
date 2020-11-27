<?php

namespace Activity\Builder;

class ActivityBuilder
{
  prot

  public function build()
  {
    return (new Activity)
      ->;
  }



  public function function setTitle(string $title): Activity;
  public abstract function setImages(array $images): Activity;
  public abstract function setSubject(User $subject): Activity;
  public abstract function setDescription(string $description): Activity;
  public abstract function setAction(string $action): Activity;
}
