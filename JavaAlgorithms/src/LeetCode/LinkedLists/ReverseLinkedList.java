package LeetCode.LinkedLists;

//https://leetcode.com/problems/reverse-linked-list/
//Input: 1->2->3->4->5->NULL
//Output: 5->4->3->2->1->NULL

public class ReverseLinkedList {

	public static void main(String[] args) {
		
//		ListNode head = convertToHeadListNode(5432);
//		ListNode newHead = reverseList(head);
		
		ListNode head = new ListNode(5);
		head.next = new ListNode(4);
		head.next.next = new ListNode(3);
		head.next.next = new ListNode(1);

		
		//System.out.println(" new Number: " + convertToNumber(newHead));
		 
	}
	
	public static ListNode reverseList(ListNode head) {
		
		ListNode newHead = null;
		ListNode temp = null;
		
		while (head !=null) {
			temp = newHead;
			newHead = new ListNode(head.val); // first make head as first element of new linked list;
			newHead.next = temp;
			head =  head.next;
		}
		
		return newHead;
        
        
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



