package hard;

import data.TreeNode;

/**
 * Created by eager-mbp on 2017/8/23.
 */
public class RecoverBinarySearchTree {

//    Two elements of a binary search tree (BST) are swapped by mistake.
//
//    Recover the tree without changing its structure.
//
//            Note:
//    A solution using O(n) space is pretty straight forward. Could you devise
//    a constant space solution?

    TreeNode firstNode = null;
    TreeNode secondNode = null;
    TreeNode preNode = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {

        findTraverse(root);
        int temp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = temp;
    }

    private void findTraverse(TreeNode root) {

        if (root == null)
            return ;
        findTraverse(root.left);

        // do something
        if (firstNode == null && preNode.val >= root.val) {
            firstNode = preNode;
        }
        if (firstNode != null && preNode.val >= root.val) {
            secondNode = root;
        }
        preNode = root;

        findTraverse(root.right);
    }

    /**
     * 这个题还是蛮有意思的，除了这种普通的中序遍历的方法，还有线索二叉树可以真正意义实现空间复杂度O(1)的解法
     * 当然，在不改变初始树的结构和指针内容的情况下
     *
     * https://discuss.leetcode.com/topic/9305/detail-explain-about-how-morris-traversal-finds-two-incorrect-pointer/2
     *
     * 总之这个问题需要先拿纸币画一下，如果两个节点交换了会发生什么，这最起码会有一组显示 pre.val > cur.val
     * 当为两组这种情况的时候一个是pre，一个是root，这样弄清楚概念之后再Coding
     *
     * 如果只有一组，也可以涵盖在两组的情况里一起写出来
     */
}
