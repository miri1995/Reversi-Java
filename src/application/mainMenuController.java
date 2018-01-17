package application;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class mainMenuController {

    @FXML
    /**
     *in charge on the gui that opens after the user clicked play.
     * @param event - a mouse click event.
     */
    protected void play(javafx.event.ActionEvent event){
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("reversiGame.fxml"));
            Scene scene = new Scene(parent,720,600);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Reversi game");
            stage.setScene(scene);
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    /**
     *in charge on the gui that opens after the user clicked settings.
     * @param event - a mouse click event.
     */
    protected void settings(javafx.event.ActionEvent event) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("settings.fxml"));
            Scene scene = new Scene(parent,426,640);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            stage.setTitle("Settings");
            stage.setScene(scene);
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    /**
     *in charge to exit gui after the player clicked exit.
     * @param event - a mouse click event.
     */
    protected void exit(javafx.event.ActionEvent event) {
       Platform.exit();
    }
}