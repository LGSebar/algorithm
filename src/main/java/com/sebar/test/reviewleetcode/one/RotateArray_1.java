package com.sebar.test.reviewleetcode.one;

/**
 * @author liguang@youxin.com
 * @Date 2020/2/29
 * @Description 189. 旋转数组
 * https://leetcode-cn.com/problems/rotate-array/
 */

public class RotateArray_1 {
    public static void main(String[] args) {

        RotateArray_1 code = new RotateArray_1();
        code.rotate4(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
    }

    /**
     * 暴力
     * 一次旋转一个数字
     *
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        int temp, previous;
        for (int i = 0; i < k; i++) {
            // 最后一个数
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }

    /**
     * 使用额外的数组
     *
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums, int k) {
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
    }

    /**
     * 使用反转
     *
     * @param nums
     * @param k
     */
    public void rotate3(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int i, int i1) {
        while (i < i1) {
            int temp = nums[i];
            nums[i1] = nums[i];
            nums[i] = temp;
            i++;
            i1--;
        }
    }

    /**
     * 环形替换
     *
     * @param nums
     * @param k
     */
    public void rotate4(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }
}
