import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class reverseWords {
    public static class Solution {
        public String reverseWords(String s) {
            if (s == null || s.length() == 0) {
                return "";
            }

            StringBuffer result= new StringBuffer();
            String [] words = s.split("\\s+");  // matches [ \\t\\n\\x0B\\f\\r ]
            if (words.length > 0) {
                for (String i : words) {
                    System.out.println(i);
                    result.insert(0, " ");
                    result.insert(0, i);
                }
            }
            return result.toString().trim();
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        String s = "  a  b";
        String res = result.reverseWords(s);
        
        System.out.println(res);
    }
}
