package Model;

public class Player {
    public PlayingPiece playingPiece;
    public String name;
    
    public Player(String name,PlayingPiece playingPiece){
     this.name = name;
     this.playingPiece = playingPiece;
    }

    public void setName(String name){
         this.name = name;
    }

    public String getName(){
        return name;
    }
    
    public PlayingPiece getPlayingPiece(){
        return playingPiece;
    }

    public void setPlayingPiece(PlayingPiece playingPiece){
        this.playingPiece = playingPiece;
    }

}
