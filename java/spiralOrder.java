import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class spiralOrder {
    public static class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> res = new ArrayList<Integer>();
            if (matrix == null || matrix.length == 0) return res;
            
            int size = matrix.length * matrix[0].length;
            int ibgn = 0, iend = matrix.length - 1;
            int jbgn = 0, jend = matrix[0].length - 1;
            boolean toup = false, toleft = false;

            while (res.size() < size && ibgn < matrix.length && jbgn < matrix[0].length) {
                for (int j = jbgn; j <= jend; j++) {
                    if (res.size() == size) break;
                    res.add(matrix[ibgn][j]);
                }
                ++ibgn;
                toleft = true;
                
                for (int j = ibgn; j <= iend; j++) {
                    if (res.size() == matrix.length * matrix[0].length) break;
                    res.add(matrix[j][jend]);
                }
                --jend;
                toup = true;

                if (toleft && res.size() < matrix.length * matrix[0].length) {
                    for (int j = jend; j >= jbgn ; j --) {
                        if (res.size() == matrix.length * matrix[0].length) break;
                        res.add(matrix[iend][j]);
                    }
                    --iend;
                    toleft = false;
                }

                if (toup && res.size() < matrix.length * matrix[0].length) {
                    for (int i = iend; i >= ibgn ; i --) {
                        if (res.size() == matrix.length * matrix[0].length) break;
                        res.add(matrix[i][jbgn]);
                    }
                    ++jbgn;
                    toup = false;
                }
            }
            return res;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [][] a = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        List<Integer> res = result.spiralOrder(a);

        System.out.println(res);
    }
}
