import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class longestPalindrome {
    public static class Solution {
        public String expandAsMuchAsPossible(String s, int left, int right) {
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            if (left >= 0 && right < s.length())
                return s.substring(left + 1, right);
            return s.substring(left + 1, right);
        }
        
        public String longestPalindrome(String s) {
            if (s == null || s.length() == 0) return "";
            String res = s.substring(0, 1);
            String one, two;
            for (int i = 0; i < s.length() - 1; i++) {
                one = expandAsMuchAsPossible(s, i, i);
                two = expandAsMuchAsPossible(s, i, i + 1);
                if (one.length() > res.length()) 
                    res = one;
                if (two.length() > res.length())
                    res = two;
            }
            return res;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        String s = "bb";
        String res = result.longestPalindrome(s);

        System.out.println(res);
    }
}
/*
  Input:	"bb"
Output:	"b"
Expected:	"bb"
 */
