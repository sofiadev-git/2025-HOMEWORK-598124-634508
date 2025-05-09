package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoGuarda implements Comando {

    @Override
    public void esegui(Partita partita) {
        partita.getIO().mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
        partita.getIO().mostraMessaggio("CFU rimanenti: " + partita.getGiocatore().getCFU());
        partita.getIO().mostraMessaggio(partita.getGiocatore().getBorsa().toString());
    }

    @Override
    public void setParametro(String parametro) {
        // Comando guarda non usa parametri
    }

    @Override
    public String getNome() {
        return "guarda";
    }
}
