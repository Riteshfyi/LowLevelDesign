import java.util.concurrent.CopyOnWriteArrayList;

public class MessageHandler {
    CopyOnWriteArrayList<Message> messages;
    String topicName;
    public MessageHandler(String topicName){
        this.topicName = topicName;
        messages = new CopyOnWriteArrayList<>();
    }

    public void addMessage(Message message){
        messages.add(message);
    }
    public Message getMessageAtOffset(int offset){
       if(offset >= messages.size())return null;
        return messages.get(offset);
    }
    public int getOffset(){
        return messages.size();
    }

}
