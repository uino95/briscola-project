import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * Created by uino on 24/03/17.
 */
public class Main {
    public static void main(String args[]) throws Exception {
        int i;
        StatoPartita statoPartita = new StatoPartita();

        int j=0;
        List<Carta> mazzettino = new ArrayList<Carta>();
        System.out.println("Briscola Project started my friend!!");

        Scanner scanner = new Scanner(System.in);
        System.out.println("inserire le carte del giocatore 1");
        String primaCarta = scanner.nextLine();
        String secondaCarta = scanner.nextLine();
        String terzaCarta = scanner.nextLine();
        for (Carta l : statoPartita.getMazzo().getCarte()) {
            System.out.println(statoPartita.getGiocatore1().getMano().size() + " " + l);
            if (l.name().equals(primaCarta)) {
                statoPartita.getGiocatore1().aggiungiCartaInMano(l);
            }
            else if (l.name().equals(secondaCarta)) {
                statoPartita.getGiocatore1().aggiungiCartaInMano(l);
            }
            else if (l.name().equals(terzaCarta)) {
                statoPartita.getGiocatore1().aggiungiCartaInMano(l);
            }
        }
        statoPartita.getMazzo().getCarte().remove(statoPartita.getGiocatore1().getMano().get(0));
        statoPartita.getMazzo().getCarte().remove(statoPartita.getGiocatore1().getMano().get(1));
        statoPartita.getMazzo().getCarte().remove(statoPartita.getGiocatore1().getMano().get(2));
        statoPartita.getGiocatore1().stampaMano();



        //pesco le tre carte del giocatore1
        //statoPartita.getGiocatore1().aggiungiCartaInMano(statoPartita.getMazzo().estrai());
        //statoPartita.getGiocatore1().aggiungiCartaInMano(statoPartita.getMazzo().estrai());
        //statoPartita.getGiocatore1().aggiungiCartaInMano(statoPartita.getMazzo().estrai());
        statoPartita.getGiocatore1().stampaMano();

        //pesco le tre carte del giocatore2
        statoPartita.getGiocatore2().aggiungiCartaInMano(statoPartita.getMazzo().estrai());
        statoPartita.getGiocatore2().aggiungiCartaInMano(statoPartita.getMazzo().estrai());
        statoPartita.getGiocatore2().aggiungiCartaInMano(statoPartita.getMazzo().estrai());
        statoPartita.getGiocatore2().stampaMano();

        System.out.println("inserire carta di briscola");
        String quartaCarta = scanner.nextLine();
        for (Carta f : statoPartita.getMazzo().getCarte()) {
            if (f.name().equals(quartaCarta)) {
                statoPartita.setBriscola(f);
            }
        }
        statoPartita.getMazzo().getCarte().remove(statoPartita.getBriscola());
        System.out.println(statoPartita.getMazzo());

        //pesco la carta di briscola
        //statoPartita.setBriscola(statoPartita.getMazzo().estrai());


        for (j = 0; j<16 ; j++){
            mazzettino.add(statoPartita.getMazzo().getCarte().get(0));
            statoPartita.getMazzo().getCarte().remove(mazzettino.get(j));
        }
        statoPartita.getGiocatore1().setMazzetto(mazzettino);
        mazzettino.clear();
        for (j = 0; j<14 ; j++){
            mazzettino.add(statoPartita.getMazzo().getCarte().get(0));
            statoPartita.getMazzo().getCarte().remove(mazzettino.get(j));
        }
        statoPartita.getGiocatore2().setMazzetto(mazzettino);

        statoPartita.setTurno(31);


        System.out.println("\ncarte nel mazzo: " + statoPartita.getMazzo().getCarte().size());

        Partita veraPartita = new Partita(statoPartita);
        i = veraPartita.scegliCarta();
        System.out.println(i);

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
