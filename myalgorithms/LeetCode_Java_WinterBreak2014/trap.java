import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class trap {
    public static class Solution {
        public int trap(int[] a) {
            if (a == null || a.length < 3) return 0;
            int peak = a[0], pidx = 0;
            for (int i = 0; i < a.length; i++) 
                if (a[i] >= peak) {  // = import, to slide to right most idx
                    peak = a[i];
                    pidx = i;                    
                }
            int pleft, pright;
            int res = 0;
            peak = a[0];
            for (int i = 0; i < pidx; i++) {
                if (a[i] > peak) peak = a[i];
                else if (a[i] < peak) 
                    res += peak - a[i];
                else continue;
            }
            peak = a[a.length - 1];
            for (int i = a.length - 1; i > pidx ; i--) {
                if (a[i] > peak) peak = a[i];
                else if (a[i] < peak) 
                    res += peak - a[i];
                else continue;
            }
            return res;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {2, 0, 2};
        int res = result.trap(a);
        
        System.out.println(res);
    }
}
/*
  Input:	[2,0,2]
Output:	0
Expected:	2
 */
