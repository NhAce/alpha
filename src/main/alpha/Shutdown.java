import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/8/23 0023.
 */
public class Shutdown {
    public static void main(String[] args) throws Exception{
        Runner one = new Runner();
        Thread countThread = new Thread(one , "CountThread1");
        countThread.start();
        TimeUnit.SECONDS.sleep(1);
        countThread.interrupt();
        Runner two = new Runner();
        countThread = new Thread(two , "CountThread2");
        countThread.start();
        TimeUnit.SECONDS.sleep(1);
        two.cancel();
        System.out.println("end");
    }

    private static class Runner implements Runnable{
        private long i;
        private volatile boolean on = true;
        @Override
        public void run() {
            while (on && !Thread.currentThread().isInterrupted()){
                i++;
            }
            System.out.println(Thread.currentThread().getName() + " Count i = " + i);
        }
        public void cancel(){
            on = false;
        }
    }
}
