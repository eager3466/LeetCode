package medium;

/**
 * Created by eager-mbp on 2017/7/24.
 */
public class MultiplyStrings {

//    Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.
//
//    Note:
//
//    The length of both num1 and num2 is < 110.
//    Both num1 and num2 contains only digits 0-9.
//    Both num1 and num2 does not contain any leading zero.
//    You must not use any built-in BigInteger library or convert the inputs to integer directly.

    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int res[] = new int[m + n];
        for (int i = m-1; i >=0; i--) {
            for (int j = n-1; j>=0; j--) {
                int p = i+j;
                int q = i+j+1;
                int temp = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + res[q];
                res[q] = temp % 10;
                res[p] += temp / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int ch : res) {
            if (!(sb.length()==0 && ch==0)) {
                sb.append(ch);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    /**
     * 有了标答的一句指点，这道题变得如此简单，事实上也就是我们小学乘法的翻版：
     *  `num1[i] * num2[j]` will be placed at indices `[i + j`, `i + j + 1]`
     *  同时有写小细节需要注意，比如两数乘积之后，要先加上那个位的数，再去运算得到结果和进位
     *  同时，要注意个位是= temp % 10，而十位是+= temp / 10;
     */
}
