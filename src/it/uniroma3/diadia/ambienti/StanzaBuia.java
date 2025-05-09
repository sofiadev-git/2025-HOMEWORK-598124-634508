package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza {

    private String nomeAttrezzoCheIllumina;

    public StanzaBuia(String nome, String nomeAttrezzoCheIllumina) {
        super(nome);
        this.nomeAttrezzoCheIllumina = nomeAttrezzoCheIllumina;
    }

    @Override
    public String getDescrizione() {
        if (this.hasAttrezzo(this.nomeAttrezzoCheIllumina)) {
            return super.getDescrizione();
        } else {
            return "qui c'è buio pesto";
        }
    }
}

