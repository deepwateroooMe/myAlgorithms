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

        // String dic = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        // Map<String, String> ls = new HashMap<>();   // long - short
        // Map<Integer, String> idl = new HashMap<>(); // id - long
        // int id = 0;
        // public String encode(String longUrl) {
        //     if (ls.containsKey(longUrl)) return ls.get(longUrl);
        //     String res = "";
        //     id ++;
        //     int cnt = id;
        //     while (cnt > 0) {
        //         res = dic.charAt(cnt % 62) + res;
        //         cnt /= 62;
        //     }
        //     if (res.length() < 6) res = "0".repeat(6-res.length()) + res;
        //     ls.put(longUrl, res);
        //     idl.put(id, longUrl);
        //     return res;
        // }
        // public String decode(String shortUrl) {
        //     int id = 0;
        //     for (int i = 0; i < shortUrl.length(); i++) 
        //         id = 62 * id + (int)(dic.indexOf(shortUrl.charAt(i)));
        //     if (idl.containsKey(id))
        //         return idl.get(id);
        //     return "";
        // }

        // private boolean canReplace(char [] s, char [] t, int idx) {
        //     for (int i = idx; i < idx + s.length; i++) 
        //         if (t[i] != '*' && s[i-idx] != t[i]) return false;
        //     return true;
        // }
        // private int getCnt(char [] s, char [] t, int idx) {
        //     int cnt = 0;
        //     for (int i = idx; i < idx + s.length; i++) {
        //         if (t[i] == '*') continue;
        //         t[i] = '*';
        //         cnt++;
        //     }
        //     return cnt;
        // }
        // public int[] movesToStamp(String stamp, String target) {
        //     int m = stamp.length(), n = target.length(), limit = 10 * n;
        //     char [] s = stamp.toCharArray(), t = target.toCharArray();
        //     boolean [] vis = new boolean [n];
        //     List<Integer> l = new ArrayList<>();
        //     int cnt = 0;
        //     while (cnt < n) {
        //         boolean done = false;
        //         for (int i = 0; i <= n-m; i++) {
        //             if (!vis[i] && canReplace(s, t, i)) {
        //                 done = true;
        //                 cnt += getCnt(s, t, i);
        //                 vis[i] = true;
        //                 l.add(i);
        //             }
        //         }
        //         if (!done) return new int [0];
        //     }
        //     int [] ans = new int [l.size()];
        //     int idx = 0;
        //     for (int i = l.size()-1; i >= 0; i--) 
        //         ans[idx++] = l.get(i);
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

    // Map<Integer, Integer> map = new HashMap<>();
    // TreeSet<Integer> high = new TreeSet<>();
    // Set<Integer> dark;
    // Random rand;
    // int m, n;
    // public Solution(int n, int[] blacklist) {
    //     this.n = n;
    //     this.m = blacklist.length;
    //     dark = new HashSet<>(Arrays.stream(blacklist).boxed().collect(Collectors.toList()));
    //     for (int i = n-m; i < n; i++)
    //         if (!dark.contains(i))
    //             high.add(i);
    //     Iterator it = high.iterator();
    //     for (Integer v : dark) 
    //         if (v < n-m) map.put(v, (Integer)it.next());
    //     rand = new Random();
    // }
    // public int pick() {
    //     int next = rand.nextInt(n-m);
    //     return map.containsKey(next) ? map.get(next) : next;
    // }

    // Random rand;
    // int [] dk;
    // int m, n ;
    // public Solution(int n, int[] blacklist) {
    //     this.m = blacklist.length;
    //     this.dk = Arrays.copyOf(blacklist, m);
    //     this.n = n;
    //     rand = new Random();
    //     Arrays.sort(this.dk);
    // }
    // // 这是一个不容易理解的方法，其思想是：已知白名单中的元素个数必然有 N-blen 个，我直接生成一个`[0,N-blen)`中的随机数k，代表我要找白名单中的第k个数；现在我要解决的问题是，如何快速确定**白名单中**的第k个数在**总名单**上的第几个位置。
    // // 现假设这个数在**总名单**上的第x个位置（总名单第x个位置的成员就等于x），则有两种情况：
    // // 1. 黑名单上所有的数都比x大，那么x左侧不可能含有黑名单成员，直接返回x即可，因为它就是白名单成员之一。
    // // 2. 黑名单上有y个数都小于x，那么说明x的左侧一定有y个黑名单成员。所以x实际上是总名单中的第k个数往后再数y个位置的结果，其中k等于值x在白名单中的索引。
    // // 所以问题就转化成了随机产生一个k，去找到y，从而确定x。
    // // 1. 首先对黑名单进行排序
    // // 2. 每次调用`pick()`
    // //         1. 先随机产生k
    // //         2. 然后利用二分查找，利用k确定y
    // //         1. 初始low指针=0，high指针=blen-1
    // //             2. 每次`mid=(low+high+1)/2`，比较`B[mid]`与k的大小关系，然后收缩y的范围
    // //             3. 如果y=0，直接返回k；如果y>0，返回k+y+1
    // public int pick() {
    //     int next = rand.nextInt(n-m);
    //     int l = 0, r = m-1;
    //     while (l < r) {
    //         int mid = (l + r + 1) / 2;
    //         if (dk[mid] - mid > next) r = mid-1;
    //         else l = mid;
    //     }
    //     return l == r && dk[l] - l <= next ? next + l + 1 : next;
    // }


        // private int getGCD(int x, int y) {
        //     return y == 0 ? x : getGCD(y, x % y);
        // }
        // public boolean canMeasureWater(int x, int y, int z) {
        //     if (x == z || y == z || x + y <= z) {
        //         if (x + y < z) return false;
        //         return true;
        //     }
        //     return x > y ? (z % getGCD(x, y) == 0 : (z % gcd(y, x)) == 0);
        // }
        // 为了减少内存的占用，DFS（动态规划类似于DFS的过程）改为BFS，这样可以遍历一部分状态后解除遍历队列中部分对象占用的空间。
        // 同时考虑到visited数组也占用非常大的空间，所以可以将访问过的状态改为用set存储，为了方便比较，这里将x和y的int值拼接为long存储在set中。
        // public long combineToLong(int a,int b){
        //     long res = (long)a;
        //     res = res << 32;
        //     return res | b;
        // } 
        // public boolean canMeasureWater(int x, int y, int z) {
        //     int capacityX = x;
        //     int capacityY = y;
        //     Set<Long> vis = new HashSet<>();
        //     Queue<Long> q = new LinkedList<>();
        //     q.offer(0l);
        //     while (!q.isEmpty()) {
        //         Long l = q.poll();
        //         if (vis.contains(l)) continue;
        //         x = (int)(l >> 32);
        //         y = l.intValue(); // 只读了右边的低位32位
        //         if (x == z || y == z || x+y == z) return true;
        //         vis.add(l);
        //         if (x != 0 && y != 0) {
        //             q.offer((long)y);         // X 清空
        //             q.offer(((long)x) << 32); // Y 清空
        //         }
        //         if (x != capacityX) {
        //             q.offer(combineToLong(capacityX, y)); // X装满
        //             if (y != 0) // 把 Y 倒入 X
        //                 q.offer(combineToLong(Math.min(x+y, capacityX), Math.max(x+y-capacityX, 0)));
        //         }
        //         if (y != capacityY) {
        //             q.offer(combineToLong(x, capacityY)); // Y装满
        //             if (x != 0) // 把 X 倒入 Y
        //                 q.offer(combineToLong(Math.max(x+y-capacityY, 0), Math.min(x+y, capacityY)));
        //         }
        //     }
        //     return false;
        // }


        // private int guess(String v, String s) { // bug bug bug
        //     int cnt = 0;
        //     for (int i = 0; i < s.length(); i++) 
        //         if (s.charAt(i) == v.charAt(i)) cnt++;
        //     return cnt;
        // }
        // Set<String> getCandidates(String [] arr, String s, int va) {
        //     Set<String> res = new HashSet<>();
        //     int cnt = 0;
        //     for (String v : arr) {
        //         cnt = 0;
        //         for (int i = 0; i < s.length(); i++) 
        //             if (s.charAt(i) == v.charAt(i)) cnt++;
        //         if (cnt == va) res.add(v);
        //     }
        //     return res;
        // } 
        // // public void findSecretWord(String[] wordlist, Master master) {
        // public boolean findSecretWord(String[] wordlist, String t) {
        //     int n = wordlist.length, m = 6, idx = 0, call = 0;
        //     Random rand = new Random();
        //     Set<String> vis = new HashSet<>();
        //     while (vis.contains(wordlist[idx]))
        //         idx = rand.nextInt(n); // [0, n)
        //     vis.add(wordlist[idx]);
        //     // int cnt = master.guess(wordlist[idx]);
        //     int cnt = guess(wordlist[idx], t);
        //     call++;
        //     if (cnt == 6) return true;
        //     // if (cnt == 6) return;
        //     Set<String> next = new HashSet<>();
        //     Set<String> can = getCandidates(wordlist, wordlist[idx], cnt);
        //     while (call < 10) {
        //         next.clear();
        //         for (String v : can) {
        //             if (vis.contains(v)) continue;
        //             // cnt = master.guess(v);
        //             cnt = guess(v, t);
        //             vis.add(v);
        //             // if (cnt == 6) return ;
        //             if (cnt == 6) return true;
        //             call++;
        //             next.addAll(getCandidates(wordlist, v, cnt));
        //         }
        //         next.retainAll(can);
        //         can.clear();
        //         can.addAll(next);
        //     }
        //     return false;
        // }       
        // private int getMatchedCnt(String s, String t) {
        //     int cnt = 0;
        //     for (int i = 0; i < s.length(); i++) 
        //         if (s.charAt(i) == t.charAt(i)) cnt++;
        //     return cnt;
        // }
        // public void findSecretWord(String[] wordlist, Master master) {
        //     int n = wordlist.length, call = 0;
        //     Random rand = new Random();
        //     Set<String> sur = new HashSet<>(Arrays.asList(wordlist));
        //     for (int i = 0, cnt = 0; i < 10 && cnt < 6; i++) {
        //         String g = wordlist[rand.nextInt(n)];
        //         cnt = master.guess(g);
        //         Set<String> ss = new HashSet<>();
        //         for (String s : sur) {
        //             if (getMatchedCnt(s, g) == cnt)
        //                 ss.add(s);
        //         }
        //         // ss.retainAll(sur);
        //         sur.clear();
        //         sur.addAll(ss);
        //         n = ss.size();
        //     }
        // }
        // public void findSecretWord(String[] wordlist, Master master) {
        //     int n = wordlist.length;
        //     for (int i = 0; i < 10; i++) {            
        //         int index = n/2;            
        //         String selected = wordlist[index];              
        //         int cnt = master.guess(selected);                             
        //         if (cnt == 6) return;                        
        //         for (int k = 0; k < n; k++) 
        //             if (countCnt(selected, wordlist[k]) != cnt) { // 直接把list变短变小了                    
        //                 n--;
        //                 wordlist[k] = wordlist[n];
        //             }
        //     }        
        // }
        // private int countCnt(String s1, String s2){
        //     int cnt = 0;
        //     for (int i = 0; i < 6; i ++) 
        //         if (s1.charAt(i) == s2.charAt(i)) 
        //             cnt++;
        //     return cnt;
        // }


        // public String entityParser(String t) {
        //     int n = t.length(), j = 0, i = 0;
        //     char [] s = t.toCharArray();
        //     String ans = "";
        //     while (i < n) {
        //         while (i < n && s[i] != '&') i++;
        //         if (i == n) return ans + t.substring(j, i);
        //         if (i > j) ans += new String(t.substring(j, i));
        //         if (s[i] == '&') {
        //             String cur = t.substring(i);
        //             if (cur.indexOf(";") == -1) {
        //                 ans += s[i] + "";
        //                 i++;
        //                 j = i;
        //                 continue;
        //             }
        //             j = i;
        //             while (j < n && s[j] != ';') j++;
        //             String tmp = t.substring(i, j+1);
        //             if (tmp.equals("&quot;")) {
        //                 ans += "\"";
        //                 i = i + 6;
        //                 j = i;
        //             } else if (tmp.equals("&apos;")) {
        //                 ans += "'";
        //                 i = i + 6;
        //                 j = i;
        //             } else if (tmp.equals("&amp;")) {
        //                 ans += "&";
        //                 i = i + 5;
        //                 j = i;
        //             } else if (tmp.equals("&gt;")) {
        //                 ans += ">";
        //                 i = i + 4;
        //                 j = i;
        //             } else if (tmp.equals("&lt;")) {
        //                 ans += "<";
        //                 i = i + 4;
        //                 j = i;
        //             } else if (tmp.equals("&frasl;")) {
        //                 ans += "/";
        //                 i = i + 7;
        //                 j = i;
        //             } else {
        //                 ans += s[i] + "";
        //                 i += 1;
        //                 j = i;
        //             }
        //         }
        //     }
        //     return ans;
        // }


        // private boolean idCheck(String ss, String tt) {
        //     int [] one = new int [26];
        //     int [] two = new int [26];
        //     char [] s = ss.toCharArray();
        //     char [] t = tt.toCharArray();
        //     for (int i = 0; i < s.length; i++) 
        //         one[s[i] - 'a']++;
        //     for (int i = 0; i < t.length; i++) 
        //         two[t[i]-'a']++;
        //     for (int i = 0; i < 26; i++) 
        //         if (one[i] != two[i])
        //             return false;
        //     return true;
        // }
        // public boolean isScramble(String s, String t) { // tle tle tle
        //     int n = s.length();
        //     if (n == 1) return s.charAt(0) == t.charAt(0);
        //     if (s.equals(t)) return true;
        //     if (!idCheck(s, t)) return false;
        //     for (int i = 1; i < n; i++) {
        //         System.out.println("\n i: " + i);
        //         String ls = s.substring(0, i), rs = s.substring(i);
        //         String ltone = t.substring(0, i), rtone = t.substring(i);
        //         String lttwo = t.substring(0, n-i), rttwo = t.substring(n-i);
        //         if (isScramble(ls, ltone) && isScramble(rs, rtone)
        //             || isScramble(ls, rttwo) && isScramble(rs, lttwo))
        //             return true;
        //     }
        //     return false;
        // } 
        // private boolean dfs(String s, String t) {
        //     String key = s + t;
        //     if (s.length() == 1 && t.length() == 1)
        //         return s.charAt(0) == t.charAt(0);
        //     if (dp.containsKey(key)) return dp.get(key);
        //     if (s.equals(t)) {
        //         dp.put(key, true);
        //         return true;
        //     }
        //     if (!idCheck(s, t)) {
        //         dp.put(key, false);
        //         return false;
        //     }
        //     int n = s.length();
        //     for (int i = 1; i < s.length(); i++) {
        //         String a = s.substring(0, i), b = s.substring(i);
        //         String c = t.substring(0, i), d = t.substring(i);
        //         String e = t.substring(0, n-i), f = t.substring(n-i);
        //         if (isScramble(a, c) && isScramble(b, d)
        //             || isScramble(a, f) && isScramble(b, e)) {
        //             dp.put(key, true);
        //             return true;
        //         }
        //     }
        //     dp.put(key, false);
        //     return false;
        // }
        // Map<String, Boolean> dp = new HashMap<>();
        // public boolean isScramble(String s, String t) {
        //     int n = s.length();
        //     if (n == 1) return s.charAt(0) == t.charAt(0);
        //     if (s.equals(t)) return true;
        //      if (!idCheck(s, t)) return false;
        //     return dfs(s, t);
        // } 
        // private boolean idCheck(String ss, String tt) {
        //     int [] one = new int [26];
        //     int [] two = new int [26];
        //     char [] s = ss.toCharArray();
        //     char [] t = tt.toCharArray();
        //     for (int i = 0; i < s.length; i++) 
        //         one[s[i] - 'a']++;
        //     for (int i = 0; i < t.length; i++) 
        //         two[t[i]-'a']++;
        //     for (int i = 0; i < 26; i++) 
        //         if (one[i] != two[i])
        //             return false;
        //     return true;
        // }
        // private int dfs(int i, int j, int k) { // k: length dp[i][j][len]: 这个dp的设计还是比较难想的！
        //     if (dp[i][j][k] != 0) return dp[i][j][k];
        //     String a = s.substring(i, i+k), b = t.substring(j, j+k);
        //     if (a.equals(b)) return dp[i][j][k] = 1;
        //     if (!idCheck(a, b)) return dp[i][j][k] = -1;
        //     for (int l = 1; l < k; l++) {
        //         if (dfs(i, j, l) == 1 && dfs(i+l, j+l, k-l) == 1)
        //             return dp[i][j][k] = 1;
        //         if (dfs(i, j+k-l, l) == 1 && dfs(i+l, j, k-l) == 1)
        //             return dp[i][j][k] = 1;
        //     }
        //     return dp[i][j][k] = -1;
        // }
        // int [][][] dp;
        // String s, t;
        // int n;
        // public boolean isScramble(String s, String t) {
        //     this.s = s;
        //     this.t = t;
        //     n = s.length();
        //     if (s.equals(t)) return true;
        //     if (!idCheck(s, t)) return false;
        //     dp = new int [n][n][n+1];
        //     return dfs(0, 0, s.length()) == 1;
        // } 
        // public boolean isScramble(String s, String t) {
        //     int n = s.length();
        //     if (s.equals(t)) return true;
        //     boolean [][][] dp = new boolean [n][n][n+1];
        //     for (int len = 1; len <= n; len++) 
        //         for (int i = 0; i+len <= n; i++) 
        //             for (int j = 0; j+len <= n; j++) {
        //                 if (len == 1) {
        //                     dp[i][j][len] = s.charAt(i) == t.charAt(j);
        //                     continue;
        //                 }
        //                 for (int k = 1; k < len; k++) 
        //                     if (dp[i][j][k] && dp[i+k][j+k][len-k] || dp[i][j+len-k][k] && dp[i+k][j][len-k])
        //                         dp[i][j][len] = true;
        //             }
        //     return dp[0][0][n];
        // }


        // private int quickmul(int base, int exp) { // 快速乘方算法
        //     long ans = 1L;
        //     while (exp > 0) {
        //         if ((exp & 1) == 1) // 指数是奇数，就先乘一次base
        //             ans = ans * base % mod;
        //         base = (int)((long)base * base % mod); // 底平方 (指数变偶数之后)
        //         exp >>= 1;                              // 指数除2，快速计算
        //     }
        //     return (int)ans;
        // }
        // int mod = (int)1e9 + 7;
        // public int makeStringSorted(String t) {
        //     int n = t.length();
        //     char [] s = t.toCharArray();
        //     int [] cnt = new int [26]; // 记录剩余字符串中各字母个数
        //     Arrays.fill(cnt, 0);
        //     for (int i = 0; i < n; i++) 
        //         cnt[s[i]-'a']++;
        //     int [] fact = new int [n+1];
        //     int [] finv = new int [n+1];
        //     fact[0] = 1;
        //     finv[0] = 1;
        //     for (int i = 1; i <= n; i++) {
        //         fact[i] = (int)((long)fact[i-1] * i % mod); // fac[i] = i! % mod
        //         finv[i] = quickmul(fact[i], mod - 2); // 费马小定理计算乘法逆元, facinv[i] = (i!) ^ -1 % mod
        //     }
        //     long ans = 0L;
        //     for (int i = 0; i < n-1; i++) {
        //         int lessCnt = 0; // 比当前位置小的字母总数
        //         for (int j = 0; j < s[i]-'a'; j++) 
        //             lessCnt += cnt[j];
        //         long upper = (long)lessCnt * fact[n-1-i] % mod; // 排列公式分子
        //         for (int j = 0; j < 26; j++) 
        //             upper = upper * finv[cnt[j]] % mod;
        //         ans = (ans + upper) % mod;
        //         cnt[s[i]-'a']--; // 指针右移
        //     }
        //     return (int)ans;
        // }


        // public String lastSubstring(String t) { // 我又是在真正的找和比较字符串，我是不是只比较一下字符和长短就可以了？
        //     int n = t.length();
        //     char [] s = t.toCharArray();
        //     Map<Character, List<Integer>> m = new HashMap<>();
        //     char max = 'a';
        //     for (int i = 0; i < n; i++) {
        //         if (i > 0 && s[i] == max && s[i-1] == max) continue;
        //         max = (char)(Math.max(s[i]-'a', max-'a')+'a');
        //         m.computeIfAbsent(s[i], z -> new ArrayList<>()).add(i);
        //     }
        //     List<Integer> idx = m.get(max);
        //     String ans = "";
        //     int ridx = -1;
        //     if (idx.size() == 1) return t.substring(idx.get(0));
        //     for (int i = 0; i < idx.size(); i++) {
        //         String tmp = t.substring(idx.get(i), i == idx.size()-1 ? n : idx.get(i+1));
        //         if (ans.equals("") || (ans.compareTo(tmp) < 0 || i < idx.size()-1 && ans.length() == tmp.length()+1 && ans.compareTo(tmp + max) < 0)) {
        //             ans = tmp;
        //             ridx = i == idx.size()-1 ? n : idx.get(i+1);
        //         }
        //     }
        //     return ridx == n ? ans : ans + t.substring(ridx);
        // }
        // public String lastSubstring(String t) { // tle tle tle: 对于重复连续字符会超时
        //     int n = t.length();
        //     char [] s = t.toCharArray();
        //     int i = 0, j = 1, k = 0;
        //     while (j+k < n) {
        //         if (s[i+k] == s[j+k]) {
        //             k++;
        //         } else if (s[i+k] < s[j+k]) {   // 找到了一个更优解
        //             // i = j; // tle tle tle    // 那么从j开始，再重新找起，看能否再找到更优解 ? !!!
        //             i = Math.max(i + k + 1, j); // 可是 j 不是已经扫过 k 个字符了吗？为什么还要再扫一遍呢？
        //             j = i + 1;
        //             k = 0; 
        //         } else { // s[i+k] > s[j+k] // i 所对应的正是比j更好的解，所以更新j, 重新走起
        //             // j++;  // tle tle tle
        //             j += k + 1; // 把 j 扫过的 k 个字符全部跳过去
        //             k = 0;
        //         }
        //     }
        //     return t.substring(i);
        // }


        // private String processInput(String t) {
        //     char [] s = t.toCharArray();
        //     // 由于第一个和最后一个字符都是#号，且也需要搜索回文，为了防止越界，我们还需要在首尾再加上非#号字符，实际操作时我们还需给开头加上个非#号字符'$'，结尾加一个'@'
        //     String ans = "$#"; // 不论原字符串是奇数还是偶数个，处理之后得到的字符串的个数都是奇数个，这样就不用分情况讨论了
        //     for (int i = 0; i < t.length(); i++) 
        //         ans += s[i] + "#";
        //     ans += "@";
        //     return ans;
        // }
        // public long maxProduct(String t) {
        //     int m = t.length();
        //     t = processInput(t);
        //     char [] s = t.toCharArray();
        //     int n = s.length;
        //     // 如何求 len 数组，需要新增两个辅助变量 r 和 idx，其中 idx 为最大回文子串中心的位置，r 是回文串能延伸到的最右端的位置
        //     int r = 0, idx = 0; // 最大右边界、最大回文串的中心位置
        //     int [] len = new int [n];
        //     for (int i = 1; i < n-1; i++) {
        //         len[i] = r > i ? Math.min(len[2*idx-i], r-i) : 1;
        //         while (i + len[i] < n-1 && i - len[i] >= 0 && s[i+len[i]] == s[i-len[i]])
        //             ++len[i];
        //         if (r < len[i]+i) {
        //             r = len[i] + i;
        //             idx = i;
        //         }
        //     }
        //     int [] arr = new int [m];
        //     idx = 0;
        //     for (int i = 2; i < n-1; i++) 
        //         if (s[i] != '#' && s[i] != '@') arr[idx++] = len[i] - len[i-1];
        //     int [] pre = new int [m]; 
        //     int [] suf = new int [m];
        //     return 0;
        // }
        // private int expand(int l, int r, String s) {
        //     while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
        //         l--;
        //         r++;
        //     }
        //     return (r - l - 2) / 2;
        // }
        // private int [] manacher(String s) {
        //     int [] ans = new int [s.length()];
        //     int idx = -1, r = -1;
        //     for (int i = 0; i < s.length(); i++) {
        //         int cur = (i <= r ? Math.min(r-i, ans[2 * idx - i]) + 1 : 1);
        //         ans[i] = expand(i-cur, i+cur, s);
        //         if (ans[i] + i > r) {
        //             idx = i;
        //             r = ans[i] + i;
        //         }
        //     }
        //     return ans;
        // }
        // public long maxProduct(String t) { // bug bug bug 不知道哪里错掉了
        //     int n = t.length();
        //     int [] len = manacher(t);
        //     int [] pre = new int [n], suf = new int [n];
        //     for (int i = 0; i < n; i++) {
        //         pre[i] = i;
        //         suf[i] = i;
        //     }
        //     for (int i = 0; i < n; i++) {
        //         suf[i - len[i]] = Math.max(i, suf[i - len[i]]);
        //         pre[i + len[i]] = Math.min(i, pre[i + len[i]]);
        //     }
        //     for (int i = 1; i < n; i++)
        //         suf[i] = Math.max(suf[i], suf[i-1]);
        //     for (int i = n-2; i >= 0; i--) 
        //         pre[i] = Math.min(pre[i], pre[i+1]);
        //     int [] pp = new int [n], ss = new int [n];
        //     pp[0] = 2 * pre[0] + 1;
        //     for (int i = 1; i < n; i++) 
        //         pp[i] = Math.max(pp[i-1], 2 * (i - pre[i]) + 1);
        //     ss[n-1] = 2 * (n-1 - suf[n-1]) + 1;
        //     for (int i = n-2; i >= 0; i--) 
        //         ss[i] = Math.max(suf[i+1], 2 * (suf[i] - i) + 1);
        //     long ans = 1;
        //     for (int i = 0; i < n-1; i++)
        //         ans = Math.max(ans, (long)pp[i] * ss[i+1]);
        //     return ans;
        // }


        // private static int[] manacherOdd(String str) {
        //     int n = str.length();
        //     char[] s = str.toCharArray();
        //     int [] ans = new int [n];
        //     for (int i = 0, l = 0, r = -1; i < n; i++) {
        //         int len = i > r ? 1 : Math.min(ans[l+r-i], r-i+1);
        //         int maxLen = Math.min(i, n-1-i);
        //         int x = i - len, y = i + len;
        //         while (len <= maxLen && s[x--] == s[y++]) len++;
        //         ans[i] = len--;
        //         if (i + len > r) {
        //             l = i - len;
        //             r = i + len;
        //         }
        //     }
        //     return ans;
        // }
        // public long maxProduct(String s) { // 这个马拉车，得多写几遍
        //     int n = s.length();
        //     int [] d = manacherOdd(s);
        //     int [] l = new int [n], r = new int [n];
        //     for (int i = 0; i < n; i++) {
        //         l[i+d[i]-1] = Math.max(l[i+d[i]-1], 2 * d[i]-1);
        //         r[i-d[i]+1] = 2 * d[i] - 1;
        //     }
        //     for (int i = n-2, j = n-1; i >= 0; i--, j--)
        //         l[i] = Math.max(l[i], l[j]-2);
        //     for (int i = 1, j = 0; i < n; i++, j++)
        //         r[i] = Math.max(r[i], r[j]-2);
        //     for (int i = 1, j = 0; i < n; i++, j++) 
        //         l[i] = Math.max(l[i], l[j]);
        //     for (int i = n-2, j = n-1; i >= 0; i--, j--)
        //         r[i] = Math.max(r[i], r[j]);
        //     long ans = 1;
        //     for (int i = 1; i < n; i++) 
        //         ans = Math.max(ans, (long)l[i-1] * r[i]);
        //     return ans;
        // }


        // public List<List<String>> findDuplicate(String[] paths) {
        //     Map<String, List<String>> m = new HashMap<>();
        //     List<List<String>> ans = new ArrayList<>();
        //     for (String s : paths) {
        //         String [] cur = s.split("\\s+");
        //         if (cur.length == 1) continue;
        //         for (int i = 1; i < cur.length; i++) {
        //             int bgn = cur[i].indexOf('(');
        //             String key = cur[i].substring(bgn, cur[i].length()-1);
        //             String path = cur[0] + "/" + cur[i].substring(0, bgn);
        //             m.computeIfAbsent(key, z -> new ArrayList<>()).add(path);
        //         }
        //     }
        //     for (Map.Entry<String, List<String>> en : m.entrySet()) {
        //         List<String> l = en.getValue();
        //         if (l.size() < 2) continue;
        //         ans.add(l);
        //     }
        //     return ans;
        // }


        // private String maskEmail(String t) {
        //     int n = t.length();
        //     char [] s = t.toCharArray();
        //     int idx = t.indexOf('@');
        //     String ans = Character.toLowerCase(s[0]) + "*****" + Character.toLowerCase(s[idx-1])+"@";
        //     for (int i = idx+1; i < n; i++) {
        //         if (Character.isUpperCase(s[i]))
        //             ans += Character.toLowerCase(s[i]);
        //         else ans += ""+s[i];
        //     }
        //     return ans;
        // }
        // private String maskPhone(String t) {
        //     int n = t.length();
        //     if (n == 10) return "***-***-" + t.substring(6);
        //     char [] s = t.toCharArray();
        //     int cnt = 0;
        //     for (int i = 0; i < n; i++)
        //         if (Character.isDigit(s[i])) cnt++;
        //     String ans = "";
        //     if (cnt == 13) ans = "+***-***-***-";
        //     else if (cnt == 12) ans = "+**-***-***-";
        //     else if (cnt == 11) ans = "+*-***-***-";
        //     else ans = "***-***-";
        //     StringBuilder sb = new StringBuilder();
        //     cnt = 0;
        //     for (int i = n-1; i >= 0; i--) 
        //         if (Character.isDigit(s[i])) {
        //             sb.append(s[i]);
        //             cnt++;
        //             if (cnt == 4)
        //                 return ans + sb.reverse().toString();
        //         }
        //     return ans;
        // }
        // public String maskPII(String t) {
        //     int n = t.length();
        //         if (n < 8 || n > 20 || t.indexOf('@') != -1)
        //             return maskEmail(t);
        //         else return maskPhone(t);
        // }


        public String reverseString(String s) {
            String reversedString = new StringBuilder (s).reverse().toString();
            char [] rs = reversedString.toCharArray();
            int i = 0, idx = 0;
            while (i < s.length()) {
                while (Character.isDigit(rs[i])) i++;
                if (i == s.length()) break;
                if (idx != i)
                    rs[idx++] = rs[i];
                i++;
            }
            StringBuilder sb = new StringBuilder();
            for ( i = 0; i < idx; i++) 
                sb.append(rs[i]);
            return sb.toString();
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        String a = "dkjfh 1 23 kdlfjdk ";

        String r = s.reverseString(a);
        System.out.println("r: " + r);
    }
}