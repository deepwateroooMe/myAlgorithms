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

public class three {
    public static class solution {

        private boolean isValid(String t) {
            int n = t.length();
            if (n < 2) return false;
            char [] s = t.toCharArray();
            int a = 0, b = 0, c = 0;
            for (int i = 0; i < n; i++) {
                if (s[i] == 'a') a++;
                else if (s[i]== 'b') b++;
                else c++;
            }
            return a > b && a > c;
        }
        private int getSmallest(int n, String t) {
            if (t.indexOf("a") == -1) return -1;
            char [] s = t.toCharArray();
            String res = "";
            int ans = 0;
            for (int i = 0; i < n; i++) {
                if (s[i] != 'a') continue;
                int d = 2;
                for (d = 2; d <= n; d++)
                    for (int j = i; j+d <= n; j++) {
                        int k = j + d;
                        String cur = t.substring(i, j);
                        if (isValid(cur) && (res.length() == 0 || res.length() > cur.length())) {
                            res = cur;
                            break;
                        }
                    }
                int c = 2;
                for ( c = 2; c <= i+1; c++) {
                    for (int j = i; j-c+1 >= 0; j--) {
                        int k = j-c+1;
                        String cur = t.substring(k, j+1);
                        if (isValid(cur) && (res.length() == 0 || res.length() > cur.length())) {
                            res = cur;
                            break;
                        }
                    }
                }
                // System.out.println("t: " + t);
                // System.out.println("t.length(): " + t.length());
                for (int x = i; x >= Math.max(0, i-c+1); x--) {
                    for (int y = i+1; y <= Math.min(n, i+d); y++) {
                        // System.out.println("x: " + x);
                        // System.out.println("y: " + y);
                        String cur = t.substring(x, y);
                        if (isValid(cur) && (res.length() == 0 || res.length() > cur.length())) 
                            res = cur;
                    }
                if (res.length() == 2) return 2;
            }
            return res.length() > 0 ? res.length() : -1;
        }
    }
        public static void main(String[] args)  throws IOException {
            solution s = new solution();

        // Path path = Paths.get("three-sur.txt");
        // Scanner in = new Scanner(path);
        Scanner in = new Scanner(System.in);
        
        int n = Integer.parseInt(in.nextLine());
        // System.out.println("n: " + n);

        int [] cnt = new int [n];
        String [] sur = new String [n];
        for (int i = 0; i < n; i++) {
            cnt[i] = Integer.parseInt(in.nextLine());
            sur[i] =  in.nextLine();
        }
        in.close();
        // System.out.println(Arrays.toString(cnt));
        // System.out.println(Arrays.toString(sur));

        for (int i = 0; i < n; i++) {
            int N = cnt[i];
            String cur = sur[i];
            
            int v = s.getSmallest(N, cur);
            System.out.println(v);
        }
    }
}
