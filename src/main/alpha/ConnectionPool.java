import java.sql.Connection;
import java.util.LinkedList;

/**
 * Created by Administrator on 2017/8/25 0025.
 */
public class ConnectionPool {
    private LinkedList<Connection> pool = new LinkedList<Connection>();
    public ConnectionPool(int initalSize){//构造函数初始化连接数
        if (initalSize > 0){
            for (int i = 0; i < initalSize; i++){
                pool.addLast(ConnectionDriver.createConnection());
            }
        }
    }

    //连接使用完成后，调用此方法，把连接归还到连接池
    public void releaseConnection(Connection connection){
        if (connection != null){
            synchronized (pool){
                //连接释放后需要进行通知，这样其他消费者就能感知到连接池中归还了一个连接
                pool.addLast(connection);
                pool.notifyAll();
            }
        }
    }

    //在 mills 内无法获取到链接，将返回null
    public Connection fetchConnection(long mills) throws InterruptedException {
        synchronized (pool){
            //完全超时
            if (mills <= 0){
                while (pool.isEmpty()){
                    pool.wait();
                }
                return pool.removeFirst();
            } else {
                long future = System.currentTimeMillis() + mills;
                long remaining = mills;
                while (pool.isEmpty() && remaining > 0){
                    pool.wait(remaining);
                    remaining = System.currentTimeMillis() - future;
                }
                Connection result = null;
                if (!pool.isEmpty()){
                    result = pool.removeFirst();
                }
                return result;
            }
        }
    }
}
