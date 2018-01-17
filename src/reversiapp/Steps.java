package reversiapp;

import java.util.ArrayList;
import java.util.List;

public class Steps implements Logic {
    private final int dx[] = { 1, 1, 0, -1, -1, -1, 0, 1 };
    private final int dy[] = { 0, 1, 1, 1, 0, -1, -1, -1 };
    private final int kNumOfDirs = 8;
    private ScoreTracker tracker;

    /**
     *  constructor
     *
     * @param tracker
     *
     *
     */
    public Steps(ScoreTracker tracker) {
        this.tracker = tracker;
    }

    @Override
    public List<Piece> getPossibleMoves(Player player, Board board) {
        List<Piece> moves = new ArrayList<Piece>();
        int size = board.getSize();
        char opponentDisk = opponentCell(player.getColor());
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Piece current = board.getPiece(i, j);
                if (current.getDisk() == Sign.kEmpty) {
                    // a possible piece to place a disk
                    if (isPossibleMove(opponentDisk, current, board)) {
                        moves.add(current);
                    }
                }
            }
        }
        return moves;
    }

    @Override
    public void flip(Player player, Piece piece, Board board) {
        char opponentDisk = opponentCell(player.getColor());
        List<Piece> flips = new ArrayList<Piece>();
        List<Piece> temp = new ArrayList<Piece>();
        int row = 0, col = 0;
        for (int i = 0; i < this.kNumOfDirs; i++) {
            row = piece.getRow();
            col = piece.getCol();
            row += this.dx[i];
            col += this.dy[i];
            // illegal piece
            if (outOfBounds(row, col, board)) {
                continue;
            }
            Piece currentCheck = board.getPiece(row, col);
            char disk = currentCheck.getDisk();
            if (disk == opponentDisk) {
                while (disk == opponentDisk) {
                    temp.add(currentCheck);
                    row += this.dx[i];
                    col += this.dy[i];
                    //not between disks.
                    if (outOfBounds(row, col, board)) {
                        break;
                    }
                    currentCheck = board.getPiece(row, col);
                    disk = currentCheck.getDisk();
                }
                if (outOfBounds(row, col, board)) {
                    temp.clear();
                    continue;
                }
                //flip the oll piece
                if (board.getPiece(row, col) .getDisk() == opponentCell(opponentDisk)) {

                    flips.addAll(temp);
                    temp.clear();
                }
                temp.clear();
            }
        }
        for (int i = 0; i < flips.size(); i++) {
            flips.get(i).setDisk(player.getColor());
        }
        tracker.updateScore(player.getColor(), flips.size());
    }

    /**
     *
     * @param opponentDisk opponent's disk
     *
     * @param piece piece to check for
     *
     * @param board
     *
     * @return - true if possible to place player's disk.
     */
    private boolean isPossibleMove(char opponentDisk, Piece piece, Board board) {
        int row = 0, col = 0;
        for (int i = 0; i < kNumOfDirs; i++) {
            // iterate through the possible directions in the 2D plain.
            row = piece.getRow();
            col = piece.getCol();
            row += dx[i];
            col += dy[i];
            // illegal piece
            if (outOfBounds(row, col, board)) {

                continue;
            }
            Piece currentCheck = board.getPiece(row, col);
            char disk = currentCheck.getDisk();
            if (disk == opponentDisk) {

                int rowCol[] = { row, col };
                if (!iterateOpponentDisks(dx[i], dy[i], rowCol, opponentDisk,
                        board)) {
                    row = rowCol[0]; // retrieve updated row val
                    col = rowCol[1]; // retrieve updated col val
                    continue;
                }
                row = rowCol[0]; // retrieve updated row val
                col = rowCol[1]; // retrieve updated col val
                if (board.getPiece(row, col)
                        .getDisk() == opponentCell(opponentDisk)) {

                    return true;
                }
            }
        }
        return false;
    }

    /**
     *
     * @param row
     *
     * @param col
     *
     * @param board
     *
     * @return - true if out of the bounds of the board.
     */
    private boolean outOfBounds(int row, int col, Board board) {
        return row < 0 || row > (board.getSize() - 1) || col < 0
                || col > (board.getSize() - 1);
    }

    /**
     *
     * @param dx  x direction
     *
     * @param dy y direction
     *
     * @param rowCol row and column numbers
     *
     * @param opponentDisk opponent's disk
     *
     * @param board
     *
     * @return - true if we iterated through the opponents disks without
     *         reaching the end of the board.
     */
    private boolean iterateOpponentDisks(int dx, int dy, int rowCol[],
                                         char opponentDisk, Board board) {
        Piece currentCheck = board.getPiece(rowCol[0], rowCol[1]);
        char disk = currentCheck.getDisk();
        while (disk == opponentDisk) {
            // iterate through the opponents disks.
            rowCol[0] += dx; // row
            rowCol[1] += dy; // col
            if (outOfBounds(rowCol[0], rowCol[1], board)) {
                // not between disks.
                return false;
            }
            currentCheck = board.getPiece(rowCol[0], rowCol[1]);
            disk = currentCheck.getDisk();
        }
        return true;
    }

    /**
     *
     * @param playerPiece a cuurent player
     *
     * @return the sign player
     */
    private char opponentCell(char playerPiece) {
        if (playerPiece == Sign.kWhites) {
            return Sign.kBlacks;
        }
        return Sign.kWhites;
    }
}
