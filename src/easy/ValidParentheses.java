package easy;

import java.util.Stack;

/**
 * Created by eager-mbp on 2017/7/10.
 */
public class ValidParentheses {

//    Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
//    The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        int len = s.length();
        while (len > 0) {
            char ch = s.charAt(s.length()-len);
            switch (ch) {
                case '(':
                case '[':
                case '{':
                    stack.push(ch);
                    break;
                case ')':
                    if (stack.isEmpty()) return false;
                    if (stack.pop() != '(') return false;
                    break;
                case ']':
                    if (stack.isEmpty()) return false;
                    if (stack.pop() != '[') return false;
                    break;
                case '}':
                    if (stack.isEmpty()) return false;
                    if (stack.pop() != '{') return false;
                    break;
            }
            len--;
        }
        return stack.isEmpty();
    }

    /**
     * 简单一题，然而标答还是要比自己写的出彩不少。
     * 我的写法肯定是标准思路，但是标答的思路转换使得每次push进去的元素可以是右括号
     * 这样简洁了代码，还减少了hardcode，点赞，值得学习。
     */

//    public boolean isValid(String s) {
//        Stack<Character> stack = new Stack<Character>();
//        for (char c : s.toCharArray()) {
//            if (c == '(')
//                stack.push(')');
//            else if (c == '{')
//                stack.push('}');
//            else if (c == '[')
//                stack.push(']');
//            else if (stack.isEmpty() || stack.pop() != c)
//                return false;
//        }
//        return stack.isEmpty();
//    }
}
