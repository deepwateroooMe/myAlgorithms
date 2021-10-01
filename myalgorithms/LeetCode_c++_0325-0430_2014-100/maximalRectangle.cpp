#include <iostream>
#include <vector>
#include <stack>
#include <queue>
#include <cmath>
using namespace std;

int maximalRectangle1(vector<vector<char> > &matrix);

// https://oj.leetcode.com/discuss/5198/a-o-n-2-solution-based-on-largest-rectangle-in-histogram
// needs to separate this question into some question that I am familiar with
int maximalRectangle(vector<vector<char> > &matrix) {
    if (matrix.size() == 0 || matrix[0].size() == 0) return 0;
    int row = matrix.size();
    int col = matrix[0].size();
    //int hight[] = new int[col + 1]; // +1 ? enforce a last round of calculate max area
    int hight[col+1];
    hight[col] = 0;
    int max = 0;

    for (int i = 0; i < row; ++i) {
        stack<int> s;
        for (int j = 0; j < col+1; ++j) {
            if (j < col)
                if (matrix[i][j] == '1')
                    hight[j] += 1;
                else
                    hight[j] = 0;
            
            if (s.empty() || hight[s.top()] <= hight[j])
                s.push(j);
            else {
                while (!s.empty() && hight[j] < hight[s.top()]) {
                    int top = s.top();
                    s.pop();
                    int area = hight[top] * (s.empty() ? j : (j-1 - s.top()));
                    if (area > max)
                        max = area;
                }
                s.push(j);
            }
        }
    }
    return max;
}

int main(){

    return 0;
}
/*
int maximalRectangle1(vector<vector<char> > &matrix) {
    if (matrix == NULL || matrix.size()== 0) return 0;
    int rLen = matrix.size();    // row length
    int cLen = matrix[0].size(); // column length
    // height array
    int h[cLen+1];
    h[cLen]= 0;
    int max = 0;
    
    for(int row = 0; row < rLen; ++row) {
        int h = INT_MAX;
        for(int j = i; j >= 0; --j) {
            h = min(h, matrix[j]);
            result = max(result, h*(i-j+1));
        }
    }
    return result;
}
*/
