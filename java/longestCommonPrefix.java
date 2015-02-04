import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class longestCommonPrefix {
    public static class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs.length == 0) return "";
            int rightMost = strs[0].length();
            for (int i = 1; i < strs.length; i++) {
                for (int j = 0; j <= rightMost; j++) {
                    if (strs[i].length() < j+1 || strs[i].charAt(j) != strs[0].charAt(j))
                    //if (strs[i].charAt(j) != strs[0].charAt(j))
                        rightMost = j - 1;
                }
            }
            System.out.println("rightMost: " + rightMost);

            //return strs[0].substring(0, rightMost);
            return rightMost <= 0 ? "" : strs[0].substring(0, rightMost);
        }

        public String longestCommonPrefix0(String[] strs) {
            if (strs.length == 0) return "";
            for (int j = 0; j < strs[0].length(); j++) {
                for (int i = 1; i < strs.length; i++) {
                    if (strs[i].length() < j+1 || strs[i].charAt(j) != strs[0].charAt(j))
                        return strs[0].substring(0, j);
                }
            }
            return strs[0];
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        String [] a = {"", ""};
        String res = result.longestCommonPrefix(a);
        
        System.out.println(res);
    }
}
