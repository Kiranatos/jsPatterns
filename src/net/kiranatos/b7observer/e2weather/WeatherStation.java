package net.kiranatos.b7observer.e2weather;

/**
 * Сьерра К., Бейтс Б., Фримен Э., Фримен Э. - Паттерны проектирования (2011-656-1).
 * стр. 71 глава 2
*/

public class WeatherStation {
    public static void main(String[] args) {
        System.out.println("\nExample from book: \n"
                + "Сьерра К., Бейтс Б., Фримен Э., Фримен Э. - Паттерны проектирования (2011-656-1)"
                + "стр. 71 глава 2\n");
        System.out.println("Used class java.util.Observable already DEPRACATED since Java 9\n");
        
        WeatherData wD = new WeatherData();
        CurrentConditionsDisplay ccD = new CurrentConditionsDisplay(wD);
        ForecastDisplay fD = new ForecastDisplay(wD);
        // CurrentConditionsDisplay ccD = new CurrentConditionsDisplay(wD);
        
        wD.setMeasurements(80, 60, 30.5f);
        wD.setMeasurements(70, 50, 31.5f);
        wD.setMeasurements(90, 60, 32.5f);
    }    
}
