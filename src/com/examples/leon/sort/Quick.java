package com.examples.leon.sort;

import java.util.Arrays;

/**
 * <p>
 * choose the last element of the array as pivot.
 * </p>
 * 
 * @see <a href="http://www.java2novice.com/java-sorting-algorithms/quick-sort/">Java2Novice - Quick Sort</a>
 * @see <a href="https://www.geeksforgeeks.org/quick-sort/">Geeks for Geeks - Quick Sort</a>
 * 
 * @author Shahriar (Shawn) Emami
 * @version Feb 13, 2018
 */
public class Quick{

	public static boolean DEBUG = true;

	public static void sort( int[] array, final int size){
		if( array == null || array.length < 2){
			return;
		}
		sortRecursive( array, 0, size - 1, 1, 'C');
	}

	public static void main( String[] args){
		//int[] array = { 9,3,4,7,8,2,5 };
		int[] array = { 8,4,2,6,9,7,1,3 };
		int low = 0, high = 7, pivot = 3;
		System.out.printf( "   Low: %d, High: %d, Pivot: %d for %s%n"
				, low, high, pivot, Arrays.toString( array));
		//sort( array, array.length);
		partition(array, low, high, pivot);
	}

	private static void sortRecursive( int[] array, final int low, final int high, int depth, char side){
		// base case all data has been sorted
		if( low >= high){
			return;
		}
		if( DEBUG)
			System.out.printf( "%nLow: %d, High: %d, Pivot: %d, Depth: %d, Side: %c%n        %s%n"
					, low, high, array[high], depth, side, Arrays.toString( array));
		int pivot = partition( array, low, high, high);

		// break array on pivot point
		sortRecursive( array, low, pivot - 1, depth + 1, 'L');
		sortRecursive( array, pivot + 1, high, depth + 1, 'R');
	}

	private static int partition( int[] array, final int low, final int high, int pivotIndex){
		final int pivot = array[pivotIndex];
		int i = (low - 1); // assume left most element is smallest
		for( int j = low; j <= high; j++){// start at smallest index
			// If current element is smaller than or equal to pivot
			if( DEBUG)
				System.out.printf( "    is: [%d] <= [%d] = %b%n"
						, array[j], pivot, ( array[j] <= pivot));
			if( array[j] <= pivot && j!=pivotIndex){
				i++;// keep track of the last partitioned number smaller than pivot
				if( i>=pivotIndex){//if passed pivot, insert smaller value behind pivot
					//insert the smaller number before pivot and update pivot
					pivotIndex = insert( array, j, i);
				}else{
					swap( array, i, j);// swap smaller than pivot number with index j
				}
			}
		}
		// bring pivot to correct position
		if( DEBUG)
			System.out.printf( " pivot: [%d] and [%d]%n        %s%n"
					, array[i + 1], array[pivotIndex], Arrays.toString( array));
		swap( array, i + 1, pivotIndex);
		return i + 1;
	}

	private static int insert(int[] array, int source, int dest) {
		if( DEBUG)
			System.out.printf( "insert: [%d] behind [%d]%n        %s%n"
					, array[source], array[dest], Arrays.toString( array));
		int i=source;
		for(;i>dest;i--){
			swap(array, i, i-1);
		}
		return i+1;
	}

	private static void swap( int[] array, final int source, final int dest){
		if( source==dest)
			return;
		int num = array[source];
		array[source] = array[dest];
		array[dest] = num;
		if( DEBUG)
			System.out.printf( "  Swap: [%d] and [%d]%n        %s%n"
					, array[source], array[dest], Arrays.toString( array));
	}
}
