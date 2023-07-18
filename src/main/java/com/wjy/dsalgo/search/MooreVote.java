package com.wjy.dsalgo.search;

/**
 * 摩尔投票算法实现。时间复杂度O(n)，空间复杂度O(1)
 * 
 * @link https://leetcode.cn/problems/majority-element/
 * 
 * @author weijiayu
 * @date 2023/7/18 9:17
 */
public class MooreVote {

    // 返回其中的多数元素。多数元素是指在数组中出现次数大于n/2的元素。
    public static int searchMajorityElement(int[] nums) {
        // 当前投票元素
        int majorElement = nums[0];
        // 当前投票元素票数
        int majorElementVoteCnt = 0;

        for (int num : nums) {
            if (majorElement == num) {
                majorElementVoteCnt++;
            } else {
                // 不是投当前候选人，则票数-1，相当于对冲
                majorElementVoteCnt--;
            }

            // 如果当前候选人票数为0，则切换候选人，重置计数
            if (majorElementVoteCnt == 0) {
                majorElement = num;
                majorElementVoteCnt = 1;
            }
        }

        // 最后验证答案是否符合要求，不符合则返回-1
        return checkMajorityElement(nums, majorElement) ? majorElement : -1;
    }

    // 判断选出的多数元素是否在数组中出现次数大于n/2
    private static boolean checkMajorityElement(int[] nums, int majorElement) {
        int majorElementCnt = 0;
        for (int num : nums) {
            if (num == majorElement) {
                majorElementCnt++;
            }
        }
        return majorElementCnt * 2 > nums.length;
    }
}
