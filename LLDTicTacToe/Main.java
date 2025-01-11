public class Main {
   public static void main(String[] args) {
    TicTacToe TTTgame = new TicTacToe(3);
    String winner = TTTgame.startGame();
    System.out.println("Winner is : " + winner);
   }
    
}
