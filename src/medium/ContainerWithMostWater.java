package medium;

/**
 * Created by eager-mbp on 2017/7/3.
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {

        if (height.length == 0) return 0;
        int i=0, j = height.length-1;
        int maxSize = 0;
        while (i > j) {
            int size = (j-i) * Math.min(height[i], height[j]);
            if (size > maxSize)
                maxSize = size;
            if (height[i] <= height[j]) i++;
            else j--;
        }
        return maxSize;
    }

    /**
     * 表示这个题只要看懂了题干想让你干嘛的就很快能写出来了……
     */
}
