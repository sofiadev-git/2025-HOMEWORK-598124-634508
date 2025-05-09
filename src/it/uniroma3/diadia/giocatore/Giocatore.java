package it.uniroma3.diadia.giocatore;

public class Giocatore {
    
    private static final int CFU_INIZIALI = 20;
    private int cfu;
    private Borsa borsa;

    public Giocatore() {
        this.cfu = CFU_INIZIALI;
        this.borsa = new Borsa();
    }

    public int getCFU() {
        return this.cfu;
    }

    public void setCFU(int cfu) {
        this.cfu = Math.max(0, cfu); // impedisce CFU negativi
    }

    public void decrementaCFU() {
        if (this.cfu > 0)
            this.cfu--;
    }

    public Borsa getBorsa() {
        return this.borsa;
    }
}