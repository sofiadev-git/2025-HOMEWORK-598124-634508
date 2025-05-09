package test;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.IOSimulator;

public class AccettazioneTest {

	@Test
	public void testVittoriaConChiave() {
	    String[] comandi = {
	        "vai sud",           // vai in aulaN10 (buia)
	        "prendi chiave",     // prendi la chiave
	        "vai nord",          // torna in atrio
	        "vai est",
	        "posa chiave",       // vai in aulaN11 (bloccata)
	        "vai nord"           // sblocchi e vinci
	    };
	    IOSimulator ioSim = new IOSimulator(comandi);

	    DiaDia gioco = new DiaDia(ioSim);
	    gioco.gioca();

	    assertTrue(ioSim.messaggioPresente("Hai vinto!"));
	}

    @Test
    public void testDirezioneInesistente() {
        String[] comandi = { "vai su", "fine" };
        IOSimulator ioSim = new IOSimulator(comandi);

        DiaDia gioco = new DiaDia(ioSim);
        gioco.gioca();

        assertTrue(ioSim.messaggioPresente("Direzione inesistente"));
    }
}
