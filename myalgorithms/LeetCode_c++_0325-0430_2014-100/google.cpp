/*
��Senior��������-Math(8607831) 11:09:22 PM 
G��������
���һ��Matrix���ݽṹ��Ҫ��֧�����ֲ���
(1) write(i,j) ��һ����дmatrix��(i,j)��
(2) sum(x1,y1,x2,y2) ���ؾ�������(x1,y1)Ϊ���ϵ㣬(x2,y2)Ϊ���µ���Ӿ���������Ԫ�صĺ͡�
Ҫ������������������ƣ�
(1) write�ܶ࣬sum����
(2) write���٣�sum�ܶ�
(3) write��sum���ܶ�

13-dgs-308  2��10�� 2:54
û��ϸ��lym�Ľⷨ���ҵĲ����ǣ��Ե�һ�����ֱ�Ӿ����¼i,j���ɣ���sumʱ������

�Եڶ������ÿ������Ԫ��i,j��¼�����Դ�Ԫ��Ϊ���½ǣ�������ԶΪ0,0�����Ӿ���ĺͣ�����sum������ͨ�����μ�������ó�������ֵҪ�������а���i,jԪ�صĺͣ����㸴�Ӷ�O(n^2)

����������ҵ��뷨�ǽ���2D BST����֪����û�����Ľṹ�����ҽ�quadruple search tree�ɣ����ǰѶ�ά����ֳ��ĵȷ֣�ÿ���ڵ��¼�ĸ��ӽڵ㣬����¼�ĸ��ӽڵ�ĺͣ�ĳЩ�ӽڵ����Ϊ�գ��������С����2^n��������������е�leaf node��¼�Ķ��Ƕ�Ӧ�ľ���Ԫ��ֵ��non-leaf node��¼���Ǿ���Ԫ�صĺͣ���Ҫ��ֵ��ֱֵ����quadruple search��O(lg n) ��ֵ��������·���ϵĽڵ�ֵ�����Ӷ�Ҳ��O(lg n)����͵Ļ���������BST��floor / ceiling�����Ӷ�O(4lgn)

��ҵ��뷨��ʲô���ģ��Ҿ��õ�����ʵ�ֿ�����Щ���Ӱ�
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
                    /˫���鿴ԭͼgfix
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
            if(minRow <= m && m <= maxRow && minCol <= n && n <= maxCol) { /˫���鿴ԭͼgfix
                sum += e.getValue();
            }
        }
    }
}

