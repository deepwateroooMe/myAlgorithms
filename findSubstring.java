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
            if (s == null || l == null || (s.length() == 0 && l.length == 0)) return null;
            int n = l.length;
            int m = l[0].length();
            if (s.length() < n * m) return res;

            Map<String, Integer> hash = new HashMap<String, Integer>();
            Map<String, Integer> fnd = new HashMap<String, Integer>();
            for(String i : l)
                if (hash.containsKey(i))
                    hash.put(i, hash.get(i) + 1);
                else 
                    hash.put(i, 1);

            int bgn = 0;
            int slow = bgn;
            int fast = slow + m;
            String tmp;
            int one = slow;
            int cnt = 0, counter = 0;
            tmp = s.substring(slow, fast).toString();
            while (fast < s.length() && !hash.containsKey(tmp)) {
                slow++;
                fast = slow + m;
                tmp = s.substring(slow, fast).toString();
            }
            one = slow;
            System.out.println("one 0: " + one);
            fast = slow + m;
            while (counter < m) {
                while (fast < s.length()) {
                    tmp = s.substring(slow, fast).toString();
                    while (fast < s.length() && hash.containsKey(tmp)) {
                        System.out.println("");
                        System.out.println("tmp: " + tmp);
                        System.out.println("slow: " + slow);
                        System.out.println("fast: " + fast);

                        if (!fnd.containsKey(tmp) ||
                            (fnd.containsKey(tmp) && hash.get(tmp) > 1) ) {
                            System.out.println("GotHere");
                            if (!fnd.containsKey(tmp))
                                fnd.put(tmp, 1);
                            else
                                fnd.put(tmp, fnd.get(tmp) + 1);
                            ++cnt;
                            if (cnt == n) {
                                System.out.println("one: " + one);
                                res.add(one);
                                fnd.remove(s.substring(one, one+m));
                                slow += m;   
                                fast = slow + m;
                                one = slow;
                                --cnt;
                            } else {
                                slow += m;
                                fast += m;
                            }
                        }
                    }
                    while (fast < s.length() && !hash.containsKey(tmp)) {
                        slow += m;
                        fast += m;
                        fnd.clear();
                        cnt = 0;
                        one = slow;
                        tmp = s.substring(slow, fast).toString();
                    }
                }
                fnd.clear(); 
                slow = ++bgn;
                fast = slow + m;
                ++counter;
            }
            return res;
        }
    }
   
    public static void main(String[] args){
        Solution result = new Solution();
        String [] a = {"foo","bar"};
        String s = "barfoothefoobarman";
        List<Integer> res = new ArrayList<Integer>();
        res = result.findSubstring(s, a);

        System.out.println(res);
    }
}

/*
  Runtime Error Message:	Line 60: java.lang.StringIndexOutOfBoundsException: String index out of range: 7
Last executed input:	"aaaaaa", ["aaa","aaa"]

  Runtime Error Message:	Line 25: java.lang.StringIndexOutOfBoundsException: String index out of range: -1
  Last executed input:	"barfoothefoobarman", ["foo","bar"]

  String [] a = {"fooo","barr","wing","ding","wing"};
  String s = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
  Last executed input:	"aaaaaaaa", ["aa","aa","aa"]
*/
