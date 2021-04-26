package de.schifi.cahcardgen.generator;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CardScanner {

    private FileReader fileReader;
    private BufferedReader bufferedReader;

    private List<String> linesRead;

    // Card attributes if no other is specified or if standard is set
    CardType lastCardType;
    String lastPackname;

    public CardScanner() {
        linesRead = new ArrayList<String>();
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

    private Card lineToCard(String line) { // TODO: Implement - this is where the magic happens
        // Check for comment line
        if (line.startsWith("#")) {
            System.out.println("COMMENT!");
            return null;
        }

        // Check for empty lines
        if (line.isEmpty()) {
            System.out.println("EMPTY!");
            return null;
        }

        // Check for instructions
        if (line.startsWith("!")) {
            System.out.println("INSTRUCTION!");
            return null;
        }

        System.out.println("CARD!");
        return new Card();
    }

}
