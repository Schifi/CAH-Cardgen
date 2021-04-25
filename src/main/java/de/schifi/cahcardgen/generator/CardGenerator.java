package de.schifi.cahcardgen.generator;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

import javax.imageio.ImageIO;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CardGenerator {

    private int width = 1000;
    private int height = 1000;

    private Group group;
    private Scene scene;

    Rectangle background;
    Label textLabel;
    Label packLabel;

    private File file;
    List<String> textList = new ArrayList<String>();

    public CardGenerator(File file) {
        this.file = file;
        readFileToStringList();
        initGroup();
    }

    public int generateCards() {
        int counter = 0;
        for (int i = 0; i < textList.size(); i++) {
            textLabel.setText(textList.get(i));
            saveImage(i + ".png");
            counter++;
        }
        return counter;
    }

    private void readFileToStringList() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                textList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initGroup() {
        group = new Group();
        scene = new Scene(group, 3000, 3000);

        background = new Rectangle(0, 0, 3000, 3000);
        group.getChildren().add(background);

        textLabel = new Label();
        group.getChildren().add(textLabel);
        textLabel.setLayoutX(90);
        textLabel.setLayoutY(80);
        textLabel.setMaxWidth(820);
        textLabel.setFont(new Font("Arial", 100));
        textLabel.setWrapText(true);

        packLabel = new Label();
        group.getChildren().add(packLabel);
        packLabel.setLayoutX(40);
        packLabel.setLayoutY(950);
        packLabel.setFont(new Font("Arial", 23));

        setCardType(CardType.WHITE);
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

    public void setCardType(CardType cardType) {
        switch (cardType) {
            case WHITE:
                background.setFill(Color.WHITE);
                textLabel.setTextFill(Color.BLACK);
                packLabel.setTextFill(Color.BLACK);
                break;
            case BLACK:
                background.setFill(Color.BLACK);
                textLabel.setTextFill(Color.WHITE);
                packLabel.setTextFill(Color.WHITE);
                break;
        }
    }

    public void setDeckname(String deckname) {
        packLabel.setText(deckname);
    }

    public void setWidth(int width) {
        this.width = width;
        textLabel.setMaxWidth(width - 180);
    }

    public void setHeight(int height) {
        this.height = height;
        this.packLabel.setLayoutY(height - 60);
    }

}