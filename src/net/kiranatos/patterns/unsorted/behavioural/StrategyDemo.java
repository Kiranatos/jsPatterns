package net.kiranatos.patterns.unsorted.behavioural;

/**
 * Created by ss on 03.09.14.
 */
interface IWearingStrategy
{
    String GetClothes();
    String GetAccessories();
}
class SunshineWearingStrategy implements IWearingStrategy
{
    public String GetClothes()
    {
        return "T-Shirt";
    }
    public String GetAccessories()
    {
        return "sunglasses";
    }
}

class RainWearingStrategy implements IWearingStrategy
{
    public String GetClothes()
    {
        return "Coat";
    }
    public String GetAccessories()
    {
        return "umbrella";
    }
}
class SnowWearingStrategy implements IWearingStrategy
{
    public String GetClothes()
    {
        return "Tulup";
    }
    public String GetAccessories()
    {
        return "Ski";
    }
}

class DefaultWearingStrategy implements IWearingStrategy
{
    public String GetClothes()
    {
        return "whateveryoulike";
    }
    public String GetAccessories()
    {
        return "nothing";
    }
}
class Myself
{
    private IWearingStrategy _wearingStrategy = new DefaultWearingStrategy();

    public void ChangeStrategy(IWearingStrategy wearingStrategy)
    {
        _wearingStrategy = wearingStrategy;
    }
    public void GoOutside()
    {
        String clothes = _wearingStrategy.GetClothes();
        String accessories = _wearingStrategy.GetAccessories();
        System.out.printf("Today I wore %s and took %s\n", clothes, accessories);
    }
}



class Weather
{
    public static String GetWeather()
    {
        return "snow";
    }
}

public class StrategyDemo
{
    public static void Run()
    {
        Myself me = new Myself();
        me.ChangeStrategy(new RainWearingStrategy());
        me.GoOutside();
        me.ChangeStrategy(new SunshineWearingStrategy());
        me.GoOutside();
        me.ChangeStrategy(new SnowWearingStrategy());
        me.GoOutside();
    }
}


class Myself_BeforeStrategyDP
{
    public void GoOutside()
    {
        String weather = Weather.GetWeather();
        String clothes = GetClothes(weather);
        String accessories = GetAccessories(weather);
        System.out.printf("Today I wore %s and took %s\n", clothes, accessories);
    }

    private String GetAccessories(String weather)
    {
        String accessories;
        switch (weather)
        {
            case "sun":
                accessories = "sunglasses";
                break;
            case "rain":
                accessories = "umbrella";
                break;
            default:
                accessories = "nothing";
                break;
        }
        return accessories;
    }

    private String GetClothes(String weather)
    {
        String clothes;
        switch (weather)
        {
            case "sun":
                clothes = "T-Shirt";
                break;
            case "rain":
                clothes = "Coat";
                break;
            default:
                clothes = "Shirt";
                break;
        }
        return clothes;
    }
}