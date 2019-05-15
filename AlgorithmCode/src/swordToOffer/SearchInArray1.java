package swordToOffer;

import org.junit.Test;

public class SearchInArray1 {
	@Test
	public void test() {
		int[][] arr = { { 1, 2, 8, 9 }, { 2, 4, 9, 12 }, { 4, 7, 10, 13 }, { 6, 8, 11, 15 } };
		System.out.println(Find(7, arr));
		/*
		 * for (int i = 0; i < arr.length; i++) { for (int j = 0; j <
		 * arr[i].length; j++) { System.out.print(arr[i][j] + "--"); }
		 * System.out.println(); }
		 */
	}

	public boolean Find(int target, int[][] array) {
		boolean flag = false;
		for (int i = 0; i < array.length; i++) {
			int low = 0;
			int high = array[i].length - 1;
			while (low <= high) {
				int mid = low + (high - low) / 2;
				if (array[i][mid] > target) {
					high = mid - 1;
				} else if (array[i][mid] < target) {
					low = mid + 1;
				} else {
					return true;
				}
			}
		}

		return flag;
	}
}
