#include <iostream>
#include <vector>
#include <stack>
#include <queue>
#include <cmath>
using namespace std;

int findMin(vector<int> &num) {
    int n = num.size();
    int start = 0, end = n - 1;
    int mid;
    while (start < end - 1) {
        mid = start + (end - start) / 2; // to prevent overflow
        if (num[mid] >= num[start] && num[mid] > num[end])
            start = mid + 1;
        else if (num[mid] >= num[start] && num[mid] < num[end])
            end = mid;
        else if (num[mid] == num[end] && num[mid] > num[start])
            end = mid;
        else  {
            start = start + 1;
            end = end - 1;
        }
    }

    if (num[start] < num[end])
        return num[start];
    return num[end];
}

int main(){
    int n = 3;
    int a[] = {3, 3, 1};
    vector<int> b;
    for (int i = 0; i < n; ++i) {
        b.push_back(a[i]);
    }
    cout << "findMin: " << findMin(b) << endl;
    
    return 0;
}
