package medium;

/**
 * Created by eager-mbp on 2017/7/12.
 */
public class DivideTwoIntegers {

//    Divide two integers without using multiplication, division and mod operator.
//
//    If it is overflow, return MAX_INT.
//
//    Comment: calculate a / b by code.

    public int divide(int dividend, int divisor) {
        if (divisor == 0 || dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1) return Integer.MIN_VALUE;
            else if (divisor == -1) return Integer.MAX_VALUE;
            // divisor must be a odd one, or it can't divide dividend.
            else return divide(dividend >> 1, divisor >> 1);
        }
        if(divisor==Integer.MIN_VALUE) return 0;
        boolean sgn = (dividend < 0) ^ (divisor < 0);
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int res = 0;
        while (dividend >= divisor) {
            int temp = divisor;
            int mult = 1;
            // 这个while很重要，迭代之前先倍增temp试一下
            while (dividend >= (temp << 1)) {
                temp <<= 1;
                mult <<= 1;
            }
            dividend -= temp;
            res += mult;
        }
        return sgn ? res : -res;
    }

    /**
     * 这道题挺考验数学思维，用位运算来代替*2或/2操作，并用减法来不断尝试迭代。
     * 但是这个c++版本的代码莫名其妙的挂了，超时
     *
     * 最后用java版本的过了，莫名其妙，感觉算法一模一样，只不过java用了堆栈
     * 可能是两者效率不一样？（笑）
     */

//    In this problem, we are asked to divide two integers. However, we are not allowed to use division, multiplication and mod operations. So, what else can we use? Yeah, bit manipulations.
//
//    Let's do an example and see how bit manipulations work.
//
//    Suppose we want to divide 15 by 3, so 15 is dividend and 3 is divisor. Well, division simply requires us to find how many times we can subtract the divisor from the the dividend without making the dividend negative.
//
//            Let's get started. We subtract 3 from 15 and we get 12, which is positive. Let's try to subtract more. Well, we shift 3 to the left by 1 bit and we get 6. Subtracting 6 from 15 still gives a positive result. Well, we shift again and get 12. We subtract 12 from 15 and it is still positive. We shift again, obtaining 24 and we know we can at most subtract 12. Well, since 12 is obtained by shifting 3 to left twice, we know it is 4 times of 3. How do we obtain this 4? Well, we start from 1 and shift it to left twice at the same time. We add 4 to an answer (initialized to be 0). In fact, the above process is like 15 = 3 * 4 + 3. We now get part of the quotient (4), with a remainder 3.
//
//    Then we repeat the above process again. We subtract divisor = 3 from the remaining dividend = 3 and obtain 0. We know we are done. No shift happens, so we simply add 1 << 0 to the answer.
//
//    Now we have the full algorithm to perform division.
//
//    According to the problem statement, we need to handle some exceptions, such as overflow.
//
//    Well, two cases may cause overflow:
//
//    divisor = 0;
//    dividend = INT_MIN and divisor = -1 (because abs(INT_MIN) = INT_MAX + 1).
//    Of course, we also need to take the sign into considerations, which is relatively easy.
//
//    Putting all these together, we have the following code.

//    if(dividend==Integer.MIN_VALUE){
//        if(divisor==-1) return Integer.MAX_VALUE;
//        else if(divisor==1)  return dividend;
//        else return ((divisor&1)==1)?divide(dividend+1,divisor):divide(dividend>>1,divisor>>1);
//    }
//    if(divisor==Integer.MIN_VALUE) return 0;

    /**
     * Accepted answer.
     */
//    public int divide(int dividend, int divisor) {
//        //Reduce the problem to positive long integer to make it easier.
//        //Use long to avoid integer overflow cases.
//        int sign = 1;
//        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
//            sign = -1;
//        long ldividend = Math.abs((long) dividend);
//        long ldivisor = Math.abs((long) divisor);
//
//        //Take care the edge cases.
//        if (ldivisor == 0) return Integer.MAX_VALUE;
//        if ((ldividend == 0) || (ldividend < ldivisor))	return 0;
//
//        long lans = ldivide(ldividend, ldivisor);
//
//        int ans;
//        if (lans > Integer.MAX_VALUE){ //Handle overflow.
//            ans = (sign == 1)? Integer.MAX_VALUE : Integer.MIN_VALUE;
//        } else {
//            ans = (int) (sign * lans);
//        }
//        return ans;
//    }
//
//    private long ldivide(long ldividend, long ldivisor) {
//        // Recursion exit condition
//        if (ldividend < ldivisor) return 0;
//
//        //  Find the largest multiple so that (divisor * multiple <= dividend),
//        //  whereas we are moving with stride 1, 2, 4, 8, 16...2^n for performance reason.
//        //  Think this as a binary search.
//        long sum = ldivisor;
//        long multiple = 1;
//        while ((sum+sum) <= ldividend) {
//            sum += sum;
//            multiple += multiple;
//        }
//        //Look for additional value for the multiple from the reminder (dividend - sum) recursively.
//        return multiple + ldivide(ldividend - sum, ldivisor);
//    }
}
