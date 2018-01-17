package reversiapp;


public class ScoreTracker {
    private int player1Score;
    private int player2Score;

    /**
     * constructor
     *
     */
    public ScoreTracker() {
        player1Score = 2;
        player2Score = 2;
    }

    /**
     *
     * @param color the color of the player
     *
     * @param pieceFlipped
     *
     */
    public void updateScore(char color, int pieceFlipped) {
        if (color == Sign.kBlacks) {
            player1Score += pieceFlipped + 1;
            player2Score -= pieceFlipped;
        } else if (color == Sign.kWhites) {
            player2Score += pieceFlipped + 1;
            player1Score -= pieceFlipped;
        }
    }

    /**
     *
     * @return the score of player 1
     */
    public int getPlayer1Score() {
        return player1Score;
    }

    /**
     *
     * @return the score of player 2
     */
    public int getPlayer2Score() {
        return player2Score;
    }
}
