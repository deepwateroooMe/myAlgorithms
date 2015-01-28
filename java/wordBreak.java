import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class wordBreak {
    public static class Solution {
        public boolean wordBreak0(String s, Set<String> dict) {
            if (dict.contains(s)) return true;
            boolean [] dp = new boolean[s.length()];
            for (int i = 0; i < s.length(); i++) 
                dp[i] = false;

            for (int i = 0; i < s.length(); i++)
                for (int j = i; j >= 0; j--) {
                    String tmp = new String(s.substring(j, i+1));
                    if (dict.contains(tmp))
                        if ((j == 0) || (j >= 1 && dp[j-1])) {
                            dp[i] = true;
                            break;
                        }
                }
            return dp[s.length()-1];
        }

        public boolean helper(String s, int i, Set<String> dict) {
            int n = s.length();
            if (i >= n) return false;
            int j = i;
            while (j < n) {
                while (j < n && !dict.contains(s.substring(i, j + 1))) j++;
                if (j == n) return false;
                if (helper(s, j + 1, dict) == true) return true;
                j++;
            }
            return false;
        }
        
        public boolean wordBreak(String s, Set<String> dict) {
            if (dict.contains(s)) return true;
            if (s == null || s.length() == 0) return false;
            return helper(s, 0, dict);
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        String s = "leetcode";
        Set<String> dict = new HashSet<String>();
        dict.add("leet");
        dict.add("code");
        boolean res = result.wordBreak(s, dict);
        
        System.out.println(res);
    }
}
