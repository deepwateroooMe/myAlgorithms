#include <iostream>
#include <vector>
#include <stack>
#include <queue>
#include <cmath>

using namespace std;
typedef vector<int> vi;

vi toVector(int a[], int n);

int maxProfit(vector<int> &prices) {
    int len = prices.size();
    if (len == 0) return 0;

    vector<int> historyProfit;
    vector<int> futureProfit;
    historyProfit.assign(len,0);
    futureProfit.assign(len,0);
    int valley = prices[0];
    int peak = prices[len-1];
    int maxProfit = 0;

    // forward, calculate max profit until this time
    for (int i = 0; i < len; ++i) {
        valley = min(valley,prices[i]);
        if(i>0) {
            historyProfit[i] = max(historyProfit[i-1], prices[i]-valley);
        }
    }

    // backward, calculate max profit from now, and the sum with history
    for (int i = len-1; i >= 0; --i) {
        peak = max(peak, prices[i]);
        if (i < len-1) 
            futureProfit[i]=max(futureProfit[i+1], peak-prices[i]);
        maxProfit = max(maxProfit, historyProfit[i]+futureProfit[i]);
    }
    return maxProfit;
}

int main(){
    int n = 10;
    int a[] = {1, 2, 4, 2, 5, 7, 2, 4, 9, 0};

    vi one = toVector(a, n);
    for(int i = 0; i < one.size(); ++i)
        cout << one[i] << ", ";
    cout << endl;
    
    cout << endl << "final: " << maxProfit(one) << endl;

    return 0;
}

vi toVector(int a[], int n) {
    vi tmp;
    for(int i = 0; i < n; ++i)
        tmp.push_back(a[i]);
    return tmp;
}

int maxProfitMyOld(vector<int> &prices) {
    /*
    // can not handle the case below
    1, 2, 4, 2, 5, 7, 2, 4, 9, 0, 
    1, 2, -2, 3, 2, -5, 2, 5, -9, 
    cnt: 3
    3, 5, 7, 0, 
    fst: 7
    snd: 5
    final: 12
    */
    if (prices.empty()) return 0;
    int n = prices.size();
    int net[n-1];
    int max[10000] = {0};
    int cnt = 0;

    for (int i = 0; i < prices.size()-1; i++) 
        net[i] = prices[i+1] - prices[i];

    for(int i = 0; i < n-1; ++i)
        cout << net[i] << ", ";
    cout << endl;

    int j = 0;
    while (j < n-1) {    
        while (j < n-1 && net[j] >= 0)  {
            max[cnt] += net[j];
            ++j;
        }
        if (net[j] < 0)  {
            if (j == 0) ++j;
            else  {
                if (max[cnt] > 0)
                    ++cnt;
                ++j;
            }
        }
    }

    cout << "cnt: " << cnt << endl;
    for(int i = 0; i <= cnt; ++i)
        cout << max[i] << ", ";
    cout << endl;

    j = 1;
    int fst = max[0], snd = 0;
    while (j <= cnt && max[j] > 0) {
        if (max[j] > fst)  {
            snd = fst;
            fst = max[j];
        } else if (max[j] <= fst && max[j] > snd)        
            snd = max[j];
        ++j; 
    }
    
    cout << "fst: " << fst << endl;
    cout << "snd: " << snd << endl;
    return fst+snd;
}
