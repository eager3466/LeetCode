package easy;

import data.TreeNode;

/**
 * Created by eager-mbp on 2017/8/23.
 */
public class SameTree {

//    Given two binary trees, write a function to check if they are equal or not.
//
//    Two binary trees are considered equal if they are structurally identical and
//    the nodes have the same value.

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    /**
     * 45%通过率的easy题就要有一遍过的能力
     */
}
