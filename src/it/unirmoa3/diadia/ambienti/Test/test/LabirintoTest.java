package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.unirmoa3.diadia.ambienti.Labirinto;
import it.unirmoa3.diadia.ambienti.Stanza;

public class LabirintoTest {
    private Labirinto labirinto;

    @Before
    public void setUp() {
        labirinto = new Labirinto();
    }

    @Test
    public void testStanzaCorrenteIniziale() {
        assertEquals("Atrio", labirinto.getStanzaCorrente().getNome());
    }

    @Test
    public void testStanzaVincente() {
        assertEquals("Biblioteca", labirinto.getStanzaVincente().getNome());
    }

    @Test
    public void testCambioStanzaCorrente() {
        Stanza nuovaStanza = new Stanza("Aula Test");
        labirinto.setStanzaCorrente(nuovaStanza);
        assertEquals("Aula Test", labirinto.getStanzaCorrente().getNome());
    }
}