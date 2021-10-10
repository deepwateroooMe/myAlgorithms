// import com.UnionFind;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toMap;
public class string {
    public static class Solution {

        // public static int base = 256;
        // public static int module = 101;
        // public static boolean match(String str1,String str2) {
        //     assert str1.length() == str2.length();
        //     for (int i = 0; i < str1.length(); i++) {
        //         if (str1.charAt(i)! = str2.charAt(i))
        //             return false; 
        //     }
        //     return true; 
        // }
        // public static int hash(String str) {
        //     int hash = 0; 
        //     for (int i = 0; i < str.length(); i++)
        //         hash = (hash*base+str.charAt(i))/module; 
        //     return hash; 
        // }
        // public int strStr(String haystack, String needle) {
        //     if (needle == "" || needle.length() == 0)
        //         return 0; 
        //     int n = haystack.length(), m = needle.length(); 
        //     int targetHash = hash(needle); 
        //     for (int i = 0; i < n-m+1; i++) {
        //         String str = haystack.substring(i,i+m); 
        //         if (hash(str) == targetHash)
        //             if (match(str,needle))
        //                 return i; 
        //     }
        //     return -1; 
        // }

        
        // public List<String> findAndReplacePattern(String[] words, String pattern) {
        //     int n = words.length, m = pattern.length(), i = 0;
        //     Arrays.sort(words);
        //     Map<Character, Character> map = new HashMap<>();
        //     List<String> res = new ArrayList<>();
        //     for (String s : words) {
        //        if (s.length() != m) continue;
        //        map.clear();
        //        for ( i = 0; i < s.length(); i++) {
        //            if (!map.containsKey(s.charAt(i))) {
        //                if (map.values().contains(pattern.charAt(i))) break;
        //                map.put(s.charAt(i), pattern.charAt(i));
        //                continue;
        //            }
        //            if (map.get(s.charAt(i)) != pattern.charAt(i)) break;
        //        }
        //        if (i < s.length()) continue;
        //        res.add(s);
        //     }
        //     return res;
        // }

        // public int minSteps(String s, String t) {
        //     int n = s.length();
        //     int [][] cnt = new int [2][26];
        //     for (int i = 0; i < n; i++) {
        //         cnt[0][s.charAt(i)-'a']++;
        //         cnt[1][t.charAt(i)-'a']++;
        //     }
        //    int res = 0;
        //     for (int i = 0; i < 26; i++)
        //         if (cnt[1][i] < cnt[0][i])
        //             res += cnt[0][i] - cnt[1][i];
        //     return res;
        // }

        // public List<String> subdomainVisits(String[] cpdomains) {
        //     int n = cpdomains.length;
        //     int cnt = 0, m = 0, i = 0, j = 0;
        //     Map<String, Integer> map = new HashMap<>();
        //     for (String s : cpdomains) {
        //         m = s.length();
        //         i = 0;
        //         while (i < m && s.charAt(i) != ' ') i++;
        //         cnt = Integer.parseInt(s.substring(0, i));
        //         j = m-1;
        //         while (j > i) {
        //             while (j > 0 && s.charAt(j) != '.' && s.charAt(j) != ' ') --j;
        //             map.put(s.substring(j+1), map.getOrDefault(s.substring(j+1), 0) + cnt);
        //             if (s.charAt(j) == ' ') continue;
        //             --j;
        //         }
        //     }
        //     List<String> res = new ArrayList<>();
        //     map.forEach((k, v) -> {
        //             res.add(String.valueOf(v) + " " + k);
        //         });
        //     return res;
        // }


