#include <iostream>
using namespace std;

class Lock {
public: 
    Lock() { }
    ~Lock() { }
    void AcquireLock(){ }
    void ReleaseLock(){ }
};

template <typename T>

class Singleton {
private:
    static Lock lock;
    static T* object;
protected:
    Singleton() { };
public:
    static T* Instance();
};

template <typename T>
Lock Singleton<T>::lock;

template <typename T>
T* Singleton<T>::object = NULL;

template <typename T>
T* Singleton<T>::Instance() {
    if (object == NULL) { // if object has not initialized yet, lock and initialize
	lock.AcquireLock();

	if (object == NULL) {
	    object = new T;
	}
	lock.ReleaseLock();
    }
    return object;
}

class Foo {
};

int main() {
    Foo* singleton_foo = Singleton<Foo>::Instance();
    return 0;
}
