#include <iostream>
#include <vector>
#include <stack>
#include <queue>
#include <cmath>
#include <algorithm>
#include <unordered_map>

using namespace std;

int longestConsecutive(vector<int> &num) {
    if (num.size() == 0) return 0;

    unordered_map<int, int> map;
    int maxlen = 1;
    int leftbound, rightbound;

    for (auto &val: num) {
        if (map[val] != 0)
            continue;
        map[val] = 1;
        leftbound = map[val-1];
        rightbound = map[val+1];
        map[val-leftbound] = map[val+rightbound] = 1 + leftbound + rightbound;
        maxlen = max(maxlen, 1 + leftbound + rightbound);
    }
    return maxlen;
}

int main(){
    int n = 6;
    int a[] = {100, 4, 200, 1, 3, 2};
    vector<int> tmp;
    for (int i = 0; i < n; ++i) {
        tmp.push_back(a[i]);
        cout << tmp[i] << ", ";
    }
    cout << endl;
    cout << "out: " << longestConsecutive(tmp) << endl;
    
    return 0;
}
