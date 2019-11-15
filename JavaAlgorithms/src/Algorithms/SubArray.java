package Algorithms;

import java.util.Arrays;

// To solve https://leetcode.com/problems/maximum-subarray/
//https://leetcode.com/problems/subarray-sum-equals-k/

public class SubArray {
	
	//21
	//                    0  1  2  3  4  5   6   7  8
	//int[] in=new int[] {1, 8, 4, 3, 9, 17,18, 10, 2};
	//1 : 
	
	//8
		//                    0  1  2  3  4  5   6   7  8
		//int[] in=new int[] {1, 5, 3, 4, 7,2};
		//1 : 
	//private static int SUM_NUMBER = 7;
	private static int SUM_NUMBER = 23;


	public static void main(String args[]) {
		
//		int[] in=new int[] {1, 2, 3, 9, 12, 17,18, 20, 22};
//
//		//int[] in=new int[] {1, 2, 3, 4, 5};
//		
//		
//		int[][] result = findArrays(in);
//		
//		System.out.println("Print: " +result);
//		
//		
//		int[] in2=new int[]{-2,1,-3,4,-1,2,1,-5,4};
//
		//System.out.println("Find Max Sum: " +findMaxSum(in2));
		
		//String S ="Avinash";
		
		
		//Char sorting used for anagram
//		char[] c = S.toCharArray();
//		System.out.println("Before:");
//		print(c);
//		Arrays.sort(c);
//		System.out.println("After:");
//		print(c);
		
		
		System.out.println("Find Max repated: " +lengthOfLongestSubstring("abcdefgh"));


		
		
	}
	
	
	
	
	public static int lengthOfLongestSubstring(String s) {
		
		 char[] in = s.toCharArray();
		
		int res =1;
		int maxRes = 1;
		
		
		for (int i = 0; i< in.length; i++) {
			for (int j =i+1; j< in.length; j++) {
				
				if(res >= maxRes) {
					maxRes=res;
				}
				res =1;
				for (int k =i; k<=j ; k++) {
					
					
					for(int l=k+1; l<=j; l++ ) {
						if(in[k]==in[l]) {
							break;
						}
						res=j-k;

					}
					
				}
				
			}
			
		}
		
		
		
		return maxRes+1;
        
        
        
    }
	
//	public static int (String as) {
//		char[] in = as.toCharArray();
//		int res=0;
//		for (int k =0; k<in.length ; k++) {
//			
//			
//			for(int l=k+1; l<in.length; l++ ) {
//				if(in[k]==in[l]) {
//					break;
//				}
//				res=in.length;
//
//			}
//			
//		}
//	}
	
	
	
	private static void print(char[] c) {
		for (int i=0; i< c.length; i ++) {
			System.out.println(", " + c[i] );
		}
	}
	
	
   private static int sum(int[] in) {
		
		int res=0;
		
		for (int i = 0; i < in.length; i++) {
			res = res + in[i];
		}
		
		
		return res;
		
	}
   
   
   private static int findSubArraysSumK(int[] nums, int k) {
		
		int res=0;
		
		int noOfArrays=0;
		
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				res=0;
				for (int m = i; m < j; m++) {
					res = res + nums[m];
				}
				if (res == k) {
					noOfArrays++;
				}
			}

		}
		return noOfArrays;
	}
   
   private static int findSubArrays(int[] in) {
		
		int res=0;
		
		int maxSum=0;
		for (int i = 0; i < in.length; i++) {
			for (int j = i + 1; j < in.length; j++) {
				res=0;
				for (int k = i; k < j; k++) {
					res = res + in[k];
				}
				if (res > maxSum) {
					maxSum = res;
				}
			}

		}
		return maxSum;
	}
	
	private static int findMaxSum(int[] in) {
		
		int res=0;
		
		int maxSum=0;
		for (int i = 0; i < in.length; i++) {
			for (int j = i + 1; j < in.length; j++) {
				res=0;
				for (int k = i; k < j; k++) {
					res = res + in[k];
				}
				if (res > maxSum) {
					maxSum = res;
				}
			}

		}
		return maxSum;
	}
	
	
	private static int[][] findArrays(int[] in){
		int start =0;
		int end = in.length -1;
		int resultRowCount = ((in.length)*(in.length-1))/2;
		int[][] result = new int[resultRowCount][2];
		
		int i=0;
		while(start < end) {
			if ((in[start] + in[end]) == SUM_NUMBER) {
				result[i] = new int[]{start, end};
				i++;
				start ++;
				end = in.length -1;
				
			} else if((in[start] + in[end]) < SUM_NUMBER) {
				start ++;
				end = in.length -1;
			
			} else if ((in[start] + in[end]) > SUM_NUMBER){
				end --;
				
			}
		}
		
		return result;
	}
	
	

}
