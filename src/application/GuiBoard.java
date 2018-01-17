package application;

import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import reversiapp.Board;
import reversiapp.Piece;
import reversiapp.Sign;
import reversiapp.GameSettings;
import settings_io.SettingsReader;

import java.io.IOException;
/**
 * C'tor.
 */
public class GuiBoard extends GridPane {
    private Board board;
    private int height;
    private int width;
    private GameSettings gameSettings;

    public GuiBoard(Board board) {
        this.board = board;
        this.gameSettings = SettingsReader.readFile();
        FXMLLoader fxmlLoader = new
                FXMLLoader(getClass().getResource("reversiBoard.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
    /**
     * draws the board of the game.
     */
    public void draw() {
        this.getChildren().clear();
        this.height = (int) this.getPrefHeight();
        this.width = (int) this.getPrefWidth();
        int cellHeight = height / board.getSize();
        int cellWidth = width / board.getSize();
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                Rectangle rect = new Rectangle(cellWidth, cellHeight, Color.rgb(149,52,157));
                rect.setStroke(Color.rgb(56,22,149));
                this.add(rect, j, i);//the board is made of rectangles.
                if (this.board.getPiece(i,j).getDisk() == Sign.kBlacks) {
                    Circle disk = new Circle(Math.min(cellWidth,cellHeight) /2, gameSettings.getPlayer1Color());
                    this.add(disk,j,i);// draws the discs of the first player.
                } else if (this.board.getPiece(i,j).getDisk() == Sign.kWhites) {
                    Circle disk = new Circle(Math.min(cellWidth,cellHeight) /2, gameSettings.getPlayer2Color());
                    this.add(disk,j,i);// draws the discs of the second player.
                } else if (this.board.getPiece(i, j).getDisk() == Sign.kToFlip) {
                    Circle disk = new Circle(Math.min(cellWidth,cellHeight) /2, Color.TRANSPARENT);
                    disk.setStroke(Color.BLACK);
                    this.add(disk, j, i);//draws the player's options for moves.
                }
            }
        }

    }

    /**
     * calculates the piece that was chose by the player.
     * @param event - a mouse click event.
     * @return - piece on the board.
     */
    public Piece clicked(MouseEvent event) {
        double x =  event.getX();
        double y =  event.getY();
        double cellHeight =  (this.getPrefHeight() / board.getSize());
        double cellWidth =  ((this.getPrefWidth() + 10)  / board.getSize());
        int i = (int)(x / cellWidth);
        int j = (int)(y / cellHeight);
        return new Piece(j, i);
    }
}