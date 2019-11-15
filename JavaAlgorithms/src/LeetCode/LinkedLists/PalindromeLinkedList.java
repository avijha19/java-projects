package LeetCode.LinkedLists;

//https://leetcode.com/problems/palindrome-linked-list/

//Given a singly linked list, determine if it is a palindrome.
//
//Example 1:
//
//Input: 1->2
//Output: false
//Example 2:
//
//Input: 1->2->2->1
//Output: true

//Follow up:
//Could you do it in O(n) time and O(1) space?

public class PalindromeLinkedList {

	public static void main(String[] args) {
		
		ListNode head = convertToHeadListNode(1232112);
		System.out.println("Print " + convertToNumber(head));
		System.out.println("Is LinkedListPalindrome: " +isPalindrome(head));

	}

	public static boolean isPalindrome(ListNode head) {
		boolean isPalindrome = true;
		
		ListNode reverseHead = null;
		ListNode temp = null;
		ListNode currentHead = head;

		if(currentHead == null ) {
			isPalindrome = true;
		} else if(currentHead.next == null) {
			isPalindrome = true;
		 }else {
			while (currentHead !=null) {
				temp = reverseHead;
				reverseHead = new ListNode(currentHead.val); // first make head as first element of new linked list;
				reverseHead.next = temp;
				currentHead =  currentHead.next;
			}
			
			while(head!=null && reverseHead!=null && head.next!=null && reverseHead.next!=null) {
				if(head.val!=reverseHead.val) {
					isPalindrome = false;
					return isPalindrome;
				} else {
					head = head.next;
					reverseHead = reverseHead.next;
				}
			}
		}
		
		
        
		return isPalindrome;

    
		
		
		
		
		
//		ListNode start = head;
//		ListNode end = head.next;
//		ListNode prevEnd = head;


//		if(end.next == null) {
//			if(start.val!= end.val)
//				isPalindrome = false;
//		} else {
//			while (end.next !=null) {
//				prevEnd = end;
//				end = end.next;
//				if(start.val!= end.val) {
//					isPalindrome = false;
//				} else {
//					end = prevEnd;
//					start = start.next;
//				}
//				
//			}
//		}
		
		

//		return isPalindrome;

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
