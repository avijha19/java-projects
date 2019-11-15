package Sorting;

public class Soduku {
	
	static int IS_EMTPY = 0;

	
	public static void main (String[] args) {
		
		int[][] arr = new int[][]{
				{0,2,3,  4,5,6,  7,8,9},
				{4,5,6,  7,8,9,  1,2,3},
				{7,8,9,  1,2,3,  4,5,6},
				
				{2,3,1,	 5,6,4,	 8,9,7},
				{5,6,4,  8,9,7,  2,3,1},
				{8,9,7,  2,3,1,  5,6,4},
				
				{3,1,2,  6,4,5,  9,7,8},
				{6,4,5,  9,7,8,  3,1,2},
				{9,7,8,  3,1,2,  6,4,5}		
				
								  };
								  
								  
			System.out.println("Before Solving: " );
			printArray(print2dLinearEfficient(arr));					  
			  
			System.out.println("isSoduku: " + isSoduku(arr));					  
		
			System.out.println("isSolved: " + solve(arr));	
			
			System.out.println("After Solving: ");
			print2dLinearEfficient(arr);					  

	}
	
	
	
	
	
	
	private static boolean isSoduku(int[][] arr) {
		
		boolean	isSoduku=true;
		
		for (int row = 0; row <9 ; row ++) {
			for (int col = 0; col < 9; col ++) {
				if(!(arr[row][col] == IS_EMTPY)) {
					isSoduku = isSoduku(arr,row, col, arr[row][col]);
					if(false == isSoduku ) {
		    			System.out.println("isSolved false for data: " + arr[row][col] + " , Row: " +row + " , Col: " +col);	
						break;
					} else {
						continue;
					}
				}
			}
			
			if(false == isSoduku) {
				break;
			} else {
				continue;
			}
		}
		
		return isSoduku;
		
	}
	
	
    private static boolean solve(int[][] arr) {
		
		boolean	isSolved=false;
		
		for (int row = 0; row <9 ; row ++) {
			for (int col = 0; col < 9; col ++) {
				if((arr[row][col] == IS_EMTPY)) {
					
					for (int k =1; k <=9; k ++) {
						
						isSolved = isSoduku(arr,row, col, k);
						if(!isSolved) {
							arr[row][col] = k;
							
							if(solve(arr)) {
								return true;
							} else {
								arr[row][col] = IS_EMTPY;
							}
					
						}
					}
					
				   }
				}
			}
			
			
		
		return isSolved;
		
	}
	
	private static boolean isSoduku(int[][] arr, int row, int col, int data) {
		
		boolean isSoduku =  true;
		
//		if(isInBox(arr, row, col, data) ) {
//			
//			isSoduku = false;
//		}
//		
		if(isInRow(arr, row, col, data) || isInCol(arr, row, col, data) || isInBox(arr, row, col, data)) {
			
			isSoduku = false;
		}
		
		return isSoduku;
		
		
	}
	
	
	private static boolean isInRow(int[][] arr, int row, int col, int data) {
		
      boolean isInRow=false;
       
        for	(int c=0; c < col; c ++) {
        	if (arr[row][c] == data) {
        		isInRow=true;
    			System.out.println("isInRow true for data: " + data + ", Row: " +row +", Col: " +col);					  

        		break;
        				
        	}
        }
        
        for	(int c=col+1; c < 9; c ++) {
        	if (arr[row][c] == data) {
        		isInRow=true;
    			System.out.println("isInRow true for data: " + data + ", Row: " +row +", Col: " +col);					  

        		break;
        				
        	}
        }
		return isInRow;
	}
	
	
	private static boolean isInCol(int[][] arr, int row, int col, int data) {
		
	      boolean isInCol=false;
	       
	        for	(int r=0; r < row; r++) {
	        	if (arr[r][col] == data) {
	        		isInCol=true;
	    			System.out.println("isInCol true for data: " + data + ", Row: " +row +", Col: " +col);					  

	        		break;
	        				
	        	}
	        }
	        
	        
	        for	(int r=row+1; r < 9; r++) {
	        	if (arr[r][col] == data) {
	        		isInCol=true;
	    			System.out.println("isInCol true for data: " + data + ", Row: " +row +", Col: " +col);					  

	        		break;
	        				
	        	}
	        }
	        
			return isInCol;
		}
	
	
	private static boolean isInBox(int[][] arr, int row, int col, int data) {

		boolean isInBox = false;
		
		int originalRow = row;
		int oroginalCol =col;

		row = row - row % 3;
		col = col - col % 3;

		for (int r = row; r < row + 3; r++) {
			for (int c = col; c < col + 3; c++) {

				if (r == originalRow && c == oroginalCol) {

				} else {
					if (arr[r][c] == data) {
						isInBox = true;
						System.out.println("isInBox true for data: " + data + " , Row: " + row + " , Col: " + col);

						break;

					}
				}

			}
		}
		return isInBox;
	}
	
	public static void printArray(int[] in) {
		for (int i = 0; i < in.length; i++) {
			System.out.println(in[i] + ", ");

		}

	}
	
	private static int[] print2dLinearEfficient(int[][] in) {
		int row = in.length;
		int col = in[0].length;
		int newLength = row * col;

		int[] result = new int[newLength];
		int r = 0;
		int c = 0;

		for (int i = 0; i < result.length; i++) {

			result[i] = in[r][c];

			if (r == 0 && c < col - 1) {
				c++;
			} else if (c == col - 1) {
				r++;
				c = 0;
			} else {
				c++;
			}
		}

		return result;
	}


}
