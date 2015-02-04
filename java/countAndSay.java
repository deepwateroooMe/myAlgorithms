import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class countAndSay {
    public static class Solution {
        public StringBuffer getNext(StringBuffer s) {
            



        }
        
        public String countAndSay(int n) {
            StringBuffer s = new StringBuffer("1");
            while (--n > 0) {
                s = getNext(s);
                return s.toString();
            }
        }
        
        public String countAndSay0(int n) {
            StringBuffer [] res = new StringBuffer[n];
            if (n < 1) return null;
            if (n == 1) return "1";

            res[0] = new StringBuffer("1");
            for (int i = 1; i < n ; i++) {
                res[i] = new StringBuffer();
                if (res[i-1].length() == 1) {
                    res[i].append(1);
                    res[i].append(res[i-1].charAt(0));
                    continue;
                }
                int slow = 0;
                char tmp = res[i-1].charAt(0);
                int j = 1;
                for ( j = 1; j < res[i-1].length(); j++) {
                    tmp = res[i-1].charAt(slow);
                    if (res[i-1].charAt(j) == tmp) continue;
                    if (j < res[i-1].length() && res[i-1].charAt(j) != tmp) {
                        res[i].append(j-slow);
                        res[i].append(res[i-1].charAt(slow));
                        slow = j;
                        continue;
                    }
                }
                if (j == res[i-1].length() && slow == 0) {
                    res[i].append(j);
                    res[i].append(res[i-1].charAt(0));
                } else if (j == res[i-1].length() && slow < j) {
                    res[i].append(j-slow);
                    res[i].append(res[i-1].charAt(slow));
                }
            }
            return res[n-1].toString();
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        String res = result.countAndSay(9);
        
        System.out.println(res);
    }
}
