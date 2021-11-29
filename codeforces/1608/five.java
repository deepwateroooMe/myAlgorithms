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

         public int getMin(int [] a, int [] b) {
             // System.out.println(Arrays.toString(a));
             // System.out.println(Arrays.toString(b));
            int n = a.length, dif = 0, ans = 0;
            for (int i = 0; i < n; i++) {
                // System.out.println("\n i: " + i);
                if (a[i] != b[i]) {
                    ans += Math.abs(a[i]-b[i]);
                    dif = - (a[i] - b[i]);
                    for (int j = i; j < n; j++) {
                        if ((j+1) % (i+1) != 0) continue;
                        // System.out.println("j: " + j);
                        a[j] += dif;
                        // System.out.println("a[j]: " + a[j]);
                    }
                }
                // System.out.println(Arrays.toString(a));
                // System.out.println(Arrays.toString(b));
                // System.out.println("ans: " + ans);
            }
            return ans;
        }
    }
    public static void main(String[] args)  throws IOException {
        solution s = new solution();

        // Path path = Paths.get("five-sur.txt");
        // Scanner in = new Scanner(path);
        Scanner in = new Scanner(System.in);
        
        int N = Integer.parseInt(in.nextLine());

        String tmp = in.nextLine();
        String [] aa = tmp.split("\\s+");
        int [] a = new int [N];
        for (int j = 0; j < aa.length; j++) 
            a[j] = Integer.parseInt(aa[j]);
        tmp = in.nextLine();
        String [] bb = tmp.split(" ");
        int [] b = new int [bb.length];
        for (int j = 0; j < bb.length; j++) 
            b[j] = Integer.parseInt(bb[j]);
        // System.out.println(Arrays.toString(a));
        // System.out.println(Arrays.toString(b));

        int n = Integer.parseInt(in.nextLine());
        // System.out.println("n: " + n);
        for (int j = 0; j < n; j++) {
            b[0] = Integer.parseInt(in.nextLine());
            int [] tmpArr = Arrays.copyOf(a, a.length);
            int v = s.getMin(tmpArr, b);
            System.out.println(v);
            b[0] = -1;
        }            
        in.close();
    }
}
