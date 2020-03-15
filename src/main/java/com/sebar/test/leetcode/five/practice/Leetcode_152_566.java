package com.sebar.test.leetcode.five.practice;

/**
 * https://leetcode-cn.com/problems/maximum-product-subarray/description/
 * 152.
 */
public class Leetcode_152_566 {
    /**
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        //
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE, iMax = 1, iMin = 1;

        for (int i = 0; i < nums.length; i++) {
            // <0 change
            if (nums[i] < 0) {
                int temp = iMax;
                iMax = iMin;
                iMin = temp;
            }
            iMax = Math.max(iMax * nums[i], nums[i]);
            iMin = Math.min(iMin * nums[i], nums[i]);

            max = Math.max(iMax, max);
        }
        return max;
    }

    public static void main(String[] args) {
        Leetcode_152_566 coco = new Leetcode_152_566();
//        int i = coco.maxProduct(new int[]{2, 3, -2, 4});
//        int i = coco.maxProduct(new int[]{-2, 0, -1});
//        int i = coco.maxProduct(new int[]{2,0,-120,-1,130,0,140});
//        int i = coco.maxProduct(new int[]{-2, -3, -4, -5, 1});
        int i = coco.maxProduct(new int[]{3, -1, 4});
//        int i = coco.maxProduct(new int[]{-2, 3, -4});
        System.out.println(i);
    }
}
