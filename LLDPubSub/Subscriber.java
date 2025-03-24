import java.util.UUID;

public class Subscriber {
    public String subscriberID;
    int Offset;
    private PubSubController pubsubcontroller;

    public Subscriber(){subscriberID = UUID.randomUUID().toString();Offset = 0;}

    public void resetOffset(int newOffset){Offset = newOffset;}

    public void setPubsubcontroller(PubSubController pubsubcontroller){this.pubsubcontroller = pubsubcontroller;}

    public void update(Message message){System.out.println("Subscriber : " + subscriberID + "rececived Message : " + message.getID());}

    public int getOffset(){
        return Offset;
    }

    public void getNotification(String topicName){pubsubcontroller.push(topicName,subscriberID);}

    public String getID(){return subscriberID;}

    public void incrementOffset(){Offset++;}
}
