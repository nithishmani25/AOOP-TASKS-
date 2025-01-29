package smarthome;

import java.util.Stack;

public class RemoteControl {
    private Command slot;
    private Stack<Command> history = new Stack<>();

    public void setCommand(Command command) {
        this.slot = command;
    }

    public void pressButton() {
        if (slot != null) {
            slot.execute();
            history.push(slot);
        }
    }

    public void pressUndo() {
        if (!history.isEmpty()) {
            history.pop().undo();
        }
    }
}
