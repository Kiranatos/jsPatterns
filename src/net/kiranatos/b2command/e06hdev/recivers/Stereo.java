package net.kiranatos.b2command.e06hdev.recivers;

public class Stereo {    
    public void on() { System.out.println("Магнитофон включён"); };
    public void off() { System.out.println("Магнитофон разбит кирпичём"); };
    public void setCd() { System.out.println("Диск CD вставлен"); };
    public void setDvd() { System.out.println("Да это ж DVD !"); };
    public void setRadio() { System.out.println("Слушаем шпионское радио"); };
    public void setVolume(int a) { System.out.println("Звук на " + a + "!"); };    
}
