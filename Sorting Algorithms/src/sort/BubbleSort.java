package sort;

import java.util.Arrays;


public class BubbleSort {
	public static int nums[] = new int[] { 5, 7, 2, 9, 15, 3, 12, 8 };
	
	public static void main(String[] args) {
		
		boolean flag = true;

		while (flag) {
			flag = false;
			for (int i = 0; i < nums.length - 1; i++) {
				
				if (nums[i] > nums[i + 1]) {
					swap(i, i+1);
					flag = true;
				}
			}
		}

		System.out.println(Arrays.toString(nums));

	}

	/**
	 * Recieves the index of the two array positions to be swapped
	 * Swaps the values into their new positions, one being assigned into a 
	 * temporary var first before being copied acorss
	 * @param i
	 * @param j
	 */
	private static void swap(int i, int j) {
		int temp;
		temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
		
	}

}
