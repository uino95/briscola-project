import java.util.List;

/**
 * Created by Martino on 28/03/2017.
 */
public class StatoPartita {

    private Carta briscola;
    private Mazzo mazzo;
    private Giocatore giocatore1;
    private Giocatore giocatore2;
    private Fase fase;
    private List<Carta> carteSulTavolo;

    public Carta getBriscola() {
        return briscola;
    }

    public void setBriscola(Carta briscola) {
        this.briscola = briscola;
    }

    public Mazzo getMazzo() {
        return mazzo;
    }

    public void setMazzo(Mazzo mazzo) {
        this.mazzo = mazzo;
    }

    public Giocatore getGiocatore1() {
        return giocatore1;
    }

    public void setGiocatore1(Giocatore giocatore1) {
        this.giocatore1 = giocatore1;
    }

    public Giocatore getGiocatore2() {
        return giocatore2;
    }

    public void setGiocatore2(Giocatore giocatore2) {
        this.giocatore2 = giocatore2;
    }

    public Fase getFase() {
        return fase;
    }

    public void setFase(Fase fase) {
        this.fase = fase;
    }

    public List<Carta> getCarteSulTavolo() {
        return carteSulTavolo;
    }

    public void setCarteSulTavolo(List<Carta> carteSulTavolo) {
        this.carteSulTavolo = carteSulTavolo;
    }
}