package sample;

import com.sun.scenario.Settings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class SettingsController{
    ObservableList<String> colors = FXCollections.observableArrayList("BLACK","WHITE","BLUE","RED");
    ObservableList<String> players= FXCollections.observableArrayList("X","O");
    ObservableList<String> boardSizes= FXCollections.observableArrayList("4","6","8","10","12","14","16","18","20");

    @FXML
    private ComboBox player;
   @FXML
    private ComboBox boardSize;
    @FXML
    private ComboBox colorPlayer1;
    @FXML
    private ComboBox colorPlayer2;
    @FXML
    private Button okButton;




//TODO FUNC OK

    @FXML
    private void initialize(){

        colorPlayer1.setValue("BLACK");
        colorPlayer1.setItems(colors);
        colorPlayer2.setValue("WHITE");
        colorPlayer2.setItems(colors);
        player.setValue("X");
        player.setItems(players);
        boardSize.setValue("8");
        boardSize.setItems(boardSizes);

    }
    @FXML
    protected  void ok() throws IOException{
      String firstPlayer = player.getValue().toString();
      String colorFirstPlayer = colorPlayer1.getValue().toString();
      String colorSecondPlayer = colorPlayer2.getValue().toString();
     int size = Integer.parseInt(boardSize.getValue().toString());
      //writeToFile("settingsFile.txt");

        PrintWriter bufferedWriter=null;
        try { bufferedWriter = new PrintWriter(new OutputStreamWriter(
                new FileOutputStream("Settings.txt")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }

       bufferedWriter.write(String.valueOf(player.getValue()));
        bufferedWriter.write(String.valueOf(colorPlayer1.getValue()));
        bufferedWriter.write(String.valueOf(colorPlayer2.getValue()));
        bufferedWriter.write(String.valueOf(Integer.parseInt(boardSize.getValue().toString())));
        bufferedWriter.close();
        Stage primaryStage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Reversi-Menu");
        primaryStage.setScene(new Scene(root, 600, 275));
        primaryStage.show();


    }

 /*  private void writeToFile(String fileName) throws IOException {



    }*/
}

