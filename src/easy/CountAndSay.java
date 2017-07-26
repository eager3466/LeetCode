package easy;

/**
 * Created by eager-mbp on 2017/7/22.
 */
public class CountAndSay {

//    The count-and-say sequence is the sequence of integers with the first five terms as following:
//
//            1.     1
//            2.     11
//            3.     21
//            4.     1211
//            5.     111221
//            1 is read off as "one 1" or 11.
//            11 is read off as "two 1s" or 21.
//            21 is read off as "one 2, then one 1" or 1211.
//    Given an integer n, generate the nth term of the count-and-say sequence.
//
//    Note: Each term of the sequence of integers will be represented as a string.
//
//            Example 1:
//
//    Input: 1
//    Output: "1"
//    Example 2:
//
//    Input: 4
//    Output: "1211"

    public String countAndSay(int n) {
        if (n <= 0)
            return null;
        String res = "1";
        if (n == 1)
            return res;

        // do n-1 loop
        n = n - 1;
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            // clean StringBuilder
            sb.setLength(0);
            for (int i = 0; i < res.length(); ) {
                // j-i means the length of same character
                int j = i;
                while (j+1 < res.length() && res.charAt(j+1) == res.charAt(j)) {
                    j++;
                }
                sb.append(j-i+1);
                sb.append(res.charAt(j));
                i = j+1;
            }
            res = sb.toString();
        }
        return res;
    }

    /**
     * 没啥好说的，easy题，数数的呗，一次写过了。
     */
}
