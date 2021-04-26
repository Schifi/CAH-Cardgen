package de.schifi.cahcardgen.generator;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CardScanner {

    private FileReader fileReader;
    private BufferedReader bufferedReader;

    private List<String> linesRead;

    // Card attributes if no other is specified or if standard is set
    private int standardWidth;
    private int standardHeight;
    CardType standardCardType;
    String standardPackname;

    public CardScanner() {
        linesRead = new ArrayList<String>();

        // Setting the starting standards
        standardWidth = 1000;
        standardHeight = 1000;
        standardCardType = CardType.WHITE;
        standardPackname = "";
    }

    public List<Card> readCardFile(File cardFile) {
        // Reading the file
        try {
            this.fileReader = new FileReader(cardFile);
            this.bufferedReader = new BufferedReader(fileReader);
            String nextLine;
            while ((nextLine = bufferedReader.readLine()) != null) {
                linesRead.add(nextLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Creating the cards
        List<Card> cardsRead = new ArrayList<Card>();
        for (int i = 0; i < linesRead.size(); i++) {
            String newCardLine = linesRead.get(i);
            Card newCard = lineToCard(newCardLine);
            if (newCard != null) {
                cardsRead.add(newCard);
            }
        }
        return cardsRead;
    }

    private Card lineToCard(String line) {
        // Check for comment line
        if (line.startsWith("#")) {
            return null;
        }

        // Check for empty lines
        if (line.isEmpty()) {
            return null;
        }

        // Check for instructions
        if (line.startsWith("!")) {
            line = line.substring(1);
            if (line.startsWith("COLOR=")) { // Change the card type
                line = line.substring(6);
                if (line.equals("WHITE")) {
                    standardCardType = CardType.WHITE;
                } else if (line.equals("BLACK")) {
                    standardCardType = CardType.BLACK;
                } else {
                    System.out.println("Error while reading .cah-file!"); // TODO: Change to exception
                }
            } else if (line.startsWith("WIDTH=")) { // Change the standard width
                line = line.substring(6);
                try {
                    int newStandardWidth = Integer.parseInt(line);
                    standardWidth = newStandardWidth;
                } catch (NumberFormatException e) {
                    System.out.println("Error while reading .cah-file!"); // TODO: Change to exception
                }
            } else if(line.startsWith("HEIGHT=")) { // Change the standard height
                line = line.substring(7);
                try {
                    int newStandardHeight = Integer.parseInt(line);
                    standardHeight = newStandardHeight;
                } catch (NumberFormatException e) {
                    System.out.println("Error while reading .cah-file!"); // TODO: Change to exception
                }
            } else if(line.startsWith("PACKNAME=")) { // Change the standard pack name
                line = line.substring(9);
                standardPackname = line;
            } else {
                System.out.println("Error while reading .cah-file!"); // TODO: Change to exception
            }
            return null;
        }

        // Card line
        Card newCard = new Card();
        newCard.setText(line);
        newCard.setCardType(standardCardType);
        newCard.setWidth(standardWidth);
        newCard.setHeight(standardHeight);
        newCard.setPackname(standardPackname);
        return newCard;
    }

}
