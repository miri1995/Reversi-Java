package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import reversiapp.*;
import settings_io.SettingsReader;
import settings_io.Enum;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class ReversiGameController implements Initializable {
    private GameSettings gameSettings;
    private Logic logic;
    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private GuiBoard reversiBoard;
    private ScoreTracker scoreTracker;

    @FXML
    private HBox root;
    @FXML
    private Label playerTurn;
    @FXML
    private Label player1Score;
    @FXML
    private Label player2Score;

    /**
     * C'tor.
      */
    public ReversiGameController () {
        this.gameSettings = SettingsReader.readFile();
        this.player1 = new PlayerHuman(Sign.kBlacks);
        this.player2 = new PlayerHuman(Sign.kWhites);
        if (this.gameSettings.getStartingPlayer() == Enum.BLACK) {
            currentPlayer = this.player1;
        } else {
            currentPlayer = this.player2;
        }
        this.board = new Board(gameSettings.getBoardSize());
        this.scoreTracker = new ScoreTracker();
        this.logic = new Steps(this.scoreTracker);
        this.reversiBoard = new GuiBoard(board);
    }

    @Override
    /**
     *updates the board according to the game developments.
     * @param location
     * @param resources.
     */
    public void initialize(URL location, ResourceBundle resources) {
        playerTurn.setText("Current Player: " + currentPlayer.playerName());//writes the current player name.
        player1Score.setText("First Player Score: " + scoreTracker.getPlayer1Score());
        player2Score.setText("Second Player Score: " + scoreTracker.getPlayer2Score());//updates the scores of the players.
        this.reversiBoard.setPrefWidth(400);
        this.reversiBoard.setPrefHeight(400);
        root.getChildren().add(0, reversiBoard);
        root.widthProperty().addListener((observable, oldValue, newValue) -> {
            double boardNewWidth = newValue.doubleValue() - 180;
            reversiBoard.setPrefWidth(boardNewWidth);
            reversiBoard.draw();
        });
        root.heightProperty().addListener((observable, oldValue, newValue) -> {
            reversiBoard.setPrefHeight(newValue.doubleValue());
            reversiBoard.draw();
        });
        reversiBoard.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            Piece picked = reversiBoard.clicked(event);
            event.consume();
            if(this.playTurn(currentPlayer, picked)) {
                updatePlayer();//update the board.
            }
        });
    }

    /**
     * plays a turn.
     * @param player - current player.
     * @param picked - a piece picked by the player.
     * @return - true if the player has moves and the
     * piece wasn't flipped.
     */
    private boolean playTurn(Player player, Piece picked) {
        List<Piece> moves = logic.getPossibleMoves(player, this.board);
        if (moves.size() == 0) {
            // text warning
            return true;
        }
        for(Piece move : moves) {
            // sets the disks as flip potential.
            board.getPiece(move.getRow(), move.getCol()).setDisk(Sign.kToFlip);
        }

        if (moves.size() == 0) {
            // text warning
            return true;
        }
        for(Piece move : moves) {
            // sets the disks back to empty
            board.getPiece(move.getRow(), move.getCol()).setDisk(Sign.kEmpty);
        }
        if(cellValidity(picked, moves)) {
            Piece changedPiece = board.getPiece(picked.getRow(), picked.getCol());
            changedPiece.setDisk(player.getColor());
            logic.flip(player, changedPiece, this.board);
            this.reDraw();
            return true;
        }
        return false;

    }
    /**
     * @param piece - a chosen piece.
     * @param moves - a list of possible moves.
     * @return - true if the chosen piece is valid.
     */
    private boolean cellValidity(Piece piece, List<Piece> moves) {
        for(Piece move : moves) {
            if(piece.equals(move)) {
                return true;
            }
        }
        return false;
    }

    private void reDraw() {
        reversiBoard.draw();
    }//draws the board again.
    /**
     *updates the players on board and their scores.
     */
    public void updatePlayer() {
        if(currentPlayer.getColor() == this.player1.getColor()) {
            this.currentPlayer = this.player2;
        } else if(currentPlayer.getColor() == this.player2.getColor()) {
            this.currentPlayer = this.player1;
        }
        playerTurn.setText("Current Player: " + currentPlayer.playerName());
        player1Score.setText("First Player Score:" + scoreTracker.getPlayer1Score());
        player2Score.setText("Second Player Score:" + scoreTracker.getPlayer2Score());
    }
    @FXML
    /**
     *show the moves of the player.
     * @param event - a mouse click event.
     */
    protected void showMoves(ActionEvent event) {
        List<Piece> moves = logic.getPossibleMoves(currentPlayer, this.board);
        if (moves.size() == 0) {
            // text warning
        }
        for(Piece move : moves) {
            // sets the disks as flip potential.
            board.getPiece(move.getRow(), move.getCol()).setDisk(Sign.kToFlip);
        }
        this.reDraw();
        for(Piece move : moves) {
            // sets the disks back to empty
            board.getPiece(move.getRow(), move.getCol()).setDisk(Sign.kEmpty);
        }
    }
}