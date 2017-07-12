import data.ListNode;
import easy.LongestCommonPrefix;
import easy.ReverseInteger;
import easy.ValidParentheses;
import hard.ReverseNodesInKGroup;
import medium.GenerateParentheses;
import medium.LetterCombinationsOfAPhoneNumber;
import medium.StringToInteger;
import medium.SumFor3;

/**
 * Created by eager-mbp on 2017/6/14.
 */
public class test {

    public static void main (String args[]) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        System.out.println(
//              new ZigZagConversion().convert("ABCDE", 3)
//              new SumFor3().threeSum(new int[]{-1,0,1,2,-1,-4})
//              new LetterCombinationsOfAPhoneNumber().letterCombinations("234")
//              new ValidParentheses().isValid("()")
//              new GenerateParentheses().generateParenthesis2(1)
                new ReverseNodesInKGroup().reverseKGroup(listNode,2)
        );
    }

}
