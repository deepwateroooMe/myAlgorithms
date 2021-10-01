import com.TestThread;

public class ThreadDemo9_5 {
    public static void main(String[] args) {
        TestThread r = new TestThread();
        new Thread(r).start();
        new Thread(r).start();
        new Thread(r).start();
        new Thread(r).start();
    }
}

