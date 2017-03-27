import java.util.ArrayList;
import java.util.List;

/**
 * Created by Martino on 24/03/2017.
 */
public class Giocatore {

    private String nome;
    private List<Carta> mano;
    private List<Carta> mazzetto;

    Giocatore(String nome) {
        this.nome = nome;
        this.mano = new ArrayList<Carta>();
        this.mazzetto = new ArrayList<Carta>();
    }
    public List<Carta> getMano() {
        return mano;
    }

    public List<Carta> getMazzetto() {
        return mazzetto;
    }

    public String getNome(){
        return this.nome;
    }

    public void aggiungiCartaInMano(Carta carta) throws Exception{
        //int i=0;
        if (this.mano.size() >= 3){
            throw new Exception();
        }
        mano.add(carta);
        // for(Carta cartaDellaMano : this.mano);
        // return;
    }

    public Carta giocaCarta() throws Exception {
        if (this.mano.size() <= 0) {
            throw new Exception();
        }
        Carta cartaGiocata = this.mano.get(0);
        this.mano.remove(0);
        return cartaGiocata;
    }

    public Carta giocaCarta(int i){
        Carta cartaGiocata;
        cartaGiocata = this.mano.get(i);
        this.mano.remove(i);
        return cartaGiocata;
    }

    public Carta giocaCarta(Carta cartaDaGiocare){
        int i=0;
        for (Carta cartaGiocata : this.mano){
            i++;
            Carta cartaCheGioco;
            if (cartaGiocata == cartaDaGiocare){
                cartaCheGioco = cartaGiocata;
                this.mano.remove(i);
                return cartaCheGioco;
            }
        }
        System.out.println("se sei arrivato qua c'è un errore");
        return null;
    }

    public void addMazzetto(Carta carta1, Carta carta2) throws Exception{
        if (this.mazzetto.size()>=40 || this.mazzetto.size()%2 != 0){ //doppio controllo
            throw new Exception();
        }
        this.mazzetto.add(carta1);
        this.mazzetto.add(carta2);
        return;
    }

    public int getPunteggio(){
        int i=0;
        for(Carta cartaPresa:mazzetto){
            i+=cartaPresa.getValore();
        }
        return i;
    }
}
