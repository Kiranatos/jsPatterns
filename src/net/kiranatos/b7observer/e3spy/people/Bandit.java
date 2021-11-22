package net.kiranatos.b7observer.e3spy.people;

import net.kiranatos.b7observer.e3spy.Congress;
import net.kiranatos.b7observer.e3spy.Message;
import net.kiranatos.b7observer.e3spy.interfaces.Observer;

public class Bandit implements Observer {
    private Congress congress;
    private String name;
    
     public Bandit(Congress congress, String name) {
        this.congress = congress;        
        this.name = name;
        congress.registerObserver(this);        
    }

    @Override
    public String getName() { return name; }
    @Override
    public String toString() { return name; }

    @Override
    public void update(Message information) {        
    }    
}
