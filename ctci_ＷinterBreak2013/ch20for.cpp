#include <iostream>
using namespace std;

int Count2(int n) {
    int count = 0;
    while (n > 0) {
	if (n % 10 == 2) {
	    ++count;
	    n /= 10;
	}
    }
    return count;
}

int Count2s1(int n) {
    int count = 0;
    for (int i = 0; i <= n; ++i) {
	count += Count2(i);
    }
    return count;
}

int Count2s(int n) {
    int count = 0;
    int factor = 1;
    int low = 0, curr = 0, high = 0;

    while(n/factor != 0) {
	low = n - (n/factor)*factor;
	curr = (n/factor) % 10;
	high = n / (factor*10);

	switch(curr) {
	case 0:
	case 1:
	    count += high * factor;
	    break;
	case 2:
	    count += high * factor + low + 1;
	    break;
	default:
	    count += (high + 1) * factor;
	    break;
	}
	factor *= 10;
    }
    return count;
}

int Countis(int n, int i) {
    if (i < 1 || i > 9) return -1; // i should be in range [1, 9]

    int count = 0; 
    int factor = 1;
    int low = 0, curr = 0, high = 0;

    while (n / factor != 0) {
	low = n - (n/factor)*factor;
	curr = (n/factor) % 10;
	high = n / (factor*10);

	if (curr < i)
	    count += high * factor;
	else if (curr == i) 
	    count += high * factor + low + 1;
	else 
	    count += (high + 1) * factor;
	factor *= 10;
    }
    return count;
}
