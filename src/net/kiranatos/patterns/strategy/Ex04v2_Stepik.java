package net.kiranatos.patterns.strategy;

import java.util.Random;
import java.util.UUID;

/** 1.3 Functions are objects
 * Artyom Burylov, из курса Java. Functional programming — 1 Theory lessons "Java. Functional programming"
 * 
 * Example: Our domain is generating an account number using different algorithms. * 
 * 
 * You can find more information about writing design patterns in functional style this:
 * 1) Richard Warburton. Java 8 Lambdas
 * 2) Raoul-Gabriel Urma, Mario Fusco, and Alan Mycroft. Java 8 in Action
 * 
 * Дубликат данного класа, также скопирован в проект NetCourses в пакет: stepik.java_adaptive.functional.theory
 * Последнее изменение: 17.12.17
 */

/**
 * Пример шаблона "Стратегия"
 * - с лямба-выражениями
 * - благодаря функциональному интерфейсу, создавать реализации стратегий можно прямо в main,
 * а не в отдельных классах
 */
public class Ex04v2_Stepik {
    public static void main(String[] args) {        
        // It's instead of UUIDGeneratingStrategy
        final NumberGenerator_v2 uuidGenerator = new NumberGenerator_v2(
                () -> "UUID:\t" + UUID.randomUUID().toString()
        );
        System.out.println(uuidGenerator.generate());
        
        
        final Random random = new Random();
        // Another simple generator for tests purposes
        final NumberGenerator_v2 testGenerator = new NumberGenerator_v2(
                () -> "Random:\t111-123-" + String.valueOf(random.nextInt(100))
        );
        System.out.println(testGenerator.generate());
    }
}


/***************************************** Strategy Client (Context)
  * Generates an account number using a generation strategy
  */
    class NumberGenerator_v2 {
    // This may be any subclass of GenerationStrategy
    private final GenerationStrategy_v2 strategy;
    public NumberGenerator_v2(GenerationStrategy_v2 strategy)   { this.strategy = strategy; }    
    public GenerationStrategy_v2 getStrategy()                  { return strategy; }
    public String generate()                                    { return strategy.generate(); }
}

/***************************************** Functional interface and his strateges
  * Functional interface for the abstract generation strategy.
  * It's a String supplier
  */
@FunctionalInterface
interface GenerationStrategy_v2 {
    String generate();
}