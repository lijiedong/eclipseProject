package niuke;

import org.junit.Test;

/**
 * 将二叉搜索树转换为一个排序的双向链表
 *
 */
public class BinarySearchAndLinkedList {
	int[] arr = { 10, 6, 14, 4, 8, 12, 16 };
	int index = 0;

	@Test
	public void test() {
		TreeNode root = null;
		root = CreateTree(arr, 0);
		TreeNode node = Convert(root);
		while (node != null) {
			System.out.print(node.val + "--");
			node = node.right;
		}
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

	public TreeNode Convert(TreeNode pRootOfTree) {
		TreeNode last = null;
		ConvertTree(pRootOfTree, last);
		while (last != null && last.left != null)
			last = last.left;
		return last;
	}

	public void ConvertTree(TreeNode root, TreeNode last) {
		if (root == null) {
			return;
		}

		// 转换左子树
		ConvertTree(root.left, last);
		root.left = last;
		if (last != null) {
			last.right = root;
		}
		last = root;
		ConvertTree(root.right, last);
	}
}
