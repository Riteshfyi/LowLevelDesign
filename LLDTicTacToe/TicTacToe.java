import Model.Board;
import Model.Player;
import Model.PieceTypeO;
import Model.PieceTypeX;
import Model.PieceType;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.List;
import Model.Pair;
import java.util.ArrayDeque;


public class TicTacToe {
    Deque<Player> turn;
    Board board;
    
    public TicTacToe(int size){
        board = new Board(size);
        this.turn = new ArrayDeque();

        turn.add(new Player("Hashirama", new PieceTypeO()));
        turn.add(new Player("Madara", new PieceTypeX()));

    };

    public String startGame(){
        Boolean noWinner = true;
      while (noWinner){
        Player player = turn.removeFirst();

        
        board.printBoard();

        List<Pair<Integer,Integer>> freecells = board.getfreeCells();
       
        if(freecells.isEmpty()){
            noWinner = false;
            continue;
        }

     

        System.out.print("Player:" + player.name + " Enter row,column: ");

      
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String values[] = s.split(",");
        int inputRow = Integer.valueOf(values[0]);
        int inputColumn = Integer.valueOf(values[1]);

         

        if(!board.addPiece(inputRow, inputColumn, player.playingPiece)){
            System.out.println("Incorredt possition chosen, try again");
            turn.addFirst(player);
            continue;
        };
       
        turn.addLast(player);
        if(isThereWinner(inputRow, inputColumn, player.playingPiece.pieceType)){
            return player.name;
        }
      }
      
      return "tie";
    }
    
    public boolean isThereWinner(int row, int column, PieceType pieceType) {

        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

      
        for(int i=0;i<board.size;i++) {

            if(board.board[row][i] == null || board.board[row][i].pieceType != pieceType) {
                rowMatch = false;
            }
        }

       
        for(int i=0;i<board.size;i++) {

            if(board.board[i][column] == null || board.board[i][column].pieceType != pieceType) {
                columnMatch = false;
            }
        }

        
        for(int i=0, j=0; i<board.size;i++,j++) {
            if (board.board[i][j] == null || board.board[i][j].pieceType != pieceType) {
                diagonalMatch = false;
            }
        }

        
        for(int i=0, j=board.size-1; i<board.size;i++,j--) {
            if (board.board[i][j] == null || board.board[i][j].pieceType != pieceType) {
                antiDiagonalMatch = false;
            }
        }

        return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;
    }


}
