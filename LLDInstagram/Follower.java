public class Follower {
    private String userId;
    private User user;
    private boolean isMuted;

    public Follower(String _userId, User _user){
        userId = _userId;
        _user = user;
    }

    public void mute(){
        isMuted  = true;
    }

    public void unmute(){
        isMuted = false;
    }

    public User getAccount(){
        return user;
    }

    public boolean isMuted(){
        return isMuted;
    }
}
