package net.kiranatos.b7observer.e3spy.interfaces;

import net.kiranatos.b7observer.e3spy.Message;

public interface Observer {
    public String getName();
    public void update(Message information);
}
