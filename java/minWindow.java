import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class minWindow {
    public static class Solution {
        public String minWindow(String s, String t) {
            Map<Character, Integer> hash = new HashMap<Character, Integer>();
            for (int i = 0; i < t.length(); i++) 
                if (!hash.containsKey(t.charAt(i)))
                    hash.put(t.charAt(i), 1);
                else hash.put(t.charAt(i), hash.get(t.charAt(i)) + 1);
            Map<Character, Integer> fnd = new HashMap<Character, Integer>();
            int fndCnt = 0;
            int slow = 0, fast = slow, size, minl = Integer.MAX_VALUE;
            StringBuffer res = new StringBuffer("");
            char j;
            while (fast < s.length()) {
                j = s.charAt(fast);
                if (hash.containsKey(j)) {
                    if (!fnd.containsKey(j)) {
                        fnd.put(j, 1);
                        fndCnt++;
                    } else {
                        if (fnd.get(j) < hash.get(j)) 
                            fndCnt++;
                        fnd.put(j, fnd.get(j) + 1);  
                    }
                }
                if (fndCnt == t.length()) {
                    char sc = s.charAt(slow);
                    while (!fnd.containsKey(sc) || fnd.get(sc) > hash.get(sc)) {
                        if (fnd.containsKey(sc) && fnd.get(sc) > hash.get(sc))
                            fnd.put(sc, fnd.get(sc) - 1);
                        slow++;
                        sc = s.charAt(slow);
                    }
                    if (fast - slow + 1 < minl) {
                        minl = fast - slow + 1;
                        res = new StringBuffer(s.substring(slow, fast + 1));
                    }
                }
                fast++;
            }
            return res.toString();
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        String s = "bbaac";
        String t = "aba";
        String res = result.minWindow(s, t);
        
        System.out.println(res);
    }
}

/*
  Time Limit ExceededMore Details 
  Last executed input:	"bbaac", "aba"

  Input:	"aa", "aa"
  Output:	""
  Expected:	"aa"

  Input:	"ab", "a"
  Output:	""
  Expected:	"a"
*/
