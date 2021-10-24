// import com.UnionFind;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

public class strtwoing {
    public static class Solution {

        // private String getString(int v) {
        //     StringBuilder s = new StringBuilder().append(""+v);
        //     if (s.length() == 4) return s.toString();
        //     return "0".repeat(4-s.length())+s.toString();
        // }
        // private boolean diffByOneDigitByOne(String s, String t) {
        //     int cnt = 0, i = 0;
        //     for (i = 0; i < 4; i++) {
        //         if (s.charAt(i) == t.charAt(i)) continue;
        //         if (Math.abs(s.charAt(i) - t.charAt(i)) == 1
        //             || s.charAt(i) == '0' && t.charAt(i) == '9'
        //             || s.charAt(i) == '9' && t.charAt(i) == '0') ++cnt;
        //         else break;
        //     }
        //     if (i < 4) return false;
        //     return cnt == 1;
        // }
        // private Set<String> getDiffByOne(String s) {
        //     Set<String> ss = new HashSet<>();
        //     for (int i = 0; i < 4; i++) {
        //         char c = s.charAt(i), up, down;
        //         up = (char)(c+1);
        //         down = (char)(c-1);
        //         if (c == '9') up = '0';
        //         else if (c == '0') down = '9';
        //         ss.add(i == 0 ? up + s.substring(i+1) : s.substring(0, i) + up + s.substring(i+1));
        //         ss.add(i == 0 ? down + s.substring(i+1) : s.substring(0, i) + down + s.substring(i+1));
        //     }
        //     return ss;
        // }
        // public int openLock(String[] deadends, String target) {
        //     if (Arrays.asList(deadends).contains("0000")) return -1;
        //     Set<String> sd = new HashSet<>();
        //     for (String v : deadends)
        //         sd.add(v);
        //     Queue<String> q = new LinkedList<>();
        //     q.offer("0000");
        //     int cnt = 0;
        //     Set<String> vis = new HashSet<>();
        //     vis.add("0000");
        //     while (!q.isEmpty()) {
        //         for (int size = q.size()-1; size >= 0; size--) {
        //             String cur = q.poll();
        //             if (cur.equals(target)) return cnt;
        //             Set<String> ss = getDiffByOne(cur);
        //             for (String v : ss) {
        //                 if (vis.contains(v) || sd.contains(v)) continue;
        //                 q.offer(v);
        //                 vis.add(v);
        //             }
        //         }
        //         ++cnt;
        //     }
        //     return -1;
        // }

        
        // private boolean isMatch(String s, String t) { // 这里元音字母好像是可以换的
        //     if (s.length() != t.length()) return false;
        //     for (int i = 0; i < s.length(); i++) 
        //         if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(t.charAt(i)))
        //             return false;
        //     return true;
        // }
        // public String[] spellchecker(String[] wordlist, String[] queries) {
        //     int n = wordlist.length;
        //     int m = queries.length;
        //     Set<String> ss = new HashSet<>();
        //     for (String v : wordlist)
        //         ss.add(v);
        //     String [] ans = new String [m];
        //     int j = 0;
        //     for (int i = 0; i < m; i++) {
        //         if (ss.contains(queries[i])) {
        //             ans[i] = queries[i];
        //             continue;
        //         }
        //         for ( j = 0; j < n; j++) 
        //             if (isMatch(wordlist[j], queries[i])) {
        //                 ans[i] = wordlist[j];
        //                 break;
        //             }
        //         if (j == n) ans[i] = "";
        //     }
        //     return ans;
        // }

 
        // private void remove(String t) { // tle tle tle tle
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
        // public String originalDigits(String s) {
        //     String res = "";
        //     String [] words = {"zero", "two", "four", "six", "eight", "one", "three", "five", "seven", "nine"};
        //     int [] nums = {0, 2, 4, 6, 8, 1, 3, 5, 7, 9};
        //     int [] cnts = new int [26];
        //     char [] chars = {'z', 'w', 'u', 'x', 'g', 'o', 'h', 'f', 's', 'i'};
        //     for (char c : s.toCharArray()) ++cnts[c-'a'];
        //     for (int i = 0; i < 10; i++) {
        //         int curCnts = cnts[chars[i]-'a'];
        //         if (curCnts == 0) continue;
        //         for (int j = 0; j < words[i].length(); j++) 
        //             cnts[words[i].charAt(j)-'a'] -= curCnts;
        //         res += (curCnts == 1 ? ""+(char)(nums[i]+'0') : (""+(char)(nums[i]+'0')).repeat(curCnts));
        //     }
        //     char [] tmp = res.toCharArray();
        //     Arrays.sort(tmp);
        //     return new String(tmp);
        // }


