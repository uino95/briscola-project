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
    private Giocatore notToccaA;
    private int turno;
    private Fase fase;
    private List<Carta> carteSulTavolo;

    public StatoPartita() {
        this.giocatore1 = new Giocatore("giocatore1");
        this.giocatore2 = new Giocatore("giocatore2");
        this.toccaA = giocatore1;
        this.notToccaA = giocatore2;
        this.mazzo = new Mazzo();
        this.mazzo.mischiaCarte();
        this.turno = 1;
        this.fase = Fase.GIOCANDOPRIMACARTA;
        this.carteSulTavolo = new ArrayList<Carta>();
    }

    public StatoPartita copiaStatoPartita() throws Exception{
        StatoPartita statoParitaClonata = new StatoPartita();
        statoParitaClonata.giocatore1 = new Giocatore("giocatore1");
        statoParitaClonata.giocatore2 = new Giocatore("giocatore2");
        statoParitaClonata.giocatore1 = this.giocatore1.copiaGiocatore();
        statoParitaClonata.giocatore2 = this.giocatore2.copiaGiocatore();
        if(this.toccaA.getNome() == "giocatore1"){
            statoParitaClonata.toccaA = statoParitaClonata.giocatore1;
            statoParitaClonata.notToccaA = statoParitaClonata.giocatore2;
        }
        else {
            statoParitaClonata.toccaA = statoParitaClonata.giocatore2;
            statoParitaClonata.notToccaA = statoParitaClonata.giocatore1;
        }
        statoParitaClonata.mazzo = new Mazzo();
        statoParitaClonata.mazzo.getCarte().clear();
        for (Carta k : this.mazzo.getCarte()) {
            statoParitaClonata.mazzo.getCarte().add(k);
        }
        statoParitaClonata.turno = this.getTurno();
        statoParitaClonata.fase = this.getFase();
        statoParitaClonata.carteSulTavolo = new ArrayList<Carta>();
        for (Carta i : this.carteSulTavolo){
            statoParitaClonata.carteSulTavolo.add(i);
        }
        statoParitaClonata.briscola = this.briscola;
        return statoParitaClonata;
    }

    @Override
    protected StatoPartita clone(){
        StatoPartita statoPartitaClone = this;
        return statoPartitaClone;
    }

    public void setBriscola(Carta briscola) {
        this.briscola = briscola;
    }

    public Carta getBriscola() {
        return briscola;
    }

    public Mazzo getMazzo() {
        return this.mazzo;
    }

    public Giocatore getGiocatore1() {
        return this.giocatore1;
    }

    public Giocatore getGiocatore2() {
        return this.giocatore2;
    }

    public Giocatore getToccaA() { return this.toccaA; }

    public void changeToccaA() throws Exception{
        if (this.toccaA.equals(this.giocatore1) && this.notToccaA.equals(this.giocatore2)){
            System.out.println("ora tocca al giocatore 2");
            this.toccaA = this.giocatore2;
            this.notToccaA = this.giocatore1;
        }
        else if (this.toccaA.equals(this.giocatore2) && this.notToccaA.equals(this.giocatore1)){
            System.out.println("ora tocca al giocatore 1");
            this.toccaA = this.giocatore1;
            this.notToccaA = this.giocatore2;
        }
        else throw new Exception();
    }

    public Giocatore getNotToccaA() {
        return this.notToccaA;
    }

    public int getTurno() { return this.turno; }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public Fase getFase() {
        return this.fase;
    }

    public void avanzaTurno(){
        this.turno++;
    }

    public void avanzaStato(){
        if (this.fase == Fase.GIOCANDOPRIMACARTA){
            this.fase = Fase.GIOCANDOSECONDACARTA;
        }
        else if (this.fase == Fase.GIOCANDOSECONDACARTA){
            this.fase = Fase.GIOCANDOPRIMACARTA;
        }
    }

    public List<Carta> getCarteSulTavolo() {
        return this.carteSulTavolo;
    }


    public void risolviMano() throws Exception{
        if (this.carteSulTavolo.size() != 2){
            System.out.println(this.carteSulTavolo.size());
            throw new Exception();
        }
        if ((this.carteSulTavolo.get(1).getSeme() == this.briscola.getSeme() && this.carteSulTavolo.get(0).getSeme() != this.briscola.getSeme())
            || (this.carteSulTavolo.get(1).getSeme() == this.carteSulTavolo.get(0).getSeme() && this.carteSulTavolo.get(1).getNumero() > this.carteSulTavolo.get(1).getNumero())){
            this.toccaA.addMazzetto(this.carteSulTavolo.get(0), this.carteSulTavolo.get(1));
            this.carteSulTavolo.remove(1);
            this.carteSulTavolo.remove(0);
        }
        else {
            this.changeToccaA();
            this.toccaA.addMazzetto(this.carteSulTavolo.get(0), this.carteSulTavolo.get(1));
            this.carteSulTavolo.remove(1);
            this.carteSulTavolo.remove(0);
        }
    }

    public void gettaCarta(int i) throws Exception{
        this.carteSulTavolo.add(this.toccaA.giocaCarta(i));
    }

    public void pescaCarte() throws Exception{
        this.toccaA.aggiungiCartaInMano(mazzo.estrai());
        if (this.turno == 34){
            this.notToccaA.aggiungiCartaInMano(this.briscola);
            System.out.println("stai pescando la briscola");
        }
        else this.notToccaA.aggiungiCartaInMano(mazzo.estrai());
    }

    public void aggiornaStato() throws Exception{
        if (this.turno%2 == 1 && this.fase == Fase.GIOCANDOPRIMACARTA){
            this.changeToccaA();
            this.avanzaTurno();
            this.avanzaStato();
        }
        else if (this.turno%2 == 0 && this.fase == Fase.GIOCANDOSECONDACARTA){
            this.risolviMano();
            if (this.turno == 40){
                return ;
            }
            if (this.turno < 36) {
                this.pescaCarte();
                //System.out.println(this.giocatore1.getMano().size() + " " + this.giocatore2.getMano().size() + " " + this.toccaA.getMano().size() + " " + this.notToccaA.getMano().size());
            }
            this.avanzaTurno();
            System.out.println("Nuovo turno= " + this.turno);
            this.avanzaStato();
        }
    }

    public void risolviPartita(){

    }

}