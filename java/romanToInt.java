import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class romanToInt {
    public static class Solution {
        public int getInt(char x) {
            switch (x) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
            }
        }

        public int romanToInt(String s) {
            int result = getInt(s.charAt(0));
            int tmp, prev;
            for (int i = 1; i < s.length(); i++) {
                tmp = getInt(s.charAt(i));
                prev = getInt(s.charAt(i-1));
                result += prev < tmp ? tmp - 2 * prev : tmp;
            }
            return result;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        String s = "DCXXI"; // to understand the rules
        int res = result.romanToInt(s);
        
        System.out.println(res);
    }
}
