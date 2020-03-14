package Practice;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/

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

public class LongestSubString {

	public static void main(String[] args) {

		String s = "abcabcbb";
		//s= "pwwkew";
		System.out.println("Max length: " + lengthOfLongestSubstring(s));

	}

	public static int lengthOfLongestSubstring(String s) {
		int result = 1;

		Set<Character> setChar = new HashSet<>();

		int start = 0;
		int end = 0;

		while (end < s.length() && start <= end) {
			Character current = s.charAt(end);
			if (!setChar.contains(current)) {

				setChar.add(current);
				end++;
				result = Math.max(end - start, result);

			} else {
				//result = Math.max(end - start, result);
				setChar.remove(s.charAt(start));
				start++;
			}

		}

		return result;
	}

}
