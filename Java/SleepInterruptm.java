import com.SleepInterrupt;

public class SleepInterruptm {
    public static void main(String[] args) {
        SleepInterrupt tt = new SleepInterrupt();
        Thread t = new Thread(tt);
        t.setName("my worker thread");
        t.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        System.out.println("in main() - interrupt all other thread");
        t.interrupt();
        System.out.println("in main() - quit");
    }
}

