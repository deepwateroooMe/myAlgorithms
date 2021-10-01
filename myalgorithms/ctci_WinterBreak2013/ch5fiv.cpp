#include <iostream>
using namespace std;

int count(int x) {
    int cnt = 0;
    for (int i = 0; i < 32; ++i) {  // refer to ch5thr.cpp
	if (x & 1) ++cnt;
	x >>= 1;
    }
    return cnt;
}

int count_one(int x){
    x = (x & (0x55555555)) + ((x >> 1) & (0x55555555));
    x = (x & (0x33333333)) + ((x >> 2) & (0x33333333));
    x = (x & (0x0f0f0f0f)) + ((x >> 4) & (0x0f0f0f0f));
    x = (x & (0x00ff00ff)) + ((x >> 8) & (0x00ff00ff));
    x = (x & (0x0000ffff)) + ((x >> 16) & (0x0000ffff));
    return x;
}

int convert_num(int a, int b) {
    return count(a ^ b);
}

int main() {
    int a = 31, b = 14;
    cout << "Bits needs to convert: " << convert_num(a, b) << endl;
    return 0;
}
