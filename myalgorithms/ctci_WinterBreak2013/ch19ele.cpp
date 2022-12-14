#include <iostream>
#include <algorithm>
using namespace std;

void printPairSum(int a[], int n, int sum) {
    if (a == NULL || n <= 0) return;

    sort(a, a+n);
    int low = 0, high = n-1;

    while (low < high) {
	if ( a[low] + a[high] > sum )
	    --high;
	else if ( a[low] + a[high] < sum )
	    ++low;
	else {
	    cout << a[low] << " " << a[high] << endl;
	    --high; 
	    ++low;
	}
    }
}

int main() {
    int n = 6, sum = 6;
    int a[] = {1, 2, 3, 4, 5, 6};
    printPairSum(a, n, sum);
    return 0;
}
