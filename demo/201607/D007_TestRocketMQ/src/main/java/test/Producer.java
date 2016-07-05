package test;


import java.util.Date;


import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;


public class Producer {
    public static void main(String[] args) throws MQClientException, InterruptedException {
        DefaultMQProducer producer = new DefaultMQProducer("rmq-group");
        producer.setNamesrvAddr("192.168.160.132:9876");
        producer.setInstanceName("rmq-instance");
        producer.start();
        try {
            for (int i = 0; i < 3; i++) {
                Message msg = new Message("TopicA-test",// topic
                    "TagA",// tag
                        (new Date() + "Hello RocketMQ ,QuickStart" + i)
                                .getBytes()// body
                );
                SendResult sendResult = producer.send(msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        producer.shutdown();
    }
}


