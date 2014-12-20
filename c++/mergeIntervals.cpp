#include <iostream>
#include <vector>
#include <stack>
#include <queue>
#include <cmath>
#include <algorithm>

using namespace std;

struct Interval {
    int start;
    int end;
    Interval() : start(0), end(0) {}
    Interval(int s, int e) : start(s), end(e) {}
};

// self defined compare function for sorting intervals
static bool myCompareFunc(Interval a, Interval b) {
    return a.start < b.start;
}

// inplace merge intervals
vector<Interval> merge(vector<Interval> &intervals) {
    if (intervals.size() < 2) return intervals;

    // still sort the vector first
    sort(intervals.begin(), intervals.end(), myCompareFunc);
    
    int j = 0;
    for (int i = 1; i < intervals.size(); ++i) {
        if (intervals[i].start <= intervals[j].end) 
            intervals[j].end = intervals[j].end > intervals[i].end ? intervals[j].end : intervals[i].end;
        else {
            ++j;
            intervals[j].start = intervals[i].start;
            intervals[j].end = intervals[i].end;
        }
    }
    // when erase, index i will be auto updated
    intervals.erase(intervals.begin()+j+1, intervals.end());
    return intervals;
}

int main(){
    Interval a(1, 4);
    Interval b(0, 2);
    Interval c(3, 5);
    //Interval d(15, 18);
    vector<Interval> tmp;
    tmp.push_back(a);
    tmp.push_back(b);
    tmp.push_back(c);
    //tmp.push_back(d);
    vector<Interval> result = merge(tmp);
    for (int i = 0; i < result.size(); ++i) {
        cout << result[i].start << ", " << result[i].end << endl;
    }
    cout << endl;
    
    return 0;
}
