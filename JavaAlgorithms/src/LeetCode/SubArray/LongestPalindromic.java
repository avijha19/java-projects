package LeetCode.SubArray;

public class LongestPalindromic {

// https://leetcode.com/problems/longest-palindromic-substring/

//	Example 1:
//
//		Input: "babad"
//		Output: "bab"
//		Note: "aba" is also a valid answer.
//		Example 2:
//
//		Input: "cbbd"
//		Output: "bb"

	public static void main(String[] args) {

		String in1 = "babad";
		
		System.out.println("Is Plandrome: " + iSPalindrome("bab", 0, 2));


		//System.out.println("Find Palindromic: " + lengthOfLongestPalindromicSubstring(in1));

	}

	
	public static boolean iSPalindrome(String inStr, int start, int end) {

		boolean isPalindrome = true;
		
//		int start = 0;
//		int end =  inStr.length() -1;
		
		while (start < end) {
			if(inStr.charAt(start) == inStr.charAt(end)) {
				start ++;
				end --;
			} else {
				isPalindrome = false;
			}
		}

		return isPalindrome;
	}
	
	
	private static int lengthOfLongestPalindromicSubstring(String in3) {
		
		
		int count = 2;
		int start = 0;
		int end = 2;
		
		
		
		return start;
		
		
	}
	
	
	public static boolean iSPalindrome2(String inStr, int start, int end) {

		boolean isPalindrome = true;
		
		while (start < end) {
			if(inStr.charAt(start) == inStr.charAt(end)) {
				start ++;
				end --;
			} else {
				isPalindrome = false;
			}
		}

		return isPalindrome;
	}
	
	

}
