package com.hao.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 
 * 【TOP-1】
 * 【两数之和】
 * 
 * 给定一个整数数组 nums 和一个目标值 target，
 * 请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 
 * 
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * @author hao
 *
 */
public class LC0001 {
	
	public int[] twoSum(int[] nums, int target) {
		return Solution3(nums, target);
	}
	
	/**
	 * 解法一：暴力解法
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] Solution1(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					return new int[] { i, j };
				}
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}

	/**
	 * 解法二： 这里利用了java集合中map 哈希表的特性，遍历数组，将元素存入哈希表中， 并同时判断（目标值-当前元素）得到的结果是否在哈希表中，
	 * 如果在哈希表中则返回这两个下标，
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] Solution2(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			int targetResult = target - nums[i];
			if (map.get(nums[i]) != null && nums[i] * 2 == target) {
				//此处针对于 2 +2 =4  4+4=8 这种 存在重复的情况，且重复的加起来正好是target
				return new int[] { map.get(targetResult), i };
			}
			if (map.containsKey(targetResult)) {
				return new int[] { map.get(targetResult), i };
			}
			map.put(nums[i], i);
		}
		throw new IllegalArgumentException("No two sum solution");
	}

	/**
	 * 解法三：
	 * 利用手动哈希的方法，和解法二思路相同
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int[] Solution3(int[] nums, int target) {
		int indexArrayMax = 2047;
		int[] indexArrays = new int[indexArrayMax + 1];
		for (int i = 0; i < nums.length; i++) {
			int diff = target - nums[i];
			int index = diff & indexArrayMax;
			if (indexArrays[index] != 0) {
				return new int[] { indexArrays[index] - 1, i };
			}
			indexArrays[nums[i] & indexArrayMax] = i + 1;
		}
		throw new IllegalArgumentException("No two sum value");
	}
}