        // public List<String> alertNames(String[] keyName, String[] keyTime) {
        //     Map<String, List<Integer>> m = new HashMap<>();
        //     int n = keyName.length;
        //     for (int i = 0; i < n; i++) 
        //         m.computeIfAbsent(keyName[i], z -> new ArrayList<>()).add(Integer.parseInt(keyTime[i].substring(0, 2))*60 + Integer.parseInt(keyTime[i].substring(3)));
        //     List<String> res = new ArrayList<>();
        //     for (Map.Entry<String, List<Integer>> en : m.entrySet()) {
        //         List<Integer> l = en.getValue();
        //         Collections.sort(l);
        //         int j = 0, max = 0;
        //         for (int i = 0; i < l.size(); i++) {
        //             if (i == 0 || i > 0 && l.get(i) - l.get(j) <= 60) {
        //                max = Math.max(max, i-j+1);
        //                 continue;
        //             }
        //             while (j < i && l.get(i) - l.get(j) > 60) j++;
        //             max = Math.max(max, i-j+1);
        //         }
        //         if (max >= 3) res.add(en.getKey());
        //     }
        //     Collections.sort(res);
        //     return res;
        // }

 
        // public int numSub(String t) { // bug bug bug
        //     int mod = (int)1e9 + 7;
        //     int n = t.length(), ans = 0, j = 0, i = 0;
        //     char [] s = t.toCharArray();
        //     while (i < n) {
        //         while (i < n && s[i] == '0') i++;
        //         j = i;
        //         while (i < n && s[i] == '1') i++;
        //         int v = i - j;
        //         ans = (ans +  v * (v + 1) % mod / 2) % mod;
        //     }
        //     return (int)(ans % mod);
        // }
        // public int numSub(String s) {
        //     int mod = (int)1e9 + 7;
        //     int r = 0;
        //     for(int i = 0, n = 0; i < s.length(); i++) {           
        //         if (s.charAt(i) == '1')  r = (r + ++n) % mod;
        //         else n = 0;
        //     }
        //     return r;
        // }


        // public int maximumGain(String t, int x, int y) { // ab, x   ba y
        //     int n = t.length(), min = Math.min(x, y), max = Math.max(x, y), ans = 0;
        //     String smin = x <= y ? "ab" : "ba";
        //     String smax = x <= y ? "ba" : "ab";
        //     Stack<Character> st = new Stack<>();
        //     char [] s = t.toCharArray();
        //     for (int i = 0; i < n; i++) {
        //         if (!st.isEmpty() && (st.peek() + "" + s[i]).equals(smax)) {
        //             st.pop();
        //             ans += max;
        //         } else
        //             st.push(s[i]);
        //     }
        //     Stack<Character> ss = new Stack<>();
        //     while (st.size() > 1) {
        //         while (!st.isEmpty()) {
        //             char c = st.pop();
        //             if (c != 'a' && c != 'b') continue;
        //             if (!st.isEmpty() && (st.peek() + "" + c).equals(smin)) {
        //                 st.pop();
        //                 ans += min;
        //             } else ss.push(c);
        //         }
        //         System.out.println("ans: " + ans);
        //         while (ss.size() > 0) { // 前面少了点儿结果，现在又算多了
        //             char c = ss.pop();
        //             if (!ss.isEmpty() && c == ss.peek()) continue;
        //             else st.push(c);
        //         }
        //         // st.push(ss.pop());
        //         System.out.println("st.size(): " + st.size());
        //         System.out.println(Arrays.toString(new ArrayList<>(st).toArray()));
        //     }            
        //     return ans;
        // }

