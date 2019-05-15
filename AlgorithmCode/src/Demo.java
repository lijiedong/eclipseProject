import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class Demo {
	public void Perm(int list[], int k, int m) {
		if (k == m) {
			for (int i = 0; i <= m; i++)
				System.out.print(list[i]);
			System.out.print("--");
			System.out.println();
		} else {
			for (int i = k; i <= m; i++) {
				// 从固定的数后第一个依次交换
				Swap(list, k, i);
				Perm(list, k + 1, m);
				// 这组递归完成之后需要交换回来
				Swap(list, k, i);
			}
		}

	}

	public void Swap(int[] list, int i, int j) {
		int t = list[i];
		list[i] = list[j];
		list[j] = t;
	}

	public static void main(String[] args) {
		Demo d = new Demo();
		int[] arr = { 1, 2, 3 };
		d.Perm(arr, 0, 2);
		String str = "abs";
		char[] ar = str.toCharArray();

	}

	@Test
	public void test() {
		ArrayList<String> lists = Permutation("aab");
		for (int i = 0; i < lists.size(); i++) {
			System.out.println(lists.get(i));
		}
	}

	public ArrayList<String> Permutation(String str) {
		char[] arr = str.toCharArray();
		Set<String> set = new HashSet<>();
		perm(arr, set, 0);
		ArrayList<String> list = new ArrayList<>(set);
		Collections.sort(list);
		return list;
	}

	public void perm(char[] arr, Set<String> set, int index) {
		if (index == arr.length - 1) {
			set.add(new String(arr));
		} else {
			for (int i = index; i < arr.length; i++) {
				swap(arr, index, i);// 交换两个元素
				perm(arr, set, index + 1);
				swap(arr, index, i);// 交换以后再交换回来
			}
		}
	}

	public void swap(char[] arr, int i, int j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}