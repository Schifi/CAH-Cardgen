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
        assertEquals(CardType.WHITE, cardsRead.get(0).getCardType());
        assertEquals("One", cardsRead.get(0).getText());
        assertEquals(CardType.WHITE, cardsRead.get(1).getCardType());
        assertEquals("Two", cardsRead.get(1).getText());
        assertEquals(CardType.WHITE, cardsRead.get(2).getCardType());
        assertEquals("Three", cardsRead.get(2).getText());
        assertEquals(CardType.WHITE, cardsRead.get(3).getCardType());
        assertEquals("Four", cardsRead.get(3).getText());
        assertEquals(CardType.WHITE, cardsRead.get(4).getCardType());
        assertEquals("Five", cardsRead.get(4).getText());
        assertEquals(CardType.BLACK, cardsRead.get(5).getCardType());
        assertEquals("Apple", cardsRead.get(5).getText());
        assertEquals(CardType.BLACK, cardsRead.get(6).getCardType());
        assertEquals("Banana", cardsRead.get(6).getText());
        assertEquals(CardType.BLACK, cardsRead.get(7).getCardType());
        assertEquals("Cherry", cardsRead.get(7).getText());
        assertEquals(CardType.BLACK, cardsRead.get(8).getCardType());
        assertEquals("Dragon Fruit", cardsRead.get(8).getText());
        assertEquals(CardType.BLACK, cardsRead.get(9).getCardType());
        assertEquals("Elderberry", cardsRead.get(9).getText());
    }

}
