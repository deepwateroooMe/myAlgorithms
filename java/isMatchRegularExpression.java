public class isMatchRegularExpression {
    public static class Solution {

        // https://oj.leetcode.com/discuss/9405/the-shortest-ac-code
        // '.' if p has a '.', it can pass any single character in s except '\0'.
        // '*' if p has a '*' character, it can pass any length of first-match
        //                    characters in s including '\0'.
        public boolean matchFirst(String s, String p) {
            return (s[0] == p[0] || (p[0] == '.' && s[0] != '\0'));
        }

        public boolean isMatch(String s, String p) {
            if (p[0] == '\0') return (s[0] == '\0');
            
            
        }    
    }
    
    public static void main(String[] args) {
        String s = "abc";
        String t = "ade";
        Solution result = new Solution();
        boolean results = result.isMatch(s, t);
                
        System.out.print(results);
    }
}
