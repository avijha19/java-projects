package LeetCode.SubArray;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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

public class LongestSubString {
	
	//https://leetcode.com/problems/longest-substring-without-repeating-characters/

	public static void main(String[] args) {
		
		String in1 = "abcabcbb";
		String in5 = "abcbacba";
		String in4 = "abcdebcdef";
		
		String in2 = "bbbbb";
		String in3 = "pwwkew";
		
		
		System.out.println("Find Max repated: " +lengthOfLongestSubstring(in3));

		System.out.println("Find Max repated: sliding window " +lengthOfLongestSubstring3(in3));
		
		System.out.println("Find Max repated: sliding window " +lengthOfLongestSubstring4(in3));


	}
	
	//USING HASHMAP
    public static int lengthOfLongestSubstring4(String s) {
        
        Map<Character, Integer> map= new HashMap<>();	
        int start=0, len=0;
        
        // abba
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                if (map.get(c) >= start) 
                    start = map.get(c) + 1;
            }
            len = Math.max(len, i-start+1);
            map.put(c, i);
        }
        
        return len;
    }
	
	
	//sliding window
	
	public static int lengthOfLongestSubstring3(String s) {
		
		 
		int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
      
  
	
	public static int lengthOfLongestSubstring(String s) {
		
		 char[] in = s.toCharArray();
	     int start = 1;
	     int res = 0;
	     int max = 1;
	     
	     while (res < in.length) {
	    	 start = res + 1;
	    	res = getMaxRepeatIndex2( in, start);
	    	//res = getMaxRepeatIndex( in, start);

	    	 
	    	 if ((res - (start -1))>max) {
	    		 max=res - (start -1);
	    	 }
	     }
		
		return max;
       
   }
	
	
    private static int getMaxRepeatIndex2(char [] in, int start) {
		
		int res = in.length;
		
		Set repeatSet = new HashSet<>();
		
		for (int i = start; i < in.length; i++) {
			if(repeatSet.contains(in[i])) {
				return i+1;
			}else {
				repeatSet.add(in[i]);
			}
		}
		return res;
	}
	
	private static int getMaxRepeatIndex(char [] in, int start) {
		
		int res = in.length;
		
		for (int i = start; i < in.length; i++) {
			for (int j =start - 1; j< i; j++) {
				
				if(in[i] == in[j]) {
					return i;
				}	
			}
		}
		return res;
	}
}
