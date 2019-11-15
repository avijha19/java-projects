package LeetCode.Tree;

import java.util.LinkedList;
import java.util.Queue;

//insert, delete, level order print, in order print, find level of any node

public class SampleBinrayTree {

	static TreeNode root;

	public static void main(String[] args) {

		SampleBinrayTree sampleTree = new SampleBinrayTree();
		sampleTree.insert(14);
		sampleTree.insert(10);
		sampleTree.insert(3);
		sampleTree.insert(4);
		sampleTree.insert(11);
		sampleTree.insert(12);

		System.out.println("In order print");
		sampleTree.printTreeInOrder();
		System.out.println("Level order print");
		sampleTree.printTreeLevelOrder();

		System.out.println("level 12: " + sampleTree.findLevel(root, 12, 1));

		sampleTree.delete(3);
		System.out.println("Level order print after deleting 3");
		sampleTree.printTreeLevelOrder();
		
//		TreeNode deepestNode = sampleTree.findDeepest();
//		System.out.println("Deepest Node: " +deepestNode.val);
//
//		TreeNode parentOfDeepestNode = sampleTree.findParent(deepestNode, root);
//		System.out.println("Parent of deepest Node: " +parentOfDeepestNode.val);

		
	}

	public SampleBinrayTree() {
		root = null;
	}

	//Algorithm 1) find deepest breadth wise 2) then replace the current node with deepest 3) find parent of deepest 4) make (child left or right) of parent as null
	private void delete(int num) {

		Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
		nodeQueue.add(root);

		TreeNode nodeTobeDeleted = null;
		TreeNode deepestNode = findDeepest();
		TreeNode parentOfDeepestNode = findParent(deepestNode, root);

		while (!nodeQueue.isEmpty()) {
			TreeNode current = nodeQueue.peek();
			if (current.val == num) {
				nodeTobeDeleted = current;
				break;
			} else {
				if (current.left != null) {
					nodeQueue.add(current.left);
				}
				if (current.right != null) {
					nodeQueue.add(current.right);
				}
				nodeQueue.poll();
			}
		}

		if (nodeTobeDeleted != null) {
			nodeTobeDeleted.val = deepestNode.val;
			if(parentOfDeepestNode.left !=null && parentOfDeepestNode.left.val == deepestNode.val) {
				parentOfDeepestNode.left = null;
			} else if(parentOfDeepestNode.right !=null && parentOfDeepestNode.right.val == deepestNode.val) {
				parentOfDeepestNode.right = null;
			}
			
		}
	}
	
	
	
	private TreeNode findParent(TreeNode node, TreeNode current) {		
		TreeNode parent = null;
		if(current!= null) {
			
			if(current.left == null && current.right == null ) {
				
			} else if (current.right == null && current.left.val == node.val){
				parent = current;				
			} else if (current.left == null && current.right.val == node.val) {
				parent = current;	
			} else if(current.left.val == node.val || current.right.val == node.val) {
				parent = current;
			} else {
				parent = findParent(node,current.left);
				if(parent == null) {           // if we are not able to find the parent in left sub tree, find in right sub tree
					parent = findParent(node,current.right);
				}
			}
		}

		return parent;
	}

	private TreeNode findDeepest() {
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

	private void insert(int num) {

		if (root == null) {
			root = new TreeNode(num);
		} else {
			Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
			nodeQueue.add(root);
			insert(nodeQueue, num);
		}

	}

	//inserting breadth wise
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
			if (current != null) {
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

	private int findLevel(TreeNode current, int x, int level) {

		if (current == null) {
			return -1;
		}

		if (current.val == x) {
			return level;
		}
		int l = findLevel(current.left, x, level + 1);

		if (l != -1) {
			return l;
		}
		return findLevel(current.right, x, level + 1);

	}

}
