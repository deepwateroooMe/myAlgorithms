#include <iostream>
#include <vector>
#include <stack>
#include <queue>
#include <cmath>
using namespace std;

/*
 * Solution (DP):
 * // we keeps a m*n matrix and scanning through string S,
 * while m = T.size() + 1 and n = S.size() + 1
 * and Path[i][j] means the number of distinct subsequences of T.substr(1...i) in S(1...j)
 * Path[i][j] = Path[i][j-1]     (discard s[j])
 *              + Path[i-1][j-1]   (s[j] == T[i] and we are going to use s[j])
 *                or 0             (s[j] != T[i] so we could not use S[j])
 * while Path[0][j] = 1 and Path[i][0] = 0             
 */
int numDistinct(string S, string T) {
    int m = T.size();
    int n = S.size();
    if (m > n || m == 0 || n == 0) return 0;

    vector<int> path(m+1, 0);
    path[0] = 1;
    for (int j = 1; j <= n; j++) {
        // traversing backwards so we are using path[i-1] from last time step
        for (int i = m; i >= 1 ; i--)  {
        //for (int i = 1; i <= m ; i++) {
            path[i] = path[i] + (T[i-1] == S[j-1] ? path[i-1] : 0);
            //cout << "path[" << i << "]: " << path[i] << endl << endl;
        }
    }
    return path[m];
    
    /*
      vector<vector<int> > path(m+1, vector<int>(n+1, 0));
      for (int i = 0; i < n; ++i)
      //path[0][i] = S[i] == T[0] ? 1 : 0;
      path[0][i] = 1;
    
      for (int j = 1; j <= n; ++j) {
      for (int i = 1; i <= m; ++i) {
      path[i][j] = path[i][j-1] + (T[i] == S[j] ? path[i-1][j-1] : 0);
      }
      }
      return path[m][n];
    */
}

int main(){
    string s = "b";
    string t = "c";
    cout << ": " << numDistinct(s, t) << endl;
    

    return 0;
}
