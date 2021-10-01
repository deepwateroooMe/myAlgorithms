import com.Interval;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import java.lang.Integer;

public class insertInterval {
    public static class Solution {
        public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
            intervals.add(newInterval);
            Collections.sort(intervals, new Comparator<Interval>(){
                    @Override
                        public int compare(Interval a, Interval b) {
                        return Integer.compare(a.start, b.start);
                    }
                });

            for (int i = 0; i < intervals.size() - 1; i++) {
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
        //int [] a = {1, 3, 6, 9};
        int [] a = {1, 2, 3, 5, 6, 7, 8, 10, 12, 16};
        Interval b = new Interval(1, 2);
        List<Interval> list = b.buildInterval(b, a);
        b.printInterval(list);
        List<Interval> res = result.insert(list, new Interval(4, 9));
        b.printInterval(res);
    }
}









