package net.kiranatos.b2command.e09file;

import net.kiranatos.b2command.e09file.command.Command;

public class FileInvoker {
    public Command command;

    public FileInvoker(Command c) {
        this.command = c;
    }

    public void execute() {
        this.command.execute();
    }
}
