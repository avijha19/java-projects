package Practice;

public class BinarySearchDemo {

	public static void main(String[] args) {
     int[] intArr = {1,3,5,7,8,9,10,11};
		
		//System.out.println("Find Integer: " + binarySearchWhile(intArr, 9) );
		//System.out.println("Find Integer: " + simpleSearch(intArr, 9) );
		//System.out.println("Find Integer: " + binarySearchRecursive1(intArr, 8, 0,intArr.length-1));
		System.out.println("Find Integer: " + binarySearchRecursive(intArr, 8, 0,intArr.length-1));


	}

	private static int binarySearchRecursive(int[] intArr, int num, int start, int end) {

		int mid = (start + end) / 2;
		int pos = 0;

		if (intArr[mid] == num) {
			return mid;
		} else if (num > intArr[mid]) {
			pos=binarySearchRecursive(intArr, num, mid + 1, end);
		} else if (num < intArr[mid]) {
			pos=binarySearchRecursive(intArr, num, start, mid - 1);
		}

		return pos;
	}
	
	
	public static int binarySearchRecursive1 (int[] intArr, int n, int start, int end) {
//		int start = 0;
//		int end = intArr.length;
		int pos = 0;
		
		int mid = (start+end)/2;
		int midValue = intArr[mid];

		if(n == midValue) {
          return mid;			
		} else if (n > midValue) {
			start = mid +1;
			pos=binarySearchRecursive1(intArr,n,start, end);
			
		} else if (n < midValue) {
			end = mid -1;
			pos=binarySearchRecursive1(intArr,n,start, end);
		}
		
		return pos;
	}

//	private static String binarySearchRecursive(int[] intArr, int i, int j, int length) {
//		
//		
//
//		return null;
//	}

}
