#include <iostream>
using namespace std;

void hanoi(int n, string src, string bri, string dst) {
    if (n == 1)
	cout << "Move disk " << n << " from " << src << " to " << dst << endl;
    else {
	hanoi(n-1, src, dst, bri);
	cout << "Move disk " << n << " from " << src << " to " << dst << endl;
	hanoi(n-1, bri, src, dst);
    }
}

int main() {
    int n = 3;
    hanoi(n, "src", "bri", "dst");
    return 0;
}
