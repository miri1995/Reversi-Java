package reversiapp;

import java.util.List;

public interface Logic {
    /**
     *
     * @param player the player that played and to find him the possible moves
     *
     * @param board
     *
     * @return - a List of possible moves.
     */
    public List<Piece> getPossibleMoves(Player player, Board board);

    /**
     *
     * @param player the player that to flip the pieces for
     *
     * @param piece the piece to flip
     *
     * @param board
     *
     */
    public void flip(Player player, Piece piece, Board board);
}
