package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoNonValido implements Comando {

    @Override
    public void esegui(Partita partita) {
        partita.getIO().mostraMessaggio("Comando sconosciuto");
    }

    @Override
    public void setParametro(String parametro) {
        // Non serve parametro per comando non valido
    }

    @Override
    public String getNome() {
        return "non valido";
    }
}
