#include <iostream>
#include <stack>
#include <queue>
#include <cstdlib>
using namespace std;

stack<int> Ssort(stack<int> s) {
    stack<int> t;
    while ( !s.empty() ) {
	int data = s.top();
	s.pop();
	while ( !t.empty() && t.top() > data ) {
	    s.push( t.top() );
	    t.pop();
	}
	t.push(data);
    }
    return t;
}

void Qsort(stack<int> &s) {
    priority_queue< int,vector<int>,greater<int> > q;
    while ( !s.empty() ) {
	q.push( s.top() );
	s.pop();
    }
    while ( !q.empty() ) {
	s.push( q.top() );
	q.pop();
    }
};

int main() {
    srand( (unsigned)time(0) );
    stack<int> s;
    for (int i = 0; i < 10; ++i)
	s.push( rand()%100 );
    Qsort(s);
    while ( !s.empty() ) {
	cout << s.top() << endl;
	s.pop();
    }
    return 0;
}
