import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class isScramble {
    public static class Solution {
        public boolean isScramble(String s1, String s2) {
            if (s1 == null || s2 == null) return false;
            if (s1.length() != s2.length()) return false;
            int len = s1.length();
            
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        String s = "great";
        String t = "rgeat";
        boolean res = result.isScramble(s, t);
        
        System.out.println(res);
    }
}
