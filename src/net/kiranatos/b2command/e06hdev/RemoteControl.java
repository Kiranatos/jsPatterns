package net.kiranatos.b2command.e06hdev;

import net.kiranatos.b2command.e06hdev.commands.Command;
import net.kiranatos.b2command.e06hdev.commands.ConcreteCommand;

public class RemoteControl {
    Command[] onCommands;
    Command[] offCommands;
    Command undoCommand;

    public RemoteControl() {
        onCommands = new Command[7];
        offCommands = new Command[7];

        Command noCommand = new ConcreteCommand.NoCommand();
        for (int i=0; i<7; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
        undoCommand = noCommand;
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    //нажатие на кнопку
    public void onButtonWasPushed(int slot) {
        onCommands[slot].execute();
        undoCommand = onCommands[slot];
    }
    public void offButtonWasPushed(int slot) {
        offCommands[slot].execute();
        undoCommand = offCommands[slot];
    }
    public void undoButtonWasPushed() {
        undoCommand.undo();
    }

    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        str.append("\n------ Remote Control Programm ------\n");
        for (int i=0; i<onCommands.length; i++) {
            str.append("[slot " + i + "] " + onCommands[i].getClass().getSimpleName() +
                    "  " + offCommands[i].getClass().getSimpleName() + "\n");
        }
        return str.toString();
    }
}