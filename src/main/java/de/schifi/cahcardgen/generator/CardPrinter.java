package de.schifi.cahcardgen.generator;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

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

    public void printCard(Card card) {
        // TODO: Printing card to image file ...
        /*WritableImage writableImage = new WritableImage(width, height);
        scene.snapshot(writableImage);
        File file = new File(filename);
        try {
            ImageIO.write(SwingFXUtils.fromFXImage(writableImage, null), "png", file);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

}
