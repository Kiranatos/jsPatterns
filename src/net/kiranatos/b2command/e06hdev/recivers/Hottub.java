package net.kiranatos.b2command.e06hdev.recivers;

public class Hottub {
    public void on() { System.out.println("Ванна наполнена, Господин!"); }
    public void off() { System.out.println("Вода испарилась"); }
    public void circulate() { System.out.println("Циркуляция воды в ванной включена"); }
    public void jetsOn() { System.out.println("Режим джакузи включен. Кот упал у ванну."); }
    public void jetsOff() { System.out.println("Режим джакузи выключен. Кот выбрался из ванной."); }
    public void setTemperature() { System.out.println("Вода в ванной нагревается"); }
}
