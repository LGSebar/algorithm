package com.sebar.test.reviewleetcode.one;

/**
 * @author liguang@youxin.com
 * @Date 2020/2/29
 * @Description
 */

public class RemoveDuplicatesFromSortedArray_1_2 {
    /**
     * 双指针
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int point = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[point]) {
                point++;
                nums[point] = nums[j];
            }
        }
        return point + 1;
    }

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
