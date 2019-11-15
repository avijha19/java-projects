package LeetCode.SubArray;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

//For example, consider the array [1, 2, 1, 3, 2]. It has a degree of 2 based 
//on the elements with values 1 and 2. The subarray of degree 2 based on 
//the 1's is [1, 2, 1] and based on 2's is [2, 1, 3, 2]. Their lengths are 3 and 4, 
//so the shortest is length 3. Property 1 is 2 and property 2 is 3.
//
//Function Description 
//Complete the function degreeOfArray in the editor below. The function
//must return an integer denoting the minimum size of the subarray such that
//		the degree of the subarray is equal to the degree of the array.
 

public class DegreeOfArray {

	public static void main(String[] args) {
		
		int[] in = new int[] {1, 2, 1, 2, 2,1,3};
		int degreeOfArray = findDegree(in);
		System.out.println("Degree Of Array: " +degreeOfArray );
		

	}
	
	
	private static int findDegree(int[] in) {

		int maxCount = 1;
		

		Map<Integer, int[]> myCount = new HashMap<>();

		for (int i = 0; i < in.length; i++) {
			if (null == myCount.get(in[i])) {
				myCount.put(in[i], new int[]{i,1,i});
			} else {
				int newValue = myCount.get(in[i])[1] + 1;
				int start = myCount.get(in[i])[0];
				int end = i;
				int[] newCount = new int[] {start,newValue, end };
				myCount.put(in[i], newCount);
			}
		}

		Set<Entry<Integer,  int[]>> entrySet = myCount.entrySet();
		int count = 1;
		int element = 0;
		int[] newCount;
		int subArray =0;
		
		for (Entry<Integer,  int[]> entry : entrySet) {

			newCount = entry.getValue();
			count = newCount[1];
			
			if (count > maxCount) {
				maxCount = count;
				element = entry.getKey();
				subArray = newCount[2] - newCount[0]+1;
				
			}
		}
		
		System.out.println("Entry with most occurance: " + element + ": Sub Array: " + subArray);
		
		

		return maxCount;
	}

	/*private static int findDegree(int[] in) {

		int maxCount = 1;

		Map<Integer, Integer> myCount = new HashMap<>();

		for (int i = 0; i < in.length; i++) {
			if (null == myCount.get(in[i])) {
				myCount.put(in[i], 1);
			} else {
				int newValue = myCount.get(in[i]) + 1;
				myCount.put(in[i], newValue);
			}
		}

		Set<Entry<Integer, Integer>> entrySet = myCount.entrySet();
		int count = 1;
		int element = 0;

		for (Entry<Integer, Integer> entry : entrySet) {

			count = entry.getValue();
			if (count > maxCount) {
				maxCount = count;
				element = entry.getKey();
			}
		}
		
		System.out.println("Entry with most occurance: " + element);
		
		int start=0;
		int end =0;
				
		for (int i = 0; i < in.length; i++) {
			for ( int j=i+1; j< in.length; j++) {
				
				for (int k = i; k<j ; k++) {
					if(in[k] == element) {
						start=i;
						
					}
				}
			}
			
		}

		return maxCount;
	} */
	
	

}
