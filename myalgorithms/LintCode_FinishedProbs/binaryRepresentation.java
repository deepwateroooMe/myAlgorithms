import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class binaryRepresentation {
    public static class Solution {
        /**
         *@param n: Given a decimal number that is passed in as a string
         *@return: A string
         */
        public String binaryRepresentation(String s) {
        StringBuffer val = new StringBuffer();
        StringBuffer res = new StringBuffer();
        int n = s.length();
        int i = 0;
        while (i < n && s.charAt(i) != '.') {
            val.append(s.charAt(i));
            i++;
        }

        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        String s = "3.72";
        String res = result.binaryRepresentation(s);
        
        System.out.println(res);
    }
}
