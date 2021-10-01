import com.TestThread;

public class ThreadLife {
    public static void main(String[] args) {
        TestThread tt = new TestThread();
        Thread t = new Thread(tt);
        t.start();
        for (int i = 0; i < 3000; i++) {
            if (i == 100)
                try {
                    t.join(2000);                    
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                } 
            if (i == 2000) {
                tt.stopMe();
                System.out.println("got stopped jfgkjfkgfklgjfdgjkj from main......");
            }
            System.out.println("Main thread is running");
        }
    }
}
