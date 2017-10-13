import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by Administrator on 2017/8/29 0029.
 */
public class Cache {
    static Map<String, Object> map = new HashMap<>();
    static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    static Lock read = readWriteLock.readLock();
    static Lock write = readWriteLock.writeLock();

    //获取一个 key 对应的 value
    public static final Object get(String key){
        read.lock();
        try {
            return map.get(key);
        }finally {
            read.unlock();
        }
    }

    //设置 key 对应的 value，并返回旧的 value
    public static final Object put(String key, Object value){
        write.lock();
        try {
            return map.put(key, value);
        }finally {
            write.unlock();
        }
    }

    public static final void clear(){
        write.lock();
        try {
            map.clear();
        }finally {
            write.unlock();
        }
    }
}
