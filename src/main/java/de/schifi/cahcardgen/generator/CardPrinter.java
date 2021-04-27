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
import java.io.File;
import java.io.IOException;

public class CardPrinter {

    // JavaFX variables
    private Group group;
    private Scene scene;
    Rectangle background;
    Label textLabel;
    Label packLabel;

    public CardPrinter() {
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
    }

    private void adjustElementsForCard(Card card) {
        textLabel.setMaxWidth(card.getWidth() - 180);
        packLabel.setLayoutY(card.getHeight() - 60);

        textLabel.setText(card.getText());
        packLabel.setText(card.getPackname());

        switch (card.getCardType()) {
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

    public void printCard(Card card, String filename) {
        adjustElementsForCard(card);
        WritableImage writableImage = new WritableImage(card.getWidth(), card.getHeight());
        scene.snapshot(writableImage);
        File file = new File(filename);
        try {
            ImageIO.write(SwingFXUtils.fromFXImage(writableImage, null), "png", file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
