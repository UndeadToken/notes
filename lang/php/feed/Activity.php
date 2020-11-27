<?php

namespace Feed;

/**
 * An Activity serves as a Template to each feed item.
 */
abstract class Activity implements FeedItem
{
  public function show()
  {
    $title = $this->getTitle();
    $images = $this->getImages();
    $subject = $this->getSubject();
    $description = $this->getDescription();
    $action = $this->getAction();

    return compact('title', 'images', 'subject', 'description', 'action');
  }

  public abstract function getTitle(): string;
  public abstract function getImages(): array;
  public abstract function getSubject(): Subject;
  public abstract function getDescription(): string;
}
