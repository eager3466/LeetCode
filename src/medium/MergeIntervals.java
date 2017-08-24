package medium;

import data.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Eager-RESCUER on 2017/7/31.
 */
public class MergeIntervals {

//    Given a collection of intervals, merge all overlapping intervals.
//
//    For example,
//    Given [1,3],[2,6],[8,10],[15,18],
//            return [1,6],[8,10],[15,18].

    public List<Interval> merge(List<Interval> intervals) {

        if (intervals == null || intervals.size() == 0)
            return new ArrayList<Interval>();
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        for (int i = 1; i < intervals.size(); i++) {
            Interval pre = intervals.get(i - 1);
            Interval cur = intervals.get(i);
            if (pre.end >= cur.start) {
                Interval newInter = new Interval(pre.start, Math.max(pre.end, cur.end));
                intervals.remove(pre);
                intervals.remove(cur);
                intervals.add(i - 1, newInter);
                i--;
            }
        }
        return intervals;
    }

    /**
     * 也是比较容易的一题，可以通过增加一个O(n)的空间复杂度，用一个ArrayList来控制加入每一段的元素
     *
     * 我写的方法比较耗时，毕竟在ArrayList中remove操作是要有O(n)的时间复杂度的
     * 但好处就是不用extra space
     *
     * 标答的形式更好，用全局的start和end来控制，使得代码更concise and elegant
     */

//    public List<Interval> merge(List<Interval> intervals) {
//        if (intervals.size() <= 1)
//            return intervals;
//
//        // Sort by ascending starting point using an anonymous Comparator
//        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
//
//        List<Interval> result = new LinkedList<Interval>();
//        int start = intervals.get(0).start;
//        int end = intervals.get(0).end;
//
//        for (Interval interval : intervals) {
//            if (interval.start <= end) // Overlapping intervals, move the end if needed
//                end = Math.max(end, interval.end);
//            else {                     // Disjoint intervals, add the previous one and reset bounds
//                result.add(new Interval(start, end));
//                start = interval.start;
//                end = interval.end;
//            }
//        }
//
//        // Add the last interval
//        result.add(new Interval(start, end));
//        return result;
//    }

}
