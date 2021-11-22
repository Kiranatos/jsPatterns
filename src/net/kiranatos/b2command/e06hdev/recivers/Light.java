package net.kiranatos.b2command.e06hdev.recivers;

//Reciver
public class Light{
    String room;
    public Light(String room) { this.room = room; }    
    public void on(){ System.out.println("Свет включён в " + room); }
    public void off(){ System.out.println("Лампочку украли в " + room); }    
    public void dim() { System.out.println("Включён Тусклый свет в " + room); }
}