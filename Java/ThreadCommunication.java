import com.P;
import com.Producer;
import com.Consumer;

public class ThreadCommunication {
    public static void main(String[] args) {
        P q = new P();
        new Thread(new Producer(q)).start();
        new Thread(new Consumer(q)).start();
    }
}
