package medium;

import java.util.*;

/**
 * Created by eager-mbp on 2017/7/10.
 */
public class GenerateParentheses {

//    Given n pairs of parentheses, write a function to generate all combinations of
//    well-formed parentheses.
//
//    For example, given n = 3, a solution set is:
//
//            [
//            "((()))",
//            "(()())",
//            "(())()",
//            "()(())",
//            "()()()"
//            ]

    public List<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<>();
        if (n <= 0)
            return res;
        LinkedList<String> queue = new LinkedList<>();
        queue.add("()");
        if (n == 1)
            return queue;
        for (int i = 1; i < n; i++) {
            Set<String> insertSet = new HashSet<>();
            // 一次性把同样长度的字符串都取出，然后再进行下一轮添加
            while (!queue.isEmpty() && queue.peek().length() == 2*i) {
                StringBuilder stringBuilder = new StringBuilder(queue.remove());
                String origin = stringBuilder.toString();
                for (int j = 0; j < origin.length(); j++) {
                    stringBuilder.insert(j, "()");
                    insertSet.add(stringBuilder.toString());
                    String str = stringBuilder.toString();
                    stringBuilder.delete(j, j+2);
                }
                insertSet.add(stringBuilder.insert(0, '(').append(')').toString());
            }
            for (String str: insertSet)
                queue.add(str);
            insertSet.clear();
        }
        return queue;
    }

    /**
     * 这个题我用电话号码字母组合那个思路做出来了，用的BFS
     * 只不过这次变成了括号的组合，而不是单单的字符排列问题
     * 不过我在产生字符串的时候有不少重复的地方，不得已用了一个set来消除重复元素，这样无疑增大了开销。
     *
     * 超神的标答用递归来产生了一个解决方法，close < open 是这个算法的精髓，赞美之心。
     * 先看懂，再想办法记忆然后背下来吧。
     *
     */

    /**
     * The idea here is to only add '(' and ')' that we know will guarantee us a solution
     * (instead of adding 1 too many close).
     * Once we add a '(' we will then discard it and try a ')' which can only close a valid '('.
     * Each of these steps are recursively called.
     */

    public List<String> generateParenthesis2(int n) {
        List<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    public void backtrack(List<String> list, String str, int open, int close, int max){

        if(str.length() == max*2){
            list.add(str);
            return;
        }

        if(open < max)
            backtrack(list, str+"(", open+1, close, max);
        if(close < open)
            backtrack(list, str+")", open, close+1, max);
    }

}
