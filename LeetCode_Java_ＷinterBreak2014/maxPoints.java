import com.Point;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class maxPoints {
    public static class Solution {
        public int maxPoints(Point[] points) {
            if (points == null || points.length == 0) return 0;
            int max = 1;
            double k = 0.0;
            for (int i = 0; i < points.length - 1; i++) {
                Map<Double, Integer> map = new HashMap<Double, Integer>();
                int cntSame = 0;
                int amax = 1; // local max
                for (int j = i + 1; j < points.length; j++) {
                    if (points[i].x == points[j].x && points[i].y == points[j].y) {
                        cntSame++;
                        continue;
                    } else if (points[i].x == points[j].x) 
                        k = Integer.MAX_VALUE; // x = x0; infinity
                    else if (points[i].y == points[j].y) // y = y0, k = 0
                        k = 0.0;
                    else 
                        k = (double)(points[i].y - points[j].y) / (double)(points[i].x - points[j].x);  // hen???

                    if (map.containsKey(k)) 
                        map.put(k, map.get(k) + 1);
                    else
                        map.put(k, 2); // instead of regular 1 for string etc
                }
                //int res = Integer.MIN_VALUE;
                //for (Double key : map.keySet())
                for(Integer val : map.values())   // ~! convenient
                    amax = Math.max(amax, val);
                amax += cntSame;
                //amax = Math.max(amax, res);
                max = Math.max(max, amax);
            }
            return max;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] b = {84, 250, 0, 0, 1, 0, 0, -70, 0, -70, 1, -1, 21, 10, 42, 90, -42, -230};
        Point pit = new Point(84, 250);
        Point [] tmp = pit.buildArray(b);
        pit.printPointArray(tmp);
        
        int res = result.maxPoints(tmp);
        
        System.out.println(res);
    }
}
/*
  Input:	[(84,250),(0,0),(1,0),(0,-70),(0,-70),(1,-1),(21,10),(42,90),(-42,-230)]
Output:	8
Expected:	6

  Input:	[(0,0),(1,1),(0,0)]
Output:	2
Expected:	3

Input:	[(0,0),(-1,-1),(2,2)]
Output:	2
Expected:	3
 */


