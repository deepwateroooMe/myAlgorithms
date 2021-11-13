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

public class four {
    public static class solution {

        public boolean isPoss(int n, int [] arr, String t) {
            Map<Integer, Set<Integer>> m = new HashMap<>();
            Map<Integer, List<Integer>> cnt = new HashMap<>();
            char [] s = t.toCharArray();
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                min = Math.min(min, arr[i]);
                max = Math.max(max, arr[i]);
                m.computeIfAbsent(arr[i], z -> new HashSet<>()).add(s[i] == 'B' ? -1 : 1);
                cnt.computeIfAbsent(arr[i], z -> new ArrayList<>()).add(i);
            }
            if (max > n && !m.get(max).contains(-1) || min < 1 && !m.get(min).contains(1))
                return false;
            if (max < n && t.indexOf("R") == -1 || min > 1 && t.indexOf("B") == -1)
                return false;
            if (max == n && cnt.get(max).size() > 1) {
                List<Integer> l = cnt.get(max);
                int red = 0;
                for (int i = 0; i < l.size(); i++) 
                    if (s[l.get(i)] == 'R') red++;
                if (red > 1) return false;  
            } 
            if (min == 1 && cnt.get(min).size() >= 2) {
                int blue = 0;
                List<Integer> l = cnt.get(min);
                for (int i = 0; i < l.size(); i++) 
                    if (s[l.get(i)] == 'B') blue++;
                if (blue > 1) return false;
            }
            return true;
        }
    }
    public static void main(String[] args)  throws IOException {
        solution s = new solution();

        Path path = Paths.get("four-sur.txt");
        Scanner in = new Scanner(path);
        // Scanner in = new Scanner(System.in);
        
        int N = Integer.parseInt(in.nextLine());
        System.out.println("n: " + n);

        int [] cnt = new int [n];
        String [] sur = new String [n];
        String [] st = new String [n];
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(in.nextLine);
            if (n == 1) {
                System.out.println(1);
                continue;
            }
            for (int j = 0; j < n-1; j++) {
                
            }
            cnt[i] = Integer.parseInt(in.nextLine());
            sur[i] =  in.nextLine();
            st[i] =  in.nextLine();
        }
        in.close();
        // System.out.println(Arrays.toString(cnt));
        // System.out.println(Arrays.toString(sur));

        for (int i = 0; i < n; i++) {
            String [] tmp = sur[i].split("\\s+");
            int [] a = new int [cnt[i]];
            for (int j = 0; j < cnt[i]; j++) 
                a[j] = Integer.parseInt(tmp[j]);
                
            boolean v = s.isPoss(cnt[i], a, st[i]);
            if (v) System.out.println("YES");
            else  System.out.println("NO");
        }
    }
}
