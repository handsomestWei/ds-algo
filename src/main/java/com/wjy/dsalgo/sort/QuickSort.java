package com.wjy.dsalgo.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author weijiayu
 * @date 2022/9/20 14:43
 */
public class QuickSort {

    public static int[] sortV1(int[] nums) {
        // 对数组进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(nums, nums.length);
        return sortV1(arr, 0, arr.length - 1);
    }

    public static int[] sortV2(int[] nums) {
        // 对数组进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(nums, nums.length);
        return sortV2(arr, 0, arr.length - 1);
    }

    // 返回基值分隔点
    public static int sort(int pivotIndex, int[] nums, int startIndex, int endIndex) {
        // 基准值
        int pivot = nums[pivotIndex];
        boolean leftStopFlag = false;
        boolean rightStopFlag = false;
        // 双指针
        int i = startIndex;
        int j = endIndex;
        for (; i < j;) {
            if (leftStopFlag && rightStopFlag) {
                // 交换
                swap(nums, i, j);
                leftStopFlag = false;
                rightStopFlag = false;
                continue;
            }
            // 先从右边开始比较，先移动右边的指针
            if (nums[j] > pivot) {
                // 不需要交换
                j--;
            } else {
                rightStopFlag = true;
            }

            if (nums[i] < pivot) {
                // 不需要交换
                i++;
            } else {
                leftStopFlag = true;
            }
        }
        return i;
    }

    // 选择首元素作为基值。但在已排序的从小到大或从大到小数组中，效率会退化为冒泡排序
    public static int getPivotIndexV1(int startIndex) {
        return startIndex;
    }

    // 在范围内随机选择一个元素作为基值。可以尽量避免最坏情况发生，但随机计算会影响性能
    public static int getPivotIndexV2(int startIndex, int endIndex) {
        return new Random().nextInt(endIndex - startIndex + 1) + startIndex;
    }

    public static int getPivotIndexV3() {
        // TODO 求三者中位数
        return -1;
    }

    private static int[] sortV1(int[] nums, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return nums;
        }
        // 选择比较的基值
        int pivotIndex = getPivotIndexV1(startIndex);
        // 排序后基值在数组中的位置
        pivotIndex = sort(pivotIndex, nums, startIndex, endIndex);
        // 小于基值的元素位于左边，大于基值的元素位于右边。继续分治递归排序左右子数组
        sortV1(nums, startIndex, pivotIndex - 1);
        sortV1(nums, pivotIndex + 1, endIndex);
        return nums;
    }

    private static int[] sortV2(int[] nums, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return nums;
        }
        // 选择比较的基值
        int pivotIndex = getPivotIndexV2(startIndex, endIndex);
        // 排序后基值在数组中的位置
        pivotIndex = sort(pivotIndex, nums, startIndex, endIndex);
        // 小于基值的元素位于左边，大于基值的元素位于右边。继续分治递归排序左右子数组
        sortV2(nums, startIndex, pivotIndex - 1);
        sortV2(nums, pivotIndex + 1, endIndex);
        return nums;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }
}
