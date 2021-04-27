package de.schifi.cahcardgen.generator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import java.io.File;
import java.util.List;

public class CardScannerTest {

    @Rule
    public final TestRule testWatcher = new TestMessages();

    private CardScanner cardScanner;

    @Before
    public void prepare() {
        cardScanner = new CardScanner();
    }

    /**
     * Converting 'cardScannerTest_01.cah' to cards.
     * This file is empty, there should be no cards generated.
     */
    @Test
    public void cardScannerTest_01() {
        List<Card> cardsRead = cardScanner.readCardFile(new File(getClass().getResource("/cardScannerTest_01.cah").getFile()));
        assertTrue(cardsRead.isEmpty());
    }

    /**
     * Converting 'cardScannerTest_02.cah' to cards.
     * There are plenty of comments, 5 white cards should be generated.
     */
    @Test
    public void cardScannerTest_02() {
        List<Card> cardsRead = cardScanner.readCardFile(new File(getClass().getResource("/cardScannerTest_02.cah").getFile()));
        assertEquals(5, cardsRead.size());
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
    }

    /**
     * Converting 'cardScannerTest_03.cah' to cards.
     * 5 white cards followed by 5 black cards should be generated.
     */
    @Test
    public void cardScannerTest_03() {
        List<Card> cardsRead = cardScanner.readCardFile(new File(getClass().getResource("/cardScannerTest_03.cah").getFile()));
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

    @Test
    public void isCommentLineTest_01() {
        String testLine = "# This is a comment.";
        assertTrue(cardScanner.isCommentLine(testLine));
    }

    @Test
    public void isCommentLineTest_02() {
        String testLine = "#This is a comment.";
        assertTrue(cardScanner.isCommentLine(testLine));
    }

    @Test
    public void isCommentLineTest_03() {
        String testLine = "          # This is a comment.";
        assertTrue(cardScanner.isCommentLine(testLine));
    }

    @Test
    public void isCommentLineTest_04() {
        String testLine = "          #This is a comment.";
        assertTrue(cardScanner.isCommentLine(testLine));
    }

    @Test
    public void isCommentLineTest_05() {
        String testLine = "This is no comment.";
        assertFalse(cardScanner.isCommentLine(testLine));
    }

    @Test
    public void isCommentLineTest_06() {
        String testLine = "     This is no comment.";
        assertFalse(cardScanner.isCommentLine(testLine));
    }

    @Test
    public void isCommentLineTest_07() {
        String testLine = "";
        assertFalse(cardScanner.isCommentLine(testLine));
    }

    @Test
    public void isCommentLineTest_08() {
        String testLine = "     ";
        assertFalse(cardScanner.isCommentLine(testLine));
    }

    @Test
    public void removeCommentFromCardLineTest_01() {
        String testLine = "Cardtext # This is a comment.";
        testLine = cardScanner.removeCommentFromCardLine(testLine);
        assertEquals("Cardtext", testLine);
    }

    @Test
    public void removeCommentFromCardLineTest_02() {
        String testLine = "Cardtext# This is a comment.";
        testLine = cardScanner.removeCommentFromCardLine(testLine);
        assertEquals("Cardtext", testLine);
    }

    @Test
    public void removeCommentFromCardLineTest_03() {
        String testLine = "Cardtext#This is a comment.";
        testLine = cardScanner.removeCommentFromCardLine(testLine);
        assertEquals("Cardtext", testLine);
    }

    @Test
    public void removeCommentFromCardLineTest_04() {
        String testLine = "Cardtext ## This is a comment. ## This is a comment.";
        testLine = cardScanner.removeCommentFromCardLine(testLine);
        assertEquals("Cardtext", testLine);
    }

    @Test
    public void removeCommentFromCardLineTest_05() {
        String testLine = "Cardtext#";
        testLine = cardScanner.removeCommentFromCardLine(testLine);
        assertEquals("Cardtext", testLine);
    }

}
