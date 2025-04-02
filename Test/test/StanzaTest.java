package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.unirmoa3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaTest {
    private Stanza stanza;
    private Attrezzo attrezzo;

    @BeforeEach
    void setUp() {
        stanza = new Stanza("Biblioteca");
        attrezzo = new Attrezzo("Libro", 2);
    }

    @Test
    void testAddAttrezzo() {
        assertTrue(stanza.addAttrezzo(attrezzo), "L'attrezzo dovrebbe essere aggiunto correttamente");
        assertEquals(attrezzo, stanza.getAttrezzo("Libro"), "L'attrezzo aggiunto dovrebbe essere recuperabile");
    }

    @Test
    void testGetAttrezzoEsistente() {
        stanza.addAttrezzo(attrezzo);
        assertNotNull(stanza.getAttrezzo("Libro"), "L'attrezzo dovrebbe essere presente nella stanza");
    }

    @Test
    void testGetAttrezzoNonEsistente() {
        assertNull(stanza.getAttrezzo("Lampada"), "Un attrezzo non presente dovrebbe restituire null");
    }

    @Test
    void testGetAttrezzoDopoAggiuntaMultipla() {
        Attrezzo altroAttrezzo = new Attrezzo("Mappa", 1);
        stanza.addAttrezzo(attrezzo);
        stanza.addAttrezzo(altroAttrezzo);
        assertEquals(attrezzo, stanza.getAttrezzo("Libro"), "Dovrebbe trovare il primo attrezzo aggiunto");
        assertEquals(altroAttrezzo, stanza.getAttrezzo("Mappa"), "Dovrebbe trovare il secondo attrezzo aggiunto");
    }
}
