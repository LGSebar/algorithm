package com.sebar.test.reviewleetcode.one;

import java.util.Arrays;

/**
 * @author liguang@youxin.com
 * @Date 2020/3/1
 * @Description
 */
public class MergeSortedArray_1 {
    /**
     * 双指针
     * O（m+n）
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j > -0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }

    /**
     * 极简模式
     * 时间复杂度O(m+n) 空间复杂度O(1)
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {
            nums1[k--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }

        System.arraycopy(nums2, 0, nums1, 0, j + 1);
    }

    /**
     * 时间复杂度：O((n+m)log(n+m))。空间复杂度O(1)
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge3(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    /**
     * 双指针，从前往后
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     * 时间复杂度：O(n+m) 空间复杂度O(m)
     */
    public void merge4(int[] nums1, int m, int[] nums2, int n) {
        int[] newNum1 = new int[m];
        System.arraycopy(nums1, 0, newNum1, 0, m);

        int p1 = 0;
        int p2 = 0;
        int p = 0;
        while ((p1 < m) && (p2 < n)) {
            nums1[p++] = newNum1[p] < nums2[p2] ? newNum1[p1++] : nums2[p2++];
        }
        // p1未结束
        if (p1 < m) {
            System.arraycopy(newNum1, p1, nums1, p1 + p2, m + n - p1 - p2);
        }
        if (p2 < n) {
            System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
        }
    }
}
