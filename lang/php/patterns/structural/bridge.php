<?php

interface Messenger
{
  public function send();
}

class EmailMessenger implements Messenger
{
  public function send()
  {
    print('Mail sent!');
  }
}

class InstantMessenger implements Messenger
{
  public function send()
  {
    print('Message sent!');
  }
}

interface Transmitter
{
  public function setSender(Messenger $sender);
  public function send();
}

abstract class Device implements Transmitter
{
  protected $sender;

  public function setSender(Messenger $sender)
  {
    $this->sender = $sender;
  }
}

class Phone extends Device
{
  public function send()
  {
    $this->sender->send();

    print('Sent from phone!');
  }
}

$phone = new Phone();
$phone->setSender(new EmailMessenger);
$phone->send();
