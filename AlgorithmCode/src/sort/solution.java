package sort;

import java.util.Arrays;

public class solution {
	public void test() {
		int[] arr = { 2, 6, 4, 3 };
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			for (int j = 1; j < arr.length - 1; j++) {

			}
		}
	}

	// 该方法是用于将排序后的数组归并到一起
	// 主要思路就是，将数组归并到一个临时数组，然后再拷贝回原数组
	public void merge(int arr[], int start, int mid, int end) {
		int[] temp = new int[end - start + 1];
		int i = start;// 第一个有序区的索引
		int j = mid + 1;// 第二个有序区的索引
		int k = 0;// 临时数组的索引
		// 这是当两边的数组都没有遍历完
		while (i <= mid && j <= end) {
			if (arr[i] <= arr[j]) {
				temp[k++] = arr[i++];
			} else {
				temp[k++] = arr[j++];
			}
		}
		// 当左边的数组没有遍历完
		while (i <= mid) {
			temp[k++] = arr[i++];
		}
		// 当右边的数组没有遍历完
		while (j <= end) {
			temp[k++] = arr[j++];
		}
		// 将排序后的数组全部整合到数组arr中
		for (i = 0; i < k; i++) {
			arr[start + i] = temp[i];
		}
	}

	// 从下到上
	public void sort(int[] arr, int start, int end) {
		int N = arr.length;
		for (int sz = 1; sz < N; sz = sz + sz) {// sz为子数组大小
			for (int lo = 0; lo < N - sz; lo += sz + sz) {
				// lo为子数组索引，所以lo的取值范围的判定条件为：N-sz，因为索引的最大值为数组的长度减去子数组的长度，从数组的最右边开始算起。
				merge(arr, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
			}
		}
	}
}