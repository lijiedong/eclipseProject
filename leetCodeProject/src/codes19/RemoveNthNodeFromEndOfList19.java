package codes19;

//该算法实现的目标是删除链表的倒数第k个节点
/**
 * 这道题就是利用双链表，我本来以为很简单，但是我花了接近半小时也没有写出来
 * 原因是我总是处理不好边界值，因为它有可能删除的是头节点，也有可能两个节点的时候，删除头节点或者末尾节点
 * 我一直用一个指针来判断，所以总也判断不出来，后来看了网上的解释才明白，
 * 典型的利用双指针法解题。首先让指针first指向头节点，然后让其向后移动n步，接着让指针sec指向头结点，并和first一起向后移动。
 * 当first的next指针为NULL时，sec即指向了要删除节点的前一个节点，接着让first指向的next指针指向要删除节点的下一个节点即可。
 * 注意如果要删除的节点是首节点，那么first向后移动结束时会为NULL，这样加一个判断其是否为NULL的条件，若为NULL则返回头结点的next指针
 * 这个注意我确实想错了，我没有考虑到要通过first指针是否为空来判断要删除的是不是头节点。
 */
public class RemoveNthNodeFromEndOfList19 {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode p = head, q = head;
		for (int i = 0; i < n; i++) {
			p = p.next;
		}
		if (p == null) {// 这个时候说明删除的是头节点
			return head.next;
		}
		while (p.next != null) {
			q = q.next;
			p = p.next;
		}

		q.next = q.next.next;

		return head;

	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}