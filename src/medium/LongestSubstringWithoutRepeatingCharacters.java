package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * Created by eager-mbp on 2017/6/19.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        if (s==null || s.length()==0)   return 0;
        HashMap<Character, Integer> map = new HashMap<>();
            int i = 0;
            while (i < s.length()) {
                while (!map.containsKey(s.charAt(i))) {
                    map.put(s.charAt(i), i);
                    if (i+1 < s.length()) {
                        i++;
                    }
                    if (map.size() > res) {
                        res = map.size();
                    }
                }
                // Get the previous one
                int preIndex = map.get(s.charAt(i));
                ArrayList<Character> delist = new ArrayList<>();
                for (char ch : map.keySet()) {
                    if (map.containsKey(ch)) {
                        if (map.get(ch) <= preIndex) {
                            delist.add(ch);
                        }
                    }
                }
                for (Character c: delist) {
                    map.remove(c);
                }
                map.put(s.charAt(i), i);
                i++;
            }

        return res;
    }

    /**
     * 官方解法：sliding windows
     * 用i和j来表示窗口的左端和右端
     * 其实我一开始想到的思路已经比较接近了，但还是没有想到用两个指针来指着两端
     * 导致最后一个test case过不了，那是一个长度为3w的字符串，还包含有了大量的重复
     *
     * 这个Sliding Window的最大优点就是可以决定i和j到底哪个往前进
     * 当出现重复字符的时候，可以i往前走一个而j不用动，再次进行循环
     * 而这一点则是我考虑良久都没有解决的
     */

    /**
    public class Solution {
        public int lengthOfLongestSubstring(String s) {
            int n = s.length();
            Set<Character> set = new HashSet<>();
            int ans = 0, i = 0, j = 0;
            while (i < n && j < n) {
                // try to extend the range [i, j]
                if (!set.contains(s.charAt(j))){
                    set.add(s.charAt(j++));
                    ans = Math.max(ans, j - i);
                }
                else {
                    set.remove(s.charAt(i++));
                }
            }
            return ans;
        }
    }
    */

    /**
     * 更优化的Sliding Window
     *
     public class Solution {
        public int lengthOfLongestSubstring(String s) {
            int n = s.length(), ans = 0;
            Map<Character, Integer> map = new HashMap<>(); // current index of character
            // try to extend the range [i, j]
            for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
            }
            return ans;
         }
     }
     */
}
