// import com.TreeNode;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;

import java.io.BufferedReader;
import java.io.*;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.util.stream.Collectors.toMap;

public class six {
    public static class solution {

        public long getSum(int t, int k, int d) {
            if (t == 0) {
                for (int i = m-k; i < m; i++)
                    for (int j = 0; j < n; j++) 
                        a[i][j] += d * (k - (m-i)+1);
            } else {
                for (int j = n-k; j < n; j++)
                    for (int i = 0; i < m; i++) 
                        a[i][j] += d * (k - (n-i) + 1);
            }
            vis = new boolean [m][n];
            ans = Long.MAX_VALUE;
            dfs(0, 0, 0);
            return ans;
        }
        int [][] dirs = {{1, 0}, {0, 1}};
        long ans = Long.MAX_VALUE;
        public long [][] a;
        public boolean [][] vis;
        public int m, n;
        private void dfs(int i, int j, long sum) {
            if (i < 0 || i >= m || j < 0 || j >= n || vis[i][j]) return ;
            if (i == m-1 && j == n-1) {
                ans = Math.min(ans, sum + a[i][j]);
                return ;
            }
            vis[i][j] = true;
            for (int [] d : dirs)
                dfs(i+d[0], j+d[1], sum + a[i][j]);
            vis[i][j] = false;
        }
    }
    public static void main(String[] args)  throws IOException {
        solution s = new solution();

        // Path path = Paths.get("six-sur.txt");
        // Scanner in = new Scanner(path);
        Scanner in = new Scanner(System.in);
        
        // int n = Integer.parseInt(in.nextLine());
        // System.out.println("n: " + n);

        String sa = in.nextLine(), sb = in.nextLine(), sc = in.nextLine();
        String [] ssa = sa.split("\\s+"), ssb = sb.split("\\s+"), ssc = sc.split("\\s+");
        s.m = Integer.parseInt(ssa[0]);
        s.n = Integer.parseInt(ssa[1]);
        int q = Integer.parseInt(ssa[2]);
        long [] a = new long [ssb.length];
        for (int i = 0; i < a.length; i++) 
            a[i] = Long.parseLong(ssb[i]);
        long [] b = new long [ssc.length];
        for (int i = 0; i < b.length; i++) 
            b[i] = Long.parseLong(ssc[i]);
        s.a = new long [s.m][s.n];
        for (int i = 0; i < s.m; i++) 
            for (int j = 0; j < s.n; j++) 
                s.a[i][j] = a[i] + b[j];
        for (int i = 0; i < q; i++) {
            String tmp = in.nextLine();
            String [] st = tmp.split("\\s+");
            int t = Integer.parseInt(st[0])-1, k = Integer.parseInt(st[1]), d = Integer.parseInt(st[2]);
            long sum = s.getSum(t, k, d);
            System.out.println(sum);
        }        
        in.close();
    }
}
