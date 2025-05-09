package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.StanzaBloccata;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccataTest {

    private StanzaBloccata stanzaBloccata;
    private Stanza destinazione;

    @Before
    public void setUp() {
        stanzaBloccata = new StanzaBloccata("Atrio", "nord", "chiave");
        destinazione = new Stanza("Uscita");
        stanzaBloccata.impostaStanzaAdiacente("nord", destinazione);
    }

    @Test
    public void testGetStanzaAdiacenteDirezioneBloccataSenzaChiave() {
        assertNull(stanzaBloccata.getStanzaAdiacente("nord"));
    }

    @Test
    public void testGetStanzaAdiacenteDirezioneBloccataConChiave() {
        stanzaBloccata.addAttrezzo(new Attrezzo("chiave", 1));
        assertEquals(destinazione, stanzaBloccata.getStanzaAdiacente("nord"));
    }

    @Test
    public void testGetStanzaAdiacenteAltraDirezioneSempreAccessibile() {
        Stanza est = new Stanza("Laboratorio");
        stanzaBloccata.impostaStanzaAdiacente("est", est);
        assertEquals(est, stanzaBloccata.getStanzaAdiacente("est"));
    }

    @Test
    public void testGetDescrizioneQuandoBloccata() {
        String desc = stanzaBloccata.getDescrizione();
        assertTrue(desc.contains("bloccata"));
        assertTrue(desc.contains("nord"));
        assertTrue(desc.contains("chiave"));
    }

    @Test
    public void testGetDescrizioneQuandoSbloccata() {
        stanzaBloccata.addAttrezzo(new Attrezzo("chiave", 1));
        String desc = stanzaBloccata.getDescrizione();
        assertFalse(desc.contains("bloccata"));
    }
}
