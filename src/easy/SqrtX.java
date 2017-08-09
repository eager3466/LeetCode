package easy;

/**
 * Created by Eager-RESCUER on 2017/8/3.
 */
public class SqrtX {

//    Implement int sqrt(int x).
//
//    Compute and return the square root of x.

    public int mySqrt(int x) {
        long r = x;
        while (r*r > x)
            r = (r + x/r) / 2;
        return (int) r;
    }

    /**
     * 51-70题的凑数题也太多了吧，这明显是一个数学题
     * 牛顿法求平方根，如果不知道的根本就是抓瞎了……
     *
     * 当然了，也可以用二分法来解这个，不过right不用到Integer.MAX_VALUE这么大
     * 到x就行了
     */

//    public int sqrt(int x) {
//        if (x == 0)
//            return 0;
//        int left = 1, right = Integer.MAX_VALUE;
//        while (true) {
//            int mid = left + (right - left)/2;
//            if (mid > x/mid) {
//                right = mid - 1;
//            } else {
//                if (mid + 1 > x/(mid + 1))
//                    return mid;
//                left = mid + 1;
//            }
//        }
//    }
}
