package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Initializable {

    /* @FXML
   private Button */
    @FXML
    private HBox root;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        Board board=new Board(8);


        board.setPrefWidth(400);
        board.setPrefHeight(400);
        root.getChildren().add(0,board);
        board.draw();

        root.heightProperty().addListener((observable, oldValue, newValue)->
        {board.setPrefHeight(newValue.doubleValue());board.draw();});

        root.widthProperty().addListener((observable, oldValue, newValue)->
        {board.setPrefWidth(newValue.doubleValue());board.draw();});

    }
}
