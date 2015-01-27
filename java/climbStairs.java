import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class climbStairs {
    public static class Solution {
        public int climbStairs(int n) {
            int [] res = new int[n + 1];
            res[0] = 1; // 1 stair
            res[1] = 2; // 2 stair
            for (int i = 2; i < n; i++) 
                res[i] = res[i - 2] + res[i - 1];
            return res[n - 1];
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int n = 5;
        int res = result.climbStairs(n);

        System.out.println(res);
    }
}
