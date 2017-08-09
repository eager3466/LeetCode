package easy;

/**
 * Created by Eager-RESCUER on 2017/8/1.
 */
public class LengthOfLastWord {

//    Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
//            return the length of last word in the string.
//
//    If the last word does not exist, return 0.
//
//    Note: A word is defined as a character sequence consists of non-space characters only.
//
//            For example,
//    Given s = "Hello World",
//    return 5.

    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0)
            return 0;
        s = s.trim();
        int res = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            if (s.charAt(i) != ' ')
                res++;
            else
                break;
        }
        return res;
    }

    /**
     * 凑数题大概……
     * 随便一写吧，还有一行搞定的函数呢
     * 不过如果一行写完的话，也会被考察trim()和lastIndexOf()函数的实现
     * 就这吧，反正这俩函数实现一点也不难
     */

//    public int lengthOfLastWord(String s) {
//        return s.trim().length()-s.trim().lastIndexOf(" ")-1;
//    }
}
