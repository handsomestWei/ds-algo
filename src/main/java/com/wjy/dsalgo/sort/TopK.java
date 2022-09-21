package com.wjy.dsalgo.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 查找数组中的第K个最大元素。leetcode#215
 * 
 * @author weijiayu
 * @date 2022/9/20 14:41
 */
public class TopK {

    // 使用jdk集合类的快速排序
    public static int findKthLargestV1(int[] nums, int k) {
        // 从小到大排序
        Arrays.sort(nums);
        // 倒序访问，返回第k个最大的元素
        return nums[nums.length - k];
    }

    // 使用快速排序
    // 排序了数组中的所有值，但实际只需要TopK的值
    public static int findKthLargestV2(int[] nums, int k) {
        // 快排
        nums = QuickSort.sortV2(nums);
        // 倒序访问，返回第k个最大的元素
        return nums[nums.length - k];
    }

    // 使用有K个元素的最小堆，返回堆顶元素
    // 可以得到Top1和TopK的值，因为k一般都比数组长度小，所以能减少一些重复计算，但仍然重复计算了Top1到TopK-1等值
    public static int findKthLargestV3(int[] nums, int k) {
        int len = nums.length;
        // 使用一个含有k个元素的最小堆，PriorityQueue底层是动态数组，为了防止数组扩容产生消耗，可以先指定数组的长度
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, Comparator.comparingInt(a -> a));
        // 将前k个元素添加到minHeap里
        for (int i = 0; i < k; i++) {
            minHeap.offer(nums[i]);
        }

        for (int i = k; i < len; i++) {
            Integer topElement = minHeap.peek();
            // 当前遍历的元素比堆顶元素大，堆顶弹出，遍历的元素进去
            if (nums[i] > topElement) {
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }
        return minHeap.peek();
    }

    // 使用快速选择，找到TopK对应的基准值。不用排序整个数组
    public static int findKthLargestV4(int[] nums, int k) {
        return QuickSelect.findKthLargest(nums, k);
    }
}
