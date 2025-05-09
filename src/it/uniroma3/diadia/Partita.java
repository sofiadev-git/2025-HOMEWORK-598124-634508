package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 * gestisce lo stato della partita
 * @author  docente di POO
 * @version estesa per funzionare con ComandoVai
 */
public class Partita {
    
    private Labirinto labirintino;
    private boolean finita;
    private Giocatore steve;
    
    public Partita() {
        this.labirintino = new Labirinto();
        this.finita = false;
        this.steve = new Giocatore();
    }

    //  Metodo richiesto da ComandoVai
    public Stanza getStanzaCorrente() {
        return this.labirintino.getStanzaCorrente();
    }

    //  Metodo richiesto da ComandoVai
    public void setStanzaCorrente(Stanza stanza) {
        this.labirintino.setStanzaCorrente(stanza);
    }

    // Metodo richiesto da ComandoVai
    public Giocatore getGiocatore() {
        return this.steve;
    }

    public Labirinto getLabirinto() {
        return this.labirintino;
    }

    public boolean vinta() {
        return labirintino.getStanzaCorrente() == labirintino.getStanzaVincente();
    }

    public boolean isFinita() {
        return finita || vinta() || (steve.getCFU() == 0);
    }

    public void setFinita() {
        this.finita = true;
    }
    public boolean giocatoreIsVivo() {
        return this.getGiocatore().getCFU() > 0;
    }
    private IO io;

    public IO getIO() {
        return this.io;
    }

    public void setIO(IO io) {
        this.io = io;
    }



}
