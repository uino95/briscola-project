/**
 * Created by Martino on 24/03/2017.
 */
public enum Carta {
    ASSOORI(1, 11, Seme.ORI), DUEORI(2, 0, Seme.ORI), TREORI(3, 10, Seme.ORI), QUATTROORI(4, 0, Seme.ORI),
    CINQUEORI(5, 0, Seme.ORI), SEIORI(6,0,Seme.ORI), SETTEORI(7,0,Seme.ORI), DONNAORI(8,2,Seme.ORI),
    CAVALLOORI(9,3,Seme.ORI), REORI(10,4,Seme.ORI),
    ASSOBASTONI(1, 11, Seme.BASTONI), DUEBASTONI(2, 0, Seme.BASTONI), TREBASTONI(3, 10, Seme.BASTONI), QUATTROBASTONI(4, 0, Seme.BASTONI),
    CINQUEBASTONI(5, 0, Seme.BASTONI), SEIBASTONI(6,0,Seme.BASTONI), SETTEBASTONI(7,0,Seme.BASTONI), DONNABASTONI(8,2,Seme.BASTONI),
    CAVALLOBASTONI(9,3,Seme.BASTONI), REBASTONI(10,4,Seme.BASTONI),
    ASSOSPADE(1, 11, Seme.SPADE), DUESPADE(2, 0, Seme.SPADE), TRESPADE(3, 10, Seme.SPADE), QUATTROSPADE(4, 0, Seme.SPADE),
    CINQUESPADE(5, 0, Seme.SPADE), SEISPADE(6,0,Seme.SPADE), SETTESPADE(7,0,Seme.SPADE), DONNASPADE(8,2,Seme.SPADE),
    CAVALLOSPADE(9,3,Seme.SPADE), RESPADE(10,4,Seme.SPADE),
    ASSOCOPPE(1, 11, Seme.COPPE), DUECOPPE(2, 0, Seme.COPPE), TRECOPPE(3, 10, Seme.COPPE), QUATTROCOPPE(4, 0, Seme.COPPE),
    CINQUECOPPE(5, 0, Seme.COPPE), SEICOPPE(6,0,Seme.COPPE), SETTECOPPE(7,0,Seme.COPPE), DONNACOPPE(8,2,Seme.COPPE),
    CAVALLOCOPPE(9,3,Seme.COPPE), RECOPPE(10,4,Seme.COPPE);

    private final int numero;
    private final int valore;
    private final Seme seme;

    Carta(int numero, int valore, Seme seme) {
        this.numero = numero;
        this.valore = valore;
        this.seme = seme;
    }

    public int getValore() {
        return valore;
    }

    public int getNumero() {
        return numero;
    }

    public Seme getSeme() {
        return seme;
    }

}

