package de.schifi.cahcardgen.ui;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainWindow {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    private static Group group;
    private static Scene scene;
    private static Stage stage;

    public static void init() {
        group = new Group();
        scene = new Scene(group, WIDTH, HEIGHT);
        stage = new Stage();
        stage.setTitle("CAH Card Generator");
        stage.setScene(scene);
    }

    public static void show() {
        stage.show();
    }

    public static void hide() {
        stage.hide();
    }

}
