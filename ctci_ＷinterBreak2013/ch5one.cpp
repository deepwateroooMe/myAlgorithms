#include <iostream>
#include <vector>
using namespace std;

void print_binary(int n) {
    vector<int> v;
    int len = 8*sizeof(int);  // bits count
    int mask = 1;
    while(len--) {
	if (n & mask) v.push_back(1);
	else v.push_back(0);

      //mask <<= 1;      // <<= equivalent !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	mask = mask << 1; 
    }
    int cnt = 0;
    while ( !v.empty() ) {
	if (cnt%4==0) cout << " ";
	if (cnt%8==0) cout << "  "; // for printing propose only

	cout << v.back();
	v.pop_back();

	++cnt;
    }
    cout << endl;
}
/*
jenny@jenny-G50VT ~/docu/iv/ctci $ g++ one.cpp
jenny@jenny-G50VT ~/docu/iv/ctci $ ./a.out
   0000 0000   0000 0000   0000 0100   0000 0000
   0000 0000   0000 0000   0000 0000   0001 0101
   0000 0000   0000 0000   0000 0100   0101 0100
*/

int update_bits(int n, int m, int i, int j) {

    int ret = (1 << i) -1;
    ret &= n;

    /* not sure if this method works
    int ret = n; 
    ret = ret << (32-i);
    ret = ret >> (32-i);
    */
    /*
    n = n >> (j+1);
    n = n << (j+1);
    n = n | (m << i);
    n = n | ret;
    */
    return ( (n >> (j+1)) << (j+1) ) | m << i | ret;
}

int update_bits2(int n, int m, int i, int j) {
    int max = ~0; // `全为1， 32位是32个1，11111111 11111111 11111111 11111111`
    int left = max - ((1 << j+1)-1) ; // 11111111 11111000 00000000 00000000
    int right = (1 << i) - 1;         // 00000000 00000000 00000000 00111111
    int mask = left | right;          // 11111111 11111000 00000000 00111111
    /*
      int mask = (1 << (33-j) - 1) << j;
      mask |= (1 << i)-1 ;
    */
    return (n & mask) | (m << i);
}

int main() {
    int n = 1 << 10, m = 21;
    int ans = update_bits(n, m, 2, 6);
    print_binary(n);
    print_binary(m);
    print_binary(ans);
    return 0;
}
