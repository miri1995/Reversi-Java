package reversiapp;

import java.util.List;

public interface Player {
    /**
     *
     * @param moves list of possible moves
     *
     * @return the place to put the piece
     */
    public Piece pickMove(List<Piece> moves);

    /**
     *
     * @return the color of the player
     */
    public char getColor();

    /**
     *
     * @return the name of the player
     */
    public String playerName();


}
