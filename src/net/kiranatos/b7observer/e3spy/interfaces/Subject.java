package net.kiranatos.b7observer.e3spy.interfaces;

import net.kiranatos.b7observer.e3spy.Message;

public interface Subject {
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers(Message information);
}
