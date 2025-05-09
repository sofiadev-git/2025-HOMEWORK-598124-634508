package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando{
    private String nomeAttrezzo;
 
        

	@Override
    public void esegui(Partita partita){
        if(partita.getLabirinto().getStanzaCorrente().hasAttrezzo(nomeAttrezzo)){
            Attrezzo attrezzo = partita.getLabirinto().getStanzaCorrente().removeAttrezzo(nomeAttrezzo);
            if(attrezzo == null){
            	partita.getIO().mostraMessaggio("Errore");
        	    return;
          	}
           	if (partita.getGiocatore().getBorsa().addAttrezzo(attrezzo)) {
           		partita.getIO().mostraMessaggio("Hai preso: " + nomeAttrezzo);
	   		}
			else {
				partita.getIO().mostraMessaggio("Borsa piena! Non puoi prendere: " + nomeAttrezzo);
	        	// Rimetti l'attrezzo nella stanza se la borsa è piena
	        	partita.getLabirinto().getStanzaCorrente().addAttrezzo(attrezzo);
	       		}
        }
		else {
			partita.getIO().mostraMessaggio("Attrezzo non presente nella stanza!");
	   	}
    }
	@Override
    public void setParametro(String parametro) {
        this.nomeAttrezzo = parametro;
    }

    // Getter per il nome del comando
    @Override
    public String getNome() {
        return "prendi";
    }

    }