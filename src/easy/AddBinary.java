package easy;

/**
 * Created by Eager-RESCUER on 2017/8/3.
 */
public class AddBinary {

//    Given two binary strings, return their sum (also a binary string).
//
//    For example,
//    a = "11"
//    b = "1"
//    Return "100".

    public String addBinary(String a, String b) {
        StringBuilder sb;
        if (a == null || b == null)
            return null;
        int m = a.length();
        int n = b.length();
        if (m == 0 && n == 0) {
            return null;
        } else if (m == 0){
            return b;
        } else if (n == 0) {
            return a;
        } else {
            int len = Math.max(m, n);
            sb = new StringBuilder(len + 1);
            int carry = 0;
            while (len-- > 0) {
                int numA = (--m >= 0) ? (a.charAt(m) - '0') : 0;
                int numB = (--n >= 0) ? (b.charAt(n) - '0') : 0;
//                m-- > 0 && n-- > 0
                int sum = numA + numB + carry;
                sb.insert(0,sum % 2);
                if (sum >= 2) {
                    carry = 1;
                } else {
                    carry = 0;
                }
            }
            if (carry == 1)
                sb.insert(0, carry);
        }
        return sb.toString();
    }

    /**
     * 简单一题了，就要有一遍写对的能力。
     *
     * 因为不知道StringBuilder有reverse()这样的函数，所以自己每次都需要insert(0, x)
     * 效率估计低了不少
     *
     * 和标答比起来，用的变量有点多，也是因为思考时间没有那么多
     * 确实如其所述，如果下标不够用了到头了，明明可以不往sum上加嘛
     *
     * 而且while (i >= 0 || j >= 0) 要比 while(maxLen-- > 0) 要好不少
     * 这个需要记忆下来
     */

//    public String addBinary(String a, String b) {
//        StringBuilder sb = new StringBuilder();
//        int i = a.length() - 1, j = b.length() -1, carry = 0;
//        while (i >= 0 || j >= 0) {
//            int sum = carry;
//            if (j >= 0) sum += b.charAt(j--) - '0';
//            if (i >= 0) sum += a.charAt(i--) - '0';
//            sb.append(sum % 2);
//            carry = sum / 2;
//        }
//        if (carry != 0) sb.append(carry);
//        return sb.reverse().toString();
//    }
}
