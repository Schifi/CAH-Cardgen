package de.schifi.cahcardgen.generator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CardGenerator {

    private List<Card> cardList;
    private List<String> readLines;
    private boolean readyToPrint;

    public CardGenerator() {
        cardList = new ArrayList<Card>();
        readLines = new ArrayList<String>();
        readyToPrint = false;
    }

    public boolean readCardFile(File cardFile) { // TODO: Implement
        readyToPrint = false;
        return readyToPrint;
    }

    public int generateCards() {
        if (readyToPrint) {
            int counter = 0;
            for (int i = 0; i < readLines.size(); i++) {

                // TODO: Print one card

                counter++;
            }
            return counter;
        } else {
            return -1;
        }
    }

}
