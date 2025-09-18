import java.util.*;

public class recentPostStrategy implements FeedStrategy {
    PostHandler postHandler;
    UserHandler userHandler;

    public  recentPostStrategy(PostHandler _postHandler, UserHandler _userHandler){
        postHandler = _postHandler;
        userHandler = _userHandler;
    }

    @Override
    public List<Post> getFeed(User user, String cursor, int limit){
        PriorityQueue<Post> posts = new PriorityQueue<>(
                (a,b) -> b.createdAt.compareTo(a.createdAt)
        );
        //get all followers of this guy
        List<Follower> followers = user.getFollowers();
        for(Follower follower : followers){
            if(follower.isMuted())continue;

            List<Post> newPosts = postHandler.getPosts(user);

            for(Post post : newPosts){
                if(post.isSoftDeleted() || post.createdAt.toString().compareTo(cursor) >= 0)continue;
                posts.add(post);
                if(posts.size() > limit)posts.poll();
            }
        }

    List<Post> feed = new ArrayList<>();

    while(!posts.isEmpty()){
        feed.add(posts.poll());
    }

    Collections.reverse(feed);
    return feed;
};
}
