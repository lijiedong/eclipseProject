package sort;

import org.junit.Test;

public class Sort1 {
	@Test
	public void test() {
		int[] arr = { 20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		// insertSort(arr);
		System.out.println("-------");
		shellSort(arr);
	}

	// 选择排序
	public void selectSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int min = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[min] > arr[j]) {
					min = j;
				}
			}
			int temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
		}
		for (int i = 0; i < arr.length; i++) {

			System.out.print(arr[i] + " ");
		}
	}

	// 插入排序
	public void insertSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j > 0 && (arr[j] < arr[j - 1]); j--) {
				int temp = arr[j];
				arr[j] = arr[j - 1];
				arr[j - 1] = temp;
			}
		}
		for (int i = 0; i < arr.length; i++) {

			System.out.print(arr[i] + " ");
		}
	}

	// 插入排序的改进版
	public void insertSort1(int[] arr) {
		int i, j;
		int temp;
		for (i = 0; i < arr.length; i++) {
			temp = arr[i];
			for (j = i; j > 0 && (arr[j - 1] > temp); j--) {

				arr[j] = arr[j - 1];

			}
			arr[j] = temp;
		}
		for (i = 0; i < arr.length; i++) {

			System.out.print(arr[i] + " ");

		}
	}

	// 希尔排序
	public void shellSort(int[] arr) {
		int h = 1;
		while (h < arr.length / 3) {
			h = 3 * h + 1;
		}
		System.out.println(h + "---");
		while (h >= 1) {
			int i = 0;
			int temp = 0;
			for (i = h; i < arr.length; i++) {
				temp = arr[i];
				int j;
				for (j = i; j >= h && arr[j - h] > temp; j -= h) {
					arr[j] = arr[j - h];
				}
				arr[j] = temp;
			}
			h = h / 3;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
