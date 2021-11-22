package net.kiranatos.b2command.e06hdev.recivers;

public class TV {
    public void on() { System.out.println("Телевизор включен"); }
    public void off() { System.out.println("Телевизор выключен"); }
    public void setInputChannel(int channel) { System.out.println("Включён канал " + channel + " на телевизоре"); }
    public void setVolume(int vol) { System.out.println("Сделан звук "+ vol +" !"); }
}
