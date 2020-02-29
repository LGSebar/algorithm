package com.sebar.test.reviewleetcode.one;

/**
 * @author liguang@youxin.com
 * @Date 2020/2/29
 * @Description
 */
public class RotateArray_1_2 {
    /**
     * 暴力求解，每次旋转一个元素
     *
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        int temp, prev;
        for (int i = 0; i < k; i++) {
            prev = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = prev;
                prev = temp;
            }
        }
    }

    /**
     * 使用额外数据库进行存储
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
     * 三次反转
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
            nums[i] = nums[i1];
            nums[i1] = temp;
            i++;
            i1--;
        }
    }

    public void rotate4(int[] nums, int k) {
        k %= nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                // 交换的下标位置
                int next = (current + k) % nums.length;
                // 待交换的元素
                int temp = nums[next];
                // 执行交换
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }
}
