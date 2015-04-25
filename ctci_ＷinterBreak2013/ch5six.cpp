#include <iostream>
using namespace std;

int swap_bits(int x) {
    return ((x & 0x55555555) << 1) | ((x>>1) & 0x55555555);
}

int swap_bits1(int x) {
    return ((x & 0x55555555) << 1) | ((x & 0xaaaaaaaa) >> 1);
}

void print_binary (int x) {
    string s = " ";
    for (int i = 0; i < 32 && x != 0; ++i, x >>= 1) {  // try me !!!
	if (i % 4 == 0) s += " ";
	if (i % 8 == 0) s += "  "; // for printing propose

	if (x & 1) s += "1";
	else s += "0";
    }
    cout << s << endl;
}

int main() {
    int x = -7665543;
    print_binary(x);
    print_binary(swap_bits(x));
    print_binary(swap_bits1(x));
    return 0; 
}

/*
jenny@jenny-G50VT ~/docu/iv/ctci $ g++ six.cpp
jenny@jenny-G50VT ~/docu/iv/ctci $ ./a.out
    1001 1110   0001 0000   1101 0001   1111 1111
    0110 1101   0010 0000   1110 0010   1111 1111
    0110 1101   0010 0000   1110 0010   1111 1111
*/
