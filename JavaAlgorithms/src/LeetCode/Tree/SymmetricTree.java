package LeetCode.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class SymmetricTree {

	static TreeNode root;

	public static void main(String[] args) {

		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.left.left = new TreeNode(4);

		boolean isSymmetric = isSymmetric(root);

		System.out.println("Is Same tree: " + isSymmetric);

	}

	public static boolean isSymmetric(TreeNode root) {
		boolean isSymmetric = true;
		
		Queue<TreeNode> nodeQueue =  new LinkedList<>();
		Map<Integer,List<TreeNode>> levelNode =  new HashMap<>();
		int level = 1;
		List<TreeNode> temp = new ArrayList<TreeNode>();
		temp.add(root);
		levelNode.put(level, temp);
		nodeQueue.add(root);
		List<TreeNode> temp2 = new ArrayList<TreeNode>();
       int height = 1;
		while(!nodeQueue.isEmpty()) {
			
			if(level == 2 || level == 4 || level == 8) {
				height = height +1;
				List<TreeNode> temp3 = new ArrayList<TreeNode>();
				levelNode.put(height, temp3);
				temp2.clear();
			}
			
			TreeNode current = nodeQueue.peek();
			
			if(current.left!=null) {
				nodeQueue.add(current.left);
				temp2.add(current.left);
			}
			
			if(current.right!=null) {
				nodeQueue.add(current.right);
				temp2.add(current.right);

			}
			
			nodeQueue.poll();
			level ++;
			
		}

		return isSymmetric;
	}

}
