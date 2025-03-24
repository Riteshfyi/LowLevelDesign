import java.util.UUID;

public class Message {
    //a message can have a topic
    private String topicName;
    //a message will have a data,let it be string for right now
    private String description;
    private String messageID;
    public Message(String  ID,String description){
        this.description = description;
        messageID = ID;
    }
    //should i give id to messages? => wont be used tho
    public String getID(){
        return messageID;
    }

}
