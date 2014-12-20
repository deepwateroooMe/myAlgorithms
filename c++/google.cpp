/*
【Senior】刘月明-Math(8607831) 11:09:22 PM 
G家面试题
设计一个Matrix数据结构，要求支持两种操作
(1) write(i,j) 将一个数写matrix的(i,j)点
(2) sum(x1,y1,x2,y2) 返回矩阵中以(x1,y1)为左上点，(x2,y2)为右下点的子矩阵中所有元素的和。
要求针对三种情况进行设计：
(1) write很多，sum很少
(2) write很少，sum很多
(3) write和sum都很多

13-dgs-308  2月10日 2:54
没仔细看lym的解法，我的猜想是，对第一种情况直接矩阵记录i,j即可，求sum时候生算

对第二种情况每个矩阵元素i,j记录的是以此元素为右下角（顶点永远为0,0）的子矩阵的和，这样sum很容易通过三次减法运算得出，但赋值要更新所有包含i,j元素的和，运算复杂度O(n^2)

第三种情况我的想法是建立2D BST，不知道有没这样的结构，姑且叫quadruple search tree吧，就是把二维矩阵分成四等分，每个节点记录四个子节点，并记录四个子节点的和，某些子节点可以为空，来处理大小不是2^n的情况，这样所有的leaf node记录的都是对应的矩阵元素值，non-leaf node记录的是矩阵元素的和，想要求值赋值直接做quadruple search，O(lg n) 赋值更新所有路径上的节点值，复杂度也是O(lg n)；求和的话类似于求BST的floor / ceiling，复杂度O(4lgn)

大家的想法是什么样的？我觉得第三种实现可能有些复杂啊
*/

public class MatrixSum {
    private static HashMap<Integer, HashMap<Integer, Double>> mat1 = 
            new HashMap<Integer, HashMap<Integer, Double>>();
    
    //Problem 1: Use HashMap<Integer, HashMap<Integer, Double>> to store the matrix
    //Write=O(1), Sum=O(M*N)
    //We can also just use HashMap<Integer, Double> for the matrix, the Integer key will be i*Columns+j
    public static void write1(int i, int j, double v) {
        HashMap<Integer, Double> row = mat1.get(i);
        if(row == null) {
            row = new HashMap<Integer, Double>();
            mat1.put(i, row);
        }
        row.put(j, v);
    }
    public static double sum1(int i, int j, int k, int l) {
        int ii = i<k?i:k;
        int jj = j<l?j:l;
        int rows = i-k>0?i-k:k-1;
        int cols = j-l>0?j-l:l-j;
        double sum = 0.0;
        for(int m = ii; m <= ii+rows; m++) {
            HashMap<Integer, Double> row = mat1.get(m);
            if(row == null) continue;
            for(int n = jj; n <= jj+cols; n++) {
                Double v = row.get(n);
                if(v != null) sum += v;
            }
        }
        return sum;
    }
    
    //Problem 2: Use two 2D array, one for the matrix, another on for the sum from m[0][0] to m[i][j]
    //Write=O(M*N), Sum=O(1)
    private static double[][] mat2 = null;
    private static double[][] matSum = null;
    public static void initMat(int numRows, int numCols) {
        mat2 = new double[numRows][numCols];
        matSum = new double[numRows][numCols];
    }
    public static void write2(int i, int j, double v) {
        for(int m=i; m<mat2.length; m++) {
            for(int n=j; n<mat2[0].length; n++) {
                matSum[m][n] += v - mat2[i][j]; // butfix += not =
            }
        }
        mat2[i][j] = v;
    }
    public static double sum2(int i, int j, int k, int l) {
        int minRow = i<k?i:k;
        int maxRow = i<k?k:i;
        int minCol = j<l?j:l;
        int maxCol = j<l?l:j;
        /**
         * bugfix, add three variables to indicate the areas
         * xxuuuu
         * lloooo
         * lloooo
         */
        double upper = 0.0; //e.g. xxuuuu
        //e.g. xx
        //     ll
        //     ll
        double left = 0.0; 
        double upperLeft = 0.0; //e.g. xx
        if(minRow > 0) upper = matSum[minRow-1][maxCol];
        if(minCol > 0) left = matSum[maxRow][minCol-1];
        if(minRow > 0 && minCol > 0) upperLeft = matSum[minRow-1][minCol-1];
        return matSum[maxRow][maxCol] - upper - left + upperLeft;
    }
    return sum;
}    

    //Problem 3: The same as Problem 2, but we use an additional HashMap up to size N to keep the changes 
    //(difference between the new value and old value) of the element in the matrix, once the size of the 
    //HashMap reaches to N, we perform an update operation to update the 2D arrays mat2 and matSum
    //Write=O(M), Sum=O(N)
    private static HashMap<Integer, Double> cache = new HashMap<Integer, Double>();
    //We need to call initMat(int numRows, int numCols) first
    public static void write3(int i, int j, double v) {
        int N = mat2[0].length;
        if(cache.size() < N) {
            Double old = cache.get(i*N+j);
            if(old == null) old = 0.0;
            cache.put(i*N+j, v - (mat2[i][j]+old) ); //Keep the difference
        } else {
            for(Entry<Integer, Double> e : cache.entrySet())
                mat2[e.getKey()/N][e.getKey()%N] += e.getValue(); //Note: we use "+="
            mat2[i][j] = v;
            cache.clear(); //Clear the cache for next N values
            //Recompute 2D array matSum: O(M*N), we only perform the update for every N different writes
            matSum[0][0] = mat2[0][0];
            for(int n=1; n<mat2[0].length; n++)
                matSum[0][n] = matSum[0][n-1] + mat2[0][n];
            for(int m=1; m<mat2.length; m++)
                matSum[m][0] = matSum[m-1][0] + mat2[m][0];
            for(int m=1; m<mat2.length; m++) {
                for(int n=1; n<mat2[0].length; n++) {
                    /双击查看原图gfix
                    matSum[m][n] = mat2[m][n] + matSum[m][n-1]+matSum[m-1][n]-matSum[m-1][n-1];
                }
            }
        }
    }
    public static double sum3(int i, int j, int k, int l) {
        int minRow = i<k?i:k;
        int maxRow = i<k?k:i;
        int minCol = j<l?j:l;
        int maxCol = j<l?l:j;
        double upper = 0.0;
        double left = 0.0; 
        double upperLeft = 0.0;
        if(minRow > 0) upper = matSum[minRow-1][maxCol];
        if(minCol > 0) left = matSum[maxRow][minCol-1];
        if(minRow > 0 && minCol > 0) upperLeft = matSum[minRow-1][minCol-1];
        double sum = matSum[maxRow][maxCol] - upper - left + upperLeft;
        //Check the cache to see if there is any update for the elements located in the given range
        int N = mat2[0].length;
        for(Entry<Integer, Double> e : cache.entrySet()) {
            int m = e.getKey()/N;
            int n = e.getKey()%N;
            if(minRow <= m && m <= maxRow && minCol <= n && n <= maxCol) { /双击查看原图gfix
                sum += e.getValue();
            }
        }
    }
}

