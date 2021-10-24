// import com.UnionFind;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.*;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toMap;

public class SummaryRanges {

    // class Range {
    //     int left, right;
    //     public Range(int left, int right) {
    //         this.left = left;
    //         this.right = right;
    //     }
    //     // public String toString() {
    //     //     return "Range(" + left + "," + right + ")";
    //     // }
    // }
    // TreeSet<Range> ts; 
    // public SummaryRanges() {
    //     ts = new TreeSet<>((a, b)->(a.left != b.left ? a.left - b.left : a.right - b.right));
    // }
    // public void addNum(int val) {
    //     int nl = val, nr = val;
    //     Range high = new Range(val, val);
    //     while (true) {
    //         Range r = ts.lower(high);
    //         if (r == null || r.right < val-1) break;
    //         if (r.right >= val) nr = r.right;
    //         if (r.right == val-1) nr = val;
    //         if (r.left < val) nl = r.left;
    //         ts.remove(r);
    //     }
    //     while (true) {
    //         Range r = ts.higher(high);
    //         if (r == null || r.left > nr + 1) break;
    //         if (r.left < nl) nl = r.left;
    //         if (r.right > nr) nr = r.right;
    //         ts.remove(r);
    //     }
    //     ts.add(new Range(nl, nr));
    // }
    // public int[][] getIntervals() {
    //     int [][] ans = new int [ts.size()][];
    //     Iterator it = ts.iterator();
    //     int i = 0;
    //     while (it.hasNext()) {
    //         Range cur = (Range)it.next();
    //         ans[i++] = new int []  {cur.left, cur.right} ;
    //     }
    //     return ans;
    // }

    class Range implements Comparable<Range> {
        int bgn, end;
        public Range(int bgn, int end) {
            this.bgn = bgn;
            this.end = end;
        }
        @Override public int compareTo(Range other) {
            return this.bgn - other.bgn;
        }
    }
    TreeSet<Range> ts; 
    public SummaryRanges() {
        ts = new TreeSet<Range>();
    }
    public void addNum(int val) {
        Range cur = new Range(val, val);
        Range bef = ts.floor(cur);
        Range aft = ts.ceiling(cur);
        if (bef != null && bef.end + 1 >= val) {
            cur.bgn = bef.bgn;
            cur.end = Math.max(val, bef.end);
            ts.remove(bef);
        }
        if (aft != null && aft.bgn == val + 1) {
            cur.end = aft.end;
            ts.remove(aft);
        }
        ts.add(cur);
    }
    public int[][] getIntervals() {
        int [][] ans = new int [ts.size()][2];
        int i = 0;
        for (Range cur : ts) {
            ans[i][0] = cur.bgn;
            ans[i][1] = cur.end;
            i++;
        }
        return ans;
    }

    public static void main(String[] args) {
        SummaryRanges s = new SummaryRanges();

        s.addNum(1);      // arr = [1]
        int [][] r = s.getIntervals(); // return [[1, 1]]
        System.out.println("r.length: " + r.length);
        for (int z = 0; z < r.length; ++z) 
            System.out.println(Arrays.toString(r[z]));

        s.addNum(3);      // arr = [1, 3]
        int [][] r1 =         s.getIntervals(); // return [[1, 1], [3, 3]]
        System.out.println("r1.length: " + r1.length);
        for (int z = 0; z < r1.length; ++z) 
            System.out.println(Arrays.toString(r1[z]));
        
        s.addNum(7);      // arr = [1, 3, 7]
        int [][] r2 =         s.getIntervals(); // return [[1, 1], [3, 3], [7, 7]]
        System.out.println("r2.length: " + r2.length);
        for (int z = 0; z < r2.length; ++z) 
            System.out.println(Arrays.toString(r2[z]));
        
        
        s.addNum(2);      // arr = [1, 2, 3, 7]
        int [][] r3 =         s.getIntervals(); // return [[1, 3], [7, 7]]
        System.out.println("r3.length: " + r3.length);
        for (int z = 0; z < r3.length; ++z) 
            System.out.println(Arrays.toString(r3[z]));
        
        
        s.addNum(6);      // arr = [1, 2, 3, 6, 7]
        int [][] r4 =         s.getIntervals(); // return [[1, 3], [6, 7]]
        System.out.println("r4.length: " + r4.length);
        for (int z = 0; z < r4.length; ++z) 
            System.out.println(Arrays.toString(r4[z]));
    }
}
