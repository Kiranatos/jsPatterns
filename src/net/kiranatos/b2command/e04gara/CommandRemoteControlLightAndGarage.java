package net.kiranatos.b2command.e04gara;

//Client
public class CommandRemoteControlLightAndGarage {
    public static void main(String[] args) {
        SimpleRemoteControl remote = new SimpleRemoteControl();
        
        Light light = new Light();
        GarageDoor garageDoor = new GarageDoor();
        
        LightOnCommand lightOn = new LightOnCommand(light);
        GarageDoorOpenCommand garageOpen = new GarageDoorOpenCommand(garageDoor);
        
        remote.setCommand(lightOn);
        remote.buttonWasPressed();
        
        remote.setCommand(garageOpen);
        remote.buttonWasPressed();
    }    
}

interface Command { public void execute(); }

//Reciver
class Light{
    public void on(){ System.out.println("Light ON"); }
    public void off() { System.out.println("Light OFF"); }
}
class GarageDoor{
    public void up(){ System.out.println("Gate Up!"); }
    public void down(){ System.out.println("Gate Down!"); }
    public void stop(){ System.out.println("Gate Stopped!"); }
    public void lightOn(){ System.out.println("Gate Light ON"); }
    public void lightOff(){ System.out.println("Gate Light OFF"); }
}

//ConcreteCommand
class LightOnCommand implements Command {    
    Light light;    
    LightOnCommand(Light light) { this.light = light; }    
    public void execute() { light.on(); }
}

class GarageDoorOpenCommand implements Command {    
    GarageDoor garageDoor;    
    GarageDoorOpenCommand(GarageDoor garageDoor) { this.garageDoor=garageDoor; }
    public void execute() { garageDoor.up(); }
}

//invoker
class SimpleRemoteControl {
    Command slot;    
    public void setCommand(Command command) { slot = command; }
    public void buttonWasPressed() { slot.execute(); }
}