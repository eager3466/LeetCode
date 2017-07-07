package easy;

/**
 * Created by eager-mbp on 2017/7/4.
 */
public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 1)
            return strs[0];
        int shortest = Integer.MAX_VALUE;
        String res = "";
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < shortest) {
                res = strs[i];
                shortest = strs[i].length();
            }
        }
        int end = 0;
        boolean flag = true;
        int i;
        for (i=0; i<res.length(); i++) {
            char current = res.charAt(i);
            for (String str: strs) {
                if (!str.equals(res)) {
                    if (str.charAt(i) != current) {
                        end = i;
                        flag = false;
                        break;
                    }
                }
            }
            if(!flag) break;
        }
        if (i==res.length())
            end = i;
        if (flag)
            end = res.length();
        return res.substring(0, end);
    }

    /**
     * 获取多个字符串的最长前置子串。
     *
     * 显然top-answer比我的想法好得多也容易得多，将字符串排序，则第一个和最后一个的交集就是最短公共子串；
     * 而且人家用StringBuilder来构造答案，速度必然会块很多。
     *
     * 看来思路比动手更重要，多想一会，找到问题的实质才是王道。
     */

//    public String longestCommonPrefix(String[] strs) {
//        if(strs.length==0) return "";
//        Arrays.sort(strs);
//        char[] first=strs[0].toCharArray();
//        char[] last=strs[strs.length-1].toCharArray();
//        StringBuilder sb = new StringBuilder();
//        for(int i=0;i<first.length;i++){
//            if(first[i]==last[i]) sb.append(first[i]);
//            else break;
//        }
//        return sb.toString();
//    }
}
