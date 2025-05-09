package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza {

    private String direzioneBloccata;
    private String attrezzoSbloccante;
    public StanzaBloccata(String nome, String direzioneBloccata, String attrezzoSbloccante) {
        super(nome);
        this.direzioneBloccata = direzioneBloccata;
        this.attrezzoSbloccante = attrezzoSbloccante;
    }

    @Override
    public Stanza getStanzaAdiacente(String direzione) {
        if (direzione.equals(this.direzioneBloccata) && !this.hasAttrezzo(this.attrezzoSbloccante)) {
             return null;// direzione bloccata
              
        }
        return super.getStanzaAdiacente(direzione);
    }

    @Override
    public String getDescrizione() {
        if (!this.hasAttrezzo(this.attrezzoSbloccante)) {
            return super.getNome() + "\nDirezione bloccata: " + this.direzioneBloccata +
                   "\nPer sbloccarla serve: " + this.attrezzoSbloccante;
        }
        return super.getDescrizione();
    }
}

