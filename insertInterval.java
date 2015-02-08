import com.Interval;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class insertInterval {
    public static class Solution {
        public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
            if (intervals.size() == 0) {
                intervals.add(newInterval);   
                return intervals;
            }
            int i = 0;
            for (i = 0; i < intervals.size(); i++) {
                Interval tmp = intervals.get(i);
                if (tmp.end < newInterval.start) continue;
                if (newInterval.end < tmp.start) {
                    intervals.add(i, newInterval);
                    return intervals;
                } else if (newInterval.start >= tmp.start && newInterval.end <= tmp.end)
                    return intervals;
                else if (newInterval.start <= tmp.start
                           && newInterval.end > tmp.start) {
                    tmp.start = newInterval.start;
                    tmp.end = Math.max(tmp.end, newInterval.end);
                    if (i < intervals.size() - 1) {
                        newInterval = intervals.get(i + 1);
                        intervals.remove(i + 1);
                        i--;
                    } else return intervals;
                }
            }
            /*
            if (newInterval.start <= intervals.get(intervals.size() - 1).end) 
                intervals.get(intervals.size() - 1).end = newInterval.end;
            else 
                intervals.add(newInterval);
            */
            return intervals;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {1, 5};
        Interval b = new Interval(a[0], a[1]);
        
        ArrayList<Interval> intervals = b.buildInterval(b, a);
        Interval newInterval = new Interval(5, 7);
        List<Interval> res = result.insert(intervals, newInterval);
        
        System.out.println("");
        for (int i = 0; i < res.size(); ++i) {
            System.out.println(res.get(i).start + ", " + res.get(i).end);
        }
        System.out.println("");
    }
}
