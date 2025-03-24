import java.util.HashMap;
public class PubSubController {
    //it is an api
    HashMap<String,TopicHandler> map;
    //publish
    //subscribe
    //getOffsetElement

    public PubSubController(){
        map = new HashMap<>();
    }

    public void publish(String TopicName,Message message){
       TopicHandler topicHandler = map.get(TopicName);
       topicHandler.publish(message);
    }

    public void subscribe(String TopicName,Subscriber subscriber){
        TopicHandler topicHandler = map.get(TopicName);
        topicHandler.addSubscriber(subscriber);
    }

    public void push(String TopicName, String subscriberID){
        TopicHandler topicHandler = map.get(TopicName);
        topicHandler.push(subscriberID);
    }

    public void createTopic(String TopicName){
        if(!map.containsKey(TopicName)){
            TopicHandler topicHandler = new TopicHandler(TopicName,new SubscriberHandler(TopicName),new MessageHandler(TopicName));
            map.put(TopicName,topicHandler);
        }
    }
}
