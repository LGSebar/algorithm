package com.sebar.test.reviewleetcode.one;

/**
 * @author liguang@youxin.com
 * @Date 2020/2/29
 * @Description 26. 删除排序数组中的重复项
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * 返回新的数组的长度
 */

public class RemoveDuplicatesFromSortedArray_1 {
    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray_1 code = new RemoveDuplicatesFromSortedArray_1();
        int i = code.removeDuplicates(new int[]{1, 2, 2});

    }

    /**
     * 双指针
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int len = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[len]) {
                len++;
                // 去除重复的元素
                nums[len] = nums[j];
            }
        }
        return len + 1;
    }

    /**
     * 优化版
     * @param nums
     * @return
     */
    public int improve(int[] nums) {
        int i = nums.length > 0 ? 1 : 0;
        for (int num : nums) {
            if (num > nums[i - 1]) {
                nums[i++] = num;
            }
        }
        return i;
    }
}
