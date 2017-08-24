import data.ListNode;
import medium.RestoreIPAddresses;
import medium.UniqueBinarySearchTreesII;
import test.*;
/**
 * Created by eager-mbp on 2017/6/14.
 */
public class test {

    Student a = new Student();

    public static void main (String args[]) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
//        new RotateImage().rotate(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}});
//        new SpiralMatrixII().generateMatrix(2);

        System.out.println(
//                new ZigZagConversion().convert("ABCDE", 3)
//                new SumFor3().threeSum(new int[]{-1,0,1,2,-1,-4})
//                new LetterCombinationsOfAPhoneNumber().letterCombinations("234")
//                new ValidParentheses().isValid("()")
//                new GenerateParentheses().generateParenthesis2(1)
//                new ReverseNodesInKGroup().reverseKGroup(listNode,2)
//                new MinimumWindowSubstring().minWindow("bba", "ab")
//                new SearchInRotatedSortedArray().search(new int[]{3,1}, 1)
//                new SearchForARange().searchRange(new int[]{5,7,7,8,8,10}, 8)
//                new CountAndSay().countAndSay(5)
//                new CombinationSum().combinationSum(new int []{8,7,4,3}, 11)
//                new FirstMissingPositive().firstMissingPositive(new int[]{2,1})
//                new WildcardMatching().isMatch("aa", "*")
//                new Permutations().permute(new int[] {1,2,3})
//                new NQueens().solveNQueens(8)
//                new UniquePaths().uniquePaths(3,3)
//                new SimplifyPath().simplifyPath("/abc/...")
//                new EditDistance().minDistance("a", "a")
//                new Subsets().subsets(new int[]{1,2,3})
//                new PalindromePartitioning().partition("aab")
//                new LargestRectangleInHistogram().largestRectangleArea(new int[] {4,2,0,3,2,4,3,4})
//                new DecodeWays().numDecodings("321")
//                new UniqueBinarySearchTreesII().generateTrees(3)
//                new RestoreIPAddresses().restoreIpAddresses("0000")
                new UniqueBinarySearchTreesII().generateTrees(3)
        );
    }

    /**
     * 暂且抛弃遗漏掉的题：
     * 30题
     */

}
