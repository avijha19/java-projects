package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        
        
	int row = matrix.length;
        
	int col =  matrix[0].length;
	int newLength = row*col;
	
	int[] result = new int[newLength];
	
	
	int t = row + col -2;
	int r = 0;

	
	for(int k=0; k < t+1; k++) {
		
		for(int i=0;i <row ;i ++) {
			
			for(int j=0;j <col ;j ++) {
				if ((i+j)== k) {
					if(k%2 == 0) {
						result[r] = matrix[j][i];
						r++;
					//	System.out.println( in[j][i]);

					}else {
						result[r] = matrix[i][j];
						r++;
						//System.out.println( in[i][j]);

					}
				}
				
			}
		}
		
	}
	
	return result;
	
    }
}
public class MainClass {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
          return new int[0];
        }
    
        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }
    
    public static int[][] stringToInt2dArray(String input) {
        JsonArray jsonArray = JsonArray.readFrom(input);
        if (jsonArray.size() == 0) {
          return new int[0][0];
        }
    
        int[][] arr = new int[jsonArray.size()][];
        for (int i = 0; i < arr.length; i++) {
          JsonArray cols = jsonArray.get(i).asArray();
          arr[i] = stringToIntegerArray(cols.toString());
        }
        return arr;
    }
    
    public static String integerArrayToString(int[] nums, int length) {
        if (length == 0) {
            return "[]";
        }
    
        String result = "";
        for(int index = 0; index < length; index++) {
            int number = nums[index];
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }
    
    public static String integerArrayToString(int[] nums) {
        return integerArrayToString(nums, nums.length);
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[][] matrix = stringToInt2dArray(line);
            
            int[] ret = new Solution().findDiagonalOrder(matrix);
            
            String out = integerArrayToString(ret);
            
            System.out.print(out);
        }
    }
}
