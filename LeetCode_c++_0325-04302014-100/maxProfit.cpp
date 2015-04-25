#include <iostream>
#include <vector>
#include <algorithm>
#include <cstring>
#include <cmath>
#include <stack>
#include <queue>
using namespace std;
typedef vector<int> vi;

/*
// time limit exceeded
int maxProfit(vector<int> &prices) {
if (prices.empty()) return 0;
else if (prices.size() == 2) {
if (prices[0] >= prices[1]) return 0;
return prices[1]-prices[0];
}
int n = prices.size();
int max, result = 0;
for(int i = 0; i < n; ++i) {
max = prices[i];
for(int j = i+1; j < n; ++j) {
if (prices[j] > max)
max = prices[j];
}
pro[i] = max - prices[i];
if (pro[i] > result)
result = pro[i];
}
return result;
}
*/

int maxProfit(vector<int> &prices) {
    if (prices.empty()) return 0;

    int maxProfit = 0;
    int max = 0;

    for (int i = 0; i < prices.size()-1; i++)
        prices[i] = prices[i+1] - prices[i];

    for (vector<int>::iterator it = prices.begin(); it < prices.end()-1; ++it) {
        if (*it >= 0) max += *it;
        else  {
            maxProfit = maxProfit > max ? maxProfit : max;
            max = max + *it > 0 ? max + *it : 0;
        }
    }
    if (maxProfit < max) return max;
    return maxProfit;
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
