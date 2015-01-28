import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;


public class minimumTotal {
    public static class Solution {
        public int minimumTotal0(List<List<Integer>> triangle) {
            List<Integer> res = new ArrayList<Integer>(triangle.get(triangle.size() - 1));
            for (int i = triangle.size() - 2; i >= 0 ; i--) 
                for (int j = 0; j <= i ; j++) 
                    res.set(j, Math.min(res.get(j), res.get(j + 1)) + triangle.get(i).get(j));
            return res.get(0);
        }

        public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {  
            if(triangle == null || triangle.size() == 0)  
                return 0;  
            if(triangle.size() == 1)  
                return triangle.get(0).get(0);
    
            int[] dp = new int[triangle.size()];  
            dp[0] = triangle.get(0).get(0);  
            for(int i = 1; i < triangle.size(); i++) {  
                dp[i] = dp[i - 1] + triangle.get(i).get(i);  
                for(int j = i - 1 ; j >= 1; j--)  
                    dp[j] = (dp[j] < dp[j-1] ? dp[j] : dp[j - 1]) + triangle.get(i).get(j);  
                dp[0] = dp[0] + triangle.get(i).get(0);  
            }
    
            int minimum = dp[0];  
            for(int i = 1; i < dp.length; i++) 
                if (dp[i] < minimum)
                    minimum = dp[i];  
            return minimum;  
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        List<Integer> a = new ArrayList<Integer>();
        a.add(2);
        Integer [] b = {3, 4};
        Integer [] c = {6, 5, 7};
        Integer [] d = {4, 1, 8, 3};
        res.add(a);
        res.add(Arrays.asList(b));
        res.add(Arrays.asList(c));
        res.add(Arrays.asList(d));
        int resone = result.minimumTotal(res);

        System.out.println(resone);
    }
}
