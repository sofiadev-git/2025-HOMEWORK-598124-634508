package it.uniroma3.diadia.comandi;




import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa implements Comando{

    private String nomeAttrezzo;

    @Override
    public void esegui(Partita partita) {
            if (partita.getGiocatore().getBorsa().hasAttrezzo(nomeAttrezzo)) {
                Attrezzo attrezzo = partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
                if (partita.getLabirinto().getStanzaCorrente().addAttrezzo(attrezzo)) {
                	partita.getIO().mostraMessaggio("Hai posato: " + nomeAttrezzo);
                } else {
                	partita.getIO().mostraMessaggio("Stanza piena! Non puoi posare: " + nomeAttrezzo);
                    // Rimetti l'attrezzo nella stanza se la borsa è piena
                    partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
                }
            } else {
            	partita.getIO().mostraMessaggio("Attrezzo non presente nella borsa!");
            }
        }


    @Override
    public void setParametro(String parametro) {
        this.nomeAttrezzo = parametro;
    }

    // Getter per il nome del comando
    @Override
    public String getNome() {
        return "posa";
    }
}