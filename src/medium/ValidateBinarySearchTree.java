package medium;

import data.TreeNode;

/**
 * Created by eager-mbp on 2017/8/23.
 */
public class ValidateBinarySearchTree {

//    Given a binary tree, determine if it is a valid binary search tree (BST).
//
//    Assume a BST is defined as follows:
//
//    The left subtree of a node contains only nodes with keys less than the node's key.
//    The right subtree of a node contains only nodes with keys greater than the node's key.
//    Both the left and right subtrees must also be binary search trees.
//    Example 1:
//            2
//            / \
//            1   3
//    Binary tree [2,1,3], return true.
//    Example 2:
//            1
//            / \
//            2   3
//    Binary tree [1,2,3], return false.

    public boolean isValidBST(TreeNode root) {
        return help(root, null, null);
    }

    private boolean help(TreeNode root, Integer low, Integer high) {
        if (root == null)
            return true;
        return (low == null || low < root.val) &&
                (high == null || high > root.val) &&
                help(root.left, low, root.val) &&
                help(root.right, root.val, high);
    }

}
