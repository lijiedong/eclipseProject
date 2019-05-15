import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 };
		/*
		 * ArrayList<ArrayList<Integer>> lists = permute(arr); for (int i = 0; i
		 * < lists.size(); i++) { System.out.println(lists.get(i)); }
		 */
		/*
		 * HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
		 * 
		 * HashSet<Integer> set = map.get(3); if (set == null) {
		 * System.out.println("null"); }
		 */
		System.out.println("arr地址：" + arr);
		f(arr);
	}

	public static void f(int[] arr1) {
		System.out.println("arr地址：" + arr1);
		arr1 = new int[] { 2, 34 };
		System.out.println(arr1);
	}

	public static ArrayList<ArrayList<Integer>> permute(int[] num) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		ArrayList<Integer> temp = new ArrayList<>();
		boolean bool[] = new boolean[num.length]; // 标记原数组当前位是否已摆放
		Arrays.fill(bool, false);
		dfs(0, list, temp, num, bool);
		return list;
	}

	/**
	 * 
	 * @param index
	 *            指示当前存储位
	 * @param list
	 * @param num
	 *            原存储空间
	 * @param bool
	 *            标记原数组当前位是否已摆放
	 * @param temp
	 *            当前存储序列
	 */
	private static void dfs(int index, ArrayList<ArrayList<Integer>> list, ArrayList<Integer> temp, int[] num,
			boolean[] bool) {

		if (index == num.length) {
			list.add(new ArrayList<Integer>(temp));
			return;
		}

		// 每一层都从0开始查找，直到第一层查找到num.length-1，递归结束
		for (int i = 0; i < num.length; i++) {
			if (bool[i] == false) {
				bool[i] = true;
				temp.add(num[i]);
				dfs(index + 1, list, temp, num, bool);
				temp.remove(temp.size() - 1);
				bool[i] = false;
			}
		}
	}
}