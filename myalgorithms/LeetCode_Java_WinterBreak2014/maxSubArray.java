import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class maxSubArray {
    public static class Solution {
        public int maxSubArray0(int[] a) {
            if (a == null || a.length == 0) return 0;
            else if (a.length == 1) return a[0];

            int [] res = new int[a.length];
            int tmp = a[0];
            res[0] = tmp;

            int i;
            for ( i = 1; i < a.length; i++) {
                if (a[i] >= 0) {
                    tmp = Math.max(tmp + a[i], a[i]);
                    if (tmp < 0 && res[i - 1] >= 0) tmp = 0;
                    res[i] = Math.max(res[i - 1], tmp);
                } else { 
                    tmp += a[i];
                    tmp = Math.max(tmp, a[i]);
                    if (res[i - 1] >= 0 && tmp < 0) tmp = 0;
                    res[i] = Math.max(res[i - 1], tmp);
                }
            }
          return res[a.length - 1];
        }

        public int maxSubArray1(int[] a) {
            int result = Integer.MIN_VALUE, f = 0;
            for (int i = 0; i < a.length; i++) {
                f = Math.max(f + a[i], a[i]);
                result = Math.max(result, f);
            }
            return result;
        }

        public int maxSubArray(int[] a) {
            int result, curMin;
            int [] sum = new int[a.length + 1];
            sum[0] = 0;
            result = Integer.MIN_VALUE;
            curMin = sum[0];
            for (int i = 1; i <= a.length ; i++) 
                sum[i] = sum[i - 1] + a[i - 1];
            for (int i = 1; i <= a.length ; i++) {
                result = Math.max(result, sum[i] - curMin);
                curMin = Math.min(curMin, sum[i]);
            }
            return result;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {1, 2, -1, -2, 2, 1, -2, 1, 4, -5, 4};
        int res = result.maxSubArray(a);
        
        System.out.println(res);
    }
}
/*
Input:	[1,2,-1,-2,2,1,-2,1,4,-5,4]
Output:	5
Expected:	6

  Input:	[8,-19,5,-4,20]
Output:	29
Expected:	21

  Input:	[-2,-3,-1]
Output:	0
Expected:	-1

  Input:	[-2,1]
Output:	-1
Expected:	1

  Input:	[1,2]
Output:	2
Expected:	3

  Input:	[-2,-1]
Output:	0
Expected:	-1

Input:	[-2,1]
Output:	0
Expected:	1
 */
