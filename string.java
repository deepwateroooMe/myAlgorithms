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


        // private boolean isPalindrome(String s, int i, int j) { // TLE TLE TLE
        //     char [] arr = s.toCharArray();
        //     while (i < j) {
        //         if (arr[i] != arr[j]) return false;
        //         i++;
        //         j--;
        //     }
        //     return true;
        // }
        // public String shortestPalindrome(String s) {
        //     int j = s.length()-1;
        //     while (j >= 0) {
        //         if (isPalindrome(s.substring(0, j+1), 0, j)) break;
        //         else --j;
        //     }
        //     return (new StringBuilder (s.substring(j+1)).reverse()) + s;
        // }
        // public String shortestPalindrome(String s) { // todo: 这个题还有几种解法，需要再完善一下
        //     int n = s.length(), j = 0;
        //     for (int i = n-1; i >= 0; i--) 
        //         if (s.charAt(i) == s.charAt(j)) j++;
        //     if (j == s.length()) return s;
        //     String suffix = s.substring(j);
        //     return new StringBuilder(suffix).reverse().toString() + shortestPalindrome(s.substring(0, j)) + suffix;
        // }


        // public String findDifferentBinaryString(String[] arr) {
        //     int m = arr.length;
        //     int n = arr[0].length();
        //     Set<Long> s = new HashSet<>();
        //     for (String v : arr)  
        //         s.add(Long.parseLong(v));
        //     for (long i = 0; i < (1 << n); i++) {
        //         if (!s.contains(Long.parseLong(Long.toBinaryString(i)))) {
        //             String res = Long.toBinaryString(i);
        //             if (res.length() < n)
        //                 res = "0".repeat(n-res.length()) + res;
        //             return res;
        //         }
        //     }
        //     return "";
        // }


        //  public boolean queryString(String s, int n) { // Bug: Long.parseLong(string) format wrong overflow //
        //     int m = s.length();
        //     Set<Long> si = new HashSet<>();
        //     int len = Long.toBinaryString(n).length();
        //     for (int i = 0; i < m; i++) 
        //         for (int j = i+1; j <= Math.min(m, Math.min(i+len, i+31)); j++) 
        //             si.add(Long.parseLong(s.substring(i, j)));
        //     for (int i = 1; i <= n; i++) 
        //         if (!si.contains(Long.parseLong(Long.toBinaryString(i)))) return false;
        //     return true;
        // }
        // public boolean queryString(String s, int n) {
        //     for (int i = 1; i <= n; i++) {
        //         String si = Integer.toBinaryString(i);
        //         if (!s.contains(si)) return false;
        //     }
        //     return true;
        // }


        // public String removeOccurrences(String s, String part) {
        //     if (!s.contains(part)) return s;
        //     int n = s.length();
        //     int m = part.length();
        //     while (s.contains(part)) {
        //         int idx = s.indexOf(part);
        //         s = s.substring(0, idx) + (idx+m-1 == n-1 ? "" : s.substring(idx+m));
        //     }
        //     return s;
        // }
        // private int [] buildNext(String s) { // 找与每个位置字符不同的下一个字母的idx KMP 
        //     int [] next = new int [s.length()];
        //     for (int i = 0, j = next[0] = -1; i < s.length()-1; ) {
        //         if (j == -1 || s.charAt(i) == s.charAt(j)) {
        //             i++;
        //             j++;
        //             next[i] = s.charAt(i) != s.charAt(j) ? j : next[j];
        //         } else j = next[j];
        //     }
        //     return next;
        // }
        // private int kmp(String s, String p, int [] next) { // 像是夹生饭，半生不熟的
        //     for (int i = 0, j = 0; i < s.length(); ) {
        //         if (j == -1 || s.charAt(i) == p.charAt(j)) {
        //             i++;
        //             j++;
        //         } else j = next[j];
        //         if (j == p.length()) return i-j;
        //     }
        //     return -1;
        // }
        // public String removeOccurrences(String s, String part) {
        //     int [] next = buildNext(part);
        //     int idx = -1;
        //     while ((idx = kmp(s, part, next)) != -1) 
        //         s = s.substring(0, idx) + s.substring(idx + part.length());
        //     return s;
        // }

        
         // public String makeLargestSpecial(String s) {
         //    int n = s.length();
         //    List<String> list = new ArrayList<>();
         //    int cnt = 0, j = 0;
         //    for (int i = 0; i < n; i++) {
         //        if (s.charAt(i) == '1') ++cnt;
         //        else --cnt;
         //        if (cnt == 0) {
         //            list.add("1"+makeLargestSpecial(s.substring(j+1, i)) + "0");
         //            j = i+1;
         //        }
         //    }
         //    Collections.sort(list, (a, b)-> b.compareTo(a));
         //    String res = "";
         //    for (String  v : list) res += v;
         //    return res;
         // }

        
        // This question is pretty like basic calculator.
        // We traverse formula in inverted order and use stack to save the multiples which are outside parenthesis.
        // Besides, we use TreeMap to keep chemical elements in lexicographical order.
        // public String countOfAtoms(String s) {
        //     TreeMap<String, Integer> map = new TreeMap<>();
        //     Stack<Integer> stack = new Stack<>();
        //     int cur = 1;
        //     for (int i = s.length()-1; i >= 0; i--) {
        //         char c = s.charAt(i);
        //         if (Character.isDigit(c)) {
        //             cur = c - '0';
        //             while (i-1 >= 0 && Character.isDigit(s.charAt(i-1)))
        //                 cur = (s.charAt(--i)-'0')*10 + cur;
        //         } else if (Character.isLetter(c)) {
        //             StringBuilder sb = new StringBuilder();
        //             sb.append(c);
        //             if (Character.isLowerCase(c) && i-1 >= 0 && Character.isUpperCase(s.charAt(i-1)))
        //                 sb.append(s.charAt(--i));  //concatenate if and only if c is lower case 
        //             for (int val : stack) 
        //                 cur *= val; 
        //             String key = sb.reverse().toString();
        //             map.put(key, map.getOrDefault(key, 0) + cur);
        //             cur = 1;
        //         } else if (c == ')') {
        //             stack.push(cur);
        //             cur = 1;
        //         } else if (c == '(') stack.pop();
        //     }
        //     StringBuilder sb = new StringBuilder();
        //     for (Map.Entry<String, Integer> en : map.entrySet()) 
        //         sb.append(en.getKey()).append(en.getValue() == 1 ? "" : en.getValue());
        //     return sb.toString();
        // }
        // private Map<String, Integer> parseString(String s) { // 自己写的，还没有找出来bug是出在哪里了
        //     int n = s.length(), i = 0, j = 0, cur = 0;
        //     Map<String, Integer> m = new HashMap<>();
        //     String pre = "";
        //     while (i < n) {
        //         char c = s.charAt(i);
        //         if (Character.isUpperCase(c)) {
        //             if (i == n-1 || i < n-1 && Character.isUpperCase(s.charAt(i+1))) {
        //                 m.put(""+c, m.getOrDefault(c, 0) + 1);
        //                 i += 1;
        //                 continue;
        //             } else if (i < n-1 && Character.isLowerCase(s.charAt(i+1))) { // default 1 lowercase per name
        //                 pre = s.substring(i, i+2);
        //                 i += 2;
        //             } else if (i < n-1 && Character.isDigit(s.charAt(i+1))) {
        //                 pre = "" + s.charAt(i);
        //                 i += 1;
        //             }
        //             if (i < n && Character.isDigit(s.charAt(i))) {
        //                 j = i;
        //                 while (j < n && Character.isDigit(s.charAt(j))) 
        //                     cur = cur * 10 + s.charAt(j++)-'0';
        //                 m.put(pre, cur);
        //                 i = j;
        //             }
        //         }
        //     }
        //     return m;
        // }
        // public String countOfAtoms(String s) {
        //     int n = s.length();
        //     Map<String, Integer> m = new HashMap<>();
        //     int i = 0, j = 0, cur = 0, l = 0, r = 0;
        //     String pre = "";
        //     while (i < n) {
        //         while (i < n && s.charAt(i) != '(') i++;
        //         if (i > j) {
        //             Map<String, Integer> sub = parseString(s.substring(j, i));
        //             for (Map.Entry<String, Integer> en : sub.entrySet()) {
        //                 String key = en.getKey();
        //                 m.put(key, m.getOrDefault(key, 0) + en.getValue());
        //             }
        //         }
        //         if (i < n && s.charAt(i) == '(') {
        //             j = i+1;
        //             l = 1; r = 0;
        //             while (j < n && l != r) {
        //                 if (s.charAt(j) == '(') ++l;
        //                 else if (s.charAt(j) == ')') {
        //                     if (l > 0) --l;
        //                     else ++r;
        //                 }
        //                 if (l == r) break;
        //                 ++j;
        //             }
        //             String one = countOfAtoms(s.substring(i+1, j));
        //             Map<String, Integer> sub = parseString(one);
        //             i = j + 1;
        //             j += 1;
        //             if (j < n && Character.isDigit(s.charAt(j))) {
        //                 cur = 0;
        //                 while (j < n && Character.isDigit(s.charAt(j))) 
        //                     cur = cur * 10 + s.charAt(j++)-'0';
        //             }
        //             for (Map.Entry<String, Integer> en : sub.entrySet()) {
        //                 String key = en.getKey();
        //                 m.put(key, m.getOrDefault(key, 0) + en.getValue() * cur);
        //             }
        //             i = j;
        //         }
        //     }
        //     String res = "";
        //     for (Map.Entry<String, Integer> en : m.entrySet()) {
        //         res += en.getKey();
        //         int v = en.getValue();
        //         if (v > 1)
        //             res += String.valueOf(en.getValue());
        //     }
        //     return res;
        // }


        // public int minNumberOfFrogs(String s) {
        //     int n = s.length();
        //     int cc = 0, cr = 0, co = 0, ca = 0, cnt = 0, max = 0;
        //     for (int i = 0; i < n; i++) {
        //         char c = s.charAt(i);
        //         if (c == 'c') {
        //             ++cc;
        //             ++cnt;
        //             max = Math.max(max, cnt);
        //         } else if (c == 'r') {
        //             if (cc == 0) return -1;
        //             --cc;
        //             ++cr;
        //         } else if (c == 'o') {
        //             if (cr == 0) return -1;
        //             --cr;
        //             ++co;
        //         } else if (c == 'a') {
        //             if (co == 0) return -1;
        //             --co;
        //             ++ca;
        //         } else if (c == 'k') {
        //             if (ca == 0) return -1;
        //             --ca;
        //             --cnt;
        //         }
        //     }
        //     if (cc + cr + co + ca > 0) return -1;
        //     return max;
        // }
        // public int minNumberOfFrogs(String s) {
        //     int n = s.length();
        //     int cnt [] = new int [5];
        //     int cur = 0, max = 0;
        //     for (int i = 0; i < n; i++) {
        //         char c = s.charAt(i);
        //         int idx = "croak".indexOf(c);
        //         ++cnt[idx];
        //         if (idx == 0)
        //             max = Math.max(max, ++cur);
        //         else if (--cnt[idx-1] < 0)
        //             return -1;
        //         else if (idx == 4)
        //             --cur;
        //     }
        //     return cur == 0 ? max : -1; // 如果最后所有的青蛙都叫完了的话  
        // }
        // public int minNumberOfFrogs(String croakOfFrogs) {
        //     char[] ch = croakOfFrogs.toCharArray();
        //     int curr = 0;
        //     int res = 0;
        //     int c = 0, r = 0, o = 0, a = 0, k = 0;
        //     for(int i = 0; i < ch.length; i++) {
        //         if(ch[i] == 'c') {
        //             c++;
        //             curr++;
        //         } else if(ch[i] == 'r') 
        //             r++;
        //         else if(ch[i] == 'o') 
        //             o++;
        //          else if(ch[i] == 'a') 
        //             a++;
        //          else {
        //             k++; 
        //             curr--;
        //         }
        //         res = Math.max(res, curr);
        //         if (c < r || r < o || o < a || a < k) // 要满足所有的条件
        //             return -1;
        //     }
        //     if ((c == r) && (r == o ) && ( o == a) &&  (a == k)) 
        //         return res;
        //     return -1;
        // }


        // public int compress(char[] arr) {
        //     int n = arr.length;
        //     int idx = 1, cnt = 1, i = 0, j = 0;
        //     while (i < n) {
        //         while (i < n-1 && s.charAt(i) == s.charAt(i+1)) {
        //             i++;
        //             cnt++;
        //         }
        //         if (cnt == 1)
        //     }
        // }

        
        // public String shiftingLetters(String s, int[] shifts) {
        //     int n = s.length();
        //     shifts[n-1] %= 26;
        //     for (int i = n-2; i >= 0; i--) {
        //         shifts[i] += shifts[i+1] % 26;
        //         shifts[i] %= 26;
        //     }
        //     char [] arr = s.toCharArray();
        //     for (int i = 0; i < n; i++) {
        //         arr[i] += shifts[i];
        //         while (arr[i] > 'z')
        //             arr[i] -= 26;
        //     }
        //     return new String(arr);
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
        //         System.out.println("(j == n || s.charAt(j) == ','): " + (j == n || s.charAt(j) == ','));
                
        //         if (j == n || s.charAt(j) == ',') { // j : , {
        //             ss.add(tmp);

        //             // System.out.println("s.substring(j+1): " + s.substring(j+1));
        //             // List<String> tmpLs = braceExpansionII(s.substring(j+1));
        //             // System.out.println("tmpLs.size(): " + tmpLs.size());
        //             // System.out.println(Arrays.toString(tmpLs.toArray()));

        //             Set<String> rest = new HashSet<>(braceExpansionII(s.substring(j+1))); // 不知道为什么，这里的结果返不回来
        //             ss.addAll(rest);
        //             return new ArrayList<>(ss);  
        //         } else { // if (s.charAt(j) == '{') {, needs to find the matched
        //             int k = j;
        //             while (k < n && s.charAt(k) != '}') ++k;
        //             Set<String> chunk = parseOneChunk(s.substring(j, k)); // [j, k)
        //             for (String v : chunk) 
        //                 ss.add(tmp + v);
        //             if (k == n) return new ArrayList<>(ss);
        //             i = k+1; // skipped ,
        //         }
        //     }
        //     return new ArrayList<>(ss);
        // }


        // public int repeatedStringMatch(String s, String t) {
        //     StringBuilder sb = new StringBuilder();
        //     int cnt = 0;
        //     while (sb.length() < s.length() + t.length()) {
        //         sb.append(s);
        //         ++cnt;
        //         if (sb.indexOf(t) != -1) return cnt;
        //     }
        //     return -1;
        // }


        // private String invert(String s) {
        //     char [] arr = s.toCharArray();
        //     StringBuilder sb = new StringBuilder();
        //     for (int i = 0; i < s.length(); i++) 
        //         sb.append(arr[i] == '1' ? '0' : '1');
        //     return sb.toString();
        // }
        // private String reverse(String s) {
        //     return new StringBuilder(s).reverse().toString();
        // }
        // public char findKthBit(int n, int k) {
        //     if (n == 1) return '0';
        //     String [] arr = new String [n]; 
        //     arr[0] = "0";
        //     for (int i = 1; i < n; i++) 
        //         arr[i] = arr[i-1] + "1" + reverse(invert(arr[i-1]));
        //     return arr[n-1].charAt(k-1);
        // }
        // public char findKthBit(int n, int k) {
        //     int length = (1 << n) -1;
        //     k--;
        //     int flip = 0;
        //     while (n > 1) {
        //         length = (1 << n) -1;
        //         int b = length >> 1; // 2
        //         if (k == b) return (char)((1 ^ flip) + '0');
        //         else if (k > b) {
        //             k -= b+1;
        //             k = b-1-k;
        //             flip = (flip + 1) % 2;
        //         }
        //         n--;
        //     }
        //     return (char)((0 ^ flip) + '0');
        // }

        // public boolean isValid(String s) {
        //     while (s.length() > 0) {
        //         int idx = s.indexOf("abc");
        //         if (idx == -1) return false;
        //         s = s.substring(0, idx) + (idx+3 <= s.length()-1 ? s.substring(idx+3) : "");
        //     }
        //     return true;
        // }


        // private class Pt {
        //     char c;
        //     int v;
        //     public Pt (char a, int b) {
        //         c = a;
        //         v = b;
        //     }
        // }
        // public String removeDuplicates(String s, int k) {
        //     int n = s.length();
        //     Stack<Pt> st = new Stack<>();
        //     int i = 0, cnt = 0, j = 0;
        //     char [] arr = s.toCharArray();
        //     System.out.println(Arrays.toString(arr));
        //     while (i < n) {
        //         char c = arr[i];
        //         j = i+1;
        //         while (j < n && arr[j] == c) ++j;
        //         cnt = (j==i ? 1 : j-i);
        //         if (st.size() > 0 && st.peek().c == c) {
        //             if (st.peek().v + cnt >= k) {
        //                 if (st.peek().v + cnt > k && (st.peek().v + cnt) % k != 0)
        //                     st.push(new Pt(c, (st.pop().v + cnt) % k));
        //                 else st.pop();
        //             } else 
        //                 st.push(new Pt(c, st.pop().v + cnt));
        //         } else if (cnt != k) 
        //             st.push(new Pt(c, cnt > k ? cnt-k : cnt));
        //         i = (j > i ? j : i + 1); 
        //     }
        //     StringBuilder sb = new StringBuilder();
        //     while (!st.isEmpty()) {
        //         Pt cur = st.pop();
        //         sb.append((cur.c+"").repeat(cur.v));
        //     }
        //     return sb.reverse().toString();
        // }


        // public List<String> wordSubsets(String[] words1, String[] words2) {
        //     int [] tt = new int [26];
        //     int [] cnt = new int [26];
        //     for (String v : words2) {
        //         Arrays.fill(cnt, 0);
        //         for (char c : v.toCharArray()) 
        //             cnt[c-'a']++;
        //         for (int i = 0; i < 26; i++) 
        //             tt[i] = Math.max(cnt[i], tt[i]);
        //     }
        //     List<String> res = new ArrayList<>();
        //     for (String v : words1) {
        //         Arrays.fill(cnt, 0);
        //         for (char c : v.toCharArray()) 
        //             cnt[c-'a']++;
        //         int i = 0;
        //         for ( i = 0; i < 26; i++) 
        //             if (cnt[i] < tt[i]) break;
        //         if (i < 26) continue;
        //         res.add(v);
        //     }
        //     return res;
        // }


        // public String alphabetBoardPath(String target) {
        //     String [] bd = {"abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"};
        //     int m = bd.length; n = bd[0].length();
        //     Map<Integer, Character> map = new HashMap<>();
        //     for (int i = 0; i < m; i++) 
        //         for (int j = 0; j < bd[i].length(); j++) 
        //             map.put(i*n+j, bd[i].charAt(j));
        //     Queue<int []> q = new LinkedList<>();
        //     Map<Character, int []> dirs = new HashMap<>();
        //     dirs.put('U', new int [] {-1, 0}); 
        //     dirs.put('D', new int [] {1, 0});
        //     dirs.put('L', new int [] {0, -1});
        //     dirs.put('R', new int [] {0, 1});
        //     q.offer(new int []{0, 0});
        //     StringBuilder sb = new StringBuilder();
        //     int idx = 0;
        //     while (!q.isEmpty()) {
        //         int [] cur = q.poll();
        //         if (map.get(cur[0]*n+cur[1]) == target.charAt(idx)) {
        //             sb.append('!');
        //             idx++;
        //         }
        //     }
        // }

        // private void remove(String t) {
        //     int i = 0;
        //     int n = s.length();
        //     for (char c : t.toCharArray()) {
        //         i = 0;
        //         while (i < n && s.charAt(i) != c) i++;
        //         s.deleteCharAt(i);
        //     }
        // }
        // StringBuilder s;
        // public String originalDigits(String so) {
        //     s = new StringBuilder(so);
        //     int n = s.length();
        //     StringBuilder t = new StringBuilder();
        //     int i = 0;
        //     while (s.length() > 0) {
        //         if (s.indexOf("u") != -1) {
        //             remove("four");
        //             t.append('4');
        //         } else if (s.indexOf("x") != -1) {
        //             remove("six");
        //             t.append('6');
        //         } else if (s.indexOf("g") != -1) {
        //             t.append('8');
        //             remove("eight");
        //         } else if (s.indexOf("z") != -1) {
        //             t.append('0');
        //             remove("zero");
        //         } else if (s.indexOf("w") != -1) {
        //             t.append('2');
        //             remove("two");
        //         } else if (s.indexOf("h") != -1) {
        //             t.append('3');
        //             remove("three");
        //         } else if (s.indexOf("o") != -1) {
        //             t.append('1');
        //             remove("one");
        //         } else if (s.indexOf("f") != -1) {
        //             t.append('5');
        //             remove("five");
        //         } else if (s.indexOf("s") != -1) {
        //             t.append('7');
        //             remove("seven");
        //         } else {
        //             t.append('9');
        //             remove("nine");
        //         }
        //     }
        //     char [] tmp = t.toString().toCharArray();
        //     Arrays.sort(tmp);
        //     return new String(tmp);
        // }


        // public int compress(char[] chars) {
        //     if (chars.length == 1) return 1;
        //     StringBuilder s = new StringBuilder();
        //     int j = 0, cnt = 1;
        //     for (int i = 1; i < chars.length; i++) {
        //         if (chars[i] == chars[i-1]) {
        //             ++cnt;
        //             if (i < chars.length-1)
        //                 continue;
        //         }
        //         if (chars[i] != chars[i-1] || i == chars.length-1 && chars[i] == chars[i-1]) {
        //             s.append(chars[i-1]);
        //             if (cnt > 1)
        //                 s.append(String.valueOf(cnt));
        //             cnt = 1;
        //         }
        //         if (i == chars.length-1 && chars[i] != chars[i-1])
        //             s.append(chars[i]);
        //     }
        //     for (int i = 0; i < s.length(); i++) 
        //         chars[i] = s.charAt(i);
        //     return s.length();
        // }


        // public int countHomogenous(String s) { // bug bug bug
        //     int n = s.length();
        //     int mod = (int)1e9 + 7;
        //     int j = 0, i = 0, cnt = 1;
        //     long ans = 0;
        //     while (i < n) {
        //         while (i < n-1 && s.charAt(i) == s.charAt(i+1)) {
        //             i++;
        //             cnt++;
        //         }
        //         ans = (ans + (cnt+1)*cnt % mod /2 ) % mod;
        //         cnt = 1;
        //         i++;
        //     }
        //     return (int)ans;
        // }


        
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        String a = "abbcccaa";

        int r = s.countHomogenous(a);
        System.out.println("r: " + r);
    }
}
