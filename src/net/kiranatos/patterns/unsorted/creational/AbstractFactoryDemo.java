package net.kiranatos.patterns.unsorted.creational;

// abstract factory
interface IToyFactory
{
    Bear GetBear();
    Cat GetCat();
}
// concrete factory
class TeddyToysFactory implements IToyFactory
{
    public Bear GetBear()
    {
        return new TeddyBear();
    }
    public Cat GetCat()
    {
        return new TeddyCat();
    }
}
// concrete factory
class WoodenToysFactory implements IToyFactory
{
    public Bear GetBear()
    {
        return new WoodenBear();
    }
    public Cat GetCat()
    {
        return new WoodenCat();
    }
}

abstract class AnimalToy
{
    private String name;
    protected AnimalToy(String _name)
    {
        name = _name;
    }
    public String getName() {
        return name;
    }
}
abstract class Cat extends AnimalToy
{
    protected Cat(String name) {
        super(name);
    }
}
abstract class Bear extends AnimalToy
{
    protected Bear(String name){
        super(name);
    }
}
class WoodenCat extends Cat
{
    public WoodenCat() {
        super("Wooden Cat");
    }
}
class TeddyCat extends Cat
{
    public TeddyCat() {
        super("Teddy Cat");
    }
}
class WoodenBear extends Bear
{
    public WoodenBear() {
        super("Wooden Bear");
    }
}
class TeddyBear extends Bear
{
    public TeddyBear(){
        super("Teddy Bear");
    }
}

public class AbstractFactoryDemo
{
    public static void Run()
    {
        RunWoodenFactory();
        RunTeddyFactory();
    }

    private static void RunWoodenFactory()
    {
        // lets start with wooden factory
        IToyFactory toyFactory = new WoodenToysFactory();

        Bear bear = toyFactory.GetBear();
        Cat cat = toyFactory.GetCat();
        System.out.printf("I've got %s and %s\n", bear.getName(), cat.getName());
    }

    private static void RunTeddyFactory()
    {
        // and now teddy one
        IToyFactory toyFactory = new TeddyToysFactory();

        Bear bear = toyFactory.GetBear();
        Cat cat = toyFactory.GetCat();
        System.out.printf("I've got %s and %s\n", bear.getName(), cat.getName());
    }
}
