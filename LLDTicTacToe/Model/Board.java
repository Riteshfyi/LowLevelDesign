
package Model;

import java.util.ArrayList;
import java.util.List;


public class Board {
    public int size;
    public PlayingPiece[][]board;

    public Board(int size){
       this.size = size;
       board = new PlayingPiece[size][size];
    }

    public Boolean addPiece(int row, int column, PlayingPiece playerPiece){
        if(board[row][column] != null)return false;
        board[row][column] = playerPiece;
        return true;
    }

    public List<Pair<Integer, Integer>> getfreeCells(){
        List<Pair<Integer, Integer>> freecells = new ArrayList<>();

        for(int i = 0; i < size ; i++){
            for(int j = 0 ; j < size ; j++){
                if(board[i][j] == null){
                      Pair<Integer, Integer> RC = new Pair<>(i,j);
                      freecells.add(RC);
                }
            }
        }

      
        return freecells;
    }


    public void printBoard(){
        for(int i = 0; i < size ; i++){
            for(int j = 0; j < size ; j++){
                if(board[i][j] != null)System.out.print(board[i][j].pieceType.name());
                else {System.out.print(" ");}
                System.out.print(" | ");
            }
            System.out.println();
        }
    }
    
}
