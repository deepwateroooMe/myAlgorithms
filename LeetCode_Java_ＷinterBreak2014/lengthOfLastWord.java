import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class lengthOfLastWord {
    public static class Solution {
        public int lengthOfLastWord(String s) {
            if (s == null || s.length() == 0) return 0;
            String [] tmp = s.split("\\s+");
            if (tmp.length == 0) return 0;
            return tmp[tmp.length-1].length();
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        String s = " ";
        int res = result.lengthOfLastWord(s);
        
        System.out.println(res);
    }
}
