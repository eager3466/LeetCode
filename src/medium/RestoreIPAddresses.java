package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eager-mbp on 2017/8/21.
 */
public class RestoreIPAddresses {

//    Given a string containing only digits, restore it by returning all possible
//    valid IP address combinations.
//
//    For example:
//    Given "25525511135",
//
//            return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        backtracking(res, new StringBuilder(), 0, s, 0);
        return res;
    }

    private void backtracking(List<String> res, StringBuilder sb,
                              int idx, String s, int n) {
        if (n > 4) {
            return ;
        }
        if (n == 4 && idx == s.length()) {
            res.add(sb.toString());
        }
        for (int i = 1; i <= 3; i++) {
            if (idx + i > s.length())
                break;
            String tmpStr = s.substring(idx, idx + i);
            // 这个判断条件是得好好想想
            if (tmpStr.length() > 1 && tmpStr.startsWith("0") ||
                    i == 3 && Integer.parseInt(tmpStr) > 255)
                continue;
            int builderLen = sb.length();
            backtracking(res, sb.append(tmpStr).append(n==3 ? "" : "."),
                    idx+i, s, n+1);
            sb.setLength(builderLen);
        }
    }

    /**
     * 这道题又巩固了一下自己对DFS和Backtracking的认知：
     *
     * Backtracking是一种更普遍的算法，毕竟把一个元素添加进去之后，进行递归，然后再去除掉
     * BFS就是在一个节点起，对图的一种遍历，从这个角度来说，Backtracking是根节点不同的多次DFS
     *
     * 本题实质上是Backtracking，用idx来记录当前的坐标，在s中不断截取
     * 判断条件成立的时候，一方面idx要到位，另一方面个数也要足够
     *
     * 如果递归的参数里用String来保存当前情况，用"+"来拼接字符串，那就不用显式地删除掉之前添加的元素
     *
     * 如果用StringBuilder来添加和删除，添加好说，删除的话，可以先记录添加前的长度
     * 再用sb.setLength(builderLen)来删除之前添加的内容
     */

    /**
     * 当然了，此题也可以用暴力循环来解，为了确保"010"被解析成"10"而造成结果错误
     * 需要对整个内容进行长度上的检验，看看结果是不是只是比原来多了三个作为分隔符的"."
     */

//    // c++  code
//    vector<string> restoreIpAddresses(string s) {
//        vector<string> ret;
//        string ans;
//
//        for (int a=1; a<=3; a++)
//            for (int b=1; b<=3; b++)
//                for (int c=1; c<=3; c++)
//                    for (int d=1; d<=3; d++)
//                        if (a+b+c+d == s.length()) {
//                            int A = stoi(s.substr(0, a));
//                            int B = stoi(s.substr(a, b));
//                            int C = stoi(s.substr(a+b, c));
//                            int D = stoi(s.substr(a+b+c, d));
//                            if (A<=255 && B<=255 && C<=255 && D<=255)
//                                if ( (ans=to_string(A)+"."+to_string(B)+"."+to_string(C)+"."+to_string(D)).length() == s.length()+3)
//                                    ret.push_back(ans);
//                        }
//
//        return ret;
//    }
}
