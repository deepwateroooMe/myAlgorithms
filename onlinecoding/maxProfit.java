import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class maxProfit {
    public static class Solution {
        /**
         * @param prices: Given an integer array
         * @return: Maximum profit
         */
        public int maxProfit(int[] prices) {
            if (prices.length == 0) return 0;
            int n = prices.length;
            int [] buy = new int[n];
            buy[0] = prices[0];
            for (int i = 1; i < n; i++)
                buy[i] = Math.min(buy[i - 1], prices[i]);
            int [] sell = new int[n];
            sell[n - 1] = prices[n - 1];
            int res = Integer.MIN_VALUE;
            for (int i = n - 2; i >= 0; i--) {
                sell[i] = Math.max(sell[i + 1], prices[i]);
                res = Math.max(res, sell[i] - buy[i]);
            }
            return res;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {3, 2, 3, 1, 2};
        int res = result.maxProfit(a);
        System.out.println(res);
    }
}
