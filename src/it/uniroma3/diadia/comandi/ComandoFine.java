package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoFine implements Comando {

    @Override
    public void esegui(Partita partita) {
        partita.getIO().mostraMessaggio("Grazie di aver giocato!");
        partita.setFinita();
    }

    @Override
    public void setParametro(String parametro) {
        // Il comando fine non richiede parametri
    }

    @Override
    public String getNome() {
        return "fine";
    }
}
