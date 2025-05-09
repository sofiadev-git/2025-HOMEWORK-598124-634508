package test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.ComandoPrendi;

public class ComandoPrendiTest {

    private Partita partita;
    private ComandoPrendi comando;
    private Attrezzo attrezzo;

    @Before
    public void setUp() {
        IOConsole io = new IOConsole();
        this.partita = new Partita();
        this.partita.setIO(io);
        this.comando = new ComandoPrendi();
        this.attrezzo = new Attrezzo("chiave", 1);
        partita.getStanzaCorrente().addAttrezzo(attrezzo);
    }

    @Test
    public void testPrendiAttrezzoPresente() {
        comando.setParametro("chiave");
        comando.esegui(partita);
        assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo("chiave"));
    }

    @Test
    public void testPrendiAttrezzoNonPresente() {
        comando.setParametro("martello");
        comando.esegui(partita);
        assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("martello"));
    }
}
