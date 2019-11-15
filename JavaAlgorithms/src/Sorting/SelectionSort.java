package Sorting;

import java.util.Arrays;

// in selection sort make sure that first element is the sortest one and then apply that 
//it has greedy property.

//when no extra place is required
//Simple implementation

//O(n^2) is the complexity
//Space complexity = O(1)

public class SelectionSort {

	public static void main(String[] args) {
		System.out.println("Avinash");
		 int[] inArray = new int[]{5,4,3,2,1,8,7,6};
		 System.out.println("before sort: " + Arrays.toString(inArray));
		  selectionSort(inArray, 0, inArray.length);
	    System.out.println("after sort: " + Arrays.toString(inArray));
	}

	private static void selectionSort(int[] inArray, int m, int length) {

		
		while (m < length) {
			for (int i = m+1; i < length; i++) {
				if (inArray[m] < inArray[i]) {
					continue;
				} else {
					int temp = inArray[m];
					inArray[m] = inArray[i];
					inArray[i] = temp;
				}
			}
			m++;
		}

	}
	
	//udemy dsguy solution
	static void selectionSort(int[] a) {
		for (int j = 0; j<a.length; j++) {
			int minimumIndex = j;
			for (int i=j+1; i<a.length; i++) {
				if (a[i] < a[minimumIndex]) //find which is the smallest element to right of 'j'
					minimumIndex = i;
			}//end of inner loop
			if (minimumIndex != j) { // if j is not minimum index then swap
				int temp = a[j];
				a[j] = a[minimumIndex];
				a[minimumIndex] = temp;
			}
		}//end of outer loop
	}//end of method


}
