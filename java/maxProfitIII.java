import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class maxProfitIII {
    public static class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length < 2) return 0;  // prices.length == 1: bug == 0
            int [] past = new int[prices.length];
            int [] futu = new int[prices.length];
            int valley = prices[0];
            int peak = prices[prices.length-1];
            int result = 0;

            // forward, calculate max profit until this time
            for (int i = 0; i < prices.length; i++) {
                valley = Math.min(valley, prices[i]);
                if (i > 0)
                    past[i] = Math.max(past[i - 1], prices[i]-valley);
            }
            
            // backward, calculate max profit from now, and the sum with history
            for (int i = prices.length-1; i >= 0 ; i--) {
                peak = Math.max(peak, prices[i]);
                if (i < prices.length - 1)
                    futu[i] = Math.max(futu[i+1], peak-prices[i]);
                result = Math.max(result, past[i] + futu[i]);
            }
            return result;
        }
        
        /*
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length < 2) return 0;  // prices.length == 1: bug == 0
            int result = 0;
            for (int i = 0; i < prices.length-1; i++) 
                result += (prices[i] < prices[i+1]) ? prices[i+1] - prices[i] : 0;
            if (result == 0) return 0; // still too slow, follow old method
            int one = 0, two = 0;
            for (int i = 1; i < prices.length-1; i++) {
                one = 0; two = 0;
                for (int j = 0; j <= i-1 ; j++) 
                    one += (prices[j] < prices[j+1]) ? prices[j+1] - prices[j] : 0;
                for (int j = i+1; j < prices.length-1 ; j++) 
                    two += (prices[j] < prices[j+1]) ? prices[j+1] - prices[j] : 0;
                result = Math.max(result, one + two);
            }
            return result;
        }
        */
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {1, 2, 3, 4, 5, 6};
        int res = result.maxProfit(a);
        
        System.out.println(res);
    }
}
