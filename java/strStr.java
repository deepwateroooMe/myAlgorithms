import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class strStr {
    public static class Solution {
        // idea is straight forward, but need to organize the idea better
        public int strStr(String haystack, String needle) {
            if (haystack == null || needle == null) return -1;
            if (needle.length() == 0) return 0;
            if (haystack.length() < needle.length()) return -1;
            if (haystack.length() == needle.length()) {
                for (int i = 0; i < haystack.length(); i++) {
                    if (haystack.charAt(i) != needle.charAt(i))
                        return -1;
                }
                return 0;
            }

            int start = 0, i = 0;
            int j = 0;
            int result = 0;
            while (start < haystack.length()) {
                i = start;
                while (i < haystack.length() && haystack.charAt(i) != needle.charAt(j)) i++;
                if (i == haystack.length() && j <= needle.length()) return -1;
                result = i;
                while (j < needle.length() && i < haystack.length() && haystack.charAt(i) == needle.charAt(j)) {
                    i++;
                    j++;
                }
                if (i == haystack.length() && j < needle.length())
                    return -1;
                if (j == needle.length())
                    return result;
                else {
                    start++;
                    j = 0;
                }
            }
            return -1;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        String a = "baabbaaaaaaabbaaaaabbabbababaabbabbbbbabbabbbbbbabababaabbbbbaaabbbbabaababababbbaabbbbaaabbaababbbaabaabbabbaaaabababaaabbabbababbabbaaabbbbabbbbabbabbaabbbaa";
        String b = "bbaaaababa";
        int res = result.strStr(a, b);
        
        System.out.println(res);
    }
}

/*
  Time Limit Exceeded
  Last executed input:	"baabbaaaaaaabbaaaaabbabbababaabbabbbbbabbabbbbbbabababaabbbbbaaabbbbabaababababbbaabbbbaaabbaababbbaabaabbabbaaaabababaaabbabbababbabbaaabbbbabbbbabbabbaabbbaa",
  "bbaaaababa"
*/
