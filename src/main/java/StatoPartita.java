import java.util.ArrayList;
import java.util.List;

/**
 * Created by Martino on 28/03/2017.
 */
public class StatoPartita {

    private Carta briscola;
    private Mazzo mazzo;
    private Giocatore giocatore1;
    private Giocatore giocatore2;
    private Giocatore toccaA;
    private int turno;
    private Fase fase;
    private List<Carta> carteSulTavolo;

    public StatoPartita() {
        this.giocatore1 = new Giocatore("giocatore1");
        this.giocatore2 = new Giocatore("giocatore2");
        this.toccaA = giocatore1;
        this.mazzo = new Mazzo();
        this.mazzo.mischiaCarte();
        this.turno = 1;
        this.fase = Fase.GIOCANDOPRIMACARTA;
        this.carteSulTavolo = new ArrayList<Carta>();
    }

    //getter and setter degli attributi
    public Carta getBriscola() {
        return briscola;
    }

    public void setBriscola(Carta briscola) {
        this.briscola = briscola;
    }

    public Mazzo getMazzo() {
        return mazzo;
    }

    public Giocatore getGiocatore1() {
        return giocatore1;
    }

    public Giocatore getGiocatore2() {
        return giocatore2;
    }

    public Giocatore getToccaA() { return toccaA; }

    public void changeToccaA(){
        if (this.toccaA.equals(this.giocatore1)){
            this.toccaA = this.giocatore2;
        }
        if (this.toccaA.equals(this.giocatore2)){
            this.toccaA = this.giocatore1;
        }
    }

    public int getTurno() { return turno; }

    public Fase getFase() {
        return fase;
    }

    public void avanzaTurno(){
        this.turno++;
    }

    public void avanzaStato(){
        if (this.fase == Fase.GIOCANDOPRIMACARTA){
            this.fase = Fase.GIOCANDOSECONDACARTA;
        }
        else if (this.fase == Fase.GIOCANDOSECONDACARTA){
            this.fase = Fase.AGGIORNANDOGIOCO;
        }
        else if (this.fase == Fase.AGGIORNANDOGIOCO){
            this.fase = Fase.GIOCANDOPRIMACARTA;
        }
    }

    public List<Carta> getCarteSulTavolo() {
        return carteSulTavolo;
    }

    public void addCartaSulTavolo(Carta carta) {
        this.carteSulTavolo.add(carta);
    }

    //fine getter and setter

    public void risolviMano() throws Exception{
        if (this.carteSulTavolo.size() != 2){
            throw new Exception();
        }
        if (this.carteSulTavolo.get(1).getSeme() == this.briscola.getSeme() && this.carteSulTavolo.get(0).getSeme() != this.briscola.getSeme()){
            this.toccaA.addMazzetto(this.carteSulTavolo.get(0), this.carteSulTavolo.get(1));
            this.carteSulTavolo.remove(0);
            this.carteSulTavolo.remove(1);
        }
    }

}