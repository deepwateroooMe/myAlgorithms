#include <iostream>
using namespace std;

int removeDuplicates(int a[], int n) {
    if (n <= 2) return n;
    int cnt = 0; 
    bool flag = false;
    int i;
    
    for ( i = 1; i < n; ++i) {
        while (a[i] == a[cnt]) {
            if (!flag && i < n)  {
                flag = true;
                a[++cnt] = a[i];
                ++i;
            } else  {
                if (i < n-1)
                    ++i;
                else
                    break;
            }
        }
        flag = false;
        if (a[i] != a[cnt])
            a[++cnt] = a[i];   
    }

    if ( (i < n && a[i] == a[cnt] && a[i] == a[cnt-1]) || i > n )
        return cnt;
    else  
        return cnt+1;    
}

int main() {
    int m = 10;
    int a[] = {-3, -3, -2, -1, -1, 0, 0, 0, 0, 0};

    cout << "a: ";
    for (int i = 0; i < m; ++i)
        cout << a[i] << ", ";
    cout << endl;
    
    int result = removeDuplicates(a, m);
    cout << "result: " << result << endl;
    for (int i = 0; i < result; ++i)
        cout << a[i] << ", ";
    cout << endl;
    
    return 0;
}

/*
  Input:	[-3,-1,0,0]
  Output:	[-3,-1]
  Expected:	[-3,-1,0]
*/
