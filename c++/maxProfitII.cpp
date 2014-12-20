#include <iostream>
#include <vector>
#include <stack>
#include <queue>
#include <cmath>

using namespace std;

int maxProfit(vector<int> &prices) {
    if (prices.empty()) return 0;
    int max = 0;
    for (int i = 0; i < prices.size()-1; i++)
        if (prices[i+1] > prices[i])
            max += prices[i+1]-prices[i];
    return max;
}

int main(){
    int n = 3;
    vi one;
    one.push_back(2);
    one.push_back(4);
    one.push_back(1);
    //one.push_back(3);
    cout << maxProfit(one) << endl;

    return 0;
}
