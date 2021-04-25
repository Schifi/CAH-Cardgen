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

    public void setFile(File cardFile) {
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
    }

    public List<Card> readCardFile(File cardFile) {
        List<Card> cardsRead = new ArrayList<Card>();

        for (int i = 0; i < linesRead.size(); i++) {
            String newCardLine = linesRead.get(i);
            Card newCard = lineToCard(newCardLine);
            cardsRead.add(newCard);
        }

        return cardsRead;
    }

    private Card lineToCard(String line) { // TODO: Implement - this is where the magic happens
        Card card = new Card();
        return card;
    }

}
