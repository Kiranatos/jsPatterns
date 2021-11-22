package net.kiranatos.b2command.e09file.command;

import net.kiranatos.b2command.e09file.recivers.FileSystemReceiver;

public class OpenFileCommand implements Command {
    private FileSystemReceiver fileSystem;

    public OpenFileCommand(FileSystemReceiver fs) {
        this.fileSystem = fs;
    }

    @Override
    public void execute() {
        this.fileSystem.openFile(); //open command is forwarding request to openFile method
    }
}
