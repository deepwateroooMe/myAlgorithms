// import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

public class slidingWindow {
    public static class Solution {

        // public int numOfSubarrays(int[] arr, int k, int threshold) {
        //     int n = arr.length;
        //     int [] pre = new int [n];
        //     pre[0] = arr[0];
        //     int res = 0;
        //     for (int i = 1; i < n; i++) 
        //         pre[i] = pre[i-1] + arr[i];
        //     for (int i = 0; i+k <= n; i++) { // j = i+k-1]
        //         if (pre[i+k-1] < k * threshold) continue;
        //         if (pre[i+k-1]-(i == 0 ? 0 : pre[i-1]) >= threshold*k) ++res;
        //     } 
        //     return res;
        // } 


        // // https://blog.csdn.net/Yaokai_AssultMaster/article/details/79599809
        // public class MaxSeg {
        //     List<Integer> tree = new ArrayList<>();
        //     int n;
        //     public MaxSeg (int [] arr) {
        //         n = arr.length;
        //         tree = new ArrayList<>(2*n);
        //         for (int i = 0; i < n; i++) 
        //             tree.add(0);
        //         for (int i = 0; i < n; i++) 
        //             tree.add(arr[i]); // same effect as below
        //         for (int i = n-1; i >= 0; i--) // i >= 0
        //             tree.set(i, Math.max(tree.get(2*i), tree.get(2*i+1)));
        //     }
        //     public void update(int idx, int v) {
        //         idx += n;
        //         tree.set(idx, v);
        //         while (idx > 1) {
        //             idx /= 2;
        //             tree.set(idx, Math.max(tree.get(2*idx), tree.get(2*idx+1)));
        //         }
        //     }
        //     public int getMax(int l, int r) {
        //         l += n;
        //         r += n;
        //         int max = Integer.MIN_VALUE;
        //         while (l < r) {
        //             if ((l & 1) == 1) {
        //                 max = Math.max(max, tree.get(l));
        //                 l++;
        //             }
        //             if ((r & 1) == 1) {
        //                 r--;            // order matters !!!
        //                 max = Math.max(max, tree.get(r));
        //             }
        //             l >>= 1;
        //             r >>= 1;
        //         }
        //         return max;
        //     }
        // }
        // public int[] maxSlidingWindow(int[] arr, int k) {
        //     int n = arr.length;
        //     MaxSeg mat = new MaxSeg(arr);
        //     if (n == k) return new int [] {mat.getMax(0, n)};
        //     int [] res = new int [n-k+1];
        //     for (int i = 0; i+k <= n; i++) 
        //         res[i] = mat.getMax(i, i+k);
        //     return res;
        // }
        // public int[] maxSlidingWindow(int[] arr, int k) {
        //     int n = arr.length, startWindowIdx = 0;
        //     ArrayDeque<Integer> q = new ArrayDeque<>(); // 维持一个递减队列
        //     int [] ans = new int [n - k + 1];
        //     for (int i = 0; i < n; i++) {
        //         startWindowIdx = i-k+1;
        //         while (!q.isEmpty() && i - q.peekFirst() >= k) q.pollFirst();     // 左出q：maintain k size window, 去头：去掉k windows之外的元素
        //         while (!q.isEmpty() && arr[q.peekLast()] <= arr[i]) q.pollLast(); // 右出q：去掉递减队列尾部所有不大于当前值的元素，就留一个最大值也行
        //         q.offerLast(i);  // 进q：进后此时q.size() == k 
        //         if (startWindowIdx >= 0)
        //             ans[startWindowIdx] = arr[q.peekFirst()]; // 使用递减队列左端最大值
        //     }
        //     return ans;
        // }

        
        // public int shortestSubarray(int[] nums, int k) { 
        //     int n = nums.length;
        //     int [] sum = new int[n+1];  
        //     for (int i = 1; i <= n; i++)  
        //         sum[i] = nums[i-1] + sum[i-1];
        //     int res = n + 1;
        //     ArrayDeque<Integer> q = new ArrayDeque<>(); // decreasing sum [] deque
        //     for (int i = 0; i <= n; i++) {
        //         while (!q.isEmpty() && sum[i] - sum[q.peekFirst()] >= k)  // 左出：
        //             res = Math.min(res, i - q.pollFirst()); // 取值了      // 取解
        //         while (!q.isEmpty() && sum[q.peekLast()] >= sum[i])       // 右出
        //             q.pollLast();  
        //         q.offerLast(i);                                           // 当前元素进队列
        //     }
        //     return res <= n ? res : -1;
        // }


        // public int minKBitFlips(int [] arr, int k) {
        //     int n = arr.length;
        //     int cnt = 0;
        //     for (int i = 0; i < n; i++) {
        //         if (arr[i] == 0) {
        //             if (i + k <= n) {
        //                 ++cnt;
        //                 for (int j = i; j < i+k; j++) 
        //                     arr[j] = 1 - arr[j];
        //             } else return -1;
        //         }
        //     }
        //     return cnt;
        // }


