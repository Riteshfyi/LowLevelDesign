import java.util.List;
import java.util.ArrayList;

public class User {
    private int userId;
    private List<Follower> followers;
    private List<User> following;

    public User(int _userId){
        userId = _userId;
        followers = new ArrayList<>();
    }

    public List<Follower> getFollowers(){
        return  followers;
    }

    public int getUserId(){
        return userId;
    }

}
