package sample;

import java.util.Vector;

public class Player {
    private Board b;
    private char player_x;
    private char player_o;
    private Steps s1;
    private DisplayScreen image;


    public Player(Board b, Steps s1, DisplayScreen image) {
        this.b = b;
        player_x = 'x';
        player_o = 'o';
        this.s1 = s1;
        this.image = image;
    }


   /* public Boolean checkInput(Piece piece, Vector<Piece> vec) {

        int counter = 0;
        for (int i = 0; i < vec.size(); i++) {
            if (piece.getRow() == vec.elementAt(i).getRow() && piece.getCol() == vec.elementAt(i).getCol()) {
                counter++;
            }
        }
        if (counter >= 1) {
            return true;
        }
        if (counter == 0) {
            return false;
        }

    }*/






    public int counter(char player){
        int counter=0;
        for(int i=1;i<= b.getRowBoard();i++){
            for(int j=1;j<= b.getColBoard();j++){
                if(this.b.getBoard()[i][j]==player){
                    counter++;
                }
            }
        }
        return counter;
    }



 /*   public String winner(){
        if(counter(player_x)>counter(player_o)){
            image.winner(player_x,false,counter(player_x),counter(player_o));
            return "x is the winner!";
        }
        else if(counter(player_x)<counter(player_o)){
            image.winner(player_o,false,counter(player_x),counter(player_o));
            return "o is the winner!";
        }
        else {
            image.winner(' ',true,counter(player_x),counter(player_o));
            return "Is a draw";
        }
    }*/



   public char getPlayerO(){
        return player_o;
    }

    public char  getPlayerX(){
        return player_x;
    }
}