        // public int numberOfSubstrings(String s) { // 这个，不知道自己错哪里了
        //     int n = s.length(), j = 0;
        //     int [][] idx = new int [n][3]; // a b c
        //     for (int i = 0; i < n; i++) 
        //         Arrays.fill(idx[i], -1);
        //     char cur = ' ';
        //     int mask = 0;
        //     int res = 0;
        //     for (int i = 0; i < n; i++) {
        //         if (i > 0 && s.charAt(i) == s.charAt(i-1)) {
        //             idx[i][s.charAt(i)-'a'] = i;
        //             for ( j = 0; j < 3; j++) 
        //                 if (j != s.charAt(i)-'a') idx[i][j] = idx[i-1][j];
        //             continue;
        //         }
        //         cur = s.charAt(i);
        //         mask |= (1 << cur-'a');
        //         idx[i][cur-'a'] = i;
        //         j = i + 1;
        //         while (j < n && mask != 7) {
        //             if (s.charAt(j) != cur) {
        //                 idx[i][s.charAt(j)-'a'] = j;
        //                 mask |= (1 << s.charAt(j)-'a');
        //             }
        //             ++j;
        //         }
        //         mask = 0;
        //     }
        //    for (int i = 0; i < n; i++) {
        //         for ( j = 0; j < 3; j++) 
        //             if (idx[i][j] == -1) break;
        //         if (j < 3) continue;
        //         res += n-Math.max(idx[i][0], Math.max(idx[i][1], idx[i][2])); // 可以在前面一个循环里执行
        //     }
        //     return res;
        // }
        // public int numberOfSubstrings(String t) {
        //     int n = t.length(), left = 0, right = 0, res = 0;
        //     int [] cnt = new int [3];
        //     char [] s = t.toCharArray();
        //     while (left < n && right < n) {
        //         cnt[s[right]-'a']++;
        //         while (cnt[0] > 0 && cnt[1] > 0 && cnt[2] > 0) {
        //             res += n - right;
        //             cnt[s[left++]-'a']--;
        //         }
        //         right++;
        //     }
        //     return res;
        // }

        
        // public int numberOfSubarrays(int[] arr, int k) {
        //     int n = arr.length;
        //     int cnt = 0, res = 0, left = 0, right = 0;
        //     while (left < n && right < n) {
        //         if (arr[right] % 2 == 1) ++cnt;
        //         if (cnt > k) {
        //             while (cnt > k) {
        //                 if (arr[left] % 2 == 1) --cnt;
        //                 ++left;
        //             }
        //         }
        //         if (cnt == k) {
        //             System.out.println("\nleft: " + left);
        //             System.out.println("right: " + right);
        //             ++res;   
        //         }
        //         right++;
        //     }
        //     return res;
        // }


        // public int maxVowels(String s, int k) {
        //     int n = s.length();
        //     int max = 0, cnt = 0;
        //     Set<Character> sv = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u'));
        //     for (int i = 0; i < k; i++) 
        //         if (sv.contains(s.charAt(i))) ++cnt;
        //     max = cnt;
        //     for (int i = k; i < n; i++) {
        //         if (sv.contains(s.charAt(i-k))) --cnt;
        //         if (sv.contains(s.charAt(i))) ++cnt;
        //         max = Math.max(max, cnt);
        //     }
        //     return max;
        // }


        // public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        //     int n = customers.length;
        //     int max = 0, sum = 0;
        //     int [][] pre = new int [2][n];
        //     for (int i = 0; i < n; i++) {
        //         pre[0][i] = (i == 0 ? 0 : pre[0][i-1]) + customers[i];
        //         if (grumpy[i] == 1)
        //             pre[1][i] = i == 0 ? 0 : pre[1][i-1];
        //         else pre[1][i] = (i == 0 ? 0 : pre[1][i-1]) + customers[i];
        //     }
        //     max = pre[0][minutes-1] + pre[1][n-1] - pre[1][minutes-1];
        //     for (int i = minutes; i < n; i++) {
        //         sum = pre[1][i-minutes] + (pre[0][i] - pre[0][i-minutes]) + pre[1][n-1] - pre[1][i];
        //         max = Math.max(max, sum);
        //     }
        //     return max;
        // }


        // public int maximumUniqueSubarray(int[] arr) {
        //     int n = arr.length;
        //     int [] sum = new int [n];
        //     for (int i = 0; i < n; i++) 
        //         sum[i] = (i == 0 ? 0 : sum[i-1]) + arr[i];
        //     Set<Integer> s = new HashSet<>();
        //     int i = 0, li = 0;
        //     int max = 0, cur = 0;
        //     while (i < n) {
        //         while (i < n && !s.contains(arr[i])) {
        //             s.add(arr[i]);
        //             ++i;
        //         }
        //         cur = sum[i-1] - (li == 0 ? 0 : sum[li-1]);
        //         max = Math.max(max, cur);
        //         if (i == n) return max;
        //         while (li < i && arr[li] != arr[i]) {
        //             s.remove(arr[li]);
        //             ++li;
        //         }
        //         ++li;
        //         i++;
        //     }
        //     return max;
        // }


        // public int characterReplacement(String s, int k) {
        //     int n = s.length(), max = 1, cur = 0;
        //     int [][] cnt = new int [n][26];
        //     cnt[0][s.charAt(0)-'A']++;
        //     for (int i = 1; i < n; i++) {
        //         cnt[i] = cnt[i-1].clone();
        //         cnt[i][s.charAt(i)-'A']++;
        //     }
        //     for (int d = max; d <= n; d++) {
        //         for (int i = 0; i+d <= n; i++) {
        //         }
        //     }
        // }


        // public int maxScore(int[] cardPoints, int k) {
        //     int n = cardPoints.length, sum = Arrays.stream(cardPoints).sum();
        //     int [] pre = new int [n+1];
        //     for (int i = 1; i <= n; i++) 
        //         pre[i] = pre[i-1] + cardPoints[i-1];
        //     int j = 0, cur = sum - pre[n-k], max = cur;
        //     for (int i = n-k; i < n; i++) 
        //         max = Math.max(max, sum - (pre[i+1] - pre[i-n+k+1]));
        //     return max;
        // }


        // public int longestBeautifulSubstring(String word) {
        //     int n = word.length(), max = 0, j = 0, i = 0;
        //     Set<Character> s = new HashSet<>();
        //     s.add(word.charAt(0));
        //     for (i = 1; i < n; i++) {
        //         if (word.charAt(i) - 'a' < word.charAt(i-1) - 'a') {
        //             if (s.size() == 5)
        //                 max = Math.max(max, i-j);
        //             System.out.println("max: " + max);
        //             j = i;
        //             s.clear();
        //             s.add(word.charAt(i));
        //         } else s.add(word.charAt(i));
        //     }
        //     if (s.size() == 5)
        //         max = Math.max(max, i-j);
        //     return max;
        // }


