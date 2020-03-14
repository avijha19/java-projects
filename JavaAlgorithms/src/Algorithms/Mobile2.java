package Algorithms;

import LeetCode.Tree.TreeNode;

//question asked in Mobile EDGe
public class Mobile2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	class Solution {
	    int count;
	    public int solution(TreeNode T) {
	        
	        if (T ==  null){
	         return 0;   
	        }


	        dfs(T,T.val);
	        return count;
	    }
	    
	    void dfs(TreeNode current, int max){
	        
	        if(current == null) {
	            return;
	        }
	        if(current.val >= max) {
	            count++;
	            max = current.val;
	        }
	        dfs(current.left, max);
	        dfs(current.right, max);
	    }
	}

}
