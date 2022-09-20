package com.wjy.dsalgo.binarytree;

/**
 * @author weijiayu
 * @date 2022/8/10 11:42
 */
public class BinaryTreeBuilderTest {

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder1 = {9, 3, 15, 20, 7};
        // [3,9,20,null,null,15,7]
        TreeNode root1 = BinaryTreeBuilder.buildTreeByPreAndInOrder(preorder, inorder1);

        int[] inorder2 = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        // [3,9,20,null,null,15,7]
        TreeNode root2 = BinaryTreeBuilder.buildTreeByInAndPostOrder(inorder2, preorder);
    }
}
