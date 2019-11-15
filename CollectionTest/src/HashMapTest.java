import java.util.ArrayList;
import java.util.List;

public class HashMapTest {

	public static void main(String[] args) {

		HashMapTest test = new HashMapTest();
		test.put("Avinash", "Kumar");
		test.put("Sabari", "Nathan");

		System.out.println("Avinash: " + test.get("Avinash"));
		System.out.println("Sabari: " + test.get("Sabari"));

		test.put("Sabari", "Fremont");
		test.put("Avinash", "Cupertino");

		System.out.println("Avinash: " + test.get("Avinash"));
		System.out.println("Sabari: " + test.get("Sabari"));

	}

	private List<Node> nodeList;

	public HashMapTest() {
		super();
		nodeList = new ArrayList<Node>();
	}

	public void put(String key, String value) {

		if (!nodeList.isEmpty()) {

//			Iterator<Node> it = nodeList.iterator();
//			
//			while (it.hasNext()) {
//				
//				Node node =  it.next();
//				
//				if (node.getKey().equals(key)) {
//
//					//node.setValue(value);
//
//				} else {
//					Node inNode = new Node(key, value);
//					nodeList.add(inNode);
//				}
//			}
			Node node;
			boolean notAdded = true;

			for (int i = 0; i < nodeList.size(); i++) {
				node = nodeList.get(i);

				if (node.getKey().equals(key)) {
					notAdded = false;
					node.setValue(value);
					break;
				} 				
				
			}

			if (notAdded) {
				Node inNode = new Node(key, value);
				nodeList.add(inNode);
			}

		} else {
			Node inNode = new Node(key, value);
			nodeList.add(inNode);
		}

	}

	public String get(String key) {

		String value = null;
		for (Node node : nodeList) {

			if (node.getKey().equals(key)) {

				value = node.getValue();

			} else {
				// do nothing
			}
		}
		return value;
	}

	class Node {

		private String key;
		private String value;

		public Node(String key, String value) {
			super();
			this.key = key;
			this.value = value;
		}

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

	}

}
