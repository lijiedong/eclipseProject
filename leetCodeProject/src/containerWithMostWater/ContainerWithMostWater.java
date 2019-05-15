package containerWithMostWater;

import org.junit.Test;

public class ContainerWithMostWater {
	@Test
	public void test() {
		int[] arr = { 1, 2 };
		System.out.println(maxArea(arr));
	}

	public int maxArea(int[] height) {
		// 先遍历一遍数组，找到里面的所有的最高值
		int maxHeight = 0;
		int max = 0;
		for (int i = 0; i < height.length; i++) {
			maxHeight = (maxHeight > height[i]) ? maxHeight : height[i];
		}
		// 开始遍历
		for (int i = 0; i < height.length; i++) {
			if (height[i] == maxHeight) {
				int left = i, right = i;
				while (left >= 0 && right < height.length) {

				}
				for (int j = i + 1; j < height.length; j++) {
					max = (max < (j - i) * height[j]) ? (j - i) * height[j] : max;
				}
				for (int j = i; j >= 0; j--) {
					max = (max < (i - j) * height[j]) ? (i - j) * height[j] : max;
				}
			}
		}
		return max;
	}

	public int maxArea1(int[] height) {
		int max = 0;
		for (int i = 0; i < height.length - 1; i++) {
			for (int j = i + 1; j < height.length; j++) {
				if (height[i] < height[j]) {
					max = (max < (j - i) * height[i]) ? (j - i) * height[i] : max;
				} else {
					max = (max < (j - i) * height[j]) ? (j - i) * height[j] : max;
				}
			}
		}
		return max;
	}
}
