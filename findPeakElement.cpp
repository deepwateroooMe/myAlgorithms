#include <iostream>
#include <vector>
#include <stack>
#include <queue>
#include <cmath>
#include <climits>

using namespace std;

typedef vector<int> vi;

void findMax(const vector<int> &num, int start, int end, int& max, int& idx) {    
    int mid;
    mid = start + (end - start) / 2;
    while (start < mid - 1 || mid < end-1) {
        if (num[mid] >= num[start] || num[mid] >= num[end]) {            
            if (num[mid] > max) {
                max = num[mid];
                idx = mid;
            }
            if (num[mid] > num[start]) {                
                start += 1;
                if (start < mid -1)
                    findMax(num, start, mid, max, idx);
            }
            if (num[mid] > num[end]) {
                end -= 1;
                if (mid < end-1)
                    findMax(num, mid, end, max, idx);
            }
        } else {
            if (num[start] > num[mid]) {
                if (num[start] > max) {
                    max = num[start];
                    idx = start;
                    mid = mid -1;
                    if (start < mid -1)
                        findMax(num, start, mid, max, idx);
                }
            } else if (num[end] > num[mid]) {
                if (num[end] > max) {
                    max = num[end];
                    idx = end;
                }
                mid = mid + 1;
    cout << "start 0: " << start << endl;
    cout << "mid 0: " << mid << endl;
    cout << "end 0: " << end << endl;
    cout << "max 0: " << max << endl;
    cout << "idx 0: " << idx << endl;
                
                if (mid < end-1)
                    findMax(num, mid, end, max, idx);
            }
        }
    }

    cout << "start: " << start << endl;
    cout << "mid: " << mid << endl;
    cout << "end: " << end << endl;
    cout << "max: " << max << endl;
    cout << "idx: " << idx << endl;
    if (start == mid || mid == end) {
        if (num[mid] > max) {
            max = num[mid];
            idx = mid;
        }
        return;
    } else if (start == mid - 1 || mid == end -1) {
        if (num[start] <= num[mid]) {
            if (num[mid] > max) {                
                max = num[mid];
                idx = mid;
            }
        }
        return;
    }
}

int findPeakElement(const vector<int> &num) {
    if (num.size() == 0) return 0;
    if (num.size() == 1) return 0;
    else if (num.size() == 2) {
        return (num[0] > num[1]) ? 0 : 1;
    }
    
    int n = num.size();
    int max = (num[0] < num[n-1]) ? num[n-1] : num[0];
    int idx = (num[0] < num[n-1]) ? 0 : n-1;
    findMax(num, 0, n-1, max, idx);
    return idx;
}

int main(){
    int a[] = {1, 2, 3, 4};
    int n = 4;
    
    vi tmp;
    for (int i = 0; i < n; ++i) {        
        tmp.push_back(a[i]);
    }
    
    cout << findPeakElement(tmp) << endl;
    
    return 0;
}
