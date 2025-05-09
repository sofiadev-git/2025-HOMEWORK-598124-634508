package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoAiuto implements Comando {

    static final private String[] elencoComandi = {
        "vai <direzione>", "aiuto", "fine", "prendi <nome attrezzo>", "posa <nome attrezzo>", "guarda"
    };

    @Override
    public void esegui(Partita partita) {
        for (String comando : elencoComandi) {
            partita.getIO().mostraMessaggio(comando);
        }
    }

    @Override
    public void setParametro(String parametro) {
        // Non serve parametro per aiuto
    }

    @Override
    public String getNome() {
        return "aiuto";
    }
}

