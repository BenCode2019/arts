package leecode;

import java.util.ArrayList;

/**
 *
 * 57. Insert Interval
 * 1 当当前的interval的end小于newInterval的start时，说明新的区间在当前遍历到的区间的后面，并且没有重叠，所以res添加当前的interval；
 * 2 当当前的interval的start大于newInterval的end时，说明新的区间比当前遍历到的区间要前面，并且也没有重叠，所以把newInterval添加到res里，并更新newInterval为当前的interval；
 * 3 当当前的interval与newInterval有重叠时，merge interval并更新新的newInterval为merge后的。
 * 画出图就好理解了
 * Created by mengwei on 2019/10/15.
 */
public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> arrayList = new ArrayList();
        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if(interval[1] < newInterval[0]){
                arrayList.add(interval);
            }else if(interval[0] > newInterval[1]){
                arrayList.add(newInterval);
                newInterval = interval;
                // 注意: 如果直接修改数组的话 arraylist中的数就会被修改结果就会出现重复[1,2][12,16][12,16]
                // newInterval[0] = interval[0];
                // newInterval[1] = interval[1];
            }else if(interval[1] >= newInterval[0] || interval[0] <= newInterval[1]){
                int minstart = Math.min(interval[0],newInterval[0]);
                int minend = Math.max(interval[1],newInterval[1]);
                newInterval[0] = minstart;
                newInterval[1] = minend;
            }
        }
        arrayList.add(newInterval);
        return arrayList.toArray(new int[0][0]);
    }

    /**
     * 参考 https://www.programcreek.com/2012/12/leetcode-insert-interval/
     * @param intervals
     * @param newInterval
     * @return
     */
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {

        ArrayList<Interval> result = new ArrayList<Interval>();

        for(Interval interval: intervals){
            if(interval.end < newInterval.start){
                result.add(interval);
            }else if(interval.start > newInterval.end){
                result.add(newInterval);
                newInterval = interval;
            }else if(interval.end >= newInterval.start || interval.start <= newInterval.end){
                newInterval = new Interval(Math.min(interval.start, newInterval.start), Math.max(newInterval.end, interval.end));
            }
        }
        result.add(newInterval);
        return result;
    }

    static class Interval{
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        public Interval(int nstart, int nend) {
            this.start = nstart;
            this.end = nend;
        }
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval = {4,8};
        InsertInterval insertInterval = new InsertInterval();
        int[][] insert = new InsertInterval().insert(intervals, newInterval);
        for (int i = 0; i < insert.length; i++) {
            int[] ints = insert[i];
            System.out.println(ints[0] + " " + ints[1]);
        }

        ArrayList<Interval> ints  = new ArrayList<Interval>();
        ints.add(new Interval(1,2));
        ints.add(new Interval(3,5));
        ints.add(new Interval(6,7));
        ints.add(new Interval(8,10));
        ints.add(new Interval(12,16));

//        Interval interval = new Interval(4, 8);
//        ArrayList<Interval> insert = insertInterval.insert(ints, interval);
//        for (Interval i:insert) {
//            System.out.println(i.start + " " + i.end);
//        }
    }

}
