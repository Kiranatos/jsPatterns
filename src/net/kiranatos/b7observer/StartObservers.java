package net.kiranatos.b7observer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import net.kiranatos.OzoHelper;

/*
Дивитись видосы не варто -> нічого нового + використовується старий DEPRACATED java.util.Observable
(Examle here #2. Observer WeatherStation from book Сьерра К. Паттерны проектирования - показує в кодi те саме і навіть краще)
    Видео: Java паттерны: Observer (наблюдатель) / https://www.youtube.com/watch?v=raTi3UCusbQ&list=PLu2Tfwn6CfssEYsUtbDGv6ImzwHuYLgGY&index=2&t=0s
    Видео: Урок Java 290: Patterns 23: Observable / https://www.youtube.com/watch?v=PQqZY-QiOVQ&list=PLu2Tfwn6CfssEYsUtbDGv6ImzwHuYLgGY&index=2
(almost the same Examle here #2. Observer WeatherStation from book Сьерра К. Паттерны проектирования - показує в кодi те саме і навіть краще)
    Канал: Vladimir Vysokomornyi / https://www.youtube.com/channel/UCoDVBOHUvfzWAqIl1vXGOhg
        Видео: Шаблоны Java. Наблюдатель (Observer) или Издатель/Подписчик (Publisher/Subscriber) / https://www.youtube.com/watch?v=dRpRiJehdvc&list=PLu2Tfwn6CfssEYsUtbDGv6ImzwHuYLgGY&index=4
*/

public class StartObservers {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static String theChoice;
    public static void main(String[] args) {        
        System.out.println("\n\n"
                + "\n#######################################################################################"                
                + "\n############# Наблюдатель (Observer) или Издатель/Подписчик (Publisher/Subscriber) or Dependents (Подченённые) ###########"
                + "\n#######################################################################################");      
        System.out.println("\t Як я поняв: два типа обєктів - Спостерігач(Субєкт/Подписчик/Subscriber) і Спостерігаємий(Обєкт/Издатель/Publisher). \n"
                + "\t Спостерігач добавляє себе в список через метод Спостерігаємого. \n"
                + "\t Спостерігаємий добавляє Спостерагача в список, але гадки немає ким він є - а потім всіх Спостерігачів зі списку Update-ить одним залпом. \n"
                + "\t Родственные шаблоны: Посредник, Singleton, Proxy \n"
                + "\t ********************************************************************** \n"                
                + "\t HomeWork: подумать над можливими варіантами паттерна -> \n"
                + "\t\t 1) Субєкти можут бути одночасно і Обєктами, тобто Спостерігати друг за другом \n"
                + "\t\t 2) Один Субєкт можеспостерігати одночасно за декфлькома Обєктами \n"
                + "\t\t 3) гра Arkanoid: за шар-обєктом спостерігають інші субєкти(стіни, платформа, цегла) \n"
                + "\t\t 4) пример: Издательство газет и подписчики \n"
                + "");        
        System.out.println("Choose examples:"
                + "\n  1. Observer WeatherStation [Book: Сьерра К. Паттерны проектирования]"
                + "\n  2. Observer WeatherStation [Book: Сьерра К. Паттерны проектирования] (using DEPRACATED java.util.Observable)"
                + "\n  3. Observer Congress, Spies & Bandits [Ігор Деркач: Основи програмування на Java | https://edx.prometheus.org.ua]"
                + "\n  4. Observer TradingIndex [YouTube: Derek Banas]"
                + "\n  5. "
                + "\n  6. "
                + "\n  7. "
                + "\n  8. "
                + "\n  9. "
                + "\n 10. "
                + "\n exit");
        
        theChoice = OzoHelper.getRead();
        System.out.println("Your choice: " + theChoice);
        
        switch (theChoice) {
            case "1": 
                net.kiranatos.b7observer.e1weather.WeatherStation.main(null);
                break;
            case "2":
                net.kiranatos.b7observer.e2weather.WeatherStation.main(null);
                break;
            case "3": 
                net.kiranatos.b7observer.e3spy.StartGame.main(null);
                break;
            case "4": 
                net.kiranatos.b7observer.e4.GrabStocks.main(null);
                break;
            case "exit": 
                System.exit(0);
                break;
            default: 
                System.out.println("Incorrect choice !!!");                
                break;
        }        
    }    
}
