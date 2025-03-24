import java.util.concurrent.atomic.AtomicInteger;

public class TopicHandler {
    String topicName;
    MessageHandler messageHandler;
    SubscriberHandler subscriberHandler;
    AtomicInteger currentOffset = new AtomicInteger(0);

    public TopicHandler(String topicName,SubscriberHandler subscriberHandler,MessageHandler messageHandler){
    this.subscriberHandler = subscriberHandler;
    this.messageHandler =  messageHandler;
    this.topicName = topicName;
    }

    public synchronized void publish(Message message){
     messageHandler.addMessage(message);
     subscriberHandler.notifyAllSubs(message,messageHandler.getOffset() - 1);
     currentOffset.incrementAndGet();
    }

    public void addSubscriber(Subscriber subscriber){
        subscriberHandler.addSubscriber(subscriber);
    }

    public void push(String subscriberID){
        Subscriber subscriber = subscriberHandler.getSubscriber(subscriberID);
        int offset = subscriber.getOffset();
        if (currentOffset.get() <= offset)return;
        Message message = messageHandler.getMessageAtOffset(offset);
        subscriberHandler.pushSubscriber(message,subscriber);
    }


}