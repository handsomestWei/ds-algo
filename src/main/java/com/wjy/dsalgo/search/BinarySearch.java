package com.wjy.dsalgo.search;

import java.util.ArrayList;
import java.util.List;

/**
 * 二分查找
 * 
 * @author weijiayu
 * @date 2022/10/8 11:50
 */
public class BinarySearch {

    // 查找排序后第一个大于等于目标元素的值的索引
    public static int searchIndexByFirstGtNumUnSort(int[] nums, int targetNum) {
        int len = nums.length;
        List<Integer> numLs = new ArrayList<>(len);
        for (int num : nums) {
            numLs.add(num);
        }
        // 从小到大排序
        numLs.sort((a, b) -> {
            return a - b;
        });
        return searchIndexByFirstGtNumV2(numLs, targetNum, 0, len - 1);
    }

    // 在已排序的数组中查找目标元素
    public static int searchIndex(int[] nums, int target) {
        int f = 0;
        int t = nums.length - 1;
        int m = (f + t) / 2;
        // 头尾双指针夹逼
        while (f + 1 < t) {
            m = (f + t) / 2;
            if (nums[m] == target) {
                return m;
            }
            if (nums[m] > target) {
                t = m;
            } else {
                f = m;
            }
        }

        if (nums[f] == target) {
            return f;
        }
        if (nums[t] == target) {
            return t;
        }
        return -1;
    }

    // 递归二分查找第一个大于等于目标元素的值的索引。列表已排序
    private static int searchIndexByFirstGtNumV1(List<Integer> ls, int targetNum, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return -1;
        }
        if (startIndex == endIndex) {
            return ls.get(endIndex) > targetNum ? endIndex : -1;
        }
        // 求中值
        int midIndex = (startIndex + (endIndex - startIndex) / 2);
        // 比较中值
        if (targetNum >= ls.get(midIndex)) {
            // 目标值大于等于中值，索引+1
            return searchIndexByFirstGtNumV1(ls, targetNum, midIndex + 1, endIndex);
        } else {
            // 索引不用+1
            return searchIndexByFirstGtNumV1(ls, targetNum, startIndex, midIndex);
        }
    }

    // 双指针循环二分查找第一个大于等于目标元素的值的索引。列表已排序
    private static int searchIndexByFirstGtNumV2(List<Integer> ls, int targetNum, int startIndex, int endIndex) {
        // 头尾双指针夹逼
        int head = startIndex;
        int tail = endIndex;
        // 循环
        while (head <= tail) {
            if (head == tail) {
                return ls.get(tail) > targetNum ? tail : -1;
            }
            // 求中值
            int mid = (head + (tail - head) / 2);
            // 比较中值
            if (targetNum >= ls.get(mid)) {
                // 目标值大于等于中值，索引+1
                head = mid + 1;
            } else {
                // 索引不用+1
                tail = mid;
            }
        }
        return -1;
    }
}
