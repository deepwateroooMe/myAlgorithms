import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class reverseWords {
    public static class Solution {

        public String reverseWords(String s) {
            StringBuilder reversed = new StringBuilder();
            int j = s.length();
            for (int i = s.length() - 1; i >= 0; i--) {
                if (s.charAt(i) == ' ') {
                    // i --;
                    j = i;
                } else if (i == 0 || s.charAt(i - 1) == ' ') {
                    if (reversed.length() != 0)
                        reversed.append(' ');
                    reversed.append(s.substring(i, j));
                }
            }
            return reversed.toString();
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        

        // System.out.println(res);
    }
}