package com.wjy.dsalgo.search;

/**
 * @author weijiayu
 * @date 2022/10/8 11:56
 */
public class BinarySearchTest {

    public static void main(String[] args) {
        int[] nums1 = {2, 0, 4, 1, 2};
        int targetNum1 = 1;
        System.out.println(BinarySearch.searchIndexByFirstGtNumUnSort(nums1, targetNum1));

        int[] nums2 = {-1, 0, 3, 5, 9, 12};
        int targetNum2 = 9;
        System.out.println(BinarySearch.searchIndex(nums2, targetNum2));
    }
}
