package sample;

import java.util.Vector;

public class DisplayScreen {
    private Board board;

    public DisplayScreen(Board board) {
        this.board = board;
    }
}

  /*  public void printBoard() {
        for (int i = 1; i <= board -> getRowBoard(); i++) {
            System.out.print(" | ");
            System.out.print(i);

        }
        System.out.println(" |");

        for (int i = 1; i <= board -> getRowBoard() * 4.5; i++) {
            System.out.println("-") ;
        }

        for (int i = 1; i <= board -> getRowBoard(); i++) {
            System.out.println(); << i << "| ";
            for (int j = 1; j <= board -> getColBoard(); j++) {

                cout << board -> getBoard()[i][j] << " | ";
            }
            cout << endl;
            for (int i = 1; i <= board -> getRowBoard() * 4.5; i++) {
                cout << "-";
            }
            cout << endl;
        }
    }*/

 /*   public int printOptions(Vector<Piece> vec) {
        if (vec.isEmpty()) {
            return 0;
        } else {
            System.out.println("Your possible moves: ");
            for (int i = 1; i < vec.size(); i++) {
                for (int j = i + 1; j < vec.size(); j++) {
                    if (vec.get(i).getRow() == vec.get(j).getRow() && vec.get(j).getCol() == vec.get(i).getCol()) {
                        vec.remove(i);
                    }
                }
                // vec2.push_back(vec.at(i));
                System.out.println( "(" ,vec.elementAt(i).getRow() , "," ,vec.elementAt(i).getCol(), ")");
            }
            // vec2.push_back(vec.at(0));
            System.out.println( "(", vec.get(0).getRow(), "," ,vec.get(0).getCol() ,")");
            return 1;
        }

    }

    public void printWhoQueue(char player) {
        System.out.println << player << ": It`s your move." << endl;
    }

    public void choiceNoOption() {
        cout << "Your choice is'nt an options.Choose move from the list." << endl;
    }

    public void noMove() {
        cout << "No possible moves." << endl;
        cout << endl;
    }

    public void winner(char player, bool draw, int scoreX, int scoreO) {
        cout << "x the score is: " << scoreX << endl;
        cout << "o the score is: " << scoreO << endl;
        cout << endl;
        if (draw == false) {
            cout << player << " is the winner!" << endl;
        } else {
            cout << "Is a draw" << endl;
        }
    }

}*/
