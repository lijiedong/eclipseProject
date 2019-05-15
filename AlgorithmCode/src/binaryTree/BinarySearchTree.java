package binaryTree;

import org.junit.Test;

/*该文件实现的是二叉搜索树的基本操作*/
public class BinarySearchTree {
	@Test
	public void test() {
		int[] arr = { 2, 3, 6, 5, 5, 1, 7, 8 };
		TreeNode root = new TreeNode(4);
		for (int i = 0; i < arr.length; i++) {
			insert(arr[i], root);
		}
		BinaryTree.preOrderRecur(root);
		System.out.println();
		System.out.println(findMax(root).getVal());
		/*
		 * root = delete(root, 4); BinaryTree.preOrderRecur(root);
		 */
	}

	/*
	 * 二叉搜索树的插入 插入的时候如果节点为空，则生成一个新的节点，并将连接指向它 如果被插入的值小于根节点的值，则继续在左子树中插入
	 * 否则继续在右子树中插入
	 */

	public TreeNode insert(int x, TreeNode T) {
		if (T == null) {
			T = new TreeNode(x);
			T.left = null;
			T.right = null;
		} else {
			if (x < T.getVal()) {
				T.left = insert(x, T.left);
			} else if (x > T.getVal()) {
				T.right = insert(x, T.right);
			}
		}
		return T;
	}

	/*
	 * 删除二叉搜索树中的最小值 因为最小值肯定是在左子树里， 直到遇到一个空指针， 然后将指向该指针的连接指向该指针的右指针
	 */
	public TreeNode deleteMin(TreeNode root) {
		if (root.left == null) {
			return root.right;
		}
		root.left = deleteMin(root.left);
		return root;
	}

	/*
	 * 删除二叉搜索树的最大值 最大值在右子树里，所以一直往右子树走，直到遇到空连接，如果该节点的左子树不为空，则返回左子树， 如果为空则直接返回空
	 * 或者也可以直接返回左子树
	 */
	public TreeNode deleteMax(TreeNode root) {
		if (root.right == null) {
			return root.left;
		}
		root.right = deleteMax(root.right);
		return root;
	}

	// 查找二叉搜索树中的最小值节点,一直往左子树中找
	public TreeNode findMin(TreeNode node) {
		if (node == null) {
			return null;
		} else {
			if (node.left == null) {
				return node;
			} else {
				return findMin(node.left);
			}
		}
	}

	// 查找二叉搜索树中的最小值节点，一直往右子树中找
	public TreeNode findMax(TreeNode node) {
		if (node == null) {
			return null;
		} else {
			if (node.right == null) {
				return node;
			} else {
				return findMax(node.right);
			}
		}
	}

	// 删除任意一个节点
	public TreeNode delete(TreeNode node, int x) {
		if (node == null) {
			System.out.println("There is no such node!");
			return null;
		} else {
			if (x < node.getVal()) {// 当要删除节点小于当前节点的值，向左子树中，进行寻找
				node.left = delete(node.left, x);
			} else if (x > node.getVal()) {// 当要删除节点大于当前节点的值，向左子树中，进行寻找
				node.right = delete(node.right, x);
			} else { // 当要删除节点等于当前节点的值的时候，进行删除
				// 当左子树和右子树都不为空的时候
				if (node.left != null && node.right != null) {

					/*
					 * TreeNode temp = node; node = findMin(temp.right); //
					 * 找到要删除节点右子树的最小节点 node.right = deleteMin(temp.right);
					 * node.left = temp.left;
					 */

					TreeNode temp = findMin(node.right);
					node.setVal(temp.getVal());
					node.right = delete(node.right, temp.getVal());

				} else {
					if (node.left == null) {
						return node.right; // 如果左子树为空，那么直接将右子树返回
					}
					if (node.right == null) {
						return node.left; // 如果右子树为空，那么直接将左子树返回
					}

				}

			}
		}
		return node;
	}
}
