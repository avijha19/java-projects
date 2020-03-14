package LeetCode.SubArray;

//https://leetcode.com/problems/container-with-most-water/

//Input: [1,8,6,2,5,4,8,3,7]
//Output: 49

public class ContainerWithMostWater {

	public static void main(String[] args) {
		int[] inArr =  new int[] {1,8,6,2,5,4,8,3,7};

		System.out.println("Area: " + maxArea(inArr));
	}

	public static int maxArea(int[] height) {
		
		int start = 0;
		int end = height.length -1;
		
		int area = 1;
		int areaTemp = 1;
		int maxHeight = 1;
		
		
		while (start < end) {
			if(height[start] >= height[end] ) {
				maxHeight = height[end];
				areaTemp = maxHeight*(end-start);
				end--;
				
			}else {
				maxHeight = height[start];
				areaTemp = maxHeight*(end-start);
				start++;
			}
			area = Math.max(area, areaTemp);
		}
		
		
		return area;

	}

}
