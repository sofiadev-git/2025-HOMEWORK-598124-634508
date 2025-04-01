package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class BorsaTest {
    private Borsa borsa;
    private Attrezzo attrezzoLeggero;
    private Attrezzo attrezzoPesante;

    @Before
    public void setUp() {
        borsa = new Borsa();
        attrezzoLeggero = new Attrezzo("penna", 1);
        attrezzoPesante = new Attrezzo("pietra", 15);
    }

    @Test
    public void testCostruttore_DefaultPesoMax() {
        assertEquals(Borsa.DEFAULT_PESO_MAX_BORSA, borsa.getPesoMax());
    }

    @Test
    public void testAddAttrezzo_Successo() {
        assertTrue(borsa.addAttrezzo(attrezzoLeggero));
        assertEquals(1, borsa.getPeso());
    }

    @Test
    public void testAddAttrezzo_FallimentoSuperamentoPeso() {
        assertFalse(borsa.addAttrezzo(attrezzoPesante));
    }

    @Test
    public void testGetAttrezzo_Presente() {
        borsa.addAttrezzo(attrezzoLeggero);
        assertNotNull(borsa.getAttrezzo("penna"));
    }

    @Test
    public void testGetAttrezzo_NonPresente() {
        assertNull(borsa.getAttrezzo("spada"));
    }

    @Test
    public void testIsEmpty_BorsaVuota() {
        assertTrue(borsa.isEmpty());
    }

    @Test
    public void testIsEmpty_BorsaNonVuota() {
        borsa.addAttrezzo(attrezzoLeggero);
        assertFalse(borsa.isEmpty());
    }

    @Test
    public void testRemoveAttrezzo_Presente() {
        borsa.addAttrezzo(attrezzoLeggero);
        assertNotNull(borsa.removeAttrezzo("penna"));
        assertTrue(borsa.isEmpty());
    }

    @Test
    public void testRemoveAttrezzo_NonPresente() {
        assertNull(borsa.removeAttrezzo("spada"));
    }
}