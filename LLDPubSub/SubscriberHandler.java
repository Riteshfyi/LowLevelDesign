import java.util.concurrent.CopyOnWriteArrayList;

public class SubscriberHandler {
    CopyOnWriteArrayList<Subscriber> subscribers;

    String topicName;
    public SubscriberHandler(String topicName){
        this.topicName = topicName;
        subscribers = new  CopyOnWriteArrayList<>();
    }



    public void notifyAllSubs(Message message,int notificationOffset){
        for (int i = 0; i < subscribers.size(); i++) {
            if(subscribers.get(i).getOffset() == notificationOffset)pushSubscriber(message,subscribers.get(i));
        }
    }

    public void addSubscriber(Subscriber newSubscriber){
        if(subscribers.contains(newSubscriber))return;
        subscribers.add(newSubscriber);
    }
    public void removeSubscriber(Subscriber subscriber){
        if(!subscribers.contains(subscriber))return;
        subscribers.remove(subscriber);
    }

    public Subscriber getSubscriber(String subscriberID){
        for (int i = 0; i < subscribers.size(); i++) {
            if(subscribers.get(i).getID() == subscriberID){
                return subscribers.get(i);
            }
        }
        return null;
    }

    public void pushSubscriber(Message message, Subscriber subscriber){
        if(message == null || subscriber == null)return;
        subscriber.update(message);
        subscriber.incrementOffset();
    }

}
