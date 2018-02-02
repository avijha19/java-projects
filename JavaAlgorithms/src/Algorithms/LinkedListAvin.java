package Algorithms;


public class LinkedListAvin {

	public static void main(String args[]) {
		LinkedListLocal ll = new LinkedListLocal();
		ll.insertFront(21);
		ll.insertFront(25);
		ll.insertFront(90);
		ll.insertFront(78);

		ll.printFirstNode();
		ll.printNode();
		ll.getSize();
		System.out.println("size" + ll.getSize());
		ll.deleteNode(78);
		System.out.println("After Deleting: ");
		ll.printNode();
	}

}

class LinkedListLocal {

	private Node top;
	private int size;

	public LinkedListLocal() {
		top = null;
	}

	public Node getTop() {
		return top;
	}

	public void setTop(Node top) {
		this.top = top;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void insertFront(int data) {

		top = new Node(data, top);
		size++;
	}

	public void printNode() {
		Node curr = top;
		// int result;

		System.out.print("All nodes: ");

		while (curr != null) {
			System.out.print(curr.getData() + ",");
			curr = curr.getNext();
		}
	}

	public void deleteNode(int data) {
		Node curr = top;
		Node prev = null;

		// int result;

		while (curr != null) {
			//System.out.print(curr.getData() + " ");

			if (top.getData() == data) {
				top = top.getNext();
				return;
			} 
			
			else {
				if (curr.getData() == data) {
					prev.setNext(curr.getNext());
					break;
				} else {
					prev = curr;
					curr = curr.getNext();
				}
			}

		}
	}

	public void printFirstNode() {

		System.out.print("FirstNode: " + top.getData() + " ");
	}
}

class Node {

	int data;
	Node next;

	public Node(int data, Node next) {
		this.data = data;
		this.next = next;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

}