        // public String smallestSubsequence(String t) {
        //     int n = t.length();
        //     char [] s = t.toCharArray();
        //     Map<Character, Integer> cnt = new HashMap<>();
        //     for (int i = 0; i < n; i++)
        //         cnt.put(s[i], cnt.getOrDefault(s[i], 0) + 1);
        //     Stack<Character> st = new Stack<>();
        //     for (int i = 0; i < n; i++) {
        //         while (!st.isEmpty() && !st.contains(s[i]) && s[i] < st.peek() && cnt.containsKey(st.peek())) 
        //             st.pop();
        //         if (!st.contains(s[i]))
        //             st.push(s[i]);
        //         cnt.put(s[i], cnt.get(s[i])-1);
        //         if (cnt.get(s[i]) == 0)
        //             cnt.remove(s[i]);
        //     }
        //     StringBuilder ans = new StringBuilder();
        //     while (!st.isEmpty()) ans.append(st.pop());
        //     return ans.reverse().toString();
        // } 
        // public String smallestSubsequence(String t) {
        //     int n = t.length();
        //     char [] s = t.toCharArray();
        //     Map<Character, Integer> cnt = new HashMap<>();
        //     for (int i = 0; i < n; i++)
        //         cnt.put(s[i], cnt.getOrDefault(s[i], 0) + 1);
        //     Stack<Character> st = new Stack<>();
        //     Set<Character> vis = new HashSet<>();
        //     for (char c : s) {
        //         if (vis.contains(c)) {
        //             cnt.put(c, cnt.get(c)-1);
        //             continue;
        //         }
        //         while (!st.isEmpty() && c < st.peek() && cnt.get(st.peek()) > 1) {
        //             char ch = st.pop();
        //             cnt.put(ch, cnt.get(ch)-1);
        //             vis.remove(ch);
        //         }
        //         st.push(c);
        //         vis.add(c);
        //     }
        //     StringBuilder ans = new StringBuilder();
        //     while (!st.isEmpty()) ans.append(st.pop());
        //     return ans.reverse().toString();
        // }

        // public String removeDuplicateLetters(String t) {
        //     int n = t.length();
        //     char [] s = t.toCharArray();
        //     Map<Character, Integer> cnt = new HashMap<>();
        //     for (int i = 0; i < n; i++)
        //         cnt.put(s[i], cnt.getOrDefault(s[i], 0) + 1);
        //     Stack<Character> st = new Stack<>();
        //     Set<Character> vis = new HashSet<>();
        //     for (char c : s) {
        //         if (vis.contains(c)) {
        //             cnt.put(c, cnt.get(c)-1);
        //             continue;
        //         }
        //         while (!st.isEmpty() && c < st.peek() && cnt.get(st.peek()) > 1) {
        //             char ch = st.pop();
        //             cnt.put(ch, cnt.get(ch)-1);
        //             vis.remove(ch);
        //         }
        //         st.push(c);
        //         vis.add(c);
        //     }
        //     StringBuilder ans = new StringBuilder();
        //     while (!st.isEmpty()) ans.append(st.pop());
        //     return ans.reverse().toString();
        // }


        // public String strWithout3a3b(int a, int b) {
        //     int min = Math.min(a, b), max = Math.max(a, b);
        //     char s = min == a ? 'a' : 'b', t = min == a ? 'b' : 'a';
        // }

