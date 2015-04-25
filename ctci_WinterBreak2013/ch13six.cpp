#include <iostream>
using namespace std;

class FirstClass {
public: 
    virtual void MethodA(int);
    virtual void MethodA(int, int);
};

void FirstClass::MethodA(int i) {
    cout << "ONE" << endl;
}

void FirstClass::MethodA(int i, int j) {
    cout << "TWO" << endl;
}


class SecondClass : public FirstClass {
public: 
    void MethodA(int);
};

void SecondClass::MethodA(int i) {
    cout << "THREE" << endl;
}

int main() {
    SecondClass a;
    a.MethodA(1);
    a.MethodA(1, 1);//error: no matching function for call to 'SecondClass::MethodA(int, int)'
    return 0;
}
