package niuke;

import org.junit.Test;

public class solution {
	@Test
	public void test() {
		ListNode head1 = null;
		ListNode head2 = null;
		head1 = createList(null, 0);
		printLinkedList(head1);

		head2 = createList(null, 1);
		printLinkedList(head2);
		ListNode p = Merge(head1, head2);
		printLinkedList(p);
	}

	public void printLinkedList(ListNode node) {
		ListNode p = node;
		while (p != null) {
			System.out.print(p.val + "--");
			p = p.next;
		}
		System.out.println();
	}

	public ListNode createList(ListNode node, int distance) {
		ListNode p, q;

		node = new ListNode(-1);
		p = node;
		for (int i = 0; i < 10; i++) {
			q = new ListNode(i + distance);
			p.next = q;
			p = q;
		}
		p.next = null;
		/*
		 * q = node; while (q != null) { System.out.print(q.val + "--"); q =
		 * q.next; }
		 */
		return node.next;
	}

	public ListNode FindKthToTail(ListNode head, int k) {

		if (head == null) {
			return null;
		}
		ListNode p = head, q = head;
		for (int i = 0; i < k; i++) {
			p = p.next;
		}
		if (p == null) {
			return head;
		}
		while (p.next != null) {
			q = q.next;
			p = p.next;
		}
		return q.next;

	}

	public ListNode Merge(ListNode list1, ListNode list2) {
		ListNode node;
		if (list1.val < list2.val) {
			node = list1;
			list1 = list1.next;
		} else {
			node = list2;
			list2 = list2.next;
		}
		ListNode head;
		head = node;
		ListNode p;
		while (list1 != null && list2 != null) {
			if (list1.val < list2.val) {
				p = list1;
				list1 = list1.next;
				node.next = p;
				node = p;
			} else {
				p = list2;
				list2 = list2.next;
				node.next = p;
				node = p;
			}
		}
		while (list1 != null) {
			p = list1;
			list1 = list1.next;
			node.next = p;
			node = p;
		}
		while (list2 != null) {
			p = list2;
			list2 = list2.next;
			node.next = p;
			node = p;
		}
		node.next = null;
		return head;
	}

}
