package Sorting;
import java.util.Arrays;

public class MergeSort {

	
	public static void main ( String arg[]){
		System.out.println("Avinash");
		 Integer[] inArray = {5,4,3,2,1,8,7,6};
		 System.out.println("before sort: " + Arrays.toString(inArray));
		 System.out.println("after sort: " + Arrays.toString(mergeSort(inArray)));

	}
	
	private static Integer[] mergeSort(Integer[] inArray){
		
		int mid= inArray.length/2;
		Integer[] left;
		Integer[] right;
		if (mid<2){
			return inArray;
		} else{
			left= new Integer[mid];
			right= new Integer[inArray.length -mid];
			for (int i=0; i < mid; i++){
				left[i] = inArray[i];
			}
			System.out.println("left: " + Arrays.toString(left));
			for (int j=mid; j < inArray.length-1; j++){
				right[j-mid] = inArray[j];
			}
		}
		//mergeSort(left);
		//mergeSort(right);
		
		inArray= merge(left,right, inArray);
		
		return inArray;		
	}
	
	private static Integer[] merge(Integer[] left, Integer[] right, Integer[] result){
		
      int i=0;
      int j=0;
      int k=0;
      while (i<left.length-1 && j < right.length-1 ){
    	  if (left[i]>right[j]){
        	  result[k]=right[j];
        	  j++;
          }  else{
        	  result[k]=left[i];
        	  i++;
          }
    	  k++;
      }
      while ( i<left.length-1){
    	  result[k]=left[i]; 
      }
      while ( j<right.length-1){
    	  result[k]=left[j]; 
      }
		
		return result;
				
	}
	
}