        // public int minSwaps(String t) {
        //     int n = t.length(), cnt = 0;
        //     char [] s = t.toCharArray();
        //     for (char c : s) 
        //         if (c == '1') ++cnt;
        //     int [] one = new int [n], two = new int [n];
        //     one[0] = 1;
        //     two[0] = 0;
        //     for (int i = 1; i < n; i++) {
        //         one[i] = 1 - one[i-1];
        //         two[i] = 1 - two[i-1];
        //     }
        //     int ca = 0, cb = 0, ta = 0, tb = 0;
        //     for (int i = 0; i < n; i++) {
        //         if (one[i] != s[i] - '0') ++ca;
        //         if (two[i] != s[i] - '0') ++cb;
        //         ta += one[i];
        //         tb += two[i];
        //     }
        //     if (ta != cnt) ca = n;
        //     if (tb != cnt) cb = n;
        //     return Math.min(ca, cb) == n ? -1 : Math.min(ca, cb) / 2;
        // }


        // private boolean winState(int [][] arr, int x, int y, int v) {
        //     int cnt = 0;
        //     boolean isWin = false;
        //     for (int i = 0; i < 3; i++) {
        //         if (arr[i][y] != v) break;
        //         ++cnt;
        //     }
        //     if (cnt == 3) return true;
        //     cnt = 0;
        //     for (int j = 0; j < 3; j++) {
        //         if (arr[x][j] != v) break;
        //         ++cnt;
        //     }
        //     if (cnt == 3) return true;
        //     if (x != y && x != -y) return false;
        //     cnt = 0;
        //     for (int i = 0; i < 3; i++) {
        //         if (arr[i][i] != v) break;
        //         ++cnt;
        //     }
        //     if (cnt == 3) return true;
        //     cnt = 0;
        //     for (int i = 0; i < 3; i++) {
        //         if (arr[i][2-i] != v) break;
        //         cnt++;
        //     }
        //     return cnt == 3;
        // }
        // public boolean validTicTacToe(String[] board) {
        //     int m = board.length, n = board[0].length(), ca = 0, cb = 0;
        //     int [][] arr = new int [m][n];
        //     for (int i = 0; i < m; i++)
        //         for (int j = 0; j < n; j++)  {
        //             arr[i][j] = board[i].charAt(j) == 'X' ? 1 : board[i].charAt(j) == 'O' ? 0 : -1;
        //             if (arr[i][j] == 1) ca ++;
        //             else if (arr[i][j] == 0) cb ++;
        //         }
        //     if (Math.abs(ca-cb) > 1 || ca < cb) return false;
        //     for (int i = 0; i < m; i++) 
        //         for (int j = 0; j < n; j++) 
        //             if (winState(arr, i, j, arr[i][j])) {
        //                 if (arr[i][j] == 0 && ca > cb) return false;
        //                 if (arr[i][j] == 1 && ca == cb) return false;
        //             }
        //     return true;
        // }


        // public String maxValue(String t, int x) {
        //     int n = t.length();
        //     char [] s = t.toCharArray();
        //     int i = 0;
        //     boolean neg = s[0] == '-';
        //     if (s[0] == '-') {
        //         while (i < n-1 && s[i+1]-'0' <= x) i++;
        //         return t.substring(0, i+1) + x + t.substring(i+1);
        //     }
        //     while (i < n && s[i]-'0' >= x) i++;
        //     return t.substring(0, i) + x + t.substring(i);
        // }


        // public String maximumNumber(String t, int[] change) {
        //     int n = t.length();
        //     char [] s = t.toCharArray();
        //     int i = 0;
        //     String ans = "";
        //     while (i < n && s[i]-'0' >= change[s[i]-'0']) i++;
        //     if (i == n) return t;
        //     ans += t.substring(0, i);
        //     while (i < n) {
        //         while (i < n && s[i]-'0' <= change[s[i]-'0']) {
        //             ans += "" + change[s[i]-'0'];
        //             i++;
        //         }
        //         if (i < n && s[i]-'0' > change[s[i]-'0'])
        //             return ans + t.substring(i);
        //     }
        //     return ans;
        // }


