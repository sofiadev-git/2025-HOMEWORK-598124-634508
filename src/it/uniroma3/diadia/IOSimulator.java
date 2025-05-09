package it.uniroma3.diadia;

public class IOSimulator implements IO {

    private String[] righeDaLeggere;
    private String[] messaggiProdotti;
    private int indiceLettura;
    private int indiceScrittura;

    public IOSimulator(String[] righeDaLeggere) {
        this.righeDaLeggere = righeDaLeggere;
        this.messaggiProdotti = new String[100]; // puoi aumentare se servono più output
        this.indiceLettura = 0;
        this.indiceScrittura = 0;
    }

    @Override
    public void mostraMessaggio(String messaggio) {
        if (indiceScrittura < messaggiProdotti.length) {
            messaggiProdotti[indiceScrittura++] = messaggio;
        }
    }

    @Override
    public String leggiRiga() {
        if (indiceLettura < righeDaLeggere.length) {
            return righeDaLeggere[indiceLettura++];
        }
        return null;
    }

    public String[] getMessaggiProdotti() {
        return this.messaggiProdotti;
    }

    public boolean messaggioPresente(String messaggio) {
        for (int i = 0; i < indiceScrittura; i++) {
            if (messaggiProdotti[i] != null && messaggiProdotti[i].equals(messaggio)) {
                return true;
            }
        }
        return false;
    }
}
