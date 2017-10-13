/**
 * Created by Administrator on 2017/8/23 0023.
 */
public class Synchronized {
    public static void main(String[] args) {
        // 对 Synchronized Class对象进行枷锁
        synchronized (Synchronized.class){
        }
    }
    public static synchronized void m(){}
}
