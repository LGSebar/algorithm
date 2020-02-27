package com.sebar.test.leetcode.three.practice;

import java.util.HashMap;
import java.util.Map;

public class Leetcode_169_566 {
    /**
     * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int maxMajority = nums.length / 2;
        // key count
        Map<Integer, Integer> keyMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int nowCount = keyMap.get(nums[i]) == null ? 1 : 1 + keyMap.get(nums[i]);
            if (nowCount > maxMajority) {
                return nums[i];
            }
            keyMap.put(nums[i], nowCount);
        }
        return 0;
    }

    /**
     * 投票法
     *
     * @param nums
     * @return
     */
    public int voteMajorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;
        for (int num : nums) {
            if (count == 0) {
                // 投票总数归零后，下一个数字就是当前数组的候选众数
                candidate = num;
            }
            count += num == candidate ? 1 : -1;
        }
        return candidate;
    }

    public static void main(String[] args) {
        Leetcode_169_566 code = new Leetcode_169_566();
//        int i = code.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2});
        int i = code.voteMajorityElement(new int[]{3, 3, 4});
        System.out.println(i);

    }
}