        // public int longestOnes(int [] arr, int k) { // 为什么slidingWindow我不会用for loop呢？
        //     int n = arr.length;
        //     int i = 0, cnt = 0, max = 0;
        //     for (int j = 0; j < n; j++) {
        //         if (arr[j] == 0) cnt++;
        //         while (cnt > k) {
        //             if (arr[i] == 0) cnt--;
        //             i++;
        //         }
        //         max = Math.max(max, j-i+1);
        //     }
        //     return max;
        // }


        // class Trie {
        //     int cnt;
        //     Trie [] children;
        //     public Trie() {
        //         this.cnt = 0;
        //         this.children = new Trie[26];
        //     }
        // }
        // private int insert(Trie root, char [] s, int idx, int minSize, int maxSize, int maxLetters) {
        //     int max = 0;
        //     Trie r = root;
        //     int i, curCnt, childIdx;
        //     Set<Character> sc = new HashSet<>();
        //     for ( i = idx, curCnt = 1; i < s.length && curCnt <= maxSize; i++, curCnt++) {
        //         sc.add(s[i]);
        //         if (sc.size() > maxLetters) return max;
        //         childIdx = s[i] - 'a';
        //         if (r.children[childIdx] == null)
        //             r.children[childIdx] = new Trie();
        //         r = r.children[childIdx];
        //         ++r.cnt;
        //         if (curCnt >= minSize) max = Math.max(max, r.cnt);
        //     }
        //     return max;
        // }
        // public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        //     Trie root = new Trie();
        //     char [] letters = s.toCharArray();
        //     int n = s.length(), i = 0, max = 0; // i: start idx
        //     for (i = 0; i + minSize <= n; i++) 
        //         max = Math.max(max, insert(root, letters, i, minSize, maxSize, maxLetters));
        //     return max;
        // }
        // public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        //     int n = s.length(), i = 0, max = 0; // i: start idx
        //     Map<Character, Integer> cnt = new HashMap<>();
        //     Map<String, Integer> m = new HashMap<>();
        //     for (int j = 0; j < n; j++) {       // j: end idx, 每次往右移动一个位置
        //         char c = s.charAt(j);
        //         cnt.put(c, cnt.getOrDefault(c, 0) + 1);
        //         if (j - i + 1 > minSize) { // 较短的子串个数一定大于等于较长的子串个数,所以只需要找到最短的子串就可以了
        //             char sc = s.charAt(i);
        //             cnt.put(sc, cnt.get(sc) - 1);
        //             if (cnt.get(sc) == 0) cnt.remove(sc);
        //             i++;
        //         }
        //         if (cnt.size() <= maxLetters && j-i+1 >= minSize) {
        //             String sub = s.substring(i, j+1);
        //             m.put(sub, m.getOrDefault(sub, 0) + 1);
        //             max = Math.max(max, m.get(sub));
        //         } 
        //     }
        //     return max;
        // }

        // public int characterReplacement(String s, int k) {
        //     int n = s.length(), max = 0, i = 0;
        //     int [] cnt = new int [26];
        //     for (int j = 0; j < n; j++) {
        //         char c = s.charAt(j);
        //         cnt[c-'A']++;
        //         if (j-i+1 - Arrays.stream(cnt).max().getAsInt() > k) {
        //             char sc = s.charAt(i);
        //             cnt[sc-'A']--;
        //             i++;
        //         }
        //         if (j-i+1 - Arrays.stream(cnt).max().getAsInt() <= k) 
        //             max = Math.max(max, j-i+1);
        //     }
        //     return max;
        // }
        

        // public int numSubarraysWithSum(int[] arr, int goal) {
        //     int n = arr.length, cnt = 0, i = 0, j = 0;
        //     int [] sum = new int [n];
        //     for ( j = 0; j < n; j++) 
        //         sum[j] = (j == 0 ? 0 : sum[j-1]) + arr[j];
        //     for ( j = 0; j < n; j++) {
        //         if (sum[j] - (i == 0 ? 0 : sum[i-1]) > goal) i++;
        //         if (sum[j] - (i == 0 ? 0 : sum[i-1]) == goal) cnt++;
        //     }
        //     ++i; --j;
        //     while (i < j && sum[j] - (i == 0 ? 0 : sum[i-1]) == goal) {
        //         cnt++;
        //         ++i;
        //     }
        //     return cnt;
        // }


        // public int equalSubstring(String s, String t, int maxCost) {
        //     int n = s.length(), i = 0, max = 0;
        //     int [] arr = new int [n];
        //     int [] sum = new int [n];
        //     for (int j = 0; j < n; j++) {
        //         arr[j] = Math.abs(s.charAt(j) - t.charAt(j));
        //         sum[j] = (j == 0 ? 0 : sum[j-1]) + arr[j];
        //     }
        //     for (int j = 0; j < n; j++) {
        //         if (sum[j] - (i == 0 ? 0 : sum[i-1]) > maxCost) i++;
        //         if (sum[j] - (i == 0 ? 0 : sum[i-1]) <= maxCost)
        //             max = Math.max(max, j-i+ 1);
        //     }
        //     return max;
        // }


        // public boolean checkInclusion(String s, String t) {
        //     int n = t.length();
        //     int m = s.length();
        //     int [] cnt = new int [26];
        //     for (int i = 0; i < m; i++) 
        //         cnt[s.charAt(i)-'a']++;
        //     int [] cur = new int [26];
        //     int i = 0;
        //     for (int j = 0; j < n; j++) {
        //         cur[t.charAt(j)-'a']++;
        //         if (j < m-1) continue;
        //         if (j >= m) {
        //             cur[t.charAt(j-m)-'a']--;
        //             i++;
        //         }
        //         if (j-i+1 == m && Arrays.equals(cnt, cur)) return true;
        //     }
        //     return false;
        // }


        // public int longestSubstring(String s, int k) {
        //     int n = s.length(), i = 0, max = 0;
        //     Map<Character, Integer> m = new HashMap<>();
        //     for (int j = 0; j < n; j++) {
        //         m.put(s.charAt(j), m.getOrDefault(s.charAt(j), 0) + 1);
        //         if (Collections.min(m.values()) >= k)
        //             max = Math.max(max, j-i+1);
        //     }
        // }


