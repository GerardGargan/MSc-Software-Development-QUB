package sort;

import java.util.Arrays;

public class BubbleSort2 {



	public static void main(String[] args) {
		int[] nums = new int[] { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		boolean flag = true;

		while (flag) {
			flag = false;
			for (int i = 0; i < nums.length - 1; i++) {
				if (nums[i] > nums[i + 1]) {
					swap(i, i + 1, nums);
					flag = true;
				}
			}
		}
		System.out.println(Arrays.toString(nums));
	}

	private static void swap(int i, int j, int[] nums2) {
		int temp;
		temp = nums2[i];
		nums2[i] = nums2[j];
		nums2[j] = temp;

	}

}
