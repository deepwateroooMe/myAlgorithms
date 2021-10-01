import com.TestThread;

public class ThreadDemo9_3 {
    public static void main(String[] args) {
        TestThread r = new TestThread();
        new Thread(r).start();
        new Thread(r).start();
        new Thread(r).start();
        new Thread(r).start();
    }
}

