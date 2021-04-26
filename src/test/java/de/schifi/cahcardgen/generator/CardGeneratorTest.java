package de.schifi.cahcardgen.generator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

public class CardGeneratorTest {

    @Rule
    public final TestRule testWatcher = new TestMessages();

    private CardGenerator cardGenerator;

    @Before
    public void prepare() {
        cardGenerator = new CardGenerator();
    }

    @Test
    public void dummyTest01() {
        assertTrue(true);
    }

    @Test
    public void dummyTest02() {
        assertFalse(false);
    }

}
