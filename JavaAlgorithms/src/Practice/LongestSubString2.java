package Practice;

import java.util.HashSet;
import java.util.Set;

//Given a string, find the length of the longest substring without repeating characters.
//
//Example 1:
//
//Input: "abcabcbb"
//Output: 3 
//Explanation: The answer is "abc", with the length of 3. 
//Example 2:
//
//Input: "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
//Example 3:
//
//Input: "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3. 
//             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.



public class LongestSubString2 {

	public static void main(String[] args) {

		
		String in1 = "abcabcbb";
		String in5 = "abcbacba";
		String in4 = "abcdebcdef";
		
		String in2 = "bbbbb";
		String in3 = "pwwkew";
		
		
		System.out.println("Find Max repated: " +lengthOfLongestSubstring2(in1));

	
	}

	private static int lengthOfLongestSubstring(String in3) {

		int start = 0;
		int end = 1;

		int max = 0;

		for (int i = 0; i < in3.length(); i++) {
			int count = 0;
			start = i;
			end = i + 1;

			while (end < in3.length()) {
				if (in3.charAt(end) != in3.charAt(start)) {
					end++;
				} else {
					start = end;
					end++;
				}

				count = end - start;
			}
			
			if (count > max) {
				max = count;
			}

		}

		return max;
	}
	
	
	private static int lengthOfLongestSubstring2(String s) {
		
		 
		 int max=0;
		 int start = 0;
		 int end =0;
		 Set<Character> repeatSet = new HashSet<>();

		 while (start < s.length() && end < s.length()) {
			 
			 if(!repeatSet.contains(s.charAt(end))) {
				 repeatSet.add(s.charAt(end));
				 end ++;
				 max = Math.max(max, (start - end));

			 }else {
				 repeatSet.remove(s.charAt(start));
				 start ++;
			 }

		 }
		
		return max;
     
 }


}
