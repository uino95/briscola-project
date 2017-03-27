/**
 * Created by uino on 24/03/17.
 */
public class Partita {

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

    public Partita(Mazzo mazzo, Giocatore giocatore1, Giocatore giocatore2, Carta cartaBriscola) {
        this.mazzo = mazzo;
        this.giocatore1 = giocatore1;
        this.giocatore2 = giocatore2;
        this.cartaBriscola = cartaBriscola;
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

    //TODO guardare il metodo che mi ritorna il nome dell'istanza della classe.
    public void giocaMano() throws Exception {
        Giocatore notToccaA = notToccaA();
        int sumPunti;

        System.out.println("siamo al turno numero " + this.turno);

        Carta cartaGiocata1 = this.toccaA.giocaCarta();
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
            giocaMano();
        }
        valutaVincitore();
    }

}
