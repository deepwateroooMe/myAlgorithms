#include <iostream>
#include <vector>
#include <stack>
#include <queue>
#include <cmath>
#include <climits>
using namespace std;

typedef vector<int> vi;
typedef vector<vector<int> > vvi;

void printVI(vi tmp) {
    for(int i = 0; i < tmp.size(); ++i)
        cout << tmp[i] << ", ";
    cout << endl;
}

void printVVI(vvi tmp) {
    for(int i = 0; i < tmp.size(); ++i)
        printVI(tmp[i]);
    cout << endl;
}
/*
  void dfs(vector<vector<int> > &triangle, int row, int idx, int tmp, int &result) {
  int n = triangle.size();
  if (row == triangle.size()-1) {
  tmp += triangle[row][idx];
  if (tmp < result)
  result = tmp;
  tmp -= triangle[row][idx];
  return;
  }

  tmp += triangle[row][idx];
  dfs(triangle, row+1, idx, tmp, result);
  dfs(triangle, row+1, idx+1, tmp, result);
  }

  int minimumTotal(vector<vector<int> > &triangle) {
  int n = triangle.size();
  int index[n];
  int tmp = INT_MAX;
  int tmp0 = 0;
  dfs(triangle, 0, 0, tmp0, tmp);
  return tmp;
  }
*/

int minimumTotal(vector<vector<int> > &triangle) {
    int n = triangle.size();
    vector<int> minlen(triangle.back()); // store the last element value
    for (int layer = n - 2; layer >= 0; --layer) {  // for each layer
        for (int i = 0; i <= layer; ++i) {
            // find the lesser of its two children, and
            // sum the curretn value in the triagle with it
            minlen[i] = min(minlen[i], minlen[i + 1]) + triangle[layer][i];
        }
    }
    return minlen[0];
}

int main(){
    int a[] = {-2, -3};
    int b[] = {1, -1, -3};

    vvi tmp;
    vi two(1, (-1));
    tmp.push_back(two);

    //vi tw(2, (-4, -3));
    vi tw;
    tw.push_back(-2);
    tw.push_back(-3);
    tmp.push_back(tw);

    printVVI(tmp);
    
    cout << "result: " << minimumTotal(tmp) << endl;

    return 0;
}
