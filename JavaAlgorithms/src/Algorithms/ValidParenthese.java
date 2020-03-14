package Algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ValidParenthese {

	public static void main(String args[]) throws Exception {
		/*
		 * Sample code to perform I/O: Use either of these methods for input
		 * 
		 * 
		 * 
		 * //BufferedReader BufferedReader br = new BufferedReader(new
		 * InputStreamReader(System.in)); String name = br.readLine(); // Reading input
		 * from STDIN System.out.println("Hi, " + name + "."); // Writing output to
		 * STDOUT
		 */
		// Scanner
//		Scanner s = new Scanner(System.in);
//		String count = s.nextLine(); // Reading input from STDIN
//		System.out.println("Hi, " + count + "."); // Writing output to STDOUT
//		try {
//		printParanthesis(Integer.parseInt(count));
//		} catch (Exception ex) {
//			System.out.println("--");
//		}
//		
		
		int x = 1;
		int y = 3;
		
		boolean ans = (x & (1 << y)) != 0;
		
		System.out.println(ans);

		// Write your code here

	}

	public static List<String> printParanthesis(int count) {
		List<String> result = new ArrayList<>();
		for (int i = 1; i <= count; i++) {
			for (String left : printParanthesis(i)) {
				for (String right : printParanthesis(count - 1 - i)) {
					result.add("(" + left + ")" + right);
				}
			}

		}
		for (int i = 0; i < result.size(); i++) {
			System.out.print(result.get(i));
		}
		return result;
	}

}
