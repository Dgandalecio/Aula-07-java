/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.timsortexample;

/**
 *
 * @author diogo
 */
import java.util.Arrays;
import java.util.Random;

public class TimSortExample {

    public static void main(String[] args) {
        int[] array = generateRandomArray(500000); 

      
        long startTime = System.currentTimeMillis();
        Arrays.sort(array);
        long endTime = System.currentTimeMillis();
        System.out.println("TimSort Time: " + (endTime - startTime) + " ms");

     
    }

    private static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(1000000);
        }
        return array;
    }

    private static void printArray(int[] array) {
        for (int i = 0; i < 100; i++) { 
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}

