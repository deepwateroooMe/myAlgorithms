#include <iostream>
#include <vector>
#include <stack>
#include <queue>
#include <cmath>
#include <unordered_map>

using namespace std;

typedef vector<int> vi;

vi toVector(int a[], int n) {
    vi result;
    for (int i = 0; i < n; ++i)
            result.push_back(a[i]);
    return result;
}

int majorityElement(vector<int> &num) {
    if (num.size() == 1) return num[0];
    unordered_map<int, int> hash;
    for (int i = 0; i < num.size(); ++i) {
        if (hash.count(num[i])) {
            hash[num[i]]++;
            if (hash[num[i]] > num.size()/2)
                return num[i];
        } else        
            hash[num[i]] = 1;
    }
}

int main(){
    int n = 3;
    int a[] = {3, 3, 4};
    vi result = toVector(a, n);
    cout << majorityElement(result) << endl;
    
    

    return 0;
}
