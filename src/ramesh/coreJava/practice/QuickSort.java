package ramesh.coreJava.practice;


//http://javarevisited.blogspot.in/2014/08/quicksort-sorting-algorithm-in-java-in-place-example.html

import java.util.Arrays;

/**
 * Test class to sort array of integers using Quicksort algorithm in Java.
 * 
 * @author Javin Paul
 */
public class QuickSort {

	public static void main(String args[]) {

		// unsorted integer array
		int[] unsorted = { 6, 5, 3, 1, 8, 7, 2, 4 };
		System.out.println("Unsorted array :" + Arrays.toString(unsorted));

		QuickSortAlgorithm algorithm = new QuickSortAlgorithm();

		// sorting integer array using quicksort algorithm
		algorithm.sort(unsorted);

		// printing sorted array
		System.out.println("Sorted array :" + Arrays.toString(unsorted));

	}

}

/**
 * Java Program sort numbers using QuickSort Algorithm. QuickSort is a divide
 * and conquer algorithm, which divides the original list, sort it and then
 * merge it to create sorted output.
 *
 * @author Javin Paul
 */
class QuickSortAlgorithm {

	private int input[];
	private int length;

	public void sort(int[] numbers) {

		if (numbers == null || numbers.length == 0) {
			return;
		}
		this.input = numbers;
		length = numbers.length;
		quickSort(0, length - 1);
	}

	/*
	 * This method implements in-place quicksort algorithm recursively.
	 */
	private void quickSort(int low, int high) {
		int i = low;
		int j = high;

		// pivot is middle index
		int pivot = input[low + (high - low) / 2];

		// Divide into two arrays
		while (i <= j) {
			/**
			 * As shown in above image, In each iteration, we will identify a
			 * number from left side which is greater then the pivot value, and
			 * a number from right side which is less then the pivot value. Once
			 * search is complete, we can swap both numbers.
			 */
			while (input[i] < pivot) {
				i++;
			}
			while (input[j] > pivot) {
				j--;
			}
			if (i <= j) {
				swap(i, j);
				// move index to next position on both sides
				i++;
				j--;
			}
		}

		// calls quickSort() method recursively
		if (low < j) {
			quickSort(low, j);
		}

		if (i < high) {
			quickSort(i, high);
		}
	}
	
	//http://3.bp.blogspot.com/-2XKswkxXtE0/U8EkLJIt2BI/AAAAAAAABr0/0S34Aan5jMI/s1600/Quicksort-in-Java-example-fast.gif

	private void swap(int i, int j) {
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}
}