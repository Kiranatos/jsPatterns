package net.kiranatos.c3factorymethod.e4wiki;

public class FactoryMethodWikiExample {
    public static void main(String[] args) {        
        Creator[] creators = {new ConcreteCreatorA(), new ConcreteCreatorB()}; // an array of creators
        
        for (Creator creator: creators) { // iterate over creators and create products
            Product product = creator.factoryMethod();
            System.out.printf("Created {%s}\n", product.getClass());
        }
    }
}

// Creator
abstract class Creator {
    public abstract Product factoryMethod();
}

// Product
interface Product { }

// ConcreteCreator
class ConcreteCreatorA extends Creator {
    @Override
    public Product factoryMethod() { return new ConcreteProductA(); }
}

// ConcreteCreator
class ConcreteCreatorB extends Creator {
    @Override
    public Product factoryMethod() { return new ConcreteProductB(); }
}

// ConcreteProduct
class ConcreteProductA implements Product { }
class ConcreteProductB implements Product { }
