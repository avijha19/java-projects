package Algorithms;

import java.util.HashSet;

import LeetCode.Tree.TreeNode;
import java.util.*;

public class Mobile3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Solution {
	int count;

	public int solution(TreeNode T) {

		Set<Integer> values = new HashSet<>();
		// values.add(T.x);
		dfs(T, values, 0);

		return count;

	}

	void dfs(TreeNode current, Set<Integer> values, int localCount) {

		if (current == null) {
			return;
		}
		Set<Integer> tempValues = new HashSet<>(values);

		if (values.add(current.val)) {

			if (current.left == null && current.right == null) {

				count = Math.max(count, ++localCount);
				return;
			}
			localCount++;
			dfs(current.left, tempValues, localCount);
			dfs(current.right, tempValues, localCount);

		} else {
			localCount = 0;

		}

	}
}