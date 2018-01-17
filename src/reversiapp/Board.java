package reversiapp;

public class Board {
    private Piece[][] board;
    private int size;

    /**
     * constructor
     *
     */
    public Board() {
        this.size = Sign.kSize;
        this.initBoard();
    }

    /**
     * constructor
     *
     * @param newSize size of the board
     *
     */
    public Board(int newSize) {
        size = newSize;
        this.initBoard();
    }

    /**
     * initializes the board
     */
    private void initBoard() {
        //initialize the board
        this.board = new Piece[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.board[i][j] = new Piece(i, j);
            }
        }
        //initialize the players
        int mid = (size / 2) - 1;
        int roofMid = (size / 2);
        this.board[mid][mid].setDisk(Sign.kWhites);
        this.board[roofMid][roofMid].setDisk(Sign.kWhites);
        this.board[mid][roofMid].setDisk(Sign.kBlacks);
        this.board[roofMid][mid].setDisk(Sign.kBlacks);
    }

    /**
     *The function return the size of the board
     * @return size of the board
     */
    public int getSize() {
        return this.size;
    }

    /**
     *
     * @param row
     *
     * @param col
     *
     * @return the piece in the corresponding location, null if out of bounds.
     */
    public Piece getPiece(int row, int col) {
        if (row > this.size || col > this.size || row < 0 || col < 0) {
            return null;
        }
        return this.board[row][col];
    }
}
