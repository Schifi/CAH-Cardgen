package de.schifi.cahcardgen.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class CAHCardgen extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        initMainWindow(stage);

    }

    private void initMainWindow(Stage stage) {
        AnchorPane anchorPane;
        try {
            anchorPane = FXMLLoader.load(getClass().getResource("/MainWindow.fxml"));
            Scene scene = new Scene(anchorPane);
            stage.setTitle("CAH Card Generator");
            stage.setScene(scene);

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