        // public int numberOfSubarrays(int[] arr, int k) {
        //     int n = arr.length, res = 0, leftCnt = 0, j = 0, cnt = 0;
        //     for (int i = 0; i < n; i++) {
        //         if (arr[i] % 2 == 1) ++cnt;
        //         else res += leftCnt;
        //         if (cnt == k) {
        //             leftCnt = 0;
        //             while (j <= i && cnt == k) {// k ==> k-1
        //                 if (arr[j++] % 2 == 1) --cnt;
        //                 leftCnt++;
        //             }
        //             res += leftCnt;
        //         }
        //     }
        //     return res;
        // }


        // public int numSubarraysWithSum(int[] arr, int goal) {
        //     int n = arr.length, res = 0, sum = 0;
        //     Map<Integer, Integer> m = new HashMap<>();
        //     m.put(0, 1);
        //     for (int v : arr) {
        //         sum += v;
        //         res += m.getOrDefault(sum - goal, 0);
        //         m.put(sum, m.getOrDefault(sum, 0) + 1);
        //     }
        //     return res;
        // }
        // public int numSubarraysWithSum(int[] arr, int goal) { 
        //     int n = arr.length, res = 0, leftCnt = 0, j = 0, sum = 0;
        //     for (int i = 0; i < n; i++) {
        //         sum += arr[i];
        //         while (j < i && sum > goal) sum -= arr[j++];
        //         if (sum < goal) continue;
        //         if (sum == goal) ++res;
        //         for (int k = j; k < i && arr[k] == 0; k++) 
        //             ++res;
        //     }
        //     return res;
        // }


        // public List<Integer> findAnagrams(String s, String p) {
        //     int n = s.length();
        //     int m = p.length();
        //     int [] cnt = new int [26];
        //     int [] arr = new int [26];
        //     for (int i = 0; i < m; i++) 
        //         cnt[p.charAt(i)-'a']++;
        //     System.out.println(Arrays.toString(cnt));
        //     int j = 0;
        //     List<Integer> res = new ArrayList<>();
        //     for (int i = 0; i < n; i++) {
        //         arr[s.charAt(i)-'a']++;
        //         if (i < m-1) continue;
        //         if (i >= m) arr[s.charAt(j++)-'a']--;
        //         if (i - j == m-1 && Arrays.equals(cnt, arr)) res.add(j);
        //     }
        //     return res;
        // }


        // public class MaxSeg {
        //     List<Integer> tree = new ArrayList<>();
        //     int n;
        //     public MaxSeg (int [] arr) {
        //         n = arr.length;
        //         tree = new ArrayList<>(2 * n);
        //         for (int i = 0; i < n; i++)
        //             tree.add(0);
        //         for (int i = 0; i < n; i++)
        //             tree.add(arr[i]); // same effect as below
        //         for (int i = n-1; i >= 0; i--) // i >= 0
        //             tree.set(i, Math.max(tree.get(2 * i), tree.get(2 * i+1)));
        //     }
        //     public void update(int idx, int v) {
        //         idx += n;
        //         tree.set(idx, v);
        //         while (idx > 1) {
        //             idx /= 2;
        //             tree.set(idx, Math.max(tree.get(2 * idx), tree.get(2 * idx+1)));
        //         }
        //     }
        //     public int getMax(int l, int r) {
        //         l += n;
        //         r += n;
        //         int max = Integer.MIN_VALUE;
        //         while (l < r) {
        //             if ((l & 1) == 1) {
        //                 max = Math.max(max, tree.get(l));
        //                 l++;
        //             }
        //             if ((r & 1) == 1) {
        //                 r--; // order matters !!!
        //                 max = Math.max(max, tree.get(r));
        //             }
        //             l >>= 1;
        //             r >>= 1;
        //         }
        //         return max;
        //     }
        // }        
        // public class MinSeg {
        //     List<Integer> tree = new ArrayList<>();
        //     int n;
        //     public MinSeg (int [] arr) {
        //         n = arr.length;
        //         tree = new ArrayList<>(2*n);
        //         for (int i = 0; i < n; i++) 
        //             tree.add(0);
        //         for (int i = 0; i < n; i++) 
        //             tree.add(arr[i]); 
        //         for (int i = n-1; i >= 0; i--)  // i >= 0
        //             tree.set(i,  Math.min(tree.get(2*i),  tree.get(2*i+1)));
        //     }
        //     public void update(int idx,  int v) {
        //         idx += n;
        //         tree.set(idx,  v);
        //         while (idx > 1) {
        //             idx /= 2;
        //             tree.set(idx,  Math.min(tree.get(2*idx),  tree.get(2*idx+1)));
        //         }
        //     }
        //     public int getMin(int l,  int r) { // [l, r) include left, not included right
        //         l += n;
        //         r += n;
        //         int min = Integer.MAX_VALUE;
        //         while (l < r) {
        //             if ((l & 1) == 1) {
        //                 min = Math.min(min,  tree.get(l));
        //                 l++;
        //             }
        //             if ((r & 1) == 1) {
        //                 r--; // order matters !!!
        //                 min = Math.min(min,  tree.get(r));
        //             }
        //             l >>= 1;
        //             r >>= 1;
        //         }
        //         return min;
        //     }
        // }
        // public int longestSubarray(int[] arr, int limit) { // 单调递增队列，左小右大，右进左出 
        //     MaxSeg max = new MaxSeg(arr);
        //     MinSeg min = new MinSeg(arr);
        //     int res = 0, tmp = 0, j = 0;
        //     int n = arr.length;
        //     for (int i = 1; i <= n; i++) {
        //         if (max.getMax(j, i) - min.getMin(j, i) <= limit) {
        //             tmp = i-j;
        //             res = Math.max(res, tmp);
        //         } else 
        //             while (max.getMax(j, i) - min.getMin(j, i) > limit && j < i) ++j;
        //     }
        //     return res;
        // }
        // public int longestSubarray(int[] arr, int limit) { // 单调递增队列，左小右大，右进左出: 这个方法需要学习的巩固
        //     int n = arr.length, max = 0;
        //     ArrayDeque<Integer> q = new ArrayDeque<>(); 
        //     for (int i = 0; i < n; i++) {
        //         while (!q.isEmpty() && Math.max(arr[q.peekLast()], arr[i]) - arr[q.peekFirst()] > limit) 
        //             // while (!q.isEmpty() && arr[i] - arr[q.peekFirst()] > limit) 
        //             q.pollFirst(); // 出队头的条件没想清楚
        //         while (!q.isEmpty() && arr[q.peekLast()] >= arr[i]) // 出尾：虽然arr[i]可能比队尾元素小，但当前元素构成的子数组长度最优
        //             q.pollLast();
        //         // max = Math.min(max, q.pollLast() - (q.size() > 0 ? q.peekFirst() : 0) + 1);
        //         q.offerLast(i);   
        //         max = Math.max(max, q.peekLast() - q.peekFirst() + 1);
        //     }
        //     return max;
        // }
        // public int longestSubarray(int[] arr, int limit) { // 单调递增队列，左小右大，右进左出 
        //     ArrayDeque<Integer> minq = new ArrayDeque<>(); // 单调递增队列
        //     ArrayDeque<Integer> maxq = new ArrayDeque<>(); // 单调递减队列
        //     for (int i = 0; i < arr.length; i++) {
        //         while (!minq.isEmpty() && arr[minq.peekLast() >= arr[i]]) 
        //             minq.pollLast(); 
        //         while (!maxq.isEmpty() && arr[maxq.peekLast()] >= arr[i]) // 出尾：虽然arr[i]可能比队尾元素小，但当前元素构成的子数组长度最优
        //             maxq.pollLast();
        //         minq.offerLast(i);   
        //         maxq.offerLast(i);   
        //         max = Math.max(max, Math.max(maxq.peekLast() - minq.peekFirst(), minq.peekLast()-maxq.peekFirst()) + 1);
        //     }
        //     return max;
        // }


