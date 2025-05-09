package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.giocatore.Giocatore;

public class GiocatoreTest {
    private Giocatore giocatore;

    @Before
    public void setUp() {
        giocatore = new Giocatore();
    }

    @Test
    public void testCostruttore_CFUIniziali() {
        assertEquals(20, giocatore.getCFU());
    }

    @Test
    public void testSetCfu() {
        giocatore.setCFU(15);
        assertEquals(15, giocatore.getCFU());
    }

    @Test
    public void testBorsaNonNulla() {
        assertNotNull(giocatore.getBorsa());
    }
}