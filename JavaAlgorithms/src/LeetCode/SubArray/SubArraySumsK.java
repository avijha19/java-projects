package LeetCode.SubArray;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/subarray-sum-equals-k/

//Input:nums = [1,1,1], k = 2
//Output: 2

public class SubArraySumsK {

	public static void main(String[] args) {

//		int[] in = new int[] {1,1,1};
//		int sum = 2;
		// ans = 2
		
		
		
//		int[] in = new int[] {1,2,3};
//		int sum = 3;
		// ans = 2
		
//		
		int[] in = new int[] { 0, 9, 3, 7, 5, 4, 2, 1 };
		int sum = 12;
//       ans =  4

//	    int[] in = new int[] {0,0,0,0,0,0,0,0,0,0};
//		int sum = 0;
//         ans =  55
		
	

		// bruteforce O(n3)
		int count = subArraySum2(in, sum);
		System.out.println("Count Sub Array + " + count);

		// HashMap O(n)
	    count = subarraySum1(in, sum);
		System.out.println("Count Sub Array + " + count);

		
		// sliding window avinash o(n2)
		count = subArraySum3(in, sum);
		System.out.println("Count Sub Array + " + count);
		
		
		// sliding window enhanced o(n)
	    count = subArraySum4(in, sum);
		System.out.println("Count Sub Array + " + count);

	}
	
	//Using hashMap O(n)
	public static int subarraySum1(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        Map <Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        for (int n: nums) {
        	sum = sum + n;
        	
        	if(map.containsKey(sum - k)) {
        		count = count + map.get(sum -k);
        	}
        	
        	if(!map.containsKey(sum)){
        		map.put(sum, 1);
        	} else {
        		map.put(sum, (map.get(sum) +1));
        	}
        }
        
        
        return count;
    }

	// sliding window avinash o(n2)

	private static int subArraySum3(int[] nums, int k) {
		
		int start = 0;
		int count = 0;
		
		for (int i = 0; i < nums.length ; i++) {
			int sum =0;
			
			while (start < nums.length) {
				sum = sum + nums[start];
				if(sum==k) {
					count++;
				}
				start ++;
			}
			start = i+1;
		}
		
		return count;
		
	}

	// sliding window enhanced o(n)

	private static int subArraySum4(int[] nums, int k) {
		int start = 0;
		int end = 1;
		int count = 0;
		int sum = nums[start];

		while (start < nums.length && end < nums.length) {
			sum = sum + nums[end];
			if (sum == k) {
				start++;
				end = start + 1;
				if (start < nums.length) {
					sum = nums[start];
				}
				count++;
			} else {
				if (end < nums.length - 1) {
					end++;
				} else if (end == nums.length - 1) {
					start++;
					end = start + 1;
					if (start < nums.length) {
					sum = nums[start];
					}
					if (start == nums.length - 1) {
						end = start;
						sum = nums[start] - nums[end];
					}
				}
			}

		}

		return count;
	}

	// bruteforce O(n3)

	private static int subArraySum2(int[] nums, int k) {
     
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j <= nums.length; j++) {
				int sum = 0;
				for (int m = i; m < j; m++) {
					sum = sum + nums[m];
				}
				if (sum == k) {
					count++;
				}
			}
		}

		return count;

	}

}