        //  public int findMaxValueOfEquation(int[][] points, int k) {
        //     int n = points.length;
        //     int max = Integer.MIN_VALUE, dif = 0,  tmp = 0, j = 0, i = 1;
        //     ArrayDeque<Integer> q = new ArrayDeque<>(); // O(N): 需要手动维护一个双端队列, 递减排列
        //     q.offerLast(points[0][1]-points[0][0]);
        //     while (i < n) {
        //         if (points[i][0] - points[j][0] > k) {
        //             if (!q.isEmpty() && points[j][1] - points[j][0] == q.peekFirst()) q.pollFirst();
        //             j++;
        //             if (j == i) {
        //                 q.clear();
        //                 q.offerLast(points[j][1]- points[j][0]);
        //                 i++;
        //             }
        //         } else {
        //             tmp = points[i][0] + points[i][1] + q.peekFirst();
        //             max = Math.max(max, tmp);
        //             while (!q.isEmpty() &&  points[i][1]-points[i][0] > q.peekLast()) q.pollLast();
        //             q.offerLast(points[i][1]-points[i][0]);
        //             i++;
        //         }
        //     } // 双端队列的队头队尾操作再想一下
        //     return max;
        // }
        // public int findMaxValueOfEquation(int[][] points, int k) {
        //     ArrayDeque<int []> q = new ArrayDeque<>();
        //     int max = Integer.MIN_VALUE;
        //     for (int [] pt : points) {
        //         while (!q.isEmpty() && pt[0] - q.peekFirst()[0] > k)
        //             q.pollFirst();
        //         if (!q.isEmpty()) 
        //             max = Math.max(max, pt[1] + pt[0] + q.peekFirst()[1] - q.peekFirst()[0]);
        //         while (!q.isEmpty() && pt[1] - pt[0] >= q.peekLast()[1] - q.peekLast()[0])
        //             q.pollLast();
        //         q.offerLast(pt);
        //     }
        //     return max;
        // }


