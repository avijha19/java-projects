package com.udemy;

import java.util.HashMap;
import java.util.Map;

public class Test 
{ 
    public static int floorSqrt(int x) 
    { 
        // Base Cases 
        if (x == 0 || x == 1) 
            return x; 
  
        // Do Binary Search for floor(sqrt(x)) 
        int start = 1, end = x, ans=0; 
        while (start <= end) 
        { 
            int mid = (start + end) / 2; 
  
            // If x is a perfect square 
            if (mid*mid == x) 
                return mid; 
  
            // Since we need floor, we update answer when mid*mid is 
            // smaller than x, and move closer to sqrt(x) 
            if (mid*mid < x) 
            { 
                start = mid + 1; 
                ans = mid; 
            } 
            else   // If mid*mid is greater than x 
                end = mid-1; 
        } 
        return ans; 
    } 
    
    public static void main (String[] args) {
    	
    	int[] input = new int[3];
    	input[0]=3;
    	input[1]=2;
    	input[2]=1;
    	
    	System.out.println("Avinash: " + solve(input));
    	
    	int[] output= solve(input);
    	
    	 for(int i=0; i<output.length; i++){
    		 System.out.println("Avinash: "+ output[i]);
    	        }
    	
    }
    
    
    public static void runhash(int[] input) {
    	   Map<Integer,Integer> countMap = new HashMap<Integer,Integer>();
  
    	   for (int i=0; i<input.length; i++){
    		   if (countMap.containsKey(i)){
    		        countMap.put(i, countMap.get(i)+1);
    		   }
    		   else {
    		   countMap.put(i, 1);
    		   }
    		   
    		  }
    }
    
    
    public static int[] solve (int[] input) {
    	
    	int[] output = new int[input.length];
        int product = 1;
        for (int i=0; i< input.length; i++){
        
        product = product*input[i];
        
        }
        
        for(int i=0; i<input.length; i++){
        output[i]= product/input[i];
        }
        
        return output;
    }
    
    public static void reverse (String input) {
    
    String[] split = input.split(input);
    
    }

    
    
    
    
    
    
    // Returns floor of square root of x 
    static int floorSqrt1(int x) 
    { 
        // Base cases 
        if (x == 0 || x == 1) 
            return x; 
  
        // Staring from 1, try all numbers until 
        // i*i is greater than or equal to x. 
        int i = 1, result = 1; 
          
        while (result <= x) { 
            i++; 
            result = i * i; 
        } 
        return i - 1; 
    } 

    
}
