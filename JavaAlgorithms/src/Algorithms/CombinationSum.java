package Algorithms;


import java.util.HashSet;
import java.util.*;

public class CombinationSum {
	
// Q: Given an array or list of integers and some value X, find the pairs of integers that sum to X.   
//  [2, 3, 7],  target=5.     =>  [[2, 3]]
//  [2, 3, 7, 4, 1],  target=5.     =>  [[2, 3], [1, 4]]
// [ -3, 4, -2 ], target = -5
//[], target = 10

	public static void main(String[] args) {

		int[] input= new int[] {2, 3, 7, 4, 1};
		
		System.out.println("Number of arrays: " + getPairsOfIntegers(input, 5 ));
		
	}
	
	public static List<List<Integer>> getPairsOfIntegers(int[] arr, int target) {
	    List<List<Integer>> result = new ArrayList<>();
	    if(arr == null || arr.length == 0) {
	        return result;
	    }
	    Map<Integer, Integer> map = new HashMap<>();
	    //Set<Integer> set = new HashSet<>();
	    for(int element : arr) {
	        if(map.containsKey(element)) {
	            List<Integer> res = new ArrayList<>();
	            res.add(element);
	            res.add(map.get(element));
	            result.add(res); // <2,3>
	            //set.remove(element);
	            map.remove(element);
	        }
	        else {
	            map.put((target-element), element); //<3,2>  -2,7   1,4    -2,-3    -9,4
	            //set.add(target-element); //3     -2    1     -2   -9
	        }
	    }
	    
	    return result;
	    
	}

}
