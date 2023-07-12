<?php

interface Command
{
    public function execute();
}

class ApplyCommand implements Command
{
    public function execute()
    {
        //
    }
}

class RevokeCommand implements Command
{
    public function execute()
    {
        //
    }
}

class CommandHistory
{
    public function push(Command $command)
    {
        //
    }

    public function pop(): Command
    {
        //
    }
}

class Application // Receiver
{
    public function __construct(protected CommandHistory $history) {}

    public function execute(Command $command)
    {
        $this->history->push($command);
    }

    public function undo()
    {
        $command = $this->history->pop(); 

        //
    }
}

class Action
{
    protected Command $command;

    public function __construct(protected Application $application) {}

    public function setCommand(Command $command)
    {
        $this->command = $command;
    }

    public function run()
    {
        $this->appliction->execute($this->command);
    }
}
