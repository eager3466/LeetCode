package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eager-RESCUER on 2017/8/7
 */
public class PalindromePartitioning {

//    Given a string s, partition s such that every substring of the partition is a palindrome.
//
//    Return all possible palindrome partitioning of s.
//
//    For example, given s = "aab",
//    Return

//        [
//        ["aa","b"],
//        ["a","a","b"]
//        ]

    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), s, 0);
        return list;
    }

    public void backtrack(List<List<String>> list, List<String> tempList, String s, int start){
        if(start == s.length())
            list.add(new ArrayList<>(tempList));
        else{
            for(int i = start; i < s.length(); i++){
                if(isPalindrome(s, start, i)){
                    tempList.add(s.substring(start, i + 1));
                    backtrack(list, tempList, s, i + 1);
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }

    public boolean isPalindrome(String s, int low, int high){
        while(low < high)
            if(s.charAt(low++) != s.charAt(high--)) return false;
        return true;
    }

    /**
     * 准确理解好题意之后，可以用backtracking解出。
     *
     * 对字符串里的字符依次进行访问，每次走一个长度，并且backtracking的start为每次的i+1
     *
     * 循环查找到字符串结尾之后，表示当次分割成功
     */
}
