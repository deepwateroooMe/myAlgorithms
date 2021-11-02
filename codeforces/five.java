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

public class five {
    public static class solution {

        public int [] getPos(int m, int n, String t) { // 不知道这个题要怎么想
            if (t.length() == 1) return new int [] {1, 1} ;
            Map<Character, int []> map = new HashMap<>();
            map.put('L', new int [] {0, -1});
            map.put('R', new int [] {0, 1});
            map.put('D', new int [] {1, 0});
            map.put('U', new int [] {-1, 0});
            char [] s = t.toCharArray();
            int [] ans = new int [2];
            Queue<int []> q = new LinkedList<>();
            for (int i = 0; i < m; i++) 
                for (int j = 0; j < n; j++) 
                    q.offer(new int [] {i, j, 0, i+1, j+1}); // i, j, idx, oi, oj
            int cnt = 0, max = 0;
            // boolean first = true;
            while (!q.isEmpty()) {
                // int size = q.size()-1;
                // while (size-- >= 0) {
                for (int size = q.size()-1; size >= 0; size--) {
                    int [] cur = q.poll(); 
                    // if (first) {
                    //     ans[0] = cur[3];
                    //     ans[1] = cur[4];
                    //     first = false;
                    // }
                    if (cur[2] == t.length()) return new int [] {cur[3], cur[4]};
                    int i = cur[0] + map.get(s[cur[2]])[0], j = cur[1] + map.get(s[cur[2]])[1];
                    if (i < 0 || i >= m || j < 0 || j >= n) {
                        // max = Math.max(max, cnt);
                        continue;
                    }
                    ans[0] = cur[3]; // 为什么这个答案记得不对，记每次queue里的第一个？
                    ans[1] = cur[4];
                    // System.out.println("i: " + i);
                    // System.out.println("j: " + j);
                    q.offer(new int [] {i, j, cur[2] + 1, cur[3], cur[4]});
                }
                cnt++;
                // first = true;
            }
            return ans;
        }
    }
    public static void main(String[] args)  throws IOException {
        solution s = new solution();

        Path path = Paths.get("five-sur.txt");
        Scanner in = new Scanner(path);
        // Scanner in = new Scanner(System.in);
        
        int n = Integer.parseInt(in.nextLine());
        // System.out.println("n: " + n);

        String [] st = new String [n];
        String [] sur = new String [n];
        for (int i = 0; i < n; i++) {
            st[i] =  in.nextLine();
            sur[i] =  in.nextLine();
        }
        in.close();
        // System.out.println(Arrays.toString(sur));

        for (int i = 0; i < n; i++) {
            String [] tp = st[i].split("\\s+");
            int m = Integer.parseInt(tp[0]), nn = Integer.parseInt(tp[1]);
        
            int [] v = s.getPos(m, nn, sur[i]);
            System.out.println(Arrays.toString(v));
        }
    }
}
