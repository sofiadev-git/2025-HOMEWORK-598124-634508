package it.uniroma3.diadia;

import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandi;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;

/**
 * Classe principale di DiaDia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il metodo gioca().
 *
 * Questa e' la classe principale: crea e istanzia tutte le altre.
 * 
 * @author docente
 * @version base
 */
public class DiaDia {

    public static final String MESSAGGIO_BENVENUTO = "" +
        "Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
        "Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n" +
        "I locali sono popolati da strani personaggi, " +
        "alcuni amici, altri... chissa!\n" +
        "Ci sono attrezzi che potrebbero servirti nell'impresa:\n" +
        "puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
        "o regalarli se pensi che possano ingraziarti qualcuno.\n\n" +
        "Per conoscere le istruzioni usa il comando 'aiuto'.";

    private Partita partita;
    private IO stampa;

    public DiaDia() {
        this.stampa = new IOConsole();
        this.partita = new Partita();
        this.partita.setIO(this.stampa);
    }

    public DiaDia(IO stampa) {
        this.stampa = stampa;
        this.partita = new Partita();
        this.partita.setIO(this.stampa);
    }

    public void gioca() {
        String istruzione;
        this.stampa.mostraMessaggio(MESSAGGIO_BENVENUTO);
        do {
            istruzione = this.stampa.leggiRiga();
        } while (!processaIstruzione(istruzione));
    }

    private boolean processaIstruzione(String istruzione) {
        FabbricaDiComandi factory = new FabbricaDiComandiFisarmonica();
        Comando comandoDaEseguire = factory.costruisciComando(istruzione);
        comandoDaEseguire.esegui(this.partita);

        if (this.partita.vinta())
            this.stampa.mostraMessaggio("Hai vinto!");

        if (!this.partita.giocatoreIsVivo())
            this.stampa.mostraMessaggio("Hai esaurito i CFU...");

        return this.partita.isFinita();
    }

    public static void main(String[] argc) {
        IO io = new IOConsole();
        DiaDia gioco = new DiaDia(io);
        gioco.gioca();
    }
}
