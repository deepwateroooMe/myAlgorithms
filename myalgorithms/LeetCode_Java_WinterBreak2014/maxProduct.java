import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class maxProduct {
    public static class Solution {
        public int maxProduct0(int[] a) {
            int n = a.length;
            int [] max = new int[n]; //  I don't need array, use 1 space only
            int [] min = new int[n];
            max[0] = a[0];
            min[0] = a[0];
            int res = a[0];
            for (int i = 1; i < n; i++) {
                max[i] = Math.max(Math.max(max[i - 1] * a[i], a[i]),
                                  Math.max(min[i - 1] * a[i], a[i]));
                min[i] = Math.min(Math.min(min[i - 1] * a[i], a[i]),
                                  Math.min(max[i - 1] * a[i], a[i]));
                res = Math.max(res, max[i]);
            }
            return res; 
        }

        public int maxProduct(int[] a) {
            int n = a.length;
            int maxLocal = a[0];
            int minLocal = a[0];
            int res = a[0];
            for (int i = 1; i < n; i++) {
                int tmp = maxLocal;
                maxLocal = Math.max(Math.max(maxLocal * a[i], a[i]),
                                    Math.max(minLocal * a[i], a[i]));
                minLocal = Math.min(Math.min(a[i], a[i] * tmp),
                                    Math.min(a[i], a[i] * minLocal));
                res = Math.max(res, maxLocal);
            }
            return res; 
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        //int [] a = {2, 3, -2, 4};
        //int [] a = {7, -2, -4};

        // how do I slide to the right?
        int [] a = {2, -5, -2, -4, 3};
        int res = result.maxProduct(a);
        
        System.out.println(res);
    }
}
/*
  Input:	[2,-5,-2,-4,3]
Output:	20
Expected:	24

  Input:	[7,-2,-4]
Output:	7
Expected:	56
 */
