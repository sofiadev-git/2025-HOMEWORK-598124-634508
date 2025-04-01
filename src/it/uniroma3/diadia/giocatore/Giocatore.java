package it.uniroma3.diadia.giocatore;

public class Giocatore {
	static final private int CFU_INIZIALI = 20;
	private int cfu;
	private Borsa lv;
	/* DEve poter prendere e posare oggetti*/
	public Giocatore() {
		this.cfu = CFU_INIZIALI;
		this.lv=new Borsa();
		
	}
	public int getCfu() {
		return this.cfu;
	}
	public void setCFU(int cfu) {
		this.cfu=cfu;
	}
	public Borsa getBorsa() {
		return this.lv;
	}
}