        // public int longestSubstring(String s, int k) {
        //     int n = s.length(), j = 0, max = 1;
        //     Map<Integer, Integer> m = new HashMap<>();
        //     boolean preValid = false;
        //     for (int i = 0; i < n; i++) {
        //         m.put(s.charAt(i), m.getOrDefault(s.charAt(i), 0) + 1);
        //         if (m.size() > 0 && Collections.min(m.values()) >= k) {
        //             max = Math.max(max, i-j+1); // 我觉得这里的左右移动我是不太清楚的
        //             if (!preValid) preValid = true;
        //         } else if (m.size() > 0 && preValid) {
        //             m.put(s.charAt(i), m.get(s.charAt(i))-1);
        //             if (m.get(s.charAt(i)) == 0) m.remove(s.charAt(i));
        //             while ()
        //         }
        //     }
        // }

        
        // private int solve(char c, String s) {
        //     int n = s.length(), max = 0;
        //     int f = 0, g = 0, cnt = 0;
        //     for (int i = 0; i < n; i++) {
        //         if (c == s.charAt(i)) {
        //             f++;
        //             g++;
        //             cnt++;
        //         } else {
        //             g = f + 1;
        //             f = 0;
        //         }
        //         max = Math.max(max, Math.max(f, g));
        //     }
        //     return Math.min(max, cnt);
        // }
        // public int maxRepOpt1(String s) {
        //     int n = s.length(), ans = 0;
        //     for (char i = 'a'; i <= 'z'; i++) 
        //         ans = Math.max(ans, solve(i, s));
        //     return ans;
        // }
        // public int maxRepOpt1(String s) { // O(n^2)
        //     int n = s.length(), ans = 0;
        //     Map<Character, Integer> charCnt = new HashMap<>();
        //     for (char c : s.toCharArray()) 
        //         charCnt.put(c, charCnt.getOrDefault(c, 0) + 1);
        //     for (int i = 0; i < n; i++) {
        //         char cur = s.charAt(i);
        //         int j = i, cnt = 0, dif = 0;
        //         while (j < n && (cur == s.charAt(j) || dif == 0) && cnt < charCnt.get(cur)) {
        //             if (cur != s.charAt(j)) {
        //                 ++dif;
        //                 i = j-1; // exchanged once, i moves to be the repeated sequence tail
        //             }
        //             ++cnt;
        //             ++j;
        //         }
        //         ans = Math.max(ans, cnt);
        //     }
        //     for (int i = n-1; i >= 0; i--) {
        //         char cur = s.charAt(i);
        //         int j = i, cnt = 0, dif = 0;
        //         while (j >= 0 && (cur == s.charAt(j) || dif == 0) && cnt < charCnt.get(cur)) {
        //             if (cur != s.charAt(j)) {
        //                 ++dif;
        //                 i = j+1;
        //             }
        //             ++cnt;
        //             --j;
        //         }
        //         ans = Math.max(ans, cnt);
        //     }
        //     return res;
        // }
        // public int maxRepOpt1(String s) { // O(n^2)
        //     int n = s.length(), ans = 0;
        //     Map<Character, List<Integer>> idxMap = new HashMap<>();
        //     for (int i = 0; i < n; i++) 
        //         idxMap.computeIfAbsent(s.charAt(i), k -> new ArrayList<>()).add(i);
        //     for (char c = 'a'; c <= 'z'; c++) {
        //         if (!idxMap.containsKey(c)) continue;
        //         int cnt = 1, cntb = 0, max = 0;
        //         List<Integer> idxs = idxMap.get(c);
        //         for (int i = 1; i < idxs.size(); i++) {
        //             if (idxs.get(i) == idxs.get(i-1) + 1) // aa
        //                 ++cnt;
        //             else {
        //                 cntb = (idxs.get(i) == idxs.get(i-1) + 2) ? cnt : 0; // aba ?
        //                 cnt = 1;
        //             }
        //             max = Math.max(max, cnt + cntb);
        //         }
        //         ans = Math.max(ans, max + (idxs.size() > max ? 1 : 0)); // aaaaabaaaaaca 多于两个重复子段，中间替换字符可是是相同的
        //     }
        //     return ans;
        // }

        
//         由于字母只有 26 个，而整型 mask 有 32 位，足够用了，
//         每一位代表一个字母，如果为1，表示该字母不够k次，如果为0就表示已经出现了k次，这种思路真是太聪明了，
//         隐约记得这种用法在之前的题目中也用过，但是博主并不能举一反三( 沮丧脸:( )，还得继续努力啊。
// 遍历字符串，对于每一个字符，都将其视为起点，然后遍历到末尾，增加 HashMap 中字母的出现次数，如果其小于k，将 mask 的对应位改为1，如果大于等于k，将 mask 对应位改为0。
// 然后看 mask 是否为0，是的话就更新 res 结果，然后把当前满足要求的子字符串的起始位置j保存到 max_idx 中，等内层循环结束后，将外层循环变量i赋值为 max_idx+1，继续循环直至结束
        // public int longestSubstring(String s, int k) { // O (N ^ 2)
        //     int n = s.length(), res = 0, i = 0;
        //     while (i + k <= n) {
        //         int [] m = new int [26];
        //         int mask = 0, maxIdx = i;
        //         for (int j = i; j < n; j++) {
        //             int t = s.charAt(j) - 'a';
        //             m[t]++;
        //             if (m[t] < k) mask |= (1 << t);
        //             else mask &= (~(1 << t));
        //             if (mask == 0) {
        //                 res = Math.max(res, j-i+1);
        //                 maxIdx = j;
        //             }
        //         }
        //         i = maxIdx + 1;
        //     }
        //     return res;
        // }
        // public int longestSubstring(String s, int k) {
        //     int n = s.length(), res = 0;
        //     for (int cnt = 1; cnt <= 26; cnt++) {
        //         int start = 0, i = 0, uniqueCnt = 0;
        //         int [] charCnt = new int [26];
        //         while (i < n) {
        //             boolean valid = true;
        //             if (charCnt[s.charAt(i++)-'a']++ == 0) ++ uniqueCnt;
        //             while (uniqueCnt > cnt) 
        //                 if (--charCnt[s.charAt(start++)-'a'] == 0) --uniqueCnt;
        //             for (int j = 0; j < 26; j++)
        //                 if (charCnt[j] > 0 && charCnt[j] < k) valid = false;
        //             if (valid) res = Math.max(res, i-start);
        //         }
        //     }
        //     return res;
        // }
        // public int longestSubstring(String s, int k) { // str.split("[dkfldjf]")
        //     int n = s.length();
        //     if (n < k) return 0;
        //     if (n == k && s.chars().distinct().count() == 1) return k;
        //     int [] cnt = new int [26];
        //     for (int i = 0; i < n; i++) 
        //         cnt[s.charAt(i)-'a']++;
        //     if (Arrays.stream(cnt).max().getAsInt() < k) return 0;
        //     StringBuilder sb = new StringBuilder("[");
        //     for (int i = 0; i < 26; i++) 
        //         if (cnt[i] < k && cnt[i] != 0)
        //             sb.append((char)(i+'a'));
        //     sb.append(']');
        //     if (sb.length() == 2) return n;
        //     String [] sa = s.split(sb.toString()); // str.split("[-+*/=]") pay attention to the format
        //     System.out.println(Arrays.toString(sa));
        //     int max = 0;
        //     for (int i = 0; i < sa.length; i++) 
        //         max = Math.max(max, longestSubstring(sa[i], k));
        //     return max;
        // }
        // public int longestSubstring(String s, int k) { // 人工手动折分
        //     int n = s.length(), maxIdx = 0, res = 0;
        //     int [] cnt = new int [128];
        //     boolean valid = true;
        //     for (char c : s.toCharArray()) 
        //         cnt[c]++;
        //     for (int i = 0; i < n; i++) 
        //         if (cnt[s.charAt(i)] < k) {
        //             res = Math.max(res, longestSubstring(s.substring(maxIdx, i), k));
        //             valid = false;
        //             maxIdx = i+1;
        //         }
        //     return valid ? n : Math.max(res, longestSubstring(s.substring(maxIdx, n), k));
        // }


// bugy bugy bugy
        // private boolean isValid(Map<Character, Integer> m, Map<Character, Integer> n) { // bugy bugy bugy
        //     if (m.size() != n.size()) return false;
        //     for (Map.Entry<Character, Integer> en : m.entrySet()) 
        //         if (!n.containsKey(en.getKey()) || n.get(en.getKey()) != en.getValue())
        //             return false;
        //     return true;
        // }
        // public int balancedString(String s) {
        //     int n = s.length(), j = 0, min = n;
        //     Map<Character, Integer> cnt = new HashMap<>();
        //     for (int i = 0; i < n; i++) 
        //         cnt.put(s.charAt(i), cnt.getOrDefault(s.charAt(i), 0) + 1);
        //     if (Collections.max(cnt.values()) == n / 4) return 0;
        //     Iterator<Map.Entry<Character, Integer>> it = cnt.entrySet().iterator();
        //     while (it.hasNext()) {
        //         Map.Entry<Character, Integer> cur = it.next();
        //         if (cur.getValue() > n/4)
        //             cur.setValue(cur.getValue() - n/4);
        //         else it.remove();
        //     }
        //     boolean valid = true;
        //     Map<Character, Integer> m = new HashMap<>();
        //     for (int i = 0; i < n; i++) { 
        //         m.put(s.charAt(i), m.getOrDefault(s.charAt(i), 0) + 1);
        //         valid = true;
        //         for (Map.Entry<Character, Integer> en : cnt.entrySet()) 
        //             if (!m.containsKey(en.getKey()) || m.get(en.getKey()) < en.getValue()) {
        //                 valid = false;
        //                 break;
        //             }
        //         if (!valid) continue;
        //         valid = isValid(m, cnt);
        //         if (valid)
        //             min = Math.min(min, i-j+1); // into one
        //         while (j <= i && valid) {
        //             min = Math.min(min, i-j+1);
        //             m.put(s.charAt(j), m.get(s.charAt(j))-1);
        //             if (m.get(s.charAt(j)) == 0) m.remove(s.charAt(j));
        //             valid = isValid(m, cnt);
        //             ++j;
        //         }
        //     }
        //     return min;
        // }
        // public int balancedString(String s) {
        //     int [] cnt = new int [128];
        //     for (char c : s.toCharArray()) cnt[c]++;
        //     int n = s.length(), ans = n, l = 0, target = n/4;
        //     for (int r = 0; r < n; r++) {
        //         cnt[s.charAt(r)]--;
        //         while (l < n && cnt['Q'] <= target && cnt['W'] <= target && cnt['E'] <= target && cnt['R'] <= target) {
        //             ans = Math.min(ans, r-l+1);
        //             ++cnt[s.charAt(l++)];
        //         }
        //     }
        //     return ans;
        // }


