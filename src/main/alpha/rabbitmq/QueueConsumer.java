package rabbitmq;

import com.rabbitmq.client.*;
import io.netty.util.CharsetUtil;
import org.apache.commons.lang.SerializationUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 * Created by Administrator on 2017/9/18 0018.
 */
public class QueueConsumer extends EndPoint implements Runnable, com.rabbitmq.client.Consumer {

    private String consumerName;
    private int number;

    public QueueConsumer(String endPointName, String consumerName) throws IOException, TimeoutException {
        super(endPointName);
        this.consumerName = consumerName;
    }

    @Override
    public void handleConsumeOk(String s) {
        System.out.println("Consumer " + s + " registered");
    }

    @Override
    public void handleCancelOk(String s) {

    }

    @Override
    public void handleCancel(String s) throws IOException {

    }

    @Override
    public void handleShutdownSignal(String s, ShutdownSignalException e) {

    }

    @Override
    public void handleRecoverOk(String s) {

    }

    @Override
    public void handleDelivery(String s, Envelope envelope, AMQP.BasicProperties basicProperties, byte[] bytes) throws IOException {
        System.out.println(consumerName + " --> received " + number++ );
//        try{
//            Thread.sleep(10000);
//        }catch (Exception e){
//            e.printStackTrace();
//        }finally {
//            channel.basicAck(envelope.getDeliveryTag(),false);
//        }
    }

    @Override
    public void run() {
        try {
//            channel.basicQos(1);
            channel.basicConsume(endPointName, true, this);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
