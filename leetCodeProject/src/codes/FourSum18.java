package codes;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class FourSum18 {
	@Test
	public void test() {
		int[] nums = { -1, 0, 1, 2, -1, -4 };
		List<List<Integer>> lists = fourSum(nums, -1);
		for (List<Integer> list : lists) {
			for (int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i) + "--");
			}
			System.out.println();
		}
	}

	public void shellSort(int[] arr) {
		int h = 1;
		while (h < arr.length / 3) {
			h = 3 * h + 1;
		}
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
	}

	public List<List<Integer>> fourSum(int[] nums, int target) {
		shellSort(nums);
		List<List<Integer>> lists = new ArrayList<>();
		for (int i = 0; i < nums.length - 3; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {// 这一步是跳过外部的重复元素
				continue;
			}
			for (int j = i + 1; j < nums.length - 2; j++) {
				if (j > i + 1 && nums[j] == nums[j - 1])// 这一步我确实没有这样想过
					continue;
				int left = j + 1, right = nums.length - 1;
				while (left < right) {
					if (nums[i] + nums[j] + nums[left] + nums[right] == target) {
						List<Integer> list = new ArrayList<Integer>();
						list.add(nums[i]);
						list.add(nums[j]);
						list.add(nums[left]);
						list.add(nums[right]);
						lists.add(list);
						while (left < right && nums[left] == nums[left + 1])
							left++;
						while (left < right && nums[right] == nums[right - 1])
							right--;
						right--;
						left++;
					} else if (nums[i] + nums[j] + nums[left] + nums[right] > target) {
						right--;
					} else if (nums[i] + nums[j] + nums[left] + nums[right] < target) {
						left++;
					}
				}
			}

		}

		return lists;
	}
}
