package it.uniroma3.diadia;


import java.util.Scanner;

import it.unirmoa3.diadia.ambienti.Labirinto;
import it.unirmoa3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.IOConsole.IOConsole;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
*/
public class DiaDia {
	
	public static final String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";    // l'ordine del tipo era sbagliato
	
	private static final String[] elencoComandi = {"vai", "aiuto", "fine", "prendi" , "posa"};

	private Partita partita;
	private Labirinto labirintino;
	private Giocatore steve;
	private IOConsole stampa;
	

	public DiaDia() {
		this.partita = new Partita();
		this.labirintino=this.partita.getlabirinto();
		this.steve=new Giocatore();
		this.stampa= new IOConsole();
		
	}
	public DiaDia(IOConsole stampa) {
        this.stampa = stampa;  // Assegna l'istanza di IOConsole
    }

	public void gioca() {
		String istruzione; 
		Scanner scannerDiLinee;
		stampa.mostraMessaggio(MESSAGGIO_BENVENUTO);
		scannerDiLinee = new Scanner(System.in);		
		do		{
			istruzione = scannerDiLinee.nextLine();
		}
		while (!processaIstruzione(istruzione));
		
		scannerDiLinee.close();    // !!!!!!!
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);
		
		/*aggiungi prendi e posa attrezzo con la sintassi "prendi nome_attrezzo" "posa nome_attrezzo"*/
		if (comandoDaEseguire.getNome().equals("fine")) {
			this.fine(); 
			return true;
		} 
		else if (comandoDaEseguire.getNome().equals("vai")) {
			this.vai(comandoDaEseguire.getParametro());   
		}
		else if (comandoDaEseguire.getNome().equals("aiuto"))
			this.aiuto();
		else if(comandoDaEseguire.getNome().equals("prendi"))
			
			/*rimuove dalla stanza e aggiunge nella borsa*/
			this.Prendi(comandoDaEseguire.getParametro());
		else if(comandoDaEseguire.getNome().equals("posa"))
			this.Posa(comandoDaEseguire.getParametro());
			/*rimuove dalla borsa e aggiunge nella stanza*/
			
		else
			stampa.mostraMessaggio("Comando sconosciuto");
		if (this.partita.vinta()) {
			stampa.mostraMessaggio("Hai vinto!");
			return true;
		} else
			return false;
	}   

	private void Prendi(String nomeAttrezzo) {
	    if (this.labirintino.getStanzaCorrente().hasAttrezzo(nomeAttrezzo)) {
	        Attrezzo attrezzo = this.labirintino.getStanzaCorrente().removeAttrezzo(nomeAttrezzo);
	        if(attrezzo==null) {
	        	stampa.mostraMessaggio("Errore");
	        	return;
	        }
	        if (this.steve.getBorsa().addAttrezzo(attrezzo)) {
	        	stampa.mostraMessaggio("Hai preso: " + nomeAttrezzo);
	        } else {
	            stampa.mostraMessaggio("Borsa piena! Non puoi prendere: " + nomeAttrezzo);
	            // Rimetti l'attrezzo nella stanza se la borsa è piena
	            this.labirintino.getStanzaCorrente().addAttrezzo(attrezzo);
	        }
	    } else {
	    	stampa.mostraMessaggio("Attrezzo non presente nella stanza!");
	    }
	}
	private void Posa(String nomeAttrezzo) {
	    if (this.steve.getBorsa().hasAttrezzo(nomeAttrezzo)) {
	        Attrezzo attrezzo = this.steve.getBorsa().removeAttrezzo(nomeAttrezzo);
	        if (this.labirintino.getStanzaCorrente().addAttrezzo(attrezzo)) {
	        	stampa.mostraMessaggio("Hai posato: " + nomeAttrezzo);
	        } else {
	        	stampa.mostraMessaggio("Stanza piena! Non puoi posare: " + nomeAttrezzo);
	            // Rimetti l'attrezzo nella stanza se la borsa è piena
	            this.steve.getBorsa().addAttrezzo(attrezzo);
	        }
	    } else {
	    	stampa.mostraMessaggio("Attrezzo non presente nella borsa!");
	    }
	}
	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			stampa.mostraMessaggio(elencoComandi[i]+" ");
		stampa.mostraMessaggio("");
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null) {
			stampa.mostraMessaggio("Dove vuoi andare ?");
			return; 
	}
		Stanza prossimaStanza = null;
		prossimaStanza = this.labirintino.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			stampa.mostraMessaggio("Direzione inesistente");
		else {
			this.labirintino.setStanzaCorrente(prossimaStanza);  // in Stanza.java alla riga 131 attrezzo.toString() dava errore perchè attrezzo risulta null
			int cfu = this.steve.getCfu();
			this.steve.setCFU(cfu--);
		}
		stampa.mostraMessaggio(labirintino.getStanzaCorrente().getDescrizione());
	}

	/**
	 * Comando "Fine".
	 */
	private void fine() {
		stampa.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}

	public static void main(String[] argc) {
		DiaDia gioco = new DiaDia();
		
		gioco.gioca();
		/* richiama la classe IOConsole*/
	}
}