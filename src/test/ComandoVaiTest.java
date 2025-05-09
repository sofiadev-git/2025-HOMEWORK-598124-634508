package test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.*;
import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.comandi.ComandoVai;

public class ComandoVaiTest {

    private Partita partita;
    private ComandoVai comando;

    @Before
    public void setUp() {
        IO io = new IOConsole();
        this.partita = new Partita();
        this.partita.setIO(io);
        this.comando = new ComandoVai();
    }

    @Test
    public void testVaiADirezioneEsistente() {
        comando.setParametro("sud");
        Stanza destinazione = partita.getStanzaCorrente().getStanzaAdiacente("sud");
        comando.esegui(partita);
        assertEquals(destinazione, partita.getStanzaCorrente());
    }

    @Test
    public void testVaiADirezioneNonEsistente() {
        comando.setParametro("su");
        Stanza iniziale = partita.getStanzaCorrente();
        comando.esegui(partita);
        assertEquals(iniziale, partita.getStanzaCorrente());
    }
}
