#include <iostream>
using namespace std;

const int STACK_SIZE = 100;
const int STACK_NUM = 10;

class stack {
 private:
    int *buf; 
    int curr; 
    int capacity;
 public: 
    stack(int capa = STACK_SIZE) {
	buf = new int[capa];
	curr = -1;
	capacity = capa;
    }
    ~stack() {
	delete[] buf;
    }

    void push(int val) {
	buf[++curr] = val;
    }
    void pop() {
	--curr;
    }
    int top() {
	return buf[curr];
    }
    bool empty() {
	return curr == -1;
    }
    bool full() {
	return curr == capacity-1;
    }
};

class SetOfStacks {  // without popAt() yet
private: 
    stack *st; 
    int curr; 
    int capacity; 
public:
    SetOfStacks(int capa = STACK_NUM) {
	st = new stack[capa];
	curr = 0;
	capacity = capa; 
    }
    ~SetOfStacks() {
	delete[] st;
    }

    void push(int val) {
	if ( st[curr].full() )
	    ++curr;
	st[curr].push(val);
    }
    void pop() {
	if ( st[curr].empty() )
	    --curr;
	st[curr].pop();
    }
    int top() {
	if ( st[curr].empty() )
	    --curr;
	return st[curr].top();
    }
    bool empty() {
	if ( curr == 0 )
	    return  st[curr].empty() ;
	else 
	    return false;
    }
    bool full() {
	if ( curr == capacity-1 )
	    return st[curr].full();
	else
	    return false;
    }
};


// with popAt() function
class SetOfStacks1 {  
private: 
    stack *st; 
    int curr; 
    int capacity; 
public:
    SetOfStacks1(int capa = STACK_NUM) {
	st = new stack[capa];
	curr = 0;
	capacity = capa; 
    }
    ~SetOfStacks1() {
	delete[] st;
    }

    void push(int val) {
	if ( st[curr].full() )
	    ++curr;
	st[curr].push(val);
    }
    void pop() {
	while ( st[curr].empty() && curr > 0 ) // consider first stack empty condition
	    --curr;
	st[curr].pop();
    }
    void popAt(int val) {
	if ( st[val].empty() && val > 0 )
	    --val;
	st[val].pop();
	if ( curr == val && st[val].empty() ) // I think I need to consider this condition
	    --curr;
    }
    int top() {
	while ( st[curr].empty() && curr > 0 )
	    --curr;
	return st[curr].top();
    }
    bool empty() {
	//while ( st[curr].empty() && curr > 0 ) --curr;	    
	//if ( curr == 0 ) return  st[curr].empty() ;

	while ( curr != -1 && st[curr].empty() )
	    --curr;
	if (curr == -1) return true;
	else 
	    return false;
    }
    bool full() {
	if ( curr == capacity-1 )
	    return st[curr].full();
	else
	    return false;
    }
};


int main() {
    SetOfStacks1 s1;
    for (int i = 0; i < 3*STACK_SIZE+1; ++i ) 
	s1.push(i);
    for (int i = 0; i < STACK_SIZE; ++i ) {
	s1.popAt(0);
	s1.popAt(2);
    }
    s1.popAt(3);
    while ( !s1.empty() ) {
	cout << s1.top() << endl;
	s1.pop();
    }
    return 0;
}
