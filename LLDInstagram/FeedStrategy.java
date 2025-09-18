import java.util.*;

public interface FeedStrategy {
    public List<Post> getFeed(User user, String cursor, int limit);
}
