#include <iostream>
using namespace std;

class stack3 {
private:
    int *buf; 
    int ptop[3];
    int size;
public: 
    stack3(int size = 300) {
	buf = new int[size*3];
	ptop[0] = ptop[1] = ptop[2] = -1;
	this->size = size;
    }
    ~stack3() {
	delete[] buf;
    }

    void push(int stackNum, int val) {
	int idx = stackNum*size + ptop[stackNum] + 1;
	buf[idx] = val; 
	++ptop[stackNum];
    }
    void pop(int stackNum) {
	--ptop[stackNum];
    }
    int top(int stackNum) {
	int idx = stackNum*size + ptop[stackNum];
	return buf[idx];
    }
    bool empty(int stackNum) {
	return ptop[stackNum] == -1;
    }
};

typedef struct node {
    int val;
    int preIdx;
} node;

class stack3_1{
private: 
    node* buf;
    int ptop[3];
    int totalSize;
    int curr;
public:
    stack3_1(int totalSize = 900) {
	buf = new node[totalSize];
	ptop[0] = ptop[1] = ptop[2] = -1;
	this->totalSize = totalSize;
	curr = 0;
    }
    ~stack3_1() {
	delete[] buf;
    }

    void push(int stackNum, int val) {
	buf[curr].val = val;
	buf[curr].preIdx = ptop[stackNum];
	ptop[stackNum] = curr;
	++curr;
    }
    void pop(int stackNum) {
	ptop[stackNum] = buf[ptop[stackNum]].preIdx; 
    }
    int top(int stackNum) {
	return buf[ptop[stackNum]].val;
    }
    bool empty(int stackNum) {
	return ptop[stackNum] == -1;
    }
};

int main(){

    //stack3 mystack;
    stack3_1 mystack;
    for(int i=0; i<10; ++i)
        mystack.push(0, i);
    for(int i=10; i<20; ++i)
        mystack.push(1, i);
    for(int i=100; i<110; ++i)
        mystack.push(2, i);
    for(int i=0; i<3; ++i)
        cout<<mystack.top(i)<<" ";
    cout<<endl;

    for(int i=0; i<3; ++i){
        mystack.pop(i);
        cout<<mystack.top(i)<<" ";
    }
    cout<<endl;

    mystack.push(0, 111);
    mystack.push(1, 222);
    mystack.push(2, 333);
    for(int i=0; i<3; ++i)
        cout<<mystack.top(i)<<" ";
    cout<<endl;

    return 0;
}
