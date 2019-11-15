package LeetCode;

//https://leetcode.com/problems/reverse-integer/submissions/

public class ReverseInteger {
	
public static void main ( String[] args) {
		
		int x= 4569;
//		int x= 817;

		System.out.println(" Reverse Integer: " + reverse(x) );
		System.out.println(" Reverse Integer: " + reverse2(x) );

	}

//Without overflow issue with the use of long

	public static int reverse3(int x) {

		long res = 0;
		while (x != 0) {
			res = res * 10 + x % 10;
			x = x / 10;
		}

		if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) {
			return 0;
		} else {
			return (int) res;
		}

	}


//with overflow issue //1027 / 1032 test cases passed. 

public static int reverse2(int x) {
	
	int reverse = 0;
	int digit =0;
	while(x!=0) {
		digit = x%10;
		reverse = reverse*10 + digit;
		x= x/10;
		
	}
	
	return reverse;
        
  }

//Without overflow issue
public static int reverse(int x) {
	int reverse = 0;
	int num=x;
	int digit=0;
	
	while(num!=0) {	
		digit = num % 10;
		num= num/10;
		 if (reverse > Integer.MAX_VALUE/10 || (reverse == Integer.MAX_VALUE / 10 && digit > 7)) return 0;
         if (reverse < Integer.MIN_VALUE/10 || (reverse == Integer.MIN_VALUE / 10 && digit < -8)) return 0;
		reverse= reverse*10 + digit;		
	}
	
	return reverse;
        
  }

}


