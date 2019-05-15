package codes;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/*找到所有和为0的三个数的组合*/
public class threeSum {
	@Test
	public void test() {
		int[] nums = { -1, 0, 1, 2, -1, -4 };
		List<List<Integer>> lists = threeSum(nums);
		for (List<Integer> list : lists) {
			for (int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i) + "--");
			}
			System.out.println();
		}
	}

	/* 我的解题思路是先进行排序，然后再将三个数的和转换为一个数的和另外两个数的和， */
	public List<List<Integer>> threeSum(int[] nums) {
		int h = 1;
		while (h < nums.length / 3) {
			h = h * 3 + 1;
		}
		while (h >= 1) {
			int i = 0, temp = 0;
			for (i = h; i < nums.length; i++) {
				temp = nums[i];
				int j = 0;
				for (j = i; j >= h && nums[j - h] > temp; j -= h) {
					nums[j] = nums[j - h];
				}
				nums[j] = temp;
			}
			h /= 3;
		}

		// 开始寻找
		// 在寻找的过程中，要去掉重复的序列，比如连续的两个数如果一样的话，就没有必要再进行遍历了。
		List<List<Integer>> lists = new ArrayList<>();
		for (int i = 0; i < nums.length - 2; i++) {
			if (i == 0 || i > 0 && nums[i] != nums[i - 1]) {
				int left = i + 1, right = nums.length - 1;
				while (left < right) {
					if (nums[left] + nums[right] + nums[i] == 0) {
						List<Integer> list = new ArrayList<Integer>();
						list.add(nums[i]);
						list.add(nums[left]);
						list.add(nums[right]);
						lists.add(list);
						while (left < right && nums[left] == nums[left + 1])
							left++;
						while (left < right && nums[right] == nums[right - 1])
							right--;
						right--;
						left++;
					} else if (nums[left] + nums[right] + nums[i] > 0) {
						right--;
					} else if (nums[left] + nums[right] + nums[i] < 0) {
						left++;
					}
				}
			}

		}
		return lists;
	}
}
