package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Labirinto {
	private Stanza stanzaCorrente;
	private Stanza stanzaVincente;

	public Labirinto() {
		creaLabirinto();
	}

	private void creaLabirinto() {
		/* crea gli attrezzi */
		Attrezzo lanterna = new Attrezzo("lanterna", 3);
		Attrezzo piccone = new Attrezzo("piccone", 4);
		Attrezzo chiave = new Attrezzo("chiave", 1);
		Attrezzo libro = new Attrezzo("libro", 2);

		/* crea stanze speciali del labirinto */
		Stanza atrio = new Stanza("Atrio");
		Stanza aulaN11 = new StanzaBloccata("Aula N11", "nord", "chiave");
		Stanza aulaN10 = new StanzaBuia("Aula N10", "lanterna");
		Stanza laboratorio = new StanzaMagica("Laboratorio Campus", 1); // diventa magica dopo 1 attrezzo
		Stanza biblioteca = new Stanza("Biblioteca");

		/* collega le stanze */
		atrio.impostaStanzaAdiacente("est", aulaN11);
		atrio.impostaStanzaAdiacente("sud", aulaN10);
		atrio.impostaStanzaAdiacente("ovest", laboratorio);

		aulaN11.impostaStanzaAdiacente("ovest", atrio);
		aulaN11.impostaStanzaAdiacente("nord", biblioteca); // questa è la direzione bloccata

		aulaN10.impostaStanzaAdiacente("nord", atrio);

		laboratorio.impostaStanzaAdiacente("est", atrio);

		biblioteca.impostaStanzaAdiacente("sud", atrio);

		/* inserisce gli attrezzi nelle stanze */
		aulaN10.addAttrezzo(chiave);     // serve per vedere nell'aula buia
		aulaN11.addAttrezzo(piccone);       // serve per sbloccare aulaN11 verso nord
		laboratorio.addAttrezzo(lanterna);    // libro sarà "magicato" se aggiungi altri attrezzi
		atrio.addAttrezzo(libro);        // oggetto generico

		/* imposta l'inizio e la fine */
		stanzaCorrente = atrio;
		stanzaVincente = biblioteca;
	}

	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}

	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}

	public Stanza getStanzaVincente() {
		return stanzaVincente;
	}
}
