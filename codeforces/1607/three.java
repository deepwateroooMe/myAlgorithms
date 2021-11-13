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

        private int getMaxiPossiOfMinValRe(int [] arr, int n, int i, int j) {
            int ans = arr[i];
            while (i < j) {
                ans = Math.max(ans, arr[i]);
                for (int k = i+1; k <= j; k++) 
                    arr[k] -= arr[i];
                i++;
            }
            ans = Math.max(ans, arr[i]);
            return ans;
        }
        public int getMaxiPossiOfMinVal(int n, int [] arr) {
            Arrays.sort(arr);
            return getMaxiPossiOfMinValRe(arr, n, 0, n-1);
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
            String [] tmp = sur[i].split("\\s+");
            int [] a = new int [tmp.length];
            for (int j = 0; j < tmp.length; j++) 
                a[j] = Integer.parseInt(tmp[j]);
                
            int v = s.getMaxiPossiOfMinVal(cnt[i], a);
            System.out.println(v);
        }
    }
}
