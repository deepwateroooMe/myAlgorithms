import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class maxProduct {
    public static class Solution {
        public int maxProduct(int[] a) {
            int n = a.length;
            int [] res = new int[n];
            res[0] = a[0];
            int tmp = a[0];
            for (int i = 1; i < n; i++) {
                
            }
            return res[n - 1];
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {2, 3, -2, 4};
        int res = result.maxProduct(a);
        
        System.out.println(res);
    }
}
