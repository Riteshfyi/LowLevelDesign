public class Client {
    public static void main(String args[]){
        Directory harddisk = new Directory("C:");
        Directory games  = new Directory("Games");
        games.add(new File("Red Dead Redemption"));
        games.add(new File("Ghost of Tsuhima"));
        Directory Movies = new Directory("Movies");
        Directory HindiMovies = new Directory("Hindi Movies");
        HindiMovies.add(new File("Weolcome"));
        HindiMovies.add(new File("Hera Pheri"));
        Movies.add(new Directory("Hollywood Movies"));
        Movies.add(HindiMovies);
        harddisk.add(games);
        harddisk.add(Movies);
        harddisk.ls();
    }
}
