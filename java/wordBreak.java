import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class wordBreak {
    public static class Solution {
        public boolean wordBreak(String s, Set<String> dict) {
            if (dict.contains(s)) return true;
            boolean [] dp = new boolean[s.length()];
            for (int i = 0; i < s.length(); i++) 
                dp[i] = false;

            for (int i = 0; i < s.length(); i++)
                for (int j = i; j >= 0; j--) {
                    String tmp = new String(s.substring(j, i+1));
                    if (dict.contains(tmp))
                        if ((j == 0) || (j >= 1 && dp[j-1]))
                            dp[i] = true;
                }
            return dp[s.length()-1];
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
