package net.kiranatos.b2command.e09file;

import net.kiranatos.b2command.e09file.recivers.UnixFileSystemReceiver;
import net.kiranatos.b2command.e09file.recivers.FileSystemReceiver;
import net.kiranatos.b2command.e09file.recivers.WindowsFileSystemReceiver;

public class FileSystemReceiverUtil {
    public static FileSystemReceiver getUnderlyingFileSystem() {
        String osName = System.getProperty("os.name");
        System.out.println("Underlying OS is: " + osName);
        if (osName.contains("Windows")) {
            return new WindowsFileSystemReceiver();
        } else {
            return new UnixFileSystemReceiver();
        }
    }
}
