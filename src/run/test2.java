package run;

import org.json.JSONException;
import sort.QuickSort;
import org.json.JSONArray;

/**
 * Created by eager-mbp on 2017/8/25.
 */
public class test2 {

    public static void main(String[] args) {
//        System.out.println("hello world");
        boolean b = parseJSON();
        new QuickSort().sort().printResult();

    }

    public static boolean parseJSON() {
        String json = "[{\"desc\":\"开启B策略\",\"type\":\"Boolean\",\"value\":false},\n" +
                "     {\"desc\":\"设置间隔毫秒数\",\"type\":\"Int\",\"value\":100},\n" +
                "     {\"desc\":\"草稿箱标题\",\"type\":\"String\",\"value\":\"草稿箱\"},\n" +
                "     {\"desc\":\"设置弹性数值\",\"type\":\"Float\",\"value\":3.14}]";
        try {
            JSONArray array = new JSONArray(json);
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return false;

    }
}
