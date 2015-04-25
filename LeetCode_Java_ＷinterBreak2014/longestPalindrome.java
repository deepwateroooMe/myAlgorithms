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
            int n = s.length();
            boolean [][] f = new boolean[n][n];
            int maxLen = 1, start = 0;
            for (int i = 0; i < n; i++) {
                f[i][i] = true;
                for (int j = 0; j < i; j++) {
                    f[j][i] = (s.charAt(j) == s.charAt(i) && (i - j < 2 || f[j + 1][i - 1]));
                    if (f[j][i] && maxLen < (i - j + 1)) {
                        maxLen = i - j + 1;
                        start = j;
                    }
                }
            }
            return s.substring(start, start + maxLen);
        }
        
        public String longestPalindrome0(String s) {
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
        String s = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
        String res = result.longestPalindrome(s);

        System.out.println(res);
    }
}
/*
  Runtime Error Message:	Line 17: java.lang.StringIndexOutOfBoundsException: String index out of range: -27
Last executed input:	"civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"

  Input:	"bb"
Output:	"b"
Expected:	"bb"
 */
