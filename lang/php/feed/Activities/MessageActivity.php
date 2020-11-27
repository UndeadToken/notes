<?php

namespace Activity\Activities;

use Activity\Activity;

class MessageActivity extends Activity
{
  protected $message;

  public function __construct(Message $message)
  {
    $this->message = $message;
  }

  public function getTitle()
  {
    $name = $this->message->sender->first_name;

    return  "{$name} sent you a message!";
  }

  public function getImages()
  {
    return $this->message
      ->sender
      ->publicImages()
      ->latest()
      ->take(4);
  }

  public function getSubject():
  {
    return $this->message->sender;
  }

  public function getDescription()
  {
    return $this->message->body;
  }
}
