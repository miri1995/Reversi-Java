package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;


import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class Board extends GridPane {
 //   private static final char player_o='o';
  //  private static final char player_x='x';
   // private static final char empty=' ';
    private char board [][];
    private int row, col;
    private int size;
    private GameController control;


    public Board(int size) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("game.fxml" ));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        Stage primaryStage=new Stage();
        primaryStage.setScene(new Scene(this, 600, 275));
    try{
        fxmlLoader.load();
    }catch(Exception e){

    }
         primaryStage.show();
        this.size = size;
        row = size;
        col = size;
        this.board = new char [size+1][size+1];
        for (int i = 0; i <= row; i++) {
            this.board[i] = new char[size+1];
        }

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                board[i][j] ='p';

            }
        }


        board[size / 2][(size / 2) + 1] = 'x';
        board[(size / 2) + 1][size / 2] = 'x';
        board[size / 2][size / 2] = 'o';
        board[(size / 2) + 1][(size / 2) + 1] = 'o';

      /*  FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sample.fxml " ));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        }
        catch (IOException exception) {
            throw new RuntimeException(exception);
        }*/



    }



    public void  initializeBoard()

    {
        for (int i = 1; i <= row; i++) {

            for (int j = 1; j <= col; j++) {
              /*  if (board[i][j] == Sign.x) {
                    board[i][j] = 'x';
                } else if (board[i][j] == Sign.o) {
                    board[i][j] = 'o';
                } else if (board[i][j] == Sign.empty) {
                    board[i][j] = ' ';
                }*/
            }
        }
    }

    public void draw() {
        this.getChildren().clear();
        int height = (int) this.getPrefHeight();
        int width = (int) this.getPrefWidth();
        int cellHeight = height / board.length;
        int cellWidth = width / board[0].length;
        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[i].length; j++) {
                if (board[i][j] == 'p') {
                    this.add(new Rectangle(cellWidth, cellHeight, Color.PINK), j, i);
                    System.out.println(board[i][j]);
                } else if (board[i][j] == 'x'){
                    this.add(new Circle(cellWidth, cellHeight, 20, Color.BLACK), j, i);
                System.out.println(board[i][j]);
            }
                else if (board[i][j] == 'o') {
                    this.add(new Circle(cellWidth, cellHeight, 20, Color.WHITE), j, i);
                    System.out.println(board[i][j]);
                }
                else{
                    System.out.println(board[i][j]);
                }

            }
        }
    }


    public char[][] getBoard() {

            return board;

    }

    public int getRowBoard()
    {
        return this.row;
    }

    public int getColBoard() {
        return this.col;
    }




 /*   public Board(Board boardCopy) {
        player_o = boardCopy.player_o;
        player_x = boardCopy.player_x;
        row = boardCopy.row;
        col = boardCopy.col;
        size = boardCopy.size;
        board = new char[size + 1][size + 1];
        for (int i = 0; i <= row; i++) {
            board[i] = new char[row + 1];
        }
        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= col; j++) {
                board[i][j] = boardCopy.board[i][j];
            }
        }
    }

    public Board equal(Board b)
    {
        if (this !=  b) {
        }

        player_o = b.player_o;
        player_x = b.player_x;
        row = b.row;
        col = b.col;
        size = b.size;
        board = new char [size + 1][size + 1];
        for (int i = 0; i <= row; i++) {
            this.board[i] = new char[row + 1];
        }
        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= col; j++) {
                this.board[i][j] = b.board[i][j];
            }
        }
        return this;
    }*/

}