package medium;

import data.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eager-mbp on 2017/8/23.
 */
public class UniqueBinarySearchTreesII {

//    Given an integer n, generate all structurally unique BST's (binary search trees)
//    that store values 1...n.
//
//    For example,
//    Given n = 3, your program should return all 5 unique BST's shown below.
//
//            1         3     3      2      1
//            \       /     /      / \      \
//            3     2     1      1   3      2
//            /     /       \                 \
//            2     1         2                 3

    public List<TreeNode> generateTrees(int n) {
        if(n == 0)
            return new ArrayList<TreeNode>();
        return genTreeList(1,n);
    }

    private List<TreeNode> genTreeList(int start, int end) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        if (start > end) {
            list.add(null);
        }
        for(int idx = start; idx <= end; idx++) {
            List<TreeNode> leftList = genTreeList(start, idx - 1);
            List<TreeNode> rightList = genTreeList(idx + 1, end);
            for (TreeNode left : leftList) {
                for(TreeNode right: rightList) {
                    TreeNode root = new TreeNode(idx);
                    root.left = left;
                    root.right = right;
                    list.add(root);
                }
            }
        }
        return list;
    }

    /**
     * 此题非常有意思，我在自己尝试解题的时候专门弄了个树，然后包括插入删除和查找都在树里操作
     * 用的Backtracking，实际上这个题更好的方法是分治（Divide-and-Conquer）
     *
     * 解题的巧妙在于，用两个list来存储左边和右边可能的结点[1，i)、[i+1, n]
     * 然后对这两个list进行循环遍历，将每一种元素组合起来依次作为自己的left_node和right_node
     * 这样可以结合递归，遍历所有情况，妙哉！
     */

//    public List<TreeNode> generateTrees(int n, int i) {
//        List<TreeNode> res = new ArrayList<>();
//        backtracking(res, null, 1, n);
//        return res;
//    }
//
//    private void backtracking(List<TreeNode> res, TreeNode treeNode, int start, int n) {
//        if (getTreeNodeCount(treeNode) == n) {
//            TreeNode subRes = new TreeNode(0);
//            subRes = treeNode;
//            res.add(subRes);
//        }
//        for (int i = 1; i <= n; i++) {
//            if (!alreadyInTree(treeNode, i)) {
//                treeNode = insertTreeNode(treeNode, i);
//                backtracking(res, treeNode, 0, n);
//                treeNode = deleteTreeNode(treeNode, i);
//            }
//        }
//    }
//
//    private boolean alreadyInTree(TreeNode treeNode, int i) {
//        if (treeNode == null)
//            return false;
//        if (treeNode.val == i) {
//            return true;
//        } else {
//            return alreadyInTree(treeNode.left, i) || alreadyInTree(treeNode.right, i);
//        }
//    }
//
//    private TreeNode insertTreeNode(TreeNode tree, int i) {
//        TreeNode node = new TreeNode(i);
//        node.left = null;
//        node.right = null;
//        if (tree == null) {
//            tree = node;
//        } else if (tree.val >= i){
//            tree.left = insertTreeNode(tree.left, i);
//        } else {
//            tree.right = insertTreeNode(tree.right, i);
//        }
//        return tree;
//    }
//
//    private TreeNode deleteTreeNode(TreeNode tree, int i) {
//        if (tree == null) {
//            return tree;
//        } else if (tree.val == i){
//            tree = null;
//        } else {
//            tree.left = deleteTreeNode(tree.left,  i);
//            tree.right = deleteTreeNode(tree.right, i);
//        }
//        return tree;
//    }
//
//    private int getTreeNodeCount(TreeNode treeNode) {
//        if (treeNode == null) {
//            return 0;
//        } else {
//            return 1 + getTreeNodeCount(treeNode.left) + getTreeNodeCount(treeNode.right);
//        }
//    }
}
