import discord.StringManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringManagerTest {
    StringManager abc;
    StringManager empty;

    @BeforeEach
    public void setUp() {
        abc = new StringManager("abc");
        empty = new StringManager("");
    }

    @Test
    public void nextTest() {
        assertFalse(abc.isOutOfRange());
        assertEquals('a', abc.next());
        assertEquals('b', abc.next());
        assertEquals('c', abc.next());
        assertEquals(0, abc.next());
        assertTrue(abc.isOutOfRange());
        assertEquals(0, empty.next());
        assertTrue(empty.isOutOfRange());
    }

    @Test
    public void peekTest() {
        assertEquals('a', abc.peek());
        assertEquals('b', abc.peekNext());
        abc.next();
        assertEquals('b', abc.peek());
        assertEquals('c', abc.peekNext());
        abc.next();
        assertEquals('c', abc.peek());
        assertEquals(0, abc.peekNext());
        abc.next();
        assertEquals(0, abc.peek());
        assertEquals(0, empty.peek());
        assertEquals(0, empty.peekNext());
    }

    @Test
    public void backTest() {
        abc.next();
        abc.back();
        assertEquals('a', abc.peek());
        abc.back();
        assertEquals('a', abc.peek());
        empty.back();
    }

}
