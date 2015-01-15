import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class longestCommonPrefix {
    public static class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) return "";
            if (strs[0].length() == 0) return "";
            StringBuffer result = new StringBuffer();
            for (int j = 0; j < strs[0].length(); j++) {
                for (int i = 1; i < strs.length; i++) {
                    if (strs[i].length() == 0) return "";
                    if (strs[i].length() < j+1 || strs[i].charAt(j) != strs[0].charAt(j))
                        return result.toString();
                }
                result.append(strs[0].charAt(j));
            }
            return result.toString();
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        String [] a = {"abc", "abd", "ab", "abde", "abw"};
        String res = result.longestCommonPrefix(a);
        
        System.out.println(res);
    }
}