        // public int numSubarrayProductLessThanK(int[] arr, int k) {
        //     if (k == 0) return 0;
        //     int n = arr.length, ans = 0, j = 0, cur = 1;
        //     for (int i = 0; i < n; i++) {
        //         cur *= arr[i];
        //         while (j <= i && cur >= k) 
        //             cur /= arr[j++];
        //         ans += (i - j + 1);
        //     }
        //     return ans;
        // }


        // public int maxFrequency(int[] nums, int k) {
        //     int n = nums.length, ans = 1, cnt = 0;
        //     Arrays.sort(nums);
        //     for (int l = 0, r = 1; r < n; r++) {
        //         cnt += (nums[r] - nums[r-1]) * (r - l);// 右指针移动后所需操作次数
        //         while (cnt > k)                        // 操作次数超过k，移动左指针
        //             cnt -= nums[r] - nums[l++];
        //         ans = Math.max(ans, r-l+1);            // 区间长度为操作后当前元素的频数
        //     }
        //     return ans;
        // }


        // public static int base = 26; // 256
        // public static int mod = (1 << 31) - 1;
        // public static boolean match(String str1,String str2) {
        //     assert str1.length() == str2.length();
        //     for (int i = 0; i < str1.length(); i++) 
        //         if (str1.charAt(i) != str2.charAt(i))
        //             return false; 
        //     return true; 
        // }
        // private String search(String s, int v) { // v: substring length
        //     int n = s.length();
        //     long hash = 0L, mp = 1l;             // to avoid overflow, long long long
        //     Map<Long, List<Integer>> map = new HashMap<>();
        //     for (int j = 0; j < v; j++) {
        //         hash = ((hash*base) + s.charAt(j)) % mod;
        //         if (j >= 1)
        //             mp = mp * base % mod;        // 先乘好准备好，准备着备用 
        //     }
        //     map.computeIfAbsent(hash, k->new ArrayList<>()).add(0);
        //     for (int i = 1; i+v <= n; i++) {
        //         hash = ((hash - s.charAt(i-1) * mp % mod + mod) % mod * base % mod + s.charAt(i+v-1)) % mod; // mod 
        //         if (map.containsKey(hash)) 
        //             for (int idx : map.get(hash)) 
        //                 if (match(s.substring(i, i+v), s.substring(idx, idx+v)))
        //                     return s.substring(i, i+v);
        //         map.computeIfAbsent(hash, k->new ArrayList<>()).add(i);
        //     }
        //     return null;
        // }
        // public String longestDupSubstring(String s) {
        //     int n = s.length();
        //     int l = 0, r = n;
        //     String res = "";
        //     while (l <= r) {
        //         int m = l + (r-l) / 2;
        //         String tmp = search(s, m);
        //         if (tmp == null) r = m-1;
        //         else {
        //             if (tmp.length() > res.length())
        //                 res = tmp;
        //             l = m+1;
        //         }
        //     }
        //     return res;
        // }
        // public String longestDupSubstring(String s) {
        //     var low = 0;
        //     var high = s.length();
        //     var prime = (1 << 31) - 1;
        //     var letterSize = 26;
        //     var longestDupSub = "";
        //     while (low <= high) {
        //         var mid = low + (high - low) / 2;
        //         var dupSub = search(s, mid, prime, letterSize);
        //         if (dupSub == null) {
        //             high = mid - 1;
        //         } else {
        //             if (dupSub.length() > longestDupSub.length())
        //                 longestDupSub = dupSub;
        //             low = mid + 1;
        //         }
        //     }
        //     return longestDupSub;
        // }
        // private String search(String s, int windowSize, int Q, int L) { // L: base, Q: mod
        //     var winHash = 0L; // calculate hash of first window
        //     for (var i = 0; i < windowSize; i++)
        //         winHash = (L * winHash + s.charAt(i)) % Q;
        //     var map = new HashMap<Long, List<Integer>>();
        //     map.put(winHash, new ArrayList<>(Collections.singletonList(0)));
        //     var E = 1L; // L ^ pattern length mod Q
        //     for (var i = 1; i < windowSize; i++)
        //         E = L * E % Q;
        //     for (int i = 1; i <= s.length() - windowSize; i++) {
        //         // remove first char
        //         winHash = (winHash - E * s.charAt(i - 1) % Q + Q) % Q;
        //         // left shift
        //         winHash = winHash * L % Q;
        //         // add new last char
        //         winHash = (winHash + s.charAt(i + windowSize - 1)) % Q;
        //         // hash collision
        //         if (map.containsKey(winHash))
        //             for (var start : map.get(winHash))
        //                 if (isEqual(s, start, i, windowSize))
        //                     return s.substring(i, i + windowSize);
        //         map.computeIfAbsent(winHash, k -> new ArrayList<>()).add(i);
        //     }
        //     return null;
        // }
        // private boolean isEqual(String s, int previous, int current, int windowSize) {
        //     for (var j = 0; j < windowSize; j++)
        //         if (s.charAt(previous++) != s.charAt(current++))
        //             return false;
        //     return true;
        // }


