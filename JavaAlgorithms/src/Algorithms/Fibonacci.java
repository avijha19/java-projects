package Algorithms;

public class Fibonacci {
	
//	Input: 2
//	Output: 1
//	Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
	
	public static void main (String[] args) {
		
		System.out.println("Fibonacci Series: " + fib(5));
	}
	static int sum =0;

	    public static int fib(int x) {
	    	sum=0;
	    	if(x>=0) {
	    	if(x== 0) {
	    		return 0;
		    } else if(x == 1) {
	    		return 1;
	
	    	}	
		    else {
	    		 x--;
	 		    sum=fib(x) + fib(x-1);
	    	}
		   
	    }	
	    	
	    	return sum;
	        
	    }
	}


