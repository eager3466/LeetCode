package sort;

/**
 * Created by eager-mbp on 2018/9/3.
 */
public abstract class Sort<T extends Comparable<T>> {

    public boolean less(T a, T b) {
        return a.compareTo(b) < 0;
    }

    public void swap(T[] num, int i, int j) {
        T temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }

    public abstract Sort sort();
}
