package LeetCode.Tree;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/maximum-depth-of-binary-tree/

//Given a binary tree, find its maximum depth.
//
//The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
//
//Note: A leaf is a node with no children.
//
//Example:
//
//Given binary tree [3,9,20,null,null,15,7],
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//return its depth = 3.

public class MaxDepthBinaryTree {

	private TreeNode root1;

	public static void main(String[] args) {

		Integer[] intArr =  new Integer[] {3,9,20,(Integer) null,(Integer) null,15,7};
		MaxDepthBinaryTree demoTree = new MaxDepthBinaryTree();
		demoTree.populateTree(intArr);
		System.out.println("Root: " + demoTree.root1.val);
		System.out.println("Max Depth: " + demoTree.maxDepth(demoTree.root1));

		
	}
	
	public MaxDepthBinaryTree() {
		root1 = null;
	}
	
	//leetcode Solution
	
	public int maxDepth(TreeNode root) {
	    if (root == null) {
	      return 0;
	    } else {
	      int left_height = maxDepth(root.left);
	      int right_height = maxDepth(root.right);
	      return java.lang.Math.max(left_height, right_height) + 1;
	    }
	  }

	//Avinash solution
	public int maxDepth1(TreeNode root) {
		int maxDepth = 1;
		if(root == null) {
			maxDepth =  0;
		} else if(root.left == null && root.right == null) {
			maxDepth = 1;
		} else {
			 TreeNode deepestNode = findDeepestNode(root);
			 maxDepth  = findLevel(root,deepestNode.val,maxDepth);
		}
		return maxDepth;

	}
	
	
	
	private int findLevel(TreeNode current, Integer val, int level) {
		if(current == null) {
			return -1;
		}
		if(current.val ==  val) {
			return level;
		} 
		
		int l = findLevel(current.left, val, level +1);
		if(l !=-1) {
			return l;
		}
		
		return findLevel(current.right, val, level +1);
	}

	private TreeNode findDeepestNode(TreeNode root) {
		
		TreeNode deepestNode = null;
		Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
		nodeQueue.add(root);

		while (!nodeQueue.isEmpty()) {
			TreeNode current = nodeQueue.peek();
			if (current.left != null) {
				nodeQueue.add(current.left);
			}
			if (current.right != null) {
				nodeQueue.add(current.right);
			}
			deepestNode = nodeQueue.poll();
		}

		return deepestNode;
	
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
