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

        public int getCnt(int n, long [] a) { // minSeg, maxSeg
            int [] cnt = new int [n];
            for (int i = 0; i < n; i++) 
                cnt[i] = Long.bitCount(a[i]);
            System.out.println(Arrays.toString(cnt));
            
        }
    }
    public static void main(String[] args)  throws IOException {
        solution s = new solution();

        Path path = Paths.get("five-sur.txt");
        Scanner in = new Scanner(path);
        // Scanner in = new Scanner(System.in);
        
        // int N = Integer.parseInt(in.nextLine());
        int n = Integer.parseInt(in.nextLine());
        // System.out.println("n: " + n);
        String tmp = in.nextLine();
        in.close();
        String [] sa = tmp.split("\\s+");
        long [] a = new long [sa.length];
        for (int i = 0; i < n; i++) 
            a[i] = Long.parseLong(sa[i]);
        System.out.println(Arrays.toString(a));
        int v = getCnt(n, a);
        System.out.println(v);
    }
}
