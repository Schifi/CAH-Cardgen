package de.schifi.cahcardgen.generator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.List;

public class CardScannerTest {

    private CardScanner cardScanner;

    @Before
    public void prepare() {
        cardScanner = new CardScanner();
    }

    @Test
    public void cardScannerTest_emptyFile_01() {
        List<Card> cardsRead = cardScanner.readCardFile(new File(getClass().getResource("/empty.cah").getFile()));
        assertEquals(0, cardsRead.size());
    }

    @Test
    public void cardScannerTest_simpleRules_01() {
        List<Card> cardsRead = cardScanner.readCardFile(new File(getClass().getResource("/simple_rules.cah").getFile()));
        assertEquals(10, cardsRead.size());
    }

}
