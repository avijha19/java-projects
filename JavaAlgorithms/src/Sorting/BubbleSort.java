package Sorting;
import java.util.Arrays;

public class BubbleSort {
	
//  https://www.journaldev.com/557/java-bubble-sort-example
//	In bubble sort, the array of integers is traversed from index 0 to length-1. 
//	The value at 0th position is compared with value at 1st position 
//  and if the later is small, its swapped. 
//	The comparison is moved from 0th index to length-1 index so that after first iteration, 
//   the last index has the biggest value.
//	 Same process is repeated again from 0th to length-1 index. 
//  	After (length-1) iteration, array is sorted. 
//	 In worst-case the complexity of bubble sort is O(n2) and 
//	in best-case the complexity of bubble sort is Ω(n).

	public static void main ( String arg[]){
		System.out.println("Avinash");
		 Integer[] inArray = {3,4,5,2,1};
		 System.out.println("before sort: " + Arrays.toString(inArray));
		 System.out.println("after sort: " + Arrays.toString(buubleSort(inArray)));

	}
	
	private static Integer[] buubleSort(Integer[] inArray){
		
		int temp;
		
		for(int i=0; i< inArray.length-1; i++){
			
			for(int j=1; j<inArray.length-i; j++){
				if(inArray[j]<inArray[j-1]){
					temp=inArray[j];
					inArray[j]=inArray[j-1];
					inArray[j-1]=temp;		
				}
			}
			
		}
		
		return inArray;
		
	}

}
