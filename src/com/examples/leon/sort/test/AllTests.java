package com.examples.leon.sort.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith( Suite.class)
@Suite.SuiteClasses( { TestBubble.class, TestInsertion.class, TestQuick.class, TestSelection.class, TestMerge.class })
public class AllTests{

    public static final int RANDOM_TEST_COUNT = 100;
    public static final int RANDOM_ARRAY_LENGHT = 1000;
    public static final int RANDOM_LARGEST_NUMBER = 1000;

    public static final int[][] array1 = {
            { 2, 10, 7, 8, 4, 6, 1, 9, 5, 3 },
            { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 } };

    public static final int[][] array2 = {
            { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 },
            { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 } };

    public static final int[][] array3 = {
            { 10, 2, 3, 4, 5, 6, 7, 8, 9, 1 },
            { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 } };

    public static final int[][] array4 = {
            { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 },
            { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 } };

    public static int[] generateRandomArray( final int size, final int largestNumber){
        int[] array = new int[size];
        for( int i = 0; i < size; i++){
            array[i] = (int) (Math.random() * largestNumber);
        }
        return array;
    }
}