package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagicaProtected extends StanzaProtected {

    private static final int SOGLIA_MAGICA_DEFAULT = 3;

    private int contatoreAttrezziPosati;
    private int sogliaMagica;

    public StanzaMagicaProtected(String nome) {
        this(nome, SOGLIA_MAGICA_DEFAULT);
    }

    public StanzaMagicaProtected(String nome, int soglia) {
        super(nome);
        this.contatoreAttrezziPosati = 0;
        this.sogliaMagica = soglia;
    }

    @Override
    public boolean addAttrezzo(Attrezzo attrezzo) {
        this.contatoreAttrezziPosati++;
        if (this.contatoreAttrezziPosati > this.sogliaMagica)
            attrezzo = this.modificaAttrezzo(attrezzo);
        if (this.numeroAttrezzi < NUMERO_MASSIMO_ATTREZZI) {
            this.attrezzi[this.numeroAttrezzi++] = attrezzo;
            return true;
        }
        return false;
    }

    private Attrezzo modificaAttrezzo(Attrezzo attrezzo) {
        String nomeInvertito = new StringBuilder(attrezzo.getNome()).reverse().toString();
        int pesoRaddoppiato = attrezzo.getPeso() * 2;
        return new Attrezzo(nomeInvertito, pesoRaddoppiato);
    }
}
