package LeetCode.Tree;

import java.util.LinkedList;
import java.util.Queue;

//to check whether any tree is binary search tree?

public class IsBinarySearchTree {

	static TreeNode root;

	public static void main(String[] args) {

		IsBinarySearchTree demoTree = new IsBinarySearchTree();

		demoTree.insert(5);
		demoTree.insert(3);
		demoTree.insert(4);
		demoTree.insert(2);
		demoTree.insert(10);
		demoTree.insert(16);
		demoTree.insert(20);
		demoTree.insert(25);
		demoTree.insert(12);
		demoTree.insert(13);
		demoTree.insert(14);
		demoTree.insert(22);
		demoTree.insert(19);


	
		System.out.println("Level Order Print ");
		demoTree.printTreeLevelOrder();

		System.out.println("Is Binary Search: " +demoTree.isBinarySearch(root));


	}

	public boolean isBinarySearch(TreeNode root) {
		boolean isBinarySearch = true;
		
		if(root !=null) {
			if ( root.left != null && root.val < root.left.val) {
				isBinarySearch = false;
				return isBinarySearch;
			}

			if (root.right != null && root.val > root.right.val) {
				isBinarySearch = false;
				return isBinarySearch;
			}
			isBinarySearch = isBinarySearch(root.left); // first check whether all the nodes of left tree is binary search tree or not then check right sub tree
			if (isBinarySearch) {
				isBinarySearch = isBinarySearch(root.right);
			}
		}		

		return isBinarySearch;

	}
	
	public IsBinarySearchTree() {
		
	}
	
// Here binary tree will not be binary search tree as insert is making sure that we are inserting like binary search tree

//	private void insert(int num) {
//
//		if (root == null) {
//			root = new TreeNode(num);
//		} else {
//			Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
//			nodeQueue.add(root);
//			insert(nodeQueue, num);
//		}
//
//	}
//	
//
//	private void insert(Queue<TreeNode> nodeQueue, int num) {
//
//		while (!nodeQueue.isEmpty()) {
//			TreeNode current = nodeQueue.peek();
//			if (current.left == null) {
//				current.left = new TreeNode(num);
//				break;
//			} else {
//				nodeQueue.add(current.left);
//			}
//
//			if (current.right == null) {
//				current.right = new TreeNode(num);
//				break;
//			} else {
//				nodeQueue.add(current.right);
//			}
//
//			nodeQueue.poll();
//		}
//	}
	
	
	// Here binary tree will be binary search tree as insert is making sure that we are inserting like binary search tree
	public void insert(int val) {

		if (null == root) {
			root = new TreeNode(val);
		} else {
			root = insert(val, root);
		}

	}
	
	public TreeNode insert(int val, TreeNode node) {

		if (null == node) {
			node = new TreeNode(val);
			return node;
		} else {
			if (node.val > val) {
				node.left = insert(val, node.left);
			} else {
				node.right = insert(val, node.right);
			}
		}
		return node;

	}

	
	public void printTreeLevelOrder() {

		Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
		nodeQueue.add(root);
		printTreeLevelOrder(nodeQueue);

	}

	private void printTreeLevelOrder(Queue<TreeNode> nodeQueue) {

		while (!nodeQueue.isEmpty()) {
			TreeNode current = nodeQueue.peek();
			if (current.left != null) {
				nodeQueue.add(current.left);
			}
			if (current.right != null) {
				nodeQueue.add(current.right);
			}
			System.out.println("" + nodeQueue.poll().val);

		}
	}

}
