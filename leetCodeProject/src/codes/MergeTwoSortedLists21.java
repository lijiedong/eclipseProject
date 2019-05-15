package codes;

import org.junit.Test;

public class MergeTwoSortedLists21 {
	@Test
	public void test() {
		int[] arr1 = { 1, 2, 4 };
		int[] arr2 = { 1, 3, 4 };
		ListNode l1 = new ListNode(0);
		ListNode l2 = new ListNode(0);
		ListNode h1, h2;
		h1 = l1;
		h2 = l2;
		for (int i = 0; i < arr1.length; i++) {
			ListNode p = new ListNode(arr1[i]);
			ListNode q = new ListNode(arr2[i]);
			h1.next = p;
			h1 = p;
			h2.next = q;
			h2 = q;
		}
		h1.next = null;
		h2.next = null;
		ListNode temp = l1;
		while (temp != null) {
			System.out.print(temp.val + "--");
			temp = temp.next;
		}
		System.out.println();
		temp = l2;
		while (temp != null) {
			System.out.print(temp.val + "--");
			temp = temp.next;
		}
		System.out.println();
		temp = mergeTwoLists(l1.next, l2.next);
		while (temp != null) {
			System.out.print(temp.val + "--");
			temp = temp.next;
		}
	}

	/* 该算法是将两个有序的链表合并成一个有序的链表 */
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode h, p;
		h = new ListNode(0);
		p = h;
		// 当两个链表都不为空的时候
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				p.next = l1;
				p = l1;
				l1 = l1.next;
			} else {
				p.next = l2;
				p = l2;
				l2 = l2.next;
			}
		}
		ListNode q = l2;// 假设第二个链表不为空
		if (l1 != null) {
			q = l1;
		}
		while (q != null) {
			p.next = q;
			p = q;
			q = q.next;
		}
		p.next = null;
		return h.next;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}