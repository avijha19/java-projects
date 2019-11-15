package LeetCode.Array;

import java.util.Arrays;

/*Input: [1,2,3,4,5,6,7] and k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
*/

public class RotateArrayL189 {

	public static void main(String[] args) {
		int[] in = new int[] { 1,2,3,4,5,6,7};
		System.out.println("print before Rotete: : " + Arrays.toString(in));
		rotate(in,3);
		System.out.println("print before Rotete: : " + Arrays.toString(in));

	}
	
	
	public static void rotate (int[] in, int k) {
		
		int[] rt = new int[in.length];
		int count = in.length -k;
		int i =0 ;
		while (count < in.length ) {
			rt[i] = in[count];
			count ++ ;
			i++;
			}
		
		 count = k;
		 i =0 ;
		 
		 while (count < in.length ) {
				rt[count] = in[i];
				count ++ ;
				i++;
				} 
		
		for (int j =0; j < rt.length; j ++) {
			
			in[j]=rt[j];
		}
		
		
	}
	
	
	
	public static void rotate2 (int[] in, int k) {
		
		int[] rt = new int[in.length];
		int count = in.length -k;
		int i =0 ;
		while (count < in.length ) {
			rt[i] = in[count];
			count ++ ;
			i++;
			}
		
		 count = k;
		 i =0 ;
		 
		 while (count < in.length ) {
				rt[count] = in[i];
				count ++ ;
				i++;
				} 
		
		for (int j =0; j < rt.length; j ++) {
			
			in[j]=rt[j];
		}
		
		
	}
}
