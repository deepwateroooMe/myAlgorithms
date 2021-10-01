import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class isPalindrome {
    public static class Solution {

        public boolean isPalindrome(String s) {
            if (s == null || s == "") return false;
            int i = 0, j = s.length() - 1;
            while (i < j) {
                while (i < j && !Character.isLetterOrDigit(s.charAt(i))) i++;
                while (i < j && !Character.isLetterOrDigit(s.charAt(j))) j--;
                if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)))
                return false;
                i++;
                j--;
            }
            return true;
        }

        public int strstr(String haystack, String needle) {
            for (int i = 0; ; i++) {
                for (int j = 0; ; j++) {
                    if (j == needle.length()) return i;
                    if (i + j == haystack.length()) 
                    	return -1;
                    if (needle.charAt(j) != haystack.charAt(i + j))
                    	break;
                }
            }
        }

        public  String reverseWords(String s) {
            StringBuilder reversed = new StringBuilder();
            int j = s.length();
            for (int i = s.length() - 1; i >= 0; i--) {
                if (s.charAt(i) == ' ') {
                    j = i;
                } else if (i == 0 || s.charAt(i - 1) == ' ') {
                    if (reversed.length() != 0) {
                        reversed.append(' ');
                    }
                    reversed.append(s.substring(i, j));
                }
            }
            return reversed.toString();
        }

        private void reverse(char [] s, int bgn, int end) {
            for (int i = 0; i < (end - bgn) / 2; i++) {
                char tmp = s[bgn + i];
                s[bgn + i] = s[end - i - 1];
                s[end - i - 1] = tmp;
            }
        }
        public void reverseWords(char[] s) {
            reverse(s, 0, s.length);
            for (int i = 0, j = 0; j <= s.length; j++) {
                if (j == s.length || s[j] == ' ') {
                    reverse(s, i, j);
                    i = j + 1;
                }
            }
        }

        public int lengthOfLongestSubstring(String s) {
            boolean [] exist = new boolean[256];
            int i = 0, maxlen = 0;
            for (int j = 0; j < s.length(); j++) {
                while (exist[s.charAt(j)]) {
                    exist[s.charAt(i)] = false;
                    i++;
                }
                exist[s.charAt(j)] = true;
                maxlen = Math.max(j - i + 1, maxlen);
            }
            return maxlen;
        }

        public int lengthOfLongestSubstring(String s) {
            int [] charMap = new int[256];
            Arrays.fill(charMap, -1);
            int i = 0, maxlen = 0;
            for (int j = 0; j < s.length(); j++) {
                if (charMap[s.charAt(j)] >= i) {
                    i = charMap[s.charAt(j)] + 1;
                }
                charMap[s.charAt(j)] = j;
                maxlen = Math.max(j - i + 1, maxlen);
            }
            return maxlen;
        }
        
    }

    public static void main (String [] args){
        Solution result = new Solution ();
        String s = "A man, a plan, a canal: Panama";
        boolean res = result.isPalindrome(s);
        
        System.out.println (res);
    }
}