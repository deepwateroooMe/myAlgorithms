import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class reverseWords2 {
    public static class Solution {

        private void reverse(char [] s, int bgn, int end) {
            char tmp;
            for (int i = 0; i < (end - bgn) / 2; i++) {
                tmp = s[i + bgn];
                s[i + bgn] = s[end - i - 1];
                s[end - i - 1] = tmp;
            }
        }
        
        public void reverseWords(char [] s) {
            reverse(s, 0, s.length);
            for (int i = 0, j = 0; j <= s.length; j++) {
                if (j == s.length || s[i] == ' ') {
                    reverse(s, i, j);
                    i = j + 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String sur = "I am a student";
        s.reverseWords(sur.toCharArray());

        System.out.println(sur);
    }
}