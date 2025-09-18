import com.sun.tools.jconsole.JConsoleContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Instagram {
    private HashMap<Integer, User> userMap;
    private FeedStrategy homeFeedStrategy;
    private PostHandler postHandler;
    private UserHandler userHandler;


    public Instagram(HashMap<Integer , User> _userMap, FeedStrategy _homeFeedStrategy, PostHandler _postHandler, UserHandler _userHandler){
        userMap = _userMap;
        homeFeedStrategy = _homeFeedStrategy;
        postHandler = _postHandler;
        userHandler = _userHandler;
    }



    public List<Post> getHomeFeed(int userId, String cursor, int limit){
        if(!userMap.containsKey(userId))userMap.put(userId, new User(userId));
         User user = userMap.get(userId);
//         homeFeed
        return new ArrayList<>();
    };

    public void post(int userId, int updateId){
        if(!userMap.containsKey(userId))userMap.put(userId, new User(userId));
        User user = userMap.get(userId);
        postHandler.createPost(user, updateId);
    }

    public void mute(int userId, int followeeId){
        if(!userMap.containsKey(userId)){
            throw new Error("Invalid UserId");
        };

        if(!userMap.containsKey(followeeId)){
            throw  new Error("Invalid followeeId");
        }

        User user = userMap.get(userId);
        User followee = userMap.get(followeeId);
        userHandler.mute(user, followee);
    }

    public void unmute(int userId, int followeeId){
        //userService
        if(!userMap.containsKey(userId)){
            throw new Error("Invalid UserId");
        };

        if(!userMap.containsKey(followeeId)){
            throw  new Error("Invalid followeeId");
        }

        User user = userMap.get(userId);
        User followee = userMap.get(followeeId);
        userHandler.unmute(user, followee);

    }
    public void follow(int followeeId, int followerId){
        if(!userMap.containsKey(followerId))userMap.put(followerId, new User(followerId));
        if(!userMap.containsKey(followeeId))userMap.put(followeeId, new User(followeeId));
        User user = userMap.get(followerId);
        User followee = userMap.get(followeeId);
        userHandler.follow(user, followee);
    }

    public void unfollow(int followeeId, int followerId){
        if(!userMap.containsKey(followeeId))throw new Error("followerId doesn't exist");
        if(!userMap.containsKey(followeeId))throw new Error("followeeId doesn't exist");

        User user = userMap.get(followerId);
        User followee = userMap.get(followeeId);
        userHandler.unfollow(user, followee);
    }

    public void createAccount(int userId){
        if(userMap.containsKey(userId)){
           throw new Error("User already exists");
        }

        User newUser = new User(userId);
        userMap.put(userId, newUser);
    }

    public void deleteUpdate(int userId, int updateId){
        if(!userMap.containsKey(userId)){
            throw new Error("Invalid UserId");
        };
        User user = userMap.get(userId);
        postHandler.createPost(user, updateId);
    }

}
