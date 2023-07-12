<?php

interface Mediator
{
    public function notify(Component $sender, Event $event);
}


