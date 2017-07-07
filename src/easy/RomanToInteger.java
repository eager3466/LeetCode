package easy;

/**
 * Created by eager-mbp on 2017/7/4.
 */
public class RomanToInteger {

    public int romanToInt(String s) {
        int res = 0;
        String M[] = {"", "M", "MM", "MMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        for (int i=M.length-1; i>0; i--)
            if (s.contains(M[i])) {
                if (i==5 && s.contains(M[i-1])) continue;
                res += 1000 * i;
                break;
            }
        for (int i=C.length-1; i>0; i--)
            if (s.contains(C[i])) {
                if (i==5 && s.contains(C[i-1])) continue;
                res += 100 * i;
                break;
            }
        for (int i=X.length-1; i>0; i--)
            if (s.contains(X[i])) {
                if (i==5 && s.contains(X[i-1])) continue;
                res += 10 * i;
                break;
            }
        for (int i=I.length-1; i>0; i--)
            if (s.contains(I[i])) {
                if (i==5 && s.contains(I[i-1])) continue;
                res += 1 * i;
                break;
            }
        return res;
    }

    /**
     * 一开始是想着用之前那道数字转罗马的字典来反着做的，从后往前匹配，应该能找到最佳的匹配
     * 但是发现坑md有点多，在排除了V，IV这个可能的坑之后，发现个位的IX和十位的X居然又重复了！
     *
     * 唉😔还是算了吧，看到正确的高票答案，都是按照常理的字典来算的
     * 依次入位，根据大小相加或者相减，无论是数组还是HashMap，道理都是这样
     */

//    public int romanToInt(String s) {
//        int nums[]=new int[s.length()];
//        for(int i=0;i<s.length();i++){
//            switch (s.charAt(i)){
//                case 'M':
//                    nums[i]=1000;
//                    break;
//                case 'D':
//                    nums[i]=500;
//                    break;
//                case 'C':
//                    nums[i]=100;
//                    break;
//                case 'L':
//                    nums[i]=50;
//                    break;
//                case 'X' :
//                    nums[i]=10;
//                    break;
//                case 'V':
//                    nums[i]=5;
//                    break;
//                case 'I':
//                    nums[i]=1;
//                    break;
//            }
//        }
//        int sum=0;
//        for(int i=0;i<nums.length-1;i++){
//            if(nums[i]<nums[i+1])
//                sum-=nums[i];
//            else
//                sum+=nums[i];
//        }
//        return sum+nums[nums.length-1];
//    }
}
