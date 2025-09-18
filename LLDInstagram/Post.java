import java.sql.Time;
import java.time.LocalDateTime;

public class Post {
    private int userId;
    private int postId;
    private String text;
    private PostMedia postMedia;
    private boolean softDeleted;
    public LocalDateTime createdAt;

    public  Post(int _postId, int  _userId){
        userId = userId;
        softDeleted = false;
        postId = _postId;
        createdAt = LocalDateTime.now();
    }

    public void setText(String _text){
        text = _text;
    }

    public void setPostMedia(PostMedia _postMedia) {
       postMedia = _postMedia;
    }

    public void updatePostStatue(boolean _value){
        softDeleted = _value;
    }

    public boolean isSoftDeleted(){
        return isSoftDeleted();
    }

}