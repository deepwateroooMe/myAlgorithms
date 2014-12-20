#include <iostream>
#include <vector>
#include <stack>
#include <queue>
#include <cmath>
using namespace std;
typedef vector<int> vi;

vi toVector(int a[], int n);

int candy(vector<int> &ratings) {
    int n = ratings.size();
    
    if (n == 0) return 0;
    else if (n == 1) return 1;
    int res[n];

    int start = 0;
    int mid = start;
    int end = start;
    bool up = false;
    bool down = false;
    bool goon = false;
    int curr = 0;
    int next_start = 0;
    
    do {
        res[start] = 1;
        up = false;
        down = false;
        mid = start;
        end = start;
        curr = start;

        while ((++curr) < n && ratings[curr] > ratings[curr-1]) {
            up = true;
            res[curr] = res[curr-1] + 1;
        }
        
        if (curr == n) { // end check
            mid = curr - 1;
            end = mid;
            down = false;
            goon = false;
        } else {
            mid = curr-1;
            if (ratings[curr] == ratings[curr-1]) {
                down = false;
                end = mid;
                next_start = mid + 1;
                goon = true;
            } else {
                down = true;
                while ( (++curr) < n && ratings[curr] < ratings[curr-1] );
                end = curr-1;
                res[end] = 1;
                
                if (curr == n) {
                    goon = false;
                } else {
                    if (ratings[curr] == ratings[curr-1]) {
                        end = curr-1;
                    }
                    goon = true;
                    next_start = end; // +1
                }
            }
        }
        if (down == true) {
            for (int i = end-1; i > mid; i--) 
                res[i] = res[i + 1] + 1;
            if (up == true) 
                res[mid] = max(res[mid-1], res[mid+1]) + 1;
            else 
                res[mid] = res[mid+1] + 1;
        }
        start = next_start;
    } while(goon);

    int sum = 0;
    for (int i = 0; i < n; i++) 
        sum += res[i];
    return sum;
}

int main(){
    int n = 3;
    int a [] = {1, 0, 2};
    vi tmp = toVector(a, n);
    for (int i = 0; i < tmp.size(); ++i)
        cout << tmp[i] << ", ";
    cout << endl;
    
    cout << endl;
    cout << candy(tmp) << endl;

    return 0;
}

vi toVector(int a[], int n) {
    vi tmp;
    for(int i = 0; i < n; ++i)
        tmp.push_back(a[i]);
    return tmp;
}
