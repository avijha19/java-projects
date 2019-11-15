package Sorting;

import java.util.Arrays;

public class MergeSort2 {

	public static void main(String[] args) {
		System.out.println("Avinash");
		 int[] inArray = new int[]{5,4,3,2,1,8,7,6};
		 System.out.println("before sort: " + Arrays.toString(inArray));
		  mergeSort(inArray, 0, inArray.length -1);
	    System.out.println("after sort: " + Arrays.toString(inArray));


	
		// TODO Auto-generated method stub

	}

	private static void mergeSort(int[] A, int start, int end) {
		int m;
		
		if(end > start) {
			m = (start + end)/2;
			mergeSort(A, start, m);
			mergeSort(A, m+1, end);
			merge(A,m,start, end);
			
		}
		// TODO Auto-generated method stub
		
	}

	private static void merge(int[] A, int m, int start, int end) {
		int [] leftTmpArray = new int[m-start+2];  //Create tmp arrays
		int [] rightTmpArray = new int[end-m+1];
		
		
	}

}
