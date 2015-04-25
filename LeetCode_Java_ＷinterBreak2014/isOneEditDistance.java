import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class isOneEditDistance {
    public static class Solution {
        public boolean isOneEditDistance(String s, String t) {
            if ((s == null || t == null) && (s != t)) {
                return false;   
            }
            String one, two;
            one = s.length() < t.length() ? s : t; // short
            two = s.length() < t.length() ? t : s; // long
                    
            if (Math.abs(s.length() - t.length()) >= 2) {
                return false;
            } else if (one.length() == 0 && two.length() == 1) {        
                return true;
            }

            int cnt = 0;
            if (s.length() == t.length()) {
                for(int i = 0; i < s.length(); ++i) {
                    if (s.charAt(i) != t.charAt(i)) {
                        ++cnt;
                    }
                }
                if (cnt > 1 || cnt == 0) {
                    return false;
                } 
                return true;
            }

            for(int i = 0; i < one.length(); ++i) {
                if (one.charAt(i) != two.charAt(i)) {
                    for(int j = i; j < one.length(); ++j) {
                        if (one.charAt(j) != two.charAt(j+1)) {
                            return false;
                        }
                    }
                }
            }
            return true;
        }
    };

    public static void main(String[] args){
        Solution result = new Solution();
        String s = "";
        String t = "";
        boolean res = result.isOneEditDistance(s, t);
        System.out.println(res);
    }
}
