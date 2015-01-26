public class isMatchRegularExpression {
    public static class Solution {
        // https://oj.leetcode.com/discuss/9405/the-shortest-ac-code
        // '.' if p has a '.', it can pass any single character in s except '\0'.
        // '*' if p has a '*' character, it can pass any length of first-match
        //                    characters in s including '\0'.
        public boolean matchFirst(String s, String p) {
            System.out.println("s: " + s);
            System.out.println("p: " + p);

            if (s.length() == 0 && !p.equals("*")) return false;
            else if (s.length() > 0 && p.length() == 0) return false;
            else if (s.length() == 0 && p.charAt(0) != '.' && p.charAt(0) != '*') return false;
            return ((s.charAt(0) == p.charAt(0)) || (s.length() >= 1 && p.charAt(0) == '.'));
        }

        public boolean isMatch0(String s, String p) {
            if (s == null) return p == null;
            if (s == null || s.length() == 0) {
                if ( (p == null && s == null) || (s.length() == 0 && p.length() == 0) )
                    return true;
                else if (p != null && p.length() != 0) {
                    if ((p.length() == 1 && p.charAt(0) == '*')
                        || (p.length() == 2 && p.charAt(1) == '*')) {
                        return true;
                    } else if ((p.length() == 1 && p.charAt(0) != '*')
                               || (p.length() == 2 && p.charAt(1) != '*')
                               || (p.length() > 2 &&
                                   (p.charAt(1) != '*' || p.charAt(p.length()-1) != '*'))) {
                        return false;
                    } else return isMatch(s, p.substring(3));
                } else {
                    char[] pchar = p.toCharArray();
                    if (p.length() == 2 && pchar[0] == '.' && pchar[1] == '*') {
                        return true;
                    } else {
                        for(int i = 2; i < p.length(); ++i) {
                            if (pchar[i] != '*') {
                                return false;
                            } 
                        }
                        return true;
                    }
                }
            } else if (p == null || p.length() == 0) {
                return (s == null && p == null) || (s.length() == 0 && p.length() == 0);
            } else if (p.length() == 1) {
                if (s.length() == 1) {
                    return matchFirst(s, p);
                } else return false;
            }
            
            char[] schar = s.toCharArray();
            char[] pchar = p.toCharArray();
            int m = 0, n = 0;
            
            if (pchar[n+1] != '*') { // without *
                if (!matchFirst(s, p)) {
                    return false;  // '.' considered in helper function   
                } else if (s.length() == 1 && p.length() == 1) {
                    return true;
                } else if (s.length() == 1) {
                    if (p.length() == 2 && p.charAt(1) == '*') {
                        return true;
                    } else if (p.length() >= 3 && p.charAt(p.length()-1) != '*') {
                        return false;
                    } else if (p.length() >= 3 && p.charAt(2) == '*') {
                        return isMatch(s.substring(1), p.substring(3));
                    }
                } else return isMatch(s.substring(1), p.substring(1));                    
            } else { // with followed '*'
                System.out.println("");
                System.out.println("GotHere");

                if (isMatch(s, p.substring(2))) return true;
                String tmp = p.substring(2, p.length());
                System.out.println("tmp 0: " + tmp);
                String stmp = s;
                while (stmp.length() > 0 && tmp.length() > 0 && matchFirst(stmp, tmp)) {
                    tmp = p.substring(2, p.length());
                    System.out.println("tmp 1: " + tmp);
                    if (s.length() >= 1) {
                        stmp = s.substring(1, s.length());
                        System.out.println("stmp: " + stmp);
                        if (isMatch(stmp, tmp)) return true;
                    } else if (s.length() == 0 && tmp.length() > 0 && !tmp.equals(".*") && !tmp.equals("*"))
                        return false;
                    else if (s.length() > 0 && p.length() == 0) return false;
                }
                if (stmp.length() > 0 && tmp.length() > 0 && !matchFirst(stmp, tmp)) return false;
            }
            return false;
        }

        public boolean isMatch(String s, String p) {
            if (p.length() == 0 && s.length() == 0) return true;
            else if (p.length() == 0 && s.length() > 0) return false;
            /*
              // don't need these parts....
            else if (s.length() == 1 && s.charAt(0) != p.charAt(0) && p.charAt(0) != '.')
            return false; // wrong

            int minLen = 0;
            int k = 0;
            while (k + 1 < p.length()) {
                if (p.charAt(k) != '*' && p.charAt(k + 1) != '*') ++minLen;
                ++k;
            }
            if (p.charAt(k) != '*')
                ++minLen;
            System.out.println("minLen: " + minLen);

            if (minLen > s.length()) return false;
            */
            int m = s.length();
            int n = p.length();
            boolean [][] dp = new boolean[m + 1][n + 1];
            dp[0][0] = true;
            //dp[0][1] = false;
            for (int i = 1; i <= m ; i++)
                dp[i][0] = false;
            for (int i = 1; i <= n ; i++)
                if (i >= 2)
                    dp[0][i] = (p.charAt(i - 1) == '*') ? dp[0][i - 2] : false;
            for (int i = 1; i <= m ; i++) {
                for (int j = 1; j <= n ; j++) {
                    if (p.charAt(j - 1) == '.')
                        dp[i][j] = dp[i - 1][j - 1];
                    else if (p.charAt(j - 1) == '*')
                        dp[i][j] = ( dp[i][j - 1] || dp[i][j - 2] ||
                                     (dp[i - 1][j] &&
                                      ((s.charAt(i - 1) == p.charAt(j - 2)  || p.charAt(j - 2) == '.'))) );
                    else if (s.charAt(i - 1) == p.charAt(j - 1)) 
                        dp[i][j] = dp[i - 1][j - 1];
                }
            }
            return dp[m][n];
        }
    }
        
    public static void main(String[] args) {
        String s = "a";
        String t = "c*."; // I don't want to do this one any more!!! 435/445
        Solution result = new Solution();
        boolean results = result.isMatch(s, t);
                
        System.out.println(results);
    }
}
/*
  Input:	"a", "c*."
Output:	false
Expected:	true

  Input:	"aa", "aa"
Output:	false
Expected:	true

Input:	"aab", "c*a*b"
Output:	false
Expected:	true
*/
