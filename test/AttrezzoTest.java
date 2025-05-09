package test;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class AttrezzoTest {
    
    private Attrezzo attrezzo;
    
    @BeforeEach
    void setUp() {
        // Preparo un attrezzo da utilizzare per i test
        attrezzo = new Attrezzo("Spada", 5);
    }
    
    @Test
    void testGetNome() {
        // Verifica che il nome dell'attrezzo sia quello che mi aspetto
        assertEquals("Spada", attrezzo.getNome());
    }

    @Test
    void testGetPeso() {
        // Verifica che il peso dell'attrezzo sia quello che mi aspetto
        assertEquals(5, attrezzo.getPeso());
    }

    @Test
    void testCreazioneAttrezzo() {
        // Verifica che l'attrezzo venga creato correttamente
        Attrezzo attrezzoTest = new Attrezzo("Pala", 3);
        assertNotNull(attrezzoTest);
        assertEquals("Pala", attrezzoTest.getNome());
        assertEquals(3, attrezzoTest.getPeso());
    }
}
