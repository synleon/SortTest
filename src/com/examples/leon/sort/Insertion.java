package com.examples.leon.sort;

/**
 * <p>
 * move elements to left side which is sorted.
 * </p>
 * 
 * @see <a href="http://www.java2novice.com/java-sorting-algorithms/insertion-sort/">Java2Novice - Insertion Sort</a>
 * @see <a href="https://www.geeksforgeeks.org/insertion-sort/">Geeks for Geeks - Insertion Sort</a>
 * 
 * @author Shahriar (Shawn) Emami
 * @version Feb 13, 2018
 */
public class Insertion{

	public static void sort( int[] array, final int size){
		if( array == null || array.length < 2){
			return;
		}
		//start from index 1
		for( int i = 1; i < size; i++){
			//start from index i and count down
			for( int j = i; j > 0; j--){
				if( array[j] < array[j-1]){
					swap( array, j, j-1);
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
