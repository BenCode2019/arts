import java.util.*;

import static java.util.Comparator.comparingInt;


/**
 * 56. 合并区间
 *
 * Created by mengwei on 2019/9/17.
 */
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        List<Interval> rs = new ArrayList<Interval>();
        for (int i = 0; i < intervals.length; i++) {
            Interval interval = new Interval();
            interval.start = intervals[i][0];
            interval.end = intervals[i][1];
            rs.add(interval);
        }

        List<Interval> merge = merge(rs);
        int[][] ints = new int[merge.size()][2];
        for (int i = 0; i < merge.size(); i++) {
            Interval interval = merge.get(i);
            ints[i][0] = interval.start;
            ints[i][1] = interval.end;
        }
        return ints;
    }

    class Interval{
        int start;
        int end;
    }

    private class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval a, Interval b) {
            return a.start < b.start ? -1 : a.start == b.start ? 0 : 1;
        }
    }

    /**
     * 1 首先将数组按start进行排序。
     * 2 判断如果当前节点的左端点在上一个节点的右端点之后，就不重叠，否则 当前区间的右端点更新上一个区间的右端点。
     * @param intervals
     * @return
     */
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new IntervalComparator());

        LinkedList<Interval> merged = new LinkedList<Interval>();
        for (Interval interval : intervals) {
            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            if (merged.isEmpty() || merged.getLast().end < interval.start) {
                merged.add(interval);
            }
            // otherwise, there is overlap, so we merge the current and previous
            // intervals.
            else {
                merged.getLast().end = Math.max(merged.getLast().end, interval.end);
            }
        }

        return merged;
    }

    /**
     * 采用lambda优化排序，虽然简洁但是效率不高
     * @param intervals
     * @return
     */
    public int[][] merge2(int[][] intervals) {
        if (intervals.length == 0) {
            return intervals;
        }
        Arrays.sort(intervals, java.util.Comparator.comparingInt(a -> a[0]));
        List<int[]> res = new ArrayList<>();
        int[] temp = intervals[0];
        res.add(temp);
        for (int[] interval : intervals) {
            if (interval[0] <= temp[1]) {
                temp[1] = Math.max(temp[1], interval[1]);
            }
            else {
                temp = interval;
                res.add(temp);
            }
        }
        int n = res.size();
        return res.toArray(new int[n][]);
    }

    public static void main(String[] args) {
        int[][] in = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        int[][] merge = new MergeIntervals().merge2(in);
        for (int i = 0; i < merge.length; i++) {
            System.out.print(merge[i][0]);
            System.out.print(" ");
            System.out.print(merge[i][1]);
            System.out.println();
        }
    }
}
