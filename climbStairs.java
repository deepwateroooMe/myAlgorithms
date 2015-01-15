import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class climbStairs {
    public static class Solution {
        
        public int climbStairs(int n) {
            int [][] cnt = new int[2][n];
            cnt[0][0] = 1; // one stair
            cnt[1][0] = 0; // two stairs
            int tmp = 0;
            for (int i = 1; i < n; i++) { // more than this
                cnt[0][i] = cnt[1][i - 1];
                cnt[1][i] = cnt[0][i - 1];
            }
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int n = 5;
        int res = result.climbStairs(n);

        System.out.println(res);
    }
}
