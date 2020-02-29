package com.sebar.test.reviewleetcode.one;

/**
 * @author liguang
 * @Date 2020/2/29
 * @Description 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，
 * 同时保持非零元素的相对顺序。
 * https://leetcode-cn.com/problems/move-zeroes/
 */

public class MoveZeros_283 {
    /**
     * 将不是0 的位置与0进行交换
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int zeroPosition = 0;
        for (int i = 0; i < nums.length; i++) {
            // 如果不等于0 ，则与zeroPosition进行位置交换
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[zeroPosition];
                nums[zeroPosition++] = temp;
            }
        }
    }

    /**
     * 快慢指针的做法
     * 第一步，将所有不是0的进行交换，并记录下0的个数
     *
     * @param nums
     */
    public void moveZeroes2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        // 0的个数，用于第二次循环的时候，进行末位补零
        int j = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                // 替换到前面去
                nums[j++] = nums[i];
            }
        }

        // 末位补零
        for (int z = j; z < nums.length; z++) {
            nums[z] = 0;
        }
    }
}
