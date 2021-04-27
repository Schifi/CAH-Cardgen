package de.schifi.cahcardgen.generator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CardGenerator {

    private List<Card> cardList;
    private boolean readyToPrint;

    public CardGenerator() {
        cardList = new ArrayList<Card>();
        readyToPrint = false;
    }

    public boolean readCardFile(File cardFile) {
        CardScanner cardScanner = new CardScanner();
        cardList = cardScanner.readCardFile(cardFile); // TODO: Catch potential CardFileException
        readyToPrint = true; // TODO: Set false if CardFileException is thrown
        return readyToPrint;
    }

    public int generateCards() {
        if (readyToPrint) {
            CardPrinter cardPrinter = new CardPrinter();
            int counter = 0;
            for (int i = 0; i < cardList.size(); i++) {
                cardPrinter.printCard(cardList.get(i), i + ".png");
                counter = i;
            }
            return counter;
        } else {
            return -1;
        }
    }

}
