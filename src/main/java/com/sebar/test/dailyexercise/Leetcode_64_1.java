package com.sebar.test.dailyexercise;

/**
 * @Author LG-QCY
 * @Date :2020/3/30 22:50
 * https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/
 * 面试题62. 圆圈中最后剩下的数字
 */
public class Leetcode_64_1 {
    public int lastRemaining(int n, int m) {
        int ans = 0;
        // 最后一轮剩下2个人，所以从2开始反推
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans;
    }
}
