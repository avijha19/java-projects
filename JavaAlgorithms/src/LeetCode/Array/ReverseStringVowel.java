package LeetCode.Array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

//https://leetcode.com/problems/reverse-vowels-of-a-string/

//Example 1:
//
//Input: "hello"
//Output: "holle"
//Example 2:
//
//Input: "leetcode"
//Output: "leotcede"
//[l, e, o, t, c, e, d, e]
//Note:
//The vowels does not include the letter "y".

public class ReverseStringVowel {

	public static void main(String[] args) {
		
			String reverse = reverseVowels("aA");
			System.out.println("Reverse: " +reverse.toString());
	}

   public static String reverseVowels(String str) {
	   
	   
	   List<Character> vowelsList = new ArrayList<>();
	   vowelsList.add('a');
	   vowelsList.add('i');
	   vowelsList.add('u');
	   vowelsList.add('o');
	   vowelsList.add('e');
	   vowelsList.add('A');
	   vowelsList.add('I');
	   vowelsList.add('U');
	   vowelsList.add('O');
	   vowelsList.add('E');
	   
	   
	   Stack<Character> charList = new Stack<>();
	   
	   for (int i=0; i< str.length(); i++) {
		   
		   if (vowelsList.contains(str.charAt(i))) {
			   charList.add(str.charAt(i));
		   }
		   
	   }
	   
	   char[] charArry = str.toCharArray();
	   for (int i=0; i< str.length(); i++) {
		   
		   if (vowelsList.contains(str.charAt(i))) {
			   charArry[i]= charList.pop();
		   }
		   
	   }

	   
	 return String.valueOf(charArry);
        
    }
	
}
