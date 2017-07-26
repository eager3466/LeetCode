package hard;

/**
 * Created by eager-mbp on 2017/7/24.
 */
public class WildcardMatching {

//    Implement wildcard pattern matching with support for '?' and '*'.
//
//            '?' Matches any single character.
//            '*' Matches any sequence of characters (including the empty sequence).
//
//    The matching should cover the entire input string (not partial).
//
//    The function prototype should be:
//    bool isMatch(const char *s, const char *p)
//
//    Some examples:
//    isMatch("aa","a") ? false
//    isMatch("aa","aa") ? true
//    isMatch("aaa","aa") ? false
//    isMatch("aa", "*") ? true
//    isMatch("aa", "a*") ? true
//    isMatch("ab", "?*") ? true
//    isMatch("aab", "c*a*b") ? false

    public boolean isMatch(String s, String p) {
        boolean[][] state = new boolean[s.length() + 1][p.length() + 1];
        state[0][0] = true;
        for (int j = 0; j < p.length(); j++) {
            if (p.charAt(j) == '*') {
                state[0][j+1] = state[0][j];
            }
            // else state[0][j+1] = false as default
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                // Both these are characters
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
                    state[i+1][j+1] = state[i][j];
                }
                if (p.charAt(j) == '*') {
                    state[i+1][j+1] = state[i+1][j] || state[i][j+1];
                }
            }
        }
        return state[s.length()][p.length()];
    }

    /**
     * 苦思冥想把这道DP题做出来了！！虽然参考了之前的题目，也看了一眼答案里的关键步骤
     * 但感觉还是不错的，这个思路还是比原来更加有了一些，关键是要用二维boolean数组来做这个
     * KEY: 1.赋初值    2.循环的时候对特殊字符进行准确的判断赋值
     */

//    public boolean isMatch(String s, String p) {
//        boolean[][] match=new boolean[s.length()+1][p.length()+1];
//        match[s.length()][p.length()]=true;
//        for(int i=p.length()-1;i>=0;i--){
//            if(p.charAt(i)!='*')
//                break;
//            else
//                match[s.length()][i]=true;
//        }
//        for(int i=s.length()-1;i>=0;i--){
//            for(int j=p.length()-1;j>=0;j--){
//                if(s.charAt(i)==p.charAt(j)||p.charAt(j)=='?')
//                    match[i][j]=match[i+1][j+1];
//                else if(p.charAt(j)=='*')
//                    match[i][j]=match[i+1][j]||match[i][j+1];
//                else
//                    match[i][j]=false;
//            }
//        }
//        return match[0][0];
//    }
}
