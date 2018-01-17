package reversiapp;


public class Piece {
    private int row;
    private int col;
    private char disk;

    /**
     * * constructor
     *
     * @param row
     *
     * @param col
     *
     */
    public Piece(int row, int col) {
        this.row = row;
        this.col = col;
        this.disk = Sign.kEmpty;
    }

    /**
     *
     * @return row number
     */
    public int getRow() {
        return this.row;
    }

    /**
     *
     * @return column number
     */
    public int getCol() {
        return this.col;
    }
    /**
     *
     * @return disk number
     */
    public char getDisk() {
        return this.disk;
    }
    /**
     * Set the disk
     *
     * @param newDisk  new disk value
     *
     */
    public void setDisk(char newDisk) {
        this.disk = newDisk;
    }

    @Override
    public String toString() {
        return Character.toString(this.disk);
    }

    /**
     *
     * @return - true if the piece id true
     */
    public boolean equals(Piece other) {
        return this.row == other.getRow() && this.col == other.getCol();
    }

    /**
     *
     * @return - String representation of the coordinate of the piece
     */
    public String toCoordinate() {
        String rowStr = String.valueOf(this.row + 1);
        String colStr = String.valueOf(this.col + 1);
        return "(" + rowStr + "," + colStr + ")";
    }
}
