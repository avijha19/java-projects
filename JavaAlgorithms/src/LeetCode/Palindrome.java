package LeetCode;

public class Palindrome {
	
	public static void main ( String[] args) {
		
		int x= 121;
		
		System.out.println(" Palindrome: " + isPalindrome(x) );
	}
	
	
public static boolean isPalindrome(int x) {
	boolean isPalindrome= false;
	if(x<0) {
		return isPalindrome;
	}
	int number = x;
	int digit =0;
	int reverseNumber = 0;;
	int i = 0;
	while(number!=0) {
		System.out.println("lopp*******: " + ++i);
	digit= number % 10;
	System.out.println("digit: " +number);
	number=number/10;
	System.out.println("number: " +number);
	

	reverseNumber = reverseNumber*10 + digit;
	System.out.println("reverseNumber: " +reverseNumber);

	
	}
	
	System.out.println("reverse Number: " + reverseNumber);
	
	if(reverseNumber==x) {
		isPalindrome=true;
	}
	
	return isPalindrome;
        
    }

}
