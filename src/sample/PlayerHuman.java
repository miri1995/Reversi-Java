package sample;

public class PlayerHuman {

    private Board board;
   public PlayerHuman(Board board){
        this.board=board;
    }


 /*   public int playOneTurn(char player,Player player1, Steps steps, int flag){
        DisplayScreen displayScreen=new DisplayScreen(this.board);
        Boolean choice;
        Piece piece(0, 0);
        displayScreen.printWhoQueue(player);
        steps.optionsToLocate(player);
        int ans = displayScreen.printOptions(steps.getVec());
        if (ans == 1) {
            piece = player1.chosenMove();
            choice = player1.checkInput(piece, steps.getVec());
            while (!choice) {// if the player chose something that isn't among the options.
                displayScreen.choiceNoOption();
                displayScreen.printOptions(steps.getVec());
                piece = player1.chosenMove();
                choice = player1.checkInput(piece, steps.getVec());
            }
            steps.flip(piece, player);
            board.initializeBoard();
            displayScreen.printBoard();
            steps.clearVec();

        } else {
            displayScreen.noMove();// if the player has no moves.
            flag++;
        }
        return flag;
    }*/
}
