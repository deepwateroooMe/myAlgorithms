public class isMatchRegularExpression {
    public static class Solution {

        // https://oj.leetcode.com/discuss/9405/the-shortest-ac-code
        // '.' if p has a '.', it can pass any single character in s except '\0'.
        // '*' if p has a '*' character, it can pass any length of first-match
        //                    characters in s including '\0'.
        public boolean matchFirst(String s, String p) {
            char[] schar = s.toCharArray();
            char[] pchar = p.toCharArray();
            return (schar[0] == pchar[0] || (pchar[0] == '.' && schar[0] != '\0'));
        }

        public boolean isMatch(String s, String p) {
            if (s == null || s.length() == 0) {
                if ( (p == null && s == null) || (s.length() == 0 && p.length() == 0) ) {
                    return true;
                } else if (p != null && p.length() != 0) {
                    if ((p.length() == 1 && p.charAt(0) == '*')
                        || (p.length() == 2 && p.charAt(1) == '*')) {
                        return true;
                    } else if ((p.length() == 1 && p.charAt(0) != '*')
                               || (p.length() == 2 && p.charAt(1) != '*')
                               || (p.length() > 2 &&
                                   (p.charAt(1) != '*' || p.charAt(p.length()-1) != '*'))) {
                        return false;
                    } else {
                        return isMatch(s, p.substring(3));
                    }
                } else {
                    char[] pchar = p.toCharArray();
                    if (p.length() == 2 && pchar[0] == '.' && pchar[1] == '*') {
                        return true;
                    } else {
                        for(int i = 2; i < p.length(); ++i) {
                            if (pchar[i] != '*') {
                                return false;
                            } else {
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
                } else {
                    return false;
                }
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
                } else {
                    return isMatch(s.substring(1), p.substring(1));
                }
            } else { // with followed '*'
                //if (p.length() == 2 && matchFirst(s, p) && s.charAt(1) == s.charAt(0)) {
                if (p.length() == 2 && matchFirst(s, p)) {
                    if (s.length() == 1) {
                        return true;
                    } else {
                        return isMatch(s.substring(1), p);
                    }
                } else if (p.length() > 2 && isMatch(s, p.substring(2))) {
                    return true;
                } else {
                    m = 1;
                    String tmp = p.substring(2);
                    System.out.println("tmp out: " + tmp);
                    while (matchFirst(s, p)) {  //try all possible lengths by the following
                        if (s.length() <= m) {
                            return false;
                        } else { 
                            s = s.substring(m);
                            System.out.println("s: " + s);
                            if (isMatch(s, tmp)) {
                                return true;
                            } else {
                            }
                        } 
                    }
                }
            }
            return false;
        }
    };
        
    public static void main(String[] args) {
        String s = "abbabaaaaaaacaa";
        String t = "a*.*b.a.*c*b*a*c*"; // I don't want to do this one any more!!! 435/445
        Solution result = new Solution();
        boolean results = result.isMatch(s, t);
                
        System.out.println(results);
    }
}