import com.ListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;
import java.util.HashSet;
import java.util.Set;

import static java.util.stream.Collectors.toMap;

public class cmp {
    public static class Solution {

        public List<Integer> targetIndices(int[] a, int target) {
            Arrays.sort(a);
            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < a.length; i++) 
                if (a[i] == target)
                    ans.add(i);
            return ans;
        }

        public int[] getAverages(int[] a, int k) {
            int n = a.length;
            long [] sum = new long [n];
            for (int i = 0; i < n; i++) 
                sum[i] = (i == 0 ? 0 : sum[i-1]) + a[i];
            int [] ans = new int [n];
            Arrays.fill(ans, -1);
            for (int i = 0; i < n; i++) {
                if (i-k < 0 || i+k >= n) continue;
                ans[i] = (int)((sum[i+k] - (i-k == 0 ? 0 : sum[i-k-1])) / (2l * k + 1l));
            }
            return ans;
        }

        public int minimumDeletions(int[] a) {
            int n = a.length, minIdx = -1, maxIdx = -1;
            ArrayDeque<Integer> min = new ArrayDeque<>(); // 单调递增
            ArrayDeque<Integer> max = new ArrayDeque<>(); // 单调递减
            for (int i = 0; i < n; i++) {
                while (!max.isEmpty() && a[max.peekLast()] <= a[i]) max.pollLast();
                max.offerLast(i);
                while (!min.isEmpty() && a[min.peekLast()] >= a[i]) min.pollLast();
                min.offerLast(i);
            }
            minIdx = min.peekFirst();
            maxIdx = max.peekFirst();
            return Math.min(Math.min(Math.max(minIdx+1, maxIdx+1), Math.max(n-minIdx, n-maxIdx)),
                            Math.min(minIdx+1+n-maxIdx, maxIdx+1+n-minIdx));
        }

        private Set<Integer> dfs(int idx, int t) {
            Set<Integer> ans = new HashSet<>();
            return ans;
        }
        Set<Integer> ans = new HashSet<>();
        // List<int []> l = new ArrayList<>();
        Set<Integer> [] dp;
        int N = 100001;
        public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
            int m = meetings.length;
            // List<int []> l = new ArrayList<>();
            Map<Integer, Set<Integer>> adj = new HashMap<>();
            for (int [] v : meetings) {
                adj.computeIfAbsent(v[2], z -> new HashSet<>()).add(v[0]);
                adj.get(v[2]).add(v[1]);
            }
            Map<Integer, Set<Integer>> tmp = map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())  // Comparator.reverseOrder()
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));
            // for (int [] v : meetings) l.add(new int [] {Math.min(v[0], v[1]), Math.max(v[0], v[1]), v[2]});
            // Collections.sort(l, (a, b)-> a[2] != b[2] ? a[2] - b[2] : a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
            // dp = new Set<Integer> [N];
            // dp[0] = new HashSet<>(List.of(0, firstPerson));
            ans.addAll(List.of(0, firstPerson));
            // dfs(0, 0);
            // dfs(firstPerson, 0);
            // return ans;
            // int r = l.get(m-1)[2];
            // Set<Integer> [][] adj = new Set<Integer> [n][r+1];
            // for (int i = 0; i < n; i++) 
            //     for (int j = 0; j <= r; j++) 
            //         adj[i][j] = new HashSet<>();
            // for (int i = 0; i < m; i++) {
            //     int [] cur = l.get(i);
            //     adj[cur[0]][cur[2]].add(cur[1]);
            //     adj[cur[1]][cur[2]].add(cur[0]);
            // }
            // Set<Integer> [] dp = new Set<Integer> [r+1];
            // dp[0] = new HashSet<>(List.of(0, firstPerson));
            // for (int i = 0; i < m; i++) {
            //     int [] cur = l.get(i);
            //     for (int t = 0; t <= cur[2]; t++) {
            //     }
            //     for (int t = 1; t <= r; t++) {
            //         dp[i] = new HashSet<>();
            //         for (Integer v : dp[t-1]) {
            //         }
            //     }
            // }
            
            for (int i = 0; i < m; i++) {
                int [] cur = l.get(i);
                int j = i;
                while (j < m && l.get(j)[2] <= cur[2]) {
                    if (ans.contains(l.get(j)[0]) || ans.contains(l.get(j)[1])) {
                        ans.add(l.get(j)[0]);
                        ans.add(l.get(j)[1]);
                    }
                    j++;
                }
                for (int k = i; k < j; k++) {
                    cur = l.get(k);
                    if (ans.contains(l.get(k)[0]) || ans.contains(l.get(k)[1])) {
                        ans.add(l.get(k)[0]);
                        ans.add(l.get(k)[1]);
                    }
                }
                if (j > i)
                    i = j-1;
            }
            List<Integer> res = new ArrayList<>(ans);
            Collections.sort(res);
            return res;
            // return new ArrayList<>(ans);
        }
    }
    public static void main (String[] args) {
        Solution s = new Solution ();

        // int [][] a = new int [][] {{3,4,2},{1,2,1},{2,3,1}};
        int [][] a = new int [][] {{0,2,1},{1,3,1},{4,5,1}};

        List<Integer> r = s.findAllPeople(294, a, 27);

        // List<Integer> r = s.findAllPeople(294, a, 27);
        System.out.println("r.size(): " + r.size());
        System.out.println(Arrays.toString(r.toArray()));
        
    }
}
// cmp s = new cmp (a);

// TreeNode root = new TreeNode(a[0]);
// root.buildTree(root, a);
// root.levelPrintTree(root);
        
// TreeNode res = s.(root );
// res.levelPrintTree(res);

// [0,4,11,13,22,24,27,32,37,38,42,55,59,63,69,70,71,73,79,85,87,88,102,106,112,124,128,139,149,156,159,168,175,183,184,189,192,193,194,199,201,205,210,214,215,218,222,230,232,234,249,255,259,264,269,271,283,285,287,288]
// [0,4,11,13,22,24,27,32,37,38,42,55,59,63,69,70,71,73,79,85,87,88,102,106,112,124,128,139,149,156,159,168,175,183,184,189,190,192,193,194,199,201,205,210,211,214,215,218,222,225,230,232,234,244,249,250,255,259,261,264,269,271,283,285,287,288]