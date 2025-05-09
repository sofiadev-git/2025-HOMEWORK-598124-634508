package test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.ComandoPosa;

public class ComandoPosaTest {

    private Partita partita;
    private ComandoPosa comando;
    private Attrezzo attrezzo;

    @Before
    public void setUp() {
        IOConsole io = new IOConsole();
        this.partita = new Partita();
        this.partita.setIO(io);
        this.comando = new ComandoPosa();
        this.attrezzo = new Attrezzo("mappa", 1);
        partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
    }

    @Test
    public void testPosaAttrezzoInBorsa() {
        comando.setParametro("mappa");
        comando.esegui(partita);
        assertTrue(partita.getStanzaCorrente().hasAttrezzo("mappa"));
        assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("mappa"));
    }

    @Test
    public void testPosaAttrezzoNonInBorsa() {
        comando.setParametro("lanterna");
        comando.esegui(partita);
        assertFalse(partita.getStanzaCorrente().hasAttrezzo("lanterna"));
    }
}
