package net.kiranatos.c3factorymethod.e1pizza;

import java.util.ArrayList;

/**
 * Сьерра К., Бейтс Б., Фримен Э., Фримен Э. - Паттерны проектирования (2011-656-1)
 * c 141-162
 */

public class FactoryMethodPizza {
    public static void main(String[] args) {        
        PizzaStore nyStore = new NYPizzaStore();
        PizzaStore chicagoStore = new ChicagoPizzaStore();
        
        System.out.println("========== New York ===========");        
        Pizza pizza = nyStore.orderPizza("cheese");
        System.out.println(pizza.getName());
        
        System.out.println("========== Chicago ===========");        
        pizza = chicagoStore.orderPizza("cheese");
        System.out.println(pizza.getName());
    }    
}

// Creator
abstract class PizzaStore {    
    public Pizza orderPizza(String type) {
        Pizza pizza = createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
   
    protected abstract Pizza createPizza(String type); // abstract fabric method
}

// Product
abstract class Pizza {
    String name;
    String dough;
    String sauce;
    ArrayList toppings = new ArrayList();
    
    void prepare() {
        System.out.println("Добавлены ингредиенты: " + name);
        for (int i = 0; i < toppings.size(); i++) { System.out.print(toppings.get(i));  }
    }
    
    public void bake(){ System.out.println("Standart bake"); }
    public void cut(){ System.out.println("Standart cut"); }
    public void box(){ System.out.println("Standart box"); }
    public String getName(){ return name;}
}

/** ConcreteCreator
 *  New York Pizza Store
 */
class NYPizzaStore extends PizzaStore {
    @Override
    protected Pizza createPizza(String type) {
        switch (type) {
            case "cheese"   : return new NYStyleCheesePizza();
            case "veggi"    : return new NYStyleVeggiPizza();
            default         : return new NYStyleOriginalPizza();
        }
    }
}

/** ConcreteCreator
 *  Chicago Pizza Store
 */
class ChicagoPizzaStore extends PizzaStore {
    @Override
    protected Pizza createPizza(String type) {
        switch (type) {
            case "cheese"   : return new ChicagoStyleCheesePizza();
            case "veggi"    : return new ChicagoStyleVeggiPizza();
            default         : return new ChicagoStyleOriginalPizza();
        }
    }
}

// ConcreteProduct
class NYStyleCheesePizza extends Pizza {
    public NYStyleCheesePizza() {
        name = "NY Style Sauce and Cheese Pizza";
        dough = "Thin Crust Dough";
        sauce = "Marinara Sauce";
        toppings.add("Grated Reggiano Cheese");
    }    
}

// ConcreteProduct
class NYStyleVeggiPizza extends Pizza {
    public NYStyleVeggiPizza() {
        name = "NY Style Sauce and Cheese Pizza";
        dough = "Thin Crust Dough";
        sauce = "Marinara Sauce";
        toppings.add("For Vegatarian");
    }    
}

// ConcreteProduct
class NYStyleOriginalPizza extends Pizza {
    public NYStyleOriginalPizza() {
        name = "NY Style Sauce and Cheese Pizza";
        dough = "Thin Crust Dough";
        sauce = "Marinara Sauce";
        toppings.add("Standart NY pizza");
    }    
}

// ConcreteProduct
class ChicagoStyleCheesePizza extends Pizza {
    public ChicagoStyleCheesePizza() {
        name = "Chicago Style Deep Dish Cheese Pizza";
        dough = "Extra Thick Dough";
        sauce = "Plum Tomato Sauce";
        toppings.add("Shredded Mozzarella Cheese");
    }    
    @Override
    public void cut() { System.out.println("Chicago cutting"); }
}

// ConcreteProduct
class ChicagoStyleVeggiPizza extends Pizza {
    public ChicagoStyleVeggiPizza() {
        name = "Chicago Style Deep Dish Cheese Pizza";
        dough = "Extra Thick Dough";
        sauce = "Plum Tomato Sauce";
        toppings.add("Shredded Mozzarella Cheese");
    }    
    @Override
    public void cut() { System.out.println("Chicago cutting"); }
}

// ConcreteProduct
class ChicagoStyleOriginalPizza extends Pizza {
    public ChicagoStyleOriginalPizza() {
        name = "Chicago Style Deep Dish Cheese Pizza";
        dough = "Extra Thick Dough";
        sauce = "Plum Tomato Sauce";
        toppings.add("Shredded Mozzarella Cheese");
    }    
    @Override
    public void cut() { System.out.println("Chicago cutting"); }
}
