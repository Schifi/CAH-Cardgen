package de.schifi.cahcardgen.main;

import de.schifi.cahcardgen.ui.MainWindow;
import javafx.application.Application;
import javafx.stage.Stage;

public class CAHCardgen extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        MainWindow.init();
        MainWindow.show();
    }
}
