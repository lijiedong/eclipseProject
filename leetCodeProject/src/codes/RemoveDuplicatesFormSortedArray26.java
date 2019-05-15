package codes;

/*该算法是移除数组中的重复元素*/
public class RemoveDuplicatesFormSortedArray26 {
	public int removeDuplicates(int[] nums) {
		int j = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[j] != nums[i]) {
				nums[++j] = nums[i];
			}
		}
		return j;
	}
}
