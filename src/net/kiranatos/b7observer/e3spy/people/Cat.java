package net.kiranatos.b7observer.e3spy.people;

import net.kiranatos.b7observer.e3spy.Congress;
import net.kiranatos.b7observer.e3spy.interfaces.Observer;

public class Cat{
    String name = "кiт Барсiк";
    Congress congress;

    public Cat(Congress congress) {
        this.congress = congress;
    }

    public String getName() { return name; }    
    
    public Boolean action(Observer o){
        int rand = 1 + (int) (Math.random() * 3);
        if (rand==1) {            
            if (o instanceof Bandit) 
                System.out.println(name + " укусив " + o.getName().replaceFirst("Бандит", "Бандита") + ". " + o.getName() + " попав в лікарню! ");
            else 
                System.err.println(name + " укусив " + o.getName().replaceFirst("Агент", "Агента") + ". " + o.getName() + " викритий! ");            
            
            return true;
        }        
        else { 
            System.out.println(getName() + " спить!");
            return false;
        }
    }
            
}