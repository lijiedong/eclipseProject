package addTwoNumbers;

public class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}

	public void addNode(ListNode node) {
		this.next = node;
		node.next = null;
	}
}
