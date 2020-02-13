package LeetCode.LinkedLists;

//https://leetcode.com/problems/add-two-numbers/
//Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
// 342
//+ 465
//------
//  807
//7->0->8
//Output: 7 -> 0 -> 8
//Explanation: 342 + 465 = 807.

public class AddTwoNumbers {

	public static void main(String[] args) {

		ListNode l13 = new ListNode(3, null);
		ListNode l12 = new ListNode(4, l13);
		ListNode l11 = new ListNode(2, l12);

		ListNode l23 = new ListNode(4, null);
		ListNode l22 = new ListNode(6, l23);
		ListNode l21 = new ListNode(5, l22);

//		ListNode l13 = new ListNode(3, null);
//		ListNode l12 = new ListNode(4, l13);
//		ListNode l11 = new ListNode(2, l12);
//
//		ListNode l23 = new ListNode(4, null);
//		ListNode l22 = new ListNode(6, l23);
//		ListNode l21 = new ListNode(5, l22);

//		ListNode l13 = new ListNode(3);
//		l13.next = null;
//		ListNode l12 = new ListNode(4);
//		l12.next = l13;
//		ListNode l11 = new ListNode(2);
//		l11.next = l12;
//
//		ListNode l23 = new ListNode(4);
//		l23.next = null;
//		ListNode l22 = new ListNode(6);
//		l22.next = l23;
//		ListNode l21 = new ListNode(5);
//		l21.next = l22;
		
		
//		ListNode l11 = new ListNode(5);
//		l11.next = null;
//		
//		ListNode l21 = new ListNode(5);
//		l21.next = null;

		//leetcode Avinash
//		ListNode ls3 = addTwoNumbers(l11, l21);
//		System.out.println("Sum Node: " + ls3.val);

//		// LeetCode recursive
		ListNode ls3 = addTwoNumbers2(l11, l21);
		System.out.println("Sum Node 2: " + ls3.val);
//		
//		//leetCode2 iterative
//		ls3 = addTwoNumbers3(l11, l21);
//		System.out.println("Sum Node 2: " + ls3.val);

	}

	// LeetCode recursive
	public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {

		ListNode resList = new ListNode(0);
		ListNode head = resList;
		int carry = 0;
		int sum = l1.val + l2.val + carry;
		carry = sum / 10;
		resList.next = new ListNode(sum % 10);
		resList = resList.next;

		if (l1.next != null && l2.next != null)
			addTwoNumbers2(l1.next, l2.next);
		else if (l1.next != null)
			addTwoNumbers2(l1.next, new ListNode(0));
		else if (l2.next != null)
			addTwoNumbers2(new ListNode(0), l2.next);
		else if (carry > 0) {
			resList.next = new ListNode(1);
			resList = resList.next;
		}
		return head.next;
	}
	
	//leetCode2 iterative

	public static ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null) {
			throw new IllegalArgumentException("Can't add two null numbers");
		}

		ListNode d1 = l1;
		ListNode d2 = l2;
		ListNode rh = null;
		ListNode rp = null;
		int carry = 0;

		while (d1 != null || d2 != null) {
			int current = carry;

			if (d1 != null) {
				current += d1.val;
				d1 = d1.next;
			}

			if (d2 != null) {
				current += d2.val;
				d2 = d2.next;
			}

			carry = current / 10;
			current = current % 10;

			ListNode nextVal = new ListNode(current);

			if (rp == null) {
				rh = nextVal;
				rp = nextVal;
			} else {
				rp.next = nextVal;
				rp = nextVal;
			}
		}

		if (carry > 0) {
			ListNode nextVal = new ListNode(carry);
			rp.next = nextVal;
			rp = nextVal;
		}
		return rh;
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
			digit = num % 10;// first digit is 8
			num = num / 10; // number converted to 70
			temp = retListNode;
			retListNode = new ListNode(digit);// first node created 8, then 0 and then 7, so 7 is head node
			retListNode.next = temp;
		}
		 
		 return retListNode;
		
	}
	
	// convert 708 to 8>0>7 // 243 to 3>4>2
    private static ListNode convertToReverseHeadListNode(int num) {
		
		ListNode temp  = null;
		ListNode retListNode = null;
		int digit;
		if(num==0) {
			retListNode = new ListNode(0);
		} else {
			int i = (int)Math.floor(Math.log10(num) + 1) -1;
			 while (i >= 0) {
				digit = (int) (num / (Math.pow(10, i))); // here first digit = 2
				num = (int) (num % (Math.pow(10, i))); // number 24
				temp = retListNode;
				retListNode = new ListNode(digit);
				retListNode.next = temp;
				i --;
			}
		}
		
		 
		 return retListNode;
		
	}
	
	// convert 2>4>3 to 342
	private static int convertToReverseNumber(ListNode in) {
		int num = in.val;
		ListNode currentL1 = null;
		if(null!=in.next) {
			 currentL1 = in.next;
		}
		double i = 1;

		while (currentL1 != null) {
			num = (int) (currentL1.val * Math.pow(10, i) + num); // 2 + 40 + 300
			currentL1 = currentL1.next;
			i++;
		}
		
		return num;

	}
	
	// convert 2>4>3 to 243
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
	
	private static int reverse(int num) {
		
		int reverse = 0;
		long reverseLong = 0;
		int digit = 0;

		while ( num!= 0) {
			digit = num % 10;
			num = num / 10;
			reverseLong = reverseLong * 10 + digit;
		}
		
		if (reverseLong > Integer.MAX_VALUE && reverseLong < Integer.MIN_VALUE) {
			reverse = 0;
		} else {
			reverse = (int) reverseLong;
		}
		
		return reverse;
	}


	// Avinash Solution
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		int first = convertToReverseNumber(l1);
		int second = convertToReverseNumber(l2);

		System.out.println("first: " + first);

		System.out.println("second: " + second);

		Integer sum = reverse(first + second);

		//ListNode ls3 = convertToHeadListNode(sum);
		
		ListNode ls3 = convertToHeadListNode(708);

		
		//ls3 = convertToReverseHeadListNode(first + second);
		ls3 = convertToReverseHeadListNode(708);


		int sum2 = convertToReverseNumber(ls3);
		 sum2 = convertToNumber(ls3);


		System.out.println("number: Final " + sum2);

		return ls3;
	}

}

//class ListNode {
//
//	int val;
//	ListNode next;
//
//	public ListNode(int inData) {
//		this.val = inData;
//	}
//
//	public ListNode(int inData, ListNode inNext) {
//		this.val = inData;
//		this.next = inNext;
//	}
//
//	public int getVal() {
//		return val;
//	}
//
//	public void setVal(int data) {
//		this.val = data;
//	}
//
//	public ListNode getNext() {
//		return next;
//	}
//
//	public void setNext(ListNode next) {
//		this.next = next;
//	}

//}
