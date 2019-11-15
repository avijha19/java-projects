package Practice;
import java.util.Arrays;

public class MergeSort {

	
	public static void main ( String arg[]){
		System.out.println("Avinash");
		 int[] inArray = new int[]{5,4,3,2,1,8,7,6};
		 System.out.println("before sort: " + Arrays.toString(inArray));
		  mergeSort(inArray, 0, inArray.length -1);
	    System.out.println("after sort: " + Arrays.toString(inArray));


	}
	
	public static void mergeSort(int[] inArray, int left, int right) {
		
		int mid = (left+right)/2;
		
		if (right>left) {
			mergeSort(inArray,left,mid);
			mergeSort(inArray,mid +1,right);
			merge(inArray,left,mid,right);

		}
		
		
	}//end of method

	
	static void merge(int[] inArray, int left, int mid, int right) {
		
		
		int[] leftArray = new int[mid -left +2]; // create one extra and assign that to max.
		int[] rightArray = new int[right -mid +1]; //right - (mid + 1) +1 // create one extra and assign that to max.

		
		for (int i = 0; i <= mid -left; i++) {
			leftArray[i]= inArray[left + i];
		}
		
		for (int i = 0; i < right -mid; i++) {
			rightArray[i]= inArray[mid+1+i];
		} 
		
		
		leftArray[mid -left +1] = Integer.MAX_VALUE;
		rightArray[right -mid] = Integer.MAX_VALUE;
		
		int i = 0;
		int j =0;
		
		for (int k = left; k <= right; k++) {
			
			if (leftArray[i] < rightArray[j]) {
				inArray[k] = leftArray[i];
				i++;
			} else {
				inArray[k] = rightArray[j];
				j++;
			}
		}

		
	}
}
