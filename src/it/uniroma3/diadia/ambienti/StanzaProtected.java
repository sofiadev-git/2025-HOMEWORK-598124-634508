package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaProtected {
    
    static final protected int NUMERO_MASSIMO_DIREZIONI = 4;
    static final protected int NUMERO_MASSIMO_ATTREZZI = 10;

    protected String nome;
    protected Attrezzo[] attrezzi;
    protected int numeroAttrezzi;
    protected StanzaProtected[] stanzeAdiacenti;
    protected int numeroStanzeAdiacenti;
    protected String[] direzioni;

    public StanzaProtected(String nome) {
        this.nome = nome;
        this.numeroAttrezzi = 0;
        this.numeroStanzeAdiacenti = 0;
        this.attrezzi = new Attrezzo[NUMERO_MASSIMO_ATTREZZI];
        this.direzioni = new String[NUMERO_MASSIMO_DIREZIONI];
        this.stanzeAdiacenti = new StanzaProtected[NUMERO_MASSIMO_DIREZIONI];
    }

    public void impostaStanzaAdiacente(String direzione, StanzaProtected stanza) {
        boolean aggiornato = false;
        for (int i = 0; i < this.direzioni.length; i++)
            if (direzione.equals(this.direzioni[i])) {
                this.stanzeAdiacenti[i] = stanza;
                aggiornato = true;
            }
        if (!aggiornato && this.numeroStanzeAdiacenti < NUMERO_MASSIMO_DIREZIONI) {
            this.direzioni[this.numeroStanzeAdiacenti] = direzione;
            this.stanzeAdiacenti[this.numeroStanzeAdiacenti] = stanza;
            this.numeroStanzeAdiacenti++;
        }
    }

    public StanzaProtected getStanzaAdiacente(String direzione) {
        for (int i = 0; i < this.numeroStanzeAdiacenti; i++) {
            if (this.direzioni[i].equals(direzione)) {
                return this.stanzeAdiacenti[i];
            }
        }
        return null;
    }

    public boolean addAttrezzo(Attrezzo attrezzo) {
        if (this.numeroAttrezzi < NUMERO_MASSIMO_ATTREZZI) {
            this.attrezzi[this.numeroAttrezzi++] = attrezzo;
            return true;
        }
        return false;
    }

    public String getDescrizione() {
        StringBuilder s = new StringBuilder();
        s.append(this.nome).append("\nUscite: ");
        for (int i = 0; i < this.numeroStanzeAdiacenti; i++)
            s.append(this.direzioni[i]).append(" ");
        s.append("\nAttrezzi nella stanza: ");
        for (int i = 0; i < this.numeroAttrezzi; i++)
            s.append(this.attrezzi[i].toString()).append(" ");
        return s.toString();
    }
}

