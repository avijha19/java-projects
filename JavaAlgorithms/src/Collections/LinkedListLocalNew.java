package Collections;

public class LinkedListLocalNew {

	public static void main (String[] args){
		
		LinkedListDefAvin ll = new LinkedListDefAvin();
		ll.addFrontLinkedListDef(23);
		ll.addFrontLinkedListDef(25);
		ll.addFrontLinkedListDef(27);
		ll.printNodes();
	}
}	

	 class LinkedListDefAvin {
		NodeLocal top;
		
		public LinkedListDefAvin() {
			top = null;
		}
		
		public void addFrontLinkedListDef(int data){
			top =new NodeLocal(data,top);		
		}
		
		public void printNodes(){
			NodeLocal curr = top;
			System.out.println("All Nodes:");
			while(curr !=null){
				System.out.println( curr.getData() + ",");
				curr=curr.getNext();
			}
		}
	}

	 class NodeLocal {
		int data;
		NodeLocal next;

		public NodeLocal(int data, NodeLocal next) {
			this.data = data;
			this.next = next;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public NodeLocal getNext() {
			return next;
		}

		public void setNext(NodeLocal next) {
			this.next = next;
		}

	}


