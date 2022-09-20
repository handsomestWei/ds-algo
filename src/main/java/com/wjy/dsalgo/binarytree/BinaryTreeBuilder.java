package com.wjy.dsalgo.binarytree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 构造二叉树
 * 
 * @author weijiayu
 * @date 2022/9/20 10:02
 */
public class BinaryTreeBuilder {

    // leetcode#105：从前序与中序遍历序列构造二叉树
    public static TreeNode buildTreeByPreAndInOrder(int[] preorder, int[] inorder) {
        // 叶子节点可看成是无左右子树的单跟节点。因此先序数组左区间可以看成左子树的根节点列表，右区间可以看成右子树的根节点列表
        // 将先序遍历元素放入先进先出队列，避免后续使用先序数组时维护和计算索引位
        Deque<Integer> preorderDq = new LinkedList<>();
        for (int val : preorder) {
            preorderDq.addLast(val);
        }

        // 递归构建
        TreeNode root = recursionBuildByPreAndInOrder(inorder, 0, inorder.length - 1, preorderDq);
        return root;
    }

    // leetcode#106：从中序与后序遍历序列构造二叉树
    public static TreeNode buildTreeByInAndPostOrder(int[] inorder, int[] postorder) {
        // 叶子节点可看成是无左右子树的单跟节点。因此后序数组右区间可以看成右子树的根节点列表，左区间可以看成左子树的根节点列表
        // 将后序遍历数组元素倒序遍历，放入先进先出队列，避免后续使用先序数组时维护和计算索引位
        Deque<Integer> postorderDq = new LinkedList<>();
        for (int i = postorder.length - 1; i >= 0; i--) {
            postorderDq.addLast(postorder[i]);
        }

        // 递归构建
        TreeNode root = recursionBuildByInAndPostOrder(inorder, 0, inorder.length - 1, postorderDq);
        return root;
    }

    private static TreeNode recursionBuildByPreAndInOrder(int[] inorder, int start, int end,
        Deque<Integer> preorderDq) {
        if (start > end) {
            return null;
        }
        TreeNode root = new TreeNode(preorderDq.pollFirst());
        for (int i = start; i <= end; i++) {
            // 找到根节点的值在中序遍历数组中的位置
            if (inorder[i] == root.val) {
                // 二分，递归构造左右子树，先左后右
                root.left = recursionBuildByPreAndInOrder(inorder, start, i - 1, preorderDq);
                root.right = recursionBuildByPreAndInOrder(inorder, i + 1, end, preorderDq);
            }
        }
        return root;
    }

    private static TreeNode recursionBuildByInAndPostOrder(int[] inorder, int start, int end,
        Deque<Integer> postorderDq) {
        if (start > end) {
            return null;
        }
        TreeNode root = new TreeNode(postorderDq.pollFirst());
        for (int i = start; i <= end; i++) {
            // 找到根节点的值在中序遍历数组中的位置
            if (inorder[i] == root.val) {
                // 二分，递归构造左右子树，先右后左
                root.right = recursionBuildByInAndPostOrder(inorder, i + 1, end, postorderDq);
                root.left = recursionBuildByInAndPostOrder(inorder, start, i - 1, postorderDq);
            }
        }
        return root;
    }
}
