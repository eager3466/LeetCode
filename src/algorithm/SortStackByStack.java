package algorithm;

import java.util.Stack;

/**
 * Created by eager-mbp on 2018/10/2.
 */
public class SortStackByStack {

    public static void main(String[] args) {

        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(4);
        s.push(2);
        s.push(6);
        s.push(7);
        s.push(3);
        s.push(6);
        s.push(9);
        sortStackByStack(s);
        // 这相当于从底到顶输出stack了……
        for (Integer i : s) {
            System.out.println(i);
        }
    }

    public static void sortStackByStack(Stack<Integer> stack) {

        if (stack == null || stack.isEmpty()) {
            return ;
        }
        Stack<Integer> help = new Stack<>();
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            while (!help.isEmpty() && cur > help.peek()) {
                stack.push(help.pop());
            }
            help.push(cur);
        }
        while (!help.isEmpty()) {
            stack.push(help.pop());
        }
    }
}
