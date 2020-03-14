package Algorithms;

import java.util.HashSet;

public class Mobile1 {

	public static void main(String[] args) {
		
		int[] arr =  new int[] { 1,4,-1,-10, };
		
		int ans = solution(arr);
		
		System.out.println("ciount" + ans);

	}
	
	public static int solution(int[] A) {
        // write your code in Java SE 8
		        
        
        int count = 0;
        
        int indexNext = 0;
        
        while(indexNext != -1){
            indexNext = A[indexNext];
            count++;
        }
        return count;
        
       
        
        
    }

}