        // private int getMatchedRIdx(String s, int idx) {
        //     int n = s.length();
        //     int l = 0, r = 0, i = idx;
        //     for (; i < n; i++) {
        //         if (s.charAt(i) == '{') ++l;
        //         else if (s.charAt(i) == '}') {
        //             if (l > 0) --l;
        //             else ++r;
        //         }
        //         if (l == r) break;
        //     }
        //     return i;
        // }
        // private int getChunkIdx(String s, int idx) {
        //     int n = s.length();
        //     int l = 0, r = 0, i = idx;
        //     boolean recnt = true;
        //     while (i < n) {
        //         // for (; i < n; i++) {
        //         while (i < n && (l != r || l == r && recnt)) {
        //             if (l == r && recnt) recnt = false;
        //             if (s.charAt(i) == '{') ++l;
        //             else if (s.charAt(i) == '}') {
        //                 if (l > 0) --l;
        //                 else ++r;
        //             }
        //             if (l == r) break;
        //             ++i;
        //         }
        //         if (i < n)
        //         if (i == n-1 || i < n-1 && s.charAt(i) == ',') return i;
        //         ++i;
        //         recnt = true;
        //     }
        //     return -1;
        // }
        // private Set<String> parseOneChunk(String s) { // { , , } or {c, d}{a, b} or {ab{}, b}
        //     int n = s.length();
        //     HashSet<String> ss = new HashSet<>();
        //     int i = 0, j = getMatchedRIdx(s, i);
        //     Set<String> tmp = new HashSet<String>(braceExpansionII(s.substring(i+1, j)));
        //     if (j == n-1) return ss;
        //     Set<String> rest = new HashSet<String>(braceExpansionII(s.substring(j+1))); // 这里得不到{c, d, e}的结果？！！
        //     for (String left : tmp) 
        //         for (String right : rest) 
        //             ss.add(left + right);
        //     return ss;
        // }
        // public List<String> braceExpansionII(String s) {
        //     int n = s.length();
        //     HashSet<String> ss = new HashSet<>();
        //     if (n == 1) {
        //         ss.add(s);
        //         return new ArrayList<String>(ss);
        //     }
        //     // int i = 0, j = 0;
        //     int i = 0;
        //     if (s.charAt(i) == '{') { // parse until get valid , not inside commas { , , }
        //         int j = getChunkIdx(s, i);
        //         if (j == n-1) return new ArrayList<>(parseOneChunk(s.substring(i, j+1))); // {{}, , }
        //         Set<String> left = parseOneChunk(s.substring(i, j+1));  // {}{}  or {}{{}{}} etc
        //         Set<String> right = parseOneChunk(s.substring(j+1));
        //         for (String leftv : left) 
        //             for (String rightv : right) 
        //                 ss.add(leftv + rightv);
        //         return new ArrayList<>(ss);
        //     }
        //     if (Character.isLetter(s.charAt(i))) { // 这里某个地方断掉了，"{a,b}{c,{d,e}}";
        //         int j = i;  
        //         while (j < n && Character.isLetter(s.charAt(j))) ++j;  // abcd
        //         String tmp = s.substring(i, j);
        //         System.out.println("tmp: " + tmp);
        //         if (j == n || s.charAt(j) == ',') { // j : , {
        //             ss.add(tmp);
        //             if (j == n) {
        //                 return new ArrayList<>(ss);   
        //             }
        //             // i = j+1; // skipped ,
        //             Set<String> rest = new HashSet<>(braceExpansionII(s.substring(j+1)));
        //             ss.addAll(rest);
        //             return new ArrayList<>(ss);  
        //         } else { // if (s.charAt(j) == '{') {
        //             int k = j;
        //             while (k < n && s.charAt(k) != ',') ++k;
        //             Set<String> chunk = parseOneChunk(s.substring(j, k)); // [j, k)
        //             for (String v : chunk) 
        //                 ss.add(tmp + v);
        //             if (k == n) return new ArrayList<>(ss);
        //             i = k+1; // skipped ,
        //         }
        //     }
        //     return new ArrayList<>(ss);
        // }

        
        // public int minDeletionSize(String[] strs) {
        //     int m = strs.length;
        //     int n = strs[0].length;
        //     Arrays.sort(strs);
        // }


        // public int[] maxDepthAfterSplit(String s) {
        //     int n = s.length(), depth = 0;
        //     int [] ans = new int [n];
        //     for (int i = 0; i < n; i++) 
        //         if (s.charAt(i) == '(') 
        //             ans[i] = depth++ % 2;
        //         else  // ')'
        //             ans[i] = ++depth % 2;
        //     return ans;
        // }


