import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class maxProduct {
    public static class Solution {
        public int maxProduct(int[] a) {
            int n = a.length;
            int [][] res = new int[n][n];
            res[0][0] = a[0];
            res[1][0] = a[0];
            int tmp = 1;
            int start = 0;
            for (int i = 1; i < n; i++) {
                if (a[i] > 0)
                    res[0][i] = Math.max(Math.max(Math.max(res[0][i - 1] * a[i], res[0][i - 1]),
                                              Math.max(res[1][i - 1] * a[i], res[1][i - 1])),
                                     a[i]);
                if (a[i] < 0 && res[1][i - 1] > 0) {
                    start = i + 1;
                    tmp = 1;   
                }
                if (res[0][i - 1] * a[i] < 0 && Math.abs(res[0][i - 1] * a[i]) > res[0][i])
                    res[1][i] = res[0][i - 1] * a[i];
                if (res[1][i - 1] * a[i] < 0 && Math.abs(res[1][i - 1] * a[i]) > res[1][i])
                    res[1][i] = Math.min(res[1][i - 1], res[1][i - 1] * a[i]);
                System.out.println("res[0][i]: " + res[0][i]);
                System.out.println("res[1][i]: " + res[1][i]);
            }
            return Math.max(res[0][n-1], res[1][n-1]);
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {2, 3, -2, 4};
        int res = result.maxProduct(a);
        
        System.out.println(res);
    }
}
