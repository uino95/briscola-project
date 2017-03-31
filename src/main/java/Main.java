import java.util.Scanner;
/**
 * Created by uino on 24/03/17.
 */
public class Main {
    public static void main(String args[]) throws Exception {

        System.out.println("Briscola Project started my friend!!");

        StatoPartita statoPartita = new StatoPartita();

        //pesco le tre carte del giocatore1
        statoPartita.getGiocatore1().aggiungiCartaInMano(statoPartita.getMazzo().estrai());
        statoPartita.getGiocatore1().aggiungiCartaInMano(statoPartita.getMazzo().estrai());
        statoPartita.getGiocatore1().aggiungiCartaInMano(statoPartita.getMazzo().estrai());
        statoPartita.getGiocatore1().stampaMano();

        //pesco le tre carte del giocatore2
        statoPartita.getGiocatore2().aggiungiCartaInMano(statoPartita.getMazzo().estrai());
        statoPartita.getGiocatore2().aggiungiCartaInMano(statoPartita.getMazzo().estrai());
        statoPartita.getGiocatore2().aggiungiCartaInMano(statoPartita.getMazzo().estrai());
        statoPartita.getGiocatore2().stampaMano();

        //pesco la carta di briscola
        statoPartita.setBriscola(statoPartita.getMazzo().estrai());

        System.out.println("\ncarte nel mazzo: " + statoPartita.getMazzo().getCarte().size());

        Partita veraPartita = new Partita(statoPartita);
        veraPartita.scegliCarta();

/*        new Thread(new Runnable() {
            public void run() {
                int numPartite = 0;
                while (numPartite<100) {
                    Partita partita1 = new Partita((cartaMano1, cartaMano2, cartaMano3, cartaBriscola));
                    partita1.vincitoreGiocandoCarta(cartaMano1);
                    numPartite++;
                }
            }
        })*/

    }

}
