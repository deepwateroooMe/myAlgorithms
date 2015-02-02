import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class findSubstring {
    public static class Solution {
        // https://oj.leetcode.com/discuss/1062/time-limit-exceeded-a-very-normal-algorithm s.substr()
        // mind is NOT working any more tonight, but should be able to figure out tomorrow
        public List<Integer> findSubstring(String s, String[] l) {
            List<Integer> res = new ArrayList<Integer>();
            int n = l.length;
            int m = l[0].length();
            if (s.length() < n * m) return res;
            Map<String, Integer> hash = new HashMap<String, Integer>();
            for(String i : l)
                if (hash.containsKey(i)) hash.put(i, hash.get(i) + 1);                    
                else hash.put(i, 1); 
            Map<String, Integer> fnd = new HashMap<String, Integer>();
            String tmp;
            int cnt = 0;
            int j;
            for (int i = 0; i <= s.length() - m * n; i++) {
                tmp = s.substring(i, i + m);
                cnt = 0;
                j = i;
                fnd.clear();
                while (hash.containsKey(tmp) && (!fnd.containsKey(tmp) || fnd.get(tmp) < hash.get(tmp))) {
                    if (!fnd.containsKey(tmp)) fnd.put(tmp, 1);
                    else fnd.put(tmp, fnd.get(tmp) + 1);
                    ++cnt;
                    j += m;
                    if (j + m <= s.length())
                        tmp = s.substring(j, j + m);
                }
                if (cnt == n) res.add(i);
            }
            return res;
        }
    }
   
    public static void main(String[] args){
        Solution result = new Solution();
        String [] a = {""};
        String s = "";
        List<Integer> res = new ArrayList<Integer>();
        res = result.findSubstring(s, a);

        System.out.println(res);
    }
}

/*
   Time Limit ExceededMore Details 
  Runtime Error Message:	Line 53: java.lang.StringIndexOutOfBoundsException: String index out of range: 12
Last executed input:	"abaababbaba", ["ab","ba","ab","ba"]

  Runtime Error Message:	Line 60: java.lang.StringIndexOutOfBoundsException: String index out of range: 7
Last executed input:	"aaaaaa", ["aaa","aaa"]

  Runtime Error Message:	Line 25: java.lang.StringIndexOutOfBoundsException: String index out of range: -1
  Last executed input:	"barfoothefoobarman", ["foo","bar"]

  String [] a = {"fooo","barr","wing","ding","wing"};
  String s = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
  Last executed input:	"aaaaaaaa", ["aa","aa","aa"]
*/
