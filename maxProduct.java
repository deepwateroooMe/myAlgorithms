import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class maxProduct {
    public static class Solution {
        public int maxProduct(int[] a) {
            int n = a.length;
            int [] max = new int[n];
            int [] min = new int[n];
            max[0] = a[0];
            min[0] = a[0];
            int tmp = a[0];   // curr positive
            for (int i = 1; i < n; i++) {
                tmp *= a[i];
                max[i] = Math.max(Math.max(max[i - 1], tmp),
                                  Math.max(max[i - 1], a[i]));
                min[i] = Math.min(a[i], min[i - 1] * a[i]);
                if (min[i] == a[i]) tmp = a[i];
                /*
                min[i] = Math.min(Math.min(min[i - 1], min[i - 1] * a[i]),
                                  Math.min(min[i - 1], a[i]));
                if (tmp < 0 && max[i - 1] >= 1)  tmp = 1;
                */
                System.out.println("i: " + i);
                System.out.println("max[i]: " + max[i]);
                System.out.println("min[i]: " + min[i]);
                System.out.println("tmp: " + tmp);
                System.out.println("");

                if (min[i] > max[i])
                    max[i] = min[i];
            }
            return Math.max(max[n - 1], min[n - 1]);
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
