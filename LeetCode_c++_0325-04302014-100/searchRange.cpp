#include <iostream>
#include <vector>
#include <algorithm>
#include <cstring>
#include <cmath>
#include <stack>
#include <queue>
using namespace std;
typedef vector<int> vi;

int binarySearch(int a[], int n, vector<int> &result, int val, int low, int high) {
    while (low <= high)  {
        int mid = (low + high) / 2;
        if (a[mid] == val) return mid;
        
    }
}

vector<int> searchRange(int A[], int n, int target) {
    vector<int> result;
    binarySearch(A, n, result, target, 0, n-1);
    
}

int main(){
    int n = 6;
    int a[] = {5, 7, 7, 8, 8, 10};
    vi tmp = searchRange(a, n, 8);
    for (int i = 0; i < 2; ++i)
        cout << tmp[i] << ", ";
    cout << endl;
    
    return 0;
}
