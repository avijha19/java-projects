package Sorting;

import java.util.Arrays;
// like a card we pick first element from unsorted array and place on the right place in sorted array.
// it has greedy property.

// when to use insertion sort
// when no extra place is required
// Simple implementation

// O(n^2) is the complexity
// Space complexity = O(1)


public class InsertionSort {

		public static void main(String[] args) {
			System.out.println("Avinash");
			 int[] inArray = new int[]{5,4,3,2,1,8,7,6};
			 System.out.println("before sort: " + Arrays.toString(inArray));
			  insertionSort(inArray, 0, inArray.length);
		    System.out.println("after sort: " + Arrays.toString(inArray));
		
	}

		private static void insertionSort(int[] inArray, int m, int length) {
				
			for (int i = 1; i < length; i++) {
				int key = inArray[i];
				int j = i-1;
			    while (j >= 0 && inArray[j] > key ) {
				   inArray[j+1] = inArray[j];  // we shift each element by one place to right if it is greater than the key( first element of unsorted array).
				   j--;
			   }
			   
			   inArray[j+1]=key; // then we find that no other element in sorted array is greater than key then we assign key after that element.
			}
			
		}

}
