/**
 * Created by uino on 24/03/17.
 */
public class Partita {

    private StatoPartita statoPartita, statoConCarta1, statoConCarta2, statoConCarta3;

    public Partita(StatoPartita ilMioStato) {
        this.statoPartita = ilMioStato;
    }

    public int scegliCarta() throws Exception {
        if (this.statoPartita.getToccaA().getMano().size() == 3) {
            int a, b, c;
            Carta d, e, f;

            System.out.println("ciao sono dentro scegliCarta nel caso 3 carte in mano");

            this.statoConCarta1 = new StatoPartita();
            this.statoConCarta2 = new StatoPartita();
            this.statoConCarta3 = new StatoPartita();

            this.statoConCarta1 = this.statoPartita.copiaStatoPartita();
            this.statoConCarta2 = this.statoPartita.copiaStatoPartita();
            this.statoConCarta3 = this.statoPartita.copiaStatoPartita();

            this.statoConCarta1.gettaCarta(0);
            d = this.statoConCarta1.getCarteSulTavolo().get(this.statoConCarta1.getCarteSulTavolo().size()-1);
            this.statoConCarta2.gettaCarta(1);
            e = this.statoConCarta2.getCarteSulTavolo().get(this.statoConCarta2.getCarteSulTavolo().size()-1);
            this.statoConCarta3.gettaCarta(2);
            f = this.statoConCarta3.getCarteSulTavolo().get(this.statoConCarta3.getCarteSulTavolo().size()-1);

            this.statoConCarta1.aggiornaStato();
            this.statoConCarta2.aggiornaStato();
            this.statoConCarta3.aggiornaStato();

            Partita partita1 = new Partita(this.statoConCarta1);
            Partita partita2 = new Partita(this.statoConCarta2);
            Partita partita3 = new Partita(this.statoConCarta3);

            a = partita1.scegliCarta();
            b = partita2.scegliCarta();
            c = partita3.scegliCarta();

            if ((a > b && a > c && this.statoPartita.getToccaA().equals(this.statoPartita.getGiocatore1())) || (a < b && a < c && this.statoPartita.getToccaA().equals(this.statoPartita.getGiocatore2()))) {
                System.out.println("turno: " + this.statoPartita.getTurno() + "carta da giocare: " + d);
                return a;
            } else if ((b > a && b > c && this.statoPartita.getToccaA().equals(this.statoPartita.getGiocatore1())) || (b < a && b < c && this.statoPartita.getToccaA().equals(this.statoPartita.getGiocatore2()))) {
                System.out.println("turno: " + this.statoPartita.getTurno() + "carta da giocare: " + e);
                return b;
            } else {
                System.out.println("turno: " + this.statoPartita.getTurno() + "carta da giocare: " + f);
                return c;
            }
        }
        else if (this.statoPartita.getToccaA().getMano().size() == 2){
            int a, b;

            System.out.println("ciao sono dentro scegliCarta nel caso 2 carte in mano");

            this.statoConCarta1 = new StatoPartita();
            this.statoConCarta2 = new StatoPartita();

            this.statoConCarta1 = this.statoPartita.copiaStatoPartita();
            this.statoConCarta2 = this.statoPartita.copiaStatoPartita();

            this.statoConCarta1.gettaCarta(1);
            this.statoConCarta2.gettaCarta(0);

            this.statoConCarta1.aggiornaStato();
            this.statoConCarta2.aggiornaStato();

            Partita partita1 = new Partita(this.statoConCarta1);
            Partita partita2 = new Partita(this.statoConCarta2);

            a = partita1.scegliCarta();
            b = partita2.scegliCarta();

            if ((a > b && this.statoPartita.getToccaA().equals(this.statoPartita.getGiocatore1())) || (a < b && this.statoPartita.getToccaA().equals(this.statoPartita.getGiocatore2()))) {
                return a;
            } else return b;
        }
        else {
            System.out.println("ciao sono dentro scegliCarta nel caso 1 carta in mano");
            this.statoPartita.gettaCarta(0);
            this.statoPartita.aggiornaStato();
            this.statoPartita.gettaCarta(0);
            this.statoPartita.aggiornaStato();
            return this.statoPartita.getGiocatore1().getPunteggio();
        }
    }
}



















    /*         avanzaStatoPartita in Partita
    public void avanzaStatoPartita{
        if (this.statoPartita.getFase() == Fase.GIOCANDOPRIMACARTA){
            this.statoPartita.setFase(Fase.GIOCANDOSECONDACARTA);
        }
        if (this.statoPartita.getFase() == Fase.GIOCANDOSECONDACARTA){
            this.statoPartita.setFase(Fase.AGGIORNANDOGIOCO);
        }
        if (this.statoPartita.getFase() == Fase.AGGIORNANDOGIOCO){
            this.statoPartita.setFase(Fase.GIOCANDOPRIMACARTA);
        }
    }



}   */






    /*
    int turno;
    private Mazzo mazzo;
    private Giocatore giocatore1, giocatore2, toccaA;
    private Carta cartaBriscola, cartaATerra;

    public Partita() {//per adesso non posso inserire io il giocatore... tutto casuale per il momento
        this.turno = 0;
        this.mazzo = new Mazzo();
        this.giocatore1 = new Giocatore("giocatore1");
        this.giocatore2 = new Giocatore("giocatore2");
        this.toccaA = giocatore1;
    }

    public Partita(Carta carta1, Carta carta2, Carta carta3, Carta cartaBriscola) throws Exception {
        this.mazzo = new Mazzo();
        this.mazzo.mischiaCarte();
        this.giocatore1 = new Giocatore("giocatore1");
        this.giocatore2 = new Giocatore("giocatore2");
        this.giocatore1.aggiungiCartaInMano(carta1);
        this.giocatore1.aggiungiCartaInMano(carta2);
        this.giocatore1.aggiungiCartaInMano(carta3);
        this.toccaA = giocatore1;
        this.cartaBriscola = cartaBriscola;
        mazzo.togliCarta(carta1);
        mazzo.togliCarta(carta2);
        mazzo.togliCarta(carta3);
        mazzo.togliCarta(cartaBriscola);
        for (int i = 0; i < 3; i++) {
            Carta cartaPescata = mazzo.estrai();
            giocatore2.aggiungiCartaInMano(cartaPescata);
            System.out.println("Il giocatore 2 ha pescato " + cartaPescata);
        }
        System.out.println("partita iniziata");
    }

    private void iniziaPartita() throws Exception {
        this.mazzo.mischiaCarte();
        for (int i = 0; i < 3; i++) {
            Carta cartaPescata = mazzo.estrai();
            giocatore1.aggiungiCartaInMano(cartaPescata);
            System.out.println("Il giocatore 1 ha pescato " + cartaPescata);
        }
        for (int i = 0; i < 3; i++) {
            Carta cartaPescata = mazzo.estrai();
            giocatore2.aggiungiCartaInMano(cartaPescata);
            System.out.println("Il giocatore 2 ha pescato " + cartaPescata);
        }
        this.cartaBriscola = this.mazzo.estrai();
        System.out.println("La briscola è " + cartaBriscola);
    }

    private Giocatore notToccaA() {
        if (toccaA.equals(giocatore1)) {
            return giocatore2;
        }
        return giocatore1;
    }

    public Carta valutaCartaVincente(Carta carta1, Carta carta2) {
        if (carta1.getSeme().toString().equals(carta2.getSeme().toString())) { //se stesso seme
            if (carta1.getValore() == 0 && carta2.getValore() == 0) {
                if (carta1.getNumero() < carta2.getNumero()) return carta2;
                else return carta1;
            } else {
                if (carta1.getValore() < carta2.getValore()) return carta2;
                else return carta1;
            }
        } else {
            if (carta1.getSeme().toString().equals(cartaBriscola.getSeme().toString())) {
                return carta1;
            }
            if (carta2.getSeme().toString().equals(cartaBriscola.getSeme().toString())) {
                return carta2;
            }
            return carta1;//seme diverso nessuna delle due briscola, vince la prima giocata

        }

    }

    public void valutaVincitore() {
        if (this.giocatore1.getPunteggio() < this.giocatore2.getPunteggio()) {
            System.out.println("Partita finita, vince il " + this.giocatore2.getNome() + " con un punteggio di " + this.giocatore2.getPunteggio() + " a " + this.giocatore1.getPunteggio());
        } else if (this.giocatore1.getPunteggio() > this.giocatore2.getPunteggio()) {
            System.out.println("Partita finita, vince il " + this.giocatore1.getNome() + " con un punteggio di " + this.giocatore1.getPunteggio() + " a " + this.giocatore2.getPunteggio());
        } else {
            System.out.println("Partita finita in parità");
        }
    }

    public Giocatore ritornaVincitore() {
        if (this.giocatore1.getPunteggio() < this.giocatore2.getPunteggio()) {
            System.out.println("Partita finita, vince il " + this.giocatore2.getNome() + " con un punteggio di " + this.giocatore2.getPunteggio() + " a " + this.giocatore1.getPunteggio());
            return giocatore2;
        } else if (this.giocatore1.getPunteggio() > this.giocatore2.getPunteggio()) {
            System.out.println("Partita finita, vince il " + this.giocatore1.getNome() + " con un punteggio di " + this.giocatore1.getPunteggio() + " a " + this.giocatore2.getPunteggio());
            return giocatore1;
        } else {
            System.out.println("Partita finita in parità");
            return null;
        }
    }



    //todo guardare il metodo che mi ritorna il nome dell'istanza della classe.
    public void giocaMano(Carta cartaDaGiocare ) throws Exception {
        Giocatore notToccaA = notToccaA();
        int sumPunti;

        System.out.println("siamo al turno numero " + this.turno);

        Carta cartaGiocata1;

        if (cartaDaGiocare == null) {

            cartaGiocata1 = this.toccaA.giocaCarta();
        }

        else{ cartaGiocata1 = cartaDaGiocare;
        this.toccaA.giocaCarta(0);
        }

        System.out.println("Il " + this.toccaA.getNome() + " ha giocato " + cartaGiocata1);
        Carta cartaGiocata2 = notToccaA.giocaCarta();
        System.out.println("Il " + notToccaA.getNome() + " ha giocato " + cartaGiocata2);
        Carta cartaVincente = valutaCartaVincente(cartaGiocata1, cartaGiocata2);
        sumPunti = cartaGiocata1.getValore() + cartaGiocata2.getValore();


        if (cartaVincente.equals(cartaGiocata1)) {
            this.toccaA.addMazzetto(cartaGiocata1, cartaGiocata2);
            System.out.println("Il " + this.toccaA.getNome() + " vince la mano, totalizzando " + sumPunti + " punti");
        } else {
            notToccaA.addMazzetto(cartaGiocata1, cartaGiocata2);
            System.out.println("Il " + notToccaA.getNome() + " vince la mano, totalizzando " + sumPunti + " punti");
            Giocatore tmp = this.toccaA;
            this.toccaA = notToccaA;
            notToccaA = tmp;
        }
        if (turno < 16) {
            Carta cartaPescata1 = this.mazzo.estrai();
            Carta cartaPescata2 = this.mazzo.estrai();
            this.toccaA.aggiungiCartaInMano(cartaPescata1);
            System.out.println("Il " + this.toccaA.getNome() + " ha pescato " + cartaPescata1);
            notToccaA.aggiungiCartaInMano(cartaPescata2);
            System.out.println("Il " + notToccaA.getNome() + " ha pescato " + cartaPescata2);
        }
        if (turno == 16) {
            Carta cartaPescata1 = this.mazzo.estrai();
            Carta cartaPescata2 = this.cartaBriscola;
            this.toccaA.aggiungiCartaInMano(cartaPescata1);
            System.out.println("Il " + this.toccaA.getNome() + " ha pescato " + cartaPescata1);
            notToccaA.aggiungiCartaInMano(cartaPescata2);
            System.out.println("Il " + notToccaA.getNome() + " ha pescato " + cartaPescata2);
        }
        this.turno++;
    }

    public void giocaPartita() throws Exception {
        iniziaPartita();
        while (this.turno < 20) {
            giocaMano(null);
        }
        valutaVincitore();
    }

    public Giocatore vincitoreGiocandoCarta(Carta cartaDaGiocare) throws Exception {//ritonra il vincitore della partita
        giocaMano(cartaDaGiocare);
        while (this.turno < 19) {
            giocaMano(null);
        }
        return ritornaVincitore();
    }
    */