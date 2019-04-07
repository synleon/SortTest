package com.examples.leon.sort;

/**
 * <p>
 * find the right element and move it to the right spot.
 * </p>
 * 
 * @see <a href="http://www.java2novice.com/java-sorting-algorithms/selection-sort/">Java2Novice - Selection Sort</a>
 * @see <a href="https://www.geeksforgeeks.org/selection-sort/">Geeks for Geeks - Selection Sort</a>
 * 
 * @author Shahriar (Shawn) Emami
 * @version Feb 13, 2018
 */
public class Selection{
	
	public static void sort( int[] array, final int size){
		if( array == null || array.length < 2){
			return;
		}
		//start from first index
		for( int i = 0; i < size-1; i++){
			int index = i;
			//look for smallest index
			for( int j = i+1; j < size; j++){
				if( array[j]<array[index]){
					index=j;
				}
			}
			swap( array, i, index);
		}
	}

	private static void swap( int[] array, int source, int dest){
		int num = array[source];
		array[source] = array[dest];
		array[dest] = num;
	}
}
