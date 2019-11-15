package Practice;


//Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//Output: 7 -> 0 -> 8
//Explanation: 342 + 465 = 807.

public class AddTwoNumbers {

	public static void main(String[] args) {
     
		
		LNode l1=	convertFromNumber(243);
		LNode l2=	convertFromNumber(564);
		LNode sumNode = addTwoNumbers(l1,l2);
		
		System.out.println("LNode" + addTwoNumbers(l1,l2));		
     
	}
	
	
	public static LNode addTwoNumbers(LNode l1, LNode l2) {
		
		 LNode dummyHead = new LNode(0);
		 LNode p = l1, q = l2, curr = dummyHead;
		    int carry = 0;
		    while (p != null || q != null) {
		        int x = (p != null) ? p.data : 0;
		        int y = (q != null) ? q.data : 0;
		        int sum = carry + x + y;
		        carry = sum / 10;
		        curr.next = new LNode(sum % 10);
		        curr = curr.next;
		        if (p != null) p = p.next;
		        if (q != null) q = q.next;
		    }
		    if (carry > 0) {
		        curr.next = new LNode(carry);
		    }
		    return dummyHead.next;
	}

	
	  //convert 708 to 7>0>8
	
	public static LNode convertFromNumber(int num) {
		LNode head = null;
    	int noOfDigits = (int) Math.floor(Math.log10(num)) + 1;
		noOfDigits --;
		int digit = (int) (num/Math.pow(10, (noOfDigits)));
		head = new LNode(digit);
		num = (int) (num%(Math.pow(10, (noOfDigits))));
		noOfDigits --;
		LNode tempNode = null;
		LNode digitNode = head;

		
		while(noOfDigits >= 0) {
			digit = (int) (num/Math.pow(10, noOfDigits)); // here first digit is 7
			tempNode =  new LNode(digit);
			digitNode.next = tempNode;
			digitNode =  digitNode.next;
			num = (int) (num%(Math.pow(10, noOfDigits)));
			noOfDigits --;
		}
		
		return head;
	}
	
	  //convert 708 to 7>0>8
	  private static LNode convertToHeadListNode(int num) {
			
			LNode temp  = null;
			LNode retListNode = null;
			int digit;
			if(num==0) {
				retListNode = new LNode(0);
			}
			 while (num > 0) {
				digit = num % 10; // here first digit = 8
				num = num / 10;
				temp = retListNode;
				retListNode = new LNode(digit);
				retListNode.next = temp;
			}
			 
			 return retListNode;
			
		}
	
	
	public int convertFromHeadNode(LNode head) {
		int num = 0;
		
		
		
		
		return num;
	}
	
	
	
	
	

}

class LNode {
	
	int data;
	LNode next;
	
	public LNode( int data) {
		this.data = data;
	}
	
}
