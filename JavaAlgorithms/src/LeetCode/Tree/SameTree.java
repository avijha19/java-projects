package LeetCode.Tree;


//https://leetcode.com/problems/same-tree

public class SameTree {

	static TreeNode root1;
	static TreeNode root2;

	

	
	public static void main(String[] args) {
		root1 = new TreeNode(1);
		root1.left = new TreeNode(2);
		root1.right = new TreeNode(3);
		root1.right.left = new TreeNode(5);

		
		root2 = new TreeNode(1);
		root2.left = new TreeNode(2);
		root2.right = new TreeNode(3);
		boolean isSameTree = isSameTree(root1, root2);
		
		System.out.println("Is Same tree: " + isSameTree);
		
		
		
	}
	
	private static boolean isSameTree (TreeNode p, TreeNode q) {
		boolean isSameTree = true;
		
		if (null == p && null == q) {
			return true;
		} 
		
		if(null == p) {
			return false;
		}
		
		if(null == q) {
			return false;
		}
		
		if(p.val == q.val) {
			isSameTree = isSameTree ( p.left,  q.left);
		} else {
			return false;
		}
		
		if(isSameTree) {
			isSameTree = isSameTree ( p.right,  q.right);
		}
		
		return isSameTree;
		
	}

}
