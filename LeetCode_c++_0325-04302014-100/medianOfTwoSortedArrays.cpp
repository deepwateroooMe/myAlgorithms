#include <iostream>
#include <cassert>
#include <climits>
using namespace std;

//#define INT_MAX ~(1<<31)  // <climits>
//#define INT_MIN 1<<31

double median(int A[], int n) {
    if (n == 0) return (1<<31);
    else if (n == 1) return A[0];
    
    if (n & 1) return A[(n-1)/2];
    else return ( A[(n-1)/2] + A[(n+1)/2] ) / 2.0;
}
    
double findMedianSortedArrays(int A[], int m, int B[], int n) {  // mine
    if (m == 0 && n != 0) return median(B, n);
    if (m != 0 && n == 0) return median(A, m);
    if (m == 1 && n == 1) return (A[0]+B[0])/2.0;   

    int idx = (m + n) / 2 + 1;
    int C[m+n];
    int i = 0, j = 0, x = 0;
    while (x < idx) {
	if (A[i] <= B[j])
	    C[x++] = A[i++];
	else 
	    C[x++] = B[j++];
    }
    for (int i = 0; i < idx; ++i)
	cout << C[i] << endl;
    cout << C[idx-2] << " " << C[idx-1] << endl;
    
    if ( (m+n) & 1 ) return C[idx-1];
    else return (double)(C[idx-2] + C[idx-1])/2.0;
}

double findMedianSortedArrays1(int A[], int m, int B[], int n) {
    int i = 0, j = 0;
    int m1 = -1, m2 = -1;
    int s = (m + n) / 2;

    while (s >= 0) {
	int a = (i < m) ? A[i] : INT_MAX;
	int b = (j < n) ? B[j] : INT_MAX;
	m1 = m2;
	if (a < b) {
	    m2 = a;
	    i++;
	} else {
	    m2 = b;
	    j++;
	}
	s--;
    }
    if ((m+n) % 2 == 0) return (m1 + m2) / 2.0;
    return m2;
}

double findMedianHelper2(const int A[], const int m, const int B[], const int n, 
			 const int l, const int r) {
    if (l > r) return findMedianHelper2( B, n, A, m, max(0, (n-m)/2), min(n-1, (m+n)/2) );
    int i = (l + r) / 2;
    int j = (m + n) / 2 - i;

    assert(i >= 0 && i <= m && j >= 0 && j <= n);
    int Ai_1 = (i == 0) ? INT_MIN : A[i-1];
    int Bj_1 = (j == 0) ? INT_MIN : B[j-1];
    int Ai = (i == m) ? INT_MAX : A[i];
    int Bj = (j == n) ? INT_MAX : B[j];

    if (Ai < Bj_1) return findMedianHelper2(A, m, B, n, i+1, r);
    if (Ai > Bj) return findMedianHelper2(A, m, B, n, l, i-1);

    if ( (m + n) % 2 == 1 ) return A[i];
    return ( max(Ai_1, Bj_1) + Ai) / 2.0;
}

double findMedianSortedArrays2(int A[], int m, int B[], int n) {
    return findMedianHelper2( A, m, B, n, max(0, (m-n)/2), min(m-1, (m+n)/2) );
}

int main() {
    int a[] = {1, 1};
    int b[] = {1, 1};
    int m = 2, n = 2;
    cout << findMedianSortedArrays2(a, m, b, n) << endl;
    return 0;
}
