#include <iostream>
#include <vector>
#include <stack>
#include <queue>
#include <cmath>
using namespace std;

class MinStack {
private:
    stack<int> sta;
    stack<int> minsta;
public:
    void push(int x) {
        sta.push(x);
        if ( (!minsta.empty() && x <= minsta.top()) || minsta.empty() )
            minsta.push(x);
    }

    void pop() {
        if (!sta.empty())  {
            if (minsta.top() == sta.top())
                minsta.pop();
            sta.pop();
        }
    }

    int top() {
        return sta.top();
    }

    int getMin() {
        return minsta.top();
    }
    
};

int main(){
    MinStack sta;
    sta.push(0);
    sta.push(1);
    sta.push(0);
    cout << "getMin: " << sta.getMin() << endl;
    sta.pop();
    cout << "getMin: " << sta.getMin() << endl;

    return 0;
}
