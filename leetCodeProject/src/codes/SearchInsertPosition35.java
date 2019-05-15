package codes;

public class SearchInsertPosition35 {
	public int searchInsert(int[] nums, int target) {
		byte i = 0;
		for (i = 0; i < nums.length; i++) {
			if (nums[i] >= target) {
				return i;
			}
		}
		return i;
	}
}
