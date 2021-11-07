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


        // public String alphabetBoardPath(String target) {
        //     String ans = "";
        //     int i = 0, j = 0;
        //     for (char c : target.toCharArray()) {
        //         int x = (c - 'a') / 5, y = (c - 'a') % 5;
        //         ans += "U".repeat(Math.max(0, i-x)) + "R".repeat(Math.max(0, y - j)) + "L".repeat(Math.max(0, j - y)) + "D".repeat(Math.max(0, x - i)) + "!";
        //         i = x;
        //         j = y;
        //     }
        //     return ans;
        // }


        // public int findMinDifference(List<String> s) {
        //     int n = s.size();
        //     int [] arr = new int [n];
        //     for (int i = 0; i < n; i++) 
        //         arr[i] = Integer.parseInt(s.get(i).substring(0, 2))*60 + Integer.parseInt(s.get(i).substring(3));
        //     int min = Integer.MAX_VALUE, cur = 0;
        //     for (int i = 0; i < n; i++) 
        //         for (int j = i+1; j < n; j++) {
        //             cur = Math.min(Math.abs(arr[i]-arr[j]), Math.min(1440-arr[i]+arr[j], 1440-arr[j]+arr[i]));
        //             min = Math.min(min, cur);
        //         }
        //     return min;
        // }


        // public boolean isRobotBounded(String instructions) {
        //     int [][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}}; // N W S E
        //     Map<String, int []> m = new HashMap<>();
        //     m.put("L-1_0", new int [] {0, -1});
        //     m.put("L0_-1", new int [] {1, 0});
        //     m.put("L1_0", new int [] {0, 1});
        //     m.put("L0_1", new int [] {-1, 0});
        //     m.put("R-1_0", new int [] {0, 1});
        //     m.put("R0_1", new int [] {1, 0});
        //     m.put("R1_0", new int [] {0, -1});
        //     m.put("R0_-1", new int [] {-1, 0});

        //     int i = 0, j = 0, di = -1, dj = 0;
        //     List<int []> pos = new ArrayList<>();
        //     int [] cur = {i, j, di, dj}; // posX, posY, dirX, dirY
        //     pos.add(cur);
        //     for (char c : instructions.repeat(5).toCharArray()) {
        //         if (c == 'G') {
        //             i = i + di;
        //             j = j + dj;
        //         } else { // if (c == 'L' || 'R ) 
        //             String key = "" + c + di + "_" + dj;
        //             System.out.println("key: " + key);
        //             int [] d = m.get(key);
        //             di = d[0];
        //             dj = d[1];
        //         }
        //         cur = new int [] {i, j, di, dj};
        //         if (pos.contains(cur)) return true;
        //         if (i == 0 && j == 0) 
        //             for (int [] d : dirs) 
        //                 if (pos.contains(new int [] {0, 0, d[0], d[1]})) return true;
        //         pos.add(cur);
        //     }
        //     // for (int [] zz : pos) 
        //     //     System.out.println(Arrays.toString(zz));
        //     return i == cur[0] && j == cur[1];
        // }


        // private String swap(String t, int i, int j) { // j < i
        //     StringBuilder s = new StringBuilder(t);
        //     char tmp = s.charAt(i);
        //     s.setCharAt(i, s.charAt(j));
        //     s.setCharAt(j, tmp);
        //     char [] tpp = t.substring(i+1).toCharArray();
        //     Arrays.sort(tpp);
        //     return s.substring(0, i+1) + new String(tpp);
        // }
        // private String getNext(String s) { // bug bug bug
        //     int n = s.length();
        //     int i = n-1;
        //     if (s.charAt(i-1) < s.charAt(i)) return swap(s, i, i-1);
        //     while (i > 0 && s.charAt(i-1) >= s.charAt(i)) --i;
        //     if (i == 0) return s;
        //     int j = i;
        //     while (s.charAt(j) > s.charAt(i)+1) ++j;
        //     return swap(s, i-1, j);
        // }
        // private int cnt(String ss, String t) {
        //     int n = ss.length();
        //     int i = 0, j = 0;
        //     StringBuilder s = new StringBuilder(ss);
        //     int cnt = 0;
        //     while (i < n) {
        //         while (i < n && s.charAt(i) == t.charAt(i)) ++i;
        //         if (i == n) break;
        //         s = new StringBuilder(swap(s.toString(), s.toString().indexOf(t.charAt(i)), i));
        //         ++i;
        //         ++cnt;
        //     }
        //     return cnt;
        // }
        // public int getMinSwaps(String num, int k) {
        //     int n = num.length();
        //     int cnt = 0;
        //     String s = num;
        //     while (cnt < k) {
        //         s = getNext(s);
        //         ++cnt;
        //     }
        //     return cnt(num, s);
        // }
        // public void swapTarget(int i, int j) {
        //     char tmp = target[i];
        //     target[i] = target[j];
        //     target[j] = tmp;
        // }
        // char [] ori, target;
        // public int getMinSwaps(String num, int k) {
        //     int n = num.length();
        //     ori = num.toCharArray();
        //     target = Arrays.copyOf(ori, n);
        //     // 求第k个最小妙数
        //     for (int i = 0; i < k; i++) {
        //         int x = n-2, y = n-1, z = n-1;
        //         while (x > 0 && target[x] >= target[x+1]) x--; // 从后向前找到num[x] < num[x+1]的第一个位置
        //         while (y > x && target[x] >= target[y]) y--;   // 从后向前找到num[x] < num[y]的第一个位置
        //         swapTarget(x, y);                   // 交换num[x]和num[y]
        //         while (x < z) swapTarget(++x, z--); // 翻转x以后位置的字符
        //     }
        //     // 贪心算法求交换次数，模拟将target交换得到num0
        //     int ans = 0;
        //     for (int i = 0; i < n; i++) {
        //         int j = i;
        //         while (j < n-1 && target[j] != ori[i]) j++;
        //         while (i < j) {
        //             swapTarget(j, --j);
        //             ans++;
        //         }
        //     }
        //     return ans;
        // }


        // public String complexNumberMultiply(String s, String t) {
        //     int m = s.length(), n = t.length();
        //     int i = 0, j = 0, a = 0, b = 0, c = 0, d = 0;
        //     while (i < m && s.charAt(i) != '+') i++;
        //     a = Integer.parseInt(s.substring(0, i));
        //     b = Integer.parseInt(s.substring(i+1, m-1));
        //     while (j < n && t.charAt(j) != '+') j++;
        //     c = Integer.parseInt(t.substring(0, j));
        //     d = Integer.parseInt(t.substring(j+1, n-1));
        //     i = a * c - b * d;
        //     j = b * c + a * d;
        //     String ans = i + "+" + j + "i";
        //     return ans;
        // }


        // public int countPalindromicSubsequence(String t) {
        //     int n = t.length();
        //     char [] s = t.toCharArray();
        //     Set<Character> left = new HashSet<>();
        //     Set<String> ss = new HashSet<>();
        //     left.add(s[0]);
        //     Map<Character, Integer> right = new HashMap<>();
        //     for (int i = n-1; i > 1; i--) 
        //         right.put(s[i], right.getOrDefault(s[i], 0) + 1);
        //     for (int i = 1; i < n-1; i++) {
        //         for (int j = 0; j < 26; j++) {
        //             char c = (char)(j + 'a');
        //             if (left.contains(c) && right.containsKey(c))
        //                     ss.add("" + c + s[i] + c);
        //         }
        //         left.add(s[i]);
        //         right.put(s[i+1], right.getOrDefault(s[i+1], 0)-1);
        //         if (right.get(s[i+1]) == 0) right.remove(s[i+1]);
        //     }
        //     return ss.size();
        // }


        // public int magicalString(int n) {
        //     if (n <= 0) return 0;
        //     if (n <= 3) return 1;
        //     int res = 1, head = 2, tail = 3, val = 1;
        //     List<Integer> l = new ArrayList<>();
        //     l.add(1);
        //     l.add(2);
        //     l.add(2);
        //     while (tail < n) {
        //         for (int i = 0; i < l.get(head); i++) {
        //             l.add(val);
        //             if (val == 1 && tail < n) ++res;
        //             ++tail;
        //         }
        //         val ^= 3;
        //         ++head;
        //     }            
        //     return res;
        // }
        // public int magicalString(int n) {
        //     String s = "122";
        //     int i = 2;
        //     while (s.length() < n) 
        //         s += String.valueOf(Integer.parseInt(s.substring(s.length()-1)) ^ 3).repeat(s.charAt(i++)-'0');
        //     return (int)s.substring(0, n).chars().filter(ch -> ch == '1').count();
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
        // public List<String> braceExpansionII(String expression) {
        //     if (expression.indexOf("{") == -1)
        //         return Arrays.stream(expression.split(",")).collect(Collectors.toList()); // 
        //     int n = expression.length();
        //     char [] s = expression.toCharArray();
        //     List<String> res = new ArrayList<>();
        //     ArrayDeque<Character> st = new ArrayDeque<>(); // 双端队列当作stack来用,因为不涉及任何线程安全相关的操作，比stack轻量且高效
        //     for (int i = 0, j = 0; i < n; i++) {           // j : lastEnd
        //         if (s[i] == '{') {
        //             st.push('{');
        //         } else if (s[i] == '}') {
        //             st.pop();
        //             if (st.isEmpty() && (i < n-1 && s[i+1] == ',' || i == n-1)) {
        //                 res.addAll(braceExpansionIIHelper(expression.substring(j, i+1))); // { , , , }
        //                 j = i + 2;
        //             }
        //         } else if (st.isEmpty() && i == n-1) 
        //             res.addAll(braceExpansionIIHelper(expression.substring(j, i+1)));
        //     }
        //     return res;
        // }
        // public List<String> braceExpansionIIHelper(String expression) {
        //     ArrayDeque<String> q = new ArrayDeque<>();
        //     q.offer(expression);
        //     char [] s = expression.toCharArray();
        //     Set<String> res = new HashSet<>();
        //     StringBuilder sb = new StringBuilder();
        //     while (!q.isEmpty()) {
        //         String cur = q.poll();
        //         if (cur.indexOf("{") == -1) { // if "{" is not in currExpression, meaning this is a valid res, add it to final res:
        //             res.add(cur);
        //             continue;
        //         }
        //         int i = 0, left = 0, right = 0;
        //         while (cur.charAt(i) != '}') {
        //             if (cur.charAt(i) == '{') left = i;
        //             i++;
        //         }
        //         right = i;
        //         String bef = cur.substring(0, left);
        //         String aft = cur.substring(right + 1);
        //         String [] str = cur.substring(left+1, right).split(",");
        //         for (String si : str) {
        //             sb.setLength(0);
        //             q.offer(sb.append(bef).append(si).append(aft).toString());
        //         }
        //     }
        //     List<String> ans = new ArrayList<>(res);
        //     Collections.sort(ans);
        //     return ans;
        // }
        // public List<String> braceExpansionII(String expression) {
        //     return expansion(expression).stream().sorted().collect(Collectors.toList());
        // }
        // public Set<String> expansion(String expression) {
        //     Set<String> res = new HashSet<>();
        //     char [] s = expression.toCharArray();
        //     if ("".equals(expression))          //空串返回空结果
        //         return res;
        //     else if (!expression.contains("{")) //不含{}，那么直接分割即可
        //         return Arrays.stream(expression.split(",")).collect(Collectors.toSet());
        //     else { //pairStart, pairEnd分另表示第一个完整的{}的位置
        //         int pair = 0, pairStart = -1, pairEnd = -1;
        //         for (int i = 0; i < expression.length(); i++) {
        //             if (s[i] == '{') {
        //                 if (pairStart == -1) 
        //                     pairStart = i;
        //                 pair++;
        //             } else if (s[i] == '}') 
        //                 pair--;
        //             if (pair == 0) {
        //                 if (pairStart != - 1 && pairEnd == -1) 
        //                     pairEnd = i;
        //                 //pair==0，即不在某个{}中间，那么可以将表达式分成两段
        //                 if (s[i] == ',') {
        //                     res.addAll(expansion(expression.substring(0, i)));
        //                     res.addAll(expansion(expression.substring(i + 1)));
        //                     return res;
        //                 }
        //             }
        //         }
        //         // 现在剩下的只会是{a{b}{c}} a{b}c {}{}这种形式的了
        //         String prefix = "";
        //         if (pairStart != 0) //括号起点不为0，说明是a{b}c这种形式
        //             prefix = expression.substring(0, pairStart);
        //         Set<String> left = expansion(expression.substring(pairStart + 1, pairEnd)); //剥掉第一个的最外层括号
        //         Set<String> right = expansion(expression.substring(pairEnd + 1)); //求出第一个完整{}后部分
        //         if (left.isEmpty()) left.add(""); //为了方便计算加入空串
        //         if (right.isEmpty()) right.add("");
        //         for (String l: left)  //拼接
        //             for (String r: right) 
        //                 res.add(prefix + l + r);
        //     }
        //     return res;
        // }


        // public String orderlyQueue(String s, int k) { // tle tle tle 暴力暴力暴力
        //     int n = s.length();
        //     if (k == n) return Stream.of(s.split("")).sorted().collect(Collectors.joining());
        //     TreeSet<String> ts = new TreeSet<>();
        //     Queue<String> q = new LinkedList<>();
        //     q.offer(s);
        //     while (!q.isEmpty()) {
        //         String cur = q.poll();
        //         for (int i = 0; i < k; i++) {
        //             cur = cur.substring(0, i) + cur.substring(i+1) + cur.charAt(i);
        //             if (!ts.contains(cur)) {
        //                 q.offer(cur);
        //                 ts.add(cur);
        //             }
        //         }
        //     }
        //     return ts.first();
        // }
        // 当K >= 2的时候,我们总是能取前KK个中第一个违反当前前KK个非递减字母序的字母放在最后面。也就是说经过若干次操作后。整个字母序列单调非递减。所以答案就是对SS进行排序。
        // 当K = 1的时候。将这个字符串序列想象成一个环序列，将一个字母放到最后若干次等价于将这个字符串环中取一个起点作为新字符串的起点。这样的字符串有|S|个，∣S∣个，所以此时答案就是这|S|∣S∣个字符串中字典序最小的那一个。
        //     时间复杂度O(|S|^2)
        // public String orderlyQueue(String s, int k) { // tle tle tle 暴力暴力暴力
        //     if (k > 1) {
        //         char [] t = s.toCharArray();
        //         Arrays.sort(t);
        //         return new String(t);
        //     }
        //     String res = "";
        //     for (int i = 0; i < s.length(); i++) {
        //         String cur = s.substring(i) + s.substring(0, i);
        //         if (res.length() == 0 || res.compareTo(cur) > 0)
        //             res = cur;
        //     }
        //     return res;
        // }


        
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        String a = "cba";

        String r = s.orderlyQueue(a, 1);
        System.out.println("r: " + r);
    }
}