package BalancedBinaryTree;

/*判断一颗树是否是平衡二叉树*/
public class JudgeTreeWhetherBalanced {
	public boolean isBalance(TreeNode node) {
		boolean[] res = new boolean[1];
		res[0] = false;
		getHeight(node, res, 1);
		return res[0];
	}

	public int getHeight(TreeNode node, boolean[] res, int level) {
		if (node == null) {
			return level;
		}
		int lh = getHeight(node.left, res, level + 1);
		if (!res[0]) {
			return level;
		}
		int rh = getHeight(node.right, res, level + 1);
		if (!res[0]) {
			return level;
		}
		if (Math.abs(lh - rh) > 1) {
			res[0] = false;
		}
		return Math.max(lh, rh);
	}

	public int isBalanced(TreeNode node, boolean[] res) {
		if (node == null) {
			return 0;
		}
		int lh = isBalanced(node.left, res);
		if (!res[0]) {
			return lh;
		}
		int rh = isBalanced(node.right, res);
		if (Math.abs(lh - rh) > 1) {
			res[0] = false;
		}
		return Math.max(lh, rh) + 1;

	}

	public String replaceSpace(StringBuffer str) {
		StringBuilder temp = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != ' ') {
				temp.append(str.charAt(i));
			} else {
				temp.append("%20");
			}
		}
		return temp.toString();
	}
}
