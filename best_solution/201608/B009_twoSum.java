/*

1. Two Sum

    Total Accepted: 268899
    Total Submissions: 1061897
    Difficulty: Easy

Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

UPDATE (2016/2/13):
The return format had been changed to zero-based indices. Please read the above updated description carefully.

Subscribe to see which companies asked this question


*/

import java.util.Arrays;
public class B009_twoSum {
	public static void main(String[] args) {
//		int[] nums = {1, 3, 6, 9, 8};
//		int[] ans = twoSum(nums, 12);
		int[] nums = {3, 2, 4};
		int[] ans = twoSum(nums, 6);
		System.out.println(ans[0]);	
		System.out.println(ans[1]);	
	}
	static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2)
			return null;
		int[] arr = new int[nums.length];
		for (int i = 0; i != arr.length; i ++)
			arr[i] = i;
		myQuickSort(nums, arr, 0, arr.length-1);
		int sta = 0, end = nums.length-1;
		while (sta < end) {
			int tmp = nums[sta] + nums[end];
			if (tmp > target)
				end --;
			else if (tmp < target)
				sta ++;
			else {
				if (arr[sta] < arr[end])
					return new int[] {arr[sta], arr[end]};	
				else if (arr[sta] > arr[end])
					return new int[] {arr[end], arr[sta]};
				else
					sta ++;
			}
		}
		return new int[] {0, 0};
    }
	static void myQuickSort(int[] nums, int[] arr, int l, int r) {
		if (l >= r)
			return;
		int p = partition(nums, arr, l, r);
		myQuickSort(nums, arr, l, p - 1);
		myQuickSort(nums, arr, p + 1, r);
	}
	static int partition(int[] nums, int[] arr, int l, int r) {
		int p = nums[l];
		int p_arr = arr[l];
		while (l < r) {
			while (l < r && nums[r] >= p)	r --;
			nums[l] = nums[r];
			arr[l] = arr[r];
			while (l < r && nums[l] <= p)	l ++;
			nums[r] = nums[l];
			arr[r] = arr[l];
		}
		nums[l] = p;
		arr[l] = p_arr;
		return l;
	}
}
