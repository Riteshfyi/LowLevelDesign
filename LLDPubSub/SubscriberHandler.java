import java.util.List;
import java.util.ArrayList;

public class SubscriberHandler {
    List<Subscriber> subscribers;
    int NotficationIndex;

    String topicName;
    public SubscriberHandler(String topicName){
        this.topicName = topicName;
        subscribers = new ArrayList<>();
        NotficationIndex = 0;
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
    public void removeSubscriber(Subscriber newSubscriber){
        if(!subscribers.contains(newSubscriber))return;
        subscribers.remove(newSubscriber);
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
        subscriber.update(message);
        subscriber.incrementOffset();
    }

}
