#include <iostream>
using namespace std;

int findIdx(int a[], int low, int high, int target) {
    if (low <= high) {
        int mid = (low + high) / 2;
        if (target == a[mid]) return mid;
        findIdx(a, low, mid-1, target);
        findIdx(a, mid+1, high, target);
    }
}

bool searchHelper(int a[], int low, int high, int target) {
    while(low <= high) {
        int mid = low + (high - low) / 2;
        if (target == a[mid]) return true;

        if (a[mid] >= a[low]) {
            if ( (a[mid] != a[low] && target >= a[low] && target < a[mid])
                 || (a[mid] == a[low]) ) {
                if (a[mid] == a[low]) {
                    low = low + 1;
                    if (low > mid)
                        low = mid + 1;
                } else                
                    high = mid -1;
            } else 
                low = mid + 1;
        } else
            if ( target > a[mid] && target < a[low] ) 
                low = mid + 1;
            else
                high = mid -1;
    }
    return false;
}

bool search(int A[], int n, int target) {
    return searchHelper(A, 0, n-1, target);
}

int main() {
    int n = 6;
    int a[] = {2, 2, 2, 0, 2, 2};    
    //int a[] = {4, 5, 6, 7, 0, 1, 2};
    //int a[] = {5, 1, 3};
    //int a[] = {1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    cout << search(a, n, 0) << endl;

    return 0;
}
