#include <iostream>
#include <vector>
#include <algorithm>
#include <cstring>
#include <cmath>
#include <stack>
#include <queue>
using namespace std;

typedef vector<int> vi;
typedef vector< vector<int> > vvi;

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


int generateOneRow(int n, int r) {
    if (r == 0 || n == r) return 1;
    if (r < n-r) r = n-r;
    long long one = 1, two = 1;
    for(int i = r+1; i <= n; ++i)
        one *= i;
    for(int j = 2; j <= n-r; ++j)
        two *= j;
    return (int) (one / two);
}

vector<int> getRow(int rowIndex) {
    vector<int> one;
    for(int j = 0; j <= rowIndex; ++j)
        one.push_back(generateOneRow(rowIndex, j));
    return one;
}

vector<vector<int> > generate(int numRows) {
    vector<int> one;
    vector<vector<int> > result;

    for(int i = 0; i < numRows; ++i) {
        /*
        for(int j = 0; j <= i; ++j)
            one.push_back(generateOneRow(i, j));
        */
        one = getRow(i);
        result.push_back(one);
        one.clear();
    }
    return result;
}

int main(){
    int n = 25;
    vvi result = generate(n);
    printVVI(result);
    
    return 0;
}
