package net.kiranatos.c3factorymethod;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import net.kiranatos.OzoHelper;
import net.kiranatos.c3factorymethod.e1pizza.FactoryMethodPizza;
import net.kiranatos.c3factorymethod.e2watch.FactoryMethodWatch;
import net.kiranatos.c3factorymethod.e3log.FactoryMethodLogger;
import net.kiranatos.c3factorymethod.e4wiki.FactoryMethodWikiExample;


public class StartFactoryMethod {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static String theChoice;
    public static void main(String[] args) {        
        System.out.println("\n\n"
                + "\n#######################################################################################"                
                + "\n############# Factory Method или Virtual Constructor ###########"
                + "\n#######################################################################################");
        System.out.println("Type: Creational \n"
                + "Define an interface for creating an object, but let subclasses decide which class to instantiate. Lets a class defer instantiation to subclasses.\n"
                + "Родственные шаблоны: Abstract Factory, Prototype, Template Method, DAO");
        System.out.println("Choose examples:"
                + "\n  1. Factory Method PizzaStore -> Pizza [Book: Сьерра К. Паттерны проектирования]"
                + "\n  2. Factory Method WatchMaker -> Watch [source lost]"
                + "\n  3. Factory Method LoggerProviderFactory -> ILogger [source lost]"
                + "\n  4. Factory Method Creator -> Product [source: ru.wikipedia.org]"
                
                
                
                + "\n  9. "
                + "\n 10. "
                + "\n exit");
        
        theChoice = OzoHelper.getRead();
        System.out.println("Your choice: " + theChoice + "\n");
        
        switch (theChoice) {
            case "1": FactoryMethodPizza.main(null);                break;
            case "2": FactoryMethodWatch.main(null);                break;
            case "3": FactoryMethodLogger.main(null);               break;
            case "4": FactoryMethodWikiExample.main(null);          break;

            case "exit": System.exit(0); break;
            default: 
                System.out.println("Incorrect choice !!!");                
                break;
        }        
    }    
}
