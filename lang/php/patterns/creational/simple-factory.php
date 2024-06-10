<?php

abstract class Notifier
{
  protected $to;

  public function __construct(string $to)
  {
    $this->to = $to;
  }

  public abstract function send();
}

class SMS extends Notifier
{
  public function send()
  {
    return 'sms';
  }
}

class Email extends Notifier
{
  public function send()
  {
    return 'email';
  }
}

class NotifierFactory
{
  public static function make($notifier, $to)
  {
    switch ($notifier)
    {
      case 'sms':
        return new SMS($to);
      case 'Email':
        return new Email($to);
      default:
        throw new Exception('Unsupported notifier type.');
    }
  }
}

$notifier = NotifierFactory::make('email', 'foo@bar.com');
$notifier->send();
