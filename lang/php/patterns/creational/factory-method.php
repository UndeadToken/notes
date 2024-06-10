<?php

interface NotifierFactory
{
  public static function getNotifier($notifier, $to);
}

class ElectronicNotifier implements NotifierFactory
{
  public static function getNotifier($notifier, $to)
  {
    if (empty($notifier)) {
      throw new Exception("No notifier passed.");
    }

    switch ($notifier)
    {
      case 'SMS':
        return new SMS($to);
      case 'Email':
        return new Email($to, 'Junade');
      default:
        throw new Exception('Notifier invalid');
    }
  }
}
