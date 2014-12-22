#include <iostream>
#include <vector>
#include <stack>
#include <queue>
#include <cmath>
#include <climits>

using namespace std;

int maximumGapVersion1(vector<int> &num);

int maximumGap(vector<int> &num) {
    if (num.size() < 2) return 0;
    else if (num.size() == 2) return abs(num[0] - num[1]);

    // find min and max first
    int imax = num[0];
    int imin = num[0];
    for (int x : num) {        
        if (x > imax) imax = x;
        if (x < imin) imin = x;
    }

    // each bucket has at most m numbers // to make sure n buckets
    int m = (imax - imin) / num.size() + 1;
    // but we just need the minimul and maximum of each bucket
    vector<vector<int> > buckets((imax - imin) / m + 1);
    
    for (int x : num) {
        int i = (x - imin) / m;   // bucket index
        if (buckets[i].empty()) {
            buckets[i].reserve(2);
            buckets[i].push_back(x);
            buckets[i].push_back(x);
        } else {
            if (x < buckets[i][0]) buckets[i][0] = x;
            if (x > buckets[i][1]) buckets[i][1] = x;
        }
    }

    // calculate the maximal gap
    int maxGap = 0;
    int prev = 0;
    for (int i = 0; i < buckets.size(); ++i) {
        if (buckets[i].empty()) continue;
        maxGap = max(maxGap, buckets[i][0] - buckets[prev][1]);
        prev = i;
    }
    return maxGap;
}

int main(){


    return 0;
}

int maximumGapVersion1(vector<int> &num) {
    if (num.size() < 2) return 0;
    else if (num.size() == 2) return abs(num[0] - num[1]);
    
    int n = num.size();
    int tmp[INT_MAX] = {0}; // the array size is too large
    for (int i = 0; i < n; ++i) 
        tmp[num[i]-1] = num[i];

    int maxGap = 0;
    int idx = 0, cnt = 0;
    while (tmp[idx] == 0) idx++;
    tmp[cnt++] = idx+1;

    for (int i = idx; i < INT_MAX; ++i) {
        if (tmp[i] != 0)
            tmp[cnt++] = i+1;
    }

    maxGap = tmp[1]-tmp[0];
    for (int i = 2; i < n; ++i) {
        if (tmp[i] - tmp[i-1] > maxGap)
            maxGap = tmp[i] - tmp[i-1];
    }
    return maxGap;
}

