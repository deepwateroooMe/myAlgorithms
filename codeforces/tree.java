// import com.TreeNode;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toMap;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class tree {
    public static class solution {
        public boolean poss;
        public String possible(int [][] arr) {
            int n = arr.length, m = arr[0].length;
            
            return "";
        }
    }
    public static void main(String[] args)  throws IOException {
        solution s = new solution();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), size = n, idx = 0;
		sc.nextLine();
        int [][] e = new int [n-1][2];
        while (size-- > 1) {
            String cur = sc.nextLine();
            String [] ca = cur.split("\\s+");
            for (int i = 0; i < 2; i++) 
                e[idx][i] = Integer.parseInt(ca[i]);
            idx++;
        }            
        System.out.println("e.length: " + e.length);
        for (int z = 0; z < e.length; ++z) 
            System.out.println(Arrays.toString(e[z]));
        int m = Integer.parseInt(sc.nextLine());
        size = m; idx = 0;
        int [][] q = new int [m][2];
        while (size -- > 0) {
            String cur = sc.nextLine();
            String [] ca = cur.split("\\s+");
            for (int i = 0; i < 2; i++) 
                q[idx][i] = Integer.parseInt(ca[i]);
            idx++;
        }
        System.out.println("q.length: " + q.length);
        for (int z = 0; z < q.length; ++z) 
            System.out.println(Arrays.toString(q[z]));
    }
}