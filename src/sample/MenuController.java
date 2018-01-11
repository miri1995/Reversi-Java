package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javax.xml.soap.Text;
import java.awt.*;
import java.io.IOException;

import javafx.scene.control.Button;



public class MenuController {
    private GridPane gridPane;
    @FXML
    private Text messageText;
    @FXML
    private Button startButton;
    @FXML
    private Button Settings;
    @FXML
    private Button QuitButton;


    @FXML
    protected void startGame()throws IOException{
        Board gameController=new Board(8);

      /* Stage primaryStage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("game.fxml"));
        primaryStage.setTitle("Reversi");
        primaryStage.setScene(new Scene(root, 600, 275));
        primaryStage.show();*/
    }
    @FXML
    protected void settings() throws IOException {
        Stage primaryStage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("settings.fxml"));
        primaryStage.setTitle("Settings");
        primaryStage.setScene(new Scene(root, 600, 275));
        primaryStage.show();
    }

}


/*  try{
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("startGame.xml"));
        Parent root = fxmlLoader.load();
        Stage stage=new Stage();
        stage.setTitle("Reversi-Menu");
        stage.setScene(new Scene(root, 300, 275));
        stage.show();
        }catch (Exception e){
          //  throw "error";

       }*/


/* Settings settings= new Settings();
        Stage stage =(Stage) Settings.getScene().getWindow();
        try{
            settings.start(stage);
        }catch (Exception e){
            System.out.println("we hate you gui");
        }*/