        // public boolean canConvertString(String ss, String tt, int k) { // 这里那个下标处理得有点儿不太对
        //     if (ss.length() != tt.length()) return false;
        //     int n = ss.length(), i = 0, v = 0, cnt = 0;
        //     char [] s = ss.toCharArray(), t = tt.toCharArray();
        //     Set<Integer> vis = new HashSet<>();
        //     while (i < n && s[i] == t[i]) i++;
        //     if (i == n) return true;
        //     if (i > k) return false;
        //     if (i > 0) {
        //         cnt = i-1;
        //         vis.add(i);
        //     }
        //     while (i < n) {
        //         while (i < n && s[i] == t[i]) i++;
        //         if (i == n) return true;
        //         if (s[i] > t[i]) 
        //             v = s[i] - t[i] + 26;
        //         else v = t[i] - s[i];
        //         if (v + i != cnt) return false; //
        //         vis.add(i);
        //         // if (i == 0) cnt += i-1;
        //         cnt += 1;
        //         if (k < cnt) return false; // 这里理解的不对，呆会儿再写
        //         i++;
        //     }
        //     return true;
        // }


        // public int numWays(String t) {
        //     int mod = (int)1e9 + 7;
        //     int n = t.length(), cnt = 0;
        //     char [] s = t.toCharArray();
        //     for (char c : s)
        //         cnt += c-'0';
        //     if (cnt % 3 != 0) return 0;
        //     if (cnt == 0) return 
        //     int i = 0, j = n-1, ca = 0, cb = 0, target = cnt / 3;
        //     while (i < n && ca < target) {
        //         if (s[i] == '1') ++ca;
        //         i++;
        //     }
        //     while (j >= 0 && cb < target) {
        //         if (s[j] == '1') ++cb;
        //         j--;
        //     }
        //     int x = i, y = j;
        //     while (x < j && s[x] == '0') ++x;
        //     while (y > i && s[y] == '0') --y;
        //     return (x - i + 1) * (j - y + 1) % mod;
        // }
        // String a = "0000"; // 如果是相同的字符，有多少分法


        // public List<String> invalidTransactions(String[] transactions) {
        //     int n = transactions.length;
        //     List<String []> l = new ArrayList<>();
        //     for (int i = 0; i < n; i++)
        //         l.add(new String [5]);
        //     for (int i = 0; i < n; i++) {
        //         String [] tmp = transactions[i].split("[\\s,]+");
        //         l.set(i, new String [] {""+i, tmp[0], tmp[1], tmp[2], tmp[3]});
        //     }
        //     Collections.sort(l, (a, b)-> a[1].compareTo(b[1]) != 0 ? a[1].compareTo(b[1]) : Integer.parseInt(b[2]) - Integer.parseInt(a[2]));
        //     for (String [] zz : l) 
        //         System.out.println(Arrays.toString(zz));
        //     List<String> ans = new ArrayList<>();
        //     Set<String> vis = new HashSet<>();
        //     for (int i = 0; i < l.size(); i++) {
        //         String [] v = l.get(i);
        //         if (Integer.parseInt(v[3]) > 1000) {
        //             vis.add(v[0]);
        //             ans.add(transactions[Integer.parseInt(v[0])]);
        //         }
        //         for (int j = i-1; j >= 0; j--) 
        //             if (v[1].equals(l.get(j)[1]) && Integer.parseInt(l.get(j)[2]) - Integer.parseInt(v[2]) <= 60 && !v[4].equals(l.get(j)[4])) {
        //                 if (!vis.contains(v[0])) {
        //                     ans.add(transactions[Integer.parseInt(v[0])]);
        //                     vis.add(v[0]);
        //                 }
        //                 if (!vis.contains(l.get(j)[0])) {
        //                     ans.add(transactions[Integer.parseInt(l.get(j)[0])]);
        //                     vis.add(l.get(j)[0]);
        //                 }
        //             } else if (v[1].equals(l.get(j)[1]) && Integer.parseInt(v[2])-Integer.parseInt(l.get(j)[2]) > 60 || !v[1].equals(l.get(j)[1])) break;
        //     }
        //     return ans;
        // }


