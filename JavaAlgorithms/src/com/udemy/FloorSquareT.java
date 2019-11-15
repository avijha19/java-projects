package com.udemy;

public class FloorSquareT {

	public static void main(String[] args) {

		System.out.println("Floor Sqaure: " + floorSquare(256));
		System.out.println("Floor Sqaure: " + floorSquareOptimized(256));


	}

	public static int floorSquare(int x) {
		int floorSquare = 1;
		int n =0;
		while (floorSquare * floorSquare < x) {
			floorSquare++;
			n++;
		}
		System.out.println("Floor Sqaure: number iteration" +n);

		return floorSquare;
	}
	
	

	public static int floorSquareOptimized(int x) {
		int floorSquare = 1;
		int start = 1;
		int end = x;
		int n =0;
		while (start < end) {
             n++;
			int mid = (start + end) / 2;

			if (mid * mid == x) {
				System.out.println("Floor Sqaure: number iteration" +n);
				return mid;
			} else if (mid * mid > x) {

				end = mid - 1;
			} else if (mid * mid < x) {
				start = mid + 1;
				floorSquare = mid;
			}
		}
		System.out.println("Floor Sqaure: number iteration" +n);
		return floorSquare;
	}
	
	
}
