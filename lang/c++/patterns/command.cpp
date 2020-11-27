#include <iostream>

/* Command */

// "Encapsulate a request as an object, thereby letting users parameterize clients wih different requests, queue or log
// requests, and support undoable actions."

// "Commands are an object oriented replacement callbacks."

class Actor {};

class Command
{
protected:
    Actor& actor;

public:
    Command(Actor& actor):actor(actor) {}

    virtual ~Command() {}
    virtual void execute() = 0;
    virtual void undo() = 0;
};

class DropPrimaryCommand : public Command
{
public:
    virtual void execute()
    {
        // actor.dropPrimary();
    };

    virtual void undo()
    {
        // Item& item = closestItem();
        // actor.setPrimary(item);
    };
};

class InputHandler
{
public:
    Command* handleInput();

private:
    Command* buttonX;
    Command* buttonY;
    Command* buttonA;
    Command* buttonB;
};

Command* InputHandler::handleInput()
{
    if (isPressed(BUTTON_X)) return buttonX;
    if (isPressed(BUTTON_Y)) return buttonY;
    if (isPressed(BUTTON_A)) return buttonA;
    if (isPressed(BUTTON_B)) return buttonB;

    return NULL;
}

int main()
{
    InputHandler handler;
    Command* command = handler.handleInput();

    if (command)
    {
        command->execute();
    }

    return 0;
}
