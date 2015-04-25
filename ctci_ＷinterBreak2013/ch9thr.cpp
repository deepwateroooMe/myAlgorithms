#include <iostream>
using namespace std;

int find(int a[], int low, int high, int val) {
    if (low <= high) {
	int mid = (low + high) >> 1;  // / 2
	if (a[mid] == val) return mid;
	find(a, low, mid-1, val);
	find(a, mid+1, high, val);
    }
}

int search(int a[], int low, int high, int x) {
    while (low <= high) {
	int mid = low + (high - low) / 2;  // different from >> 1
	if (a[mid] == x) return mid;

	if (a[mid] >= a[low]) {
	    if (a[low] <= x && x < a[mid])
		high = mid -1;
	    else
		low = mid + 1;
	} else { 
	    if (x > a[mid] && x < a[low])
		low = mid + 1;
	    else
		high = mid -1;
	}
    }
    return -1;
}

int main() {
    int a[] = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
    cout << find(a, 0, 11, 5) << endl;
    cout << search(a, 0, 11, 5) << endl;
    return 0;
}
