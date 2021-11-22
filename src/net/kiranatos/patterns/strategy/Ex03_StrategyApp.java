package net.kiranatos.patterns.strategy;

import java.util.Arrays;

/**
 * Школа программирования
 * Шаблоны Java. Стратегия (Strategy)
 * https://www.youtube.com/watch?v=0Ra90O1lakE
 * 
 * Похож на паттерн State, Делегат
 */
public class Ex03_StrategyApp {
    public static void main(String[] args) {
        StrategyClient c = new StrategyClient();
        
        int[] arr0 = {1,3,2,1};
        c.setStrategy(new SelectionSort());
        c.executeStrategy(arr0);
        
        int[] arr1 = {11,4,2,7,8,54};
        c.setStrategy(new InsertingSort());
        c.executeStrategy(arr1);
        
        int[] arr2 = {3,-8,2,0,33,1,3,2};
        c.setStrategy(new BubbleSort());
        c.executeStrategy(arr2);
    }
}

// *************************************** Strategy Client (Context)
class StrategyClient {
    private Sorting strategy;
    public void setStrategy(Sorting strategy) { this.strategy = strategy; }
    public void executeStrategy(int[] arr) { strategy.sort(arr); }    
}

// *************************************** Interface and his strateges
interface Sorting {
    void sort(int[] arr);
}
// Bubble sorting strategy (Сотрировка пузырьком)
class BubbleSort implements Sorting {
    @Override
    public void sort(int[] arr) {
        System.out.println("Bubble sorting");
        System.out.println("before:\t" + Arrays.toString(arr));
        for (int b = arr.length-1; b >= 0; b--) {
            for (int i = 0; i < b; i++) {
                if (arr[i] > arr[i+1]) {
                    int tmp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = tmp;
                }
            }
        }
        System.out.println("after:\t" + Arrays.toString(arr));
    }
}

// Selection sorting strategy (Сотрировка выборками)
class SelectionSort implements Sorting {
    @Override
    public void sort(int[] arr) {
        System.out.println("Selection sorting");
        System.out.println("before:\t" + Arrays.toString(arr));
        for (int b = 0; b < arr.length-1; b++) {
            for (int i = b+1; i < arr.length; i++) {
                if (arr[i] < arr[b]) {
                    int tmp = arr[i];
                    arr[i] = arr[b];
                    arr[b] = tmp;
                }
            }
        }
        System.out.println("after:\t" + Arrays.toString(arr));
    }
}

// Inserting sorting strategy (Сотрировка выборками)
class InsertingSort implements Sorting {
    @Override
    public void sort(int[] arr) {
        System.out.println("Inserting sorting");
        System.out.println("before:\t" + Arrays.toString(arr));
        for (int b = 1; b < arr.length; b++) {
            int index = b;
            while (index-1>=0 && arr[index]<arr[index-1]) {
                int tmp = arr[index];
                arr[index] = arr[index-1];
                arr[index-1] = tmp;
                index--;
            }            
        }
        System.out.println("after:\t" + Arrays.toString(arr));
    }
}