package binaryTree;

import java.util.Stack;

import org.junit.Test;

public class BinaryTree {
	int[] arr = { 1, 2, 3, 4, 5, 0, 0, 0, 0, 6, 7 };
	int index = 0;

	@Test
	public void test() {
		TreeNode root = null;
		root = CreateTree(arr, 0);
		/*
		 * System.out.println("先序非递归遍历"); preOrderUnRecur(root);
		 * System.out.println(); System.out.println("先序递归遍历");
		 * preOrderRecur(root);
		 */

		System.out.println("中序遍历");
		inOrderRecur(root);
		System.out.println();
		System.out.println("中序非递归遍历");
		inOrderUnRecur(root);
		/*
		 * System.out.println("后序遍历"); posOrderRecur(root);
		 * System.out.println(); System.out.println("后序非递归遍历");
		 * posOrderUnRecur(root);
		 */

	}

	// 创建树
	public TreeNode CreateTree(int[] arr, int index) {
		TreeNode node = null;

		if (index < arr.length && arr[index] != 0) {
			node = new TreeNode(arr[index]);
			node.setLeft(CreateTree(arr, 2 * index + 1));
			node.setRight(CreateTree(arr, 2 * index + 2));
		}

		return node;
	}

	// 创建树
	public TreeNode CreateTree1() {
		if (index == arr.length) {
			return null;
		}
		int data = arr[index];
		System.out.println("index:" + index + "data:" + data);
		index++;
		if (data == 0) {
			return null;
		} else {
			TreeNode node = new TreeNode(data);
			node.setLeft(CreateTree1());
			node.setRight(CreateTree1());
			return node;
		}

	}

	// 先序遍历树的递归算法
	public static void preOrderRecur(TreeNode head) {
		if (head == null) {
			return;
		}
		System.out.print(head.val + "  ");
		preOrderRecur(head.left);
		preOrderRecur(head.right);
	}

	// 中序遍历树的递归算法
	public static void inOrderRecur(TreeNode head) {
		/*
		 * if (head == null) { return; }
		 */
		if (head.left != null) {
			inOrderRecur(head.left);
		}

		System.out.print(head.val + "  ");
		if (head.right != null) {
			inOrderRecur(head.right);
		}

	}

	// 后序遍历树的递归算法
	public static void posOrderRecur(TreeNode head) {
		if (head == null) {
			return;
		}
		posOrderRecur(head.left);
		posOrderRecur(head.right);
		System.out.print(head.val + "  ");
	}

	// 先序遍历的非递归算法
	public void preOrderUnRecur(TreeNode head) {
		if (head != null) {
			Stack<TreeNode> stack = new Stack<TreeNode>();
			stack.add(head);
			while (!stack.isEmpty()) {
				head = stack.pop();
				System.out.print(head.val + "  ");
				if (head.right != null) {
					stack.push(head.right);
				}
				if (head.left != null) {
					stack.push(head.left);
				}
			}
		}
	}

	// 中序遍历的非递归算法
	public void inOrderUnRecur(TreeNode head) {
		if (head != null) {
			Stack<TreeNode> stack = new Stack<TreeNode>();
			while (!stack.isEmpty() || head != null) {
				if (head != null) {
					stack.push(head);
					head = head.left;
				} else {
					head = stack.pop();
					System.out.print(head.val + "  ");
					head = head.right;
				}
			}
		}
	}

	// 后序遍历的非递归算法
	public void posOrderUnRecur(TreeNode head) {
		if (head != null) {
			Stack<TreeNode> s1 = new Stack<TreeNode>();
			Stack<TreeNode> s2 = new Stack<TreeNode>();
			s1.push(head);
			while (!s1.isEmpty()) {
				head = s1.pop();
				s2.push(head);
				if (head.left != null) {
					s1.push(head.left);
				}
				if (head.right != null) {
					s1.push(head.right);
				}
			}
			while (!s2.isEmpty()) {
				System.out.print(s2.pop().val + "  ");
			}
		}
	}
}
