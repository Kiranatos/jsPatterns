package net.kiranatos.b7observer.e3spy;

import net.kiranatos.b7observer.e3spy.people.Bandit;

public class CorruptionOrganization {
    
    private Congress congress;
    private Bandit[] bandits;

    public CorruptionOrganization(Congress congress) {
        this.congress = congress;
    }
    
    public void start(){        
      int random = 1 + (int) (Math.random() * 100);
      bandits = new Bandit[random];
      for (int i=0; i < bandits.length; i++) {
            String str = "Бандит №" + i;            
            bandits[i] = new Bandit(this.congress, str);
        }
    }
    
}
