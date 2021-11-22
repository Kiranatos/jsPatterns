package net.kiranatos.c3factorymethod.e2watch;

/**
 * В данном примере класс-создатель и класс-продукт просто параллельные классы.
 * И класс-создатель только и делает, что создает экземпляр класса-продукта.
 * Пример был бы более полноценный, если бы класс-создатель помимо создания
 * экземпляра класса-продукта делал бы еще какую либо работу, что и предполагается на практике.﻿ 
 */
public class FactoryMethodWatch {    
    private static WatchMaker getMakerNyName(String maker) {
        if (maker.equals("Digital")) return new DigitalWatchMaker();
        else if (maker.equals("Rome")) return new RomeWatchMaker();
        throw new RuntimeException("Erorr " + maker);
    }
    
    public static void main(String[] args) {        
        //WatchMaker maker = new DigitalWatchMaker();
        WatchMaker maker = getMakerNyName("Rome");
        /** Изменяя код который находится вверху,
         * фабричный метод помогает делать неизменным код,
         * который нахоится ниже:               */
        Watch watch = maker.createWatch();
        watch.showTime();
    }    
}

// Creator
interface WatchMaker {
    Watch createWatch(); // abstract fabric method
}

// Product
interface Watch { void showTime(); }

// ConcreteCreator
class DigitalWatchMaker implements WatchMaker {
    public Watch createWatch() {
     return new DigitalWatch();   
    }    
}

// ConcreteCreator
class RomeWatchMaker implements WatchMaker {
    public Watch createWatch() {
     return new RomeWatch();   
    }    
}

// ConcreteProduct
class DigitalWatch implements Watch {
    public void showTime() {
        System.out.println("11:30");
    }
}

// ConcreteProduct
class RomeWatch implements Watch {
    public void showTime() {
        System.out.println("VII-XII");
    }
}