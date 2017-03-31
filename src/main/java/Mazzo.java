import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Martino on 24/03/2017.
 */
public class Mazzo {
    private List<Carta> carte;

    public Mazzo() {
        carte= new ArrayList<Carta>();
        for(Carta carta: Carta.values()) {
            this.carte.add(carta);
        }
    }

    public List<Carta> getCarte() {
        return carte;
    }

    public void mischiaCarte(){
        Collections.shuffle(carte);
    }

    @Override
    public String toString() {
        String stringa="";
        for(Carta carta: carte) {
            stringa+=carta.toString() + " ";
        }
        return stringa;
    }

    public Carta estrai() throws Exception{
        if(this.carte.size() == 0){
            throw new Exception();
        }
        Carta cartaPescata = this.carte.get(0);
        this.carte.remove(0);
        return cartaPescata;
    }

    public void togliCarta(Carta carta){
        carte.remove(carta);
    }
}
