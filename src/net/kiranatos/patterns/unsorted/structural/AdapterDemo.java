package net.kiranatos.patterns.unsorted.structural;

class OldElectricitySystem
{
    public String MatchThinSocket()
    {
        return "220V";
    }
}
interface INewElectricitySystem
{
    String MatchWideSocket();
}
class NewElectricitySystem implements INewElectricitySystem
{
    public String MatchWideSocket()
    {
        return "220V";
    }
}
class Adapter implements INewElectricitySystem
{
    private final OldElectricitySystem _adaptee;
    public Adapter(OldElectricitySystem adaptee)
    {
        _adaptee = adaptee;
    }
    public String MatchWideSocket()
    {
        return _adaptee.MatchThinSocket();
    }
}
class ElectricityConsumer
{
    public static void ChargeNotebook(INewElectricitySystem electricitySystem)
    {
        System.out.println(electricitySystem.MatchWideSocket());
    }
}
public class AdapterDemo
{
    public static void Run()
    {
        // 1)
        // Ми можемо і надалі користувати нашою новою системою
        INewElectricitySystem newElectricitySystem = new NewElectricitySystem();
        ElectricityConsumer.ChargeNotebook(newElectricitySystem);

        // 2)
        // Ми повинні адаптуватися до старої системи, використовуючи адаптер
        OldElectricitySystem oldElectricitySystem = new OldElectricitySystem();
        INewElectricitySystem adapter = new Adapter(oldElectricitySystem);
        ElectricityConsumer.ChargeNotebook(adapter);
    }
}
