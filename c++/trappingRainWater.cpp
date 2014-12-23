#include <iostream>
#include <vector>
#include <stack>
#include <queue>
#include <cmath>
using namespace std;

// referred to the genious idea from
// https://oj.leetcode.com/discuss/3546/any-one-pass-solutions
int trap(int A[], int n) {
    int left = 0, right = n-1;
    int block = 0, currlevel = 0, area = 0;
    while (left <= right) {
        if (min(A[left], A[right]) > currlevel) {
            area += (min(A[left], A[right]) - currlevel) * (right - left + 1);
            currlevel = min(A[left], A[right]);
        }
        if (A[left] < A[right])
            block += A[left++];
        else
            block += A[right--];
    }
    return area - block;
}

int main(){
    int n = 12;
    int a[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    cout << trap(a, n)  << endl;

    return 0;
}
