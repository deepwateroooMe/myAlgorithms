//import com.TestThread;

public class GetNameThreadDemo extends Thread {
    public void run() {
        for (int i = 0; i < 200; i++) {
            printMsg();
        }
    }

    public void printMsg() {
        Thread t = Thread. currentThread();
        String name = t.getName();
        System.out.println("name = " + name);
    }

    public static void main(String[] args) {
        GetNameThreadDemo t1 = new GetNameThreadDemo();
        t1.setName("test thread");
        System.out.println("before start(), t.isAlive() = " + t1.isAlive());

        t1.start();
        for (int i = 0; i < 300; i++) {
            t1.printMsg();
        }
        System.out.println("end of main, t.isAlive() = " + t1.isAlive());
    }
}

