package com.sebar.test.reviewleetcode.one;

/**
 * @author liguang@youxin.com
 * @Date 2020/2/29
 * @Description 283. 移动零
 * https://leetcode-cn.com/problems/move-zeroes/
 */
public class MoveZeros_283_2 {
    /**
     * 第一种快慢指针的方式，用一根指针记录这个数组中0的个数
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        // 记录非0元素的个数
        int j = 0;
        for (int x = 0; x < nums.length; x++) {
            if (nums[x] != 0) {
                // 交换位置
                nums[j++] = nums[x];
            }
        }

        // 记录完0的个数后，末位补0
        for (int f = j; f < nums.length; f++) {
            nums[f] = 0;
        }
    }

    /**
     * 单次遍历
     *
     * @param nums
     */
    public void moveZeroes2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        // 标识着0所在的位置
        int zeroPosition = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[zeroPosition];
                nums[zeroPosition++] = temp;
            }
        }
    }

    public void moveZeroes3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        for (int i = 0, count = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                // count统计前面非0的最后下标
                if (count != i) {
                    nums[count] = nums[i];
                    nums[i] = 0;
                }
                // count前移
                count++;
            }
        }
    }
}
