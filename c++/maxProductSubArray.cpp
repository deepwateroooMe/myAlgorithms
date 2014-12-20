#include <iostream>
#include <vector>
#include <stack>
#include <queue>
#include <cmath>
using namespace std;

int maxProduct(int A[], int n) {
    if (n  == 0) return 0;
    int minPre = A[0];
    int maxPre = A[0];
    int minHere, maxHere, maxSoFar = A[0];
    for (int i = 1; i < n; ++i) {
        maxHere = max(A[i], max(maxPre*A[i], minPre*A[i]));
        minHere = min(A[i], min(maxPre*A[i], minPre*A[i]));
        maxSoFar = max(maxHere, maxSoFar);
        maxPre = maxHere;
        minPre = minHere;
    }
    return maxSoFar;
}

int main(){
    int n = 2;
    int a[] = {0, 2};    
    cout << "out: " << maxProduct(a, n) << endl;
    
    return 0;
}
