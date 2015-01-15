import com.Interval;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import java.lang.Integer;

public class mergeInterval {
    public static class Solution {
        public List<Interval> merge(List<Interval> intervals) {
            // sort List<interval>
            // https://oj.leetcode.com/discuss/13953/a-simple-java-solution
            Collections.sort(intervals, new Comparator<Interval>(){
                    @Override
                        public int compare(Interval a, Interval b) {
                        return Integer.compare(a.start, b.start);
                    }
                });

            int i;
            for ( i = 0; i < intervals.size() - 1; i++) {
                int j = i + 1;
                if (intervals.get(i).end < intervals.get(j).start)
                    continue;
                else if (intervals.get(i).end >= intervals.get(j).start
                         && intervals.get(i).end < intervals.get(j).end) {
                    intervals.get(i).end = intervals.get(j).end;
                    intervals.remove(intervals.get(j));
                    --i;
                } else {
                    intervals.remove(intervals.get(j));
                    --i;
                }
            }
            return intervals;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {1, 3, 2, 6, 8, 10, 15, 18};
        Interval b = new Interval();
        List<Interval> list = b.buildInterval(b, a);
        b.printInterval(list);
        List<Interval> res = result.merge(list);
        b.printInterval(res);
    }
}









