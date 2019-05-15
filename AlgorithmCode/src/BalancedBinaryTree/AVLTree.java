package BalancedBinaryTree;

import org.junit.Test;

/*下面代码实现了平衡二叉树的基本操作*/
public class AVLTree {
	@Test
	public void testAVL() {
		// int[] arr = { 3, 2, 1, 4, 5, 6, 7, 16, 15, 14, 13, 12, 11, 10, 8, 9
		// };
		int[] arr = { 4, 3, 6, 1, 2, 5, 7, 8 };
		TreeNode root = null;
		for (int i = 0; i < arr.length; i++) {
			root = insert(arr[i], root);

		}
		preOrderRecur(root);
		System.out.println();
		root = delete(root, 5);
		preOrderRecur(root);
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

	// 求二叉树高度的函数
	int height(TreeNode p) {
		if (p == null) {
			return -1;
		} else {
			return p.getHeight();
		}
	}

	/*
	 * Int depth(AVLBtree T) { Int ldepth,rdepth; If(T==NULL)return 0; Else{
	 * ldepth=depth(T->lchild); rdepth=depth(T->rchild); if(ldepth>rdepth)return
	 * ldepth+1; else return rdepth+1; } }
	 */
	public TreeNode insert(int x, TreeNode node) {
		if (node == null) { // 当节点为空的时候
			node = new TreeNode(x);
			node.setLeft(null);
			node.setRight(null);
			node.setHeight(0);
		} else {// 当节点不为空的时候
			if (x < node.getVal()) {
				node.left = insert(x, node.left);
				// 判断是否平衡
				if (height(node.left) - height(node.right) == 2) {
					if (x < node.left.getVal()) {
						node = singleRotateWithLeft(node);
					} else {
						node = doubleRotateWithLeft(node);
					}
				}
			} else if (x > node.getVal()) {
				node.right = insert(x, node.right);
				// 判断是否平衡
				if (height(node.right) - height(node.left) == 2) {
					if (x > node.right.getVal()) {
						node = singleRotateWithRight(node);
					} else {
						node = doubleRotateWithRight(node);
					}
				}
			}

		}
		node.height = height(node.left) > height(node.right) ? height(node.left) + 1 : height(node.right) + 1;
		return node;
	}

	// LL插入，单左旋
	public TreeNode singleRotateWithLeft(TreeNode root) {
		TreeNode k1;
		k1 = root.left;
		root.left = k1.right;
		k1.right = root;
		root.height = height(root.left) > height(root.right) ? height(root.left) + 1 : height(root.right) + 1;
		k1.height = height(k1.left) > height(k1.right) ? height(k1.left) + 1 : height(k1.right) + 1;
		return k1;
	}

	// LR插入，双左旋
	public TreeNode doubleRotateWithLeft(TreeNode root) {
		root.left = singleRotateWithRight(root.left);
		return singleRotateWithLeft(root);
	}

	// RR插入，单右旋
	public TreeNode singleRotateWithRight(TreeNode root) {
		TreeNode k2;
		k2 = root.right;
		root.right = k2.left;
		k2.left = root;
		root.height = height(root.left) > height(root.right) ? height(root.left) + 1 : height(root.right) + 1;
		k2.height = height(k2.left) > height(k2.right) ? height(k2.left) + 1 : height(k2.right) + 1;
		return k2;
	}

	// RL插入，双右旋
	public TreeNode doubleRotateWithRight(TreeNode root) {
		root.right = singleRotateWithLeft(root.right);
		return singleRotateWithRight(root);
	}

	// 删除任意节点，删除的以后保持平衡
	public TreeNode delete(TreeNode node, int x) {

		if (node == null) {
			return null; // 当当前节点为空的时候，返回空
		}
		if (x < node.getVal()) {
			node.left = delete(node.left, x);
		} else if (x > node.getVal()) {
			node.right = delete(node.right, x);
		} else {
			if (node.left == null) {
				return node.right;
			} else if (node.right == null) {
				return node.left;
			} else {
				// 当要删除节点的左右子树都不 为空的情况下
				// 首先找到当前节点右子树中的最小节点
				TreeNode minNode = findMin(node);
				// 把这个值直接赋给要删除节点 ，然后把那个最小值对应的节点给删除
				node.setVal(minNode.getVal());
				node.right = delete(node.right, minNode.getVal());
			}

		}
		// 接下来进行判断是否平衡,首先更新高度

		node.height = height(node.left) > height(node.right) ? height(node.left) + 1 : height(node.right) + 1;
		// 进行调整
		if (height(node.left) - height(node.right) > 1) {
			// 当左子树比右子树高的时候
			if (height(node.left.left) - height(node.left.right) >= 0) {
				node = singleRotateWithLeft(node);
			} else {
				node = doubleRotateWithLeft(node);
			}
		} else if (height(node.left) - height(node.right) < -1) {
			// 右子树比左子树高的时候

			if (height(node.right.left) - height(node.right.right) <= 0) {
				node = singleRotateWithRight(node);
			} else {
				node = doubleRotateWithRight(node);
			}
		}
		return node;
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

}
