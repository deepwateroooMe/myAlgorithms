import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class isNumber {
    public static class Solution {
        // need to trace back the errors to understand the rules
        // most headache question ever `~!!!!
        public boolean isNumber(String s) {
            if (s == null || s.length() == 0) return false;
            int n = s.length();
            int i = 0;
            while (i < n && Character.isWhitespace(s.charAt(i))) i++;
            if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) i++;
            boolean res = false;
            boolean ee = false;
            boolean eval = false;
            StringBuffer tmp = new StringBuffer();
            while (i < n && Character.isDigit(s.charAt(i))) {
                tmp.append(s.charAt(i));
                i++;
                if (i < n && !ee && (s.charAt(i) == 'e' || s.charAt(i) == 'E')) {
                    ee = true;
                    i++;   
                    if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) i++;
                    tmp = new StringBuffer();
                }
                res = true;
            }

            if (ee && tmp.length() == 0) return false;
            if (i < n && !ee && s.charAt(i) == '.') {
                tmp.append(s.charAt(i));
                i++;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    tmp.append(s.charAt(i));
                    i++;
                    res = true;
                } 
                if (i < n && !ee && (s.charAt(i) == 'e' || s.charAt(i) == 'E')) {
                    ee = true;
                    if (ee && (tmp.length() == 0 ||
                               tmp.toString().equals(".") ||
                               tmp.toString().equals("0."))) return false;
                    i++;
                    if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) i++;
                    tmp = new StringBuffer();
                }
                while (i < n && Character.isDigit(s.charAt(i))) {
                    tmp.append(s.charAt(i));
                    i++;
                    res = true;
                } 
            }
            while (i < n && Character.isWhitespace(s.charAt(i))) i++;
            if (ee && (tmp.length() == 0)) return false;
            return res && i == n;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        String s = "005047e+6";
        boolean res = result.isNumber(s);
        
        System.out.println(res);
    }
}
/*
  Input:	" 005047e+6"
Output:	false
Expected:	true

  Input:	".2e81"
Output:	false
Expected:	true

  Input:	"3.e"
Output:	true
Expected:	false

  Input:	"0.e"
Output:	true
Expected:	false

  Input:	".e1"
Output:	true
Expected:	false

  Input:	"46.e3"
Output:	false
Expected:	true

  Input:	"0e"
Output:	true
Expected:	false

  Runtime Error Message:	Line 13: java.lang.StringIndexOutOfBoundsException: String index out of range: 1
Last executed input:	"3"
 */
