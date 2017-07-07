package medium;

import java.util.ArrayList;

/**
 * Created by eager-mbp on 2017/6/27.
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if (s.length() <= numRows || numRows == 1) {
            return s;
        }
        // 之字形分两个阶段：竖着向下和斜着向右上，这两个阶段凑成一轮处理
        int total = s.length();
        ArrayList<ArrayList<Character>> lineList = new ArrayList<>();
        for (int i=0; i<numRows; i++) {
            ArrayList<Character> list = new ArrayList<>();
            lineList.add(list);
        }
        int i = 0;
        // 剩下字符长度还够一轮处理时，处理当轮
        while (total > 2*numRows - 2) {
            // 处理直线部分
            for (int j = 0; j < numRows; j++) {
                lineList.get(j).add(s.charAt(i+j));
            }
            i += numRows;
            // 右上斜线部分
            for (int j = 1; j < numRows-1; j++) {
                lineList.get(numRows-1-j).add(s.charAt(i+j-1));
            }
            total -= (2*numRows - 2);
            i += (numRows - 2);
        }

        // 剩下的部分最多一竖行加一个斜着右上
        if (total <= numRows) {
            // 只有一个竖行
            for (int j = 0; j < total; j++) {
                lineList.get(j).add(s.charAt(i+j));
            }
        } else {
            // 先搞定竖行
            for (int j = 0; j < numRows; j++) {
                lineList.get(j).add(s.charAt(i+j));
            }
            total -= numRows;
            i += numRows;
            // 再搞定右上斜线部分，处理最后剩余的total个字符
            for (int j = 1; j < total+1; j++) {
                lineList.get(numRows-1-j).add(s.charAt(i+j-1));
            }
        }
        StringBuilder builder = new StringBuilder(s.length());
        for (ArrayList<Character> list: lineList) {
            for (char c: list) {
                builder.append(c);
            }
        }
        return builder.toString();
    }

    /**
     * 这道题倒是不很难，就是对坐标的计算非常的细腻，各种边界值和下标需要一点一点扣
     * 我是用多个ArrayList来储存，然后连接在一起的。
     *
     * 后来想想自己的i和total实际上是一个变量，当前的i走到某个位置，自然说明total还剩下多少
     * 最优最快的解法就是直接操作数组，赋值，控制好下标。
     *
     * 这道题比较考验基本功，但我没有太多时间去想，只好先这样了。
     */

//    public class Solution {
//        public String convert(String s, int numRows) {
//            if (numRows == 1) {
//                return s;
//            }
//            int len = s.length();
//            StringBuilder sb = new StringBuilder();
//            char[] chars = s.toCharArray();
//            for (int i = 0; i < numRows; i++) {
//                for (int j = i; j < len; j += 2 * numRows - 2) {
//                    if (i == 0 || i == numRows - 1) {
//                        sb.append(chars[j]);
//                    } else {
//                        sb.append(chars[j]);
//                        if (j + 2 * numRows - 2 - 2 * i < len) {
//                            sb.append(chars[j + 2 * numRows - 2 - 2 * i]);
//                        }
//                    }
//                }
//            }
//            return sb.toString();
//        }
//    }
}
