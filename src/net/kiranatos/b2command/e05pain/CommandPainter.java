package net.kiranatos.b2command.e05pain;

public class CommandPainter {
    public static void main(String[] args) {
        Holst h = new Holst();
        UserInterface ui = new UserInterface(h);
        ui.paint();
        h.show();
        ui.clear();
        h.show();
    }
}

interface Command {
    public void undo();
    public void execute();
}

// ConcreteCommand Классы-команды
class LineCommand implements Command {
    Holst h;
    public LineCommand(Holst h) { this.h = h; }
    @Override
    public void undo() { h.deleteLine(); }
    @Override
    public void execute() { h.showLine(); }
}

// Ресивер
class Holst {
    int line = 0;
    public void showLine() { line++; }
    public void deleteLine() { line--; }
    public void show() { System.out.println(line); }
}

// Инвокер
class UserInterface {
    private Command obj;        
    public UserInterface(Holst h) { obj = new LineCommand(h); }    
    public void paint() { obj.execute(); }
    public void clear() { obj.undo(); }
}