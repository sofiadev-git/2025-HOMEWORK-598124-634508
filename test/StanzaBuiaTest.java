package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.StanzaBuia;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuiaTest {

    private StanzaBuia stanzaBuia;

    @Before
    public void setUp() {
        stanzaBuia = new StanzaBuia("Corridoio", "lanterna");
    }

    @Test
    public void testDescrizioneConLanterna() {
        stanzaBuia.addAttrezzo(new Attrezzo("lanterna", 1));
        assertFalse(stanzaBuia.getDescrizione().contains("buio pesto"));
    }

    @Test
    public void testDescrizioneSenzaLanterna() {
        assertEquals("qui c'è buio pesto", stanzaBuia.getDescrizione());
    }

    @Test
    public void testDescrizioneConAttrezzoDiverso() {
        stanzaBuia.addAttrezzo(new Attrezzo("osso", 1));
        assertEquals("qui c'è buio pesto", stanzaBuia.getDescrizione());
    }
}