        // public String removeOccurrences(String s, String part) {
        //     int n = s.length();
        //     int m = part.length();
        //     int i = 0, j = 0, lj = 0;
        //     while (i < n) {
        //         while (i < n && s.charAt(i) != part.charAt(0)) ++i;
        //         if (i == n || i+m > n) return s;
        //         if (s.substring(i, i+m).equals(part)) {
        //             if (i == 0)
        //                 return removeOccurrences(s.substring(i+m), part);
        //             else {
        //                 String tmp = removeOccurrences(s.substring(i+m), part);
        //                 String left =  s.substring(0, i);
        //                 for (int j = i-1; j >= Math.max(0, i-(m-1)); j--) {
        //                 }
        //                 return left + tmp; // bug: nested part : dababc for part abc
        //             }
        //         }
        //         else ++i;
        //     }
        //     return s;
        // }
        // public String removeOccurrences(String s, String part) {
        //     int n = s.length();
        //     int m = part.length();
        //     Stack<Character> st = new Stack<>();
        //     Stack<Character> sr = new Stack<>();
        //     int i = 0;
        //     while (i < n) {
        //         while (i < n && s.charAt(i) != part.charAt(0)) {
        //             st.push(s.charAt(i));
        //             ++i;
        //         }
        //         if (i == n || i + m > n) return s;
        //         if (s.substring(i, i+m).equals(part)) {
        //             if (i + m == n) break; // process stack chars
        //             int j = part.indexOf(s.charAt(i+m)), oj = j; // 这里的思路还是没能理清楚
        //             if (s.substring(i+m).startsWith(part.substring(j))) {
        //                 // if (st.size() < m - j) i = i+m;
        //                 // else {
        //                 if (st.size() >= m - j) {
        //                     --j;
        //                     while (j >= 0 && st.peek() == part.charAt(j)) {
        //                         sr.push(st.pop());
        //                         --j;
        //                     }
        //                     if (j < 0) {
        //                         sr.clear();
        //                         // i = i + m +  m - oj;
        //                         i += m - oj;
        //                     } esle {
        //                         while (sr.size() > 0)
        //                             st.push(sr.pop());
        //                         // i = i + m;
        //                     }
        //                 }
        //             }
        //             // i = i+m;
        //         }
        //         else ++i;
        //     }
        // }

        
    //     public String evaluate(String s, List<List<String>> knowledge) {
    //         int n = s.length();
    //         Map<String, String> m = new HashMap<>();
    //         for (List<String> ls : knowledge) 
    //             m.put(ls.get(0), ls.get(1));
    //         StringBuilder sb = new StringBuilder();
    //         int i = 0, j = 0;
    //         while (i < n) {
    //             while (i < n && s.charAt(i) != '(') {
    //                 sb.append(s.charAt(i));
    //                 ++i;
    //             }
    //             if (i == n) return sb.toString(); // i: (
    //             j = i+1;
    //             while (j < n && s.charAt(j) != ')') ++j;
    //             String tmp = s.substring(i+1, j);
    //             sb.append(m.getOrDefault(tmp, "?"));
    //             if (j == n-1) return sb.toString(); 
    //             i = j+1; // i: (
    //         }
    //         return sb.toString();
    //     }


        // public int scoreOfParentheses(String s) {
        //     int n = s.length();
        //     if (n == 0) return 0;
        //     if (n == 2) return 1;
        //     int i = 0, l = 1, r = 0, j = 1;
        //     while (j < n && l != r) {
        //         if (s.charAt(j) == '(') ++l;
        //         else {
        //             if (l > 0) --l;
        //             else ++r;
        //         }
        //         if (l == r) break;
        //         ++j;
        //     }
        //     if (j-i+1 == 2)
        //         return 1 + scoreOfParentheses(s.substring(j+1));
        //     else if (j-i+1 == 4)
        //         return 2 + scoreOfParentheses(s.substring(j+1));
        //     else return 2 * scoreOfParentheses(s.substring(i+1, j)) + scoreOfParentheses(s.substring(j+1));
        // }


