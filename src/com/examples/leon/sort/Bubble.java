package com.examples.leon.sort;

/**
 * <p>
 * compare pairs of cells.
 * </p>
 * 
 * @see <a href="http://www.java2novice.com/java-sorting-algorithms/bubble-sort/">Java2Novice - Bubble Sort</a>
 * @see <a href="https://www.geeksforgeeks.org/bubble-sort/">Geeks for Geeks - Bubble Sort</a>
 * 
 * @author Shahriar (Shawn) Emami
 * @version Feb 13, 2018
 */
public class Bubble{

	public static void sort( int[] array, final int size){
		if( array == null || array.length < 2){
			return;
		}
		// start from index 1
		for( int i = 1; i <size; i++){
			for( int j = 0; j < size-i; j++){
				//compare pairs next to each other
				if( array[j] > array[j+1]){
					swap( array, j+1, j);
				}
			}
				
		}
	}

	private static void swap( int[] array, int source, int dest){
		int num = array[source];
		array[source] = array[dest];
		array[dest] = num;
	}
}