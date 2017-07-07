package medium;

/**
 * Created by eager-mbp on 2017/6/24.
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {

        if (s == null) return null;
        if (s.length() <= 2) {
            if (s.charAt(0) == s.charAt(1)) {
                return s;
            } else
                return s.substring(0, 1);
        }
        int maxLen = 1;
        int maxi=0, maxj=s.length()-1;
        for (int i=0; i<s.length()-maxLen; i++) {
            for (int j = s.length() - 1; j > i; j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (isPalin(s, i, j)) {
                        if (j - i + 1 >= maxLen) {
                            maxLen = j - i + 1;
                            maxi = i;
                            maxj = j;
                            break;
                        }

                    }
                }
            }
        }
        if (maxLen == 1 && maxi==0 && maxj==s.length()-1) return s.substring(0,1);
        return s.substring(maxi, maxj+1);
    }

    public boolean isPalin(String s, int i, int j) {

        while(j-i>=2) {
            if(s.charAt(i) != s.charAt(j)) return false;
            i++; j--;
        }
        if(s.charAt(i) != s.charAt(j)) return false;
        else return true;
    }

    /**
     *
     * 我的思路是两边收缩，看看一个长串是不是回文的
     * 时间效率上过得去的答案是从一个短的字符开始向两端拓展，来看回文的极限在哪里
     * 理论上来讲，它那个效率更高一些
     * 还高了不少，导致我目前这个超时了
     * 除此之外还看了一个最好的算法了应该是。。。。会智能的找到一个最合适的地方去拓展
     * 而且它这个思想是，重复的字符可以作为拓展的中心，无论数量是奇是偶
     * 也就是处理"aaaaaaaaa"这样的字符串效率可以达到O(N)
     * 而"ababababababa"这样的字符串才会达到最差的O(N*N)
     * 而且它循环的时候使用了3个指针i,j,k，其中i=k+1可以大大加快对相同字符的处理迭代
     */


    /**
     * 精髓有几处： if (s.size() - i <= max_len / 2) break;
     * max_len / 2 很有讲究的，意思你剩下的位数，如果不到我当前最长回文字符串的一半的话，就不可能构成
     * 一个那么长回文串的另一半了（cababa)这样的
     * 一开始我以为是max_len，后来发现是有问题的
     */
//    string longestPalindrome(string s) {
//        if (s.empty()) return "";
//        if (s.size() == 1) return s;
//        int min_start = 0, max_len = 1;
//        for (int i = 0; i < s.size();) {
//            if (s.size() - i <= max_len / 2) break;
//            int j = i, k = i;
//            while (k < s.size()-1 && s[k+1] == s[k]) ++k; // Skip duplicate characters.
//            i = k+1;
//            while (k < s.size()-1 && j > 0 && s[k + 1] == s[j - 1]) { ++k; --j; } // Expand.
//            int new_len = k - j + 1;
//            if (new_len > max_len) { min_start = j; max_len = new_len; }
//        }
//        return s.substr(min_start, max_len);
//    }
}
