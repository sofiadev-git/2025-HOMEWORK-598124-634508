package it.uniroma3.diadia;

import it.unirmoa3.diadia.ambienti.Labirinto;
import it.unirmoa3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 * gestisce lo stato della partita
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {
	private Labirinto labirintino;
	private boolean finita;
	private Giocatore steve;
	
	public Partita(){
		this.labirintino=new Labirinto();
		this.finita = false;
		this.steve=new Giocatore();
	}
	public Labirinto getlabirinto() {
		return this.labirintino;
	}
    /**
     * Crea tutte le stanze e le porte di collegamento
     */
   
	
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return labirintino.getStanzaCorrente()== labirintino.getStanzaVincente();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (steve.getCfu()==0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}

}
