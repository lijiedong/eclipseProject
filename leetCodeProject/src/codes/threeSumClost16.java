package codes;

import org.junit.Test;

public class threeSumClost16 {
	@Test
	public void test() {
		int[] nums = { 0, 2, 1, -3 };
		System.out.println(threeSumClosest(nums, 1));
	}

	/*
	 * 这道题是求三个数最接近目标和，我觉得和上一道求三个数和为0题是一样的，思路也是先排序再求解，
	 * 但是我在解的过程中，我没有控制那个左右两边移动的条件，所以才会花了那么多的时间，
	 * 当三个数的和大于目标值，意味着最后一个数可以减小，也就是right-- 当三个数的和小于目标值，意味着第二个数可以增大，也就是left++
	 * 其中第一个数是由外层循环i控制，所以内层循环不涉及第一个元素的变换 我一直没有想明白那个移动的条件。其他的我觉得应该没什么问题
	 */
	public int threeSumClosest(int[] nums, int target) {

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
		int sum = nums[0] + nums[1] + nums[nums.length - 1];
		for (int i = 0; i < nums.length - 2; i++) {

			int left = i + 1, right = nums.length - 1;

			while (left < right) {
				int temp = nums[left] + nums[right] + nums[i];
				if (temp == target) {
					return temp;
				}
				if (Math.abs(temp - target) < Math.abs(sum - target)) {
					sum = temp;
				}
				if (temp > target) {
					right--;
				} else {
					left++;
				}
			}

		}
		return sum;
	}
}
