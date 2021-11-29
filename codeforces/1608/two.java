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

public class two {
    public static class solution {

        public long getPos(long x, long n) {
            long cnt = 0, pos = x;
            while (cnt < n) {
                if (pos % 2 == 0) pos -= cnt + 1;
                else pos += cnt + 1;
                ++cnt;
                if (pos == x && n > Integer.MAX_VALUE) {

                    System.out.println("\n x: " + x);
                    System.out.println("n: " + n);
                    System.out.println("cnt: " + cnt);
                   long preCnt = cnt;
                    // cnt += cnt * ((n - cnt) / cnt);
                    n = (n - preCnt) % preCnt;
                    cnt = 0;
                }
            }
            return pos;
        }
    }
    public static void main(String[] args)  throws IOException {
        solution s = new solution();

        Path path = Paths.get("twosur.txt");
        Scanner in = new Scanner(path);
        // Scanner in = new Scanner(System.in);
        
        int tests = Integer.parseInt(in.nextLine());
        // System.out.println("tests: " + tests);
        long [][] sur = new long [tests][2];
        for (int i = 0; i < tests; i++) {
            sur[i][0] = in.nextLong();
            sur[i][1] = in.nextLong();
        }
        in.close();

        // System.out.println("sur.length: " + sur.length);
        // for (int z = 0; z < sur.length; ++z) 
        //     System.out.println(Arrays.toString(sur[z]));
        
        for (int i = 0; i < tests; i++) {
            long v = s.getPos(sur[i][0], sur[i][1]);
            System.out.println(v);
        }
    }
}
