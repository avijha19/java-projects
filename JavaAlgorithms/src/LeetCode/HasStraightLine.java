package LeetCode;


//https://leetcode.com/problems/check-if-it-is-a-straight-line/

//Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
//Output: true

public class HasStraightLine {

	public static void main(String[] args) {

		
	}
	
	
	 public boolean checkStraightLine(int[][] coordinates) {
		 
		 
		 int x_first = coordinates[0][0];
	        int y_first = coordinates[0][1];
	        int x_last = coordinates[coordinates.length-1][0];
	        int y_last = coordinates[coordinates.length-1][1];
	        int slope = (x_last-x_first)==0 ? 0: (y_last-y_first) / (x_last-x_first);
	        int b = -1 * slope * x_first + y_first;
	        
	        for(int i=1; i<coordinates.length;i++) {
	            // check y = slope * x + b
	            if(coordinates[i][1]!=slope*coordinates[i][0]+b) {
	                return false;
	            }
	        }
	        return true; 
	        
	    }

}
