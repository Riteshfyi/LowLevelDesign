import java.util.List;
public class Screen {
    public String genre;
    private List<Show> shows;
    public Screen(String genre,List<Show> shows){
        this.genre = genre;
        this.shows = shows;
    }

    public List<Show> getShows(){
        return shows;
    }
}
