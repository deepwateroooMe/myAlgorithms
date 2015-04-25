import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class titleToNumber {
    public static class Solution {
        public int titleToNumber(String s) {
            int result = 0;
            if (s == null || s.length() == 0) {
                return 0;
            }
            for (int i = 0; i < s.length(); i++) {
                result *= 26;
                result += s.charAt(i) - 'A' + 1;
                //System.out.println("result: " + result);
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Solution result = new Solution();
            
        String s = "AB";
        int res = result.titleToNumber(s);
        System.out.println(res);
    }
       
}
