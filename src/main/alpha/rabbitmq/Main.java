package rabbitmq;

import io.netty.util.NettyRuntime;
import io.netty.util.internal.SystemPropertyUtil;

import java.util.HashMap;

/**
 * Created by Administrator on 2017/9/18 0018.
 */
public class Main {

    public Main() throws Exception{
        Consumer consumer = new Consumer("queue");
        Thread consumerThread = new Thread(consumer);
//        consumerThread.start();

        Producer producer = new Producer("queue");
        for (int i = 0; i < 100; i++){
            HashMap message = new HashMap();
            message.put("message number", i);
            producer.sendMessage(message);
            System.out.println("Message Number " + i + " sent.");
        }
    }

    public static void main(String[] args) throws Exception{
//        new Main();
//        QueueConsumer queueConsumer1 = new QueueConsumer("queue", "consumer1");
//        Thread queueConsumerThread1 = new Thread(queueConsumer1);
//        queueConsumerThread1.start();

        QueueConsumer queueConsumer2 = new QueueConsumer("task_queue", "consumer2");
        Thread queueConsumerThread2 = new Thread(queueConsumer2);
        queueConsumerThread2.start();
//
//        QueueConsumer queueConsumer3 = new QueueConsumer("queue", "consumer3");
//        Thread queueConsumerThread3 = new Thread(queueConsumer3);
//        queueConsumerThread3.start();
//        System.out.println(Math.max(1, SystemPropertyUtil.getInt("io.netty.eventLoopThreads", NettyRuntime.availableProcessors() * 2)));
    }
}
