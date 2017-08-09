package medium;

import java.util.*;

/**
 * Created by Eager-RESCUER on 2017/8/3
 */
public class SimplifyPath {

//    Given an absolute path for a file (Unix-style), simplify it.
//
//    For example,
//            path = "/home/", => "/home"
//    path = "/a/./b/../../c/", => "/c"
//    click to show corner cases.
//
//    Corner Cases:
//    Did you consider the case where path = "/../"?
//            In this case, you should return "/".
//    Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
//    In this case, you should ignore redundant slashes and return "/home/foo".

    public String simplifyPath(String path) {
        StringBuilder res = new StringBuilder();
        String[] intervals = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String str : intervals) {
            if (!str.equals("") && !str.equals(".") && !str.equals("..")) {
                stack.push(str);
            } else {
                if (str.equals("..") && !stack.isEmpty())
                    stack.pop();
            }
        }
        for (String str : stack) {
            res.append('/');
            res.append(str);
        }
        return res.toString().equals("") ? "/" : res.toString();
    }

    /**
     * 用了一点耐心来面对这个题，结果让我失望了，目录里有一个"."的无意义字段也就算了
     * 还有"..."这样的不让去掉，这也太傻比了，比如输入"/abc/..."要求输出"/abc/..."，无语……
     *
     * 群众给低分肯定是有原因的啊，我还是把时间多花在更需要做的题上吧。
     */

//    public String simplifyPath(String path) {
//        Deque<String> stack = new LinkedList<>();
//        Set<String> skip = new HashSet<>(Arrays.asList("..",".",""));
//        for (String dir : path.split("/")) {
//            if (dir.equals("..") && !stack.isEmpty()) stack.pop();
//            else if (!skip.contains(dir)) stack.push(dir);
//        }
//        String res = "";
//        for (String dir : stack) res = "/" + dir + res;
//        return res.isEmpty() ? "/" : res;
//    }

}
