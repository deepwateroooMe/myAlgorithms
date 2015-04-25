#include <iostream>
#include <vector>
#include <stack>
#include <queue>
#include <cmath>
#include <unordered_map>

using namespace std;

class TwoSum {
private:
    unordered_map<int, int> hash;
public:
    void add(int number) {
        hash[number] = hash.count(number) ? hash[number]++ : 1);
        /*
        if (hash.count(number) == 0) 
            hash[number] = 1;
        else 
            hash[number]++;
        */
	}

    bool find(int value) {
        int second;
	    for (auto &key : hash) {
            second = value - key.first;
            if (hash.count(second) > 0) 
                if (second != key.first || (second == key.first && hash[second] > 1)) 
                    return true;
        }
        return false;
    }
};

int main() {
    TwoSum one;
    
    one.add(1);
    one.add(3);
    one.add(3);
    one.add(5);

    cout << one.find(4) << endl;
    cout << one.find(6) << endl;
    cout << one.find(7) << endl;
    
    return 0;
}
