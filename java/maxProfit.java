import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class maxProfit {
    public static class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length < 2) return 0;  // prices.length == 1: bug == 0

            int [] min = new int[prices.length];
            int [] max = new int[prices.length];
            int result = Integer.MIN_VALUE;
            min[0] = prices[0];
            max[prices.length-1] = prices[prices.length-1];
            for (int i = prices.length-2; i >= 0 ; i--)
                max[i] = Math.max(max[i+1], prices[i]);

            for (int i = 1; i < prices.length; i++) {
                min[i] = Math.min(min[i-1], prices[i]);
                result = Math.max(result, max[i]-min[i]);
            }
            return result;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {1, 2, 3, 4, 5, 6};
        int res = result.maxProfit(a);
        
        System.out.println(res);
    }
}
