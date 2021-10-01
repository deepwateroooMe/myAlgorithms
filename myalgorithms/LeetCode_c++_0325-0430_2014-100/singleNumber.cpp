#include <iostream>
#include <unordered_map>
using namespace std;
/*
// for twice
int singleNumber(int a[], int n) {
    unordered_map<int, bool> hash;
    for (int i = 0; i < n; ++i) {
        if (!hash[a[i]]) 
            hash[a[i]] = true;
        else 
            hash.erase(a[i]);
    }
    int result = (hash.begin())->first;
    return result;
}
*/

int singleNumber(int a[], int n) {
    unordered_map<long, int> hash;
    for (int i = 0; i < n; ++i) {
        if (hash.find(a[i]) == hash.end())
            hash[a[i]] = 1;
        else if (hash[a[i]] < 2) 
            ++hash[a[i]];
        else 
            hash.erase(a[i]);
    }
    /*
    cout << "hash.size(): " << hash.size() << endl;
    for ( auto& x: hash )
        std::cout << x.first << ": " << x.second << std::endl;
    */
    int result = (hash.begin())->first;
    return result;
}

int main() {
    int n = 37;
    int a[] = {1, 1, 1, 2, 3,  4, 2, 2, 3, 3,
               4, 4, 43,16,45, 89,45,-2147483648,45,2147483646,
               -2147483647,-2147483648,43,2147483647,-2147483646,
               -2147483648,89,-2147483646,89,-2147483646,

               -2147483647,2147483646,-2147483647,16,16,
               2147483646,43};
    int x = singleNumber(a, n);
    cout << x << endl;

    return 0;
}
