package medium;

/**
 * Created by eager-mbp on 2017/7/4.
 */
public class IntegerToRoman {
    public String intToRoman(int num) {
        String M[] = {"", "M", "MM", "MMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
    }

    /**
     * GTMD leetcode，这道题就是纯粹为了弄个词典，前提是你要知道罗马数字怎么表示……
     * 唯一需要注意的是题目里需要表示的数字为1-3999，M那一栏最多就到MMM了
     *
     * 但是这个代码表现得简洁、优雅、易懂，值得一看
     */
}
