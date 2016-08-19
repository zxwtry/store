public class B012_getSharedParts {
	public static void main(String[] args) {

	}
	/*
		在这里假定list1和list2都是不能够做任何修改的。
		这里的list1和list2都不是有序链表
		假定有非常多的共同组合，那么返回最长的一组
	*/
	static Node getSharedParts(Node list1, Node list2) {
		if (list1 == null || list2 == null)
			return null;
		int len1 = 1, len2 = 1;
		Node travel1 = list1, travel2 = list2;
		while (travel1.next != null) {
			travel1 = travel1.next;
			len1 ++;
		}
		while (travel2.next != null) {
			travel2 = travel2.next;
			len2 ++;
		}
		if (len1 < len2)
			return getSharedPartsBais(list2, list1, len2, len1);
		else
			return getSharedPartsBais(list1, list2, len1, len2);
	}
	private Node getSharedPartsBais(Node list1, Node list2, int len1, int len2) {
		
	}
	static class Node {
		int value;
		Node next;
	}
}
