package medium;

/**
 * Created by eager-mbp on 2017/6/27.
 */
public class StringToInteger {

    public static int myAtoi(String str) {
        if(str== null || str.equals("") || str.equals("-") || str.equals("+"))
            return 0;
        int sgn = 1;  // 符号位
        int start = 0;  // 起始位
        if (str.startsWith("-")) {
            sgn = -1;
            start = 1;
        }
        if (str.startsWith("+")) {
            sgn = 1;
            start = 1;
        }
        if (start == 1) {
            if (str.charAt(1)>'9' || str.charAt(1)<'0'){
                return 0;
            }
        }
        // 跳过前置的0；若前面都是0，则返回最后一位的数值
        while (str.charAt(start) == '0' && start < str.length()-1) start++;
        if(start == str.length()-1)
            return getInt(str.charAt(start)) * sgn;

        // 此时start所在位为第一个前置非0位
        // times用于控制每走一位数增加的倍数
        int times = 10;
        int res = 0;
        while (start < str.length()) {
            res = res * times + getInt(str.charAt(start));
            if (res > Integer.MAX_VALUE) {
                return 0;
            }
            start++;
        }
        res = res * sgn;
        return res;
    }

    public static int getInt(char c) {
        return Character.digit(c, 10);
    }

    /**
     * 字符串转化为整数，一开始我考虑的是以下几点：
     * 我以为输入总会是一个合法的数字，所以想到：
     * 1.前置为的0我 要处理掉
     * 2.符号位要处理以下
     * 3.考虑到溢出（overflow)问题，对Integer.MAX_VALUE和Integer.MIN_VALUE进行判断
     *
     * 事实上，前置位的0根本不用去管，因为读一位乘以10，0位再多也并不往总数上加，所以应该不予考虑；
     * 我没有想到前置的符号位还可以有+-，-+的前置，甚至输入内容就是"+-"或"-+"，这个有待考察；
     * 正如byte范围是 -128~127一样，最大值和最小值这里有很多边界值的case值得注意，包括位数上都溢出的都算。
     *
     * 【必须要吐槽自己一点】数字char转int我居然还tm造了一个函数……明摆着str.charAt(i) - '0'就可以了
     */

    /**
     * AC的答案考虑到了更多：
     * 1.前置位空格（可手动处理，可用trim()处理）
     * 2.符号位处理（这个没的说）
     * 3.溢出（这个回来完全琢磨清楚之后会重新写一遍再submit）
     * 4.非法输入，写着写着出来个0-9之外的数字，其实这个题目也没有叙述清楚，应该是立刻返回异常之前的数字
     */

//    public static int myAtoi(String str) {
//        if (str.isEmpty()) return 0;
//        int sign = 1, base = 0, i = 0;
//        while (str.charAt(i) == ' ')
//            i++;
//        if (str.charAt(i) == '-' || str.charAt(i) == '+')
//            sign = str.charAt(i++) == '-' ? -1 : 1;
//        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
//            if (base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > 7)) {
//                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
//            }
//            base = 10 * base + (str.charAt(i++) - '0');
//        }
//        return base * sign;
//    }


    // Retry for the problem
    public static int myAtoik(String str) {
        if(str == null || str.equals(""))
            return 0;

        // Deal extra front space
        str = str.trim();
        int sgn = 1;  // 符号位
        int index = 0;  // 指针位

        // Deal with the sign
        if (str.charAt(index) == '-' || str.charAt(index) == '+') {
            sgn = (str.charAt(index) == '-') ? -1 : 1;
            index ++;
        }

        int res = 0;
        // Start iteration
        while (index < str.length()) {
            // Invalid input
            if (str.charAt(index) > '9' || str.charAt(index) < '0')
                return res * sgn;

            // Deal with overflow
            int digit = str.charAt(index) - '0';
            if (res > Integer.MAX_VALUE / 10 ||
                    res == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10) {
                return (sgn == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 +  digit;
            index++ ;
        }
        res = res * sgn;
        return res;
    }
}