package addTwoNumbers;

public class AddTwoNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ListNode lnode = new ListNode(-1);
		// ListNode p = lnode;
		// for (int i = 0; i < 3; i++) {
		// ListNode q = new ListNode(i);
		// p.addNode(q);
		// p = q;
		// }
		// p = lnode;
		// while (p != null) {
		// System.out.println(p.val);
		// p = p.next;
		// }
		// 下面的代码是构造要进行计算的列表
		ListNode l1 = new ListNode(2);
		ListNode p = l1;
		ListNode l2 = new ListNode(4);
		p.addNode(l2);
		p = l2;
		ListNode l3 = new ListNode(3);
		p.addNode(l3);
		p = l1;

		ListNode q1 = new ListNode(5);
		p = q1;
		ListNode q2 = new ListNode(6);
		p.addNode(q2);
		p = q2;
		ListNode q3 = new ListNode(4);
		p.addNode(q3);
		p = q1;
		p = addTwoNumbers(l1, q1);
		while (p != null) {
			System.out.println(p.val);
			p = p.next;

		}

	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int la = 0, lb = 0;// 用来统计两个链表的长度
		ListNode p = l1;
		while (p != null) {
			la++;
			p = p.next;
		}
		p = l2;
		while (p != null) {
			lb++;
			p = p.next;
		}
		ListNode min, max;
		if (la < lb) {
			min = l1;
			max = l2;
		} else {
			min = l2;
			max = l1;
		}
		// 进行计算，先计算两条链表都不为空的部分
		int flag = 0;// 用来存储低位相加的进位
		// 同时用未插法新建一个链表
		ListNode q = new ListNode(0);
		ListNode h;
		h = q;
		while (min != null) {
			int sum = 0;
			sum = min.val + max.val + flag;
			flag = 0;// 将进位重新置0
			if (sum >= 10) {
				flag = 1;
				sum = sum % 10;
			}
			ListNode temp = new ListNode(sum);
			h.next = temp;
			h = temp;
			min = min.next;
			max = max.next;
		}
		// 接下来计算max链表的剩余部分
		while (max != null) {
			int sum = 0;
			sum = flag + max.val;
			flag = 0;// 将进位重新置0
			if (sum >= 10) {
				flag = 1;
				sum = sum % 10;
			}
			ListNode temp = new ListNode(sum);
			h.next = temp;
			h = temp;
			max = max.next;
		}
		// max链表的最后一位如果大于10
		if (flag == 1) {
			ListNode temp = new ListNode(1);
			h.next = temp;
			h = temp;
		}
		h.next = null;
		return q.next;
	}

}
