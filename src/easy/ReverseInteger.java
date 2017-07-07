package easy;

/**
 * Created by eager-mbp on 2017/6/27.
 */
public class ReverseInteger {

    public static int reverse(int x) {
        int res = 0;
        while (x!=0) {
            int low = x % 10;
            int temp = 10 * res + low;
            // 这里加上对溢出的判断
            // 如果不溢出，这个逆运算是显而易见会成立的
            if ((temp - low) / 10 != res) return 0;
            res = temp;
            x = x / 10;
        }
        return res;
    }

    /**
     *
     * 首先是想到这个思路，翻转一个int，因为我们无法直接获得高位，所以肯定是通过%10来一次次获得低位然后翻转
     * 第一次得到的值比较小但是并不用担心，以后每次以此为基数都乘以10就可以了，能达到反转的效果。
     *
     * 原题中让对超过32位int的数值进行检查，如果越界了就返回0。
     *
     * 看到优秀的解法里判断这个溢出的方法仅仅只是进行了依次简单的逆运算，
     * 如果有溢出的话这个逆运算明显是不成立的。
     *
     * 这点十分巧妙。
     */
}
