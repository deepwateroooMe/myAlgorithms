import com.SleepInterrupt;

public class InterruptCheck {
    public static void main(String[] args) {
        Thread t = Thread.currentThread();
        System.out.println("A t.isInterrupted(): " + t.isInterrupted());
        t.interrupt();
        System.out.println("B t.isInterrupted(): " + t.isInterrupted());
        System.out.println("C t.isInterrupted(): " + t.isInterrupted());
        try {
            Thread.sleep(2000);
            System.out.println("thread is NOT interrupted yet....");
        } catch (InterruptedException e) {
            System.out.println("now thread got interrupted....");
        }
        System.out.println("thread got interrupted");
        System.out.println("D t.isInterrupted(): " + t.isInterrupted());
    }
}

