package net.kiranatos.patterns.unsorted.creational;

abstract class LaptopBuilder
{
    protected Laptop laptop;
    public void CreateNewLaptop()
    {
        laptop = new Laptop();
    }
    public Laptop GetMyLaptop()
    {
        return laptop;
    }
    //mentioned steps to build laptop
    public abstract void SetMonitorResolution();
    public abstract void SetProcessor();
    public abstract void SetMemory();
    public abstract void SetHDD();
    public abstract void SetBattery();
}

/* Concrete Builder */
class TripLaptopBuilder extends LaptopBuilder
{
    public void SetMonitorResolution()
    {
        laptop.monitorResolution = "1200X800";
    }
    public void SetProcessor()
    {
        laptop.processor = "Celeron 2 GHz";
    }
    public void SetMemory()
    {
        laptop.memory = "2048 Mb";
    }
    public void SetHDD()
    {
        laptop.hDD = "250 Gb";
    }
    public void SetBattery()
    {
        laptop.battery = "12 lbs";
    }
}
/* Concrete Builder */
class GamingLaptopBuilder extends LaptopBuilder
{
    public void SetMonitorResolution()
    {
        laptop.monitorResolution = "1900X1200";
    }
    public void SetProcessor()
    {
        laptop.processor = "Core 2 Duo, 3.2 GHz";
    }
    public void SetMemory()
    {
        laptop.memory = "6144 Mb";
    }
    public void SetHDD()
    {
        laptop.hDD = "500 Gb";
    }
    public void SetBattery()
    {
        laptop.battery = "6 lbs";
    }
}
/* Director */
class BuyLaptop
{
    private LaptopBuilder _laptopBuilder;
    public void SetLaptopBuilder(LaptopBuilder lBuilder)
    {
        _laptopBuilder = lBuilder;
    }
    // Змушує будівельника повернути цілий ноутбук
    public Laptop GetLaptop()
    {
        return _laptopBuilder.GetMyLaptop();
    }
    // Змушує будівельника додавати деталі
    public void ConstructLaptop()
    {
        _laptopBuilder.CreateNewLaptop();
        _laptopBuilder.SetMonitorResolution();
        _laptopBuilder.SetProcessor();
        _laptopBuilder.SetMemory();
        _laptopBuilder.SetHDD();
        _laptopBuilder.SetBattery();
    }
}
class Laptop
{
    public String processor;
    public String memory;
    public String monitorResolution;
    public String hDD;
    public String battery;

    public String toString()
    {
        return String.format("Laptop: %s, %s, %s, %s, %s", monitorResolution, processor, memory, hDD, battery);
    }
}


/* Client Code */
public class BuilderDemo
{
    public static void Run()
    {
        //Your system could have bulk of builders
        LaptopBuilder tripBuilder = new TripLaptopBuilder();
        LaptopBuilder gamingBuilder = new GamingLaptopBuilder();
        BuyLaptop shopForYou = new BuyLaptop();//director
        shopForYou.SetLaptopBuilder(gamingBuilder);//Customer answered that he wants to play
        shopForYou.ConstructLaptop();
        Laptop laptop = shopForYou.GetLaptop();//just get what he wants
        System.out.println(laptop);
    }
}
