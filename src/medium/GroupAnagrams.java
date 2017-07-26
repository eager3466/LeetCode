package medium;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by eager-mbp on 2017/7/26
 */
public class GroupAnagrams {

//    Given an array of strings, group anagrams together.
//
//    For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
//    Return:
//
//            [
//            ["ate", "eat","tea"],
//            ["nat","tan"],
//            ["bat"]
//            ]
//    Note: All inputs will be in lower-case.

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length == 0)
            return res;
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String sorted = String.valueOf(array);
            if (!map.keySet().contains(sorted)) {
                ArrayList<String> list = new ArrayList<>();
                list.add(str);
                map.put(sorted, list);
            } else {
                map.get(sorted).add(str);
            }
        }
        for (List list: map.values())
            res.add(list);
        return res;
    }

    /**
     * 妈的我一定要吐槽这样的题，这样的题没有解题技巧或者思路，或者数据结构上巧妙的运用
     * 只是为了解决一个问题，不过这整个过程并没有什么技术含量
     *
     * 就这吧，只当练手，一遍AC了。本来想着有什么妙招解法的，看了答案才知道是最普通的求解……
     */
}
