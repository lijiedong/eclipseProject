package generic;

import java.util.ArrayList;
import java.util.Stack;

import org.junit.Test;

public class Solution {
	@Test
	public void test() {

		int[] arr = { 4, 8, 6, 12, 16, 14, 10 };
		System.out.println(VerifySquenceOfBST(arr));
	}

	// 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
		ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();
		findPath(root, target, 0, stack, lists);
		return lists;
	}

	public void findPath(TreeNode root, int target, int currentSum, Stack<Integer> stack,
			ArrayList<ArrayList<Integer>> lists) {
		currentSum += root.val;
		stack.push(root.val);
		if (root.left == null && root.right == null && currentSum == target) {
			int sum = 0;
			ArrayList<Integer> list = new ArrayList<>();
			for (int i = 0; i < stack.size(); i++) {

				list.add(stack.get(i));
			}
			lists.add(list);
		}
		if (root.left != null)// 当左子树不为空的时候，寻找左子树
			findPath(root.left, target, currentSum, stack, lists);
		if (root.right != null)// 当右子树不为空的时候，寻找右子树
			findPath(root.right, target, currentSum, stack, lists);
		// 当返回父节点时，在路径上删除当前节点
		stack.pop();

	}
	// ----------------------------------

	// 判断一个序列是否是二叉搜索树的序列
	public boolean VerifySquenceOfBST(int[] sequence) {

		return verify(sequence, 0, sequence.length - 1);
	}

	public boolean verify(int[] arr, int begin, int end) {
		if (end < 0) {
			return false;
		}
		int root = arr[end];
		int i = begin; // 通过遍历找到第一个比根节点值大的节点
		while (i < end) {
			if (arr[i] > root) {
				break;
			}
			i++;
		}
		// 遍历右子树的节点，看是否均大于根节点
		int j = i;
		while (j < end) {
			if (arr[j] < root) {
				return false;
			}
			j++;
		}
		// 判断左子树是否是二叉平衡树
		boolean left = true;
		if (i > 0)
			left = verify(arr, begin, i - 1);
		// 判断右子树是否是二叉平衡树
		boolean right = true;
		if (j < end)
			right = verify(arr, i, j - 1);
		return left && right;
	}
	// --------------------------------------------------------------

	public boolean IsPopOrder(int[] pushA, int[] popA) {
		if (pushA.length == 0 || popA.length == 0) {
			return false; // 当传入的序列有一个为空的时候返回false
		}
		int push = 0, pop = 0;
		Stack<Integer> stack = new Stack<>();

		while (pop < popA.length) {
			while (stack.isEmpty() || popA[pop] != stack.peek()) { // 当辅助栈栈顶的元素和弹出队列
				if (push == pushA.length) { // 的元素不相等的时候，继续入栈
					return false;
				}
				stack.push(pushA[push++]);

			}
			stack.pop();
			pop++;
		}

		return true;
	}
}

class TreeNode {
	int val = 0;
	TreeNode left = null;
	TreeNode right = null;

	public TreeNode(int val) {
		this.val = val;

	}

}
