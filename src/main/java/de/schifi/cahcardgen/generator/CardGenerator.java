package de.schifi.cahcardgen.generator;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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
    }

    public int generateCards() {
        int counter = 0;
        for (int i = 0; i < textList.size(); i++) {
            textLabel.setText(textList.get(i));
            //saveImage(i + ".png"); TODO: Send to printer
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
