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

public class mat {
    public static class solution {
        public boolean poss;
        public String possible(int [][] arr) {
            int n = arr.length, m = arr[0].length;
            

        }
    }
    public static void main(String[] args)  throws IOException {
        solution s = new solution();
        Scanner sc = new Scanner(System.in);

        int tests = sc.nextInt();
		sc.nextLine();

        while (tests > 0) {
            String cur = sc.nextLine();
            String [] ca = cur.split("\\s+");
            int n = Integer.parseInt(ca[0]), m = Integer.parseInt(ca[1]);
            // System.out.println("n: " + n);
            // System.out.println("m: " + m);
            String [] mat = new String [n];
            int [][] arr = new int [n][m];
            for (int i = 0; i < n; i++) {
                mat[i] = sc.nextLine();
                String [] tmp = mat[i].split("\\s+");
                for (int j = 0; j < m; j++) 
                    arr[i][j] = Integer.parseInt(tmp[j]);
            }
            System.out.println("arr.length: " + arr.length);
            for (int z = 0; z < arr.length; ++z) 
                System.out.println(Arrays.toString(arr[z]));

            tests--;
        }
    }
}