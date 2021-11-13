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

        public int getCost(int [] a) {
            int minDif = Math.abs(a[0] + a[2] - 2 * a[1]), cnt = 0;
            while (cnt < 1000) {
                
            }
        }
    }
    public static void main(String[] args)  throws IOException {
        solution s = new solution();

        Path path = Paths.get("onesur.txt");
        Scanner in = new Scanner(path);
        // Scanner in = new Scanner(System.in);
        
        int [] cur = new int [3];
        int N = Integer.parseInt(in.nextLine());
        // System.out.println("N: " + N);
        for (int i = 0; i <  N; i++) {
            cur = in.nextLine();
            if (cur[0] + cur[2] == 2 * cur[1])
                System.out.println(0);
            else {
                int v = getCost(cur);
                System.out.println(v);
            }
        }
    }
}
