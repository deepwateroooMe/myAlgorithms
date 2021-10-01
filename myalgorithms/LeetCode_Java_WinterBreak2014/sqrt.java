import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class sqrt {
    public static class Solution {
        public int sqrt0(int x) {
            int bgn = 0;
            int end;
            int mid;
            int pdt;
            int pdtt;
            end = x / 2 < (int)Math.sqrt(Integer.MAX_VALUE) ? x / 2 + 1 : (int)Math.sqrt(Integer.MAX_VALUE);
            while (bgn < end) {
                mid = bgn + (end - bgn) / 2;
                pdt = mid * mid;
                pdtt = (mid + 1) * (mid + 1);
                if (pdt == x) return mid;
                if (pdt < x && pdtt <= x)
                    bgn = mid + 1;
                else if (pdt > x)
                    end = mid - 1;
                else if (pdt < x && pdtt > x) break;
            }
            return bgn + (end - bgn) / 2;
        }

        public int sqrt(int x) {
            int bgn = 0, end = 0;
            int mid = 0;
            int lastMid = 0;
            if (x < 2) return x;
            end = x / 2 < (int)Math.sqrt(Integer.MAX_VALUE) ? x / 2 + 1 : (int)Math.sqrt(Integer.MAX_VALUE);
            while (bgn <= end) {
                mid = bgn + (end - bgn) / 2;
                if (x / mid == mid)
                    return mid;
                else if (x / mid > mid) {
                    bgn = mid + 1;
                    lastMid = mid;
                } else  // x / mid < mid
                    end = mid - 1;
            }
            return lastMid;
        }

    }

    public static void main(String[] args){
        Solution result = new Solution();
        int x = 3;
        int res = result.sqrt(x);
        
        System.out.println(res);
    }
}
/*
  Input:	5
Output:	3
Expected:	2

  Input:	2
Output:	2
Expected:	1
 */
