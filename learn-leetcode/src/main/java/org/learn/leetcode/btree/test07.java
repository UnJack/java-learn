package org.learn.leetcode.btree;

import org.learn.leetcode.common.TreeNode;
import org.learn.leetcode.common.TreeNodeFactory;

/**
 * @link 二叉树的最大深度
 * <a href="https://leetcode.cn/problems/maximum-depth-of-binary-tree/description/">
 * https://leetcode.cn/problems/maximum-depth-of-binary-tree/description/
 * </a>
 */
public class test07 {

    public static void main(String[] args) {
        TreeNode<Integer> root = TreeNodeFactory.getTreeNode();
        System.out.println(max(root));
    }

    public static int max(TreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        int leftMax = max(root.getLeft());
        int rightMax = max(root.getRight());
        return Math.max(leftMax, rightMax) + 1;
    }
}
