package Algorithms;

import java.util.Arrays;

//https://www.educative.io/courses/grokking-the-coding-interview/gkZNLjV2kBk
public class KnapSack {

	  public int solveKnapsack(int[] profits, int[] weights, int capacity) {
	    int[][] dp = new int[profits.length][capacity + 1];
	    int result = this.knapsackRecursive(dp, profits, weights, capacity, 0);
	    System.out.println("profits: " + Arrays.toString(profits));
	    System.out.println("weights: " + Arrays.toString(weights));

	    System.out.println("DP: " + Arrays.toString(dp[0]));
	    System.out.println("DP: " + Arrays.toString(dp[1]));
	    System.out.println("DP: " + Arrays.toString(dp[2]));
	    System.out.println("DP: " + Arrays.toString(dp[3]));

	    return result;
	  }

	  private int knapsackRecursive(int[][] dp, int[] profits, int[] weights, int capacity,
	      int currentIndex) {

	    // base checks
	    if (capacity <= 0 || currentIndex >= profits.length)
	      return 0;

	    // if we have already solved a similar problem, return the result from memory
	    if(dp[currentIndex][capacity] != 0)
	      return dp[currentIndex][capacity];

	    // recursive call after choosing the element at the currentIndex
	    // if the weight of the element at currentIndex exceeds the capacity, we shouldn't process this
	    int profit1 = 0;
	    if( weights[currentIndex] <= capacity )
	        profit1 = profits[currentIndex] + knapsackRecursive(dp, profits, weights,
	                capacity - weights[currentIndex], currentIndex + 1);

	    // recursive call after excluding the element at the currentIndex
	    int profit2 = knapsackRecursive(dp, profits, weights, capacity, currentIndex + 1);

	    dp[currentIndex][capacity] = Math.max(profit1, profit2);
	    return dp[currentIndex][capacity];
	  }

	  public static void main(String[] args) {
		  KnapSack ks = new KnapSack();
	    int[] profits = {1, 6, 10, 16};
	    int[] weights = {1, 2, 3, 5};
	    int maxProfit = ks.solveKnapsack(profits, weights, 7);
	    System.out.println("Total knapsack profit ---> " + maxProfit);
	    maxProfit = ks.solveKnapsack(profits, weights, 6);
	    System.out.println("Total knapsack profit ---> " + maxProfit);
	  }
	}

