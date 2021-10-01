import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class fullJustify {
    public static class Solution {
        public List<String> recursion(List<String> list, int l) {
            List<String> res = new ArrayList<String>();
            StringBuffer tmp = new StringBuffer();
            if (list.size() == 1) {
                
                tmp = new StringBuffer(list.get(0));
                for (int i = 1; i <= l - list.get(0).length(); i++)
                    tmp.append(' ');
                res.add(tmp.toString());
                return res;
            }
            
            if (list.size() > 1 && list.get(0).length() <= l &&
                list.get(0).length() + 1 + list.get(1).length() > l) {
                tmp.append(list.get(0));
                for (int i = 0; i < l - list.get(0).length(); i++) 
                    tmp.append(' ');
                list.remove(0);
                res = recursion(list, l);
                res.add(0, tmp.toString());
                return res;
            }
        
            int idx = 0, slow = 0;
            int cnt = list.get(0).length();
            while (cnt <= l && idx < list.size() - 1 && cnt + 1 + list.get(idx + 1).length() <= l) {
                cnt += 1 + list.get(++idx).length();
            }
            //System.out.println("idx: " + idx);
            if (idx == list.size() - 1) {
                cnt = 0;
                for (int i = slow; i < idx; i++) {
                    tmp.append(list.get(i));
                    tmp.append(' ');
                    cnt += list.get(i).length() + 1;
                }
                tmp.append(list.get(idx));
                cnt += list.get(idx).length();
                for (int i = 0; i < l - cnt ; i++)
                    tmp.append(' ');
                res.add(tmp.toString());
                return res;
            }
            if (idx == 1) {
                tmp.append(list.get(0));
                for (int i = 0; i < l - list.get(0).length() - list.get(1).length(); i++)
                    tmp.append(' ');
                tmp.append(list.get(1));
                list.remove(1);
                list.remove(0);
                if (list.size() > 0) {
                    res = recursion(list, l);
                    res.add(0, tmp.toString());
                } else
                    res.add(tmp.toString());
                return res;
            } // two words
            
            if (cnt < l) {
                int num = l - cnt;
                StringBuffer [] str = new StringBuffer[idx];
                for (int i = 0; i < idx; i++) {
                    str[i] = new StringBuffer(list.get(slow++));
                    str[i].append(' ');
                    for (int j = 0; j < num / idx; j++) {
                        str[i].append(' ');
                    }
                }
                for (int i = 0; i < num % idx; i++) {
                    str[i].append(' ');
                }
                for (int i = 0; i < idx; i++)
                    tmp.append(str[i]);
                tmp.append(list.get(idx));
            } else {
              for (int i = slow; i < idx; i++) {
                  tmp.append(list.get(i));
                  tmp.append(' ');
              }
              tmp.append(list.get(idx));
            }
            int size = list.size();
            for (int i = 0; i < size - idx - 1 ; i++) {
                list.set(i, list.get(i + idx + 1));
            }
            for (int i = size - 1; i >= size - idx - 1; i--) 
                list.remove(i);
            res = recursion(list, l);
            res.add(0, tmp.toString());
            return res;
        }
        
        public List<String> fullJustify0(String[] words, int L) {
            List<String> res = new ArrayList<String>();
            if (words == null) return null;
            else if (words.length == 1 && words[0] == "" && L == 0) {
                res.add("");
                return res;
            }
            if (L == 0) return null;

            List<String> list = new ArrayList<String>();
            for(String i : words)
                list.add(i);
            return recursion(list, L);
        }

        public StringBuffer addSpaces(StringBuffer s, int i, int n, int L, boolean last) {
            if (n < 1 || i > n - 1) return s;
            int spaces = last ? 1 : (L / n + (i < (L % n) ? 1 : 0));
            for (int j = 0; j < spaces; j++)
                s.append(" ");
            return s;
        }
        
        public StringBuffer connect(String [] words, int bgn, int end, int len, int L, boolean last) {
            StringBuffer s = new StringBuffer();
            int n = end - bgn + 1;
            for (int i = 0; i < n; i++) {
                s.append(words[bgn + i]);
                s = addSpaces(s, i, n - 1, L - len, last);
            }
            if (s.length() < L)
                for (int j = 0; j < L - s.length(); j++) 
                    s.append(' ');
            return s;
        }
        
        public List<String> fullJustify(String[] words, int L) {
            List<String> res = new ArrayList<String>();
            int n = words.length;
            int bgn = 0, len = 0;
            for (int i = 0; i < n; i++) {
                if (len + words[i].length() + (i - bgn) > L) {
                    res.add(connect(words, bgn, i - 1, len, L, false).toString());
                    bgn = i;
                    len = 0;
                }
                len += words[i].length();
            }
            res.add(connect(words, bgn, n - 1, len, L, true).toString());
            return res;
        }
    }
    /*
      Input:	[""], 2
Output:	[" "]
Expected:	["  "]

      Runtime Error Message:	Line 29: java.lang.ArithmeticException: / by zero
      Last executed input:	["Listen","to","many,","speak","to","a","few."], 6

Runtime Error Message:	Line 27: java.lang.IndexOutOfBoundsException: Index: 2, Size: 2
Last executed input:	["What","must","be","shall","be."], 12

Input:	["Here","is","an","example","of","text","justification."], 16
Output:	["Here   is   an","example oftext","justification.  "]
Expected:	["Here    is    an","example  of text","justification.  "]
    */
    public static void main(String[] args){
        Solution result = new Solution();
        String [] words = {""};
        int L = 2;
        List<String> res = result.fullJustify(words, L);

        for (int i = 0; i < res.size(); i++) 
            System.out.println(res.get(i) + "\t");
    }
}
/*
  [
   "This    is    an",
   "example  of text",
   "justification.  "
]
 */
