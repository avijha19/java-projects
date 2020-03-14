package LeetCode.SubArray;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//	https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/

//Input: "eceba"
//Output: 3
//Explanation: t is "ece" which its length is 3.

public class LongestSubStringTwoDistinct {

	public static void main(String[] args) {
		String s ="eceba";
		
		System.out.println("Max length: " + lengthOfLongestSubstringTwoDistinct3(s));
	}

	
	
	public static int lengthOfLongestSubstringTwoDistinct3(String s) {

		int max_length = 2;

		Map<Character, Integer> charMap = new HashMap<>();

		int start = 0;
		int end = 0;

		while (end < s.length()) {

			if (charMap.size() < 3) {
				charMap.put(s.charAt(end), end);
				end++;
			}

			if (charMap.size() == 3) {
				int del_index = Collections.min(charMap.values());
				charMap.remove(s.charAt(del_index));
				start = del_index + 1;

			}
			
			max_length =  Math.max(max_length, end - start);

		}

		return max_length;

	}
	
	public static int lengthOfLongestSubstringTwoDistinct(String s) {
		int result =0;
		
		int start=0;
		int end =0 ;
		
        Set<Character> setChar = new HashSet<>();

		
		while (end < s.length() && end >= start) {
			if(!setChar.contains(s.charAt(end)) && setChar.size() < 2) {
				setChar.add(s.charAt(end));
				end ++;
				result =  Math.max(result, end -start);
			} else if (setChar.contains(s.charAt(end))){
				end ++;
				result =  Math.max(result, end -start);
			} else {
				setChar.remove(s.charAt(start));
				start ++;
				result =  Math.max(result, end -start);


			}
		}
		
		return result;

	}
	//
	public static int lengthOfLongestSubstringTwoDistinct2(String s) {
		int result =0;
		
		int start=0;
		int end =0 ;
		
        Map<Character, Integer> setChar = new HashMap<>();

		
		while (end < s.length() && end >= start) {
			if(!setChar.containsKey(s.charAt(end)) && setChar.size() < 2) {
				setChar.put(s.charAt(end), end);
				end ++;
				result =  Math.max(result, end -start);
			} else if (setChar.containsKey(s.charAt(end))){
				end ++;
				result =  Math.max(result, end -start);
			} else {
				int delete_index = Collections.min(setChar.values());
				setChar.remove(s.charAt(delete_index));
				start = delete_index + 1;
				result =  Math.max(result, end -start);


			}
		}
		
		return result;

	}

}
