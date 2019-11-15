package BasicDataStructure;

import java.util.LinkedList;
import java.util.Queue;

// delete, insert, search, level order print, in order print
public class SampleBinarySearchTree {

	TreeNode root;
	int size;

	public static void main(String[] args) {

		SampleBinarySearchTree demoTree = new SampleBinarySearchTree();

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


		demoTree.printTreeInorder();
		
		TreeNode searchNode = demoTree.search(25);
        System.out.println("Node Value: " + searchNode.val);
        
		demoTree.delete(25);
        System.out.println("After Deleting");

		demoTree.printTreeInorder();
	}

	public SampleBinarySearchTree() {
		root = null;
		size = 0;
	}

	public void insert(int val) {

		if (null == root) {
			root = new TreeNode(val);
		} else {
			root = insert(val, root);
		}

	}

	public void delete(int val) {

		deleteRecursive(root, val);

	}
	
	
	private TreeNode deleteRecursive(TreeNode currentNode, int val) {

		if(currentNode.val > val) {
			currentNode.left = deleteRecursive(currentNode.left, val);

		}else if(currentNode.val < val) {
			currentNode.right = deleteRecursive(currentNode.right, val);

		} else {
			if(currentNode.left == null && currentNode.right == null) {
				currentNode = null;
			} else if (currentNode.left == null && currentNode.right != null) {
				currentNode  = currentNode.right;
			}  else if (currentNode.left != null && currentNode.right == null) {
				currentNode  = currentNode.left;
			} else {
				int min = findMin (currentNode.right);
				currentNode.val = min;
				deleteRecursive (currentNode.right, val);
			}
		}
		
		return currentNode;
		
	}

	private int findMin(TreeNode current) {
		int min = 0;
		if(current.left != null) {
			findMin(current.left);
		} else {
			min = current.val;
		}
		
		return min;
	}

	public TreeNode search(int val) {
		if (val==root.val) {
			return root;
		}else {
			return search(val, root);

		}
	}
	
	public TreeNode search(int val, TreeNode node) {
		TreeNode nodeToReturn;
		if (val==node.val) {
			nodeToReturn =  node;
		}else {
			if(val>node.val) {
				nodeToReturn = search(val,node.right);
			} else {
				nodeToReturn = search(val, node.left);

			}
		}

		return nodeToReturn;
	}
	
	public void printTreeInorder() {

		printTreeInorderRecursive(root);

	}

	public void printTreeInorderRecursive(TreeNode node) {

		if (null == node) {
			return;
		} else {
			System.out.println(node.val);
			printTreeInorderRecursive(node.left);
			printTreeInorderRecursive(node.right);

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
	
	
	private void printTreeLevelOrder( Queue<TreeNode> nodeQueue) {
		
		while (!nodeQueue.isEmpty()) {
			TreeNode current = nodeQueue.peek();
			if(current.left != null) {
				nodeQueue.add(current.left);
			}
			if(	current.right != null) {
				nodeQueue.add(current.right);
			}
			System.out.println("" + nodeQueue.poll().val);

		}
	}

}
