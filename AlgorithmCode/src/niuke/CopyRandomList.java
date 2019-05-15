package niuke;

public class CopyRandomList {
	public RandomListNode Clone(RandomListNode pHead) {
		cloneNodes(pHead);
		cloneRandomNodes(pHead);
		return getLists(pHead);
	}

	// 第一步首先复制原始链表的节点
	public void cloneNodes(RandomListNode head) {
		RandomListNode tempHead = head;
		while (tempHead != null) {
			RandomListNode temp = new RandomListNode(tempHead.label);
			temp.next = tempHead.next;
			temp.random = null;
			tempHead.next = temp;
			tempHead = temp.next;
		}
	}

	// 第二步复制随机节点
	public void cloneRandomNodes(RandomListNode head) {
		RandomListNode tempHead = head;
		while (tempHead != null) {
			RandomListNode temp = tempHead.next;
			if (tempHead.random != null) {
				temp.random = tempHead.random.next;
			}
			tempHead = temp.next;
		}
	}

	// 第三步得到复制后的节点
	/*
	 * RandomListNode tempHead = new RandomListNode(0);// RandomListNode temp =
	 * tempHead; // 将原来的节点和复制后的节点给分开 while (head != null) { RandomListNode q =
	 * head.next; temp.next = q; head.next = head.next.next; temp = q; }
	 */

	public RandomListNode getLists(RandomListNode head) {
		RandomListNode tempHead = head;
		RandomListNode pClonedHead = new RandomListNode(0);
		RandomListNode temp = pClonedHead;
		while (tempHead != null) {
			temp.next = tempHead.next;
			tempHead.next = temp.next;
			tempHead = tempHead.next;
			temp = temp.next;
		}

		return pClonedHead.next;
	}

	public RandomListNode getListss(RandomListNode pHead) {
		RandomListNode head = pHead;
		RandomListNode cHead = pHead.next;
		RandomListNode node = cHead;
		while (head != null) {
			head.next = node.next;
			head = head.next;
			if (head != null) {
				node.next = head.next;
				node = node.next;
			}
		}
		return cHead;
	}
}

class RandomListNode {
	int label;
	RandomListNode next = null;
	RandomListNode random = null;

	RandomListNode(int label) {
		this.label = label;
	}
}
