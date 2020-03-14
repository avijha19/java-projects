package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class IslandSizes {

	public static void main(String[] args) throws IOException {

		Scanner s = new Scanner(System.in);
		String input = s.nextLine();

		if (input.length() <= 2) {
			System.out.println("-");
		}

		else {
			String[] sizes = input.split(" ");
			int rows = 0;
			int cols = 0;
			try {
				rows = Integer.parseInt(sizes[0]);
				cols = Integer.parseInt(sizes[1]);
				
				if(rows <= 0 || cols<= 0 ) {
					throw new Exception();
				}
				
				// Reading input from STDIN

				int[][] island = new int[rows][cols];
				for (int i = 0; i < rows; i++) {
					String row = s.nextLine();
					String[] rowVal = row.split(" ");
					for (int j = 0; j < cols; j++) {
						island[i][j] = Integer.parseInt(rowVal[j]);

					}
				}
				numberOfIslands(island.length, island[0].length, island);

			} catch (Exception ex) {
				System.out.println("-:-");
				return;
			}

		}

	}
	
	public static String numberOfIslands(int rows, int cols, int[][] island) {
        if(island == null || island.length == 0) {
            return "-";
        }
        
        List<Integer> islandSizes = new ArrayList<>();
        
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(island[i][j] == 1) {
                    islandSizes.add(dfs(island, i, j, 1));
                }
            }
        }
        Collections.sort(islandSizes);
        StringBuilder result = new StringBuilder();
        for(int i=0; i < islandSizes.size(); i++) {
            result.append(islandSizes.get(i) + " ");
        }
        System.out.println(result.toString().trim());
        return result.toString().trim();
    }
    
    public static int dfs(int[][] island, int row, int col, int islandSize) {
        if(row < 0 || col < 0 || row >= island.length || col >= island[row].length || island[row][col] == 0) {
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
