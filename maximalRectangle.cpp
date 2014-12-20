#include <iostream>
#include <vector>
#include <stack>
#include <queue>
#include <cmath>
using namespace std;

int maximalRectangle(vector<vector<char> > &matrix) {
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

int main(){


    return 0;
}
