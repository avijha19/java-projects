package Sorting;
import java.util.Arrays;

public class MergeSort {

	
	public static void main ( String arg[]){
		System.out.println("Avinash");
		 int[] inArray = new int[]{5,4,3,2,1,8,7,6};
		 System.out.println("before sort: " + Arrays.toString(inArray));
		  mergeSort(inArray, 0, inArray.length -1);
	    System.out.println("after sort: " + Arrays.toString(inArray));


	}
	
	public static void mergeSort(int[] Array, int left, int right) {
		if (right > left) {
			int m = (left + right) / 2;
			mergeSort(Array, left, m);
			mergeSort(Array, m + 1, right);
			merge(Array, left, m, right);
		}
	}//end of method

	
	static void merge(int[] A, int left, int middle, int right) {
		int [] leftTmpArray = new int[middle-left+2];  //Create tmp arrays
		int [] rightTmpArray = new int[right-middle+1];
		
		for(int i=0;i<=middle-left;i++) //Copy values from Array 'A' to these tmp arrays
			leftTmpArray[i]= A[left+i];
		for(int i=0;i<right-middle;i++)
			rightTmpArray[i]= A[middle+1+i];
		
		leftTmpArray[middle-left+1]= Integer.MAX_VALUE; //Merge values and insert into Array 'A'
		rightTmpArray[right-middle] = Integer.MAX_VALUE;
		int i = 0, j = 0;
		for (int k = left; k <= right; k++) {
			if (leftTmpArray[i] < rightTmpArray[j]) {
				A[k] = leftTmpArray[i];
				i++;
			} else {
				A[k] = rightTmpArray[j];
				j++;
			}
		}
	}//end of method
	
}
