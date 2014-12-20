#include <iostream>
#include <vector>
#include <stack>
#include <queue>
#include <cmath>
using namespace std;

struct Interval {
    int start;
    int end;
    Interval() : start(0), end(0) {}
    Interval(int s, int e) : start(s), end(e) {}
};

vector<Interval> insert(vector<Interval> &intervals, Interval newInterval) {
    vector<Interval> result;
    bool done = false;
    int i;
    for (i = 0; i < intervals.size() && !done; ++i) {
        // If newInterval is BEHIND the current interval
        if (newInterval.start > intervals[i].end) 
            result.push_back(intervals[i]);
        // if new interval is BEFORE current interval
        else if (newInterval.end < intervals[i].start)  {
            result.push_back(newInterval);
            result.push_back(intervals[i]);
            done = true;
        } else  { // if ine middle somewhere
            newInterval.start = (intervals[i].start < newInterval.start) ? intervals[i].start : newInterval.start;
            newInterval.end = (intervals[i].end > newInterval.end) ? intervals[i].end : newInterval.end;
        }
    }
    if (!done)
        result.push_back(newInterval);
    else  {
        for (; i < intervals.size(); ++i)
            result.push_back(intervals[i]);
    }
    return result;
}

int main() {
    vector<Interval> tmp;
    tmp.push_back(Interval(2, 5));
    tmp.push_back(Interval(6, 7));
    tmp.push_back(Interval(8, 9));
    for(int i = 0; i < tmp.size(); ++i)
        cout << tmp[i].start << ", " << tmp[i].end << endl;
    cout << endl;

    vector<Interval> result;
    result = insert(tmp, Interval(0, 0));
    
    for(int i = 0; i < result.size(); ++i)
        cout << result[i].start << ", " << result[i].end << endl;
    cout << endl;
    
    return 0;
}

/*
  vector<Interval> insert(vector<Interval> &intervals, Interval newInterval) {
  int n = intervals.size();
  vector<Interval> result;
  if (n == 0) {
  result.push_back(newInterval);
  return result;
  } else if (n == 1)  {
  if (intervals[0].end < newInterval.start)  {
  result.push_back(intervals[0]);
  result.push_back(newInterval);
  return result;
  } else if (newInterval.end < intervals[0].start) {
  result.push_back(newInterval);
  result.push_back(intervals[0]);
  return result;
  } else if (newInterval.start >= intervals[0].start && newInterval.end <= intervals[0].end) {
  result.push_back(intervals[0]);
  return result;
  } else if (newInterval.start <= intervals[0].start && newInterval.end >= intervals[0].end) {
  result.push_back(newInterval);
  return result;
  } else if (newInterval.end >= intervals[0].start && newInterval.end <= intervals[0].end) {
  result.push_back(Interval(min(intervals[0].start, newInterval.start), intervals[0].end));
  return result;
  } else  {        
  result.push_back(Interval(intervals[0].start, newInterval.end));
  return result;
  }
  } else if (newInterval.start <= intervals[0].start
  && newInterval.end >= intervals[n-1].end)  {
  result.push_back(newInterval);
  return result;
  } else if (newInterval.end < intervals[0].start) {
  result.push_back(newInterval);
  for(int i = 0; i < n; ++i)
  result.push_back(intervals[i]);
  return result;
  } else if (newInterval.start > intervals[n-1].end) {
  for(int i = 0; i < n; ++i)
  result.push_back(intervals[i]);
  result.push_back(newInterval);
  return result;
  } else if (newInterval.start < intervals[0].end && newInterval.end >= intervals[n-1].start) {
  result.push_back(Interval(min(intervals[0].start, newInterval.start),
  max(newInterval.end, intervals[n-1].end)));
  return result;
  }

  int start, end;
  if (newInterval.start > intervals[n-2].end)  {
  start = n-1;
  end = n-1;
  //cout << "start: " << start << endl;
  } else {
  for (int i = 0; i < n-1; ++i) {
  if (newInterval.start < intervals[0].start) {
  start = 0;
  //cout << "start 0: " << start << endl;
  break;
  } else if (intervals[i].start <= newInterval.start && intervals[i].end >= newInterval.start)  {
  start = i;
  //cout << "start: " << start << endl;
  break;
  }
  }
  for (int i = n-1; i >= 1; --i) {
  //cout << "i: " << i << endl;
  //cout << "intervals[i].start > newInterval.end: " << (intervals[i].start > newInterval.end) << endl;
  //cout << "intervals[i-1].start <= newInterval.end: " << (intervals[i-1].start <= newInterval.end) << endl;
  if (intervals[i].start > newInterval.end && intervals[i-1].start <= newInterval.end) {
  end = i-1;
  //cout << "end 0: " << end << endl;
  break;
  } else if (intervals[i].start <= newInterval.end && newInterval.end <= intervals[i].end) {
  end = i;
  //cout << "end 2: " << end << endl;
  break;
  } else if (newInterval.end > intervals[n-1].end) {
  end = n-1;
  break;
  }
  }
  //cout << "end 1: " << end << endl;
  }
  //cout << "start out: " << start << endl;
  //cout << "end out: " << end << endl;
    
  for (int i = 0; i < start; ++i)
  result.push_back(intervals[i]);
  if (start == end) {
  if (newInterval.start < intervals[start].start && newInterval.end < intervals[start].start ) {
  result.push_back(newInterval);
  result.push_back(intervals[start]);
  } else if (newInterval.start >= intervals[start].start)
  result.push_back(Interval(intervals[start].start, max(intervals[start].end, newInterval.end)));
  else if (newInterval.start < intervals[start].start && newInterval.end >= intervals[start].end)
  result.push_back(newInterval);
  else if (newInterval.end < intervals[end].end && newInterval.end >= intervals[end].start)
  result.push_back(Interval(min(intervals[end].start, newInterval.start), intervals[end].end));
  } else     
  result.push_back(Interval(min(intervals[start].start, newInterval.start),
  max(intervals[end].end, newInterval.end)));

  //cout << "end: " << end << endl;
  if (end == n) return result;
  if (end < n-1)  {
  for (int i = end+1; i < n; ++i)
  result.push_back(intervals[i]);
  return result;
  }
  }
*/
