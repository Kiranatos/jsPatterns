package net.kiranatos.b2command.e09file.command;

import net.kiranatos.b2command.e09file.recivers.FileSystemReceiver;

public class CloseFileCommand implements Command {
    private FileSystemReceiver fileSystem;

    public CloseFileCommand(FileSystemReceiver fs) {
        this.fileSystem = fs;
    }

    @Override
    public void execute() {
        this.fileSystem.closeFile();
    }
}
