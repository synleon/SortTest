package com.examples.leon.sort;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * <p>
 * choose the last element of the array is pivot.
 * </p>
 * 
 * @see <a href="http://www.java2novice.com/java-sorting-algorithms/merge-sort/">Java2Novice - Merge Sort</a>
 * @see <a href="https://www.geeksforgeeks.org/merge-sort/">Geeks for Geeks - Merge Sort</a>
 * 
 * @author Shahriar (Shawn) Emami
 * @version Feb 13, 2018
 */
public class Merge{

	public static boolean DEBUG = true;

	public static void sort( int[] array, final int size){
		if( array == null || array.length < 2){
			return;
		}
		sortRecursive( array, 0, size - 1, 0);
	}

	public static void main( String[] args){
		//int[] array = { 9,3,4,7,8,2,5 };
		int[] array = { 8,4,2,6,9,7,1,3 };
		System.out.printf( " sorting: %s%n", print( array, 0, array.length));
		//sort( array, array.length);
		sortRecursive( array, 0, array.length - 1, 0);
		System.out.printf( "  sorted: %s%n", print( array, 0, array.length));
	}
	
	private static String print( int[] array, final int low, final int high){
		StringBuilder builder = new StringBuilder("[");
		String separator = "";
		for(int i=low; i<high; i++){
			builder.append( separator).append( array[i]);
			separator = ", ";
		}
		builder.append( "]");
		return builder.toString();
	}

	public static void sortRecursive( int[] array, final int low, final int high, int depth){
		if( low >= high){
			if( DEBUG)
				System.out.printf( "  left-%d: not enough elements%n", depth);
			return;
		}
		// find the middle
		int middle = low + (high - low) / 2;
		// sort left half
		if( DEBUG)
			System.out.printf( "  left-%d: %s%n", depth, print( array, low, middle+1));
		sortRecursive( array, low, middle, depth+1);
		// sort right half
		if( DEBUG)
			System.out.printf( " right-%d: %s%n", depth, print( array, middle + 1, high+1));
		sortRecursive( array, middle + 1, high, depth+1);
		// merge two halves of an array and sort
		if( DEBUG)
			System.out.printf( " merge-%d: %s%n", depth, print( array, low, high+1));
		merge( array, low, middle, high);
		if( DEBUG)
			System.out.printf( "  sort-%d: %s%n", depth, print( array, low, high+1));
	}

	private static void merge( int[] array, final int low, final int middle, final int high){
		int[] tempMerg = new int[array.length];
		for( int i = low; i <= high; i++){// copy array to temporary location
			tempMerg[i] = array[i];
		}
		int leftIndex = low; // keep track of left half index, most left
		int rightIndex = middle + 1;// keep track of right half index, most left
		int mainIndex = low;// keep track of main array index
		for( ; leftIndex <= middle && rightIndex <= high; mainIndex++){
			// if left index is smaller copy left otherwise copy right
			// and increment the copied index
			if( tempMerg[leftIndex] <= tempMerg[rightIndex]){
				array[mainIndex] = tempMerg[leftIndex];
				leftIndex++;
			}else{
				array[mainIndex] = tempMerg[rightIndex];
				rightIndex++;
			}
		}
		// copy the remainder of temp array to main array
		for( ; leftIndex <= middle; mainIndex++, leftIndex++){
			array[mainIndex] = tempMerg[leftIndex];
		}
	}
}