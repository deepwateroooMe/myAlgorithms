#include <iostream>
using namespace std;

const int MAX_INT = ~(1<<31); // 2147483647

typedef struct node {
    int val; 
    int min;
} node;

class StackWithMin{
private:
    node* buf;
    int curr;
public: 
    StackWithMin(int size = 1000){
	buf = new node[size];
	buf[0].min = MAX_INT;
	curr = 0;
    }
    ~StackWithMin(){
	delete[] buf;
    }

    void push(int val) {
	buf[++curr].val = val;
	if ( val < buf[curr-1].min )
	    buf[curr].min = val;
	else 
	    buf[curr].min = buf[curr-1].min;
    }
    void pop() {
	--curr;
    }
    int top() {
	return buf[curr].val;
    }
    bool empty() {
	//return (buf[curr].min == MAX_INT);
	return curr == 0;  // much more easier
    }
    int min() {
	return buf[curr].min;
    }
};


// maintain two stack to save space
class stack {
 private:
    int *buf; 
    int curr; 
 public: 
    stack(int size = 1000) {
	buf = new int[size];
	curr = -1;
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
};

class StackWithMin1{
private:
    stack s1, s2;
public: 
    StackWithMin1(){
    }
    ~StackWithMin1(){
    }

    void push(int val) {
	s1.push(val);
	// if ( val <= s2.top() )
	if ( val <= min() )  // more direct
	    s2.push(val);
    }
    void pop() {
	if ( s1.top() == min() )
	    s2.pop();
	int val = s1.top();
	s1.pop();
    }
    int top() {
	return s1.top();
    }
    bool empty() {
	return s1.empty();
    }
    int min() {
	if ( s2.empty() )
	    return MAX_INT;
	else
	    return s2.top();
    }
};


int main() {

    StackWithMin1 mystack;

    for(int i=0; i<20; ++i)
        mystack.push(i);
    cout << mystack.min() << " " << mystack.top() << endl;
    mystack.push(-50);
    mystack.push(-100);
    cout << mystack.min() << " " << mystack.top() << endl;
    mystack.pop();
    cout << mystack.min() << " " << mystack.top() << endl;

    return 0;
}
