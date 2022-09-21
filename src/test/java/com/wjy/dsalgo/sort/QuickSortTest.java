package com.wjy.dsalgo.sort;

/**
 * @author weijiayu
 * @date 2022/9/20 16:00
 */
public class QuickSortTest {

    public static void main(String[] args) {
        int[] nums1 = {46, 30, 82, 90, 56, 17, 95, 15};
        int[] rs1 = QuickSort.sortV1(nums1);
        printArray(rs1);

        int[] nums2 = {46, 30, 82, 90, 56, 17, 95, 15};
        int[] rs2 = QuickSort.sortV2(nums2);
        printArray(rs2);
    }

    private static void printArray(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
