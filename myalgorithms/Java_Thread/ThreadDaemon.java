import com.ThreadTest;

public class ThreadDaemon {
    public static void main(String[] args) {
        ThreadTest tt = new ThreadTest();
        Thread t = new Thread(tt);
        t.setDaemon(true);
        t.start();
        for (int i = 0; i < 300; i++) {
            System.out.println("GotHere");

        }

    }
}

