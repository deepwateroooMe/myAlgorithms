#include <iostream>
using namespace std;

void print_pare(int left, int right, char str[], int cnt) {
    if (left < 0 || right < left) return;
    if (left == 0 && right == 0) {
	for (int i = 0; i < cnt; ++i)
	    cout << str[i];
	cout << ", ";
    } else {
	if (left > 0) {
	    str[cnt] = '(';
	   print_pare(left-1, right, str, cnt+1);
	}
	if (right > left) {
	    str[cnt] = ')';
	    print_pare(left, right-1, str, cnt+1);
	}
    }
}

int main() {
    int cnt = 3;
    char str[2*cnt];
    print_pare(cnt, cnt, str, 0);
    return 0;
}
