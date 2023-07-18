package com.wjy.dsalgo.search;

/**
 * @author weijiayu
 * @date 2023/7/18 9:26
 */
public class MooreVoteTest {

    public static void main(String[] args) {
        int[] nums1 = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(MooreVote.searchMajorityElement(nums1));

        int[] nums2 = {1, 1, 1, 2, 2, 2};
        System.out.println(MooreVote.searchMajorityElement(nums2));
    }
}
