package LeetCode.LinkedLists;

//https://leetcode.com/problems/delete-node-in-a-linked-list/
//Example 1:
//
//Input: head = [4,5,1,9], node = 5
//Output: [4,1,9]
//Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your function.
//Example 2:
//
//Input: head = [4,5,1,9], node = 1
//Output: [4,5,9]
//Explanation: You are given the third node with value 1, the linked list should become 4 -> 5 -> 9 after calling your function.
public class DeleteNodeLinkedList {

	public static void main(String[] args) {
		ListNode head = convertToHeadListNode(123456789);
		System.out.println("BeforeDelting: " + convertToNumber(head));
		ListNode nodeToDelete = head.next.next.next; // 4 (third from head)
		System.out.println("Node to be deleted: " + nodeToDelete.val);
//		deleteNode(head, nodeToDelete);
//		System.out.println("AfterDelting: " + convertToNumber(head));
		
		deleteNode( nodeToDelete); // 4 (third from head)
		System.out.println("AfterDelting: " + convertToNumber(head));
		
//		BeforeDelting: 123456789
//		AfterDelting: 12356789
		
	}
	
	//actually we are deleting 5 here and converting the 4 node value as 5
	public static void deleteNode(ListNode node) {
	    node.val = node.next.val;
	    node.next = node.next.next;
	}
	
	
    public static void deleteNode(ListNode head, ListNode nodeToDelete) {
    	ListNode current = null;
    	ListNode prev = null;
    	if(head.val == nodeToDelete.val) {
    		head = head.next;
    		return;
    	} else {
    		current = head.next;
    		prev = head;
    		while(current!=null) {
    			if (current.val == nodeToDelete.val) {
    				prev.next = current.next;
    				return;
    			} else {
    				current = current.next;
    				prev = prev.next;
    			}
        	}
    	}
        
    }
    
    
  //convert 708 to 7>0>8
	  private static ListNode convertToHeadListNode(int num) {
			
		    ListNode temp  = null;
			ListNode retListNode = null;
			int digit;
			if(num==0) {
				retListNode = new ListNode(0);
			}
			 while (num > 0) {
				digit = num % 10; // here first digit = 8
				num = num / 10;
				temp = retListNode;
				retListNode = new ListNode(digit);
				retListNode.next = temp;
			}
			 
			 return retListNode;
			
		}
	  
	// convert 7> 0> 8 to 708
		  private static int convertToNumber(ListNode in) {
				
				ListNode originalIn = in;
				int i =-1;
				//first calculate the size
				while (null!= in) {
					in = in.next;
					i++;
				}
				
				int num =0;
				while (originalIn != null) {
					num = (int) (originalIn.val * Math.pow(10, i) + num); // 200 + 40 + 3
					originalIn = originalIn.next;
					i--;
				}
				
				return num;

		}

}
