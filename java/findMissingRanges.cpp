#include <iostream>
#include <vector>
#include <stack>
#include <queue>
#include <cmath>
#include <cstdio>

#include "tree.h"

using namespace std;

// https://oj.leetcode.com/discuss/18265/shouldnt-consider-corner-cases-where-int_min-int_max-involved
vector<string> result;
char buf[50];
void adddMissingRange(int left, int right, bool incLeft = false, bool incRight = false) {
    if (right < left) return;
    else if (right == left) sprintf(buf, "%d", left);
    else sprintf(buf, "%d->%d", left, right);
    result.push_back(buf);
}

vector<string> findMissingRanges(int A[], int n, int lower, int upper) {
    int last = lower - 1;
    for (int i = 0; i < n; ++i) {
        adddMissingRange(last+1, A[i]-1);
        last = A[i];
    }
    adddMissingRange(last+1, upper);
    return result;
}

int main(){
    int n = 5;
    int a[] = {0, 1, 3, 50, 75};
    vs result = findMissingRanges(a, n, 0, 99);
    printVS(result);
    
    return 0;
}
