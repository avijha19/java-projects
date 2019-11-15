package LeetCode.Tree;

import java.util.LinkedList;
import java.util.Queue;

// In this example we print in order, level order, insert ( like binary search tree)

//https://leetcode.com/problems/cousins-in-binary-tree/

//In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
//
//Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
//
//We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.
//
//Return true if and only if the nodes corresponding to the values x and y are cousins.
//
// 
//
//Example 1:
//
//
//Input: root = [1,2,3,4], x = 4, y = 3
//Output: false
//Example 2:
//
//
//Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
//Output: true
//Example 3:
//
//
//
//Input: root = [1,2,3,null,4], x = 2, y = 3
//Output: false

// find level, find cousin , find sibling etc

public class CousinsBinaryTree {

	static TreeNode root;

	public static void main(String[] args) {

		CousinsBinaryTree demoTree = new CousinsBinaryTree();

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

//		System.out.println("In Order Print ");
//		demoTree.printTreeInOrder();
//		
		System.out.println("Level Order Print ");
		demoTree.printTreeLevelOrder();

		System.out.println("Level: " + demoTree.findLevel(root, 22, 1));
		System.out.println("Is Sibling: " + demoTree.isSibling(root, 19, 22));

		System.out.println("Is Cousins: " + demoTree.isCousins(root, 19, 13));

	}

	public CousinsBinaryTree() {
		root = null;
	}

	public boolean isCousins(TreeNode root, int x, int y) {

		boolean isCousins = false;

		int levelX = findLevel(root, x, 1);
		int levelY = findLevel(root, y, 1);

		if (levelX == levelY) {
			isCousins = !isSibling(root, x, y);
		}

		return isCousins;

	}

	private boolean isSibling(TreeNode current, int x, int y) {

		boolean isSibling = false;
		if (current == null) {
			isSibling = false;
		} else {
			if (current.left != null && current.right != null) {
				if ((current.left.val == x && current.right.val == y)
						|| (current.left.val == y && current.right.val == x)) {
					isSibling = true;
				} else {
					isSibling = isSibling(current.right, x, y); // first check in right, if found sibling dont check in right, other wise check in right
					if (!isSibling) {
						isSibling = isSibling(current.left, x, y);
					}

				}
			} else if (current.left == null) {
				isSibling = isSibling(current.right, x, y);
			} else if (current.right == null) {
				isSibling = isSibling(current.left, x, y);
			} else {
				isSibling = false;
			}
		}

		return isSibling;

	}

	private int findLevel(TreeNode current, int x, int level) {

		if (current == null) {
			return -1;
		}
		if (current.val == x) {
			return level;
		}
		int l = findLevel(current.left, x, level + 1);
		if (l != -1) {         // first check the level of left sub tree if  node is find in left sub tree , if find then return the level if  not then check in right sub tree
			return l;
		}
		return findLevel(current.right, x, level + 1);

	}

	private void insert(int num) {

		if (root == null) {
			root = new TreeNode(num);
		} else {
			Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
			nodeQueue.add(root);
			insert(nodeQueue, num);
		}

	}

	private void insert(Queue<TreeNode> nodeQueue, int num) {

		while (!nodeQueue.isEmpty()) {
			TreeNode current = nodeQueue.peek();
			if (current.left == null) {
				current.left = new TreeNode(num);
				break;
			} else {
				nodeQueue.add(current.left);
			}

			if (current.right == null) {
				current.right = new TreeNode(num);
				break;
			} else {
				nodeQueue.add(current.right);
			}

			nodeQueue.poll();
		}
	}

	public void printTreeInOrder() {

		printTreeInOrderRecursive(root);

	}

	public void printTreeInOrderRecursive(TreeNode node) {

		if (null == node) {
			return;
		} else {
			System.out.println(node.val);
			printTreeInOrderRecursive(node.left);
			printTreeInOrderRecursive(node.right);

		}

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
