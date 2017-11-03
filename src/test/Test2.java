import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Administrator on 2017/11/3 0003.
 */
public class Test2 {
//    private static final ExecutorService threadPool = Executors.newFixedThreadPool(20000);
//    private static AtomicInteger index = new AtomicInteger();

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>(2);
        map.put("1", "C");
        map.put("2", "A");
        map.put("8", "B");

//        Thread t = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 10000; i++){
//                    new Thread(new Runnable() {
//                        @Override
//                        public void run() {
//                            map.put(UUID.randomUUID().toString(), "");
//                        }
//                    }, "fif" + i).start();
//                }
//            }
//        },"ftf");
//        t.start();
//        t.join();
    }
}
