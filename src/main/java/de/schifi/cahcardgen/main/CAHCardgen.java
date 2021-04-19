package de.schifi.cahcardgen.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class CAHCardgen extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/MainWindow.fxml"));
        Scene scene = new Scene(anchorPane);
        stage.setTitle("CAH Card Generator");
        stage.setScene(scene);

        stage.show();

    }
}
