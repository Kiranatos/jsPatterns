package net.kiranatos.patterns.strategy;

import java.util.Random;
import java.util.UUID;

/** 1.3 Functions are objects
 * Artyom Burylov, из курса Java. Functional programming — 1 Theory lessons "Java. Functional programming"
 * 
 * Example: Our domain is generating an account number using different algorithms.
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
 * - без лямба-выражений
 * - вместо интерфейса используется абстрактный класс
 */
public class Ex04v1_Stepik {
    public static void main(String[] args) {
        // an example of using UUIDGeneratingStrategy
        final NumberGenerator uuidGenerator = new NumberGenerator(new UUIDGenerationStrategy());
        System.out.println(uuidGenerator.generate());
        
        // an example of using FormattedRandomGenerationStrategy
        final NumberGenerator randomGenerator = new NumberGenerator(new FormattedRandomGenerationStrategy());
        System.out.println(randomGenerator.generate());
    }
}


/***************************************** Strategy Client (Context)
  * Generates an account number using a generation strategy
  */
class NumberGenerator {
    // This may be any subclass of GenerationStrategy
    private final GenerationStrategy strategy;
    public NumberGenerator(GenerationStrategy strategy) { this.strategy = strategy; }    
    public GenerationStrategy getStrategy()             { return strategy; }
    public String generate()                            { return strategy.generate(); }
}

/***************************************** Abstract class and his strateges
  * Abstract generation strategy
  */
abstract class GenerationStrategy {
    abstract String generate();
}

/**
  * Concrete generation strategy. It generates number based on UUID
  */
class UUIDGenerationStrategy extends GenerationStrategy{
    @Override
    public String generate() {
        return "UUID:\t" + UUID.randomUUID().toString();
    }
}

/**
  * Concrete generation strategy. It generates number based on the prefix and a random value
  */
class FormattedRandomGenerationStrategy extends GenerationStrategy{
    private final Random random = new Random();
    @Override
    public String generate() {
        return "Random:\t111-123-" + Math.abs(random.nextInt());
    }
}