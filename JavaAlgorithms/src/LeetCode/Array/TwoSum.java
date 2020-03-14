package LeetCode.Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/two-sum/

//Given nums = [2, 7, 11, 15], target = 9,
//
//Because nums[0] + nums[1] = 2 + 7 = 9,
//return [0, 1].

public class TwoSum {

	public static void main(String[] args) {

		TwoSum twoSum = new TwoSum();
		int[] nums = new int[] {2,7,11,15};
		System.out.println("Two Sums: " +Arrays.toString(twoSum.twoSum(nums, 9)));
		
	}
	
	
	
	 public int[] twoSum(int[] nums, int target) {
	        
			
			Map<Integer, Integer> map = new HashMap<>();
			for (int i = 0; i < nums.length; i++) {
				if(null != map.get(target - nums[i])) {
					return new int[] { i, map.get(target - nums[i]) };
				} else {
					map.put(nums[i], i);
				}
				
				
				
			}
//			for (int i = 0; i < nums.length; i++) {
//				int complement = target - nums[i];
//				if (map.containsKey(complement) && map.get(complement) != i) {
//					return new int[] { i, map.get(complement) };
//				}
//			}
			throw new IllegalArgumentException("No two sum solution");

		
	    }
	}
	
	


