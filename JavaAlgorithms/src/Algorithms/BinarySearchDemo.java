package Algorithms;

public class BinarySearchDemo {

	public static void main(String[] args) {
    
		int[] intArr = {1,3,5,7,8,9,10,11};
		
		//System.out.println("Find Integer: " + binarySearchWhile(intArr, 9) );
		//System.out.println("Find Integer: " + simpleSearch(intArr, 9) );
		System.out.println("Find Integer: " + binarySearchRecursive(intArr, 8, 0,intArr.length));



	}
	
	//iterative

	
	public static int binarySearchWhile (int[] intArr, int n) {
		int start = 0;
		int end = intArr.length;
		int pos = 0;
		int mid = 0;

		
		while (start <= end) {
			 mid = (start + end)/2;
			
			if(intArr[mid] == n) {
				return mid;
				
			} else if(intArr[mid] > n) {
				end = mid -1;
				
				
			} else if(intArr[mid] < n) {
				start = mid + 1;
			}
		}
		return pos;
	}
	
	
	
	//recursive
	
	public static int binarySearchRecursive (int[] intArr, int n, int start, int end) {
//		int start = 0;
//		int end = intArr.length;
		int pos = 0;
		
		int mid = (start+end)/2;
		int midValue = intArr[mid];

		if(n == midValue) {
          return mid;			
		} else if (n > midValue) {
			start = mid +1;
			pos=binarySearchRecursive(intArr,n,start, end);
			
		} else if (n < midValue) {
			end = mid -1;
			pos=binarySearchRecursive(intArr,n,start, end);
		}
		
		return pos;
	}
	
	//Simple brute force
	public static int simpleSearch (int[] intArr, int n) {
		int pos = 0;
		
		for (int i=0; i<intArr.length; i++ ) {
			if(intArr[i]== n) {
				return i;
			} else {
				
			}
		}
		
		return pos;
	}
	
	

}
