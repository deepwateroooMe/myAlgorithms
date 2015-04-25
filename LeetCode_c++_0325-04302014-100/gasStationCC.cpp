#include <iostream>
#include <vector>
using namespace std;

typedef vector<int> vi;
typedef vector< vector<int> > vvi;

void printVI(vi tmp) {
    for (int i = 0; i < tmp.size(); ++i)
        cout << tmp[i] << ", ";
    cout << endl;
}

void printVVI(vvi tmp) {
    cout << endl << "vvi print: " << endl;
    for (int i = 0; i < tmp.size(); ++i)
        printVI(tmp[i]);
    cout << endl;
}

int canCompleteCircuit(vector<int> &gas, vector<int> &cost) {
    int n = gas.size();
    if (n == 1) {
        if (gas[0] >= cost[0]) return 0;
        return -1;
    }
    int lover = 0;
    int curr;
    int net[n];
    for (int i = 0; i < n; ++i)
        net[i] = gas[i]-cost[i];

    int tover = 0;
    for (int i = 0; i < n; ++i) {
        if (net[i] <= 0) continue;
        int j = i;
        int counter = 1;

        while (counter < n && tover >= 0) {
            tover += net[j];
            if (tover < 0) break;
            ++j;
            ++counter;
            if (tover < 0) {
                tover = 0;
                continue; 
            }
            if (j == n) j = 0;
        }
        if (counter == n && tover >= 0) 
            return i;
        else tover = 0;
    }
    return -1;
}

int main() {
    int n = 4;
    int gas[] = {1, 2, 3, 3};
    int cost[] = {2, 1, 5, 1};
    vi a;
    vi b;
    for (int i = 0; i < n; ++i ) {
        a.push_back(gas[i]);
        b.push_back(cost[i]);
    }
    int result = canCompleteCircuit(a, b);
    cout << result << endl;
    
    return 0;
}


