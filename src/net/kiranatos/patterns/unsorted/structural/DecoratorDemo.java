package net.kiranatos.patterns.unsorted.structural;

class Car
{
    private String brandName;
    public void Go()
    {
        System.out.println("I'm " + getBrandName() + " and I'm on my way...");
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
}

abstract class DecoratorCar extends Car
{
    private Car decoratedCar;
    public DecoratorCar(Car decoratedCar)
    {
        this.decoratedCar = decoratedCar;
    }
    public  void Go()
    {
        decoratedCar.Go();
    }

    public Car getDecoratedCar() {
        return decoratedCar;
    }

    public void setDecoratedCar(Car decoratedCar) {
        this.decoratedCar = decoratedCar;
    }
}
class AmbulanceCar extends DecoratorCar
{
    public AmbulanceCar(Car decoratedCar)
    {
        super(decoratedCar);
    }
    public  void Go()
    {
        super.Go();
        System.out.println("... beep-beep-beeeeeep ...");
    }
}
class FireCar extends DecoratorCar
{
    public FireCar(Car decoratedCar)
    {
        super(decoratedCar);
    }
    public  void Go()
    {
        super.Go();
        System.out.println("... fireeeeeee!!!!!! ...");
    }
}
class Mersedes extends Car
{
    public Mersedes()
    {
        setBrandName("Mersedes");
    }
}
class BMW extends Car
{
    public BMW()
    {
        setBrandName("BMW");
    }
}
public class DecoratorDemo
{
    public static void Run()
    {
        DecoratorCar doctorsDream = new AmbulanceCar(new Mersedes());
        DecoratorCar fireCar = new FireCar(new BMW());
        DecoratorCar fireAmbulanceCar = new FireCar(new AmbulanceCar(new BMW()));
        doctorsDream.Go();
        fireCar.Go();
        fireAmbulanceCar.Go();
    }
}