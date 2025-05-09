package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai implements Comando {

    private String direzione;

    public ComandoVai(String direzione) {
        this.direzione = direzione;
    }

    public ComandoVai() {
        // costruttore vuoto nel caso venga settato solo il parametro
    }

    @Override
    public void esegui(Partita partita) {
        Stanza stanzaCorrente = partita.getStanzaCorrente();
        Stanza prossimaStanza;

        if (direzione == null) {
            partita.getIO().mostraMessaggio("Dove vuoi andare?");
            partita.getIO().mostraMessaggio("    Devi specificare una direzione");
            return;
        }

        prossimaStanza = stanzaCorrente.getStanzaAdiacente(this.direzione);
        if (prossimaStanza == null) {
            partita.getIO().mostraMessaggio("Direzione inesistente");
            return;
        }

        partita.setStanzaCorrente(prossimaStanza);
        partita.getIO().mostraMessaggio(partita.getStanzaCorrente().getNome());
        partita.getGiocatore().setCFU(partita.getGiocatore().getCFU() - 1);
    }

    @Override
    public void setParametro(String parametro) {
        this.direzione = parametro;
    }

    @Override
    public String getNome() {
        return "vai";
    }
}
