import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class strStr {
    public static class Solution {
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
            int i = 0;
            int j = 0;
            int result = 0;
            while (i < haystack.length()) {
                while (i < haystack.length() && haystack.charAt(i) != needle.charAt(j)) i++;
                if (i == haystack.length() && j <= needle.length()) return -1;
                result = i;
                while (j < needle.length() && i < haystack.length() && haystack.charAt(i) == needle.charAt(j)) {
                    i++;
                    j++;
                }
                //System.out.println("i: " + i);
                //System.out.println("j: " + j);
                
                if (i == haystack.length() && j < needle.length())
                    return -1;
                if (j == needle.length())
                    return result;
                if (strStr(haystack.substring(result+1), needle) == -1)
                    return -1;
                else 
                    return result + 1 + strStr(haystack.substring(result+1), needle);
            }
            return -1;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        String a = "mississippi";
        String b = "issip";
        int res = result.strStr(a, b);
        
        System.out.println(res);
    }
}

/*
Last executed input:	"baabbaaaaaaabbaaaaabbabbababaabbabbbbbabbabbbbbbabababaabbbbbaaabbbbabaababababbbaabbbbaaabbaababbbaabaabbabbaaaabababaaabbabbababbabbaaabbbbabbbbabbabbaabbbaa", "bbaaaababa"
 */
