import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class jump {
    public static class Solution {
        public int jump(int[] a) {
            if (a.length == 1) return 0;

            int maxj = 0;  
            int lastj = 0; 
            int i = 0;
            int cnt = 0;
            while (i + a[i] < a.length -1) {
                // scan every jump, and next start from the furthest idx afr 1 jump 
                for (lastj = i + 1; lastj <= i + a[i]; lastj++) {
                    if (lastj + a[lastj] > maxj + a[maxj]) {
                        maxj = lastj;
                        //System.out.println("maxj: " + maxj);
                    }
                }
                ++cnt;
                i = maxj;
            }
            return ++cnt;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        //int [] a = {7, 0, 9, 6, 9, 6, 1, 7, 9, 0, 1, 2, 9, 0, 3};
        int [] a = {1, 2, 3};
        int res = result.jump(a);
        
        System.out.println(res);
    }
}

/*
  Runtime Error Message:	Line 17: java.lang.ArrayIndexOutOfBoundsException: 3
Last executed input:	[1,2,3]

  Input:	[7,0,9,6,9,6,1,7,9,0,1,2,9,0,3]
Output:	4
Expected:	2
 */
