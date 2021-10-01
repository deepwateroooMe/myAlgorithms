import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class restoreIpAddress {
    public static class Solution {

        public void helper(String s, List<String> res, StringBuffer ip, int j, int done) {
            StringBuffer one = new StringBuffer();
            StringBuffer two = new StringBuffer();
            StringBuffer thr = new StringBuffer();
            one.append(ip);

            if (j == s.length() && done == 4) {
                one.deleteCharAt(one.length() - 1);
                res.add(one.toString());
                return;
            } else if ((j < s.length() && done == 4) || j == s.length() ) 
                return;   
            
            int i = j;
            if (s.charAt(i) == '0') {
                one.append("0.");
                helper(s, res, one, i + 1, done + 1);
            } else if (s.charAt(i) - '0' > 2) {
                one.append(s.charAt(i));
                two.append(one);
                one.append(".");
                helper(s, res, one, i + 1, done + 1);
                if (i < s.length() - 1) {
                    two.append(s.charAt(++i) + ".");
                    helper(s, res, two, i + 1, done + 1);
                }
            } else if (s.charAt(i) == '1') {
                one.append(s.charAt(i));
                two.append(one);
                one.append(".");
                helper(s, res, one, i + 1, done + 1);
                if (i < s.length() - 1) {
                    two.append(s.charAt(++i));
                    thr.append(two);
                    two.append(".");
                    helper(s, res, two, i + 1, done + 1);
                    if (i < s.length() - 1) {
                        thr.append(s.charAt(++i) + ".");
                        helper(s, res, thr, i + 1, done + 1);
                    }
                }
            } else { //2
                one.append(s.charAt(i));
                two.append(one);
                one.append(".");
                helper(s, res, one, i + 1, done + 1);
                if (i < s.length() - 1) {
                    two.append(s.charAt(++i));
                    thr.append(two);
                    two.append(".");
                    helper(s, res, two, i + 1, done + 1);
                    if (i < s.length() - 1 &&
                        ( (s.charAt(i) == '5'  && s.charAt(i + 1) - '0' < 6) || (s.charAt(i) - '0' < 5)) ) {
                        thr.append(s.charAt(++i) + ".");
                        helper(s, res, thr, i + 1, done + 1);
                    }
                }
            }
        }
        
        public List<String> restoreIpAddresses(String s) {
            List<String> res = new ArrayList<String>();
            //if (s == null || s.length() < 4 || s.length() > 12) return res;
            StringBuffer ip = new StringBuffer("");
            dfs(s, res, ip, 0, 0);
            return res;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        //String s = "25525511135";
        String s = "172162541";
        List<String> res = result.restoreIpAddresses(s);

        System.out.println(res);
    }
}

/*
  Input:	"172162541"
  Output:	["172.16.25.41","172.16.254.1","172.162.5.41","172.162.54.1"]
  Expected:	["17.216.25.41","17.216.254.1","172.16.25.41","172.16.254.1","172.162.5.41","172.162.54.1"]

*/
