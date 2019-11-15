package Algorithms;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTreeDemo {

	public static void main(String[] args) {
		BinarySearchT bst =  new BinarySearchT();
		bst.insertBinary(10);
		bst.insertBinary(45);
		bst.insertBinary(12);
		bst.insertBinary(70);
		bst.insertBinary(80);
		bst.insertBinary(2);
		bst.insertBinary(6);
		bst.insertBinary(8);
		bst.insertBinary(60);
		bst.printBinaryLevelOrder();
		
		//bst.delete(45);
		System.out.println("After Deletion**********");
		bst.printBinaryLevelOrder();

	}
	
}
	
	
	 class BinarySearchT{
		
		NodeT root;
		
		public  BinarySearchT() {
			root = null;
		}
		
		
		
		public void insertBinary(int dataToInsert){
			
			if (root==null) {
				NodeT nodeToInsert= new NodeT(dataToInsert);
				root = nodeToInsert;
				return;
		    } else {
				insertNode (root,dataToInsert);
		    }
		}
		
		private void insertNode(NodeT rootNode, int dataToInsert) {
			if(dataToInsert < rootNode.getData()) {
				if(rootNode.getLeft()==null) {
					rootNode.setLeft(new NodeT(dataToInsert));
					return;
				} else {
					insertNode(rootNode.getLeft(),dataToInsert);
				}
			} else {
				if(rootNode.getRight()==null) {
					rootNode.setRight(new NodeT(dataToInsert));
					return;
				} else {
					insertNode(rootNode.getRight(),dataToInsert);
				}
			}
			
		}
		

		public void printBinary () {
			
			printBinaryRecurSive(root);
			
		}
		
		public void printBinaryLevelOrder () {
			printBinaryRecurSiveLevel(root);
			
		}
		
		public void delete (int nodeTobeDeleted) {
			
		 delete(root, nodeTobeDeleted);
			
			
		}

		private NodeT delete(NodeT currentNode, int nodeTobeDeleted) {
			NodeT nodeReturn = null;
			if(nodeTobeDeleted > currentNode.getData()) {
				currentNode.right= delete(currentNode.right , nodeTobeDeleted);
			} else if (nodeTobeDeleted < currentNode.getData()) {
				currentNode.left= delete(currentNode.left , nodeTobeDeleted);
			} else {
				
				if(currentNode.getLeft() ==  null && currentNode.getRight() ==  null) {
					nodeReturn = null;
				} else if (currentNode.getLeft() !=  null && currentNode.getRight() ==  null) {
					nodeReturn= currentNode.getLeft();
		
				} else if(currentNode.getLeft() ==  null && currentNode.getRight() !=  null) {
					nodeReturn = currentNode.getRight();
					
				}  else if(currentNode.getLeft() !=  null && currentNode.getRight() !=  null) {
					int minData = findMin( currentNode.getRight());
					currentNode.setData(minData);
					nodeReturn = delete(currentNode.getRight(),currentNode.getData());
				}
			}
			
			return nodeReturn;
			
		}



		private int findMin(NodeT currentNode) {
			int minData = currentNode.getData();
			
			if(currentNode.getLeft() != null) {
				minData = findMin(currentNode.getLeft());
			}
			
			return minData;
		}



		private void printBinaryRecurSiveLevel(NodeT node) {
		 Queue<NodeT> qu= new LinkedList<NodeT>();
			
			if(root!= null) {
				qu.add(node);
			}
			
			while (!qu.isEmpty()) {
				NodeT nodeEnQueue = qu.peek();
				
				if(nodeEnQueue.getLeft()!= null) {
					qu.add(nodeEnQueue.getLeft());
				}
				
				if(nodeEnQueue.getRight()!= null) {
					qu.add(nodeEnQueue.getRight());
				}
				
				
				NodeT nodePrint = qu.remove();
				System.out.println(", " + nodePrint.getData() +" , "  );
				
			}
		}



		private void printBinaryRecurSive(NodeT node) {

			if(node == null) {
				return;
			}else {
				System.out.println("" + node.getData());
				printBinaryRecurSive(node.getLeft());
				printBinaryRecurSive(node.getRight());
			}
		}
		
	}
	
	
	class NodeT{
		
		int data;
		NodeT left;
		NodeT right;
		
		public NodeT(int data) {
			this.data = data;
		}
		
		public int getData() {
			return data;
		}
		public void setData(int data) {
			this.data = data;
		}
		public NodeT getLeft() {
			return left;
		}
		public void setLeft(NodeT left) {
			this.left = left;
		}
		public NodeT getRight() {
			return right;
		}
		public void setRight(NodeT right) {
			this.right = right;
		}
	}
	
	


