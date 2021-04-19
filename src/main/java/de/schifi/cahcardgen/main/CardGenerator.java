package de.schifi.cahcardgen.main;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CardGenerator {

    private final int width = 1000;
    private final int height = 1000;

    private Group group;
    private Scene scene;
    private Stage stage;

    Label textLabel;
    Label packLabel;

    private File file;
    List<String> textList = new ArrayList<String>();

    public CardGenerator(File file) {
        this.file = file;
        readFileToStringList();
        initGroup();
    }

    public void generateCards() {
        for (int i = 0; i < textList.size(); i++) {
            textLabel.setText(textList.get(i));
            saveImage(i + ".png");
        }
    }

    private void readFileToStringList() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                textList.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initGroup() {
        group = new Group();
        scene = new Scene(group, width, height);

        textLabel = new Label();
        group.getChildren().add(textLabel);
        textLabel.setLayoutX(90);
        textLabel.setLayoutY(80);
        textLabel.setMaxWidth(820);
        textLabel.setFont(new Font("Arial", 100));
        textLabel.setTextFill(Color.BLACK);
        textLabel.setWrapText(true);

        packLabel = new Label();
        group.getChildren().add(packLabel);
        packLabel.setLayoutX(40);
        packLabel.setLayoutY(950);
        packLabel.setFont(new Font("Arial", 23));
        packLabel.setTextFill(Color.BLACK);
    }

    private void saveImage(String filename) {
        WritableImage writableImage = new WritableImage(width, height);
        scene.snapshot(writableImage);
        File file = new File(filename);
        try {
            ImageIO.write(SwingFXUtils.fromFXImage(writableImage, null), "png", file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
