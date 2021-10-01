#include <iostream>
#include <vector>
#include <stack>
#include <queue>
#include <cmath>
using namespace std;
typedef vector<int> vi;
typedef vector<vector<int> > vvi;

int uniquePathsObstacles(vector<vector<int> > &obstacleGrid) {
    int m = obstacleGrid.size();
    int n = obstacleGrid[0].size();
    if ( (m == 0 || n == 0) || (obstacleGrid[0][0] == 1) ) return 0;
    if ( (m == 2 && n == 1) || (m == 1 && n == 2) ) {
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1)
            return 0;
        else
            return 1;
    } 

    int cnt = 0;
    // for row
    int cntj = 0;
    for(int j = 0; j < n; ++j) {
        for(int i = 0; i < m; ++i) {
            if (obstacleGrid[i][j] == 1)  
                ++cntj;
        }
        if (cntj == n) return 0;
        else cntj = 0;
    }

    // for crossingover
    /*
    // for col
    for(int i = 0; i < m; ++i) {
        for(int j = 0; j < n; ++j) {
            if (obstacleGrid[i][j] == 1)  
                ++cnt;
        }
        if (cnt == m) return 0;
        else cnt = 0;
    }

    for(int i = 0; i <= m+n-2; ++i)
    {
        for(int j = 0; j <=)
    }
    */          
    int mid[m][n];
    for(int i = 0; i < m; ++i)
        if (obstacleGrid[i][0] == 0)
            mid[i][0] = 1;
        else
            mid[i][0] = 0;
    for(int j = 1; j < n; ++j) 
        if (obstacleGrid[0][j] == 0)
            mid[0][j] = 1;
        else
            mid[0][j] = 0;
    for(int i = 1; i < m; ++i) {
        for(int j = 1; j < n; ++j) {
            if (obstacleGrid[i][j] == 1)  {
                mid[i][j] = 0;
                ++cnt;
            } else            
                mid[i][j] = mid[i-1][j] + mid[i][j-1];
        }
        if (cnt == n-1 && obstacleGrid[i][0] == 1) return 0;
        else cnt = 0;
    }
    
    return mid[m-1][n-1];
}

int main() {
    int m = 23;
    int n = 12;
    vvi tmp;
    vi one;
    one.push_back(0);
    one.push_back(0);
    tmp.push_back(one);
    for (int i = 0; i < 2; ++i)
        one.pop_back();
    one.push_back(1);
    one.push_back(1);
    tmp.push_back(one);
    for (int i = 0; i < 2; ++i)
        one.pop_back();
    one.push_back(0);
    one.push_back(0);
    tmp.push_back(one);
    for (int i = 0; i < 2; ++i)
        one.pop_back();
    
    cout << uniquePathsObstacles(tmp) << endl;
    
    return 0;
}


/*
Input:	[[0,1,0,0,0],[1,0,0,0,0],[0,0,0,0,0],[0,0,0,0,0]]
Output:	15
Expected:	0
 */

/*
  int uniquePaths(int m, int n) {
  if (m == 0 || n == 0) return 0;
  int mid[m][n];

  for(int i = 0; i < m; ++i) 
  mid[i][0] = 1;
  for(int j = 0; j < n; ++j) 
  mid[0][j] = 1;

  for(int i = 1; i < m; ++i) {
  for(int j = 1; j < n; ++j) {
  mid[i][j] = mid[i-1][j] + mid[i][j-1];
  }
  }
  return mid[m-1][n-1];
  }
*/
