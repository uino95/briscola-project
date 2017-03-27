import java.util.Scanner;
/**
 * Created by uino on 24/03/17.
 */
public class Main {
    public static void main(String args[]) throws Exception {
//        Giocatore meStesso = new Giocatore("meStesso");
//        Scanner in = new Scanner(System.in);
//        System.out.println("Scrivi il nome della prima carta");
//        String carta1 = in.nextLine();
//        String carta2 = in.nextLine();
//        String carta3 = in.nextLine();
//
//        meStesso.aggiungiCartaInMano(carta1);
//        meStesso.aggiungiCartaInMano(carta2);
//        meStesso.aggiungiCartaInMano(carta3);

        System.out.println("Briscola Project started my friend");

        Partita partita = new Partita();
        partita.giocaPartita();


    }

}
