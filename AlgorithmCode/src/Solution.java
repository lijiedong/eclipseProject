import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		System.out.println("请输入一个整数！");
		int n;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		// 将用户编号和分数存储到map集合里
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			int temp = sc.nextInt();
			ArrayList<Integer> list = map.get(temp);
			if (list == null) {
				ArrayList<Integer> tempList = new ArrayList<>();
				tempList.add(i);
				map.put(temp, tempList);
			} else {
				list.add(i);
				map.put(temp, list);
			}
		}
		// 获得要查询的组数
		int q = sc.nextInt();
		int[][] arrs = new int[q][3];
		for (int i = 0; i < q; i++) {
			for (int j = 0; j < 3; j++) {
				arrs[i][j] = sc.nextInt();
			}
		}
		System.out.println(map.size() + "--");
		for (int i = 0; i < q; i++) {
			find(arrs, map, i);
		}
		for (int i = 0; i < q; i++) {
			System.out.println(arrs[i][0]);
		}
	}

	public static void find(int[][] arrs, HashMap<Integer, ArrayList<Integer>> map, int index) {
		int temp = 0; // 用来存储符合条件的用户的个数
		ArrayList<Integer> list = map.get(arrs[index][2]);// 获取某个分数的所有人
		if (list != null) {
			// 先找到左边的位置
			int left = arrs[index][0] - 1;
			int right = arrs[index][1] - 1;

			Integer[] arr = list.toArray(new Integer[list.size()]);
			Arrays.sort(arr);// 对数组进行排序
			System.out.println(left + "--" + right + "--" + arr.length);
			// 当左边界大于数组最右边的值，不符合条件，直接返回
			if (left > arr[arr.length - 1]) {
				arrs[index][0] = 0;
				return;
			}
			// 当右边界的小于数组最左边的值的时候，不符合条件，直接返回
			if (right < arr[0]) {
				arrs[index][0] = 0;
				return;
			}

			int tempLeft = 0;
			int tempRight = arr.length;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] >= left) { // 找到第一个大于等于左边界的值
					tempLeft = i;
					break;
				}

			}
			for (int i = arr.length - 1; i >= 0; i--) {// 找到第一个小于等于右边界的值
				if (arr[i] <= right) {
					tempRight = i;
					break;
				}
			}
			temp = tempRight - tempLeft + 1;
		}

		arrs[index][0] = temp;
	}
}
/*
 * public static void find(int[][] arrs, int[] arr, int index) { int temp = 0;
 * for (int i = arrs[index][0] - 1; i <= arrs[index][1] - 1; i++) { if (arr[i]
 * == arrs[index][2]) { temp++; } } arrs[index][0] = temp; }
 */