        // private StringBuilder getReverse(StringBuilder s) {
        //     StringBuilder sb = new StringBuilder();
        //     int n = s.length();
        //     for (int i = n-1; i >= 0; i--) 
        //         if (s.charAt(i) == '(' || s.charAt(i) == ')') 
        //             sb.append(s.charAt(i) == '(' ? ')' : '(');
        //         else sb.append(s.charAt(i));
        //     return sb;
        // }
        // public String reverseParentheses(String s) {
        //     int n = s.length();
        //     if (n == 0) return "";
        //     StringBuilder sb = new StringBuilder();
        //     int i = 0, r = 0;
        //     while (i < n && s.charAt(i) != '(') {
        //         sb.append(s.charAt(i));
        //         ++i;
        //     }
        //     if (i == n) return sb.toString(); // i: (
        //     int j = i+1, l = 1;
        //     while (j < n && l != r) {
        //         if (s.charAt(j) == '(') ++l;
        //         else if (s.charAt(j) == ')'){
        //             if (l > 0) --l;
        //             else ++r;
        //         }
        //         if (l == r) break;
        //         ++j;  // j: )
        //     }
        //     StringBuilder tmp = getReverse(new StringBuilder(s.substring(i+1, j)));
        //     if (tmp.toString().indexOf('(') == -1) {
        //         if (j == n-1 || j < n-1 && s.substring(j+1).indexOf('(') == -1)
        //             return sb.append(tmp.toString()).toString() + s.substring(j+1);
        //         return sb.append(tmp.toString()).toString() + (j < n-1 ? reverseParentheses(s.substring(j+1)) : "");
        //     } else {
        //         if (s.substring(j+1).indexOf('(') == -1)
        //             return sb.toString() + reverseParentheses(tmp.toString()) + s.substring(j+1);
        //         return sb.toString() + reverseParentheses(tmp.toString()) + reverseParentheses(s.substring(j+1));
        //     }
        // }


        // public String minRemoveToMakeValid(String s) {
        //     int n = s.length();
        //     StringBuilder sb = new StringBuilder();
        //     int l = 0, r = 0, i = 0;
        //     for ( i = 0; i < n; i++) {
        //         if (s.charAt(i) == ')' && r > l-1) continue;
        //         sb.append(s.charAt(i));
        //         if (s.charAt(i) == '(') ++l;
        //         else if (s.charAt(i) == ')') {
        //             if (l > 0) --l;
        //             else ++r;
        //         }
        //     }
        //     while (l > 0) {
        //         i = sb.length()-1;
        //         while (l > 0 && i >= 0 && sb.charAt(i) != '(') --i;
        //         sb.deleteCharAt(i);
        //         ++i;
        //         --l;
        //     }
        //     return sb.toString();
        // }


        // public int beautySum(String s) {
        //     int n = s.length();
        //     int [][] arr = new int [n][26];
        //     arr[0][s.charAt(0)-'a'] = 1;
        //     for (int i = 1; i < n; i++) {
        //         arr[i] = arr[i-1].clone();
        //         arr[i][s.charAt(i)-'a']++;
        //     }
        //     int max = 0, min = n, sum = 0;
        //     for (int i = 0; i < n; i++) 
        //         for (int d = 1; i+d <= n; d++) {
        //             max = 0; min = n;
        //             for (char c : s.substring(i, i+d).toCharArray()) {
        //                 min = Math.min(min, arr[i+d-1][c-'a'] - (i == 0 ? 0 : arr[i-1][c-'a']));
        //                 max = Math.max(max, arr[i+d-1][c-'a'] - (i == 0 ? 0 : arr[i-1][c-'a']));
        //             }
        //             sum += max - min;
        //         }
        //     return sum;
        // }


        // public List<String> printVertically(String s) {
        //     String [] sa = s.split(" ");
        //     int n = sa.length, max = 0, j = 0;
        //     for (String str : sa)
        //         max = Math.max(max, str.length());
        //     char [][] arr = new char [max][n];
        //     for (int i = 0; i < max; i++) 
        //         Arrays.fill(arr[i], ' ');
        //     for (int i = 0; i < n; i++) 
        //         for ( j = 0; j < sa[i].length(); j++) 
        //             arr[j][i] = sa[i].charAt(j);
        //     List<String> res = new ArrayList<>();
        //     for (int i = 0; i < max; i++) 
        //         res.add((new String(arr[i])).stripTrailing());
        //     return res;
        // }

        
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        // String a = "HOW ARE YOU";
        String a = "TO BE OR NOT TO BE";
        // String a = "CONTEST IS COMING";

        List<String> res = s.printVertically(a);
        System.out.println("res.size(): " + res.size());
        for (int z = 0; z < res.size(); ++z) 
            System.out.print(res.get(z) + ", ");
        System.out.print("\n");
    }
}