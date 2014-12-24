#include <iostream>
#include <vector>
#include <stack>
#include <queue>
#include <cmath>
#include <climits>

using namespace std;

typedef vector<int> vi;

void findMax(const vector<int> &num, int start, int end, int& max, int& idx);
int findPeakElement1(const vector<int> &num);


// https://oj.leetcode.com/discuss/17793/find-the-maximum-by-binary-search-recursion-and-iteration

// recursion
int HelperOne(const vector<int> &num, int low, int high) {
    if (low == high) return low;

    int mid1 = low + (high - low) / 2;
    int mid2 = mid1 + 1;
    if (num[mid1] > num[mid2]) 
        return HelperOne(num, low, mid1);
    return HelperOne(num, mid2, high);
}

// iterative
int Helper(const vector<int> &num, int low, int high) {
    while (low <= high - 1) {        
        int mid1 = low + (high - low) / 2;
        int mid2 = mid1 + 1;
        if (num[mid1] > num[mid2]) 
            high = mid1;
        else low = mid2;
    }
    //if (low == high) return low;
    return low;
}

int findPeakElement(const vector<int> &num) {
    //return HelperOne(num, 0, num.size() - 1);
    return Helper(num, 0, num.size() - 1);
}

int main(){
    int a[] = {2, 1};
    int n = 2;
    
    vi tmp;
    for (int i = 0; i < n; ++i) {        
        tmp.push_back(a[i]);
    }
    
    cout << findPeakElement(tmp) << endl;
    
    return 0;
}

int findPeakElement1(const vector<int> &num) {
    if (num.size() == 0) return 0;
    if (num.size() == 1) return 0;
    else if (num.size() == 2) {
        return (num[0] > num[1]) ? 0 : 1;
    }
    
    int n = num.size();
    int max = (num[0] < num[n-1]) ? num[n-1] : num[0];
    int idx = (num[0] < num[n-1]) ? n-1 : 0;
    findMax(num, 0, n-1, max, idx);
    return idx;
}

// I don't know what am I doing here now
void findMax(const vector<int> &num, int start, int end, int& max, int& idx) {    
    int mid;
    while (start < end -1) {            
        mid = start + (end - start) / 2;
        if (num[mid] >= num[start] || num[mid] >= num[end]) {            
            if (num[mid] > max) {
                max = num[mid];
                idx = mid;
            }
            if (num[mid] > num[start]) {                
                start += 1;
                findMax(num, start, mid, max, idx);
            }
            if (num[mid] > num[end]) {
                end -= 1;
                findMax(num, mid, end, max, idx);
            }
        } else {
            if (num[start] > num[mid]) {
                if (num[start] > max) {
                    max = num[start];
                    idx = start;
                    mid = mid -1;
                    findMax(num, start, mid, max, idx);
                }
            } else if (num[end] > num[mid]) {
                if (num[end] > max) {
                    max = num[end];
                    idx = end;
                }
                mid = mid + 1;
                findMax(num, mid, end, max, idx);
            }
        }
    }
    if (start == end) {            
        if (num[mid] > max) {
            max = num[mid];
            idx = mid;
        }
        return;
    } else if (start == end - 1) {     
        if (num[start] <= num[mid]) {
            if (num[mid] > max) {                
                max = num[mid];
                idx = mid;
            }
        }
        return;
    }
}

