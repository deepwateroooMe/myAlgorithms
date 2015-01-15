import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class restoreIpAddress {
    public static class Solution {
        // work on tmp to backtracing
        public void helper(String s, List<String> res, StringBuffer tmp, int j, int done) {
            //System.out.println("done: " + done);
            //System.out.println("j: " + j);
            //System.out.println("s.length(): " + s.length());

            if (j == s.length() && done == 4) {
                res.add(tmp.toString());
                System.out.println("tmp f: " + tmp.toString());
                tmp = new StringBuffer();
                return;
            } else if (done == 4 && j < s.length()) {
                tmp = new StringBuffer();
                return;   
            } else if (j == s.length()) {
                tmp = new StringBuffer();
                return;   
            }
            
            int i = j;
            int n;
            if (s.charAt(i) == '0') {
                tmp.append("0.");
                helper(s, res, tmp, j + 1, done + 1);
            } else if (s.charAt(i) - '0' > 2) {
                tmp.append(s.charAt(i) + ".");
                helper(s, res, tmp, j + 1, done + 1);
                if (i < s.length() - 1) {
                    n = tmp.length() - 1;
                    tmp.deleteCharAt(n);
                    tmp.append(s.charAt(++i) + ".");
                    helper(s, res, tmp, j + 1, done + 1);
                }
            } else if (s.charAt(i) == '1') {
                tmp.append(s.charAt(i) + ".");
                helper(s, res, tmp, j + 1, done + 1);
                if (i < s.length() - 1) {
                    n = tmp.length() - 1;
                    tmp.deleteCharAt(n);
                    tmp.append(s.charAt(++i) + ".");
                    helper(s, res, tmp, j + 1, done + 1);
                    if (i < s.length() - 1) {
                        n = tmp.length() - 1;
                        tmp.deleteCharAt(n);
                        tmp.append(s.charAt(++i));
                        tmp.append(s.charAt(++i) + ".");
                        helper(s, res, tmp, j + 1, done + 1);
                    }
                }
            } else { //2
                tmp.append(s.charAt(i) + ".");
                System.out.println("tmp 20: " + tmp.toString());
                helper(s, res, tmp, j + 1, done + 1);
                if (i < s.length() - 1) {
                    tmp.append(s.charAt(++i) + ".");
                    helper(s, res, tmp, j + 1, done + 1);
                    if (i < s.length() - 1 && s.charAt(i) - '0' < 6
                        && s.charAt(i + 1) - '0' < 6) {
                        n = tmp.length() - 1;
                        tmp.deleteCharAt(n);
                        tmp.append(s.charAt(++i) + ".");
                        helper(s, res, tmp, j + 1, done + 1);
                    }
                }
            }
        }
        
        public List<String> restoreIpAddresses(String s) {
            List<String> res = new ArrayList<String>();
            if (s == null || s.length() < 4 || s.length() > 12) return res;
            StringBuffer tmp = new StringBuffer("");
            int i = 0;
            int n;
            if (s.charAt(i) == '0') {
                tmp.append("0.");
                helper(s, res, tmp, i + 1, 1);
            } else if (s.charAt(i) - '0' > 2) {
                tmp.append(s.charAt(i) + ".");
                helper(s, res, tmp, i + 1, 1);
                if (i < s.length() - 1) {
                    n = tmp.length() - 1;
                    tmp.deleteCharAt(n);
                    tmp.append(s.charAt(++i) + ".");
                    System.out.println("tmp 11: " + tmp.toString());
                    helper(s, res, tmp, i + 1, 1);
                }
            } else if (s.charAt(i) == '1') {
                tmp.append(s.charAt(i) + ".");
                helper(s, res, tmp, i + 1, 1);
                if (i < s.length() - 1) {
                    n = tmp.length() - 1;
                    tmp.deleteCharAt(n);
                    tmp.append(s.charAt(++i) + ".");
                    helper(s, res, tmp, i + 1, 1);
                    if (i < s.length() - 1) {
                        n = tmp.length() - 1;
                        tmp.deleteCharAt(n);
                        tmp.append(s.charAt(++i) + ".");
                        System.out.println("tmp 12: " + tmp.toString());
                        helper(s, res, tmp, i + 1, 1);
                    }
                }
            } else { //2
                tmp.append(s.charAt(i) + ".");
                helper(s, res, tmp, i + 1, 1);
                if (i < s.length() - 1) {
                    n = tmp.length() - 1;
                    tmp.deleteCharAt(n);
                    tmp.append(s.charAt(++i) + ".");
                    helper(s, res, tmp, i + 1, 1);
                    if (i < s.length() - 1 && s.charAt(i) - '0' < 6
                        && s.charAt(i + 1) - '0' < 6) {
                        n = tmp.length() - 1;
                        tmp.deleteCharAt(n);
                        tmp.append(s.charAt(++i) + ".");
                System.out.println("tmp 20: " + tmp.toString());
                        helper(s, res, tmp, i + 1, 1);
                    }
                }
            }
            return res;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        String s = "25525511135";
        List<String> res = result.restoreIpAddresses(s);

        System.out.println(res);
    }
}
