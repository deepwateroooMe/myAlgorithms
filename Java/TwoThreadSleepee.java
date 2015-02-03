import com.TwoThreadSleep;

public class TwoThreadSleepee {
    public static void main(String[] args) {
        TwoThreadSleep tt = new TwoThreadSleep();
        Thread t = new Thread(tt);
        t.setName("my worker thread");
        t.start();
        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
        }
        ((TwoThreadSleep)t).loop();
    }
}

