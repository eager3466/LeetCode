package hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by eager-mbp on 2017/7/12.
 */
public class SubstringWithConcatenationOfAllWords {

//    You are given a string, s, and a list of words, words, that are all of the same length.
//    Find all starting indices of substring(s) in s that is a concatenation of each word in
//    words exactly once and without any intervening characters.
//
//    For example, given:
//    s: "barfoothefoobarman"
//    words: ["foo", "bar"]
//
//    You should return the indices: [0,9].
//            (order does not matter).

    public List<Integer> findSubstring(String s, String[] words) {
        if (s == null) return null;
        List<Integer> res = new ArrayList<>();
        if (words.length == 0)  return res;
        Map<String, Integer> mapper = new HashMap<>(words.length);
        // Initialize words mapper
        for (String word: words)
            mapper.put(word, mapper.containsKey(word)? mapper.get(word) + 1 : 1);

        int count = words.length;

        return null;
    }

    /**
     * 这个题的标答可读性有些差，先放下，不好理解。
     * 解题思想还是能理得通的，和sliding window是一样的思路，只是这里需要用一些数据结构来存储那些words的索引而已。
     */
}

