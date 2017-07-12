package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by eager-mbp on 2017/7/7.
 */
public class LetterCombinationsOfAPhoneNumber {

//    Given a digit string, return all possible letter combinations that the number could represent.
//
//    A mapping of digit to letters (just like on the telephone buttons) is given below.
//
//      (A phone picture that combines 1-9 with a-z)
//
//    Input:Digit string "23"
//    Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits==null || digits.length()==0) {
            return res;
        }
        String prefix = "";
        recursive(digits, prefix, 0, res);
        return res;
    }

    public void recursive(String digits, String prefix, int index, List<String> res) {
        if (index >= digits.length()) {
            // means prefix has all elements
            res.add(prefix);
        } else {
            String str = KEYS[digits.charAt(index) - '0'];
            for (int i = 0; i < str.length(); i++) {
                recursive(digits, prefix+str.charAt(i), index+1, res);
            }
        }
    }

    /**
     * 这一题是一个类似的图遍历。对n个字符串进行n次便利，应该是O(n^n)
     * 为了解决这样的问题，可以用递归recursive（实际上是用了堆栈（stack))这个想法类似于DFS
     * 自己重写递归的时候，发现如果参数传递StringBuilder的时候会造成引用传递（reference pass）
     * 以为不太可行的时候看到了有位朋友的code可以work，发现他的思路是这样：
     * StringBuilder.append(char);
     * recursive();
     * StringBuilder.deleteCharAt(result.length() - 1);
     * 递归过后又删除了当前添加的char，这样就不会出错了。
     * 事实证明这样的code耗时6ms，用String的话耗时8ms，肯定是有所提升。
     *
     * 另一个就是用队列来进行遍历，思路类似于BFS
     * BFS的标答中，ans.peek().length()==i真是帅气的一B，判断当前的队头元素的长度到底是多长
     * 顺便和循环因子i有了联动，最终得到如下的循环过程：
     * eg. input = "23"
     * queue: "a" "b" "c" // 对length为1的元素，出队列，拼接，入队列；
     * queue: "b" "c" "ad" "ae" "af"
     * queue: "c" "ad" "ae" "af" "bd" "be" "bf"
     * queue: "ad" "ae" "af" "bd" "be" "bf" "cd" "ce" "cf"
     * 如果再有其他数字，则对length为2里的队列元素，继续出队列，拼接，再入队列
     *
     * 不过标答都不太关心边界条件和异常输入的问题，这个还是按照自己的思路去走吧
     * LeetCode上的边界条件输入和输出有点奇怪，比如输入字符串为""时我倒觉得输出""挺好的，其实不然。
     * 算了，这都是小问题
     */

    public List<String> letterCombinationsBFS(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for(int i =0; i<digits.length();i++){
            int x = Character.getNumericValue(digits.charAt(i));
            while(ans.peek().length()==i){
                String t = ans.remove();
                for(char s : mapping[x].toCharArray())
                    ans.add(t+s);
            }
        }
        return ans;
    }

    public List<String> letterCombinationsDFS(String digits) {
        List<String> ret = new LinkedList<String>();
        combination("", digits, 0, ret);
        return ret;
    }

    private static final String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    private void combination(String prefix, String digits, int offset, List<String> ret) {
        if (offset >= digits.length()) {
            ret.add(prefix);
            return;
        }
        String letters = KEYS[(digits.charAt(offset) - '0')];
        for (int i = 0; i < letters.length(); i++) {
            combination(prefix + letters.charAt(i), digits, offset + 1, ret);
        }
    }
}
