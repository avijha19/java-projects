package Algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Mobile4 {

	public static void main(String[] args) {

	}

	public String numberOfIslands(int rows, int cols, int[][] island) {
		if (island == null || island.length == 0) {
			return "-";
		}
		// System.out.println("hi");
		List<Integer> islandSizes = new ArrayList<>();
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (island[i][j] == 1) {
					islandSizes.add(dfs(island, i, j, 1));
				}
			}
		}
		Collections.sort(islandSizes);
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < islandSizes.size(); i++) {
			result.append(islandSizes.get(i) + " ");
		}
		System.out.println(result.toString().trim());
		return result.toString().trim();
	}

	public int dfs(int[][] island, int row, int col, int islandSize) {
		if (row < 0 || col < 0 || row >= island.length || col >= island[row].length || island[row][col] == 0) {
			return 0;
		}
		island[row][col] = 0;
		islandSize += dfs(island, row - 1, col, islandSize);
		islandSize += dfs(island, row + 1, col, islandSize);
		islandSize += dfs(island, row, col - 1, islandSize);
		islandSize += dfs(island, row, col + 1, islandSize);
		return islandSize;
	}
}
