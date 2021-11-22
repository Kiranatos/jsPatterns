package net.kiranatos.patterns.strategy;

/**
 * Java Vision
 * Java паттерны - Strategy стратегия
 * https://www.youtube.com/watch?v=1efuUd2GDR4
 * 
 * Strategy нужен когда необходимо иметь несколько вариантов поведения
 * Похож на паттерн State, Делегат
 */
public class Ex02_JavaVision {
    public static void main(String[] args) {
        Door door = new Door();
        
        DoorStrategy open = new Open();
        door.setStrategy(open);
        door.move();
        
        DoorStrategy close = new Close();
        door.setStrategy(close);
        door.move();
    }    
}

// *************************************** Strategy Client (Context)
class Door {
    private DoorStrategy doorStrategy; /* здесь отличие от шаблона Состояние, взаемодействие со 
    стратегиями идёт через интерфейс и слабую связь */
    public void setStrategy(DoorStrategy doorStrategy) { this.doorStrategy = doorStrategy; }
    public void move() { doorStrategy.openClose(); }
}

// *************************************** Interface and his strateges
interface DoorStrategy {
    void openClose();
}

class Open implements DoorStrategy {
    @Override
    public void openClose() {
        System.out.println("Door is open.");
    }
}

class Close implements DoorStrategy {
    @Override
    public void openClose() {
        System.out.println("Door is close.");
    }
}