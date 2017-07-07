package hard;

/**
 * Created by eager-mbp on 2017/6/22.
 */
public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] a = nums1;
        int[] b = nums2;
        int m = a.length;
        int n = b.length;
        if (m > n) {
            a = nums2;
            b = nums1;
            m = a.length;
            n = b.length;
        }
        int imin = 0;
        int imax = m;
        int i,j;
        int max_left;
        int min_right;
        while (imin <= imax) {
            i = (imin + imax) / 2;
            j = (m + n + 1) / 2 - i;
            // 注：该边界条件不允许大于等于
            if (i > 0 && a[i-1] > b[j]) {
                imax = i-1;
            } else if(i < m && b[j-1] > a[i]) {
                imin = i+1;
            } else {
                // Perfect i for solution
                // Actually means
                // (i==m || j==0 || a[i] >= b[j-1]) && (i==0 || j==n || a[i-1] <= b[j]

                //注：这里边界条件时，两边的分界值不是a[m-1]和b[n-1]
                //而是a[i-1]和b[j-1]
                if (i==0) {
                    max_left = b[i-1];
                } else if (j==0) {
                    max_left = a[j-1];
                } else {
                    max_left = Math.max(a[i-1], b[j-1]);
                }
                if ((m+n)%2 == 1) {
                    return max_left;
                }

                if (i==m) {
                    min_right = b[j];
                } else if(j==n) {
                    min_right = a[i];
                } else {
                    min_right = Math.min(a[i], b[j]);
                }

                return (max_left + min_right) / 2.0;
            }
        }
        return 0;
    }

}