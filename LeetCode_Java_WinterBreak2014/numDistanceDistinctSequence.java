import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class numDistanceDistinctSequence {
    public static class Solution {
        public int numDistinct(String s, String t) {
            if (s == null || s.length() == 0) return 0;
            int m = s.length();
            int n = t.length();
            int [] res = new int[n + 1];
            res[0] = 1;
            for (int i = 0; i < m; i++) 
                for (int j = n - 1; j >= 0; j--) 
                    res[j + 1] += s.charAt(i) == t.charAt(j) ? res[j] : 0;
            return res[n];
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        String s = "rabbbit";
        String t = "rabbit";
        int res = result.numDistinct(s, t);
        
        System.out.println(res);
    }
}
