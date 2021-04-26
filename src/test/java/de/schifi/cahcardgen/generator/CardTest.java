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

    // TODO: Test for card-resolution boundaries! (width and height)

}
