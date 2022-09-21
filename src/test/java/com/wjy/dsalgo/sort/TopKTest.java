package com.wjy.dsalgo.sort;

/**
 * @author weijiayu
 * @date 2022/9/21 11:57
 */
public class TopKTest {

    public static void main(String[] args) {
        int[] nums1 = {46, 30, 82, 90, 56, 17, 95, 15};
        int k1 = 2;
        System.out.println(TopK.findKthLargestV4(nums1, k1));

        int[] nums2 = {46, 30, 82, 90, 56, 17, 95, 15};
        int k2 = 7;
        System.out.println(TopK.findKthLargestV4(nums2, k2));
    }
}
