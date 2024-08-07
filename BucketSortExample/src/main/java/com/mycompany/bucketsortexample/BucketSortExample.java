/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bucketsortexample;

/**
 *
 * @author diogo
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class BucketSortExample {

    public static void main(String[] args) {
        int[] array = generateRandomArray(500000);
            long startTime = System.currentTimeMillis();
        bucketSort(array);
        long endTime = System.currentTimeMillis();
        System.out.println("BucketSort Time: " + (endTime - startTime) + " ms");

     
    }

    public static void bucketSort(int[] array) {
        if (array.length <= 0) return;

        int maxValue = findMaxValue(array);
        int numBuckets = maxValue / 10 + 1;
        List<List<Integer>> buckets = new ArrayList<>(numBuckets);


        for (int i = 0; i < numBuckets; i++) {
            buckets.add(new ArrayList<>());
        }


        for (int value : array) {
            int bucketIndex = value / 10;
            buckets.get(bucketIndex).add(value);
        }


        int index = 0;
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);  
            for (int value : bucket) {
                array[index++] = value;
            }
        }
    }

    private static int findMaxValue(int[] array) {
        int maxValue = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > maxValue) {
                maxValue = array[i];
            }
        }
        return maxValue;
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

