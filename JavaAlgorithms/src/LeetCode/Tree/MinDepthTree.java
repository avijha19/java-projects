package LeetCode.Tree;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/minimum-depth-of-binary-tree/solution/

public class MinDepthTree {

	private TreeNode root1;

	public static void main(String[] args) {
		//Integer[] intArr =  new Integer[] {3,9,20,(Integer) null,(Integer) null,15,7};
		Integer[] intArr =  new Integer[] {1,2,3,4,5};

		MinDepthTree demoTree = new MinDepthTree();
		demoTree.populateTree(intArr);

		System.out.println(" Minimum Depth: " + demoTree.minDepth(demoTree.root1));
	}
	
	public MinDepthTree() {
		root1 = null;
	}
	
	//recursion
	
	public int minDepth(TreeNode root) {

		if (root == null) {
			return 0;
		}

		if ((root.left == null) && (root.right == null)) {
			return 1;
		}

		int min_depth = Integer.MAX_VALUE;
		if (root.left != null) {
			min_depth = Math.min(minDepth(root.left), min_depth);
		}
		if (root.right != null) {
			min_depth = Math.min(minDepth(root.right), min_depth);
		}

		return min_depth + 1;
	}
        
	// using BFS
	
	
	public int minDepthBFS(TreeNode root) {
		
		if(root == null) {
			return 0;
		}

		Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
		nodeQueue.add(root);
		int level = 0;
		while (!nodeQueue.isEmpty()) {	
			level ++;
			
			TreeNode current = nodeQueue.peek();
			if(current == null) {
				break;
			} else {
				if(current.left == null && current.right == null) {
					break;
				}
				if(current.left != null) {
					nodeQueue.add(current.left);
				}
				
				if(current.right != null) {
					nodeQueue.add(current.right);
				}
				nodeQueue.poll();	
			}
			
		}
		
		return level;
	}
    
   
   
 
  
  private void populateTree (Integer[] intArr) {
		
		root1 = new TreeNode(intArr[0]);
		TreeNode temp = null;
		for (int i =1; i< intArr.length; i++) {
			temp = new TreeNode(intArr[i]);
			insert(temp);
		}		
	}
	
	

	private void insert(TreeNode temp) {
		Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
		nodeQueue.add(root1);

		while (!nodeQueue.isEmpty()) {
			TreeNode current = nodeQueue.peek();
			if (current.left == null) {
				current.left = temp;
				break;
			} else {
				nodeQueue.add(current.left);
			}
			if (current.right == null) {
				current.right = temp;
				break;
			} else {
				nodeQueue.add(current.right);
			}
			nodeQueue.poll();
		}
	}

}
