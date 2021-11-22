package net.kiranatos.patterns.unsorted.behavioural;
import java.util.*;
abstract class WierdCafeVisitor
{
    private WierdCafeVisitor cafeVisitor;
    protected WierdCafeVisitor(WierdCafeVisitor cafeVisitor)
    {
        this.cafeVisitor = cafeVisitor;
    }
    public void HandleFood(Food food)
    {
        // If I cannot handle other food, passing it to my successor
        if (cafeVisitor != null)
        {
            cafeVisitor.HandleFood(food);
        }
    }

    public WierdCafeVisitor getCafeVisitor() {
        return cafeVisitor;
    }

    public void setCafeVisitor(WierdCafeVisitor cafeVisitor) {
        this.cafeVisitor = cafeVisitor;
    }
}

class GirlFriend extends WierdCafeVisitor
{
    public GirlFriend(WierdCafeVisitor cafeVisitor)
    {
        super(cafeVisitor);
    }
    public void HandleFood(Food food)
    {
        if (food.getName().equals("Cappuccino"))
        {
            System.out.println("GirlFriend: My lovely cappuccino!!!");
            return;
        }
        super.HandleFood(food);
    }
}

class Me extends WierdCafeVisitor
{
    public Me(WierdCafeVisitor cafeVisitor)
    {
        super(cafeVisitor);
    }
    public void HandleFood(Food food)
    {
        if (food.getName().contains("Soup"))
        {
            System.out.println("Me: I like Soup. It went well.");
            return;
        }
        super.HandleFood(food);
    }
}

class BestFriend extends WierdCafeVisitor
{
    private LinkedList<Food> coffeeContainingFood;
    public BestFriend(WierdCafeVisitor cafeVisitor)
    {
        super(cafeVisitor);
        coffeeContainingFood = new LinkedList<Food>();
    }
    public void HandleFood(Food food)
    {
        if (food.getIngradients().contains("Meat"))
        {
            System.out.println("BestFriend: I just ate " + food.getName() + ". It was testy.");
            return;
        }
        if (food.getIngradients().contains("Coffee") && coffeeContainingFood.size() < 1)
        {
            coffeeContainingFood.add(food);
            System.out.println("BestFriend: I have to take something with coffee. " + food.getName() + " looks fine.");
            return;
        }
        super.HandleFood(food);
    }
    public LinkedList<Food> getcoffeeContainingFood() {
        return coffeeContainingFood;
    }
    public void setcoffeeContainingFood(LinkedList<Food> coffeeContainingFood) {
        this.coffeeContainingFood = coffeeContainingFood;
    }
}

class Food
{
    public Food(String name, LinkedList<String> ingradients)
    {
        this.name = name;
        this.ingradients = ingradients;
    }

    private LinkedList<String> ingradients;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LinkedList<String> getIngradients() {
        return ingradients;
    }

    public void setIngradients(LinkedList<String> ingradients) {
        this.ingradients = ingradients;
    }
}

public class ChainOfResponsibilityDemo
{
    public static void Run()
    {
        Food cappuccino2 = new Food("Cappuccino", new LinkedList<String>(Arrays.asList( "Coffee", "Milk")));
        Food cappuccino1 = new Food("Cappuccino", new LinkedList<String>(Arrays.asList( "Coffee", "Milk", "Sugar")));
        Food soup1 = new Food("Soup with meat", new LinkedList<String>(Arrays.asList( "Meat", "Water", "Potato")));
        Food soup2 = new Food("Soup with potato", new LinkedList<String>(Arrays.asList( "Water", "Potato")));
        Food meat = new Food("Meat", new LinkedList<String>(Arrays.asList( "Meat" )));

        GirlFriend girlFriend = new GirlFriend(null);
        Me me = new Me(girlFriend);
        BestFriend bestFriend = new BestFriend(me);

        bestFriend.HandleFood(cappuccino1);
        bestFriend.HandleFood(cappuccino2);
        bestFriend.HandleFood(soup1);
        bestFriend.HandleFood(soup2);
        bestFriend.HandleFood(meat);
    }
}
