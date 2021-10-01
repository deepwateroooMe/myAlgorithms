import com.A;
import com.B;
import com.P;

public class DeadLockDemo implements Runnable {
    public A a = new A();
    public B b = new B();

    public DeadLockDemo() {
        Thread.currentThread().setName("Main--->>Thread");
        new Thread(this).start();
        a.funA(b);
        System.out.println("main thread run done~~!!");
    }

    public void run() {
        Thread.currentThread().setName("Test-->>Thread");
        b.funB(a);
        System.out.println("all other thread run done~~!!");
    }

    public static void main(String[] args) {
        new DeadLockDemo();
    }
}
