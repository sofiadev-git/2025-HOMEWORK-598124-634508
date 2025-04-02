package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import it.unirmoa3.diadia.ambienti.Labirinto;
import it.unirmoa3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.Partita;


class PartitaTest {
    private Partita partita;

    @BeforeEach
    void setUp() {
        partita = new Partita();
    }

    @Test
    void testPartitaInizialmenteNonFinita() {
        assertFalse(partita.isFinita(), "La partita appena creata non dovrebbe essere finita.");
    }

    @Test
    void testSetFinita() {
        partita.setFinita();
        assertTrue(partita.isFinita(), "Dopo aver chiamato setFinita(), la partita dovrebbe essere finita.");
    }

    @Test
    void testVintaQuandoStanzaCorrenteUgualeAStanzaVincente() {
        Labirinto labirinto = partita.getlabirinto();
        Stanza stanzaVincente = labirinto.getStanzaVincente();
        labirinto.setStanzaCorrente(stanzaVincente);
        assertTrue(partita.vinta(), "La partita dovrebbe essere vinta quando la stanza corrente è la stanza vincente.");
    }

    @Test
    void testNonVintaAllInizio() {
        assertFalse(partita.vinta(), "All'inizio la partita non dovrebbe essere vinta.");
    }

    
}

