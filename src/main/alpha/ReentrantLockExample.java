import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2017/8/17 0017.
 */
public class ReentrantLockExample {
    int a = 0;
    ReentrantLock lock = new ReentrantLock();
    public void writer(){
        lock.lock();
        try {
            a++;
        }finally {
            lock.unlock();
        }
    }
    public void reader(){
        lock.lock();
        try {
            int i = a;
        }finally {
            lock.unlock();
        }
    }

}
