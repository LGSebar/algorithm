package com.sebar.test.dailyexercise;

/**
 * @Author LG-QCY
 * @Date :2020/3/27 22:08
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 * 4. 寻找两个有序数组的中位数
 * 中位数实际上是将两个数组整体划分为元素个数相等的两个部分，
 * 并且前一个部分中的数都不大于后一个部分
 */
public class Leetcode_4_1 {
    /**
     * 二分法
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int left = (n + m + 1) / 2;
        int right = (n + m + 2) / 2;
        // 将奇数与偶数的情况合并，如果是奇数，两次k同样
        return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left) + getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) / 2;

    }

    private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        // 让len1的长度小于len2，这样就可以保证如果有数组空了，一定是len1
        if (len1 > len2) {
            // 调换
            return getKth(nums2, start2, end2, nums1, start1, end1, k);
        }
        if (len1 == 0) {
            return nums2[start2 + k - 1];
        }
        if (k == 1) {
            Math.min(nums1[start1], nums2[start2]);
        }
        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;
        if (nums1[i] > nums2[j]) {
            return getKth(nums1, start1, end2, nums2, j + 1, end2, k - (j - start2 + 1));
        } else {
            return getKth(nums1, i + 1, end2, nums2, start2, end2, k - (i - start1 + 1));
        }
    }
}
