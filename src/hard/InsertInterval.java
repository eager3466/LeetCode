package hard;

import com.sun.corba.se.spi.ior.IORFactories;
import data.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eager-RESCUER on 2017/8/1.
 */
public class InsertInterval {

//    Given a set of non-overlapping intervals, insert a new interval
//    into the intervals (merge if necessary).
//
//    You may assume that the intervals were initially sorted according to their start times.
//
//    Example 1:
//    Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
//
//    Example 2:
//    Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
//
//    This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> res = new ArrayList<>();
        if (newInterval == null)
            return intervals;
        if (intervals == null || intervals.size() == 0) {
            res.add(newInterval);
            return res;
        }
        int i = -1;
        if (intervals.get(0).start > newInterval.end) {
            res.add(0, newInterval);
        } else {
            for (Interval interval : intervals) {
                if (interval.start <= newInterval.start && interval.end >= newInterval.start) {
                    i = intervals.indexOf(interval);
                    break;
                }
            }
            if (i == -1) {
                // Not found proper position to insert
                intervals.add(newInterval);
            } else {
                int end = newInterval.end;
                int j = 0;
                for (j = i; j < intervals.size(); j++) {
                    if (intervals.get(j).start > end) {
                        break;
                    } else {
                        end = Math.max(intervals.get(j).end, end);
                    }
                }
                Interval interval = new Interval(intervals.get(i).start, end);
                for (int k = 1; k <= j - i; k++) {
                    intervals.remove(i);
                }
                intervals.add(i, interval);
            }
        }
        return intervals;
    }

    /**
     * 思考时间不够多，其实这个题没什么具体的难度，只要把所有情况分清楚了就可以写出来
     * 自己少写了一种“(0,3)插入(1,5)”这样的情况
     *
     * 标答的思路更好，不过不用频繁的new Interval，而用变量将其保存起来即可，最后new一下
     * 同样是在ArrayList里进行remove操作，在第二个while里可以不用i++，因为已经remove掉了i
     *
     * 最后在i的位置再添加，这比较巧妙了
     *
     * 关键的是，他是对newInterval这个对象进行操作的，这样在迭代的同时保持了代码简介和优雅
     * 值得学习！
     */

//    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {``
//        int i=0;
//        while(i<intervals.size() && intervals.get(i).end<newInterval.start) i++;
//        while(i<intervals.size() && intervals.get(i).start<=newInterval.end){
//            newInterval = new Interval(Math.min(intervals.get(i).start, newInterval.start), Math.max(intervals.get(i).end, newInterval.end));
//            intervals.remove(i);
//        }
//        intervals.add(i,newInterval);
//        return intervals;
//    }
}
