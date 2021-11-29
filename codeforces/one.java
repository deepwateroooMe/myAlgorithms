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

public class one {
    public static class solution {

        public long getSum(int [] a) {
            int n = a.length, cnt = 0, cb = 0;
            long sum = 0, sumb = 0;
            if (n == 1) return a[0];
            Arrays.sort(a);

            int oddIdx = -1, j = n-1, oddVal = 0;
            while (j >= 0 && a[j] % 2 == 0) j--;
            // if (j < 0) return sum;
            if (j >= 0) {
                oddIdx = j;
                oddVal = a[j];
            }
            for (int i = 0; i < n-1; i++) {
                while (i < n-1 && a[i] % 2 == 0 && a[i] / 2 >= 1) {
                    a[i] /= 2;
                    cnt++;
                    if (i != oddIdx)
                        cb++;
                }
                if (a[i] % 2 == 1 && i < n-1) sum += a[i];
                if (i != oddIdx) sumb += a[i];
            }
            if (oddIdx >= 0) {
                while (a[n-1] % 2 == 0 && a[n-1] / 2 >= 1) {
                    a[n-1] /= 2;
                    cb++;
                }
            }
            if (oddIdx >= 0) sumb += a[n-1];
            long tmp = a[n-1];
            for (int i = 0; i < cnt; i++) 
                tmp *= 2;
            sum += tmp;
            if (j < 0) return sum;
            for (int i = 0; i < cb; i++) 
                oddVal *= 2;
            sumb += oddVal;
            return Math.max(sum, sumb);
        }
    }
    public static void main(String[] args)  throws IOException {
        solution s = new solution();

        // Path path = Paths.get("one-sur.txt");
        // Scanner in = new Scanner(path);
        Scanner in = new Scanner(System.in);
        
        int N = Integer.parseInt(in.nextLine());
        // System.out.println("N: " + N);
        for (int i = 0; i <  N; i++) {
            int n = Integer.parseInt(in.nextLine());
            int [] a = new int [n];
            String tmp = in.nextLine();
            String [] cur = tmp.split("\\s+");
            for (int j = 0; j < n; j++) 
                a[j] = Integer.parseInt(cur[j]);
            // System.out.println(Arrays.toString(a));
           long ans = s.getSum(a);
            System.out.println(ans);
        }
    }
}
