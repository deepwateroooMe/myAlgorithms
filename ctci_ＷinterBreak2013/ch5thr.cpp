#include <iostream>
#include <vector>
using namespace std;

void print_binary(int x) {
    vector<int> v;
    int cnt = 0, mask = 1;
    while (cnt < 32) {
	if (x & mask) v.push_back(1);
	else v.push_back(0);
	mask <<= 1;
	++cnt;
    }

    cnt = 0;
    while ( !v.empty() ) {
	if (cnt % 4 == 0) cout << " ";
	if (cnt % 8 == 0) cout << "  ";
	cout << v.back();
	v.pop_back();
	++cnt;
    }
    cout << endl;
}

int count1(int x) {
    int cnt = 0;
    for (int i = 0; i < 32; ++i) {  // for is safer !!!!!!
	if (x & 1) ++cnt; 
	x >>= 1;
    }
    return cnt;
}

int count(int x) {
    int cnt = 0;
    while (x > 0) { 
	if (x & 1) ++cnt;
	x >>= 1;
    }
    return cnt;
}

int count_one (int x) {
    x = (x & (0x55555555)) + ((x >> 1) & (0x55555555));
    x = (x & (0x33333333)) + ((x >> 2) & (0x33333333));
    x = (x & (0x0f0f0f0f)) + ((x >> 4) & (0x0f0f0f0f));
    x = (x & (0x00ff00ff)) + ((x >> 8) & (0x00ff00ff));
    x = (x & (0x0000ffff)) + ((x >> 16) & (0x0000ffff));
    return x;
}

int count_oneP (int x) {
    print_binary(x);
    cout << endl;

    cout << "1:" << endl;
    print_binary(x);
    print_binary(0x55555555);
    print_binary(x & (0x55555555));
    cout << endl;
    print_binary(x >> 1);
    print_binary(0x55555555);
    print_binary((x >> 1) & (0x55555555));
    cout << endl;
    print_binary(x & (0x55555555));
    print_binary((x >> 1) & (0x55555555));
    x = (x & (0x55555555)) + ((x >> 1) & (0x55555555));
    print_binary(x);
    cout << endl;

    cout << "2:" << endl;
    print_binary(x);
    print_binary(0x33333333);
    print_binary(x & (0x33333333));
    cout << endl;
    print_binary(x >> 2);
    print_binary(0x33333333);
    print_binary((x >> 2) & (0x33333333));
    cout << endl;
    print_binary(x & (0x33333333));
    print_binary((x >> 2) & (0x33333333));
    x = (x & (0x33333333)) + ((x >> 2) & (0x33333333));
    print_binary(x);
    cout << endl;

    cout << "4:" << endl;
    print_binary(x);
    print_binary(0x0f0f0f0f);
    print_binary(x & (0x0f0f0f0f));
    cout << endl;
    print_binary(x >> 4);
    print_binary(0x0f0f0f0f);
    print_binary((x >> 4) & (0x0f0f0f0f));
    cout << endl;
    print_binary(x & (0x0f0f0f0f));
    print_binary((x >> 4) & (0x0f0f0f0f));
    x = (x & (0x0f0f0f0f)) + ((x >> 4) & (0x0f0f0f0f));
    print_binary(x);
    cout << endl;

    cout << "8:" << endl;
    print_binary(x);
    print_binary(0x00ff00ff);
    print_binary(x & (0x00ff00ff));
    cout << endl;
    print_binary(x >> 8);
    print_binary(0x00ff00ff);
    print_binary((x >> 8) & (0x00ff00ff));
    cout << endl;
    print_binary(x & (0x00ff00ff));
    print_binary((x >> 8) & (0x00ff00ff));
    x = (x & (0x00ff00ff)) + ((x >> 8) & (0x00ff00ff));
    print_binary(x);
    cout << endl;

    cout << "16:" << endl;
    print_binary(x);
    print_binary(0x0000ffff);
    print_binary(x & (0x0000ffff));
    cout << endl;
    print_binary(x >> 16);
    print_binary(0x0000ffff);
    print_binary((x >> 16) & (0x0000ffff));
    cout << endl;
    print_binary(x & (0x0000ffff));
    print_binary((x >> 16) & (0x0000ffff));
    x = (x & (0x0000ffff)) + ((x >> 16) & (0x0000ffff));
    print_binary(x);
    return x;
}

/* mine, not complete
int next(int x) {
    int num = count(x); 
    int val = x+1;
    while ( count(val) != num )
	val += 1;
    return val;
} */

int next1(int x) {
    int max_int = ~(1<<31);
    int num = count(x);
    if (x == 0 || x == -1) return -1;
    for (++x; count(x) != num && x < max_int; ++x);
    if (count(x) == num) return x;
    return -1;
}

/* mine, not complete
int previous(int x) {
    int num = count(x); 
    int val = x-1;
    while ( count(val) != num )
	val -= 1;
    return val;
} */

int previous1(int x) {
    int min_int = (1 << 31);
    int num = count(x);
    if (x == 0 || x == -1) return -1;
    for (--x; count(x) != num && x > min_int; --x);
    if (count(x) == num) return x;
    return -1;
}

