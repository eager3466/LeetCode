package medium;

import data.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eager-mbp on 2017/8/20.
 */
public class BinaryTreeInorderTraversal {

//    Given a binary tree, return the inorder traversal of its nodes' values.
//
//    For example:
//    Given binary tree [1,null,2,3],
//            1
//            \
//            2
//            /
//            3
//            return [1,3,2].
//
//    Note: Recursive solution is trivial, could you do it iteratively?

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        recursive(res, root);
        return res;
    }

    private void recursive(List<Integer> res, TreeNode root) {
        if (root == null)
            return ;
        recursive(res, root.left);
        res.add(root.val);
        recursive(res, root.right);
    }

    /**
     * 这没啥说的了吧，这么多年了如果写不出来的话……也不好意思说自己学计算机的了
     */
}
