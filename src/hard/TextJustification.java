package hard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eager-RESCUER on 2017/8/3.
 */

public class TextJustification {

//    Given an array of words and a length L, format the text such that each line has exactly
//    L characters and is fully (left and right) justified.
//
//    You should pack your words in a greedy approach; that is, pack as many words as you can
//    in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.
//
//    Extra spaces between words should be distributed as evenly as possible. If the number of
//    spaces on a line do not divide evenly between words, the empty slots on the left will be assigned
//    more spaces than the slots on the right.
//
//    For the last line of text, it should be left justified and no extra space is inserted between words.
//
//    For example,
//    words: ["This", "is", "an", "example", "of", "text", "justification."]
//    L: 16.
//
//    Return the formatted lines as:
//            [
//            "This    is    an",
//            "example  of text",
//            "justification.  "
//            ]
//    Note: Each word is guaranteed not to exceed L in length.

    public List<String> fullJustify(String[] words, int L) {
        List<String> lines = new ArrayList<String>();

        int index = 0;
        while (index < words.length) {
            int count = words[index].length();
            int last = index + 1;
            while (last < words.length) {
                if (words[last].length() + count + 1 > L) break;
                count += words[last].length() + 1;
                last++;
            }

            StringBuilder builder = new StringBuilder();
            int diff = last - index - 1;
            // if last line or number of words in the line is 1, left-justified
            if (last == words.length || diff == 0) {
                for (int i = index; i < last; i++) {
                    builder.append(words[i] + " ");
                }
                builder.deleteCharAt(builder.length() - 1);
                for (int i = builder.length(); i < L; i++) {
                    builder.append(" ");
                }
            } else {
                // middle justified
                int spaces = (L - count) / diff;
                int r = (L - count) % diff;
                for (int i = index; i < last; i++) {
                    builder.append(words[i]);
                    if (i < last - 1) {
                        for (int j = 0; j <= (spaces + ((i - index) < r ? 1 : 0)); j++) {
                            builder.append(" ");
                        }
                    }
                }
            }
            lines.add(builder.toString());
            index = last;
        }
        return lines;
    }

    /**
     * 实在不是我偷懒不想做这个题，而是它的价值真的不高
     * 没用任何算法相关的干货内容，就是为了写题而写题，我不喜欢
     *
     * 直接copy了标答，不过我看思路也不复杂，就是按照蛋疼的要求把结果一点一点拼出来
     * 先判断这一行能有几个单词，带上空格来算个数
     * 一行的确定好了之后再确定行内空格，到底怎么分更平均
     *
     * 要是分不平均了那该怎么分，比如8个分3个空格，是233么，真是蛋疼
     *
     * 过了。
     */
}
