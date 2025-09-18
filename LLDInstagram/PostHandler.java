import java.util.*;

public class PostHandler {
    private HashMap<User, List<Post>> postMap;

    public PostHandler(HashMap<User, List<Post>> _postMap){
        postMap = _postMap;
    }

    public List<Post> getPosts(User user){
        if(!postMap.containsKey(user))postMap.put(user, new ArrayList<>());
        return postMap.get(user);
    }

    public void createPost(User user, int postId){
        if(!postMap.containsKey(user))postMap.put(user, new ArrayList<>());
        postMap.get(user).add(new Post(user.getId(), postId));
    }

    public void softDeletePost(){

    }

}
