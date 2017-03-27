import java.util.Scanner;
/**
 * Created by uino on 24/03/17.
 */
public class Main {
    public static void main(String args[]) throws Exception {

        System.out.println("Briscola Project started my friend!!");

        Carta cartaMano1 = Carta.ASSOBASTONI;
        Carta cartaMano2 = Carta.TREBASTONI;
        Carta cartaMano3 = Carta.REBASTONI;
        Carta cartaBriscola = Carta.CAVALLOBASTONI;

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

        Partita partita = new Partita(cartaMano1, cartaMano2, cartaMano3, cartaBriscola);
        partita.vincitoreGiocandoCarta(cartaMano1);



    }

}
