package net.kiranatos.b2command.e09file;

import net.kiranatos.b2command.e09file.recivers.FileSystemReceiver;
import net.kiranatos.b2command.e09file.command.CloseFileCommand;
import net.kiranatos.b2command.e09file.command.WriteFileCommand;
import net.kiranatos.b2command.e09file.command.OpenFileCommand;

public class FileSystemClient {
    public static void main(String[] args) {
        //Creating the receiver object
        FileSystemReceiver fs = FileSystemReceiverUtil.getUnderlyingFileSystem();
        
        //creating command and associating with receiver
        OpenFileCommand openFileCommand = new OpenFileCommand(fs);        
        FileInvoker file = new FileInvoker(openFileCommand); //Creating invoker and associating with Command
        file.execute(); //perform action on invoker object
        
        WriteFileCommand writeFileCommand = new WriteFileCommand(fs);
        file = new FileInvoker(writeFileCommand);
        file.execute();
        
        CloseFileCommand closeFileCommand = new CloseFileCommand(fs);
        file = new FileInvoker(closeFileCommand);
        file.execute();
    }
}
