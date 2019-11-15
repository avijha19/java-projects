package LeetCode.LinkedLists;
//https://leetcode.com/problems/odd-even-linked-list/
//Example 1:

//Input: 1->2->3->4->5->NULL
//Output: 1->3->5->2->4->NULL
//Example 2:
//
//Input: 2->1->3->5->6->4->7->NULL
//Output: 2->3->6->7->1->5->4->NULL


public class OddEvenLinkedLists {

	public static void main(String[] args) {
		ListNode head = convertToHeadListNode(12345678);
		//System.out.println("Odd Even: " +convertToNumber(oddEvenList(head)));
		System.out.println("Odd Even: " +convertToNumber(oddEvenList2(head)));

	}
	
	//leet code
	    public static ListNode oddEvenList2(ListNode head) {
	        if (head == null) return null;
	        ListNode odd = head, even = head.next, evenHead = even;
	        while (even != null && even.next != null) {
	            odd.next = even.next;
	            odd = odd.next;
	            even.next = odd.next;
	            even = even.next;
	        }
	        odd.next = evenHead;
	        return head;
	    }
	
	
	//Avinash Solution
    public static ListNode oddEvenList(ListNode head) {

    	ListNode odd = head;
    	ListNode newHead = new ListNode(-1);
    	ListNode prev = newHead;    	
    	ListNode evenHead =  new ListNode(-2);
    	ListNode even = evenHead;
    	
    	while (odd!=null ) {
    		prev.next = odd;
    		even.next = odd.next;
    		if(odd.next!=null) {
        		odd = odd.next.next;
        		prev=prev.next;
        		even = even.next;
    		} else {
    			break;
    			//odd = odd.next;
    		}
    	}
		System.out.println("even value: " +even.val);
		if(odd == null) {
		prev.next = evenHead.next;	
		} else {
			even.next=null;
	    	odd.next=evenHead.next;
		}
    	
		return newHead.next;
        
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
