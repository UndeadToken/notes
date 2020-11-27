<?php

use Activity\Composite\ActivityComposite;
use App\Model\User;
use App\Model\Message;

// event
class MessageCreated
{
  protected $user;

  protected $subject;

  protected $message;

  public function __construct(User $user, User $subject, Message $message)
  {
    $this->user = $user;
    $this->subject = $subject;
    $this->message = $message;
  }

}

// listener
class CreateMessageActivity
{
  public function listen(MessageCreated $event)
  {
    $user = $event->user;
    $subject = $event->subject;
    $message = $event->message;

    $user->notify(new MessageActivity($message));
  }
}

// events
MessageCreated::class => [
  CreateMessageActivity::class
],
