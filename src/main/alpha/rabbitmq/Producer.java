package rabbitmq;

import com.rabbitmq.client.MessageProperties;
import org.apache.commons.lang.SerializationUtils;

import java.io.IOException;
import java.io.Serializable;
import java.util.concurrent.TimeoutException;

/**
 * Created by Administrator on 2017/9/18 0018.
 */
public class Producer extends EndPoint {
    public Producer(String endPointName) throws IOException, TimeoutException {
        super(endPointName);
    }

    public void sendMessage(Serializable Object) throws IOException{
        channel.basicPublish("",endPointName, MessageProperties.PERSISTENT_TEXT_PLAIN, SerializationUtils.serialize(Object));
    }

    public static void main(String[] args) throws Exception {
        Producer producer = new Producer("test-queue");
        int i = 0;
        String message = "heelllllooooo";
        boolean flag = true;
        while (flag){
            message += i++;
            producer.sendMessage(message);
            System.out.println("sent --> " + message);
//            try {
//                Thread.sleep(300);
//            }catch (Exception e){
//                e.printStackTrace();
//            }
            message = "heelllllooooo";
        }
        producer.close();
    }
}
