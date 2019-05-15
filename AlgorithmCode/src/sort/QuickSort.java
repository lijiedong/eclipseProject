package sort;

import org.junit.Test;

/*
 * 快速排序的实现代码
 */
public class QuickSort {
	@Test
	public void test() {
		int[] arr = { 5, 9, 7, 4, 5, 7, 6, 1, 9, 9, 7, 4 };
		printArray(arr);
		quickSort(arr, 0, arr.length - 1);
		printArray(arr);
	}

	public void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "--");
		}
		System.out.println();
	}

	/*
	 * 1）设置两个变量i、j，排序开始的时候：i=0，j=N-1； 2）以第一个数组元素作为关键数据，赋值给key，即key=A[0]；
	 * 3）从j开始向前搜索，即由后开始向前搜索(j--)，找到第一个小于key的值A[j]，将A[j]和A[i]互换；
	 * 4）从i开始向后搜索，即由前开始向后搜索(i++)，找到第一个大于key的A[i]，将A[i]和A[j]互换； 5）重复第3、4步，直到i=j；
	 * (3,4步中，没找到符合条件的值，即3中A[j]不小于key,4中A[i]不大于key的时候改变j、i的值，
	 * 使得j=j-1，i=i+1，直至找到为止。找到符合条件的值，进行交换的时候i，
	 * j指针位置不变。另外，i==j这一过程一定正好是i+或j-完成的时候，此时令循环结束）
	 */
	public void quickSort1(int[] arr, int left, int right) {
		// 当左边大于于右边的时候直接返回
		if (right <= left)
			return;
		int key = arr[left];// 进行划分的值
		int i = left, j = right + 1;// 注意j不是等于right，而是等于right右边的值
		while (true) {

			// 在左边找到第一个比key大的值
			while (arr[++i] < key) {
				if (i == right) {
					break;
				}
			}
			// 在右边找到第一个比key小的值
			while (arr[--j] >= key) {
				if (j == left) {
					break;
				}
			}
			if (i >= j) {
				break;
			}
			exch(arr, i, j);

		}
		// 这个时候i和j已经是相等的了，j右边的元素都不小于key，所以把key和j所对应的元素直接交换位置就行了，接下来就是将key放到相应的位置。
		exch(arr, left, j);
		quickSort1(arr, left, j - 1);
		quickSort1(arr, j + 1, right);

	}

	public void quickSort(int[] arr, int left, int right) {

		// 当左边大于于右边的时候直接返回
		if (right <= left)
			return;
		int key = arr[left];// 进行划分的值
		int i = left, j = right;//
		while (i < j) {

			// 在右边找到第一个比key小的值
			while (i < j && arr[j] >= key) {
				j--;
			}
			// 在左边找到第一个比key大的值
			while (i < j && arr[i] <= key) {
				i++;
			}
			if (i < j) {
				exch(arr, i, j);
			}

		}
		// 这个时候i和j已经是相等的了，j右边的元素都不小于key，所以把key和j所对应的元素直接交换位置就行了，接下来就是将key放到相应的位置。
		exch(arr, left, j);
		quickSort(arr, left, i - 1);
		quickSort(arr, i + 1, right);

	}

	public void exch(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}