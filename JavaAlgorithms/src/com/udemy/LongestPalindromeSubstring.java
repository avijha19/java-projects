package com.udemy;

//https://www.udemy.com/course/learn-data-structure-algorithms-with-java-interview/learn/lecture/13854872#overview

public class LongestPalindromeSubstring {

	public static void main(String[] args) {

		String s = "adfefaefea";

		int res = lps(0, s.length() - 1, s);
		System.out.println("Longest palindromic: " + res);
	}

	private static int lps(int start, int end, String s) {

		int result = 0;

		if (start > end) {
			return 0;
		}

		if (start == end) {
			return 1;
		}

		int c1 = 0;

		if (s.charAt(start) == s.charAt(end)) {

			int remainingLength = end - start - 1;
			if (remainingLength == lps(start + 1, end - 1, s)) {
				c1 = remainingLength + 2;
			}

		}
		int c2 = lps(start + 1, end, s);
		int c3 = lps(start, end - 1, s);

		result = Math.max(c1, Math.max(c2, c3));

		return result;
	}

}
