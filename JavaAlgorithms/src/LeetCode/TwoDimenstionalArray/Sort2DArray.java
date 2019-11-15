package LeetCode.TwoDimenstionalArray;

import java.util.Arrays;

//https://leetcode.com/discuss/interview-question/381172/google-phone-screen-sort-a-2d-array

public class Sort2DArray {

	public static void main(String[] args) {
		int[][] in = new int[][] 
				{
				{ 5, 12, 17, 21, 23 }
				,{ 1, 2, 4, 6, 8 }
				,{ 12, 14, 18, 19, 27}
				,{ 3, 7, 9, 15, 25 } 
				};
		int[] result= printLinear(in);
		
	  System.out.println("Before Sorting: " + Arrays.toString(result));
	
//	    result= printLinear(create2DArray(sort(in),in.length,in[0].length));
//	    
//	    
//		System.out.println("After Sorting: " + Arrays.toString(result));
		
		
//		int[] first = new int[]{ 5, 12, 17, 21, 23 };
//		
//        int[] second =  new int[]{ 1, 2, 4, 6, 8 };
//        
//        result = mergeTwoSortedArray(first, second);
	  
	    result = sortEfficient(in);       
	    
	    System.out.println("After Sorting Length : " + result.length);

	    
	    

        System.out.println("After Sorting: " + Arrays.toString(result));
	}
	
	
private static int[] sortEfficient(int[][] in) {
		
	int rowCount = in.length;
	int colCount = in[0].length;
	int newLength = rowCount*colCount;
//	int[] result = new int[newLength];
//		
//	
//		 for (int i = 0; i< colCount ; i++) {
//			 result[i]= in[0][i];
//		 }
		 
	
	   int[]  result = in[0];
		int j =1; 
	    while(j < rowCount) {
	    	result = mergeTwoSortedArray(result, in[j]);	
	    	j++;
	   }
	
	
	
		return result;
		
	}
	
	
	private static int[] mergeTwoSortedArray(int[] first, int[] second){
		
		int firstArrayLength = first.length;
		int secondArrayLength = second.length;

		int resultLength = firstArrayLength + secondArrayLength;
		
		int[] result = new int[resultLength];
		int firstIndex = 0;
		int secondIndex =0;
		
		for (int i =0; i < resultLength; i++) {
			
			if (secondIndex == secondArrayLength) {
				result[i]= first[firstIndex]; 
				 if (firstIndex < firstArrayLength) {
				 firstIndex++;
				 }
			} else if (firstIndex == firstArrayLength ) {
				result[i]= second[secondIndex]; 
				if (secondIndex < secondArrayLength ) {
					 secondIndex ++;
				 }
				
			} else {
				if (first[firstIndex] > second[secondIndex]) {
			
				 result[i]= second[secondIndex];
				 if (secondIndex < secondArrayLength ) {
					 secondIndex ++;
				 }
				
				 
			 }else {
				 result[i]= first[firstIndex]; 
				 if (firstIndex < firstArrayLength ) {
				 firstIndex++;
				 }
			  }
			}
		}
		
		
		return result;
		
		
	}

	private static int[] printLinear(int[][] in) {
		
		int r = 0;
		int c =0;
		
		int rowCount = in.length;
		int colCount = in[0].length;
		int newLength = rowCount*colCount;
		int[] result = new int[newLength];
		int k =0;
		
	
		
		for ( k = 0; k < newLength; k ++) {
			result[k] = in[r][c];
			if(c < colCount -1 ) {
				c ++;	

			} else if (c == colCount -1 ) {
				r ++;
				c =0;

			}
		}
		
		return result;
		
		
	}
	
	
	private static int[][] create2DArray (int [] in, int rowCount, int colCount){
		
		int newLength = rowCount*colCount;
		int r = 0;
		int c =0;
		int [][] result= new int[rowCount][colCount];
		
		
		for ( int k = 0; k < newLength; k ++) {
			result[r][c] = in[k];
			if(c < colCount -1 ) {
				c ++;	

			} else if (c == colCount -1 ) {
				r ++;
				c =0;

			}
		}
		
		return result;
		
	}
	
	
	

	private static int[] sort(int[][] in) {
		
		int[] result= printLinear(in);
		
		for (int i = 0; i < result.length - 1; i ++) {
			for (int j = i + 1; j < result.length -i ; j ++) {
				if (result[i] > result[j]) {
					int temp = result[i];
					result[i]= result[j];
					result[j] = temp;
				}
			}
		}
		
		return result;
		
	}
}
