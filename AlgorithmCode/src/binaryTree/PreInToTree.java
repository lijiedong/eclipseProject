package binaryTree;

import java.util.HashMap;

import org.junit.Test;

//先序和中序序列重构二叉树
public class PreInToTree {
	@Test
	public void test() {
		int[] pre = { 1, 2, 4, 5, 6, 7, 3 };
		int[] in = { 4, 2, 6, 5, 7, 1, 3 };
		new BinaryTree().preOrderRecur(preInToTree(pre, in));
	}

	public TreeNode preInToTree(int[] pre, int[] in) {
		if (pre == null || in == null) {
			return null;
		}
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < in.length; i++) {
			map.put(in[i], i);
		}

		return preIn(pre, 0, pre.length - 1, in, 0, in.length - 1, map);
	}

	public TreeNode preIn(int[] p, int pi, int pj, int[] n, int ni, int nj, HashMap<Integer, Integer> map) {
		if (pi > pj) {
			return null;
		}
		TreeNode head = new TreeNode(p[pi]);
		int index = map.get(p[pi]);
		head.left = preIn(p, pi + 1, pi + index - ni, n, ni, index - 1, map);
		head.right = preIn(p, pi + index - ni + 1, pj, n, index + 1, ni, map);

		return head;
	}
}