int next2(int x) {
    int xx = x, bit = 0;
    for (; (x&1) != 1 && bit < 32; x >>= 1, ++bit);
    for (; (x&1) != 0 && bit < 32; x >>= 1, ++bit);
    if (bit == 31) return -1; // 011---, none satisfy
    x |= 1;
    x <<= bit; // wtf, x<<32 != 0, so use next line to make x=0
    if (bit == 32) x = 0; // for 11100---00
    int num1 = count(xx) - count(x);
    int c = 1;
    for (; num1 > 0; x |= c, --num1, c <<= 1);
    return x;
}

int previous2(int x){
    int xx = x, bit = 0;
    for(; (x&1) != 0 && bit < 32; x >>= 1, ++bit);
    for(; (x&1) != 1 && bit < 32; x >>= 1, ++bit);
    if(bit == 31) return -1; //100..11, none satisify
    x -= 1;
    x <<= bit;
    if(bit == 32) x = 0;
    int num1 = count_one(xx) - count_one(x);
    x >>= bit;
    for(; num1 > 0; x = (x<<1) | 1, --num1, --bit);
    for(; bit > 0; x <<= 1, --bit);
    return x;
}

int main() {
    //int x = (1<<30) | (1<<28) | (1<<25) | (1<<21) | (1<<19) | (1<<15) 
    //	    | (1<<13) | (1<<10) | (1<<8) | (1<<6) | (1<<5) | (1<<2); 

    int x = -976756; // (1<<31)+(1<<29); // -8737776;

    //int cnt = count_oneP(x);
    //cout << "cnt: " << cnt << endl;

    print_binary(x);
    cout << endl;
    print_binary( next1(x) );    
    print_binary( next2(x) );    
    cout << endl;
    print_binary( previous1(x) );
    print_binary( previous2(x) );

    return 0;  // the result may have problem
}


/*
jenny@jenny-G50VT ~/docu/iv/ctci $ g++ thr.cpp
jenny@jenny-G50VT ~/docu/iv/ctci $ ./a.out
   0101 0010   0010 1000   1010 0101   0110 0100

1:
   0101 0010   0010 1000   1010 0101   0110 0100
   0101 0101   0101 0101   0101 0101   0101 0101
   0101 0000   0000 0000   0000 0101   0100 0100

   0010 1001   0001 0100   0101 0010   1011 0010
   0101 0101   0101 0101   0101 0101   0101 0101
   0000 0001   0001 0100   0101 0000   0001 0000

   0101 0000   0000 0000   0000 0101   0100 0100
   0000 0001   0001 0100   0101 0000   0001 0000
   0101 0001   0001 0100   0101 0101   0101 0100

2:
   0101 0001   0001 0100   0101 0101   0101 0100
   0011 0011   0011 0011   0011 0011   0011 0011
   0001 0001   0001 0000   0001 0001   0001 0000

   0001 0100   0100 0101   0001 0101   0101 0101
   0011 0011   0011 0011   0011 0011   0011 0011
   0001 0000   0000 0001   0001 0001   0001 0001

   0001 0001   0001 0000   0001 0001   0001 0000
   0001 0000   0000 0001   0001 0001   0001 0001
   0010 0001   0001 0001   0010 0010   0010 0001

4:
   0010 0001   0001 0001   0010 0010   0010 0001
   0000 1111   0000 1111   0000 1111   0000 1111
   0000 0001   0000 0001   0000 0010   0000 0001

   0000 0010   0001 0001   0001 0010   0010 0010
   0000 1111   0000 1111   0000 1111   0000 1111
   0000 0010   0000 0001   0000 0010   0000 0010

   0000 0001   0000 0001   0000 0010   0000 0001
   0000 0010   0000 0001   0000 0010   0000 0010
   0000 0011   0000 0010   0000 0100   0000 0011

8:
   0000 0011   0000 0010   0000 0100   0000 0011
   0000 0000   1111 1111   0000 0000   1111 1111
   0000 0000   0000 0010   0000 0000   0000 0011

   0000 0000   0000 0011   0000 0010   0000 0100
   0000 0000   1111 1111   0000 0000   1111 1111
   0000 0000   0000 0011   0000 0000   0000 0100

   0000 0000   0000 0010   0000 0000   0000 0011
   0000 0000   0000 0011   0000 0000   0000 0100
   0000 0000   0000 0101   0000 0000   0000 0111

16:
   0000 0000   0000 0101   0000 0000   0000 0111
   0000 0000   0000 0000   1111 1111   1111 1111
   0000 0000   0000 0000   0000 0000   0000 0111

   0000 0000   0000 0000   0000 0000   0000 0101
   0000 0000   0000 0000   1111 1111   1111 1111
   0000 0000   0000 0000   0000 0000   0000 0101

   0000 0000   0000 0000   0000 0000   0000 0111
   0000 0000   0000 0000   0000 0000   0000 0101
   0000 0000   0000 0000   0000 0000   0000 1100
cnt: 12

*/
