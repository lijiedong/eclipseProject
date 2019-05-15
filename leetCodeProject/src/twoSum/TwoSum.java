package twoSum;

public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 2, 7, 11, 15 };
		a = twoSum(a, 9);
		System.out.println(a[0] + "---" + a[1]);
	}

	public static int[] twoSum(int[] nums, int target) {

		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					return new int[] { i, j };

				}
			}
		}
		return null;
	}

}