        // public String removeKdigits(String t, int k) {
        //     int n = t.length(), i = 0;
        //     char [] s = t.toCharArray();
        //     while (i < n) {
        //         while (i < n-1 && k > 0 && s[i] > s[i+1]) {
        //             s[i] = -1;
        //             k--;
        //             i++;
        //         } 
        //     }
        // }


        // public String decodeAtIndex(String t, int k) {  // bug bug bug 不知道哪里错掉了
        //     int n = t.length(), i = 0, j = 0;
        //     char [] s = t.toCharArray();
        //     String ans = "";
        //     while (i < n && ans.length() < k) {
        //         if (Character.isLowerCase(s[i])) {
        //             ans += ""+s[i];
        //             i++;
        //         } else if (Character.isDigit(s[i])) {
        //             j = i;
        //             while (j < n && Character.isDigit(s[j])) j++;
        //             ans = ans.repeat(Integer.parseInt(t.substring(i, j)));
        //             i = j;
        //         }
        //     }
        //     return ""+ans.charAt(k-1);
        // }
        // String a = "vzpp636m8y"; // 29920
        // public String decodeAtIndex(String t, int k) { // 没看懂，改天再好好看一下
        //     long n = 0;
        //     for (char c : t.toCharArray()) {
        //         if (c.toString().matches("[a-z]")) {
        //             n++;
        //             if (n == k) return c + "";
        //         } else {
        //             int d = Integer.parseInt(c.toString()); // 是我没看懂吗？感觉这个方法这里写得不对呀，是test case没有cover这个吗？
        //             if (k <= n * d) {
        //                 if (k % n == 0) return decodeAtIndex(s, (int)n);
        //                 return decodeAtIndex(s, (int)(k % n));
        //             }
        //             n = n * d;
        //         }
        //     }
        //     return "";
        // }


        // public String validIPAddress(String IP) {
        //     if (IP.indexOf(".") == -1 && IP.indexOf(":") == -1) return "Neither";
        //     int m = IP.length();
        //     String [] s;
        //     if (IP.indexOf(".") != -1)
        //         s = IP.split("\\.");
        //     else s = IP.split("\\:");
        //     int n = s.length;
        //     if (n != 4 && n != 8) return "Neither";
        //     if (IP.charAt(m-1) == '.' || IP.charAt(m-1) == ':') return "Neither";
        //     if (n == 4) {
        //         for (int i = 0; i < 4; i++) {
        //             if (s[i].length() < 1 || s[i].length() > 3 || s[i].length() > 1 && s[i].charAt(0) == '0') return "Neither"; // string does not match well
        //             for (char c = 'a'; c <= 'z'; c++) 
        //                 if (s[i].indexOf(c) != -1) return "Neither";
        //             for (char c = 'A'; c <= 'Z'; c++) 
        //                 if (s[i].indexOf(c) != -1) return "Neither";
        //             int v = Integer.parseInt(s[i]);
        //             if (v < 0 || v > 255) return "Neither";
        //         }
        //         return "IPv4";
        //     }
        //     for (int i = 0; i < n; i++) {
        //         if (s[i].length() == 0 || s[i].length() > 4) return "Neither";
        //         for (char c = 'g'; c <= 'z'; c++) 
        //             if (s[i].indexOf(c) != -1) return "Neither";
        //         for (char c = 'G'; c <= 'Z'; c++) 
        //             if (s[i].indexOf(c) != -1) return "Neither";
        //     }
        //     return "IPv6";
        // }


        
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        String a = "11111111111111111111111111";

        // String a = "172.16.254.1";
        // String a = "2001:0db8:85a3:0:0:8A2E:0370:7334";
        // String a = "2001:0db8:85a3:0:0:8A2E:0370:7334:";
        // String a = "1e1.4.5.6";

        String r = s.validIPAddress(a);
        System.out.println("r: " + r);
    }
}