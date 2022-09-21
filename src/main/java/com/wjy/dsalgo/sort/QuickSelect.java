package com.wjy.dsalgo.sort;

/**
 * 快速选择
 * 
 * @author weijiayu
 * @date 2022/9/20 17:56
 */
public class QuickSelect {

    // 查找数组中的第K个最大元素
    public static int findKthLargest(int[] nums, int k) {
        int startIndex = 0;
        int endIndex = nums.length - 1;
        int pivotIndex = 0;
        while (1 == 1) {
            int kIndex = endIndex - k + 1;
            // 利用一轮快速排序来快速选择
            pivotIndex = QuickSort.sort(QuickSort.getPivotIndexV2(startIndex, endIndex), nums, startIndex, endIndex);
            if (pivotIndex == kIndex) {
                // 找到TopK对应的基准值
                return nums[pivotIndex];
            } else {
                if (pivotIndex < kIndex) {
                    // 去右区间查找
                    startIndex = pivotIndex + 1;
                } else {
                    // 右区间和k的绝对差值
                    int diff = endIndex - k;
                    // 去左区间查找
                    endIndex = pivotIndex - 1;
                    // 更新k，缩小在子数组的位置
                    k = endIndex - diff;
                }
            }
            // 缩小区间后，重新一轮快速排序
        }
    }
}
