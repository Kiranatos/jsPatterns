package net.kiranatos.patterns.strategy;

import java.io.File;

/**
 * Roman Brovko
 * 10 - Design Patterns. Strategy
 * Лектор: Тимур Батыршинов (http://javabegin.ru)
 * https://www.youtube.com/watch?v=u6eWG4dky7g
 * 
 * Похож на паттерн State, Делегат
 */
public class Ex01_Brovko {
    public static void main(String[] args) {
        UserChecker userChecker = new UserChecker();
        userChecker.check(new DBAuth("jdbc:/etc"));
        userChecker.check(new FileAuth(new File("file.txt")));
    }
}

// *************************************** Strategy Client (Context)
class UserChecker {
    private String name;
    private String password;
    public void setName(String name)            { this.name = name; }
    public void setPassword(String password)    { this.password = password; }
    public String getName()                     { return name; }
    public String getPassword()                 { return password; }
    
    public boolean check(AuthStrategy authStrategy){
        return authStrategy.checkLogin(name, password);
    }
}

// *************************************** Interface and his strateges
interface AuthStrategy {
    boolean checkLogin(String name, String password);
}

class FileAuth implements AuthStrategy {
    private File file;

    public FileAuth(File file) { this.file = file; }
    
    @Override
    public boolean checkLogin(String name, String password) {
        System.out.println("Checking with file...");
        return checkFromFile();
    }
    
    private boolean checkFromFile() { return true; }
}

class DBAuth implements AuthStrategy {
    private String dbUrl;

    public DBAuth(String dbUrl) { this.dbUrl = dbUrl; }
    private void createConnection(String dbUrl) { }
    
    @Override
    public boolean checkLogin(String name, String password) {
        System.out.println("Checking with Data Base...");
        String userHash = getHash(name);
        String passHash = getHash(password);
        return checkUser(userHash, passHash);
    }
    
    private boolean checkUser(String name, String pass) { return true; }
    private String getHash(String value){ return "25DF7R8"; }
}

