package hard;

/**
 * Created by Eager-RESCUER on 2017/8/8
 */
public class ScrambleString {

//    https://leetcode.com/problems/scramble-string/description/

    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        if (s1.equals(s2))
            return true;
        int[] count = new int[256];
        for (int i = 0; i < s1.length(); i++)
            count[s1.charAt(i) - 'a']++;
        for (int i = 0; i < s2.length(); i++)
            count[s2.charAt(i) - 'a']--;
        for (int i = 0; i < count.length; i++)
            if (count[i] != 0)
                return false;

        for (int i = 1; i < s1.length(); i++) {
            if (isScramble(s1.substring(0,i), s2.substring(0, i))
                    && isScramble(s1.substring(i), s2.substring(i)) ||
                    isScramble(s1.substring(0,i), s2.substring(s2.length() - i))
                            && isScramble(s1.substring(i), s2.substring(0,s2.length() - i))) {
                return true;
            }
        }
        return false;
    }

    /**
     * 这是一道考递归的好题！
     *
     * 猛一看觉得很懵，但发现"循环+子串"这样的模式来判断是可行的，而且思路非常简单
     *
     * 分段截取，判断，然后遍历所有情况就行，时间复杂度应该是O(4^n)
     * 把容易得到结果的判断放前面
     * if (s1.length() != s2.length())
        return false;
        应该能加快整体进度（更多的时候这个循环都是长度不相等的）
     */
}