        // public boolean containsNearbyAlmostDuplicate(int [] arr, int k, int t) {
        //     if (k == 0) return t >= 0;
        //     // ArrayDeque<Integer> q = new ArrayDeque<>(); // increasing
        //     Queue<Integer> minq = new PriorityQueue<>((a, b) -> arr[a]-arr[b]); // increasing
        //     Queue<Integer> maxq = new PriorityQueue<>((a, b) -> arr[b]-arr[a]); // decreasing
        //     int j = 0; // j: left
        //     for (int i = 0; i < arr.length; i++) {
        //         minq.offer(i);
        //         maxq.offer(i);
        //         if (i-j < k-1) continue;
        //         if ()
        //     }
        // }


        // public int totalFruit(int[] arr) {
        //     int n = arr.length;
        //     int ans = 0, cnt = 0, j = 0;
        //     Map<Integer, Integer> m = new HashMap<>();
        //     for (int i = 0; i < n; i++) {
        //         m.put(arr[i], m.getOrDefault(arr[i], 0) + 1);
        //         cnt++;
        //         if (m.size() <= 2) {
        //             ans = Math.max(ans, cnt);
        //             continue;
        //         }
        //         while (m.size() > 2) {
        //             m.put(arr[j], m.get(arr[j]) - 1);
        //             if (m.get(arr[j]) == 0) m.remove(arr[j]);
        //             cnt--;
        //             j++;
        //         }
        //         ans = Math.max(ans, cnt);
        //     }
        //     return ans;
        // }

        
        // public boolean containsNearbyAlmostDuplicate(int [] arr, int k, int t) {
        //     TreeSet<Long> ts = new TreeSet<>();
        //     for (int i = 0; i < arr.length; i++) {
        //         if (i >= k+1) ts.remove((long)arr[i-k-1]);
        //         Long lower = ts.ceiling((long)arr[i]-t); // E ceiling(E e) ，返回 treeSet 中大于等于 e 的元素中最小的元素，如果没有大于等于 e 的元素就返回 null
        //         if (lower != null && lower <= (long)arr[i] + t)
        //             return true;
        //         ts.add((long)arr[i]);
        //     }
        //     return false;
        // }
        // 维持一个长度为k的window, 每次检查新的值是否与原来窗口中的所有值的差值有小于等于t的. 如果用两个for循环会超时O(nk).
        //     使用treeset( backed by binary search tree) 的subSet函数,可以快速搜索. 复杂度为 O(n logk)
        // public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        //     if (k < 1 || t < 0 || nums == null || nums.length < 2) return false;
        //     SortedSet<Long> set = new TreeSet<Long>();
        //     for(int j = 0; j < nums.length; j++) {
        //         SortedSet<Long> subSet = set.subSet((long)nums[j] - t, (long)nums[j] + t + 1);
        //         if (!subSet.isEmpty()) return true;
        //         if (j >= k)  set.remove((long)nums[j - k]);
        //         set.add((long)nums[j]);
        //     }
        //     return false;
        // }


        public int minMoves(int[] arr, int k) {
            if (k == 1) return 0;
            int n = arr.length;
            List<Integer> g = new ArrayList<>();
            List<Integer> sum = new ArrayList<>();
            sum.add(0);
            int cnt = -1, last = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] == 0) continue;
                ++cnt;
                g.add(i-cnt);
                sum.add(last + i - cnt);
                last += i - cnt; 
            }
            int m = g.size();
            int ans = Integer.MAX_VALUE;
            for (int i = 0; i+k <= m; i++) {
                int mid = (i + i + k - 1) / 2; // 中位数下标
                int q = g.get(mid);            // 中位数
                ans = Math.min(ans, (2*(mid-i)-k+1) * q + sum.get(i+k) - sum.get(mid+1) - sum.get(mid) + sum.get(i));
            }
            return ans;
        }
    }    
    public static void main(String[] args) {
        Solution s  =  new Solution();

        int []  a = new int []  {1, 0, 0, 0, 0, 0, 1, 1};
        
        int r  =  s.minMoves(a, 3);
        System.out.println("r: "  +  r);
    }
}
