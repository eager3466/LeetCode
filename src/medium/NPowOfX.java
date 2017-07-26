package medium;

/**
 * Created by eager-mbp on 2017/7/26
 */
public class NPowOfX {

//    Implement pow(x, n).

    public double myPow(double x, int n) {
        if(n<0) return 1/x * myPow(1/x, -(n+1));
        if(n==0) return 1;
        if(n==2) return x*x;
        if(n%2==0) return myPow( myPow(x, n/2), 2);
        else return x*myPow( myPow(x, n/2), 2);
    }

    /**
     * 瓦日，48个赞110个踩的nc题目我也是懒得吐槽了，估计也就考了个个二分的分治思想了
     */
}
