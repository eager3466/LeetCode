package easy;

/**
 * Created by eager-mbp on 2017/7/2.
 */
public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        if(x<0 || x>0 && x%10 == 0)
            return false;
        int res = 0;
        while(x > res) {
            res = res * 10 + x%10;
            x = x / 10;
        }
        return (x==res || x == res/10);
    }

    /**
     * 又是一道处理整数每位数的问题，几道题下来应该知道是从低位开始算起，每次%10取一个低位
     * 然后得到的结果*10，再累次叠加，还原整个数字，这期间可以与边界值相比较来处理overflow
     *
     * 回文数的特点是前后回文，看到答案的技巧就是反过来再造一个数字，循环到一半再根据原数位的
     * 奇偶性来判断是否回文，思路巧妙，用到的extra space 非常少，O(1)。
     */
}
