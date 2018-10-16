package data;

import java.util.HashSet;

/**
 * Created by eager-mbp on 2017/9/7.
 */
public class A {
    public int k;

    public A(int k) {
        this.k = k;
    }

    public  static void methodA() {
        System.out.println("null print");
    }

    public void main(String[] args) {
        //region 新建对象
        A a1 = new A(1);
        A a2 = new A(2);
        //endregion
        System.out.println(a1.equals(a2));
        HashSet hs = new HashSet();
        hs.add(a1);
        hs.add(a2);


    }
    @Override
    public boolean equals(Object obj) {
        return obj.hashCode() == this.hashCode();
        //return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return 1;
    }
}
