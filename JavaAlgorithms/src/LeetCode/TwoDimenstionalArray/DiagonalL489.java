package LeetCode.TwoDimenstionalArray;

public class DiagonalL489 {

	/*
	 * Input: [ [ 1, 2, 3 ], [ 4, 5, 6 ], [ 7, 8, 9 ] ]
	 * 
	 * Output: [1,2,4,7,5,3,6,8,9]
	 * 
	 * https://leetcode.com/problems/diagonal-traverse/
	 */

	public static void main(String args[]) {

//		int[][] in = new int[][]{{ 1,2,3},{4,5,6} , {7,8,9}, {10,11,12}};
		// int[][] in = new int[][]{{ 1,2,3},{4,5,6}};
//		int[][] in = new int[][]{{ 1,2,3},{4,5,6} , {7,8,9}};

		int[][] in = new int[][] { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15, },
				{ 16, 17, 18, 19, 20 } };

		int row = in.length;
		int col = in[0].length;
		System.out.println("M: Row: " + row);
		System.out.println("N: Col: " + col);
		// System.out.println("N: Row: " +in[2][2] );

//		System.out.println("Printing Array 2D Diagnoly: ");
//		int[] result = print2dArrayDioagnoal(in);
//		printArray(result);

//		System.out.println("Printing Array 2D: ");
//		int[] result = print2dArray(in);
//		printArray(result);

//		System.out.println("Printing Array 2D Diagnoly Efficiently: ");
//		int[] result = print2dArrayDiagonalEfficient(in);
//		printArray(result);

//		System.out.println("Printing Array 2D Diagnoly: ");
//		int[] result = print2dLinearEfficient(in);
//		printArray(result);

		System.out.println("Printing Array 2D Diagnoly: ");
		int[] result = print2dDiagonalEfficient2(in);
		printArray(result);

	}

	public static void printArray(int[] in) {
		for (int i = 0; i < in.length; i++) {
			System.out.println(in[i] + ", ");

		}

	}

	private static int[] print2dArray(int[][] in) {
		int row = in.length;
		int col = in[0].length;
		int newLength = row * col;

		int[] result = new int[newLength];
		int r = 0;

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				result[r] = in[i][j];
				r++;
			}
		}

		return result;
	}

	private static int[] print2dDiagonalEfficient2(int[][] in) {
		int row = in.length;
		int col = in[0].length;
		int newLength = row * col;

		int[] result = new int[newLength];
		int r = 0;
		int c = 0;

		for (int i = 0; i < result.length; i++) {

			result[i] = in[r][c];

			if ((r + c) % 2 == 0) {

				if (c == (col - 1)) {
					r++;
				} else if (r == 0) {
					c++;
				}

				else {
					r--;
					c++;
				}

			} else {

				if (r == (row - 1)) {
					c++;
				} else if (c == 0) {
					r++;
				} else {
					r++;
					c--;
				}

			}

		}

		return result;
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

	private static int[] print2dArrayDiagonalEfficient(int[][] matrix) {
		int rowCount = matrix.length;
		int colCount = matrix[0].length;
		int newLength = rowCount * colCount;

		int[] result = new int[newLength];
		int r = 0;

		for (int k = 0; k <= rowCount - 1; k++) {

			for (int row = k, col = 0; (row > -1) && (col <= colCount - 1); row--, col++) {
				result[r] = matrix[row][col];
				r++;
			}
		}

		for (int k = 1; k <= colCount - 1; k++) {

			for (int row = rowCount - 1, col = k; row > -1 && col <= colCount - 1; row--, col++) {
				result[r] = matrix[row][col];
				r++;
			}
		}

		return result;

	}

	private static int[] print2dArrayDioagnoal(int[][] matrix) {
		int row = matrix.length;
		int col = matrix[0].length;
		int newLength = row * col;

		int[] result = new int[newLength];

		int t = row + col - 2;
		int r = 0;

		for (int k = 0; k < t + 1; k++) {

			for (int i = 0; i < row; i++) {

				for (int j = 0; j < col; j++) {
					if ((i + j) == k) {
						if (k % 2 == 0) {
							result[r] = matrix[j][i];
							r++;
							// System.out.println( in[j][i]);

						} else {
							result[r] = matrix[i][j];
							r++;
							// System.out.println( in[i][j]);

						}
					}

				}
			}

		}

		return result;

	}

}
