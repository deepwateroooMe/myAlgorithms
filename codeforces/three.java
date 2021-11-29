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

        public int getCnt(int n, int e, int [] a) {
            if (Arrays.stream(a).min().getAsInt() > 1) return 0;
            int ans = 0;
            for (int i = 0; i < n; i++) {
                // System.out.println("\n i: " + i);
                
                if (a[i] != 2 && a[i] != 1 && !isPrime(a[i])) continue;
                int v = a[i];   
                for (int j = 1; i+1+e*j <= n; j++) {
                    v *= a[i+e*j];
                    // System.out.println("v: " + v);
                    if (isPrime(v)) {
                        // System.out.println("j: " + j);
                        
                        ans++;
                        // System.out.println("ans: " + ans);
                    } else break;
                }
            }
            return ans;
        }
        private boolean isPrime(int v) {
            boolean ans = true;
            if (v <= 1) return false;
            for (int i = 2; i <= v / 2; i++) 
                if (v % i == 0) {
                    ans = false;
                    break;
                }
            return ans;
        }
    }
    public static void main(String[] args)  throws IOException {
        solution s = new solution();

        // Path path = Paths.get("three-sur.txt");
        // Scanner in = new Scanner(path);
        Scanner in = new Scanner(System.in);
        
        int N = Integer.parseInt(in.nextLine());
        // System.out.println("N: " + N);

        for (int i = 0; i < N; i++) {
            String one = in.nextLine(), two = in.nextLine();
            String [] sa = one.split("\\s+"), sb = two.split("\\s+");
            int n = Integer.parseInt(sa[0]), e = Integer.parseInt(sa[1]);
            int [] a = new int [sb.length];
            for (int j = 0; j < a.length; j++) 
                a[j] = Integer.parseInt(sb[j]);
            // System.out.println(Arrays.toString(a));
            int v = s.getCnt(n, e, a);
            System.out.println(v);
        }
        in.close();
    }
}
