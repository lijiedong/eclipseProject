package BalancedBinaryTree;

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	int height;// 表示当前节点左右子树的高度差

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public TreeNode(int val) {
		super();
		this.val = val;
	}

}
