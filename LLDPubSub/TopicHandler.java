public class TopicHandler {
    String topicName;
    MessageHandler messageHandler;
    SubscriberHandler subscriberHandler;

    public TopicHandler(String topicName,SubscriberHandler subscriberHandler,MessageHandler messageHandler){
    this.subscriberHandler = subscriberHandler;
    this.messageHandler =  messageHandler;
    this.topicName = topicName;
    }

    public synchronized void publish(Message message){
     messageHandler.addMessage(message);
     subscriberHandler.notifyAllSubs(message,messageHandler.getOffset() - 1);
    }

    public void addSubscriber(Subscriber subscriber){
        subscriberHandler.addSubscriber(subscriber);
    }

    public void push(String subscriberID){
        Subscriber subscriber = subscriberHandler.getSubscriber(subscriberID);
        int offset = subscriber.getOffset();
        Message message = messageHandler.getMessageAtOffset(offset);
        subscriberHandler.pushSubscriber(message,subscriber);
    }


}