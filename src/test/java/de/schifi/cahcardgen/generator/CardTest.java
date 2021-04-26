package de.schifi.cahcardgen.generator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CardTest {

    private Card card;

    @Before
    public void prepare() {
        card = new Card();
    }

    @Test
    public void dummyCardTest_01() {
        card.setHeight(700);
        assertEquals(700, card.getHeight());
    }

    @Test
    public void cardTest_01() {
        card.setWidth(299);
        assertEquals(300, card.getWidth());
    }

    @Test
    public void cardTest_02() {
        card.setWidth(300);
        assertEquals(300, card.getWidth());
    }

    @Test
    public void cardTest_03() {
        card.setWidth(3000);
        assertEquals(3000, card.getWidth());
    }

    @Test
    public void cardTest_04() {
        card.setWidth(3001);
        assertEquals(3000, card.getWidth());
    }

    @Test
    public void cardTest_05() {
        card.setHeight(299);
        assertEquals(300, card.getHeight());
    }

    @Test
    public void cardTest_06() {
        card.setHeight(300);
        assertEquals(300, card.getHeight());
    }

    @Test
    public void cardTest_07() {
        card.setHeight(3000);
        assertEquals(3000, card.getHeight());
    }

    @Test
    public void cardTest_08() {
        card.setHeight(3001);
        assertEquals(3000, card.getHeight());
    }

}
