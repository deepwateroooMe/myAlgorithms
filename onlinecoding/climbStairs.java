import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class climbStairs {
    public static class Solution {
        /**
         * @param n: An integer
         * @return: An integer
         */
        public int climbStairs(int n) {
            int [] res = new int[n];
            res[0] = 1;
            if (n < 2) return 1;
            res[1] = 2;
            for (int i = 2; i < n; i++) 
                res[i] = res[i - 1] + res[i - 2];
            return res[n - 1];
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int res = result.climbStairs(1);

        System.out.println(res);
    }
}
